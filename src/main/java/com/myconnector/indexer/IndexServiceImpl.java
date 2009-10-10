package com.myconnector.indexer;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Logger;

import com.myconnector.dao.BookmarkDAO;
import com.myconnector.dao.PageCacheDAO;
import com.myconnector.dao.PageIndexDAO;
import com.myconnector.dao.PageListDAO;
import com.myconnector.domain.Bookmark;
import com.myconnector.domain.PageCache;
import com.myconnector.domain.PageIndex;
import com.myconnector.domain.PageIndexPK;
import com.myconnector.domain.PageList;

/**
 * TODO This class would probably better as a stored procedure
 * 
 * @author Nilesh Kapadia (nileshka@gmail.com)
 */
public class IndexServiceImpl implements IndexService {

    Logger logger = Logger.getLogger(IndexServiceImpl.class);

    private PageListDAO pageListDAO;
    private PageIndexDAO pageIndexDAO;
    private PageCacheDAO pageCacheDAO;
    private BookmarkDAO bookmarkDAO;
    private PageParser pageParser;
    private Boolean allowFullIndexDeletion = Boolean.FALSE;

    public void setAllowFullIndexDeletion(Boolean allowFullIndexDeletion) {
        this.allowFullIndexDeletion = allowFullIndexDeletion;
    }

    public void setPageParser(PageParser pageParser) {
        this.pageParser = pageParser;
    }

    public void setBookmarkDAO(BookmarkDAO bookmarkDAO) {
        this.bookmarkDAO = bookmarkDAO;
    }

    public void setPageIndexDAO(PageIndexDAO pageIndexDAO) {
        this.pageIndexDAO = pageIndexDAO;
    }

    public void setPageCacheDAO(PageCacheDAO pageCacheDAO) {
        this.pageCacheDAO = pageCacheDAO;
    }

    public void setPageListDAO(PageListDAO pageListDAO) {
        this.pageListDAO = pageListDAO;
    }

    public IndexResults generateIndex() {
        // TODO time this transaction.
        IndexResults results = new IndexResults();
        logger.info("Starting generate index.");

        logger.info("- Deleting all page tables.");
        deleteAll();
        logger.info("- Generating new index.");
        updateList(false, false, results, null);
        updateIndex(results);
        logger.info("Finished generate index.  Commiting");
        return results;
    }

    public IndexResults generateIndexFromCache() {
        IndexResults results = new IndexResults();
        logger.info("Starting generate index from cache.");
        logger.info("- Deleting page index table.");
        pageIndexDAO.deleteAll();
        logger.info("- Generating new index from cache.");
        updateIndexFromCache(false, results);
        logger
                .info("Finished generating new index from cache (may take a few minutes for transaction to finish committing).");
        return results;
    }

    public IndexResults generateIndexIncremental() {
        IndexResults results = new IndexResults();
        logger.info("Starting generate index incremental.");
        logger.info("- Updating URL list and indexing new pages");
        updateList(true, true, results, null);
        logger.info("Finished generate index incremental.");
        return results;
    }

    public IndexResults generateIndexIncrementalWithLimit(Integer limit) {
        IndexResults results = new IndexResults();
        logger.info("Starting generate index.");
        logger.info("- Updating URL list and indexing new pages");
        updateList(true, true, results, limit);
        return results;
    }

    public IndexResults generateIndexIncrementalNewIndex() {
        IndexResults results = new IndexResults();
        logger.info("Starting generate index.");
        logger.info("- Deleting page index table.");
        pageIndexDAO.deleteAll();
        logger.info("- Updating URL list.");
        updateList(true, false, results, null);
        logger.info("- Generating new index from cache.");
        updateIndexFromCache(true, results);
        return results;
    }

    private void deleteAll() {
        if (allowFullIndexDeletion.booleanValue()) {
            pageCacheDAO.deleteAll();
            pageIndexDAO.deleteAll();
            pageListDAO.deleteAll();
        } else {
            throw new RuntimeException("Deleting entire index is disable");
        }

    }

    private int updateList(boolean checkForExistingUrl, boolean indexNow, IndexResults results,
            Integer limit) {
        Map<String, String> map = new HashMap<String, String>();
        // List<String> list = bookmarkDAO.getUrlList();
        List<Bookmark> list = bookmarkDAO.getBookmarkList();
        for (Bookmark bookmark : list) {
            map.put(bookmark.getUrl(), bookmark.getTitle());
        }

        int count = 0;
        for (Entry<String, String> entry : map.entrySet()) {
            boolean saveUrl = true;
            if (checkForExistingUrl) {
                if (pageListDAO.checkUrl(entry.getKey())) {
                    saveUrl = false;
                }
            }
            if (saveUrl) {
                PageList page = new PageList(null, entry.getKey());
                page.setTitle(entry.getValue());
                pageListDAO.save(page);
                count++;
                if (logger.isDebugEnabled()) {
                    logger.debug("Page ID: " + page.getId());
                }
                if (indexNow) {
                    indexPage(page, results);
                }
                if (limit != null) {
                    if (count > limit.intValue()) {
                        break;
                    }
                }
            }
        }
        return count;
    }

    private void updateIndex(IndexResults results) {
        List<PageList> list = pageListDAO.getList();
        for (PageList page : list) {
            PageCache cache = new PageCache();
            Map<String, Integer> map;
            try {
                map = pageParser.getWordMapForUrl(page.getUrl(), cache);
                cache.setId(page.getId());
                cache.setTimeLoaded(new Date());
                page.addPageCache(cache);
                pageCacheDAO.save(cache);
                for (Entry<String, Integer> entry : map.entrySet()) {
                    PageIndex pageIndex = new PageIndex();
                    pageIndex.setCompId(new PageIndexPK(page, entry.getKey()));
                    pageIndex.setOccurances(entry.getValue());
                    pageIndexDAO.save(pageIndex);
                }
                results.addSuccess(page.getUrl());
            } catch (MalformedURLException e) {
                results.addError(page.getUrl(), IndexResults.MALFORMED_URL);
            } catch (IOException e) {
                results.addError(page.getUrl(), IndexResults.IO_EXCEPTION);
            }
        }
    }

    /**
     * Update index using existing cache and get page if it doesn't exist
     */
    private void updateIndexFromCache(boolean fetchUncached, IndexResults results) {
        List<PageList> list = pageListDAO.getList();
        for (PageList page : list) {
            indexPage(fetchUncached, page, results);
        }
    }

    private void indexPage(PageList page, IndexResults results) {
        indexPage(true, page, results);
    }

    private void indexPage(boolean fetchUncached, PageList page, IndexResults results) {
        Map<String, Integer> map = null;
        if (page != null) {
            logger.info("Indexing page: " + page.getUrl());
        }
        if (fetchUncached && page.getPageCache() == null) {
            PageCache cache = new PageCache();
            try {
                map = pageParser.getWordMapForUrl(page.getUrl(), cache);
                cache.setId(page.getId());
                cache.setTimeLoaded(new Date());
                page.addPageCache(cache);
                pageCacheDAO.save(cache);
                results.addSuccess(page.getUrl());
            } catch (MalformedURLException e) {
                results.addError(page.getUrl(), IndexResults.MALFORMED_URL);
            } catch (IOException e) {
                results.addError(page.getUrl(), IndexResults.IO_EXCEPTION);
            }
        } else {
            if (page != null && page.getPageCache() != null) {
                map = pageParser.getWordMapForString(page.getPageCache().getPageText());
            }
        }
        if (map != null) {
            for (Entry<String, Integer> entry : map.entrySet()) {
                if (entry.getKey().length() < 255) {
                    PageIndex pageIndex = new PageIndex();
                    pageIndex.setCompId(new PageIndexPK(page, entry.getKey()));
                    pageIndex.setOccurances(entry.getValue());
                    pageIndexDAO.save(pageIndex);
                }
            }
        }
    }

    public int updatePageList() {
        IndexResults results = new IndexResults();
        return updateList(true, false, results, null);
    }

    public List<PageList> getPageList() {
        return pageListDAO.getList();
    }

    public boolean cachePageById(Integer id) throws MalformedURLException, IOException {
        PageList page = pageListDAO.load(id);
        if (page.getPageCache() == null && page.getCacheFailed() == null) {
            PageCache cache = new PageCache();
            Map<String, Integer> map;
            logger.info("Attempting to cache: " + page.getUrl());
            pageParser.loadPageIntoCache(page.getUrl(), cache);
            cache.setId(page.getId());
            cache.setTimeLoaded(new Date());
            page.addPageCache(cache);
            pageCacheDAO.save(cache);
            return true;
        }
        return false;
    }
    
    public void cacheFailedById(Integer pageListId) {
        PageList page = pageListDAO.load(pageListId);
        if(page.getCacheFailed() == null) {
            page.setCacheFailed(new Integer(1));
        } else {
            int cacheFailed = page.getCacheFailed().intValue();
            cacheFailed++;
            page.setCacheFailed(new Integer(cacheFailed));
        }
        pageListDAO.update(page); // TODO do we need this?
    }

    public boolean cacheSinglePage() throws MalformedURLException, IOException {
        // TODO do query that only gets single entry
        List<PageList> list = pageListDAO.getList();
        for (PageList page : list) {
            if (page.getPageCache() == null) {
                PageCache cache = new PageCache();
                Map<String, Integer> map;
                logger.info("Attempting to cache: " + page.getUrl());
                pageParser.loadPageIntoCache(page.getUrl(), cache);
                cache.setId(page.getId());
                cache.setTimeLoaded(new Date());
                page.addPageCache(cache);
                pageCacheDAO.save(cache);
                return true;
            }
        }
        return false;
    }

    public void copyTitlesToPageList() {
        List<PageList> list = pageListDAO.getList();
        for (PageList page : list) {
            List<Bookmark> bookmarkList = bookmarkDAO.getBookmarkListForURL(page.getUrl());
            if (bookmarkList != null && bookmarkList.size() > 0) {
                Bookmark bookmark = bookmarkList.get(0);
                if (bookmark != null) {
                    page.setTitle(bookmark.getTitle());
                    // pageListDAO.save(page);
                }
            }
        }
    }
}

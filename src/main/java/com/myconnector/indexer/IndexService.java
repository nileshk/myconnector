package com.myconnector.indexer;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import com.myconnector.domain.PageList;

public interface IndexService {

    /**
     * Deletes all page tables and regenerates index
     */
    public IndexResults generateIndex();

    /**
     * Generate index from existing cache, fetching and caching pages that
     * aren't cached. Doesn't check for new URL's.
     */
    public IndexResults generateIndexFromCache();

    /**
     * Index any new URL's added in bookmarks.
     */
    public IndexResults generateIndexIncremental();

    /**
     * Index any new URL's added in bookmarks.
     */
    public IndexResults generateIndexIncrementalWithLimit(Integer limit);    
    
    /**
     * Generate completely new index from existing cache, fetching and caching pages that
     * aren't cached. Checks for, caches and indexes new URL's.  This erases all of page_index table.
     */
    public IndexResults generateIndexIncrementalNewIndex();

    // TODO add method to index new pages
    
    /**
     * Update only the PAGE_LIST table
     */
    public int updatePageList();    
    
    public List<PageList> getPageList();
    
    /**
     * Fetch and cache page if it's not already cached
     * @param id
     * @return true if page was fetched and cached, false if not (if it was already cached)
     * @throws MalformedURLException
     * @throws IOException
     */
    public boolean cachePageById(Integer pageListId) throws MalformedURLException, IOException;
            
    /**
     * Increment cache attempt failure for page
     * @param pageListId
     * @return
     */
    public void cacheFailedById(Integer pageListId);
    
    /**
     * TODO: Might delete this unused method
     * Fetch and cache a single uncached page
     * @return true if page was cached, false if not
     * @throws MalformedURLException
     * @throws IOException
     */
    public boolean cacheSinglePage() throws MalformedURLException, IOException;
    
    public void copyTitlesToPageList();
}

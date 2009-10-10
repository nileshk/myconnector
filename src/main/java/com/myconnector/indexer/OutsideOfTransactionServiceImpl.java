package com.myconnector.indexer;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

import com.myconnector.domain.PageList;

public class OutsideOfTransactionServiceImpl implements OutsideOfTransactionService {

    Logger logger = Logger.getLogger(OutsideOfTransactionServiceImpl.class);
    
    private IndexService indexService;

    public void setIndexService(IndexService indexService) {
        this.indexService = indexService;
    }

    public IndexResults fetchUncachedPages() {
        IndexResults results = new IndexResults();
        logger.debug("Updating page list...");
        indexService.updatePageList();
        logger.debug("Getting page list...");
        List<PageList> list = indexService.getPageList();
        logger.debug("Starting fetching/caching...");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            PageList page = (PageList) it.next();            
            try {
                indexService.cachePageById(page.getId());
            } catch (MalformedURLException e) {
                results.addError(page.getUrl(), IndexResults.MALFORMED_URL);
                indexService.cacheFailedById(page.getId());
            } catch (IOException e) {
                results.addError(page.getUrl(), IndexResults.IO_EXCEPTION);
                indexService.cacheFailedById(page.getId());
            }
            it.remove();
        }
        logger.debug("Finished caching... Regenerating index from cached pages");
        indexService.generateIndexFromCache();
        
        return results;
    }

}

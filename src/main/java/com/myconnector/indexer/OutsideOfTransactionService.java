package com.myconnector.indexer;

public interface OutsideOfTransactionService {

    public IndexResults fetchUncachedPages();
    
    // TODO fetch expired cached pages
    
}

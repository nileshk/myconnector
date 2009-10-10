package com.myconnector.indexer;

import java.util.List;

import com.myconnector.domain.PageIndex;

public interface SearchService {

    public List<PageIndex> search(String query);
    
    public List<PageIndex> searchByUser(String query, String uid);
    
    public List<PageIndex> searchByUserAndFriends(String query, String uid);
    
}

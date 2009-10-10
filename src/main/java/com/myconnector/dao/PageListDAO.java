package com.myconnector.dao;

import java.util.List;

import com.myconnector.domain.PageList;

public interface PageListDAO extends AbstractDAO<PageList, Integer> {

    /**
     * Check if URL is already in page list
     * @param url
     * @return true if it already exists, false if not
     */
    public boolean checkUrl(String url);
    
    public List<PageList> search(String word);
    
    public List<PageList> searchByUser(String word, String uid);
    
    public List<PageList> searchOr(String[] words);
    
    public List<PageList> searchOrByUser(String[] words, String uid);
    
    public List<PageList> searchAnd(String[] words);
    
    public List<PageList> searchAndByUser(String[] words, String uid);	
	    
}

package com.myconnector.dao;

import java.util.List;

import com.myconnector.domain.PageIndex;
import com.myconnector.domain.PageIndexPK;

public interface PageIndexDAO extends AbstractDAO<PageIndex, PageIndexPK> {

    public List<PageIndex> search(String word);
    
    public List<PageIndex> searchByUser(String word, String uid);
    
    public List<PageIndex> searchOr(String[] words);
    
    public List<PageIndex> searchOrByUser(String[] words, String uid);
    
    public List<PageIndex> searchAnd(String[] words);
    
    public List<PageIndex> searchAndByUser(String[] words, String uid);
    
    public List<PageIndex> searchByUsers(String word, List<String> uids);
    
    public List<PageIndex> searchOrByUsers(String[] words, List<String> uids);
    
    public List<PageIndex> searchAndByUsers(String[] words, List<String> uids);    
       
}

package com.myconnector.dao;

import java.util.List;

import com.myconnector.domain.Dictionary;

/**
 * DAO for DICTIONARY table
 * 
 * @author Nilesh Kapadia (nileshka@gmail.com)
 */
public interface DictionaryDAO {

    public Dictionary load(String word);
    
    public void update(Dictionary dictionary);

    public void save(Dictionary dictionary);

    public void delete(Dictionary dictionary);
    
    public void deleteById(String id);

    public List getList();    
    
}
package com.myconnector.service;

import com.myconnector.domain.Dictionary;

/**
 * 
 * @author Nilesh Kapadia (nileshka@gmail.com)
 */
public interface DictionaryService extends OldGenericExtraService {

    public void delete(Dictionary dictionary);

    public Dictionary getDictionaryById(String id);

    public void save(Dictionary dictionary);

//    public void saveOrUpdate(Dictionary dictionary);

    public void update(Dictionary dictionary);
}
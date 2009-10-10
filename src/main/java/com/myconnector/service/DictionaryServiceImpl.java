package com.myconnector.service;

import java.util.List;

import com.myconnector.dao.DictionaryDAO;
import com.myconnector.domain.Dictionary;

/**
 * 
 * @author Nilesh Kapadia (nileshka@gmail.com)
 */
public class DictionaryServiceImpl implements DictionaryService {

    DictionaryDAO dictionaryDAO;

    public void setDictionaryDAO(DictionaryDAO dictionaryDAO) {
        this.dictionaryDAO = dictionaryDAO;
    }

    public void delete(Dictionary dictionary) {
        dictionaryDAO.delete(dictionary);
    }

    public Dictionary getDictionaryById(String id) {
        return dictionaryDAO.load(id);
    }

    public void save(Dictionary dictionary) {
        dictionaryDAO.save(dictionary);
    }

//    public void saveOrUpdate(Dictionary dictionary) {
//        dictionaryDAO.saveOrUpdate(dictionary);
//    }

    public void update(Dictionary dictionary) {
        dictionaryDAO.update(dictionary);
    }

    public void deleteById(String id) {
        dictionaryDAO.deleteById(id);
    }

    public List getList() {
        return dictionaryDAO.getList();
    }

    public Object getById(String id) {
        return getDictionaryById(id);
    }

    public void save(Object obj) {
        save((Dictionary) obj);
    }

    public void update(Object obj) {
        update((Dictionary) obj);
    }

}
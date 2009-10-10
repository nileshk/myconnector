package com.myconnector.dao.hibernate;

import org.apache.log4j.Logger;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.myconnector.dao.DictionaryDAO;
import com.myconnector.domain.Dictionary;

import java.util.List;

public class DictionaryDAOImpl extends HibernateDaoSupport implements DictionaryDAO {

    static Logger logger = Logger.getLogger(DictionaryDAOImpl.class);

    public DictionaryDAOImpl() {
    }

    public Dictionary load(String id) {
        return (Dictionary) getHibernateTemplate().load(Dictionary.class, id);
    }

    public void update(Dictionary dictionary) {
        getHibernateTemplate().update(dictionary);
    }

    public void save(Dictionary dictionary) {
        getHibernateTemplate().save(dictionary);
    }

    public void delete(Dictionary dictionary) {
        getHibernateTemplate().delete(dictionary);
    }

    public List getList() {
        return (getHibernateTemplate()
                .find("from com.myconnector.domain.Dictionary x"));
    }

    public void deleteById(String word) {
    	Object obj = load(word);
        getHibernateTemplate().delete(obj);
    }
}
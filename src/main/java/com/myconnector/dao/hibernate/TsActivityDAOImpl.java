package com.myconnector.dao.hibernate;

import java.util.List;

import org.hibernate.Hibernate;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.myconnector.dao.TsActivityDAO;
import com.myconnector.domain.TsActivity;

/**
 * 
 * @author Nilesh Kapadia (nileshka@gmail.com)
 */
public class TsActivityDAOImpl extends HibernateDaoSupport implements TsActivityDAO {

    public TsActivity load(String id) {
        return (TsActivity) getHibernateTemplate().load(TsActivity.class, id);
    }

    public void update(TsActivity activity) {
        getHibernateTemplate().update(activity);
    }

    public void save(TsActivity activity) {
        getHibernateTemplate().save(activity);
    }

    public void delete(TsActivity activity) {
        getHibernateTemplate().delete(activity);
    }

    public void deleteById(String id) {
    	Object obj = load(id);
        getHibernateTemplate().delete(obj);
    }

    public List getList() {
        return (getHibernateTemplate().find("from com.myconnector.domain.TsActivity x"));
    }

}
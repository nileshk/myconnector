package com.myconnector.dao.hibernate;

import java.util.List;

import org.hibernate.Hibernate;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.myconnector.dao.TsCustomerDAO;
import com.myconnector.domain.TsCustomer;

/**
 * 
 * @author Nilesh Kapadia (nileshka@gmail.com)
 */
public class TsCustomerDAOImpl extends HibernateDaoSupport implements TsCustomerDAO {

    public TsCustomer load(String id) {
        return (TsCustomer) getHibernateTemplate().load(TsCustomer.class, id);
    }

    public void update(TsCustomer entry) {
        getHibernateTemplate().update(entry);
    }

    public void save(TsCustomer entry) {
        getHibernateTemplate().save(entry);
    }

    public void delete(TsCustomer entry) {
        getHibernateTemplate().delete(entry);
    }

    public void deleteById(String id) {
    	Object obj = load(id);
        getHibernateTemplate().delete(obj);
    }

    public List getList() {
        return (getHibernateTemplate().find("from com.myconnector.domain.TsCustomer x"));
    }

}
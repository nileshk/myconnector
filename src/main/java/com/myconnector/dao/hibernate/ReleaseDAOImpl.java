package com.myconnector.dao.hibernate;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.myconnector.dao.ReleaseDAO;
import com.myconnector.domain.Release;

/**
 * 
 * @author Nilesh Kapadia (nileshka@gmail.com)
 */
public class ReleaseDAOImpl extends HibernateDaoSupport implements ReleaseDAO {

    /*
     * @see com.myconnector.dao.ReleaseDAO#load(com.myconnector.domain.ReleasePK)
     */
    public Release load(String id) {
        return (Release) getHibernateTemplate().load(Release.class, id);
    }

    /*
     * @see com.myconnector.dao.ReleaseDAO#update(com.myconnector.domain.Release)
     */
    public void update(Release release) {
        getHibernateTemplate().update(release);
    }

    /*
     * @see com.myconnector.dao.ReleaseDAO#save(com.myconnector.domain.Release)
     */
    public void save(Release release) {
        getHibernateTemplate().save(release);
    }

    /*
     * @see com.myconnector.dao.ReleaseDAO#saveOrUpdate(com.myconnector.domain.Release)
     */
    public void saveOrUpdate(Release release) {
        getHibernateTemplate().saveOrUpdate(release);
    }

    /*
     * @see com.myconnector.dao.ReleaseDAO#delete(com.myconnector.domain.Release)
     */
    public void delete(Release release) {
        getHibernateTemplate().delete(release);
    }

    /*
     * @see com.myconnector.dao.ReleaseDAO#deleteById(java.lang.String)
     */
    public void deleteById(String id) {
    	Object obj = load(id);
        getHibernateTemplate().delete(obj);
    }

    /*
     * @see com.myconnector.dao.ReleaseDAO#getList()
     */
    public List getList() {
        return getHibernateTemplate().find("from com.myconnector.domain.Release release");
    }

    /*
     * @see com.myconnector.dao.ReleaseDAO#getListByUserId(java.lang.String)
     */
    public List getListById(String id) {
        return getHibernateTemplate().find(
                "from com.myconnector.domain.Release release where release.id = ?", id);
    }
}
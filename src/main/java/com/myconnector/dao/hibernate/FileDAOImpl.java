package com.myconnector.dao.hibernate;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.myconnector.dao.FileDAO;
import com.myconnector.domain.File;

/**
 * 
 * @author Nilesh Kapadia (nileshka@gmail.com)
 */
public class FileDAOImpl extends HibernateDaoSupport implements FileDAO {

    /*
     * @see com.myconnector.dao.FileDAO#load(com.myconnector.domain.FilePK)
     */
    public File load(String id) {
        return (File) getHibernateTemplate().load(File.class, id);
    }

    /*
     * @see com.myconnector.dao.FileDAO#update(com.myconnector.domain.File)
     */
    public void update(File file) {
        getHibernateTemplate().update(file);
    }

    /*
     * @see com.myconnector.dao.FileDAO#save(com.myconnector.domain.File)
     */
    public void save(File file) {
        getHibernateTemplate().save(file);
    }

    /*
     * @see com.myconnector.dao.FileDAO#saveOrUpdate(com.myconnector.domain.File)
     */
    public void saveOrUpdate(File file) {
        getHibernateTemplate().saveOrUpdate(file);
    }

    /*
     * @see com.myconnector.dao.FileDAO#delete(com.myconnector.domain.File)
     */
    public void delete(File file) {
        getHibernateTemplate().delete(file);
    }

    /*
     * @see com.myconnector.dao.FileDAO#deleteById(java.lang.String)
     */
    public void deleteById(String id) {
    	Object obj = load(id);
        getHibernateTemplate().delete(obj);    	
    }

    /*
     * @see com.myconnector.dao.FileDAO#getList()
     */
    public List getList() {
        return getHibernateTemplate().find("from com.myconnector.domain.File file");
    }

    /*
     * @see com.myconnector.dao.FileDAO#getListByUserId(java.lang.String)
     */
    public List getListById(String id) {
        return getHibernateTemplate().find(
                "from com.myconnector.domain.File file where file.id = ?", id);
    }
}
/*
 * Created on Aug 15, 2004
 *
 */
package com.myconnector.dao.hibernate;

import org.easymock.MockControl;
import org.springframework.orm.hibernate3.HibernateOperations;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.myconnector.dao.hibernate.BookmarkDAOImpl;
import com.myconnector.domain.Bookmark;

import junit.framework.TestCase;

/** 
 *
 * @author Nil
 */
public class BookmarkDAOImplTests extends TestCase {

    public void testLoadBookmark() {
        /*
        String id = "id";
        Bookmark bk1 = new Bookmark();
        bk1.setId(id);
        //MockControl sessionMC = MockControl.createControl(SessionFactory.class);
        //SessionFactory sessionFactory = (SessionFactory)sessionMC.getMock();
        MockControl hibernateTemplateMC = MockControl.createControl(HibernateOperations.class);
        HibernateOperations hibernateTemplate = (HibernateOperations)hibernateTemplateMC.getMock();
        hibernateTemplate.load(Bookmark.class, id);        
        hibernateTemplateMC.setReturnValue(bk1);
        hibernateTemplateMC.replay();
        BookmarkDAOImpl dao = new BookmarkDAOImpl();
        //dao.setSessionFactory(sessionFactory);
        dao.setHibernateTemplate(hibernateTemplate);
        dao.loadBookmark(id);
        hibernateTemplateMC.verify(); */
    }

    public void testUpdateBookmark() {
    }

    public void testSaveBookmark() {
    }

    public void testDeleteBookmark() {
    }

    public void testGetBookmarkList() {
    }

}

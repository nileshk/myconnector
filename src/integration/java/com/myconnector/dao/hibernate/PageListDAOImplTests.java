package com.myconnector.dao.hibernate;

import java.util.List;

import com.myconnector.dao.BaseDAOTests;
import com.myconnector.dao.PageListDAO;
import com.myconnector.domain.PageList;

public class PageListDAOImplTests extends BaseDAOTests {

    PageListDAO dao;

    @Override
    protected void onSetUpInTransaction() throws Exception {
        super.onSetUpInTransaction();
        dao = (PageListDAO) applicationContext.getBean("pageListDAO");
    }

    public void testSave() {
        PageList pageList = new PageList();
        pageList.setUrl("http://slashdot.org");
        dao.save(pageList);
    }

    public void testLoad() {
        PageList pageList = new PageList();
        pageList.setUrl("http://slashdot.org");
        dao.save(pageList);
        System.out.println(pageList.getId().toString());
        PageList loaded = dao.load(pageList.getId());
        assertEquals(pageList.getUrl(), loaded.getUrl());
    }

    public void testDelete() {
        PageList pageList = new PageList();
        pageList.setUrl("http://slashdot.org");
        dao.save(pageList);
        System.out.println(pageList.getId().toString());
        PageList loaded = dao.load(pageList.getId());
        assertEquals(pageList.getUrl(), loaded.getUrl());
        dao.delete(loaded);
    }

    public void testDeleteById() {
        PageList pageList = new PageList();
        pageList.setUrl("http://slashdot.org");
        dao.save(pageList);
        System.out.println(pageList.getId().toString());
        PageList loaded = dao.load(pageList.getId());
        assertEquals(pageList.getUrl(), loaded.getUrl());
        dao.deleteById(loaded.getId());
    }

    public void testViolateConstraint() {
        PageList pl1 = new PageList();
        pl1.setUrl("http://slashdot.org");
        dao.save(pl1);
        PageList pl2 = new PageList();
        pl2.setUrl("http://slashdot.org");
        dao.save(pl2);
        // Doesn't throw error until you commit?
    }

    public void testGetList() {
        List list1 = dao.getList();        
        PageList pl1 = new PageList();
        pl1.setUrl("http://slashdot.org");
        dao.save(pl1);
        PageList pl2 = new PageList();
        pl2.setUrl("http://www.google.com");
        dao.save(pl2);
        List list2 = dao.getList();
        assertEquals(2, list2.size() - list1.size());
    }

    public void testDeleteAll() {
        // Can't do this until foreign relationships in page_index is deleted
        //dao.deleteAll();
    }
    
    public void testCheckUrl() {
        boolean test = dao.checkUrl("http://slashdot.org/");
        assertTrue(test);
    }
    
    public void testCheckUrlFalse() {
        boolean test = dao.checkUrl("http://not.a.url");
        assertFalse(test);
    }
    
    public void testCount() {
        int count = dao.count();
        System.out.println("Count: " + count);
    }
    
}

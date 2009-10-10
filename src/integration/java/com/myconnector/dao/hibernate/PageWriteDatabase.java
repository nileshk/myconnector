package com.myconnector.dao.hibernate;

import com.myconnector.dao.BaseDAOTests;
import com.myconnector.dao.PageIndexDAO;
import com.myconnector.dao.PageListDAO;
import com.myconnector.domain.PageIndex;
import com.myconnector.domain.PageIndexPK;
import com.myconnector.domain.PageList;

public class PageWriteDatabase extends BaseDAOTests {

    PageListDAO pageListDAO;
    PageIndexDAO pageIndexDAO;

    @Override
    protected void onSetUpInTransaction() throws Exception {        
        pageListDAO = (PageListDAO) applicationContext.getBean("pageListDAO");
        pageIndexDAO = (PageIndexDAO) applicationContext.getBean("pageIndexDAO");
    }
    
    public void testCreateData() {
        setComplete();
        PageList pl1 = new PageList();
        pl1.setUrl("http://www.nileshk.com");
        pageListDAO.save(pl1);
        PageIndex pi1 = new PageIndex(new PageIndexPK(pl1, "computers"), Integer.valueOf(5));
        PageIndex pi2 = new PageIndex(new PageIndexPK(pl1, "software"), Integer.valueOf(3));
        pageIndexDAO.save(pi1);
        pageIndexDAO.save(pi2);
    }
    
}

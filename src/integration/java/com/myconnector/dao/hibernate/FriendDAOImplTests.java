package com.myconnector.dao.hibernate;

import com.myconnector.dao.BaseDAOTests;
import com.myconnector.dao.FriendDAO;
import com.myconnector.domain.FriendPK;

public class FriendDAOImplTests extends BaseDAOTests {

    FriendDAO dao;
    //UserDataDAO userDataDAO;
    
    @Override
    protected void onSetUpInTransaction() throws Exception {
        super.onSetUpInTransaction();
        dao = (FriendDAO) applicationContext.getBean("friendDAO");
        //userDataDAO = (UserDataDAO) applicationContext.getBean("userDataDAO");
    }
    
    public void testGetUrlList() {
        FriendPK pk = new FriendPK("nonexistant", "another");
        assertNull(dao.load(pk));
    }    
    
}

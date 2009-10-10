package com.myconnector.dao.hibernate;

import java.util.List;

import com.myconnector.dao.BaseDAOTests;
import com.myconnector.dao.BookmarkDAO;
import com.myconnector.dao.UserDataDAO;
import com.myconnector.domain.Bookmark;

public class BookmarkDAOImplTests2 extends BaseDAOTests {

    BookmarkDAO dao;
    UserDataDAO userDataDAO;
    
    @Override
    protected void onSetUpInTransaction() throws Exception {
        super.onSetUpInTransaction();
        dao = (BookmarkDAO) applicationContext.getBean("bookmarkDAO");
        userDataDAO = (UserDataDAO) applicationContext.getBean("userDataDAO");
    }
    
    public void testGetUrlList() {
        List<String> list = dao.getUrlList();
        for (String url : list) {
            System.out.println(url);
        }
    }
    
    public void testUserHasUrlTrue() {
        String userId = userDataDAO.getUserByUserLogin("admin").getId();
        boolean ret = dao.userHasBookmark("http://slashdot.org/", userId);
        assertTrue(ret);
    }

    public void testUserHasUrlFalse() {
        String userId = userDataDAO.getUserByUserLogin("admin").getId();
        boolean ret = dao.userHasBookmark("http://randomurladdfasdfasdf.org/", userId);
        assertFalse(ret);
    }    
    
    public void testGetBookmarkList() {
    	List<Bookmark> bookmarkList = dao.getBookmarkList();
    	assertTrue(bookmarkList.size() > 0);
    }
}

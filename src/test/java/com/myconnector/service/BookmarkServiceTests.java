/*
 * Created on Aug 14, 2004
 *
 */
package com.myconnector.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.easymock.MockControl;

import com.myconnector.dao.BookmarkDAO;
import com.myconnector.domain.Bookmark;
import com.myconnector.domain.UserData;

import junit.framework.TestCase;

/**
 * @author Nilesh Kapadia (nileshka@gmail.com)
 *
 */
public class BookmarkServiceTests extends TestCase {

	public void testLoadBookmark() {
		Bookmark bk = new Bookmark();
		bk.setAddDate(new Date());
		bk.setDescription("description");
		bk.setFolder("folder");
		bk.setId("BOOKMARKID");
		bk.setKeywords("keywords");
		bk.setLastVisit(new Date());
		bk.setTitle("title");
		bk.setUrl("url");
		UserData userData = new UserData();
		userData.setId("userid");
		bk.setUserData(userData);
		bk.setViewable(null);
		
		// Setup mock object
		MockControl mc = MockControl.createControl(BookmarkDAO.class);
		BookmarkDAO dao = (BookmarkDAO) mc.getMock();
		dao.loadBookmark("BOOKMARKID");
		mc.setReturnValue(bk);
		
		// Stop scripting mock and test using it
		mc.replay();		
		BookmarkServiceImpl bookmarkService = new BookmarkServiceImpl();
		bookmarkService.setBookmarkDAO(dao);
		assertEquals("Retrieved Bookmark object from DAO", 
				bookmarkService.loadBookmark("BOOKMARKID"),
				bk);
		mc.verify();
	}

	public void testSaveBookmark() {
		Bookmark bk1 = new Bookmark();
		bk1.setId("1");
		String id = "0123456789012345";
		int idLength = id.length();
		
		// Setup mock object
		MockControl daoMC = MockControl.createControl(BookmarkDAO.class);
		BookmarkDAO dao = (BookmarkDAO) daoMC.getMock();
		dao.saveBookmark(bk1);
				
		daoMC.replay();
		
		BookmarkServiceImpl bookmarkService = new BookmarkServiceImpl();
		bookmarkService.setBookmarkDAO(dao);
		bookmarkService.setIdLength(idLength);
		bookmarkService.saveBookmark(bk1);		
		
		daoMC.verify();
		assertEquals("Bookmark.id is set", id, bk1.getId());
		assertEquals("Bookmark.id is correct length", idLength, bk1.getId().length());
		
	}

	public void testDeleteBookmark() {
	}

	public void testSaveBookmarkArray() {	
		Bookmark bk1 = new Bookmark();
		bk1.setId("1");
		Bookmark bk2 = new Bookmark();
		bk2.setId("2");
		String id = "0123456789012345";
		String id2 = "ABCDF56789012345";
		int idLength = id.length();

		List list = new ArrayList();
		list.add(bk1);
		list.add(bk2);
		
		// Setup mock object
		MockControl daoMC = MockControl.createControl(BookmarkDAO.class);
		BookmarkDAO dao = (BookmarkDAO) daoMC.getMock();
		dao.saveBookmark(bk1);
		dao.saveBookmark(bk2);
				
		daoMC.replay();
		
		BookmarkServiceImpl bookmarkService = new BookmarkServiceImpl();
		bookmarkService.setBookmarkDAO(dao);
		bookmarkService.setIdLength(idLength);
		bookmarkService.saveBookmarkList(list);		
		
		daoMC.verify();
		assertEquals("Bookmark.id is set", id, bk1.getId());
		assertEquals("Bookmark.id is correct length", idLength, bk1.getId().length());
		assertEquals("Bookmark.id is set", id2, bk2.getId());
		assertEquals("Bookmark.id is correct length", idLength, bk1.getId().length());		
	}
/*
	public void testLoadBookmarkArray() {
		
	}
*/
}

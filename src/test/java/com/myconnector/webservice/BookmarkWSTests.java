/*
 * Created on Aug 15, 2004
 *
 */
package com.myconnector.webservice;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import com.myconnector.domain.Bookmark;
import com.myconnector.dto.BookmarkDTO;
import com.myconnector.service.BookmarkService;
import com.myconnector.util.ConvertUtil;

import org.apache.axis.AxisFault;
import org.easymock.MockControl;
import junit.framework.TestCase;

/**
 * @author Nilesh Kapadia (nileshka@gmail.com)
 *
 */
public class BookmarkWSTests extends TestCase {

	public void testLoadBookmark() {
	}

	public void testSaveBookmark() {
	}

	public void testDeleteBookmark() {
	}

	public void testLoadBookmarkList() throws AxisFault, RemoteException {
		MockControl mc = MockControl.createControl(BookmarkService.class);
		BookmarkService bookmarkService = (BookmarkService)mc.getMock();

		List list = new ArrayList();
		Bookmark b1 = new Bookmark();
		Bookmark b2 = new Bookmark();
		Bookmark b3 = new Bookmark();
		list.add(b1);
		list.add(b2);	
		list.add(b3);
		
		bookmarkService.getList();
		mc.setReturnValue(list);
		
		mc.replay();
		BookmarkWSImplTestable bookmarkWS = new BookmarkWSImplTestable();
		bookmarkWS.setBookmarkService(bookmarkService);
		BookmarkDTO[] bookmarkArray = bookmarkWS.loadBookmarkList();
		assertNotNull("Array not null", bookmarkArray);
		assertNotNull("Array element not null", bookmarkArray[0]);
		assertNotNull("Array element not null", bookmarkArray[1]);
		assertNotNull("Array element not null", bookmarkArray[2]);
		assertEquals("Is correct Bookmark instance", b1, bookmarkArray[0]);
		assertEquals("Is correct Bookmark instance", b2, bookmarkArray[1]);
		assertEquals("Is correct Bookmark instance", b3, bookmarkArray[2]);
		mc.verify();
	}

	public void testSaveBookmarkList() throws AxisFault, RemoteException {
		MockControl mc = MockControl.createControl(BookmarkService.class);
		BookmarkService bookmarkService = (BookmarkService)mc.getMock();
		
		BookmarkDTO[] ba = new BookmarkDTO[3];
		ba[0] = new BookmarkDTO();		
		ba[1] = new BookmarkDTO();
		ba[2] = new BookmarkDTO();
		List list = ConvertUtil.array2List(ba);
		bookmarkService.saveBookmarkList(list);
		
		mc.replay();
		BookmarkWSImplTestable bookmarkWS = new BookmarkWSImplTestable();
		bookmarkWS.setBookmarkService(bookmarkService);
		bookmarkWS.saveBookmarkList(ba);
		mc.verify();
	}
	
	
	private class BookmarkWSImplTestable extends BookmarkWSImpl {
		/**
		 * @param bookmarkService The bookmarkService to set.
		 */
		public void setBookmarkService(BookmarkService bookmarkService) {
			this.bookmarkService = bookmarkService;
		}		
	}
}

/*
 * Created on Aug 15, 2004
 *
 */
package com.myconnector.util;

import java.util.ArrayList;
import java.util.List;

import com.myconnector.domain.Bookmark;

import junit.framework.TestCase;

/**
 * @author Nilesh Kapadia (nileshka@gmail.com)
 *
 */
public class BookmarkUtilTests extends TestCase {

	public void testList2Array() {
		List list = new ArrayList();
		Bookmark b1 = new Bookmark();
		Bookmark b2 = new Bookmark();
		Bookmark b3 = new Bookmark();
		list.add(b1);
		list.add(b2);	
		list.add(b3);
		Bookmark[] bookmarkArray = BookmarkUtil.list2Array(list);
		assertNotNull("Array not null", bookmarkArray);
		assertNotNull("Array element not null", bookmarkArray[0]);
		assertNotNull("Array element not null", bookmarkArray[1]);
		assertNotNull("Array element not null", bookmarkArray[2]);
		assertEquals("Is correct Bookmark instance", b1, bookmarkArray[0]);
		assertEquals("Is correct Bookmark instance", b2, bookmarkArray[1]);
		assertEquals("Is correct Bookmark instance", b3, bookmarkArray[2]);
	}
	
	public void testList2ArrayNullInput() {
		Bookmark[] bookmarkArray = BookmarkUtil.list2Array(null);
		assertNull("Return value is null", bookmarkArray);		
	}
	
	public void testList2ArrayEmptyList() {
		Bookmark[] bookmarkArray = BookmarkUtil.list2Array(new ArrayList());
		assertNull("Return value is null", bookmarkArray);
	}

	public void testList2ArrayBadInput() {
		List list = new ArrayList();
		Bookmark b1 = new Bookmark();
		Integer b2 = new Integer(5);
		Bookmark b3 = new Bookmark();
		list.add(b1);
		list.add(b2);	
		list.add(b3);
		try {
		Bookmark[] bookmarkArray = BookmarkUtil.list2Array(list);
		}
		catch(ClassCastException ex)
		{
			assertEquals("Expected exception", ClassCastException.class, ex.getClass());
		}
	}
	
	
}

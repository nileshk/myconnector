/*
 * Created on Aug 15, 2004
 *
 */
package com.myconnector.util;

import java.util.Iterator;
import java.util.List;

import com.myconnector.domain.Bookmark;

/**
 * @author nil
 *  
 */
public class BookmarkUtil {

	/**
	 * Converts a List to Bookmark[]. If the a null List is provided, or the
	 * List is empty, returns null.
	 * 
	 * @param list List of Bookmark instances
	 * @return
	 */
	public static Bookmark[] list2Array(List list) {
		Bookmark[] bookmarkArray = null;
		if (list != null && !list.isEmpty()) {
			bookmarkArray = new Bookmark[list.size()];
			Iterator iterator = list.iterator();
			int i = 0;
			while (iterator.hasNext()) {
				bookmarkArray[i++] = (Bookmark) iterator.next();
			}
		}
		return (bookmarkArray);
	}
}
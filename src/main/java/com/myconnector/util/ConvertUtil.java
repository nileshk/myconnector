/*
 * Created on Aug 15, 2004
 */
package com.myconnector.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Generic conversion utilities
 * 
 * @author nil
 */
public class ConvertUtil {

	/**
	 * Converts an Object[] to a List. If null Object[] is provided, an empty
	 * List is returned.
	 * 
	 * @param obj
	 *            Array of objects to be placed in List
	 * @return List of objects
	 */
	public static List array2List(Object[] obj) {
		ArrayList list = new ArrayList();
		if (obj != null) {
			for (int i = 0; i < obj.length; i++) {
				list.add(obj[i]);
			}
		}
		return (list);
	}

}
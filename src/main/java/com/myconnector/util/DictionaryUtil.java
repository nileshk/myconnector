/*
 * Created on Aug 15, 2004
 *
 */
package com.myconnector.util;

import java.util.Iterator;
import java.util.List;

import com.myconnector.domain.Dictionary;

/**
 * @author nil
 *  
 */
public class DictionaryUtil {

	/**
	 * Converts a List to Dictionary[]. If the a null List is provided, or the
	 * List is empty, returns null.
	 * 
	 * @param list List of Dictionary instances
	 * @return
	 */
	public static Dictionary[] list2Array(List list) {
		Dictionary[] dictionaryArray = null;
		if (list != null && !list.isEmpty()) {
			dictionaryArray = new Dictionary[list.size()];
			Iterator iterator = list.iterator();
			int i = 0;
			while (iterator.hasNext()) {
				dictionaryArray[i++] = (Dictionary) iterator.next();
			}
		}
		return (dictionaryArray);
	}
}
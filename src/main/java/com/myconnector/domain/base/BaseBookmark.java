package com.myconnector.domain.base;

import java.io.Serializable;
import com.myconnector.dto.BookmarkDTO;



/**
 * This is an object that contains data related to the bookmark table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="bookmark"
 */

public abstract class BaseBookmark extends BookmarkDTO implements Serializable {

	public static String REF = "Bookmark";
	public static String PROP_URL = "url";
	public static String PROP_TITLE = "title";
	public static String PROP_FOLDER = "folder";
	public static String PROP_DESCRIPTION = "description";
	public static String PROP_ADD_DATE = "addDate";
	public static String PROP_LAST_VISIT = "lastVisit";
	public static String PROP_VIEWABLE = "viewable";
	public static String PROP_KEYWORDS = "keywords";


	// constructors
	public BaseBookmark () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBookmark (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseBookmark (
		java.lang.String id,
		com.myconnector.domain.UserData userData,
		java.lang.String url) {

		this.setId(id);
		this.setUserData(userData);
		this.setUrl(url);
		initialize();
	}

	protected void initialize () {}



	//private int hashCode = Integer.MIN_VALUE;

	// primary key
	//private java.lang.String id;

	// fields
	//private java.lang.String url;
	//private java.lang.String title;
	//private java.lang.String folder;
	//private java.lang.String description;
	//private java.util.Date addDate;
	//private java.util.Date lastVisit;
	//private java.lang.Byte viewable;
	//private java.lang.String keywords;

	// many to one
	private com.myconnector.domain.UserData userData;








	/**
	 * Return the value associated with the column: USER_ID
	 */
	public com.myconnector.domain.UserData getUserData () {
		return userData;
	}

	/**
	 * Set the value related to the column: USER_ID
	 * @param userData the USER_ID value
	 */
	public void setUserData (com.myconnector.domain.UserData userData) {
		this.userData = userData;
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.myconnector.domain.Bookmark)) return false;
		else {
			com.myconnector.domain.Bookmark bookmark = (com.myconnector.domain.Bookmark) obj;
			if (null == this.getId() || null == bookmark.getId()) return false;
			else return (this.getId().equals(bookmark.getId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}
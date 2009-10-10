package com.myconnector.domain;

import com.myconnector.domain.base.BaseBookmark;



public class Bookmark extends BaseBookmark {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Bookmark () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Bookmark (java.lang.String id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public Bookmark (
		java.lang.String id,
		com.myconnector.domain.UserData userData,
		java.lang.String url) {

		super (
			id,
			userData,
			url);
	}

/*[CONSTRUCTOR MARKER END]*/


}
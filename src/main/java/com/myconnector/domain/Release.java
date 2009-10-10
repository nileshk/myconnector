package com.myconnector.domain;

import com.myconnector.domain.base.BaseRelease;



public class Release extends BaseRelease {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Release () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Release (java.lang.String id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public Release (
		java.lang.String id,
		com.myconnector.domain.UserData createdBy) {

		super (
			id,
			createdBy);
	}

/*[CONSTRUCTOR MARKER END]*/


}
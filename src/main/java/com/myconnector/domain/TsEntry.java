package com.myconnector.domain;

import com.myconnector.domain.base.BaseTsEntry;



public class TsEntry extends BaseTsEntry {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public TsEntry () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public TsEntry (java.lang.String id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public TsEntry (
		java.lang.String id,
		com.myconnector.domain.UserData user,
		com.myconnector.domain.TsActivity activity,
		java.lang.String description) {

		super (
			id,
			user,
			activity,
			description);
	}

/*[CONSTRUCTOR MARKER END]*/


}
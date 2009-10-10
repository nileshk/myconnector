package com.myconnector.domain;

import com.myconnector.domain.base.BaseTsActivity;



public class TsActivity extends BaseTsActivity {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public TsActivity () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public TsActivity (java.lang.String id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public TsActivity (
		java.lang.String id,
		java.lang.String name,
		java.lang.String description) {

		super (
			id,
			name,
			description);
	}

/*[CONSTRUCTOR MARKER END]*/


}
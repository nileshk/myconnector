package com.myconnector.domain;

import com.myconnector.domain.base.BaseTsCustomer;



public class TsCustomer extends BaseTsCustomer {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public TsCustomer () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public TsCustomer (java.lang.String id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public TsCustomer (
		java.lang.String id,
		java.lang.String name,
		java.lang.String abbreviation) {

		super (
			id,
			name,
			abbreviation);
	}

/*[CONSTRUCTOR MARKER END]*/


}
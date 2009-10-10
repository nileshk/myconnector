package com.myconnector.domain;

import com.myconnector.domain.base.BaseFile;



public class File extends BaseFile {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public File () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public File (java.lang.String id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public File (
		java.lang.String id,
		byte[] file) {

		super (
			id,
			file);
	}

/*[CONSTRUCTOR MARKER END]*/


}
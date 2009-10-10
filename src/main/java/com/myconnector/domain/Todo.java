package com.myconnector.domain;

import com.myconnector.domain.base.BaseTodo;



public class Todo extends BaseTodo {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Todo () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Todo (java.lang.String id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public Todo (
		java.lang.String id,
		com.myconnector.domain.UserData userData,
		java.lang.String description) {

		super (
			id,
			userData,
			description);
	}

/*[CONSTRUCTOR MARKER END]*/


}
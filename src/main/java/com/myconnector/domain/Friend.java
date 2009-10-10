package com.myconnector.domain;

import com.myconnector.domain.base.BaseFriend;



public class Friend extends BaseFriend {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Friend () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Friend (com.myconnector.domain.FriendPK comp_id) {
		super(comp_id);
	}

/*[CONSTRUCTOR MARKER END]*/


}
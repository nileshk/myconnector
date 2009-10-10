package com.myconnector.domain;

import com.myconnector.domain.base.BaseFriendPK;

public class FriendPK extends BaseFriendPK {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public FriendPK () {}
	
	public FriendPK (
		java.lang.String id,
		java.lang.String friendId) {

		super (
			id,
			friendId);
	}
/*[CONSTRUCTOR MARKER END]*/


}
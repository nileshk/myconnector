package com.myconnector.domain;

import java.util.Date;

import com.myconnector.domain.base.BaseUserData;



public class UserData extends BaseUserData {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public UserData () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public UserData (java.lang.String id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public UserData (
		java.lang.String id,
		java.lang.String userLogin,
		java.lang.String userPassword,
		byte securityLevel) {

		super (
			id,
			userLogin,
			userPassword,
			securityLevel);
	}

/*[CONSTRUCTOR MARKER END]*/

    public UserCookie getNewCookie() {
        UserCookie newCookie = new UserCookie();
        newCookie.setCreateDate(new Date());
        addCookie(newCookie);
        newCookie.setUserData(this);
        return newCookie;
    }
    
    public void addCookie(UserCookie cookie) {
        if (null == getCookies()) setCookies(new java.util.HashSet<UserCookie>());
        getCookies().add(cookie);
    }

}
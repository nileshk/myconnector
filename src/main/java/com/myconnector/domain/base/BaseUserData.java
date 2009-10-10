package com.myconnector.domain.base;

import java.io.Serializable;
import java.util.Date;

import com.myconnector.domain.UserCookie;
import com.myconnector.dto.UserDataDTO;



/**
 * This is an object that contains data related to the user_data table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="user_data"
 */

public abstract class BaseUserData extends UserDataDTO implements Serializable {

	public static String REF = "UserData";
	public static String PROP_USER_LOGIN = "userLogin";
	public static String PROP_USER_PASSWORD = "userPassword";
	public static String PROP_SECURITY_LEVEL = "securityLevel";


	// constructors
	public BaseUserData () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseUserData (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseUserData (
		java.lang.String id,
		java.lang.String userLogin,
		java.lang.String userPassword,
		byte securityLevel) {

		this.setId(id);
		this.setUserLogin(userLogin);
		this.setUserPassword(userPassword);
		this.setSecurityLevel(securityLevel);
		initialize();
	}

	protected void initialize () {}



	//private int hashCode = Integer.MIN_VALUE;

	// primary key
	//private java.lang.String id;

	// fields
	//private java.lang.String userLogin;
	//private java.lang.String userPassword;
	//private byte securityLevel;

	// collections
	private java.util.Set bookmarksByUserId;
	private java.util.Set todos;
	private java.util.Set releaseUserXrefs;
	private java.util.Set friendsByFriendId;
	private java.util.Set friendsById;
	private java.util.Set releasesByCreatedBy;
    private java.util.Set<UserCookie> cookies;

	/**
	 * Return the value associated with the column: bookmarksByUserId
	 */
	public java.util.Set getBookmarksByUserId () {
		return bookmarksByUserId;
	}

	/**
	 * Set the value related to the column: bookmarksByUserId
	 * @param bookmarksByUserId the bookmarksByUserId value
	 */
	public void setBookmarksByUserId (java.util.Set bookmarksByUserId) {
		this.bookmarksByUserId = bookmarksByUserId;
	}

	public void addTobookmarksByUserId (com.myconnector.domain.Bookmark bookmark) {
		if (null == getBookmarksByUserId()) setBookmarksByUserId(new java.util.HashSet());
		getBookmarksByUserId().add(bookmark);
	}



	/**
	 * Return the value associated with the column: todos
	 */
	public java.util.Set getTodos () {
		return todos;
	}

	/**
	 * Set the value related to the column: todos
	 * @param todos the todos value
	 */
	public void setTodos (java.util.Set todos) {
		this.todos = todos;
	}

	public void addTotodos (com.myconnector.domain.Todo todo) {
		if (null == getTodos()) setTodos(new java.util.HashSet());
		getTodos().add(todo);
	}



	/**
	 * Return the value associated with the column: releaseUserXrefs
	 */
	public java.util.Set getReleaseUserXrefs () {
		return releaseUserXrefs;
	}

	/**
	 * Set the value related to the column: releaseUserXrefs
	 * @param releaseUserXrefs the releaseUserXrefs value
	 */
	public void setReleaseUserXrefs (java.util.Set releaseUserXrefs) {
		this.releaseUserXrefs = releaseUserXrefs;
	}

	public void addToreleaseUserXrefs (com.myconnector.domain.ReleaseUserXref releaseUserXref) {
		if (null == getReleaseUserXrefs()) setReleaseUserXrefs(new java.util.HashSet());
		getReleaseUserXrefs().add(releaseUserXref);
	}



	/**
	 * Return the value associated with the column: friendsByFriendId
	 */
	public java.util.Set getFriendsByFriendId () {
		return friendsByFriendId;
	}

	/**
	 * Set the value related to the column: friendsByFriendId
	 * @param friendsByFriendId the friendsByFriendId value
	 */
	public void setFriendsByFriendId (java.util.Set friendsByFriendId) {
		this.friendsByFriendId = friendsByFriendId;
	}

	public void addTofriendsByFriendId (com.myconnector.domain.Friend friend) {
		if (null == getFriendsByFriendId()) setFriendsByFriendId(new java.util.HashSet());
		getFriendsByFriendId().add(friend);
	}



	/**
	 * Return the value associated with the column: friendsById
	 */
	public java.util.Set getFriendsById () {
		return friendsById;
	}

	/**
	 * Set the value related to the column: friendsById
	 * @param friendsById the friendsById value
	 */
	public void setFriendsById (java.util.Set friendsById) {
		this.friendsById = friendsById;
	}

	public void addTofriendsById (com.myconnector.domain.Friend friend) {
		if (null == getFriendsById()) setFriendsById(new java.util.HashSet());
		getFriendsById().add(friend);
	}

    public java.util.Set<UserCookie> getCookies() {
        return cookies;
    }

    public void setCookies(java.util.Set<UserCookie> cookies) {
        this.cookies = cookies;
    }
    
	/**
	 * Return the value associated with the column: releasesByCreatedBy
	 */
	public java.util.Set getReleasesByCreatedBy () {
		return releasesByCreatedBy;
	}

	/**
	 * Set the value related to the column: releasesByCreatedBy
	 * @param releasesByCreatedBy the releasesByCreatedBy value
	 */
	public void setReleasesByCreatedBy (java.util.Set releasesByCreatedBy) {
		this.releasesByCreatedBy = releasesByCreatedBy;
	}

	public void addToreleasesByCreatedBy (com.myconnector.domain.Release release) {
		if (null == getReleasesByCreatedBy()) setReleasesByCreatedBy(new java.util.HashSet());
		getReleasesByCreatedBy().add(release);
	}

	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.myconnector.domain.UserData)) return false;
		else {
			com.myconnector.domain.UserData userData = (com.myconnector.domain.UserData) obj;
			if (null == this.getId() || null == userData.getId()) return false;
			else return (this.getId().equals(userData.getId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}

}
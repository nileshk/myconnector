package com.myconnector.domain.base;

import java.io.Serializable;
import com.myconnector.dto.FriendDTO;



/**
 * This is an object that contains data related to the friend table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="friend"
 */

public abstract class BaseFriend extends FriendDTO implements Serializable {

	public static String REF = "Friend";


	// constructors
	public BaseFriend () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseFriend (com.myconnector.domain.FriendPK comp_id) {
		this.setComp_id(comp_id);
		initialize();
	}

	protected void initialize () {}



	//private int hashCode = Integer.MIN_VALUE;

	// primary key
	//private com.myconnector.domain.FriendPK comp_id;

	// many to one
	private com.myconnector.domain.UserData userDataByFriendId;
	private com.myconnector.domain.UserData userDataById;








	/**
	 * Return the value associated with the column: FRIEND_ID
	 */
	public com.myconnector.domain.UserData getUserDataByFriendId () {
		return userDataByFriendId;
	}

	/**
	 * Set the value related to the column: FRIEND_ID
	 * @param userDataByFriendId the FRIEND_ID value
	 */
	public void setUserDataByFriendId (com.myconnector.domain.UserData userDataByFriendId) {
		this.userDataByFriendId = userDataByFriendId;
	}



	/**
	 * Return the value associated with the column: ID
	 */
	public com.myconnector.domain.UserData getUserDataById () {
		return userDataById;
	}

	/**
	 * Set the value related to the column: ID
	 * @param userDataById the ID value
	 */
	public void setUserDataById (com.myconnector.domain.UserData userDataById) {
		this.userDataById = userDataById;
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.myconnector.domain.Friend)) return false;
		else {
			com.myconnector.domain.Friend friend = (com.myconnector.domain.Friend) obj;
			if (null == this.getComp_id() || null == friend.getComp_id()) return false;
			else return (this.getComp_id().equals(friend.getComp_id()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getComp_id()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getComp_id().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}
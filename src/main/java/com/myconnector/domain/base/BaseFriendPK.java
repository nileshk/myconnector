package com.myconnector.domain.base;

import java.io.Serializable;


public abstract class BaseFriendPK implements Serializable {

	protected int hashCode = Integer.MIN_VALUE;

	private java.lang.String id;
	private java.lang.String friendId;


	public BaseFriendPK () {}
	
	public BaseFriendPK (
		java.lang.String id,
		java.lang.String friendId) {

		this.setId(id);
		this.setFriendId(friendId);
	}


	/**
	 * Return the value associated with the column: id
	 */
	public java.lang.String getId () {
		return id;
	}

	/**
	 * Set the value related to the column: id
	 * @param id the id value
	 */
	public void setId (java.lang.String id) {
		this.id = id;
	}



	/**
	 * Return the value associated with the column: friend_id
	 */
	public java.lang.String getFriendId () {
		return friendId;
	}

	/**
	 * Set the value related to the column: friend_id
	 * @param friendId the friend_id value
	 */
	public void setFriendId (java.lang.String friendId) {
		this.friendId = friendId;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.myconnector.domain.FriendPK)) return false;
		else {
			com.myconnector.domain.FriendPK mObj = (com.myconnector.domain.FriendPK) obj;
			if (null != this.getId() && null != mObj.getId()) {
				if (!this.getId().equals(mObj.getId())) {
					return false;
				}
			}
			else {
				return false;
			}
			if (null != this.getFriendId() && null != mObj.getFriendId()) {
				if (!this.getFriendId().equals(mObj.getFriendId())) {
					return false;
				}
			}
			else {
				return false;
			}
			return true;
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			StringBuffer sb = new StringBuffer();
			if (null != this.getId()) {
				sb.append(this.getId().hashCode());
				sb.append(":");
			}
			else {
				return super.hashCode();
			}
			if (null != this.getFriendId()) {
				sb.append(this.getFriendId().hashCode());
				sb.append(":");
			}
			else {
				return super.hashCode();
			}
			this.hashCode = sb.toString().hashCode();
		}
		return this.hashCode;
	}


}
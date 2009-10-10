package com.myconnector.domain.base;

import java.io.Serializable;


public abstract class BaseReleaseUserXrefPK implements Serializable {

	protected int hashCode = Integer.MIN_VALUE;

	private java.lang.String releaseId;
	private java.lang.String userId;


	public BaseReleaseUserXrefPK () {}
	
	public BaseReleaseUserXrefPK (
		java.lang.String releaseId,
		java.lang.String userId) {

		this.setReleaseId(releaseId);
		this.setUserId(userId);
	}


	/**
	 * Return the value associated with the column: release_id
	 */
	public java.lang.String getReleaseId () {
		return releaseId;
	}

	/**
	 * Set the value related to the column: release_id
	 * @param releaseId the release_id value
	 */
	public void setReleaseId (java.lang.String releaseId) {
		this.releaseId = releaseId;
	}



	/**
	 * Return the value associated with the column: user_id
	 */
	public java.lang.String getUserId () {
		return userId;
	}

	/**
	 * Set the value related to the column: user_id
	 * @param userId the user_id value
	 */
	public void setUserId (java.lang.String userId) {
		this.userId = userId;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.myconnector.domain.ReleaseUserXrefPK)) return false;
		else {
			com.myconnector.domain.ReleaseUserXrefPK mObj = (com.myconnector.domain.ReleaseUserXrefPK) obj;
			if (null != this.getReleaseId() && null != mObj.getReleaseId()) {
				if (!this.getReleaseId().equals(mObj.getReleaseId())) {
					return false;
				}
			}
			else {
				return false;
			}
			if (null != this.getUserId() && null != mObj.getUserId()) {
				if (!this.getUserId().equals(mObj.getUserId())) {
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
			if (null != this.getReleaseId()) {
				sb.append(this.getReleaseId().hashCode());
				sb.append(":");
			}
			else {
				return super.hashCode();
			}
			if (null != this.getUserId()) {
				sb.append(this.getUserId().hashCode());
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
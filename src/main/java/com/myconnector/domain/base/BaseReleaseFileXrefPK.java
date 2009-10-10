package com.myconnector.domain.base;

import java.io.Serializable;


public abstract class BaseReleaseFileXrefPK implements Serializable {

	protected int hashCode = Integer.MIN_VALUE;

	private java.lang.String releaseId;
	private java.lang.String fileId;


	public BaseReleaseFileXrefPK () {}
	
	public BaseReleaseFileXrefPK (
		java.lang.String releaseId,
		java.lang.String fileId) {

		this.setReleaseId(releaseId);
		this.setFileId(fileId);
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
	 * Return the value associated with the column: file_id
	 */
	public java.lang.String getFileId () {
		return fileId;
	}

	/**
	 * Set the value related to the column: file_id
	 * @param fileId the file_id value
	 */
	public void setFileId (java.lang.String fileId) {
		this.fileId = fileId;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.myconnector.domain.ReleaseFileXrefPK)) return false;
		else {
			com.myconnector.domain.ReleaseFileXrefPK mObj = (com.myconnector.domain.ReleaseFileXrefPK) obj;
			if (null != this.getReleaseId() && null != mObj.getReleaseId()) {
				if (!this.getReleaseId().equals(mObj.getReleaseId())) {
					return false;
				}
			}
			else {
				return false;
			}
			if (null != this.getFileId() && null != mObj.getFileId()) {
				if (!this.getFileId().equals(mObj.getFileId())) {
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
			if (null != this.getFileId()) {
				sb.append(this.getFileId().hashCode());
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
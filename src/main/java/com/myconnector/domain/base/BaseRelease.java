package com.myconnector.domain.base;

import java.io.Serializable;
import com.myconnector.dto.ReleaseDTO;



/**
 * This is an object that contains data related to the releases table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="releases"
 */

public abstract class BaseRelease extends ReleaseDTO implements Serializable {

	public static String REF = "Release";
	public static String PROP_TITLE = "title";
	public static String PROP_DESCRIPTION = "description";
	public static String PROP_INSTRUCTIONS = "instructions";
	public static String PROP_VERSION_NUMBER = "versionNumber";
	public static String PROP_CREATED_DATE = "createdDate";
	public static String PROP_READY = "ready";
	public static String PROP_KEYWORDS = "keywords";


	// constructors
	public BaseRelease () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseRelease (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseRelease (
		java.lang.String id,
		com.myconnector.domain.UserData createdBy) {

		this.setId(id);
		this.setCreatedBy(createdBy);
		initialize();
	}

	protected void initialize () {}



	//private int hashCode = Integer.MIN_VALUE;

	// primary key
	//private java.lang.String id;

	// fields
	//private java.lang.String title;
	//private java.lang.String description;
	//private java.lang.String instructions;
	//private java.lang.String versionNumber;
	//private java.util.Date createdDate;
	//private java.lang.Byte ready;
	//private java.lang.String keywords;

	// many to one
	private com.myconnector.domain.UserData createdBy;

	// collections
	private java.util.Set releaseFileXrefs;
	private java.util.Set releaseUserXrefs;








	/**
	 * Return the value associated with the column: CREATED_BY
	 */
	public com.myconnector.domain.UserData getCreatedBy () {
		return createdBy;
	}

	/**
	 * Set the value related to the column: CREATED_BY
	 * @param createdBy the CREATED_BY value
	 */
	public void setCreatedBy (com.myconnector.domain.UserData createdBy) {
		this.createdBy = createdBy;
	}



	/**
	 * Return the value associated with the column: releaseFileXrefs
	 */
	public java.util.Set getReleaseFileXrefs () {
		return releaseFileXrefs;
	}

	/**
	 * Set the value related to the column: releaseFileXrefs
	 * @param releaseFileXrefs the releaseFileXrefs value
	 */
	public void setReleaseFileXrefs (java.util.Set releaseFileXrefs) {
		this.releaseFileXrefs = releaseFileXrefs;
	}

	public void addToreleaseFileXrefs (com.myconnector.domain.ReleaseFileXref releaseFileXref) {
		if (null == getReleaseFileXrefs()) setReleaseFileXrefs(new java.util.HashSet());
		getReleaseFileXrefs().add(releaseFileXref);
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





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.myconnector.domain.Release)) return false;
		else {
			com.myconnector.domain.Release release = (com.myconnector.domain.Release) obj;
			if (null == this.getId() || null == release.getId()) return false;
			else return (this.getId().equals(release.getId()));
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
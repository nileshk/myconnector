package com.myconnector.domain.base;

import java.io.Serializable;
import com.myconnector.dto.ReleaseUserXrefDTO;



/**
 * This is an object that contains data related to the release_user_xref table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="release_user_xref"
 */

public abstract class BaseReleaseUserXref extends ReleaseUserXrefDTO implements Serializable {

	public static String REF = "ReleaseUserXref";


	// constructors
	public BaseReleaseUserXref () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseReleaseUserXref (com.myconnector.domain.ReleaseUserXrefPK comp_id) {
		this.setComp_id(comp_id);
		initialize();
	}

	protected void initialize () {}



	//private int hashCode = Integer.MIN_VALUE;

	// primary key
	//private com.myconnector.domain.ReleaseUserXrefPK comp_id;

	// many to one
	private com.myconnector.domain.UserData userData;
	private com.myconnector.domain.Release release;








	/**
	 * Return the value associated with the column: USER_ID
	 */
	public com.myconnector.domain.UserData getUserData () {
		return userData;
	}

	/**
	 * Set the value related to the column: USER_ID
	 * @param userData the USER_ID value
	 */
	public void setUserData (com.myconnector.domain.UserData userData) {
		this.userData = userData;
	}



	/**
	 * Return the value associated with the column: RELEASE_ID
	 */
	public com.myconnector.domain.Release getRelease () {
		return release;
	}

	/**
	 * Set the value related to the column: RELEASE_ID
	 * @param release the RELEASE_ID value
	 */
	public void setRelease (com.myconnector.domain.Release release) {
		this.release = release;
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.myconnector.domain.ReleaseUserXref)) return false;
		else {
			com.myconnector.domain.ReleaseUserXref releaseUserXref = (com.myconnector.domain.ReleaseUserXref) obj;
			if (null == this.getComp_id() || null == releaseUserXref.getComp_id()) return false;
			else return (this.getComp_id().equals(releaseUserXref.getComp_id()));
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
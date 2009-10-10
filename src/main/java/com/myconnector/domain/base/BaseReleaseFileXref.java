package com.myconnector.domain.base;

import java.io.Serializable;
import com.myconnector.dto.ReleaseFileXrefDTO;



/**
 * This is an object that contains data related to the release_file_xref table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="release_file_xref"
 */

public abstract class BaseReleaseFileXref extends ReleaseFileXrefDTO implements Serializable {

	public static String REF = "ReleaseFileXref";


	// constructors
	public BaseReleaseFileXref () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseReleaseFileXref (com.myconnector.domain.ReleaseFileXrefPK comp_id) {
		this.setComp_id(comp_id);
		initialize();
	}

	protected void initialize () {}



	//private int hashCode = Integer.MIN_VALUE;

	// primary key
	//private com.myconnector.domain.ReleaseFileXrefPK comp_id;

	// many to one
	private com.myconnector.domain.File file;
	private com.myconnector.domain.Release release;








	/**
	 * Return the value associated with the column: FILE_ID
	 */
	public com.myconnector.domain.File getFile () {
		return file;
	}

	/**
	 * Set the value related to the column: FILE_ID
	 * @param file the FILE_ID value
	 */
	public void setFile (com.myconnector.domain.File file) {
		this.file = file;
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
		if (!(obj instanceof com.myconnector.domain.ReleaseFileXref)) return false;
		else {
			com.myconnector.domain.ReleaseFileXref releaseFileXref = (com.myconnector.domain.ReleaseFileXref) obj;
			if (null == this.getComp_id() || null == releaseFileXref.getComp_id()) return false;
			else return (this.getComp_id().equals(releaseFileXref.getComp_id()));
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
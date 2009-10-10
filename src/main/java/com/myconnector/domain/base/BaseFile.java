package com.myconnector.domain.base;

import java.io.Serializable;
import com.myconnector.dto.FileDTO;



/**
 * This is an object that contains data related to the files table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="files"
 */

public abstract class BaseFile extends FileDTO implements Serializable {

	public static String REF = "File";
	public static String PROP_FILE_NAME = "fileName";
	public static String PROP_FILE_SIZE = "fileSize";
	public static String PROP_FILE_TYPE = "fileType";
	public static String PROP_FILE_DESCRIPTION = "fileDescription";
	public static String PROP_FILE = "file";


	// constructors
	public BaseFile () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseFile (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseFile (
		java.lang.String id,
		byte[] file) {

		this.setId(id);
		this.setFile(file);
		initialize();
	}

	protected void initialize () {}



	//private int hashCode = Integer.MIN_VALUE;

	// primary key
	//private java.lang.String id;

	// fields
	//private java.lang.String fileName;
	//private java.lang.Short fileSize;
	//private java.lang.String fileType;
	//private java.lang.String fileDescription;
	//private byte[] file;

	// collections
	private java.util.Set releaseFileXrefs;








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





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.myconnector.domain.File)) return false;
		else {
			com.myconnector.domain.File file = (com.myconnector.domain.File) obj;
			if (null == this.getId() || null == file.getId()) return false;
			else return (this.getId().equals(file.getId()));
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
package com.myconnector.dto;

import java.io.Serializable;

public class FileDTO implements Serializable {


	protected int hashCode = Integer.MIN_VALUE;



	// primary key
	private java.lang.String id;


	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="uuid.hex"
     *  column="id"
     */
	public java.lang.String getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (java.lang.String id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}



	// fields
	private java.lang.String fileName;
	private java.lang.Short fileSize;
	private java.lang.String fileType;
	private java.lang.String fileDescription;
	private byte[] file;


	/**
	 * Return the value associated with the column: file_name
	 */
	public java.lang.String getFileName () {
		return fileName;
	}

	/**
	 * Set the value related to the column: file_name
	 * @param fileName the file_name value
	 */
	public void setFileName (java.lang.String fileName) {
		this.fileName = fileName;
	}



	/**
	 * Return the value associated with the column: file_size
	 */
	public java.lang.Short getFileSize () {
		return fileSize;
	}

	/**
	 * Set the value related to the column: file_size
	 * @param fileSize the file_size value
	 */
	public void setFileSize (java.lang.Short fileSize) {
		this.fileSize = fileSize;
	}



	/**
	 * Return the value associated with the column: file_type
	 */
	public java.lang.String getFileType () {
		return fileType;
	}

	/**
	 * Set the value related to the column: file_type
	 * @param fileType the file_type value
	 */
	public void setFileType (java.lang.String fileType) {
		this.fileType = fileType;
	}



	/**
	 * Return the value associated with the column: file_description
	 */
	public java.lang.String getFileDescription () {
		return fileDescription;
	}

	/**
	 * Set the value related to the column: file_description
	 * @param fileDescription the file_description value
	 */
	public void setFileDescription (java.lang.String fileDescription) {
		this.fileDescription = fileDescription;
	}



	/**
	 * Return the value associated with the column: file
	 */
	public byte[] getFile () {
		return file;
	}

	/**
	 * Set the value related to the column: file
	 * @param file the file value
	 */
	public void setFile (byte[] file) {
		this.file = file;
	}



}
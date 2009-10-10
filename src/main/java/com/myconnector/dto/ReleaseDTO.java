package com.myconnector.dto;

import java.io.Serializable;

public class ReleaseDTO implements Serializable {


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
	private java.lang.String title;
	private java.lang.String description;
	private java.lang.String instructions;
	private java.lang.String versionNumber;
	private java.util.Date createdDate;
	private java.lang.Byte ready;
	private java.lang.String keywords;


	/**
	 * Return the value associated with the column: title
	 */
	public java.lang.String getTitle () {
		return title;
	}

	/**
	 * Set the value related to the column: title
	 * @param title the title value
	 */
	public void setTitle (java.lang.String title) {
		this.title = title;
	}



	/**
	 * Return the value associated with the column: description
	 */
	public java.lang.String getDescription () {
		return description;
	}

	/**
	 * Set the value related to the column: description
	 * @param description the description value
	 */
	public void setDescription (java.lang.String description) {
		this.description = description;
	}



	/**
	 * Return the value associated with the column: instructions
	 */
	public java.lang.String getInstructions () {
		return instructions;
	}

	/**
	 * Set the value related to the column: instructions
	 * @param instructions the instructions value
	 */
	public void setInstructions (java.lang.String instructions) {
		this.instructions = instructions;
	}



	/**
	 * Return the value associated with the column: version_number
	 */
	public java.lang.String getVersionNumber () {
		return versionNumber;
	}

	/**
	 * Set the value related to the column: version_number
	 * @param versionNumber the version_number value
	 */
	public void setVersionNumber (java.lang.String versionNumber) {
		this.versionNumber = versionNumber;
	}



	/**
	 * Return the value associated with the column: created_date
	 */
	public java.util.Date getCreatedDate () {
		return createdDate;
	}

	/**
	 * Set the value related to the column: created_date
	 * @param createdDate the created_date value
	 */
	public void setCreatedDate (java.util.Date createdDate) {
		this.createdDate = createdDate;
	}



	/**
	 * Return the value associated with the column: ready
	 */
	public java.lang.Byte getReady () {
		return ready;
	}

	/**
	 * Set the value related to the column: ready
	 * @param ready the ready value
	 */
	public void setReady (java.lang.Byte ready) {
		this.ready = ready;
	}



	/**
	 * Return the value associated with the column: keywords
	 */
	public java.lang.String getKeywords () {
		return keywords;
	}

	/**
	 * Set the value related to the column: keywords
	 * @param keywords the keywords value
	 */
	public void setKeywords (java.lang.String keywords) {
		this.keywords = keywords;
	}



}
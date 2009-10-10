package com.myconnector.dto;

import java.io.Serializable;

public class TodoDTO implements Serializable {


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
	private java.lang.String description;
	private java.lang.Integer level;
	private java.util.Date completionDate;


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
	 * Return the value associated with the column: level
	 */
	public java.lang.Integer getLevel () {
		return level;
	}

	/**
	 * Set the value related to the column: level
	 * @param level the level value
	 */
	public void setLevel (java.lang.Integer level) {
		this.level = level;
	}



	/**
	 * Return the value associated with the column: completion_date
	 */
	public java.util.Date getCompletionDate () {
		return completionDate;
	}

	/**
	 * Set the value related to the column: completion_date
	 * @param completionDate the completion_date value
	 */
	public void setCompletionDate (java.util.Date completionDate) {
		this.completionDate = completionDate;
	}



}
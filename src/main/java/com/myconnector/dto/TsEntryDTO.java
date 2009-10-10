package com.myconnector.dto;

import java.io.Serializable;

public class TsEntryDTO implements Serializable {


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
	private java.math.BigDecimal hours;
	private java.util.Date dateTimeStart;
	private java.util.Date dateOccur;
	private java.lang.String description;


	/**
	 * Return the value associated with the column: hours
	 */
	public java.math.BigDecimal getHours () {
		return hours;
	}

	/**
	 * Set the value related to the column: hours
	 * @param hours the hours value
	 */
	public void setHours (java.math.BigDecimal hours) {
		this.hours = hours;
	}



	/**
	 * Return the value associated with the column: date_time_start
	 */
	public java.util.Date getDateTimeStart () {
		return dateTimeStart;
	}

	/**
	 * Set the value related to the column: date_time_start
	 * @param dateTimeStart the date_time_start value
	 */
	public void setDateTimeStart (java.util.Date dateTimeStart) {
		this.dateTimeStart = dateTimeStart;
	}



	/**
	 * Return the value associated with the column: date_occur
	 */
	public java.util.Date getDateOccur () {
		return dateOccur;
	}

	/**
	 * Set the value related to the column: date_occur
	 * @param dateOccur the date_occur value
	 */
	public void setDateOccur (java.util.Date dateOccur) {
		this.dateOccur = dateOccur;
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



}
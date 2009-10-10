package com.myconnector.dto;

import java.io.Serializable;

public class BookmarkDTO implements Serializable {


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
	private java.lang.String url;
	private java.lang.String title;
	private java.lang.String folder;
	private java.lang.String description;
	private java.util.Date addDate;
	private java.util.Date lastVisit;
	private java.lang.Integer viewable;
	private java.lang.String keywords;


	/**
	 * Return the value associated with the column: url
	 */
	public java.lang.String getUrl () {
		return url;
	}

	/**
	 * Set the value related to the column: url
	 * @param url the url value
	 */
	public void setUrl (java.lang.String url) {
		this.url = url;
	}



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
	 * Return the value associated with the column: folder
	 */
	public java.lang.String getFolder () {
		return folder;
	}

	/**
	 * Set the value related to the column: folder
	 * @param folder the folder value
	 */
	public void setFolder (java.lang.String folder) {
		this.folder = folder;
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
	 * Return the value associated with the column: add_date
	 */
	public java.util.Date getAddDate () {
		return addDate;
	}

	/**
	 * Set the value related to the column: add_date
	 * @param addDate the add_date value
	 */
	public void setAddDate (java.util.Date addDate) {
		this.addDate = addDate;
	}



	/**
	 * Return the value associated with the column: last_visit
	 */
	public java.util.Date getLastVisit () {
		return lastVisit;
	}

	/**
	 * Set the value related to the column: last_visit
	 * @param lastVisit the last_visit value
	 */
	public void setLastVisit (java.util.Date lastVisit) {
		this.lastVisit = lastVisit;
	}



	/**
	 * Return the value associated with the column: viewable
	 */
	public java.lang.Integer getViewable () {
		return viewable;
	}

	/**
	 * Set the value related to the column: viewable
	 * @param viewable the viewable value
	 */
	public void setViewable (java.lang.Integer viewable) {
		this.viewable = viewable;
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
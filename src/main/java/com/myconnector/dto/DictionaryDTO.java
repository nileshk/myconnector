package com.myconnector.dto;

import java.io.Serializable;

public class DictionaryDTO implements Serializable {


	protected int hashCode = Integer.MIN_VALUE;



	// primary key
	private java.lang.String word;


	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="assigned"
     *  column="word"
     */
	public java.lang.String getWord () {
		return word;
	}

	/**
	 * Set the unique identifier of this class
	 * @param word the new ID
	 */
	public void setWord (java.lang.String word) {
		this.word = word;
		this.hashCode = Integer.MIN_VALUE;
	}



	// fields
	private java.lang.String def;


	/**
	 * Return the value associated with the column: def
	 */
	public java.lang.String getDef () {
		return def;
	}

	/**
	 * Set the value related to the column: def
	 * @param def the def value
	 */
	public void setDef (java.lang.String def) {
		this.def = def;
	}



}
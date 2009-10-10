package com.myconnector.domain.base;

import java.io.Serializable;
import com.myconnector.dto.TsCustomerDTO;



/**
 * This is an object that contains data related to the ts_customer table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="ts_customer"
 */

public abstract class BaseTsCustomer extends TsCustomerDTO implements Serializable {

	public static String REF = "TsCustomer";
	public static String PROP_NAME = "name";
	public static String PROP_ABBREVIATION = "abbreviation";


	// constructors
	public BaseTsCustomer () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseTsCustomer (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseTsCustomer (
		java.lang.String id,
		java.lang.String name,
		java.lang.String abbreviation) {

		this.setId(id);
		this.setName(name);
		this.setAbbreviation(abbreviation);
		initialize();
	}

	protected void initialize () {}



	//private int hashCode = Integer.MIN_VALUE;

	// primary key
	//private java.lang.String id;

	// fields
	//private java.lang.String name;
	//private java.lang.String abbreviation;










	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.myconnector.domain.TsCustomer)) return false;
		else {
			com.myconnector.domain.TsCustomer tsCustomer = (com.myconnector.domain.TsCustomer) obj;
			if (null == this.getId() || null == tsCustomer.getId()) return false;
			else return (this.getId().equals(tsCustomer.getId()));
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
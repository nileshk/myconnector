package com.myconnector.domain.base;

import java.io.Serializable;
import com.myconnector.dto.TsActivityDTO;



/**
 * This is an object that contains data related to the ts_activity table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="ts_activity"
 */

public abstract class BaseTsActivity extends TsActivityDTO implements Serializable {

	public static String REF = "TsActivity";
	public static String PROP_NAME = "name";
	public static String PROP_DESCRIPTION = "description";


	// constructors
	public BaseTsActivity () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseTsActivity (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseTsActivity (
		java.lang.String id,
		java.lang.String name,
		java.lang.String description) {

		this.setId(id);
		this.setName(name);
		this.setDescription(description);
		initialize();
	}

	protected void initialize () {}



	//private int hashCode = Integer.MIN_VALUE;

	// primary key
	//private java.lang.String id;

	// fields
	//private java.lang.String name;
	//private java.lang.String description;

	// many to one
	private com.myconnector.domain.TsCustomer defaultCustomer;








	/**
	 * Return the value associated with the column: DEFAULT_CUSTOMER_ID
	 */
	public com.myconnector.domain.TsCustomer getDefaultCustomer () {
		return defaultCustomer;
	}

	/**
	 * Set the value related to the column: DEFAULT_CUSTOMER_ID
	 * @param defaultCustomer the DEFAULT_CUSTOMER_ID value
	 */
	public void setDefaultCustomer (com.myconnector.domain.TsCustomer defaultCustomer) {
		this.defaultCustomer = defaultCustomer;
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.myconnector.domain.TsActivity)) return false;
		else {
			com.myconnector.domain.TsActivity tsActivity = (com.myconnector.domain.TsActivity) obj;
			if (null == this.getId() || null == tsActivity.getId()) return false;
			else return (this.getId().equals(tsActivity.getId()));
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
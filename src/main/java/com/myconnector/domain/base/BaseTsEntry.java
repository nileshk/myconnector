package com.myconnector.domain.base;

import java.io.Serializable;
import com.myconnector.dto.TsEntryDTO;



/**
 * This is an object that contains data related to the ts_entry table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="ts_entry"
 */

public abstract class BaseTsEntry extends TsEntryDTO implements Serializable {

	public static String REF = "TsEntry";
	public static String PROP_HOURS = "hours";
	public static String PROP_DATE_TIME_START = "dateTimeStart";
	public static String PROP_DATE_OCCUR = "dateOccur";
	public static String PROP_DESCRIPTION = "description";


	// constructors
	public BaseTsEntry () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseTsEntry (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseTsEntry (
		java.lang.String id,
		com.myconnector.domain.UserData user,
		com.myconnector.domain.TsActivity activity,
		java.lang.String description) {

		this.setId(id);
		this.setUser(user);
		this.setActivity(activity);
		this.setDescription(description);
		initialize();
	}

	protected void initialize () {}



	//private int hashCode = Integer.MIN_VALUE;

	// primary key
	//private java.lang.String id;

	// fields
	//private java.math.BigDecimal hours;
	//private java.util.Date dateTimeStart;
	//private java.util.Date dateOccur;
	//private java.lang.String description;

	// many to one
	private com.myconnector.domain.UserData user;
	private com.myconnector.domain.TsActivity activity;
	private com.myconnector.domain.TsCustomer customer;








	/**
	 * Return the value associated with the column: USER_ID
	 */
	public com.myconnector.domain.UserData getUser () {
		return user;
	}

	/**
	 * Set the value related to the column: USER_ID
	 * @param user the USER_ID value
	 */
	public void setUser (com.myconnector.domain.UserData user) {
		this.user = user;
	}



	/**
	 * Return the value associated with the column: ACTIVITY_ID
	 */
	public com.myconnector.domain.TsActivity getActivity () {
		return activity;
	}

	/**
	 * Set the value related to the column: ACTIVITY_ID
	 * @param activity the ACTIVITY_ID value
	 */
	public void setActivity (com.myconnector.domain.TsActivity activity) {
		this.activity = activity;
	}



	/**
	 * Return the value associated with the column: CUSTOMER_ID
	 */
	public com.myconnector.domain.TsCustomer getCustomer () {
		return customer;
	}

	/**
	 * Set the value related to the column: CUSTOMER_ID
	 * @param customer the CUSTOMER_ID value
	 */
	public void setCustomer (com.myconnector.domain.TsCustomer customer) {
		this.customer = customer;
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.myconnector.domain.TsEntry)) return false;
		else {
			com.myconnector.domain.TsEntry tsEntry = (com.myconnector.domain.TsEntry) obj;
			if (null == this.getId() || null == tsEntry.getId()) return false;
			else return (this.getId().equals(tsEntry.getId()));
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
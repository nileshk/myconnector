package com.myconnector.domain.base;

import java.io.Serializable;
import com.myconnector.dto.TodoDTO;



/**
 * This is an object that contains data related to the todo table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="todo"
 */

public abstract class BaseTodo extends TodoDTO implements Serializable {

	public static String REF = "Todo";
	public static String PROP_DESCRIPTION = "description";
	public static String PROP_LEVEL = "level";
	public static String PROP_COMPLETION_DATE = "completionDate";


	// constructors
	public BaseTodo () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseTodo (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseTodo (
		java.lang.String id,
		com.myconnector.domain.UserData userData,
		java.lang.String description) {

		this.setId(id);
		this.setUserData(userData);
		this.setDescription(description);
		initialize();
	}

	protected void initialize () {}



	//private int hashCode = Integer.MIN_VALUE;

	// primary key
	//private java.lang.String id;

	// fields
	//private java.lang.String description;
	//private java.lang.Integer level;
	//private java.util.Date completionDate;

	// many to one
	private com.myconnector.domain.UserData userData;








	/**
	 * Return the value associated with the column: USER_ID
	 */
	public com.myconnector.domain.UserData getUserData () {
		return userData;
	}

	/**
	 * Set the value related to the column: USER_ID
	 * @param userData the USER_ID value
	 */
	public void setUserData (com.myconnector.domain.UserData userData) {
		this.userData = userData;
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.myconnector.domain.Todo)) return false;
		else {
			com.myconnector.domain.Todo todo = (com.myconnector.domain.Todo) obj;
			if (null == this.getId() || null == todo.getId()) return false;
			else return (this.getId().equals(todo.getId()));
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
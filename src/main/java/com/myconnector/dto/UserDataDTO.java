package com.myconnector.dto;

import java.io.Serializable;

public class UserDataDTO implements Serializable {


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
	private java.lang.String userLogin;
	private java.lang.String userPassword;
	private byte securityLevel;


	/**
	 * Return the value associated with the column: user_login
	 */
	public java.lang.String getUserLogin () {
		return userLogin;
	}

	/**
	 * Set the value related to the column: user_login
	 * @param userLogin the user_login value
	 */
	public void setUserLogin (java.lang.String userLogin) {
		this.userLogin = userLogin;
	}



	/**
	 * Return the value associated with the column: user_password
	 */
	public java.lang.String getUserPassword () {
		return userPassword;
	}

	/**
	 * Set the value related to the column: user_password
	 * @param userPassword the user_password value
	 */
	public void setUserPassword (java.lang.String userPassword) {
		this.userPassword = userPassword;
	}



	/**
	 * Return the value associated with the column: security_level
	 */
	public byte getSecurityLevel () {
		return securityLevel;
	}

	/**
	 * Set the value related to the column: security_level
	 * @param securityLevel the security_level value
	 */
	public void setSecurityLevel (byte securityLevel) {
		this.securityLevel = securityLevel;
	}



}
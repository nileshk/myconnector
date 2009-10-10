package com.myconnector.dto;

import java.io.Serializable;

public class ReleaseFileXrefDTO implements Serializable {


	protected int hashCode = Integer.MIN_VALUE;



	// primary key
	private com.myconnector.domain.ReleaseFileXrefPK comp_id;


	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     */
	public com.myconnector.domain.ReleaseFileXrefPK getComp_id () {
		return comp_id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param comp_id the new ID
	 */
	public void setComp_id (com.myconnector.domain.ReleaseFileXrefPK comp_id) {
		this.comp_id = comp_id;
		this.hashCode = Integer.MIN_VALUE;
	}




}
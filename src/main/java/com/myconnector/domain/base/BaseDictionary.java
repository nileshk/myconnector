package com.myconnector.domain.base;

import java.io.Serializable;
import com.myconnector.dto.DictionaryDTO;



/**
 * This is an object that contains data related to the dictionary table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="dictionary"
 */

public abstract class BaseDictionary extends DictionaryDTO implements Serializable {

	public static String REF = "Dictionary";
	public static String PROP_DEF = "def";


	// constructors
	public BaseDictionary () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseDictionary (java.lang.String word) {
		this.setWord(word);
		initialize();
	}

	protected void initialize () {}



	//private int hashCode = Integer.MIN_VALUE;

	// primary key
	//private java.lang.String word;

	// fields
	//private java.lang.String def;










	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.myconnector.domain.Dictionary)) return false;
		else {
			com.myconnector.domain.Dictionary dictionary = (com.myconnector.domain.Dictionary) obj;
			if (null == this.getWord() || null == dictionary.getWord()) return false;
			else return (this.getWord().equals(dictionary.getWord()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getWord()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getWord().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}
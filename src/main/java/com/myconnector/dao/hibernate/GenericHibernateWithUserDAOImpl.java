package com.myconnector.dao.hibernate;

import java.io.Serializable;
import java.util.List;

public abstract class GenericHibernateWithUserDAOImpl <T extends Serializable, KeyType extends Serializable>
extends AbstractHibernateDAOImpl<T, KeyType> {

	@SuppressWarnings("unchecked")
	public List<T> getListForUser(String userId) {
		return (getHibernateTemplate().find("from " + domainClass.getName() + " x where x.userData.id = ?", userId));
	}
	
}

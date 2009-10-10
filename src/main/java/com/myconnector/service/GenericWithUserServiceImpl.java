package com.myconnector.service;

import java.io.Serializable;
import java.util.List;

import com.myconnector.dao.GenericWithUserDAO;
import com.myconnector.exception.MessageException;
import com.myconnector.util.CommonThreadLocal;

public abstract class GenericWithUserServiceImpl<T extends Serializable, KeyType extends Serializable>
extends GenericServiceImpl<T, KeyType> implements GenericWithUserService<T, KeyType> {

	public List<T> getListForCurrentUser() {
		if(getGenericDAO() instanceof GenericWithUserDAO) {
			String userId = CommonThreadLocal.getUserId();
			GenericWithUserDAO dao = (GenericWithUserDAO) getGenericDAO();
			return dao.getListForUser(userId);
		} else {
			throw new MessageException("exception.method.userNotSupported");
		}
	}
	
}

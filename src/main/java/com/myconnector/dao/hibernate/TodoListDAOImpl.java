package com.myconnector.dao.hibernate;

import com.myconnector.dao.TodoListDAO;
import com.myconnector.domain.TodoList;

public class TodoListDAOImpl extends GenericHibernateWithUserDAOImpl<TodoList, String> implements TodoListDAO {

	@Override
	protected Class<TodoList> getDomainClass() {
		return TodoList.class;
	}

}

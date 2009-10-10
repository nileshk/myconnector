package com.myconnector.service;

import com.myconnector.dao.AbstractDAO;
import com.myconnector.dao.TodoListDAO;
import com.myconnector.domain.TodoList;

public class TodoListServiceImpl extends GenericWithUserServiceImpl<TodoList, String> implements TodoListService {

	private TodoListDAO todoListDAO;

	@Override
	protected AbstractDAO<TodoList, String> getGenericDAO() {
		return todoListDAO;
	}

	public void setTodoListDAO(TodoListDAO todoListDAO) {
		this.todoListDAO = todoListDAO;
	}
}

package com.myconnector.service;

import com.myconnector.dao.AbstractDAO;
import com.myconnector.dao.TodoItemDAO;
import com.myconnector.domain.TodoItem;

public class TodoItemServiceImpl extends GenericWithUserServiceImpl<TodoItem, String> implements TodoItemService {

	private TodoItemDAO todoListDAO;

	@Override
	protected AbstractDAO<TodoItem, String> getGenericDAO() {
		return todoListDAO;
	}

	public void setTodoItemDAO(TodoItemDAO todoListDAO) {
		this.todoListDAO = todoListDAO;
	}
}

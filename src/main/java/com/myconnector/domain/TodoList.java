package com.myconnector.domain;

import java.io.Serializable;
import java.util.Set;

import com.myconnector.domain.interfaces.HasUserData;

public class TodoList implements Serializable, HasUserData {

	private String id;
	private String title;
	private UserData userData;
	private Set<TodoItem> todoItems;
	
	private static final long serialVersionUID = 1L;
	protected int hashCode = Integer.MIN_VALUE;

	
	public TodoList() {
		super();
	}

	public TodoList(String id) {
		this.setId(id);
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof TodoList))
			return false;
		else {
			TodoList todo = (TodoList) obj;
			if (null == this.getId() || null == todo.getId())
				return false;
			else
				return (this.getId().equals(todo.getId()));
		}
	}

	public int hashCode() {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId())
				return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":"
						+ this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}

	public String toString() {
		return super.toString();
	}	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}

	public UserData getUserData() {
		return userData;
	}

	public void setUserData(UserData userData) {
		this.userData = userData;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Set<TodoItem> getTodoItems() {
		return todoItems;
	}

	public void setTodoItems(Set<TodoItem> todoItems) {
		this.todoItems = todoItems;
	}

}
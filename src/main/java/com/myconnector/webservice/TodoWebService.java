package com.myconnector.webservice;

import com.myconnector.dto.TodoDTO;

public interface TodoWebService extends BaseWS {
    
    public TodoDTO getTodo(String id);
    public void saveTodo(TodoDTO todo);
    public void updateTodo(TodoDTO todo);
    public void deleteTodoById(String id);
    public TodoDTO[] getTodoList();
    public TodoDTO[] getTodoListSortedBy(String orderBy, boolean descending);    

}

package com.myconnector.service;

import java.util.List;

import com.myconnector.domain.Todo;

/** 
 *
 * @author Nilesh Kapadia (nileshka@gmail.com)
 */
public interface TodoService extends OldGenericService, OldGenericExtraService {
   
    public Todo getTodoById(String id);
    
    public void updateTodoDTO(com.myconnector.dto.TodoDTO todo);
    
    public void update(Todo todo);

    public void save(Todo todo);
        
    public List<Todo> getListByCurrentUser();
    
    public List<Todo> getListByCurrentUser(String orderBy, boolean descending);
    
    public List<Todo> getListByUserId(String userId);
    
    public List<Todo> getListByUserId(String userId, String orderBy, boolean descending);
}

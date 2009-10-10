package com.myconnector.dao;

import java.util.List;

import com.myconnector.domain.Todo;

/**
 * DAO for todo table
 * 
 * @author Nilesh Kapadia (nileshka@gmail.com)
 */
public interface TodoDAO {

    public Todo load(String id);
    
    public void update(Todo todo);

    public void save(Todo todo);

    public void delete(Todo todo);
    
    public void deleteById(String id);

    public List<Todo> getList();
    
    public List<Todo> getListByUserId(String userId);
    
    public List<Todo> getListByUserId(String userId, String orderBy, boolean descending);
}
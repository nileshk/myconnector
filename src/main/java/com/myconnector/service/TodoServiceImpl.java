package com.myconnector.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;

import com.myconnector.dao.TodoDAO;
import com.myconnector.dao.UserDataDAO;
import com.myconnector.domain.Todo;
import com.myconnector.domain.UserData;
import com.myconnector.util.CommonThreadLocal;

/**
 * 
 * @author Nilesh Kapadia (nileshka@gmail.com)
 */
public class TodoServiceImpl implements TodoService {

    Logger logger = Logger.getLogger(TodoServiceImpl.class);
    
    TodoDAO todoDAO;

    UserDataDAO userDataDAO;

    public void setTodoDAO(TodoDAO todoDAO) {
        this.todoDAO = todoDAO;
    }

    public void setUserDataDAO(UserDataDAO userDataDAO) {
        this.userDataDAO = userDataDAO;
    }

    public void update(Todo todo) {
        todoDAO.update(todo);
    }

    public void save(Todo todo) {
        String userId = CommonThreadLocal.getUserId();
        logger.debug("userId:" + userId);
        UserData userData = userDataDAO.load(userId);
        todo.setUserData(userData);
        todoDAO.save(todo);
    }

    public void deleteById(String id) {
        todoDAO.deleteById(id);
    }

    public List<Todo> getList() {
        return todoDAO.getList();
    }

    public List<Todo> getListByCurrentUser() {
        return todoDAO.getListByUserId(CommonThreadLocal.getUserId());
    }

    public List<Todo> getListByCurrentUser(String orderBy, boolean descending) {
        return todoDAO.getListByUserId(CommonThreadLocal.getUserId(), orderBy, descending);
    }
    
    
    public List<Todo> getListByUserId(String userId) {
        return todoDAO.getListByUserId(userId);
    }

    public Todo getTodoById(String id) {
        return todoDAO.load(id);
    }

    public void updateTodoDTO(com.myconnector.dto.TodoDTO todo) {
        Todo todoCurrent = todoDAO.load(todo.getId());        
        try {
            BeanUtils.copyProperties(todoCurrent, todo);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        todoDAO.update(todoCurrent);
    }

    public List<Todo> getListByUserId(String userId, String orderBy, boolean descending) {
        return todoDAO.getListByUserId(userId, orderBy, descending);
    }

    public Object getById(String id) {
        return getTodoById(id);
    }

    public void save(Object obj) {
        save((Todo)obj);
    }

    public void update(Object obj) {
        update((Todo)obj);
    }

}
package com.myconnector.webservice;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.myconnector.dto.TodoDTO;
import com.myconnector.service.TodoService;

public class TodoWebServiceImpl extends BaseWSImpl implements TodoWebService {

    TodoService getTodoService() {
        return (TodoService) ctx.getBean("todoService");
    }

    public void saveTodo(TodoDTO todo) {
        try {
            com.myconnector.domain.Todo todoIn = new com.myconnector.domain.Todo();
            BeanUtils.copyProperties(todo, todoIn);
            getTodoService().save(todoIn);
        } catch (Exception ex) {
            throw handleException(ex);
        }
    }

    public void updateTodo(TodoDTO todo) {
        try {
            getTodoService().updateTodoDTO(todo);
        } catch (Exception ex) {
            throw handleException(ex);
        }
    }

    public void deleteTodoById(String id) {
        try {
            getTodoService().deleteById(id);
        } catch (Exception ex) {
            throw handleException(ex);
        }
    }

    public TodoDTO[] getTodoList() {
        try {
            List list = getTodoService().getListByCurrentUser();
            TodoDTO[] todo = new TodoDTO[list.size()];
            Iterator it = list.iterator();
            int i = 0;
            while (it.hasNext()) {
                todo[i++] = (TodoDTO) it.next();
            }
            return todo;
        } catch (Exception ex) {
            throw handleException(ex);
        }

    }

    public TodoDTO getTodo(String id) {
        try {
            return getTodoService().getTodoById(id);
        } catch (Exception ex) {
            throw handleException(ex);
        }

    }

    public TodoDTO[] getTodoListSortedBy(String orderBy, boolean descending) {
        try {
            List list = getTodoService().getListByCurrentUser(orderBy, descending);
            TodoDTO[] todo = new TodoDTO[list.size()];
            list.toArray(todo);
            return todo;            
        } catch (Exception ex) {
            throw handleException(ex);
        }
    }    
    
}

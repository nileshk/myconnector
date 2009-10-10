/*
 * Created on Aug 28, 2004
 *
 */
package com.myconnector.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.myconnector.domain.Todo;
import com.myconnector.service.TodoService;

/**
 * 
 * @author Nilesh Kapadia (nileshka@gmail.com)
 */
public class TodoListAdvancedController implements Controller {

    static Logger logger = Logger.getLogger(TodoListAdvancedController.class);

    private TodoService todoService;

    protected String view;

    protected String listName = "list";

    public void setListName(String listName) {
        this.listName = listName;
    }

    public void setView(String view) {
        this.view = view;
    }

    /**
     * @param todoService
     *            The genericService to set.
     */
    public void setTodoService(TodoService todoService) {
        this.todoService = todoService;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.web.servlet.mvc.Controller#handleRequest(javax.servlet.http.HttpServletRequest,
     *      javax.servlet.http.HttpServletResponse)
     */
    public ModelAndView handleRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        List<Todo> list = todoService.getListByCurrentUser("level", false);
        Map model = new HashMap();
        model.put(listName, list);
        Map<Integer, List<Todo>> map = new HashMap<Integer, List<Todo>>();
        for (Todo todo : list) {            
            if(todo.getLevel() != null) {
                List<Todo> listToAddTo;
                if(!map.containsKey(todo.getLevel())) {
                    listToAddTo = new ArrayList<Todo>();
                    map.put(todo.getLevel(), listToAddTo);
                } else {
                    listToAddTo = map.get(todo.getLevel());
                }
                listToAddTo.add(todo);
            }
        }
        model.put("todoListMap", map);
        return new ModelAndView(view, model);
    }
}
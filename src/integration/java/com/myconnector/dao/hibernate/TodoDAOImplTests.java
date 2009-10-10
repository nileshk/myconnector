package com.myconnector.dao.hibernate;

import java.util.Date;

import com.myconnector.dao.BaseDAOTests;
import com.myconnector.dao.TodoDAO;
import com.myconnector.domain.Todo;


/** 
 *
 * @author Nilesh Kapadia (nileshka@gmail.com)
 */
public class TodoDAOImplTests extends BaseDAOTests {

    TodoDAO dao;
    
    protected void onSetUpInTransaction() throws Exception {
        super.onSetUpInTransaction();
        dao = (TodoDAO) applicationContext.getBean("todoDAO");
    }
    
    public void testSave() {
        Todo todo = new Todo();
        todo.setDescription("my description");
        todo.setCompletionDate(new Date());
        todo.setLevel(new Integer(0));        
        dao.save(todo);
    }
    
}

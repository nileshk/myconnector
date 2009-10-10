package com.myconnector.dao.hibernate;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.myconnector.dao.TodoDAO;
import com.myconnector.domain.Todo;

/**
 * 
 * @author Nilesh Kapadia (nileshka@gmail.com)
 */
public class TodoDAOImpl extends HibernateDaoSupport implements TodoDAO {

    public Todo load(String id) {
        return (Todo) getHibernateTemplate().load(Todo.class, id);
    }

    public void update(Todo todo) {
        getHibernateTemplate().update(todo);
    }

    public void save(Todo todo) {
        getHibernateTemplate().save(todo);
    }

    public void delete(Todo todo) {
        getHibernateTemplate().delete(todo);
    }

    public void deleteById(String id) {
    	Object obj = load(id);
        getHibernateTemplate().delete(obj);
    }

    public List<Todo> getList() {
        return (getHibernateTemplate().find("from com.myconnector.domain.Todo x"));
    }

    public List<Todo> getListByUserId(String userId) {
        return (getHibernateTemplate().find(
                "from com.myconnector.domain.Todo x where x.userData.id = ? " +
                "order by x.level asc", userId));
    }

    public List<Todo> getListByUserId(String userId, String orderBy, boolean descending) {        
        if (orderBy.equals("description") || orderBy.equals("level")
                || orderBy.equals("completionDate")) {
        } else {
            throw new RuntimeException("invalid orderBy value");
        }
        String direction = descending ? "desc" : "asc";

        return (getHibernateTemplate().find(
                "from com.myconnector.domain.Todo x where x.userData.id = ? " +
                "order by x." + orderBy + " " + direction, userId));
    }

}
/*
 * Created on Aug 9, 2004
 *
 */
package com.myconnector.webservice;

import java.rmi.RemoteException;
import java.util.Iterator;
import java.util.List;

import org.apache.axis.AxisFault;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;

import com.myconnector.domain.Dictionary;
import com.myconnector.dto.DictionaryDTO;
import com.myconnector.dto.TodoDTO;
import com.myconnector.service.DictionaryService;
import com.myconnector.service.TodoService;

/**
 * @author Nilesh Kapadia (nileshka@gmail.com)
 */
public class DictionaryWSImpl extends BaseWSImpl implements DictionaryWS {

    static Logger logger = Logger.getLogger(DictionaryWSImpl.class);

    protected DictionaryService dictionaryService;
    
    public void setDictionaryService(DictionaryService dictionaryService) {
        this.dictionaryService = dictionaryService;
    }

    /*
     * @see com.myconnector.webservice.AboutWS#loadDictionary(java.lang.String)
     */
    public DictionaryDTO getDictionary(String id) throws RemoteException {
        try {
            return (dictionaryService.getDictionaryById(id));
        } catch (Exception ex) {
            throw handleException(ex);
        }
    }

    /*
     * @see com.myconnector.webservice.AboutWS#saveDictionary(com.myconnector.domain.Dictionary)
     */
    public void saveDictionary(DictionaryDTO dictionary) throws RemoteException {
        try {
            Dictionary dictionaryIn = new Dictionary();;
            BeanUtils.copyProperties(dictionary, dictionaryIn);
            dictionaryService.save(dictionaryIn);
        } catch (Exception ex) {
            throw handleException(ex);
        }
    }

    /*
     * @see com.myconnector.webservice.DictionaryWS#deleteDictionary(java.lang.String)
     */
    public void deleteDictionary(String id) throws RemoteException {
        try {
            dictionaryService.deleteById(id);
        } catch (Exception ex) {
            throw handleException(ex);
        }
    }

    /*
     * @see com.myconnector.webservice.DictionaryWS#loadDictionaryList()
     */
    public DictionaryDTO[] getDictionaryList() throws RemoteException, AxisFault {
        try {
            List list = dictionaryService.getList();
            DictionaryDTO[] dictionaryArray = new DictionaryDTO[list.size()];
            list.toArray(dictionaryArray);
            return (dictionaryArray);
        } catch (Exception ex) {
            throw handleException(ex);
        }
    }

    /*
     * @see com.myconnector.webservice.DictionaryWS#saveDictionaryList(com.myconnector.domain.Dictionary[])
     */
    public void saveDictionaryList(DictionaryDTO[] dictionaryArray) throws RemoteException, AxisFault {
        try {
            for (int i = 0; i < dictionaryArray.length; i++) {
                Dictionary dictionaryIn = new Dictionary();;
                BeanUtils.copyProperties(dictionaryArray[i], dictionaryIn);
                dictionaryService.save(dictionaryIn);
            }
        } catch (Exception ex) {
            throw handleException(ex);
        }
    }

    TodoService getTodoService() {
        return (TodoService) ctx.getBean("todoService");
    }

    public void saveTodo(TodoDTO todo) throws AxisFault {
        try {
            com.myconnector.domain.Todo todoIn = new com.myconnector.domain.Todo();
            BeanUtils.copyProperties(todo, todoIn);
            getTodoService().save(todoIn);
        } catch (Exception ex) {
            throw handleException(ex);
        }
    }

    public void updateTodo(TodoDTO todo) throws AxisFault {
        try {
            getTodoService().updateTodoDTO(todo);
        } catch (Exception ex) {
            throw handleException(ex);
        }
    }

    public void deleteTodoById(String id) throws AxisFault {
        try {
            getTodoService().deleteById(id);
        } catch (Exception ex) {
            throw handleException(ex);
        }
    }

    public TodoDTO[] getTodoList() throws AxisFault {
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

    public TodoDTO getTodo(String id) throws AxisFault {
        try {
            return getTodoService().getTodoById(id);
        } catch (Exception ex) {
            throw handleException(ex);
        }

    }

    public TodoDTO[] getTodoListSortedBy(String orderBy, boolean descending) throws AxisFault {
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
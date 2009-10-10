/*
 * Created on Aug 9, 2004
 *
 */
package com.myconnector.webservice;

import java.rmi.RemoteException;

import org.apache.axis.AxisFault;

import com.myconnector.dto.DictionaryDTO;
import com.myconnector.dto.TodoDTO;

/**
 * @author Nilesh
 */
public interface DictionaryWS extends BaseWS {
    
    public DictionaryDTO getDictionary(String word) throws RemoteException;
    public DictionaryDTO[] getDictionaryList() throws RemoteException, AxisFault;
    public void saveDictionary(DictionaryDTO dictionary) throws RemoteException;
    public void saveDictionaryList(DictionaryDTO[] dictionaryArray) throws RemoteException, AxisFault;
    public void deleteDictionary(String id) throws RemoteException;    

    public TodoDTO getTodo(String id) throws AxisFault;
    public void saveTodo(TodoDTO todo) throws AxisFault;
    public void updateTodo(TodoDTO todo) throws AxisFault;
    public void deleteTodoById(String id) throws AxisFault;
    public TodoDTO[] getTodoList() throws AxisFault;
    public TodoDTO[] getTodoListSortedBy(String orderBy, boolean descending) throws AxisFault;
}
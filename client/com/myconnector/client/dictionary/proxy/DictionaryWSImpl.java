/**
 * DictionaryWSImpl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC3 Feb 28, 2005 (10:15:14 EST) WSDL2Java emitter.
 */

package com.myconnector.client.dictionary.proxy;

public interface DictionaryWSImpl extends java.rmi.Remote {
    public com.myconnector.client.dictionary.proxy.Dictionary getDictionary(java.lang.String id) throws java.rmi.RemoteException;
    public void saveDictionary(com.myconnector.client.dictionary.proxy.Dictionary dictionary) throws java.rmi.RemoteException;
    public void deleteDictionary(java.lang.String id) throws java.rmi.RemoteException;
    public com.myconnector.client.dictionary.proxy.Dictionary[] getDictionaryList() throws java.rmi.RemoteException;
    public void saveDictionaryList(com.myconnector.client.dictionary.proxy.Dictionary[] dictionaryArray) throws java.rmi.RemoteException;
    public void saveTodo(com.myconnector.client.dictionary.proxy.Todo todo) throws java.rmi.RemoteException;
    public void updateTodo(com.myconnector.client.dictionary.proxy.Todo todo) throws java.rmi.RemoteException;
    public void deleteTodoById(java.lang.String id) throws java.rmi.RemoteException;
    public com.myconnector.client.dictionary.proxy.Todo[] getTodoList() throws java.rmi.RemoteException;
    public com.myconnector.client.dictionary.proxy.Todo getTodo(java.lang.String id) throws java.rmi.RemoteException;
    public com.myconnector.client.dictionary.proxy.Todo[] getTodoListSortedBy(java.lang.String orderBy, boolean descending) throws java.rmi.RemoteException;
    public boolean login(java.lang.String username, java.lang.String password) throws java.rmi.RemoteException;
    public void logout() throws java.rmi.RemoteException;
    public java.lang.String getLoggedUsername() throws java.rmi.RemoteException;
    public java.lang.String getHttpSessionId() throws java.rmi.RemoteException;
}

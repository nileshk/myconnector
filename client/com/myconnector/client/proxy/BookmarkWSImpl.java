/**
 * BookmarkWSImpl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC3 Feb 28, 2005 (10:15:14 EST) WSDL2Java emitter.
 */

package com.myconnector.client.proxy;

public interface BookmarkWSImpl extends java.rmi.Remote {
    public com.myconnector.client.proxy.BookmarkDTO loadBookmark(java.lang.String id) throws java.rmi.RemoteException;
    public void saveBookmark(java.lang.String url, java.lang.String title, java.lang.String folder, java.lang.String description, java.util.Calendar addDate, java.util.Calendar lastVisit) throws java.rmi.RemoteException;
    public void deleteBookmark(java.lang.String id) throws java.rmi.RemoteException;
    public void saveBookmarkList(com.myconnector.client.proxy.BookmarkDTO[] bookmarkArray) throws java.rmi.RemoteException;
    public com.myconnector.client.proxy.BookmarkDTO[] loadBookmarkList() throws java.rmi.RemoteException;
    public boolean login(java.lang.String username, java.lang.String password) throws java.rmi.RemoteException;
    public void logout() throws java.rmi.RemoteException;
    public java.lang.String getLoggedUsername() throws java.rmi.RemoteException;
    public java.lang.String getHttpSessionId() throws java.rmi.RemoteException;
}

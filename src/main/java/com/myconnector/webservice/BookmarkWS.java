/*
 * Created on Aug 9, 2004
 *
 */
package com.myconnector.webservice;

import java.rmi.RemoteException;
import java.util.Date;

import org.apache.axis.AxisFault;

import com.myconnector.dto.BookmarkDTO;

/**
 * @author Nilesh
 */
public interface BookmarkWS extends BaseWS {

    public BookmarkDTO loadBookmark(String id) throws RemoteException;

    public BookmarkDTO[] loadBookmarkList() throws RemoteException, AxisFault;

    // public void saveBookmark(BookmarkDTO bookmark) throws RemoteException;
    public void saveBookmark(String url, String title, String folder, String description,
            Date addDate, Date lastVisit) throws RemoteException;

    public void saveBookmarkList(BookmarkDTO[] bookmarkArray) throws RemoteException, AxisFault;

    public void deleteBookmark(String id) throws RemoteException;
}
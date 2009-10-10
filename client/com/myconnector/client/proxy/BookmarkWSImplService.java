/**
 * BookmarkWSImplService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC3 Feb 28, 2005 (10:15:14 EST) WSDL2Java emitter.
 */

package com.myconnector.client.proxy;

public interface BookmarkWSImplService extends javax.xml.rpc.Service {
    public java.lang.String getBookmarkAddress();

    public com.myconnector.client.proxy.BookmarkWSImpl getBookmark() throws javax.xml.rpc.ServiceException;

    public com.myconnector.client.proxy.BookmarkWSImpl getBookmark(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}

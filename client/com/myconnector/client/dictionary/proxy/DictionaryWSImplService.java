/**
 * DictionaryWSImplService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC3 Feb 28, 2005 (10:15:14 EST) WSDL2Java emitter.
 */

package com.myconnector.client.dictionary.proxy;

public interface DictionaryWSImplService extends javax.xml.rpc.Service {
    public java.lang.String getDictionaryAddress();

    public com.myconnector.client.dictionary.proxy.DictionaryWSImpl getDictionary() throws javax.xml.rpc.ServiceException;

    public com.myconnector.client.dictionary.proxy.DictionaryWSImpl getDictionary(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}

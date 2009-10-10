package com.myconnector.webservice;

import org.codehaus.xfire.fault.XFireFault;

/**
 * 
 * @author Nilesh Kapadia (nileshka@gmail.com)
 */
public interface BaseWS {
    
    public boolean login(String username, String password);
    
    public void logout();
    
    public String getLoggedUsername();
    
    public String getHttpSessionId();
        
}
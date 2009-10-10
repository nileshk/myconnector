/*
 * Created on Sep 5, 2004
 *
 */
package com.myconnector.service;

import com.myconnector.domain.UserCookie;
import com.myconnector.domain.UserData;

/**
 * 
 * @author Nil
 */
public interface SecurityService {
    public UserData login(String username, String password);

    public void logout();
    
    public void logout(String cookieValue);

    /**
     * Perform login check, and re-populate CommonThreadLocal from HttpSession
     * if necessary
     * 
     * XXX Maybe we shouldn't use CommonThreadLocal and just use HttpSession
     * exclusively
     * 
     * @return
     */
    public boolean loginCheck();

    public String getCurrentUser();

    /**
     * Initialize a virgin database
     * 
     * @return Return admin user if it is a virgin database, return null if it
     *         is not a virgin database
     */
    public UserData initialize();

    public UserCookie getCookie(String userId);
    
    public UserData loginWithCookie(String cookieValue);
}
package com.myconnector.service;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.orm.hibernate3.HibernateObjectRetrievalFailureException;

import com.myconnector.dao.UserCookieDAO;
import com.myconnector.dao.UserDataDAO;
import com.myconnector.domain.UserCookie;
import com.myconnector.domain.UserData;
import com.myconnector.util.CommonThreadLocal;
import com.myconnector.util.HttpSessionThreadLocal;

/**
 * 
 * @author Nil
 */
public class SecurityServiceImpl implements SecurityService {

    private Logger logger = Logger.getLogger(SecurityServiceImpl.class);

    private UserDataDAO userDataDAO;
    private UserCookieDAO userCookieDAO;

    public void setUserDataDAO(UserDataDAO userDataDAO) {
        this.userDataDAO = userDataDAO;
    }

    public void setUserCookieDAO(UserCookieDAO userCookieDAO) {
        this.userCookieDAO = userCookieDAO;
    }

    /*
     * @see com.myconnector.service.SecurityService#login(java.lang.String,
     *      java.lang.String)
     */
    public UserData login(String username, String password) {
        UserData userData = userDataDAO.getUserByUserLogin(username);
        if (userData != null) {
            if (userData.getUserPassword().equals(password)) {
                logger.debug("Logging in as " + userData.getUserLogin());
                HttpSessionThreadLocal.setAttribute("userId", userData.getId());
                HttpSessionThreadLocal.setAttribute("username", username);
                return userData;
            }
        }
        return null;
    }

    public void logout() {
        logout(null);
    }    
    
    /*
     * @see com.myconnector.service.SecurityService#logout()
     */
    public void logout(String cookieValue) {

        if(cookieValue != null && !cookieValue.equals("")) {
            String[] cookieValueSplit = cookieValue.split(":");
            String cookieId = cookieValueSplit[0];
            String userId = cookieValueSplit[1];
            try {
                UserCookie cookie = userCookieDAO.load(cookieId);
                if(cookie != null) {
                    if(!cookie.getUserData().getId().equals(userId)) {
                        logger.fatal("Deleting a cookie whose userId doesn't match actual user in database");
                    }
                    userCookieDAO.delete(cookie);
                }
            } catch (HibernateObjectRetrievalFailureException ex) {
                logger.warn("Attempted to fetch a cookie for deletion that doesn't exist in database");
                logger.warn("cookieValue = " + cookieValue);
                logger.debug(ex);
            }            
        }
        HttpSessionThreadLocal.clear();
    }

    /*
     * @see com.myconnector.service.SecurityService#getCurrentUser()
     */
    public String getCurrentUser() {
        // TODO check HttpSession, etc.
        String username = CommonThreadLocal.getUsername();
        logger.debug("SecurityServiceImpl.getCurrentUser: " + username);
        return username;
    }

    /*
     * @see com.myconnector.service.SecurityService#initialize()
     */
    public UserData initialize() {
        if (userDataDAO.getList().isEmpty()) {
            UserData userData = new UserData();
            userData.setUserLogin("admin");
            userData.setUserPassword("admin");
            logger.debug("Setting security level 100.");
            userData.setSecurityLevel((byte) 100);
            userDataDAO.save(userData);
            return userData;
        } else {
            return null;
        }
    }

    public boolean loginCheck() {
        throw new UnsupportedOperationException(); // TODO Add code
    }

    public UserCookie getCookie(String userId) {
        UserData userData = userDataDAO.load(userId);
        UserCookie cookie = new UserCookie();
        // TODO assign id with a less predictable value
        cookie.setUserData(userData);
        cookie.setCreateDate(new Date());
        userCookieDAO.save(cookie);
        logger.debug("cookie id: " + cookie.getId());
        return cookie;
    }

    public UserData loginWithCookie(String cookieValue) {
        logger.debug("Attempting login with cookie value: " + cookieValue);
        String[] cookieValueSplit = cookieValue.split(":");
        String cookieId = cookieValueSplit[0];
        String userId = cookieValueSplit[1];
        UserCookie cookie = null;
        try {
            cookie = userCookieDAO.load(cookieId);
        } catch(HibernateObjectRetrievalFailureException ex) {
            logger.debug("Cookie not in database.");
            logger.debug(ex);
            return null;
        }
        if(cookie == null) {
            return null;
        }
        UserData user = cookie.getUserData();
        if(!user.getId().equals(userId)) {
            logger.fatal("POTENTIAL HACK ATTEMPT: FORGED COOKIE DOES NOT MATCH USER");
            logger.fatal("cookieValue: " + cookieValue);
            logger.fatal("cookie owner: " + user.getUserLogin());
            return null;
        }
        
        return user; 
    }

}
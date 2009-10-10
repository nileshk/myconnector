/*
 * Created on Aug 9, 2004
 *
 */
package com.myconnector.util;

import org.apache.log4j.Logger;

/**
 * Common class for holding ThreadLocal variables
 * 
 * @author Nilesh
 */
public class CommonThreadLocal {

    static Logger logger = Logger.getLogger(CommonThreadLocal.class);

    public static String getUsername() {
        return HttpSessionThreadLocal.getUsername();
    }

    public static String getUserId() {
        return HttpSessionThreadLocal.getUserId();
    }

}
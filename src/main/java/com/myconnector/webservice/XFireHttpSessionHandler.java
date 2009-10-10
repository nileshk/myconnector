package com.myconnector.webservice;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.codehaus.xfire.MessageContext;
import org.codehaus.xfire.handler.AbstractHandler;
import org.codehaus.xfire.transport.Session;
import org.codehaus.xfire.transport.http.XFireHttpSession;

import com.myconnector.util.HttpSessionThreadLocal;

public class XFireHttpSessionHandler extends AbstractHandler {

    static Logger logger = Logger.getLogger(XFireHttpSessionHandler.class);
    
    public void invoke(MessageContext context) throws Exception {
        Session session = context.getSession();
        if(session instanceof XFireHttpSession) {
            logger.debug("Session is an instance of XFireHttpSession, attempting to extract HttpSession");
            XFireHttpSession xFireHttpSession = (XFireHttpSession) session;
            HttpSession httpSession = xFireHttpSession.getSession();
            HttpSessionThreadLocal.set(httpSession);
            logger.debug("HttpSession extracted from XFireHttpSession");
        } else {
            logger.debug("Session not an instance of XFireHttpSession");
        }
    }

}

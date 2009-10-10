/*
 * Created on Aug 28, 2004
 *
 */
package com.myconnector.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.orm.hibernate3.HibernateObjectRetrievalFailureException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.view.RedirectView;

import com.myconnector.service.ReleaseUserService;

/**
 * 
 * @author Nilesh Kapadia (nileshka@gmail.com)
 */
public class ReleaseUserDeleteController implements Controller {

    static Logger logger = Logger.getLogger(ReleaseUserDeleteController.class);

    ReleaseUserService releaseUserService;

    String view = "home.do";

    public void setReleaseUserService(ReleaseUserService releaseUserService) {
        this.releaseUserService = releaseUserService;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.web.servlet.mvc.Controller#handleRequest(javax.servlet.http.HttpServletRequest,
     *      javax.servlet.http.HttpServletResponse)
     */
    public ModelAndView handleRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        String userId = request.getParameter("userId");
        String releaseId = request.getParameter("releaseId");
        logger.debug("releaseId = " + releaseId);
        logger.debug("userId = " + userId);
        Map model = new HashMap();
        if (userId != null && releaseId != null && request.getParameter("submit.delete") != null) {
            try {
                releaseUserService.delete(releaseId, userId);
            } catch (HibernateObjectRetrievalFailureException ex) {
                model.put("deleteFailed", "true");
            }
        }

        String returnView = view + "?id=" + releaseId;
        return new ModelAndView(new RedirectView(returnView, false));
    }

    /**
     * @param view
     *            The view to set.
     */
    public void setView(String view) {
        this.view = view;
    }
}
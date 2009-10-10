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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.myconnector.service.BookmarkService;

/**
 * 
 * @author nil
 */
public class IndexController implements Controller {

    static Logger logger = Logger.getLogger(IndexController.class);

    BookmarkService bookmarkService;

    /**
     * @param bookmarkService
     *            The bookmarkService to set.
     */
    public void setBookmarkService(BookmarkService bookmarkService) {
        this.bookmarkService = bookmarkService;
    }

    /*
     * @see org.springframework.web.servlet.mvc.Controller#handleRequest(javax.servlet.http.HttpServletRequest,
     *      javax.servlet.http.HttpServletResponse)
     */
    public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1)
            throws Exception {
        int size = bookmarkService.getList().size();
        Map model = new HashMap();
        model.put("bookmarkNumber", String.valueOf(size));
        return new ModelAndView("index.jsp", model);
    }
}
/*
 * Created on Aug 28, 2004
 *
 */
package com.myconnector.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.myconnector.service.BookmarkService;

/** 
 *
 * @author Nilesh Kapadia (nileshka@gmail.com)
 */
public class ListController implements Controller {

    static Logger logger = Logger.getLogger(ListController.class);
    
    BookmarkService bookmarkService;

    /**
     * @param bookmarkService The bookmarkService to set.
     */
    public void setBookmarkService(BookmarkService bookmarkService) {
        this.bookmarkService = bookmarkService;
    }  
    
    /* (non-Javadoc)
     * @see org.springframework.web.servlet.mvc.Controller#handleRequest(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
        List bookmarkList = bookmarkService.getList();                
        Map model = new HashMap(); 
        model.put("bookmarkList", bookmarkList);
        model.put("showUser", Boolean.TRUE);
        return new ModelAndView("list.jsp", model);
    }
}

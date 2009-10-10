/*
 * Created on Aug 28, 2004
 *
 */
package com.myconnector.web.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.myconnector.domain.Bookmark;
import com.myconnector.service.BookmarkService;

/**
 * 
 * @author nil
 */
public class EditController extends SimpleFormController {

    static Logger logger = Logger.getLogger(EditController.class);
    
    BookmarkService bookmarkService;

    /**
     * @param bookmarkService
     *            The bookmarkService to set.
     */
    public void setBookmarkService(BookmarkService bookmarkService) {
        this.bookmarkService = bookmarkService;
    }

    protected Object formBackingObject(HttpServletRequest req) throws Exception {
        String id = req.getParameter("id");
        return (bookmarkService.loadBookmark(id));
    }

    protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response,
            Object command, BindException errors) throws Exception {
        Bookmark bookmark = (Bookmark) command;
        bookmarkService.saveOrUpdateBookmark(bookmark);
        //return listController.handleRequest(request, response);
        //return new ModelAndView(getSuccessView(), errors.getModel());
        return super.onSubmit(request, response, command, errors);
    }
}
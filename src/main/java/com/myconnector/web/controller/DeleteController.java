package com.myconnector.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.orm.hibernate3.HibernateObjectRetrievalFailureException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.myconnector.service.BookmarkService;

/**
 * 
 * @author nil
 */
public class DeleteController implements Controller {

    static Logger logger = Logger.getLogger(DeleteController.class);

    BookmarkService bookmarkService;
    String view = "list.jsp";

    /**
     * @param bookmarkService
     *            The bookmarkService to set.
     */
    public void setBookmarkService(BookmarkService bookmarkService) {
        this.bookmarkService = bookmarkService;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.web.servlet.mvc.Controller#handleRequest(javax.servlet.http.HttpServletRequest,
     *      javax.servlet.http.HttpServletResponse)
     */
    public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse res)
            throws Exception {
        String id = req.getParameter("id");
        Map model = new HashMap();
        if (id != null && req.getParameter("submit.delete") != null) {
            try {
                bookmarkService.deleteById(id);
            } catch (HibernateObjectRetrievalFailureException ex) {
                model.put("deleteFailed", "true");
            }
        }
        return new ModelAndView(view, model);
    }

    /**
     * @param view
     *            The view to set.
     */
    public void setView(String view) {
        this.view = view;
    }
}

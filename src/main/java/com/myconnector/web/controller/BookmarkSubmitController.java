package com.myconnector.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.myconnector.domain.Bookmark;
import com.myconnector.service.BookmarkService;

public class BookmarkSubmitController extends SimpleFormController {

    static Logger logger = Logger.getLogger(BookmarkSubmitController.class);
    
    BookmarkService bookmarkService;

    String closePopupView = "closePopup.jsp";
    
    /**
     * @param bookmarkService
     *            The bookmarkService to set.
     */
    public void setBookmarkService(BookmarkService bookmarkService) {
        this.bookmarkService = bookmarkService;
    }
        
    public void setClosePopupView(String closePopupView) {
        this.closePopupView = closePopupView;
    }
    
    protected Object formBackingObject(HttpServletRequest request) throws Exception {        
        Bookmark bookmark = new Bookmark();
		bookmark.setUrl(request.getParameter("url"));
		bookmark.setTitle(request.getParameter("title"));		
		return (bookmark);
    }

    protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response,
            Object command, BindException errors) throws Exception {
        Bookmark bookmark = (Bookmark) command;
        bookmarkService.saveBookmark(bookmark);
        //return listController.handleRequest(request, response);
        //return new ModelAndView(getSuccessView(), errors.getModel());
        
        if(request.getParameter("popup") != null) {
            return new ModelAndView(closePopupView, null);
        }
        
        return super.onSubmit(request, response, command, errors);
    }
	
	
}

package com.myconnector.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.util.WebUtils;

import com.myconnector.domain.Bookmark;
import com.myconnector.domain.UserData;
import com.myconnector.exception.MessageException;
import com.myconnector.service.BookmarkService;
import com.myconnector.service.UserService;

/**
 * 
 * @author Nilesh Kapadia (nileshka@gmail.com)
 */
public class ProfileController implements Controller {

	String view;

	UserService userService;

	BookmarkService bookmarkService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void setBookmarkService(BookmarkService bookmarkService) {
		this.bookmarkService = bookmarkService;
	}

	public void setView(String view) {
		this.view = view;
	}

	/*
	 * @see org.springframework.web.servlet.mvc.Controller#handleRequest(javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
        if(id == null || id.equals("")) {
            id = (String) WebUtils.getSessionAttribute(request, LoginController.USER_ID);
            if(id == null || id.equals("")) {
                throw new MessageException("user.notLoggedIn"); 
            }
        }
		Map model = new HashMap();
		UserData userData = userService.getUserByIdWithBookmarks(id);
		model.put("userData", userData);
		List<Bookmark> bookmarkList = bookmarkService.getBookmarkListByUserId(id);
		model.put("bookmarkList", bookmarkList);

		return new ModelAndView(view, model);
	}
}

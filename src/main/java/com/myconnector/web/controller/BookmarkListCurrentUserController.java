package com.myconnector.web.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.util.WebUtils;

import com.myconnector.service.BookmarkService;

public class BookmarkListCurrentUserController implements Controller {

	BookmarkService bookmarkService;

	String view;

	public void setView(String view) {
		this.view = view;
	}

	public void setBookmarkService(BookmarkService bookmarkService) {
		this.bookmarkService = bookmarkService;
	}

	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String username = (String) WebUtils.getSessionAttribute(request,
				"username");
		Map map = new HashMap();
		if(username != null && username.length() > 0) {
			Collection bookmarks = bookmarkService.getBookmarkListByUserLoginIncludingPrivate(username);
			map.put("bookmarkList", bookmarks);
		}		
		return new ModelAndView(view, map);
	}

}

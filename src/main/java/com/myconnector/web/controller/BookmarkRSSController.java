package com.myconnector.web.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.myconnector.domain.Bookmark;
import com.myconnector.service.BookmarkService;

public class BookmarkRSSController implements Controller {

    BookmarkService bookmarkService;

    String view;
    
    String errorView;

    public void setView(String view) {
        this.view = view;
    }

    public void setBookmarkService(BookmarkService bookmarkService) {
        this.bookmarkService = bookmarkService;
    }

    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String userLogin = request.getParameter("user");
        Map map = new HashMap();
        if (userLogin != null && !userLogin.equals("")) {
            Collection bookmarks = bookmarkService.getBookmarkListByUserLogin(userLogin);
//            if(bookmarks == null) {
//                map.put("errorMessage", "User not found");
//                return new ModelAndView(errorView, map);
//            }
            
            for(Iterator it = bookmarks.iterator(); it.hasNext(); ) {
                Bookmark bookmark = (Bookmark) it.next();
                String url = bookmark.getUrl();
                bookmark.setUrl(url.replaceAll("&", "&amp;"));
                bookmark.setUrl(url.replaceAll("<", "&lt;"));
                bookmark.setUrl(url.replaceAll(">", "&gt;"));
            }            
            map.put("bookmarks", bookmarks);
            map.put("userLogin", userLogin);
        }
        response.setContentType("application/xml");
        return new ModelAndView(view, map);
    }

}

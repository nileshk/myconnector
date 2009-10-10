package com.myconnector.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.myconnector.domain.PageCache;
import com.myconnector.service.BookmarkService;

public class BookmarkCacheView implements Controller {

    private BookmarkService bookmarkService;

    private String view;

    public void setBookmarkService(BookmarkService bookmarkService) {
        this.bookmarkService = bookmarkService;
    }

    public void setView(String view) {
        this.view = view;
    }

    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        String id = request.getParameter("id");
        PageCache cache = bookmarkService.getPageCache(Integer.valueOf(id));        
        Map<String, Object> map = new HashMap<String, Object>();
        if(cache != null) {
            map.put("data", cache.getPageText());
        }
        return new ModelAndView(view, map);
    }
}

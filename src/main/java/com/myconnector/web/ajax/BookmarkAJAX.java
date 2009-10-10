package com.myconnector.web.ajax;

import javax.servlet.http.HttpSession;

public interface BookmarkAJAX {

    public boolean addBookmarkToCurrentUser(String bookmarkId, HttpSession httpSession);
    
}

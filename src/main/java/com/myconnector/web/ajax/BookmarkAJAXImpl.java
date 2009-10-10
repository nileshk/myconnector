package com.myconnector.web.ajax;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.myconnector.domain.Bookmark;
import com.myconnector.service.BookmarkService;
import com.myconnector.util.HttpSessionThreadLocal;

public class BookmarkAJAXImpl implements BookmarkAJAX {

    private static Logger logger = Logger.getLogger(BookmarkAJAXImpl.class);

    private BookmarkService bookmarkService = null;

    public void setBookmarkService(BookmarkService bookmarkService) {
        // Check null in case someone tries to call using AJAX
        if (bookmarkService != null) {
            this.bookmarkService = bookmarkService;
        }
    }

    public boolean addBookmarkToCurrentUser(String bookmarkId, HttpSession httpSession) {
        HttpSessionThreadLocal.set(httpSession);
        if (logger.isDebugEnabled()) {
            logger.debug("userId = " + HttpSessionThreadLocal.getUserId());
            logger.debug("userName = " + HttpSessionThreadLocal.getUsername());
        }
        // TODO unit test
        logger.debug("Attempting to add bookmark id = " + bookmarkId);
        Bookmark bookmark = bookmarkService.loadBookmark(bookmarkId);
        bookmark.setId(null);
        bookmark.setAddDate(null);
        bookmark.setFolder(null);
        return bookmarkService.saveBookmark(bookmark);
    }

}

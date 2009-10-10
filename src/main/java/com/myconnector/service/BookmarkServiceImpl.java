package com.myconnector.service;

import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

import com.myconnector.dao.BookmarkDAO;
import com.myconnector.dao.PageCacheDAO;
import com.myconnector.dao.PageListDAO;
import com.myconnector.dao.UserDataDAO;
import com.myconnector.domain.Bookmark;
import com.myconnector.domain.PageCache;
import com.myconnector.domain.PageList;
import com.myconnector.domain.UserData;
import com.myconnector.exception.MessageException;
import com.myconnector.util.CommonThreadLocal;

public class BookmarkServiceImpl implements BookmarkService {

    static Logger logger = Logger.getLogger(BookmarkServiceImpl.class);

    private BookmarkDAO bookmarkDAO;

    private PageListDAO pageListDAO;

    private PageCacheDAO pageCacheDAO;

    private UserDataDAO userDataDAO;

    int idLength = 0;

    public void setBookmarkDAO(BookmarkDAO bookmarkDAO) {
        this.bookmarkDAO = bookmarkDAO;
    }

    public void setUserDataDAO(UserDataDAO userDataDAO) {
        this.userDataDAO = userDataDAO;
    }

    public void setPageListDAO(PageListDAO pageListDAO) {
        this.pageListDAO = pageListDAO;
    }

    public void setPageCacheDAO(PageCacheDAO pageCacheDAO) {
        this.pageCacheDAO = pageCacheDAO;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.myconnector.service.UserService#loadBookmark(com.myconnector.domain.Bookmark)
     */
    public Bookmark loadBookmark(String id) {
        return (bookmarkDAO.loadBookmark(id));
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.myconnector.service.UserService#saveBookmark(com.myconnector.domain.Bookmark)
     */
    public boolean saveBookmark(Bookmark bookmark) {
        String userId = CommonThreadLocal.getUserId();
        // if(userId == null) {
        // userId = userDataDAO.getUserByUserLogin("admin").getId(); // TODO
        // remove this!!!
        // }
        UserData userData = userDataDAO.load(userId);
        bookmark.setUserData(userData);

        // TODO detect and throw errors on oversized url's and other fields
        if (bookmark.getUrl().length() > 1024) {
            bookmark.setUrl(bookmark.getUrl().substring(0, 1023));
        }

        if (bookmark.getAddDate() == null) {
            bookmark.setAddDate(new Date());
        }

        if (bookmark.getViewable() == null) {
            // set bookmark to public if value was not set
            bookmark.setViewable(new Integer(0));
        }

        // TODO make duplicate bookmarkng an option and/or return status
        if (!userHasBookmark(bookmark.getUrl(), userData.getId())) {
            bookmarkDAO.saveBookmark(bookmark);
        } else {
            logger.debug("User already has bookmark, so bookmark is not saved.");
            return false;
        }

        // TODO automatically update index?
        return true;
    }

    private boolean userHasBookmark(String url, String userId) {
        return bookmarkDAO.userHasBookmark(url, userId);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.myconnector.service.BookmarkService#deleteBookmark(java.lang.String)
     */
    public void deleteById(String id) {
        Bookmark bk = bookmarkDAO.loadBookmark(id);
        String userId = CommonThreadLocal.getUserId();
        if (!bk.getUserData().getId().equals(userId)) {
            throw new MessageException("delete.bookmarkDoesNotBelongToUser",
                    "Bookmark does not belong to user, delete failed.");
        }
        bookmarkDAO.deleteBookmark(bk);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.myconnector.service.BookmarkService#saveBookmarkArray(java.util.ArrayList)
     */
    public void saveBookmarkList(List bookmarkList) {
        Iterator iterator = bookmarkList.iterator();
        while (iterator.hasNext()) {
            saveBookmark((Bookmark) iterator.next());
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.myconnector.service.BookmarkService#loadBookmarkArray()
     */
    public List getList() {
        return (bookmarkDAO.getBookmarkList());
    }

    /**
     * @param idLength
     *            The idLength to set.
     */
    public void setIdLength(int idLength) {
        this.idLength = idLength;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.myconnector.service.BookmarkService#saveOrUpdateBookmark(com.myconnector.domain.Bookmark)
     */
    public void saveOrUpdateBookmark(Bookmark bookmark) {
        bookmarkDAO.saveOrUpdateBookmark(bookmark);
    }

    public List<Bookmark> getBookmarkListByUserId(String userId) {
        List<Bookmark> bookmarks = bookmarkDAO.getBookmarkListByUser(userId);
        bookmarks.size();
        return bookmarks;
    }

    public Collection getBookmarkListByUserLogin(String userLogin) {
        UserData user = userDataDAO.getUserByUserLogin(userLogin);
        // Collection bookmarks = user.getBookmarksByUserId();
        Collection bookmarks = bookmarkDAO.getBookmarkListByUser(user.getId());
        bookmarks.size();
        return bookmarks;
    }

    public List<Bookmark> getBookmarkListByUserLoginIncludingPrivate(String userLogin) {
        UserData user = userDataDAO.getUserByUserLogin(userLogin);
        // Collection bookmarks = user.getBookmarksByUserId();
        List<Bookmark> bookmarks = bookmarkDAO.getBookmarkListByUserIncludingPrivate(user.getId());
        bookmarks.size();
        return bookmarks;
    }

    public PageCache getPageCache(Integer pageListId) {
        PageList page = pageListDAO.load(pageListId);
        if (page != null) {
            return page.getPageCache();
        } else {
            // TODO throw error if null?
            return null;
        }
    }

    public int getPageListCount() {
        return pageListDAO.count();
    }

    public int getPageCacheCount() {
        return pageCacheDAO.count();
    }
}
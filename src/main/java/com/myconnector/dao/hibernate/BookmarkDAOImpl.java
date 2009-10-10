package com.myconnector.dao.hibernate;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.myconnector.dao.BookmarkDAO;
import com.myconnector.domain.Bookmark;

import java.util.List;

public class BookmarkDAOImpl extends HibernateDaoSupport implements BookmarkDAO {

    static Logger logger = Logger.getLogger(BookmarkDAOImpl.class);

    public BookmarkDAOImpl() {
    }

    public Bookmark loadBookmark(String id) throws DataAccessException {
        return (Bookmark) getHibernateTemplate().load(Bookmark.class, id);
    }

    public void updateBookmark(Bookmark bookmark) throws DataAccessException {
        getHibernateTemplate().update(bookmark);
    }

    public void saveBookmark(Bookmark bookmark) throws DataAccessException {
        getHibernateTemplate().save(bookmark);
    }

    public void deleteBookmark(Bookmark bookmark) throws DataAccessException {
        getHibernateTemplate().delete(bookmark);
    }

    @SuppressWarnings("unchecked")
    public List<Bookmark> getBookmarkList() throws DataAccessException {
        return (getHibernateTemplate()
                .find("from com.myconnector.domain.Bookmark bookmark " +
                	"where bookmark.viewable = 0 " +
                	"order by bookmark.addDate desc"));
    }

    @SuppressWarnings("unchecked")
    public List<Bookmark> getBookmarkListByUser(String userId) throws DataAccessException {
        return (getHibernateTemplate()
                .find("from com.myconnector.domain.Bookmark bookmark " +
                        "where bookmark.userData.id = ? " +
                        "and bookmark.viewable = 0 " +
                        "order by bookmark.addDate desc", userId));
    }

    @SuppressWarnings("unchecked")
    public List<Bookmark> getBookmarkListByUserIncludingPrivate(String userId) throws DataAccessException {
        return (getHibernateTemplate()
                .find("from com.myconnector.domain.Bookmark bookmark " +
                        "where bookmark.userData.id = ? " +
                        "order by bookmark.addDate desc", userId));
    }    
    
    @SuppressWarnings("unchecked")
    public List<String> getUrlList() {
        return (getHibernateTemplate().find("select b.url from com.myconnector.domain.Bookmark b where b.viewable = 0"));
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.myconnector.dao.BookmarkDAO#saveOrUpdateBookmark(com.myconnector.domain.Bookmark)
     */
    public void saveOrUpdateBookmark(Bookmark bookmark) throws DataAccessException {
        getHibernateTemplate().saveOrUpdate(bookmark);
    }

    @SuppressWarnings("unchecked")
    public boolean userHasBookmark(String url, String userId) {
        Object[] parameters = new Object[] { userId, url };
        List<String> urlList = getHibernateTemplate()
                .find(
                        "select b.url from com.myconnector.domain.Bookmark b where b.userData.id = ? and b.url = ?",
                        parameters);
        return (urlList.size() > 0);
    }

    @SuppressWarnings("unchecked")
    public List<Bookmark> getBookmarkListForURL(String url) {
        return (getHibernateTemplate()
                .find("from com.myconnector.domain.Bookmark bookmark " +
                        "where bookmark.url = ? " +
                        "order by bookmark.addDate", url));
    }
}
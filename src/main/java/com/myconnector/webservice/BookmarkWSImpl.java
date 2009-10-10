/*
 * Created on Aug 9, 2004
 *
 */
package com.myconnector.webservice;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import javax.xml.rpc.ServiceException;

import org.apache.axis.AxisFault;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;

import com.myconnector.domain.Bookmark;
import com.myconnector.dto.BookmarkDTO;
import com.myconnector.service.BookmarkService;
import com.myconnector.util.ConvertUtil;

/**
 * @author Nilesh Kapadia (nileshka@gmail.com)
 */
public class BookmarkWSImpl extends BaseWSImpl implements BookmarkWS {

    static Logger logger = Logger.getLogger(BookmarkWSImpl.class);

    protected BookmarkService bookmarkService;

    public void setBookmarkService(BookmarkService bookmarkService) {
        this.bookmarkService = bookmarkService;
    }    
    
    /*
     * @see com.myconnector.webservice.AboutWS#loadBookmark(java.lang.String)
     */
    public BookmarkDTO loadBookmark(String id) throws RemoteException {
        try {
            return (bookmarkService.loadBookmark(id));
        } catch (Exception ex) {
            throw handleException(ex);        }
    }

//    public void saveBookmark(BookmarkDTO bookmarkDTO) throws RemoteException {
//        try {
//            Bookmark bookmark = new Bookmark();
//            BeanUtils.copyProperties(bookmarkDTO, bookmark);
//            bookmarkService.saveBookmark(bookmark);
//        } catch (Exception ex) {
//            throw handleException(ex);        }
//    }

    public void saveBookmark(String url, String title, String folder, String description,
            Date addDate, Date lastVisit) throws RemoteException {
        try {
            Bookmark bookmark = new Bookmark();
            bookmark.setUrl(url);
            bookmark.setTitle(title);
            bookmark.setFolder(folder);
            bookmark.setDescription(description);
            bookmark.setAddDate(addDate);
            bookmark.setLastVisit(lastVisit);
            bookmarkService.saveBookmark(bookmark);
        } catch (Exception ex) {
            throw handleException(ex);        }
        
    }

    
    /*
     * (non-Javadoc)
     * 
     * @see com.myconnector.webservice.BookmarkWS#deleteBookmark(java.lang.String)
     */
    public void deleteBookmark(String id) throws RemoteException {
        bookmarkService.deleteById(id);
    }

    /*
     * @see com.myconnector.webservice.BookmarkWS#loadBookmarkList()
     */
    public BookmarkDTO[] loadBookmarkList() throws RemoteException, AxisFault {
        try {
            List list = bookmarkService.getList();
            BookmarkDTO[] bookmarkArray = new BookmarkDTO[list.size()];
            for (int i = 0; i < list.size(); i++) {
                bookmarkArray[i] = (BookmarkDTO) list.get(i);
            }
            return (bookmarkArray);
        } catch (Exception ex) {            
            throw handleException(ex);
        }
    }

    /*
     * @see com.myconnector.webservice.BookmarkWS#saveBookmarkList(com.myconnector.domain.Bookmark[])
     */
    public void saveBookmarkList(BookmarkDTO[] bookmarkArray) throws RemoteException, AxisFault {
        try {
            bookmarkService.saveBookmarkList(ConvertUtil.array2List(bookmarkArray));
        } catch (Exception ex) {
            throw handleException(ex);
        }
    }

}
/*
 * Created on Oct 14, 2003
 */

/**
 * @author Nilesh Kapadia
 */
package com.myconnector.client;

import java.rmi.RemoteException;
import java.util.List;

import javax.xml.rpc.ServiceException;

import org.apache.axis.AxisFault;
import org.apache.log4j.Logger;

import com.myconnector.client.util.FileParser;
import com.myconnector.client.proxy.BookmarkDTO;
import com.myconnector.client.proxy.BookmarkWSImpl;
import com.myconnector.client.proxy.BookmarkWSImplServiceLocator;
import com.myconnector.util.ConvertUtil;

public class BkMethods {

    Logger logger = Logger.getLogger(BkMethods.class);

    // BookmarkWS bookmarkWS = null;
    BookmarkWSImpl bookmarkWS = null;

    FileParser fileParser = null;

    boolean bookmarkWSSet = false;

    void start(String fileList) throws RemoteException {

        BookmarkWSImplServiceLocator locator = new BookmarkWSImplServiceLocator();
        locator.setMaintainSession(true);

        try {
            bookmarkWS = locator.getBookmark();
        } catch (ServiceException e) {
            logger.debug(e);
            throw new RuntimeException(e);
        }

        // Login
        if (bookmarkWS.login("admin", "admin") == false) {
            return;
        }

        // Get logged in user to verify we are logged in
        // by session
        String loggedInAs = bookmarkWS.getLoggedUsername();
        logger.debug("Logged in as: " + loggedInAs);
        if (loggedInAs == null) {
            return;
        }

        // BookmarkDTO bookmarkTest =
        // bookmarkWS.loadBookmark("ff80808103342236010334228cb70001");

        // logger.debug(bookmarkTest.getId());
        // logger.debug(bookmarkTest.getUrl());

        BookmarkDTO[] bl = bookmarkWS.loadBookmarkList();
        for (int i = 0; i < bl.length; i++) {
            System.out.println(bl[i].getUrl());
        }
//        if (true)
//            return;
        FileParser f = fileParser;
        List fList = f.fileListParse(fileList);

        System.out.println("Processing bookmark files:");

        for (int i = 0; i < fList.size(); i++) {
            List bList = bList = f.parse((String) fList.get(i));
            System.out.print((String) fList.get(i));
            if (bList != null) {
                addList(bList);
                System.out.println(" [Added]");
            } else
                System.out.println(" [Error loading file.  Processing next file.]");
        }
        // DisplayBookmarks();
    }

    // void setPersistanceLayer(BookmarkWS persistanceLayer) {
    // bookmarkWS = persistanceLayer;
    //
    // }

    void addList(List bList) throws RemoteException {
        // Add bookmark list to persistance layer
        if (bookmarkWS != null)
            for (int i = 0; i < bList.size(); i++)
                if (bList.get(i) == null) {
                    System.out.println("It's null!");
                } else {
                    BookmarkDTO bookmarkDTO = (BookmarkDTO) bList.get(i);
                    System.out.println(bookmarkDTO.getUrl());
                    bookmarkWS.saveBookmark(bookmarkDTO.getUrl(), bookmarkDTO.getTitle(),
                            bookmarkDTO.getFolder(), bookmarkDTO.getDescription(), bookmarkDTO
                                    .getAddDate(), bookmarkDTO.getLastVisit());
                }
        // System.out.println(bList.Get(i).title + ":" +
        // bList.Get(i).url);
    }

    void displayBookmarks() throws AxisFault, RemoteException {
        if (bookmarkWS != null) {
            // Display bookmarks contained in persistance layer
            List bList2 = ConvertUtil.array2List(bookmarkWS.loadBookmarkList());
            System.out.println("From database:");
            for (int i = 0; i < bList2.size(); i++)
                System.out.println(((BookmarkDTO) bList2.get(i)).getTitle() + ":"
                        + ((BookmarkDTO) bList2.get(i)).getUrl());
        }
    }

    /**
     * @param fileParser
     *            The fileParser to set.
     */
    public void setFileParser(FileParser fileParser) {
        this.fileParser = fileParser;
    }

    /**
     * @param bookmarkWS
     *            The bookmarkWS to set.
     */
    // public void setBookmarkWS(BookmarkWS bookmarkWS) {
    // this.bookmarkWS = bookmarkWS;
    // }
}
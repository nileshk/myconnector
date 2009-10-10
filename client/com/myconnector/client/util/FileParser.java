/*
 * Created on Sep 21, 2003
 */

/**
 * @author Nilesh Kapadia
 */
package com.myconnector.client.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.myconnector.client.proxy.BookmarkDTO;

public class FileParser {

    static Logger logger = Logger.getLogger(FileParser.class);

    public List fileListParse(String filename) {
        FileInputHandler f = new FileInputHandler(filename);
        ArrayList fList = new ArrayList();

        String line = f.readLine();
        while (line != null) {
            if (line != "")
                fList.add(line);
            line = f.readLine();
        }

        return (fList);
    }

    public List parse(String filename) {
        List bList = new ArrayList();

        //		try
        {
            String currentHeading = "";
            String lastHeading = "";
            FileInputHandler f = new FileInputHandler(filename);
            String line = f.readLine();
            boolean headingOn = false;
            while (line != null) {
                BookmarkDTO bookmark = parseLine(line);
                String heading = parseLineHeading(line);
                if (heading != "") {
                    lastHeading = heading;
                    //System.out.println(heading);
                }
                if (line.indexOf("<DL>") > -1) {
                    if (lastHeading != "") {
                        currentHeading += "/" + lastHeading;
                        //System.out.println(currentHeading);
                    }
                }
                if (line.indexOf("</DL>") > -1) {
                    if (currentHeading.lastIndexOf("/") > 0)
                        currentHeading = currentHeading.substring(0, currentHeading
                                .lastIndexOf("/"));
                    else
                        //if (currentHeading.equals("/"))
                        currentHeading = "";
                    //System.out.println(currentHeading);
                }
                bookmark.setFolder(currentHeading);
                if (bookmark.getUrl() != "") {
                    bList.add(bookmark);
                }
                line = f.readLine();
            }
        }
        //		catch (RuntimeException ex)
        //		{
        //			System.out.println(ex.toString());
        //			bList = null;
        //		}
        return (bList);
    }

    private String parseLineHeading(String line) {
        boolean isHeading = false;
        boolean foundTitle = false;
        int startTitle = 0;
        int endTitle = 0;
        String title = "";
        for (int i = 0; i < line.length(); i++) {
            if (!isHeading && (i < (line.length() - 2)))
                if (line.substring(i, i + 3).toUpperCase().equals("<H3")) {
                    i = i + 2;
                    isHeading = true;
                }
            if (isHeading) {
                if (!foundTitle && (startTitle == 0))
                    if (line.substring(i, i + 1).equals(">"))
                        startTitle = i + 1;
                if (!foundTitle && (startTitle != 0))
                    if (line.substring(i, i + 1).equals("<")) {
                        endTitle = i;
                        title = line.substring(startTitle, endTitle);
                        foundTitle = true;
                    }
            }
        }
        return (title);
    }

    //    private int scanForTag(String tag, String line, int i, Integer start) {
    //        if (i < (line.length() - 10)) {
    //            if (line.substring(i, i + 10).toUpperCase().equals("ADD_DATE=\"")) {
    //                startAddDate = i + 10;
    //                i = i + 10;
    //            }
    //        }
    //    }

    private BookmarkDTO parseLine(String line) {
        String bkmrkURL = "";
        String url = "";
        int startURL = 0;
        int endURL = 0;
        boolean foundURL = false;
        boolean foundTitle = false;
        boolean foundAddDate = false;
        int startTitle = 0;
        int endTitle = 0;
        int startAddDate = 0;
        int endAddDate = 0;
        String title = "";
        String addDate = "";
        for (int i = 0; i < line.length(); i++) {
            boolean isURL = false;
            if (i < (line.length() - 6)) {
                if (line.substring(i, i + 6).toUpperCase().equals("HREF=\"")) {
                    //outputString = ":" + line.substring(i, i+6);
                    startURL = i + 6;
                    i = i + 6;
                }
            }
            if (i < (line.length() - 10)) {
                if (line.substring(i, i + 10).toUpperCase().equals("ADD_DATE=\"")) {
                    startAddDate = i + 10;
                    i = i + 10;
                }
            }

            if ((startURL != 0) && !foundURL) {
                if (line.substring(i, i + 1).equals("\"")) {
                    endURL = i;
                    bkmrkURL = line.substring(startURL, endURL);
                    foundURL = true;
                }
            }
            if ((startAddDate != 0) && !foundAddDate) {
                if (line.substring(i, i + 1).equals("\"")) {
                    endAddDate = i;
                    addDate = line.substring(startAddDate, endAddDate);
                    foundAddDate = true;
                }
            }
            if (foundURL && !foundTitle && (startTitle == 0)) {
                if (line.substring(i, i + 1).equals(">")) {
                    startTitle = i + 1;
                }
            }
            if (foundURL && !foundTitle && (startTitle != 0)) {
                if (line.substring(i, i + 1).equals("<")) {
                    endTitle = i;
                    title = line.substring(startTitle, endTitle);
                    foundTitle = true;
                }
            }

        }

        BookmarkDTO bookmark = new BookmarkDTO();
        bookmark.setUrl(bkmrkURL);
        bookmark.setTitle(title);
        if (foundAddDate) {
            logger.debug("Add date = " + addDate);
            //            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            //            sdf.setLenient(true);

            Date date = new Date(Long.valueOf(addDate).longValue());//sdf.parse(addDate);
            logger.debug("Date = " + date.toString());
            //bookmark.setAddDate(date);
        }
        return (bookmark);
    }
}

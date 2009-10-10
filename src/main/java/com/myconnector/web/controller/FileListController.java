/*
 * Created on Aug 28, 2004
 *
 */
package com.myconnector.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.myconnector.service.FileService;

/** 
 *
 * @author Nilesh Kapadia (nileshka@gmail.com)
 */
public class FileListController implements Controller {

    static Logger logger = Logger.getLogger(FileListController.class);
    
    FileService fileService;

    protected String view;
       
    public void setView(String view) {
        this.view = view;
    }
    /**
     * @param fileService The fileService to set.
     */
    public void setFileService(FileService fileService) {
        this.fileService = fileService;
    }  
    
    /* (non-Javadoc)
     * @see org.springframework.web.servlet.mvc.Controller#handleRequest(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List fileList = fileService.getList();                
        Map model = new HashMap(); 
        model.put("fileList", fileList);
        return new ModelAndView(view, model);
    }
}

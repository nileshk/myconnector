/*
 * Created on Dec 21, 2004
 *
 */
package com.myconnector.web.controller;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.myconnector.domain.File;
import com.myconnector.service.FileService;

/**
 * 
 * @author Nilesh Kapadia (nileshka@gmail.com)
 */
public class FileDownloadController implements Controller {

    FileService fileService;

    /**
     * @param fileService
     *            The fileService to set.
     */
    public void setFileService(FileService fileService) {
        this.fileService = fileService;
    }

    /*
     * @see org.springframework.web.servlet.mvc.Controller#handleRequest(javax.servlet.http.HttpServletRequest,
     *      javax.servlet.http.HttpServletResponse)
     */
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        String id = request.getParameter("id");

        File file = fileService.getFile(id);

        if (file != null) {
            if (file.getFile() != null) {
                byte[] b = file.getFile();
                response.setBufferSize(b.length);
                //response.setContentType(file.getFileType());
                response.setContentLength(b.length);
                
                /* These lines added to force browser to download with correct filename */
                response.setContentType("application/x-download");
                response.setHeader("Content-Disposition","attachment; filename=\"" + file.getFileName() +"\"");

                ServletOutputStream outputStream = response.getOutputStream();
                outputStream.write(b, 0, b.length);
                outputStream.flush();
                outputStream.close();
            } else {
                // ERROR
            }
        }
        return null;
    }

}
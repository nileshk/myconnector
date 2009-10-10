package com.myconnector.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;

import com.myconnector.domain.File;
import com.myconnector.service.ReleaseFileService;

/**
 * 
 * @author Nilesh Kapadia (nileshka@gmail.com)
 */
public class ReleaseFileUploadController extends SimpleFormController {

    static Logger logger = Logger.getLogger(ReleaseFileUploadController.class);

    ReleaseFileService releaseFileService;

    public void setReleaseFileService(ReleaseFileService releaseFileService) {
        this.releaseFileService = releaseFileService;
    }

    public ReleaseFileUploadController() {
        setCommandClass(File.class);
    }

    /*
     * @see org.springframework.web.servlet.mvc.AbstractFormController#formBackingObject(javax.servlet.http.HttpServletRequest)
     */
    protected Object formBackingObject(HttpServletRequest request)
            throws Exception {
        File command = new File();
        return command;
    }

    /*
     * @see org.springframework.web.servlet.mvc.BaseCommandController#initBinder(javax.servlet.http.HttpServletRequest,
     *      org.springframework.web.bind.ServletRequestDataBinder)
     */
    protected void initBinder(HttpServletRequest request,
            ServletRequestDataBinder binder) throws Exception {
        binder.registerCustomEditor(byte[].class,
                new ByteArrayMultipartFileEditor());
    }

    /*
     * @see org.springframework.web.servlet.mvc.SimpleFormController#onSubmit(javax.servlet.http.HttpServletRequest,
     *      javax.servlet.http.HttpServletResponse, java.lang.Object,
     *      org.springframework.validation.BindException)
     */
    protected ModelAndView onSubmit(HttpServletRequest request,
            HttpServletResponse response, Object command, BindException errors)
            throws Exception {
        logger.debug("onSubmit");
        File file = (File) command;

        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile multipartFile = multipartRequest.getFile("file");
        file.setFileName(multipartFile.getOriginalFilename());
        file.setFileType(multipartFile.getContentType());
        //file.setFileSize(multipartFile.getSize());

        String releaseId = request.getParameter("releaseId");
        releaseFileService.saveFile(file, releaseId);
        String view = getSuccessView() + "?id=" + releaseId;
        return new ModelAndView(new RedirectView(view, false));
    }

}
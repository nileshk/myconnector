package com.myconnector.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;

import com.myconnector.domain.Release;
import com.myconnector.service.ReleaseService;

/** 
 *
 * @author Nilesh Kapadia (nileshka@gmail.com)
 */
public class ReleaseEditController extends SimpleFormController {
 
    static Logger logger = Logger.getLogger(ReleaseEditController.class);
    
    protected ReleaseService releaseService;
    
    public void setReleaseService(ReleaseService releaseService) {
        this.releaseService = releaseService;
    }
    
    public ReleaseEditController() {
        setCommandClass(Release.class);
    }
    
    protected Object formBackingObject(HttpServletRequest request)
            throws Exception {
        String id = request.getParameter("id");
        Release command = null;
        if(id == null || id.equals("")) {
            command = new Release();
        } else {
            command = releaseService.getReleaseById(id);
        }
        return command;        
    }
    
    protected ModelAndView onSubmit(HttpServletRequest request,
            HttpServletResponse response, Object command, BindException errors)
            throws Exception {
        Release release = (Release) command;
        if(release.getId() == null || release.getId().equals("")) {
            releaseService.saveRelease(release);
        } else {
            releaseService.updateRelease(release);
        }
        return new ModelAndView(new RedirectView(getSuccessView(), false));
    }
}

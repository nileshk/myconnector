package com.myconnector.web.controller;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;

import com.myconnector.service.ReleaseUserService;
import com.myconnector.service.UserService;
import com.myconnector.web.ChecklistCommand;

/**
 * 
 * @author Nilesh Kapadia (nileshka@gmail.com)
 */
public class ReleaseUserSelectionController extends SimpleFormController {

    Logger logger = Logger.getLogger(ReleaseUserSelectionController.class); 
    
    UserService userService;

    ReleaseUserService releaseUserService;

    public void setReleaseUserService(ReleaseUserService releaseUserService) {
        this.releaseUserService = releaseUserService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    
    public ReleaseUserSelectionController() {
        setCommandClass(ChecklistCommand.class);
    }
    
    protected Object formBackingObject(HttpServletRequest request)
            throws Exception {
        return new ChecklistCommand();
    }
    
    protected ModelAndView showForm(HttpServletRequest request,
            HttpServletResponse response, BindException errors) throws Exception {
        ModelAndView mv = super.showForm(request, response, errors);
        
        List userList = userService.getList();
        mv.addObject("userList", userList);        
        
        return mv;
    }
    
    protected ModelAndView onSubmit(HttpServletRequest request,
            HttpServletResponse response, Object command, BindException errors)
            throws Exception {
        ChecklistCommand checklistCommand = (ChecklistCommand) command;
        List list = checklistCommand.getChecks();
        Iterator it = list.iterator();
        while(it.hasNext()) {
            String id = (String) it.next();
            logger.debug(id);
            if(id == null || id.length() < 1) {
                it.remove();
            }
        }
        releaseUserService.addUserList(checklistCommand.getId(), list);
        
        String view = getSuccessView() + "?id=" + checklistCommand.getId(); 
        return new ModelAndView(new RedirectView(view, false));
    }
}
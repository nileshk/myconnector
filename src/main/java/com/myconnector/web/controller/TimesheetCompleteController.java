package com.myconnector.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.view.RedirectView;

import com.myconnector.service.TsEntryService;

/**
 * 
 * @author Nilesh Kapadia (nileshka@gmail.com)
 */
public class TimesheetCompleteController implements Controller {

    private TsEntryService tsEntryService;

    String view;

    public void setTsEntryService(TsEntryService tsEntryService) {
        this.tsEntryService = tsEntryService;
    }

    public void setView(String view) {
        this.view = view;
    }

    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        String id = request.getParameter("id");
        tsEntryService.complete(id, true);
        return new ModelAndView(new RedirectView(view, false));
    }

}

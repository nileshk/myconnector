package com.myconnector.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.myconnector.domain.Release;
import com.myconnector.service.ReleaseService;

/**
 * 
 * @author Nilesh Kapadia (nileshka@gmail.com)
 */
public class ReleaseViewController implements Controller {

    ReleaseService releaseService;

    String view;

    public void setReleaseService(ReleaseService releaseService) {
        this.releaseService = releaseService;
    }

    public void setView(String view) {
        this.view = view;
    }

    public ModelAndView handleRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        String id = request.getParameter("id");
        Release release = releaseService.getReleaseById(id);
        List fileList = releaseService.getFileListByReleaseId(id);
        List userList = releaseService.getUserListByReleaseId(id);
        Map model = new HashMap();
        model.put("release", release);
        model.put("fileList", fileList);
        model.put("userList", userList);
        return new ModelAndView(view, model);
    }
}
package com.myconnector.web.controller;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;

import com.myconnector.domain.interfaces.HasId;
import com.myconnector.service.GenericService;

/**
 * 
 * @author Nilesh Kapadia (nileshka@gmail.com)
 */
public class GenericEditController extends SimpleFormController {

    static Logger logger = Logger.getLogger(GenericEditController.class);

    protected GenericService service;

    public void setService(GenericService service) {
        this.service = service;
    }

    protected Object formBackingObject(HttpServletRequest request)
            throws Exception {
        String id = request.getParameter("id");
        Object command = null;
        if (id == null || id.equals("")) {
            command = getCommandClass().newInstance();
        } else {
            command = service.getById(id);
        }
        return command;
    }

    @SuppressWarnings("unchecked")
	protected ModelAndView onSubmit(HttpServletRequest request,
            HttpServletResponse response, Object command, BindException errors)
            throws Exception {
    	Serializable commandSerializable = (Serializable) command;
        String id = null;
        if(commandSerializable instanceof HasId) {
            id = ((HasId)commandSerializable).getId();
        } else {
            id = request.getParameter("id");
        }
        if (id == null || id.equals("")) {
            service.save(commandSerializable);
        } else {
            service.update(commandSerializable);
        }
        return new ModelAndView(new RedirectView(getSuccessView(), false));
    }
}
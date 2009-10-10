package com.myconnector.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.myconnector.service.GenericService;
import com.myconnector.service.GenericWithUserService;

/**
 * 
 * @author Nilesh Kapadia (nileshka@gmail.com)
 */
public class GenericListController implements Controller {

	static Logger logger = Logger.getLogger(GenericListController.class);

	private GenericService service;

	protected String view;

	protected String listName = "list";

	public void setListName(String listName) {
		this.listName = listName;
	}

	public void setView(String view) {
		this.view = view;
	}

	public void setService(GenericService genericService) {
		this.service = genericService;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.web.servlet.mvc.Controller#handleRequest(javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		List list = null;
		if (service instanceof GenericWithUserService) {
			list = ((GenericWithUserService) service).getListForCurrentUser();
		} else {
			list = service.getList();
		}
		Map model = new HashMap();
		model.put(listName, list);
		return new ModelAndView(view, model);
	}
}
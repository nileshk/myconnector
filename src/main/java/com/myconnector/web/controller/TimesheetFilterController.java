package com.myconnector.web.controller;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.util.WebUtils;

import com.myconnector.web.TimesheetFilterCommand;

/**
 * 
 * @author Nilesh Kapadia (nileshka@gmail.com)
 */
public class TimesheetFilterController extends SimpleFormController implements Controller {

    public TimesheetFilterController() {
        setCommandClass(TimesheetFilterCommand.class);
    }

    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder)
            throws Exception {
        NumberFormat nf = NumberFormat.getInstance(request.getLocale());
        binder.registerCustomEditor(java.lang.Integer.class, new CustomNumberEditor(
                java.lang.Integer.class, nf, true));
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(sdf, true));
    }

    protected Object formBackingObject(HttpServletRequest request) throws Exception {
        TimesheetFilterCommand object = new TimesheetFilterCommand();
        return object;
    }

    protected ModelAndView showForm(HttpServletRequest request, HttpServletResponse response,
            BindException errors) throws Exception {
        return new ModelAndView(new RedirectView(getFormView(), false));
    }

    protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response,
            Object command, BindException errors) throws Exception {
        TimesheetFilterCommand filter = (TimesheetFilterCommand) command;

        WebUtils.setSessionAttribute(request, "SdateFilter", filter.getDateFilter());
        WebUtils.setSessionAttribute(request, "SweekFilter", filter.getWeekFilter());
        WebUtils.setSessionAttribute(request, "SmonthFilter", filter.getMonthFilter());

        return new ModelAndView(new RedirectView(getSuccessView(), false));
    }

}

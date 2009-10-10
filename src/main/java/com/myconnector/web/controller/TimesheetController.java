package com.myconnector.web.controller;

import java.text.NumberFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.util.WebUtils;

import com.myconnector.domain.TsActivity;
import com.myconnector.domain.TsCustomer;
import com.myconnector.domain.TsEntry;
import com.myconnector.service.TsActivityService;
import com.myconnector.service.TsCustomerService;
import com.myconnector.service.TsEntryService;

/**
 * 
 * @author Nilesh Kapadia (nileshka@gmail.com)
 */
public class TimesheetController extends SimpleFormController implements Controller {

    protected TsEntryService tsEntryService;

    protected TsActivityService tsActivityService;

    protected TsCustomerService tsCustomerService;

    public void setTsActivityService(TsActivityService tsActivityService) {
        this.tsActivityService = tsActivityService;
    }

    public void setTsCustomerService(TsCustomerService tsCustomerService) {
        this.tsCustomerService = tsCustomerService;
    }

    public void setTsEntryService(TsEntryService tsEntryService) {
        this.tsEntryService = tsEntryService;
    }

    public TimesheetController() {
        setCommandClass(TsEntry.class);
    }
    
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder)
            throws Exception {
        NumberFormat nf = NumberFormat.getInstance(request.getLocale());
        binder.registerCustomEditor(java.lang.Integer.class, new CustomNumberEditor(
                java.lang.Integer.class, nf, true));        
        binder.registerCustomEditor(java.math.BigDecimal.class, new CustomNumberEditor(
                java.math.BigDecimal.class, nf, true));        
    }

    protected Object formBackingObject(HttpServletRequest request) throws Exception {
        TsEntry entry = new TsEntry();
        entry.setActivity(new TsActivity());
        entry.setCustomer(new TsCustomer());
        return entry;
    }

    private void prepareModel(ModelAndView mv, HttpServletRequest request) {
        Date dateFilter = (Date) WebUtils.getSessionAttribute(request, "SdateFilter");
        Date weekFilter = (Date) WebUtils.getSessionAttribute(request, "SweekFilter");
        List entryList = null;
        if(dateFilter != null) {
            entryList = tsEntryService.getListByCurrentUserAndDate(dateFilter);
        } else if(weekFilter != null) {
            entryList = tsEntryService.getListByCurrentUserAndWeek(weekFilter);
        } else {
            entryList = tsEntryService.getListByCurrentUser();
        }
        
        
        List activityList = tsActivityService.getList();
        List customerList = tsCustomerService.getList();

        mv.addObject("entryList", entryList);
        mv.addObject("activityList", activityList);
        mv.addObject("customerList", customerList);
    }

    protected ModelAndView showForm(HttpServletRequest request, HttpServletResponse response,
            BindException errors) throws Exception {
        ModelAndView mv = super.showForm(request, response, errors);
        prepareModel(mv, request);
        return mv;
    }

    protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response,
            Object command, BindException errors) throws Exception {
        ModelAndView mv = super.onSubmit(request, response, command, errors);        
        
        TsEntry entry = (TsEntry) command;
        tsEntryService.save(entry);        
        
        prepareModel(mv, request);        
        return mv;
    }
    
}

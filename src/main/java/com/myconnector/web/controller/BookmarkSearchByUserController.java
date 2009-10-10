package com.myconnector.web.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.util.WebUtils;

import com.myconnector.domain.PageIndex;
import com.myconnector.indexer.SearchService;
import com.myconnector.web.SearchCommand;

public class BookmarkSearchByUserController extends SimpleFormController implements Controller {

    static Logger logger = Logger.getLogger(BookmarkSearchByUserController.class);

    private SearchService searchService;
    
    static private String searchTypeIndicator = "byUser";

    public void setSearchService(SearchService searchService) {
        this.searchService = searchService;
    }

    public BookmarkSearchByUserController() {
        setCommandClass(SearchCommand.class);
    }

    @Override
    protected ModelAndView showForm(HttpServletRequest arg0, HttpServletResponse arg1, BindException arg2) throws Exception {
    	// TODO Auto-generated method stub
    	ModelAndView mv = super.showForm(arg0, arg1, arg2);
        mv.addObject(searchTypeIndicator, Boolean.TRUE);
        logger.debug("searching by user screen");
        return mv;
    }
    
    @Override
    protected Object formBackingObject(HttpServletRequest request) throws Exception {
        SearchCommand searchCommand = new SearchCommand();
        searchCommand.setSearch(request.getParameter("search"));
        return searchCommand;
    }

    @SuppressWarnings("unchecked")
    @Override
    protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response,
            Object command, BindException errors) throws Exception {
        Date startDate = new Date();
        SearchCommand searchCommand = (SearchCommand) command;
        String uid = (String) WebUtils.getSessionAttribute(request, "sessionUserId");
        List<PageIndex> searchResults = searchService.searchByUser(searchCommand.getSearch(), uid);
        Map model = new HashMap();
        model.put("results", searchResults);
        model.put("query", searchCommand.getSearch());
        model.put(searchTypeIndicator, Boolean.TRUE);
        logger.debug("searching by user");
        Date endDate = new Date();
        float time = endDate.getTime() - startDate.getTime();
        float timeElapsed = time / 100;
        String timeElapsedString = String.valueOf(timeElapsed);         
        model.put("timeElapsed", timeElapsedString);        
        return new ModelAndView(getSuccessView(), model);
    }

}

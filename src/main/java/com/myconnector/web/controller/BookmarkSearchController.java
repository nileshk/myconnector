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

public class BookmarkSearchController extends SimpleFormController implements Controller {

    static Logger logger = Logger.getLogger(BookmarkSearchController.class);

    private SearchService searchService;

    public void setSearchService(SearchService searchService) {
        this.searchService = searchService;
    }

    public BookmarkSearchController() {
        setCommandClass(SearchCommand.class);
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
        List<PageIndex> searchResults = null;
        if(request.getParameter("submit.search.my") != null) {
            logger.debug("submit.search.my");
            String uid = (String) WebUtils.getSessionAttribute(request, LoginController.USER_ID);
            searchResults = searchService.searchByUser(searchCommand.getSearch(), uid);            
        } else if(request.getParameter("submit.search.network") != null) {
            logger.debug("submit.search.network");
            String uid = (String) WebUtils.getSessionAttribute(request, LoginController.USER_ID);
            searchResults = searchService.searchByUserAndFriends(searchCommand.getSearch(), uid);
        } else if(request.getParameter("submit.search.all") != null) {
            logger.debug("submit.search.all");
            searchResults = searchService.search(searchCommand.getSearch());
        }        
        Map model = new HashMap();
        model.put("results", searchResults);
        model.put("query", searchCommand.getSearch());
        Date endDate = new Date();
        float time = endDate.getTime() - startDate.getTime();
        float timeElapsed = time / 1000;
        String timeElapsedString = String.valueOf(timeElapsed);         
        model.put("timeElapsed", timeElapsedString);
        return new ModelAndView(getSuccessView(), model);
    }

}

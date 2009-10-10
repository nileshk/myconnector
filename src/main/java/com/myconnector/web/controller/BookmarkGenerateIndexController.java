package com.myconnector.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.myconnector.indexer.IndexResults;
import com.myconnector.indexer.IndexService;

public class BookmarkGenerateIndexController implements Controller {
    
    static Logger logger = Logger.getLogger(BookmarkGenerateIndexController.class);

    private String view = "generateIndexView";
    private IndexService indexService;

    public void setIndexService(IndexService indexService) {
        this.indexService = indexService;
    }

    public void setView(String view) {
        this.view = view;
    }

    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        Map<String, Object> model = new HashMap<String, Object>();
        IndexResults indexResults = null;
        // verify an HTTP post to verify not precaching before calling generateIndex
        if(request.getParameter("submit.generateindex") != null) {
            logger.debug("BookmarkGenerateIndexController: Generating index");
            indexResults = indexService.generateIndex();
        } else if(request.getParameter("submit.generateindexfromcache") != null) {
            logger.debug("BookmarkGenerateIndexController: Generating index from cache");
            indexResults = indexService.generateIndexFromCache();
        } else if(request.getParameter("submit.generate.incremental") != null) {
            logger.debug("BookmarkGenerateIndexController: Generating index incrementally");
            indexResults = indexService.generateIndexIncremental();
        } else if(request.getParameter("submit.generate.incremental.limit") != null) {
            logger.debug("BookmarkGenerateIndexController: Generating index incrementally w/ limit");
            indexResults = indexService.generateIndexIncrementalWithLimit(Integer.valueOf(30));
        } else if(request.getParameter("submit.generate.incremental.new") != null) {
            logger.debug("BookmarkGenerateIndexController: Generating index incrementally with entirely new page_index table");
            indexResults = indexService.generateIndexIncrementalNewIndex();
        } else {
            logger.debug("BookmarkGenerateIndexController: Called generate index without POST request.");
            model.put("errorMessage", "Called generate index without POST request.");
        }
        model.put("results", indexResults);
        model.put("noPagesGenerated", indexResults.getIndexedPages().size());
        model.put("noErrors", indexResults.getErrors().size());
        return new ModelAndView(view, model);
    }

}

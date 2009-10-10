package com.myconnector.indexer;

import java.util.ArrayList;
import java.util.List;

public class IndexResults {

    public static String MALFORMED_URL = "MalformedURL";
    
    public static String IO_EXCEPTION = "IOException";
    
    private List<String> indexedPages;

    private List<ErrorResult> errors;

    public IndexResults() {
        super();
        indexedPages = new ArrayList<String>();
        errors = new ArrayList<ErrorResult>();
    }

    public List<String> getIndexedPages() {
        return indexedPages;
    }

    public List<ErrorResult> getErrors() {
        return errors;
    }
   
    public void addSuccess(String url) {
        indexedPages.add(url);
    }
    
    public void addError(String url, String error) {
        errors.add(new ErrorResult(url, error));
    }

}

package com.myconnector.indexer;

public class ErrorResult {

    private String url;

    private String errorMessage;

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String error) {
        this.errorMessage = error;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ErrorResult() {
        super();
    }

    public ErrorResult(String url, String error) {
        super();
        this.errorMessage = error;
        this.url = url;
    }

}

package com.myconnector.domain;

import java.io.Serializable;

public class PageIndexPK implements Serializable {

    private static final long serialVersionUID = 1L;

    private PageList page;
    private String word;

    public PageIndexPK() {
        super();
    }

    public PageIndexPK(PageList page, String word) {
        super();
        this.page = page;
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public boolean equals (Object obj) {
        if(null == obj) return false;
        if(this == obj) return true;
        
        final PageIndexPK pk = (PageIndexPK) obj;
        
        // XXX null check?
        if(!pk.getPage().equals(getPage())) return false;
        if(!pk.getWord().equals(getWord())) return false;
        
        return true;
    }
    
    public int hashCode() {
        String hashStr = this.getClass().getName() + ":" + getPage().hashCode() + getWord().hashCode();
        return hashStr.hashCode();        
    }

    public PageList getPage() {
        return page;
    }

    public void setPage(PageList page) {
        this.page = page;
    }
}

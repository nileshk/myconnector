package com.myconnector.domain;

import java.io.Serializable;

public class PageIndex implements Serializable {

    private static final long serialVersionUID = 1L;

    private PageIndexPK compId;
    private Integer occurances;

    public PageIndex() {        
    }
    
    public PageIndex(PageIndexPK compId, Integer occurances) {
        this.compId = compId;
        this.occurances = occurances;
    }
    
    public PageIndexPK getCompId() {
        return compId;
    }

    public void setCompId(PageIndexPK compId) {
        this.compId = compId;
    }

    public Integer getOccurances() {
        return occurances;
    }

    public void setOccurances(Integer occurances) {
        this.occurances = occurances;
    }

    public boolean equals (Object obj) {
        if(null == obj) return false;
        if(this == obj) return true;
        
        final PageIndex pi = (PageIndex) obj;
        
        if(!pi.getCompId().equals(getCompId())) return false;
        
        return true;
    }
    
    public int hashCode() {
        String hashStr = this.getClass().getName() + ":" + getCompId().hashCode();
        return hashStr.hashCode();        
    }    
    
}

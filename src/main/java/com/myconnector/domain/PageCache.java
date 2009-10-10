package com.myconnector.domain;

import java.io.Serializable;
import java.util.Date;

public class PageCache implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String pageText;
    private Date timeLoaded;
    private PageList page;

    public PageCache() {
        super();
    }

    public PageCache(Integer id, String pageText, Date timeLoaded) {
        super();
        this.id = id;
        this.pageText = pageText;
        this.timeLoaded = timeLoaded;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPageText() {
        return pageText;
    }

    public void setPageText(String pageText) {
        this.pageText = pageText;
    }

    public Date getTimeLoaded() {
        return timeLoaded;
    }

    public void setTimeLoaded(Date timeLoaded) {
        this.timeLoaded = timeLoaded;
    }

    public PageList getPage() {
        return page;
    }

    public void setPage(PageList page) {
        this.page = page;
    }

    public boolean equals(Object obj) {
        if (null == obj)
            return false;
        if (this == obj)
            return true;

        final PageCache pageList = (PageCache) obj;

        if (!pageList.getId().equals(getId()))
            return false;
        if (!pageList.getPageText().equals(getPageText()))
            return false;
        if (!pageList.getTimeLoaded().equals(getTimeLoaded()))
            return false;

        return true;
    }

    public int hashCode() {
        String hashStr = this.getClass().getName() + ":" + getId().hashCode()
                + getPageText().hashCode() + getTimeLoaded().hashCode();
        return hashStr.hashCode();
    }
}

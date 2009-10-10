package com.myconnector.domain;

import java.io.Serializable;
import java.util.Date;

public class PageList implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String url;
    private String title;
    private PageCache pageCache;
    private Integer cacheFailed;

    public PageList() {
        super();
    }

    public PageList(Integer id, String url) {
        super();
        this.id = id;
        this.url = url;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getCacheFailed() {
        return cacheFailed;
    }

    public void setCacheFailed(Integer cacheFailed) {
        this.cacheFailed = cacheFailed;
    }

    public PageCache getPageCache() {
        return pageCache;
    }

    public void setPageCache(PageCache pageCache) {
        this.pageCache = pageCache;
    }

    public void addPageCache(PageCache cache) {
        cache.setPage(this);
        cache.setId(this.getId());
        if (cache.getTimeLoaded() == null) {
            cache.setTimeLoaded(new Date());
        }
        setPageCache(cache);
    }

    public void addPageCache(String cacheText) {
        PageCache cache = new PageCache();
        cache.setPageText(cacheText);
        cache.setPage(this);
        cache.setId(this.getId());
        if (cache.getTimeLoaded() == null) {
            cache.setTimeLoaded(new Date());
        }
        setPageCache(pageCache);
    }

    public boolean equals(Object obj) {
        if (null == obj)
            return false;
        if (this == obj)
            return true;

        final PageList pageList = (PageList) obj;

        if (!pageList.getId().equals(getId()))
            return false;
        if (!pageList.getUrl().equals(getUrl()))
            return false;

        return true;
    }

    public int hashCode() {
        String hashStr = this.getClass().getName() + ":" + getId().hashCode() + getUrl().hashCode();
        return hashStr.hashCode();
    }
}

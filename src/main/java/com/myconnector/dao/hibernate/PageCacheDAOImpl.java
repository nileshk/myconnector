package com.myconnector.dao.hibernate;

import com.myconnector.dao.PageCacheDAO;
import com.myconnector.domain.PageCache;

public class PageCacheDAOImpl extends AbstractHibernateDAOImpl<PageCache, Integer> implements PageCacheDAO {

    @Override
    protected Class<PageCache> getDomainClass() {
        return PageCache.class;
    }
    
}

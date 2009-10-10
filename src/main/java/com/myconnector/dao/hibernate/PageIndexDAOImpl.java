package com.myconnector.dao.hibernate;

import java.util.List;

import org.apache.log4j.Logger;

import com.myconnector.dao.PageIndexDAO;
import com.myconnector.domain.PageIndex;
import com.myconnector.domain.PageIndexPK;

public class PageIndexDAOImpl extends AbstractHibernateDAOImpl<PageIndex, PageIndexPK> implements
        PageIndexDAO {

    static Logger logger = Logger.getLogger(PageIndexDAOImpl.class);
    
    @Override
    protected Class<PageIndex> getDomainClass() {
        return PageIndex.class;
    }
    
    @SuppressWarnings("unchecked")
    public List<PageIndex> search(String word) {
        return (getHibernateTemplate().find("from " + domainClass.getName()
                + " x where lower(x.compId.word) = ? order by x.occurances desc", word.toLowerCase()));
    }

    @SuppressWarnings("unchecked")
    public List<PageIndex> searchByUser(String word, String uid) {
    	Object[] params = new Object[2];
    	params[0] = word.toLowerCase();
    	params[1] = uid;
        return (getHibernateTemplate().find("select x from " + domainClass.getName() + " x, "
        		+ "com.myconnector.domain.PageList pl, "
        		+ "com.myconnector.domain.Bookmark b "
                + "where lower(x.compId.word) = ?"
                + "and x.compId.page.id = pl.id "
                + "and pl.url = b.url "
                + "and b.userData.id = ?"
                + "order by x.occurances desc", params));
    }    
    
    @SuppressWarnings("unchecked")
    public List<PageIndex> searchOr(String[] words) {
        // XXX lowercase words?
        
        StringBuilder sb = new StringBuilder("from " + domainClass.getName());
        sb.append(" x ");
        sb.append("where (");
        sb.append("lower(x.compId.word) = ? ");
        for(int i = 1; i < words.length; i++) {
            sb.append("or lower(x.compId.word) = ? ");
        }
        sb.append(") ");
        sb.append("order by x.occurances desc");
        
        return (getHibernateTemplate().find(sb.toString(), words));
    }

	@SuppressWarnings("unchecked")
	public List<PageIndex> searchOrByUser(String[] words, String uid) {
		Object[] params = new Object[words.length + 1];
		int j = 0;
		for(j = 0; j < words.length; j++) {
			params[j] = words[j];
		}
		params[j] = uid;
        StringBuilder sb = new StringBuilder("select x from " + domainClass.getName());
        sb.append(" x, ");        
		sb.append("com.myconnector.domain.PageList pl, ");
		sb.append("com.myconnector.domain.Bookmark b ");
		sb.append("where (");
        sb.append("lower(x.compId.word) = ? ");
        for(int i = 1; i < words.length; i++) {
            sb.append("or lower(x.compId.word) = ? ");
        }
        sb.append(") ");
        sb.append("and x.compId.page.id = pl.id ");
        sb.append("and pl.url = b.url ");
        sb.append("and b.userData.id = ? ");
        sb.append("order by x.occurances desc");
        String query = sb.toString();
        logger.debug("PageIndexDAOImpl.searchOrByUser query: " + query);
        
        return (getHibernateTemplate().find(query, params));
	}    
    
    @SuppressWarnings("unchecked")
    public List<PageIndex> searchAnd(String[] words) {
        // XXX lowercase words?
        
        // select p1.id from page_index p1, page_index p2
        // where p1.word = 'slashdot' and p2.word = 'linux' and p1.id = p2.id
        
        String className = domainClass.getName();
        
        StringBuilder sb = new StringBuilder("select p0 from " + className + " p0 ");
        if(words.length > 1) {
            for(int i = 1; i < words.length; i++) {
                sb.append(", ");
                sb.append(className);
                sb.append(" p");
                sb.append(i);
                sb.append(" ");
            }
        }
        sb.append("where ");
        sb.append("lower(p0.compId.word) = ? ");
        for(int i = 1; i < words.length; i++) {
            sb.append("and lower(p");
            sb.append(i);
            sb.append(".compId.word) = ? ");
        }
        if(words.length > 1) {
            sb.append("and ");
            for(int i = 1; i < words.length; i++) {
                sb.append("p");
                int j = i - 1;
                sb.append(j);
                sb.append(".compId.page ");
                sb.append("= p");
                sb.append(i);
                sb.append(".compId.page ");
                if(i < words.length - 1) {
                    sb.append("and ");
                }
            }
        }
        
        sb.append("order by p0.occurances desc");
        
        String query = sb.toString();
        logger.debug(query);
        
        return (getHibernateTemplate().find(query, words));
    }

	@SuppressWarnings("unchecked")
	public List<PageIndex> searchAndByUser(String[] words, String uid) {
		Object[] params = new Object[words.length + 1];
		int k = 0;
		for(k = 0; k < words.length; k++) {
			params[k] = words[k];
		}
		params[k] = uid;
		
        String className = domainClass.getName();
        
        StringBuilder sb = new StringBuilder("select p0 from " + className + " p0, ");
		sb.append("com.myconnector.domain.PageList pl, ");
		sb.append("com.myconnector.domain.Bookmark b ");        
        if(words.length > 1) {
            for(int i = 1; i < words.length; i++) {
                sb.append(", ");
                sb.append(className);
                sb.append(" p");
                sb.append(i);
                sb.append(" ");
            }
        }
        sb.append("where ");
        sb.append("lower(p0.compId.word) = ? ");
        for(int i = 1; i < words.length; i++) {
            sb.append("and lower(p");
            sb.append(i);
            sb.append(".compId.word) = ? ");
        }
        if(words.length > 1) {
            sb.append("and ");
            for(int i = 1; i < words.length; i++) {
                sb.append("p");
                int j = i - 1;
                sb.append(j);
                sb.append(".compId.page ");
                sb.append("= p");
                sb.append(i);
                sb.append(".compId.page ");
                if(i < words.length - 1) {
                    sb.append("and ");
                }
            }
        }
        sb.append("and p0.compId.page.id = pl.id ");
        sb.append("and pl.url = b.url ");
        sb.append("and b.userData.id = ? ");
        sb.append("order by p0.occurances desc");        
        String query = sb.toString();
        logger.debug(query);
        
        return (getHibernateTemplate().find(query, params));
	}

    @SuppressWarnings("unchecked")
    public List<PageIndex> searchByUsers(String word, List<String> uids) {
        assert(uids != null);
        assert(uids.size() > 0);
        Object[] params = new Object[1 + uids.size()];
        params[0] = word.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < uids.size(); i++) {
            params[i + 1] = uids.get(i);
            if(i == 0) {
                sb.append("?");
            } else {
                sb.append(",?");
            }
        }
        
        String query = "select x from " + domainClass.getName() + " x, "
                    + "com.myconnector.domain.PageList pl, "
                    + "com.myconnector.domain.Bookmark b "
                    + "where lower(x.compId.word) = ? "
                    + "and x.compId.page.id = pl.id "
                    + "and pl.url = b.url "
                    + "and b.userData.id IN (" + sb.toString() + ") "
                    + "order by x.occurances desc";
        
        logger.debug(query);
        
        return getHibernateTemplate().find(query, params);
    }

    @SuppressWarnings("unchecked")
    public List<PageIndex> searchOrByUsers(String[] words, List<String> uids) {
        assert(uids != null);
        assert(uids.size() > 0);
        Object[] params = new Object[words.length + uids.size()];
        int j = 0;
        for(j = 0; j < words.length; j++) {
            params[j] = words[j];
        }
        StringBuilder uidBinds = new StringBuilder();
        for (int i = 0; i < uids.size(); i++) {
            params[j + i] = uids.get(i);
            if(i == 0) {
                uidBinds.append("?");
            } else {
                uidBinds.append(",?");
            }            
        }
        
        StringBuilder sb = new StringBuilder("select x from " + domainClass.getName());
        sb.append(" x, ");        
        sb.append("com.myconnector.domain.PageList pl, ");
        sb.append("com.myconnector.domain.Bookmark b ");
        sb.append("where (");
        sb.append("lower(x.compId.word) = ? ");
        for(int i = 1; i < words.length; i++) {
            sb.append("or lower(x.compId.word) = ? ");
        }
        sb.append(") ");
        sb.append("and x.compId.page.id = pl.id ");
        sb.append("and pl.url = b.url ");
        sb.append("and b.userData.id IN (");
        sb.append(uidBinds);
        sb.append(") ");
        sb.append("order by x.occurances desc");
        String query = sb.toString();
        logger.debug("PageIndexDAOImpl.searchOrByUser query: " + query);
        
        return (getHibernateTemplate().find(query, params));
    }

    @SuppressWarnings("unchecked")
    public List<PageIndex> searchAndByUsers(String[] words, List<String> uids) {
        assert(uids != null);
        assert(uids.size() > 0);
        Object[] params = new Object[words.length + uids.size()];
        int k = 0;
        for(k = 0; k < words.length; k++) {
            params[k] = words[k];
        }
        StringBuilder uidBinds = new StringBuilder();
        for (int i = 0; i < uids.size(); i++) {
            params[k + i] = uids.get(i);
            if(i == 0) {
                uidBinds.append("?");
            } else {
                uidBinds.append(",?");
            }            
        }
        
        String className = domainClass.getName();
        
        StringBuilder sb = new StringBuilder("select p0 from " + className + " p0, ");
        sb.append("com.myconnector.domain.PageList pl, ");
        sb.append("com.myconnector.domain.Bookmark b ");        
        if(words.length > 1) {
            for(int i = 1; i < words.length; i++) {
                sb.append(", ");
                sb.append(className);
                sb.append(" p");
                sb.append(i);
                sb.append(" ");
            }
        }
        sb.append("where ");
        sb.append("lower(p0.compId.word) = ? ");
        for(int i = 1; i < words.length; i++) {
            sb.append("and lower(p");
            sb.append(i);
            sb.append(".compId.word) = ? ");
        }
        if(words.length > 1) {
            sb.append("and ");
            for(int i = 1; i < words.length; i++) {
                sb.append("p");
                int j = i - 1;
                sb.append(j);
                sb.append(".compId.page ");
                sb.append("= p");
                sb.append(i);
                sb.append(".compId.page ");
                if(i < words.length - 1) {
                    sb.append("and ");
                }
            }
        }
        sb.append("and p0.compId.page.id = pl.id ");
        sb.append("and pl.url = b.url ");
        sb.append("and b.userData.id IN (");
        sb.append(uidBinds);
        sb.append(") ");
        sb.append("order by p0.occurances desc");        
        String query = sb.toString();
        logger.debug(query);
        
        return (getHibernateTemplate().find(query, params));
    }
    
}

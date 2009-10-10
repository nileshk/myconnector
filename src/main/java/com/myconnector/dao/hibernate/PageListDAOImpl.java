package com.myconnector.dao.hibernate;

import java.util.List;

import org.apache.log4j.Logger;

import com.myconnector.dao.PageListDAO;
import com.myconnector.domain.PageList;

public class PageListDAOImpl extends AbstractHibernateDAOImpl<PageList, Integer> implements PageListDAO {

    Logger logger = Logger.getLogger(PageListDAOImpl.class);
    
    @Override
    protected Class<PageList> getDomainClass() {
        return PageList.class;
    }    
    
    @SuppressWarnings("unchecked")
    public boolean checkUrl(String url) {
        List<Integer> list = (List<Integer>)getHibernateTemplate().find("select count(*) from com.myconnector.domain.PageList x " +
                "where x.url = ?", url);
        Integer count = list.get(0);
//        if(logger.isDebugEnabled() && count != null) {
//            logger.debug("Count: " + count);
//        }
        if(count == null || count.intValue() == 0) {
            return false;
        } else {
            return true;
        }
    }
    
    // The following search methods are being used
    
	public List<PageList> search(String word) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<PageList> searchByUser(String word, String uid) {
    	Object[] params = new Object[2];
    	params[0] = word.toLowerCase();
    	params[1] = uid;
        return ((List<PageList>)getHibernateTemplate().find("select distinct pl from com.myconnector.domain.PageIndex x, "
        		+ "com.myconnector.domain.PageList pl, "
        		+ "com.myconnector.domain.Bookmark b "
                + "where lower(x.compId.word) = ?"
                + "and x.compId.page.id = pl.id "
                + "and pl.url = b.url "
                + "and b.userData.id = ?"
                + "order by x.occurances desc", params));
	}

	public List<PageList> searchOr(String[] words) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<PageList> searchOrByUser(String[] words, String uid) {
		Object[] params = new Object[words.length + 1];
		int j = 0;
		for(j = 0; j < words.length; j++) {
			params[j] = words[j];
		}
		params[j] = uid;
        StringBuilder sb = new StringBuilder("select distinct pl from com.myconnector.domain.PageIndex");
        sb.append(" x, ");        
		sb.append("com.myconnector.domain.PageList pl, ");
		sb.append("com.myconnector.domain.Bookmark b ");
		sb.append("where ");
        sb.append("lower(x.compId.word) = ? ");
        for(int i = 1; i < words.length; i++) {
            sb.append("or lower(x.compId.word) = ? ");
        }
        sb.append("and x.compId.page.id = pl.id ");
        sb.append("and pl.url = b.url ");
        sb.append("and b.userData.id = ? ");
        //sb.append("order by x.occurances desc");
        
        return ((List<PageList>)getHibernateTemplate().find(sb.toString(), params));
	}

	public List<PageList> searchAnd(String[] words) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<PageList> searchAndByUser(String[] words, String uid) {
		Object[] params = new Object[words.length + 1];
		int k = 0;
		for(k = 0; k < words.length; k++) {
			params[k] = words[k];
		}
		params[k] = uid;
		      
        StringBuilder sb = new StringBuilder("select distinct pl from com.myconnector.domain.PageIndex p0, ");
		sb.append("com.myconnector.domain.PageList pl, ");
		sb.append("com.myconnector.domain.Bookmark b ");        
        if(words.length > 1) {
            for(int i = 1; i < words.length; i++) {
                sb.append(", ");
                sb.append("com.myconnector.domain.PageIndex");
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
        //sb.append("order by p0.occurances desc");        
        String query = sb.toString();
        logger.debug(query);
        
        return ((List<PageList>)getHibernateTemplate().find(query, params));
	}
    
}

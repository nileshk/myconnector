package com.myconnector.dao.hibernate;

import java.util.Date;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.type.Type;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.myconnector.dao.TsEntryDAO;
import com.myconnector.domain.TsEntry;

/**
 * 
 * @author Nilesh Kapadia (nileshka@gmail.com)
 */
public class TsEntryDAOImpl extends HibernateDaoSupport implements TsEntryDAO {

    public TsEntry load(String id) {
        return (TsEntry) getHibernateTemplate().load(TsEntry.class, id);
    }

    public void update(TsEntry entry) {
        getHibernateTemplate().update(entry);
    }

    public void save(TsEntry entry) {
        getHibernateTemplate().save(entry);
    }

    public void delete(TsEntry entry) {
        getHibernateTemplate().delete(entry);
    }

    public void deleteById(String id) {
    	Object obj = load(id);
        getHibernateTemplate().delete(obj);
    }

    public List getList() {
        return (getHibernateTemplate().find("from com.myconnector.domain.TsEntry x"));
    }

    public List getListByUserId(String userId) {
        return (getHibernateTemplate().find(
                "from com.myconnector.domain.TsEntry x where x.user.id = ? " +
                "order by x.dateOccur desc, x.dateTimeStart desc", userId));
    }

    public List getListByUserId(String userId, String orderBy, boolean descending) {        
        if (orderBy.equals("dateOccur") || orderBy.equals("dateTimeStart") || orderBy.equals("description")
                || orderBy.equals("hours")) {
        } else {
            throw new RuntimeException("invalid orderBy value");
        }
        String direction = descending ? "desc" : "asc";

        return (getHibernateTemplate().find(
                "from com.myconnector.domain.TsEntry x where x.userData.id = ? " +
                "order by x." + orderBy + " " + direction, userId));
    }

    public List getListByUserIdAndDate(String userId, Date date) {
        Object[] oa = new Object[2];
        oa[0] = userId;
        oa[1] = date;
        return (getHibernateTemplate().find(
                "from com.myconnector.domain.TsEntry x where x.user.id = ? and x.dateOccur = ? " +
                "order by x.dateOccur desc, x.dateTimeStart desc", oa));        
    }

    public List getListByUserIdAndDateRange(String userId, Date startDate, Date endDate) {
        Object[] oa = new Object[3];
        oa[0] = userId;
        oa[1] = startDate;
        oa[2] = endDate;
        return (getHibernateTemplate().find(
                "from com.myconnector.domain.TsEntry x where x.user.id = ? " +
                "and x.dateOccur >= ? and x.dateOccur <= ? " +
                "order by x.dateOccur desc, x.dateTimeStart desc", oa));        
    }

}
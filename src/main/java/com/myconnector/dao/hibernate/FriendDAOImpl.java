package com.myconnector.dao.hibernate;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.ObjectNotFoundException;
import org.springframework.orm.hibernate3.HibernateObjectRetrievalFailureException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.myconnector.dao.FriendDAO;
import com.myconnector.domain.Friend;
import com.myconnector.domain.FriendPK;

/**
 * 
 * @author Nilesh Kapadia (nileshka@gmail.com)
 */
public class FriendDAOImpl extends HibernateDaoSupport implements FriendDAO {

    static Logger logger = Logger.getLogger(FriendDAOImpl.class);
    
    /*
     * @see com.myconnector.dao.FriendDAO#load(com.myconnector.domain.FriendPK)
     */
    public Friend load(FriendPK pk) {
        try {
            return (Friend) getHibernateTemplate().load(Friend.class, pk);
        } catch (HibernateObjectRetrievalFailureException ex) {
            logger.debug("Object not found, returning null:");
            logger.debug(ex);
            return null;
        }
    }

    /*
     * @see com.myconnector.dao.FriendDAO#update(com.myconnector.domain.Friend)
     */
    public void update(Friend friend) {
        getHibernateTemplate().update(friend);
    }

    /*
     * @see com.myconnector.dao.FriendDAO#save(com.myconnector.domain.Friend)
     */
    public void save(Friend friend) {
        getHibernateTemplate().save(friend);
    }

    /*
     * @see com.myconnector.dao.FriendDAO#saveOrUpdate(com.myconnector.domain.Friend)
     */
    public void saveOrUpdate(Friend friend) {
        getHibernateTemplate().saveOrUpdate(friend);
    }

    /*
     * @see com.myconnector.dao.FriendDAO#delete(com.myconnector.domain.Friend)
     */
    public void delete(Friend friend) {
        getHibernateTemplate().delete(friend);
    }

    /*
     * @see com.myconnector.dao.FriendDAO#getList()
     */
    public List getList() {
        return getHibernateTemplate().find("from com.myconnector.domain.Friend friend");
    }

    /*
     * @see com.myconnector.dao.FriendDAO#getListByUserId(java.lang.String)
     */
    public List getListByUserId(String userId) {
        return getHibernateTemplate().find(
                "from com.myconnector.domain.Friend friend where friend.userDataById.id = ?",
                userId);
    }

}
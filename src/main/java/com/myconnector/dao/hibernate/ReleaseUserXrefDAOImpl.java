package com.myconnector.dao.hibernate;

import org.apache.log4j.Logger;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.myconnector.dao.ReleaseUserXrefDAO;
import com.myconnector.domain.ReleaseUserXref;
import com.myconnector.domain.ReleaseUserXrefPK;

import java.util.Collection;
import java.util.List;

public class ReleaseUserXrefDAOImpl extends HibernateDaoSupport implements
		ReleaseUserXrefDAO {

	static Logger logger = Logger.getLogger(ReleaseUserXrefDAOImpl.class);

	public ReleaseUserXrefDAOImpl() {
	}

	public ReleaseUserXref load(ReleaseUserXrefPK pk) {
		return (ReleaseUserXref) getHibernateTemplate().load(
				ReleaseUserXref.class, pk);
	}

	public void update(ReleaseUserXref xref) {
		getHibernateTemplate().update(xref);
	}

	public void save(ReleaseUserXref xref) {
		getHibernateTemplate().save(xref);
	}

	public void delete(ReleaseUserXref xref) {
		getHibernateTemplate().delete(xref);
	}

	public List getList() {
		return (getHibernateTemplate()
				.find("from com.myconnector.domain.ReleaseUserXref xref"));
	}

	/*
	 * @see com.myconnector.dao.ReleaseUserXrefDAO#saveOrUpdateReleaseUserXref(com.myconnector.domain.ReleaseUserXref)
	 */
	public void saveOrUpdate(ReleaseUserXref xref) {
		getHibernateTemplate().saveOrUpdate(xref);
	}

	public void deleteByReleaseId(String id) {
		Collection objects = getHibernateTemplate()
				.find(
						"from com.myconnector.domain.ReleaseUserXref x where x.release.id = ?",
						id);
		getHibernateTemplate().deleteAll(objects);
	}

	public void deleteByUserId(String id) {
		Collection objects = getHibernateTemplate()
				.find(
						"from com.myconnector.domain.ReleaseUserXref x where x.userData.id = ?",
						id);
		getHibernateTemplate().deleteAll(objects);
	}
}
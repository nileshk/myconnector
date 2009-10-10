package com.myconnector.dao.hibernate;

import org.apache.log4j.Logger;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.myconnector.dao.ReleaseFileXrefDAO;
import com.myconnector.domain.ReleaseFileXref;
import com.myconnector.domain.ReleaseFileXrefPK;

import java.util.Collection;
import java.util.List;

public class ReleaseFileXrefDAOImpl extends HibernateDaoSupport implements
		ReleaseFileXrefDAO {

	static Logger logger = Logger.getLogger(ReleaseFileXrefDAOImpl.class);

	public ReleaseFileXrefDAOImpl() {
	}

	public ReleaseFileXref load(ReleaseFileXrefPK pk) {
		return (ReleaseFileXref) getHibernateTemplate().load(
				ReleaseFileXref.class, pk);
	}

	public void update(ReleaseFileXref xref) {
		getHibernateTemplate().update(xref);
	}

	public void save(ReleaseFileXref xref) {
		getHibernateTemplate().save(xref);
	}

	public void delete(ReleaseFileXref xref) {
		getHibernateTemplate().delete(xref);
	}

	public List getList() {
		return (getHibernateTemplate()
				.find("from com.myconnector.domain.ReleaseFileXref xref"));
	}

	/*
	 * @see com.myconnector.dao.ReleaseFileXrefDAO#saveOrUpdateReleaseFileXref(com.myconnector.domain.ReleaseFileXref)
	 */
	public void saveOrUpdate(ReleaseFileXref xref) {
		getHibernateTemplate().saveOrUpdate(xref);
	}

	public void deleteByReleaseId(String id) {
		Collection objects = getHibernateTemplate()
				.find(
						"from com.myconnector.domain.ReleaseFileXref x where x.release.id = ?",
						id);
		getHibernateTemplate().deleteAll(objects);
	}

	public void deleteByFileId(String id) {
		Collection objects = getHibernateTemplate()
				.find(
						"from com.myconnector.domain.ReleaseFileXref x where x.file.id = ?",
						id);
		getHibernateTemplate().deleteAll(objects);
	}
}
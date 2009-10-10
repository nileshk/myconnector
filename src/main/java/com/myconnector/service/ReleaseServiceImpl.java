package com.myconnector.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.myconnector.dao.ReleaseDAO;
import com.myconnector.dao.ReleaseFileXrefDAO;
import com.myconnector.domain.Release;
import com.myconnector.domain.ReleaseFileXref;
import com.myconnector.domain.ReleaseUserXref;
import com.myconnector.domain.UserData;
import com.myconnector.util.CommonThreadLocal;

/**
 * 
 * @author Nilesh Kapadia (nileshka@gmail.com)
 */
public class ReleaseServiceImpl implements ReleaseService {

    ReleaseDAO releaseDAO;

    ReleaseFileXrefDAO releaseFileXrefDAO;

    public void setReleaseFileXrefDAO(ReleaseFileXrefDAO releaseFileXrefDAO) {
        this.releaseFileXrefDAO = releaseFileXrefDAO;
    }

    public void setReleaseDAO(ReleaseDAO releaseDAO) {
        this.releaseDAO = releaseDAO;
    }

    public void deleteRelease(Release release) {
        releaseDAO.delete(release);
    }

    public Release getReleaseById(String id) {
        return releaseDAO.load(id);
    }

    public void saveRelease(Release release) {
        UserData createdBy = new UserData();
        createdBy.setId(CommonThreadLocal.getUserId());
        release.setCreatedBy(createdBy);
        release.setCreatedDate(new Date());
        if (release.getReady() == null) {
            release.setReady(new Byte((byte) 0));
        }
        releaseDAO.save(release);
    }

    public void saveOrUpdateRelease(Release release) {
        releaseDAO.saveOrUpdate(release);
    }

    public void updateRelease(Release release) {
        releaseDAO.update(release);
    }

    public void deleteById(String id) {
        releaseFileXrefDAO.deleteByFileId(id); // XXX this may belong at DAO level
        releaseDAO.deleteById(id);
    }

    public List getList() {
        return releaseDAO.getList();
    }

    public List getFileListByReleaseId(String releaseId) {
        Release release = releaseDAO.load(releaseId);
        List list = new ArrayList();

        Set xrefs = release.getReleaseFileXrefs();
        Iterator it = xrefs.iterator();
        while (it.hasNext()) {
            ReleaseFileXref xref = (ReleaseFileXref) it.next();
            list.add(xref.getFile());
        }

        return list;
    }

    public List getUserListByReleaseId(String releaseId) {
        Release release = releaseDAO.load(releaseId);
        List list = new ArrayList();

        Set xrefs = release.getReleaseUserXrefs();
        Iterator it = xrefs.iterator();
        while (it.hasNext()) {
            ReleaseUserXref xref = (ReleaseUserXref) it.next();
            list.add(xref.getUserData());
        }

        return list;        
    }

}
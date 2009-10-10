package com.myconnector.service;

import java.util.Iterator;
import java.util.List;

import com.myconnector.dao.ReleaseUserXrefDAO;
import com.myconnector.domain.Release;
import com.myconnector.domain.ReleaseUserXref;
import com.myconnector.domain.ReleaseUserXrefPK;
import com.myconnector.domain.UserData;

/**
 * 
 * @author Nilesh Kapadia (nileshka@gmail.com)
 */
public class ReleaseUserServiceImpl implements ReleaseUserService {

    protected ReleaseUserXrefDAO releaseUserXrefDAO;

    public void setReleaseUserXrefDAO(ReleaseUserXrefDAO releaseUserXrefDAO) {
        this.releaseUserXrefDAO = releaseUserXrefDAO;
    }

    public void addUser(String releaseId, String userId) {
        ReleaseUserXref xref = new ReleaseUserXref();
        ReleaseUserXrefPK pk = new ReleaseUserXrefPK();
        pk.setReleaseId(releaseId);
        pk.setUserId(userId);
        xref.setComp_id(pk);
        Release release = new Release();
        UserData user = new UserData();
        release.setId(releaseId);
        user.setId(userId);
        xref.setRelease(release);
        xref.setUserData(user);
        releaseUserXrefDAO.save(xref);
    }

    public void addUserList(String releaseId, List userIds) {
        Iterator it = userIds.iterator();
        while (it.hasNext()) {
            String userId = (String) it.next();
            addUser(releaseId, userId);
        }
    }

    public void delete(String releaseId, String userId) {
        ReleaseUserXref xref = new ReleaseUserXref(new ReleaseUserXrefPK(
                releaseId, userId));
        releaseUserXrefDAO.delete(xref);
    }

}
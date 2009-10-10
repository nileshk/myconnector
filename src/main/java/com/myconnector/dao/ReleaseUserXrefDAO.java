package com.myconnector.dao;

import java.util.List;

import com.myconnector.domain.ReleaseUserXref;
import com.myconnector.domain.ReleaseUserXrefPK;

/**
 * DAO for RELEASE_USER_XREF table
 * 
 * @author Nilesh Kapadia (nileshka@gmail.com)
 */
public interface ReleaseUserXrefDAO {

    public ReleaseUserXref load(ReleaseUserXrefPK pk);

    public void update(ReleaseUserXref xref);

    public void save(ReleaseUserXref xref);

    public void saveOrUpdate(ReleaseUserXref xref);

    public void delete(ReleaseUserXref xref);
    
    public void deleteByReleaseId(String id);
    
    public void deleteByUserId(String id);

    public List getList();
}
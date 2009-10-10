package com.myconnector.dao;

import java.util.List;

import com.myconnector.domain.ReleaseFileXref;
import com.myconnector.domain.ReleaseFileXrefPK;

/**
 * DAO for RELEASE_FILE_XREF table
 * 
 * @author Nilesh Kapadia (nileshka@gmail.com)
 */
public interface ReleaseFileXrefDAO {

    public ReleaseFileXref load(ReleaseFileXrefPK pk);

    public void update(ReleaseFileXref xref);

    public void save(ReleaseFileXref xref);

    public void saveOrUpdate(ReleaseFileXref xref);

    public void delete(ReleaseFileXref xref);
    
    public void deleteByReleaseId(String id);
    
    public void deleteByFileId(String id);

    public List getList();
}
package com.myconnector.service;

import java.util.List;

import com.myconnector.domain.Release;

/** 
 *
 * @author Nilesh Kapadia (nileshka@gmail.com)
 */
public interface ReleaseService extends OldGenericService {

    public void deleteRelease(Release release);    

    public Release getReleaseById(String id);
    
    public List getFileListByReleaseId(String releaseId);
    
    public List getUserListByReleaseId(String releaseId);

    public void saveRelease(Release release);

    public void saveOrUpdateRelease(Release release);

    public void updateRelease(Release release);    
    
}

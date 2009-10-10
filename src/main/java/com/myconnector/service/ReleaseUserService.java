package com.myconnector.service;

import java.util.List;

/** 
 *
 * @author Nilesh Kapadia (nileshka@gmail.com)
 */
public interface ReleaseUserService {

    public void addUser(String releaseId, String userId);
    
    /**
     * 
     * @param releaseId
     * @param userIds - List of userId's
     */
    public void addUserList(String releaseId, List userIds);
    
    public void delete(String releaseId, String userId);
    
    //public void addReleaseList(String userId, List releases);
    
}

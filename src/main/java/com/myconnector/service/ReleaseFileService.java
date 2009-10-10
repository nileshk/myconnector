package com.myconnector.service;

import com.myconnector.domain.File;

/** 
 *
 * @author Nilesh Kapadia (nileshka@gmail.com)
 */
public interface ReleaseFileService {

    public void saveFile(File file, String releaseId);
    
}

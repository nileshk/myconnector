package com.myconnector.service;

import org.apache.log4j.Logger;

import com.myconnector.dao.ReleaseFileXrefDAO;
import com.myconnector.domain.File;
import com.myconnector.domain.Release;
import com.myconnector.domain.ReleaseFileXref;
import com.myconnector.domain.ReleaseFileXrefPK;

/**
 * 
 * @author Nilesh Kapadia (nileshka@gmail.com)
 */
public class ReleaseFileServiceImpl implements ReleaseFileService {

    Logger logger = Logger.getLogger(ReleaseFileServiceImpl.class);
    
    FileService fileService;

    ReleaseFileXrefDAO releaseFileXrefDAO;

    public void setReleaseFileXrefDAO(ReleaseFileXrefDAO releaseFileXrefDAO) {
        this.releaseFileXrefDAO = releaseFileXrefDAO;
    }

    public void setFileService(FileService fileService) {
        this.fileService = fileService;
    }

    public void saveFile(File file, String releaseId) {
        fileService.saveFile(file);
        logger.debug("File Id: " + file.getId());
        
        ReleaseFileXref xref = new ReleaseFileXref();
        ReleaseFileXrefPK pk = new ReleaseFileXrefPK();
        pk.setFileId(file.getId());
        pk.setReleaseId(releaseId);
        xref.setComp_id(pk);
        xref.setFile(file);
        Release release = new Release();
        release.setId(releaseId);
        xref.setRelease(release);
        releaseFileXrefDAO.save(xref);
    }

}
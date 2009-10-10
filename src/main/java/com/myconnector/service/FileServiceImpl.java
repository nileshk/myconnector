package com.myconnector.service;

import java.util.List;

import com.myconnector.dao.FileDAO;
import com.myconnector.dao.ReleaseFileXrefDAO;
import com.myconnector.domain.File;

/**
 * 
 * @author Nilesh Kapadia (nileshka@gmail.com)
 */
public class FileServiceImpl implements FileService {

    FileDAO fileDAO;

    ReleaseFileXrefDAO releaseFileXrefDAO;

    public void setReleaseFileXrefDAO(ReleaseFileXrefDAO releaseFileXrefDAO) {
        this.releaseFileXrefDAO = releaseFileXrefDAO;
    }

    public void setFileDAO(FileDAO fileDAO) {
        this.fileDAO = fileDAO;
    }

    /*
     * @see com.myconnector.service.FileService#saveFile(com.myconnector.domain.File)
     */
    public void saveFile(File file) {
        fileDAO.save(file);
    }

    /*
     * @see com.myconnector.service.FileService#getFile(java.lang.String)
     */
    public File getFile(String id) {
        return fileDAO.load(id);
    }

    /*
     * @see com.myconnector.service.FileService#loadFileList()
     */
    public List getList() {
        return fileDAO.getList();
    }

    public void deleteById(String id) {
        releaseFileXrefDAO.deleteByFileId(id); // XXX this may belong at DAO level
        fileDAO.deleteById(id);
    }

}
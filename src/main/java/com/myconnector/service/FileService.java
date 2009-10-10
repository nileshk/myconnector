package com.myconnector.service;

import com.myconnector.domain.File;

public interface FileService extends OldGenericService {

    public void saveFile(File file);

    //public void saveFileList(List fileList);

    public File getFile(String id);

}
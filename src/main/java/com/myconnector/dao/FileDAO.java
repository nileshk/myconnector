package com.myconnector.dao;

import java.util.List;

import com.myconnector.domain.File;

/**
 * DAO for FILES table
 * 
 * @author Nilesh Kapadia (nileshka@gmail.com)
 */
public interface FileDAO {

    public File load(String id);

    public void update(File file);

    public void save(File file);

    public void saveOrUpdate(File file);

    public void delete(File file);
    
    public void deleteById(String id);

    public List getList();

    public List getListById(String id);
}
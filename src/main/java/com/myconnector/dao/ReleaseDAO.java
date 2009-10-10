package com.myconnector.dao;

import java.util.List;

import com.myconnector.domain.Release;

/**
 * DAO for RELEASES table
 * 
 * @author Nilesh Kapadia (nileshka@gmail.com)
 */
public interface ReleaseDAO {

    public Release load(String id);

    public void update(Release release);

    public void save(Release release);

    public void saveOrUpdate(Release release);

    public void delete(Release release);
    
    public void deleteById(String id);

    public List getList();

    public List getListById(String id);
}
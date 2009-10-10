package com.myconnector.dao;

import java.util.List;

import com.myconnector.domain.TsActivity;

/**
 * 
 * @author Nilesh Kapadia (nileshka@gmail.com)
 */
public interface TsActivityDAO {

    public TsActivity load(String id);
    
    public void update(TsActivity activity);

    public void save(TsActivity activity);

    public void delete(TsActivity activity);
    
    public void deleteById(String id);

    public List getList();
       
}
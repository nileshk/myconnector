package com.myconnector.dao;

import java.util.Date;
import java.util.List;

import com.myconnector.domain.TsEntry;

/**
 * 
 * @author Nilesh Kapadia (nileshka@gmail.com)
 */
public interface TsEntryDAO {

    public TsEntry load(String id);
    
    public void update(TsEntry entry);

    public void save(TsEntry entry);

    public void delete(TsEntry entry);
    
    public void deleteById(String id);

    public List getList();
    
    public List getListByUserId(String userId);
    
    public List getListByUserIdAndDate(String userId, Date date);
    
    public List getListByUserIdAndDateRange(String userId, Date startDate, Date endDate);
    
    public List getListByUserId(String userId, String orderBy, boolean descending);
}
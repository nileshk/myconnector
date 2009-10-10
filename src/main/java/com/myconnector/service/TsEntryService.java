package com.myconnector.service;

import java.util.Date;
import java.util.List;

import com.myconnector.domain.TsEntry;

/**
 * 
 * @author Nilesh Kapadia (nileshka@gmail.com)
 */
public interface TsEntryService extends OldGenericService {

    public TsEntry getTsEntryById(String id);

    public void updateTsEntryDTO(com.myconnector.dto.TsEntryDTO entry);

    public void update(TsEntry entry);

    public void save(TsEntry entry);

    public List getListByCurrentUser();

    public List getListByCurrentUser(String orderBy, boolean descending);

    public List getListByUserId(String userId);

    public List getListByUserId(String userId, String orderBy, boolean descending);
    
    public List getListByCurrentUserAndDate(Date date);
    
    public List getListByUserIdAndDate(String userId, Date date);
    
    /**
     * 
     * @param userId
     * @param date date that occurs on week
     * @return
     */
    public List getListByUserIdAndWeek(String userId, Date date);
    
    public List getListByCurrentUserAndWeek(Date date);

    /**
     * Complete a timesheet entry by counting the number of hours since
     * dateTimeStart and storing the value. Hours will be rounded to multiples
     * of 0.25.
     * 
     * @param id id of TsEntry object
     * @param roundUp True to round up, false to round down
     */
    public void complete(String id, boolean roundUp);
}

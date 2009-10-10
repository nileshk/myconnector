package com.myconnector.service;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;

import com.myconnector.dao.TsEntryDAO;
import com.myconnector.dao.UserDataDAO;
import com.myconnector.domain.TsEntry;
import com.myconnector.domain.UserData;
import com.myconnector.util.CommonThreadLocal;

/**
 * 
 * @author Nilesh Kapadia (nileshka@gmail.com)
 */
public class TsEntryServiceImpl implements TsEntryService {

    Logger logger = Logger.getLogger(TsEntryServiceImpl.class);

    TsEntryDAO entryDAO;

    UserDataDAO userDataDAO;

    public void setTsEntryDAO(TsEntryDAO entryDAO) {
        this.entryDAO = entryDAO;
    }

    public void setUserDataDAO(UserDataDAO userDataDAO) {
        this.userDataDAO = userDataDAO;
    }

    public void update(TsEntry entry) {
        entryDAO.update(entry);
    }

    public void save(TsEntry entry) {
        String userId = CommonThreadLocal.getUserId();
        logger.debug("userId:" + userId);
        UserData userData = userDataDAO.load(userId);
        entry.setUser(userData);

        if (entry.getDateOccur() == null) {
            entry.setDateOccur(new Date());
        }

        if (entry.getDateTimeStart() == null && entry.getHours() == null
                && entry.getHours() == null) {
            entry.setDateTimeStart(new Date());
        }

        entryDAO.save(entry);
    }

    public void deleteById(String id) {
        entryDAO.deleteById(id);
    }

    public List getList() {
        return entryDAO.getList();
    }

    public List getListByCurrentUser() {
        return entryDAO.getListByUserId(CommonThreadLocal.getUserId());
    }

    public List getListByCurrentUser(String orderBy, boolean descending) {
        return entryDAO.getListByUserId(CommonThreadLocal.getUserId(), orderBy, descending);
    }

    public List getListByUserId(String userId) {
        return entryDAO.getListByUserId(userId);
    }

    public TsEntry getTsEntryById(String id) {
        return entryDAO.load(id);
    }

    public void updateTsEntryDTO(com.myconnector.dto.TsEntryDTO entry) {
        TsEntry entryCurrent = entryDAO.load(entry.getId());
        try {
            BeanUtils.copyProperties(entryCurrent, entry);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        entryDAO.update(entryCurrent);
    }

    public List getListByUserId(String userId, String orderBy, boolean descending) {
        return entryDAO.getListByUserId(userId, orderBy, descending);
    }

    public void complete(String id, boolean roundUp) {
        TsEntry entry = entryDAO.load(id);
        long elapsed = System.currentTimeMillis() - entry.getDateTimeStart().getTime();
        if (elapsed < 0) {
            throw new RuntimeException("Date/time start is greater than current time.");
        }
        logger.debug("elapsed = " + elapsed);
        float elapsedHours = elapsed / (60 * 60 * 1000F);
        int wholeNumberRounded = Math.round(elapsedHours) * 100;
        int rounded = Math.round(elapsedHours * 100);
        float finalVal;
        int padding = roundUp ? 25 : 0;
        if (rounded < (wholeNumberRounded + 50)) {
            if (rounded < (wholeNumberRounded + 25)) {
                finalVal = wholeNumberRounded + padding;
            } else {
                finalVal = wholeNumberRounded + 25 + padding;
            }
        } else {
            if (rounded < (wholeNumberRounded + 75)) {
                finalVal = wholeNumberRounded + 50 + padding;
            } else {
                finalVal = wholeNumberRounded + 75 + padding;
            }
        }
        logger.debug("finalVal = " + finalVal);
        float hoursFloat = finalVal / 100;
        logger.debug("hoursFloat = " + hoursFloat);
        BigDecimal hours = new BigDecimal(hoursFloat);
        logger.debug("hours = " + hours.floatValue());
        entry.setHours(hours);
        entryDAO.update(entry);
    }

    public List getListByCurrentUserAndDate(Date date) {
        return getListByUserIdAndDate(CommonThreadLocal.getUserId(), date);
    }

    public List getListByUserIdAndDate(String userId, Date date) {
        return entryDAO.getListByUserIdAndDate(userId, date);
    }

    public List getListByUserIdAndWeek(String userId, Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Date tempStart = null;
        Date tempEnd = null;
        Calendar gc = new GregorianCalendar();
        gc.setTime(date);
        if(gc.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
            tempStart = new Date(gc.getTimeInMillis());
            tempEnd = new Date(gc.getTimeInMillis() + 6*24*60*60*1000);            
        } else {
            tempStart = new Date(gc.getTimeInMillis() - gc.get(Calendar.DAY_OF_WEEK)*24*60*60*1000);
            tempEnd = new Date(tempStart.getTime() + 6*24*60*60*1000);            
        }
                        
        Date dateStart;
        Date dateEnd;
        try {
            dateStart = sdf.parse(sdf.format(tempStart));
            dateEnd = sdf.parse(sdf.format(tempEnd));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        
        
        return entryDAO.getListByUserIdAndDateRange(userId, dateStart, dateEnd);
    }

    public List getListByCurrentUserAndWeek(Date date) {
        return getListByUserIdAndWeek(CommonThreadLocal.getUserId(), date);
    }

}
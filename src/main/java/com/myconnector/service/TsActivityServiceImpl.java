package com.myconnector.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;

import com.myconnector.dao.TsActivityDAO;
import com.myconnector.domain.TsActivity;

/**
 * 
 * @author Nilesh Kapadia (nileshka@gmail.com)
 */
public class TsActivityServiceImpl implements TsActivityService {

    Logger logger = Logger.getLogger(TsActivityServiceImpl.class);

    TsActivityDAO activityDAO;

    public void setTsActivityDAO(TsActivityDAO activityDAO) {
        this.activityDAO = activityDAO;
    }

    public void update(TsActivity activity) {
        activityDAO.update(activity);
    }

    public void save(TsActivity activity) {
        activityDAO.save(activity);
    }

    public void deleteById(String id) {
        activityDAO.deleteById(id);
    }

    public List getList() {
        return activityDAO.getList();
    }

    public TsActivity getTsActivityById(String id) {
        return activityDAO.load(id);
    }

    public void updateTsActivityDTO(com.myconnector.dto.TsActivityDTO activity) {
        TsActivity activityCurrent = activityDAO.load(activity.getId());
        try {
            BeanUtils.copyProperties(activityCurrent, activity);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        activityDAO.update(activityCurrent);
    }

    public Object getById(String id) {
        return getTsActivityById(id);
    }

    public void save(Object obj) {
        save((TsActivity) obj);
    }

    public void update(Object obj) {
        update((TsActivity) obj);
    }

}
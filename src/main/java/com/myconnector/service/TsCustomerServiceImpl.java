package com.myconnector.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;

import com.myconnector.dao.TsCustomerDAO;
import com.myconnector.domain.TsCustomer;

/**
 * 
 * @author Nilesh Kapadia (nileshka@gmail.com)
 */
public class TsCustomerServiceImpl implements TsCustomerService {

    Logger logger = Logger.getLogger(TsCustomerServiceImpl.class);
    
    TsCustomerDAO customerDAO;

    public void setTsCustomerDAO(TsCustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    public void update(TsCustomer customer) {
        customerDAO.update(customer);
    }

    public void save(TsCustomer customer) {
        customerDAO.save(customer);
    }

    public void deleteById(String id) {
        customerDAO.deleteById(id);
    }

    public List getList() {
        return customerDAO.getList();
    }

    public TsCustomer getTsCustomerById(String id) {
        return customerDAO.load(id);
    }

    public void updateTsCustomerDTO(com.myconnector.dto.TsCustomerDTO customer) {
        TsCustomer customerCurrent = customerDAO.load(customer.getId());        
        try {
            BeanUtils.copyProperties(customerCurrent, customer);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        customerDAO.update(customerCurrent);
    }

    public Object getById(String id) {
        return getTsCustomerById(id);
    }

    public void save(Object obj) {
        save((TsCustomer) obj);
    }

    public void update(Object obj) {
        update((TsCustomer) obj);
    }

}
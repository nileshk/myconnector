package com.myconnector.dao;

import java.util.List;

import com.myconnector.domain.TsCustomer;

/**
 * 
 * @author Nilesh Kapadia (nileshka@gmail.com)
 */
public interface TsCustomerDAO {

    public TsCustomer load(String id);
    
    public void update(TsCustomer customer);

    public void save(TsCustomer customer);

    public void delete(TsCustomer customer);
    
    public void deleteById(String id);

    public List getList();

}
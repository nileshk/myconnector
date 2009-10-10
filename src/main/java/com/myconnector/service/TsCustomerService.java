package com.myconnector.service;

import com.myconnector.domain.TsCustomer;

/** 
 *
 * @author Nilesh Kapadia (nileshka@gmail.com)
 */
public interface TsCustomerService extends OldGenericExtraService {
   
    public TsCustomer getTsCustomerById(String id);
    
    public void updateTsCustomerDTO(com.myconnector.dto.TsCustomerDTO customer);
    
    public void update(TsCustomer customer);

    public void save(TsCustomer customer);
        
}

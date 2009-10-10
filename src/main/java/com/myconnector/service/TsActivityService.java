package com.myconnector.service;

import com.myconnector.domain.TsActivity;

/** 
 *
 * @author Nilesh Kapadia (nileshka@gmail.com)
 */
public interface TsActivityService extends OldGenericExtraService {
   
    public TsActivity getTsActivityById(String id);
    
    public void updateTsActivityDTO(com.myconnector.dto.TsActivityDTO activity);
    
    public void update(TsActivity activity);

    public void save(TsActivity activity);
        
}

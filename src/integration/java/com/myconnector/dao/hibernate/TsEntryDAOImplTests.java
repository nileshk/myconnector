package com.myconnector.dao.hibernate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.myconnector.dao.BaseDAOTests;
import com.myconnector.dao.TsEntryDAO;
import com.myconnector.domain.TsEntry;

/** 
 *
 * @author Nilesh Kapadia (nileshka@gmail.com)
 */
public class TsEntryDAOImplTests extends BaseDAOTests {

    static Logger logger = Logger.getLogger(TsEntryDAOImplTests.class); 
    
    TsEntryDAO dao;
    
    protected void onSetUpInTransaction() throws Exception {
        super.onSetUpInTransaction();
        dao = (TsEntryDAO) applicationContext.getBean("tsEntryDAO");
    }
    
    public void testGetListByUserIdAndDate() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Date date = sdf.parse("05/17/2005");        
        logger.debug(date);
        
        List list = dao.getListByUserIdAndDate("ff80808103341c820103341ccb7b0001", date);
        assertTrue(list.size() > 0);
        for(int i = 0; i < list.size(); i++) {
            TsEntry tsEntry = (TsEntry) list.get(i);            
            assertEquals(date, tsEntry.getDateOccur());
        }        
    }
    
    public void testGetListByUserIdAndDateRange() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Date dateStart = sdf.parse("05/15/2005");     
        Date dateEnd = sdf.parse("05/17/2005");
        
        List list = dao.getListByUserIdAndDateRange("ff80808103341c820103341ccb7b0001", dateStart, dateEnd);
        assertTrue(list.size() > 0);
        for(int i = 0; i < list.size(); i++) {
            TsEntry tsEntry = (TsEntry) list.get(i);            
            logger.debug("date: " + tsEntry.getDateOccur());
        }
        
    }
    
}

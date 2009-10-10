package com.myconnector.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.easymock.MockControl;

import com.myconnector.dao.TsEntryDAO;

import junit.framework.TestCase;

/** 
 *
 * @author Nilesh Kapadia (nileshka@gmail.com)
 */
public class TsEntryServiceImplTests extends TestCase {

//    public void testElapsedTimeToHours() {
//        long elapsed = 12034242;
//        float elapsedHours = elapsed/(60*60*1000F);
//        System.out.println(elapsedHours);
//        int wholeNumberRounded = Math.round(elapsedHours) * 100;
//        System.out.println(wholeNumberRounded);
//        int rounded = Math.round(elapsedHours * 100);
//        System.out.println(rounded);
//        int finalInt;
//        if(rounded < (wholeNumberRounded + 50)) {
//            if(rounded < (wholeNumberRounded + 25)) {
//                finalInt = wholeNumberRounded;
//            } else {
//                finalInt = wholeNumberRounded + 25;
//            }
//        } else {
//            if(rounded < (wholeNumberRounded + 75)) {
//                finalInt = wholeNumberRounded + 50;
//            } else {
//                finalInt = wholeNumberRounded + 75;
//            }            
//        }
//        System.out.println(finalInt);        
//    }
    
    public void testGetListByUserIdAndWeek() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Date dateStart = sdf.parse("05/14/2005");     
        Date dateEnd = sdf.parse("05/20/2005");
        Date date = sdf.parse("05/14/2005");
                
        MockControl mc = MockControl.createControl(TsEntryDAO.class);
        TsEntryDAO dao = (TsEntryDAO) mc.getMock();
        dao.getListByUserIdAndDateRange("USERID", dateStart, dateEnd);
        mc.setReturnValue(null);
        
        mc.replay();
        
        TsEntryServiceImpl tsEntryService = new TsEntryServiceImpl();
        tsEntryService.setTsEntryDAO(dao);
        tsEntryService.getListByUserIdAndWeek("USERID", date);
        
        mc.verify();
    }

    public void testGetListByUserIdAndWeek2() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Date dateStart = sdf.parse("05/14/2005");     
        Date dateEnd = sdf.parse("05/20/2005");
        Date date = sdf.parse("05/17/2005");
                
        MockControl mc = MockControl.createControl(TsEntryDAO.class);
        TsEntryDAO dao = (TsEntryDAO) mc.getMock();
        dao.getListByUserIdAndDateRange("USERID", dateStart, dateEnd);
        mc.setReturnValue(null);
        
        mc.replay();
        
        TsEntryServiceImpl tsEntryService = new TsEntryServiceImpl();
        tsEntryService.setTsEntryDAO(dao);
        tsEntryService.getListByUserIdAndWeek("USERID", date);
        
        mc.verify();
    }    
    
}

/*
 * Created on Aug 15, 2004
 *
 */
package com.myconnector.client;

import java.rmi.RemoteException;

import org.apache.axis.AxisFault;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/** 
 *
 * @author nil
 */
public class ClientCore {
    
    Logger logger = Logger.getLogger(ClientCore.class); 
    
	protected ApplicationContext appContext = null;
	
	public void start()
	{		
	    logger.info("Starting...");
		appContext = new ClassPathXmlApplicationContext("applicationContext-client.xml");
		BkMethods bk = (BkMethods)appContext.getBean("bkMethods");
		
		try {
			bk.start("/home/nil/bin/eclipse31-common/workspace/myconnector/client/com/myconnector/client/bkfile.txt");
		}
		catch(AxisFault ex)
		{			
			logger.fatal("Axis Fault: " + ex.getMessage());
			logger.warn("Axis Fault", ex);
		}
		catch(RemoteException ex)
		{			
			logger.fatal("RemoteException: " + ex.getMessage());
			logger.warn("RemoteException", ex);
		}
		catch(RuntimeException ex)
		{			
			logger.fatal("RuntimeException: " + ex.getMessage());
			logger.warn("RuntimeException", ex);
		}
		catch(Exception ex)
		{
			logger.fatal("Exception: " + ex.getMessage());
			logger.warn("Exception", ex);
		}		
		
		logger.info("Done.");
	}
}

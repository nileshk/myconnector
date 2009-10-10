package com.myconnector.client.dictionary;

import javax.xml.rpc.ServiceException;

import org.apache.log4j.Logger;

import com.myconnector.client.dictionary.proxy.DictionaryWSImpl;
import com.myconnector.client.dictionary.proxy.DictionaryWSImplServiceLocator;


/** 
 *
 * @author Nilesh Kapadia (nileshka@gmail.com)
 */
public class DictionaryGUI {
    
    static Logger logger = Logger.getLogger(DictionaryGUI.class);
    
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        DictionaryWSImplServiceLocator locator = new DictionaryWSImplServiceLocator();
        locator.setMaintainSession(true);
        DictionaryWSImpl dictionaryWS = null;
        try {
            dictionaryWS = locator.getDictionary();
            logger.debug("Connected to web service");
        } catch (ServiceException e) {
            logger.error(e);
            throw new RuntimeException(e);
        }
        DictionaryWindow window = new DictionaryWindow();
        window.setDictionaryWS(dictionaryWS);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}

package com.myconnector.client.proxy.test;

import org.codehaus.xfire.XFireRuntimeException;

import junit.framework.TestCase;

public class TestServiceImplIntegrationTests extends TestCase {

    TestServiceClient service = new TestServiceClient();
    TestServicePortType testService = service.getTestServiceHttpPort();
      
    public void testReverseString() {
        String ret = testService.reverseString("ABC");
        assertEquals("CBA", ret);
    }
    
    public void testGetException() {
        try {
            testService.throwException();
            fail();
        } catch(XFireRuntimeException ex) {            
            ex.printStackTrace();
        }
    }
    
}

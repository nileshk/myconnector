
package com.myconnector.client.proxy.test;

import javax.jws.WebService;

@WebService(serviceName = "TestService", targetNamespace = "http://webservice.myconnector.com", endpointInterface = "com.myconnector.client.proxy.test.TestServicePortType")
public class TestServiceImpl
    implements TestServicePortType
{


    public String reverseString(String in0) {
        throw new UnsupportedOperationException();
    }

    public void throwException() {
        throw new UnsupportedOperationException();
    }

}

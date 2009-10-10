
package com.myconnector.client.proxy.test;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService(name = "TestServicePortType", targetNamespace = "http://webservice.myconnector.com")
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL, parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public interface TestServicePortType {


    @WebMethod(operationName = "reverseString", action = "")
    @WebResult(name = "out", targetNamespace = "http://webservice.myconnector.com")
    public String reverseString(
        @WebParam(name = "in0", targetNamespace = "http://webservice.myconnector.com")
        String in0);

    @WebMethod(operationName = "throwException", action = "")
    public void throwException();

}

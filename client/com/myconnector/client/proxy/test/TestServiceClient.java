
package com.myconnector.client.proxy.test;

import java.net.MalformedURLException;
import java.util.Collection;
import java.util.HashMap;
import javax.xml.namespace.QName;
import org.codehaus.xfire.XFireRuntimeException;
import org.codehaus.xfire.aegis.AegisBindingProvider;
import org.codehaus.xfire.annotations.AnnotationServiceFactory;
import org.codehaus.xfire.annotations.jsr181.Jsr181WebAnnotations;
import org.codehaus.xfire.client.XFireProxyFactory;
import org.codehaus.xfire.jaxb2.JaxbTypeRegistry;
import org.codehaus.xfire.service.Endpoint;
import org.codehaus.xfire.service.Service;
import org.codehaus.xfire.soap.AbstractSoapBinding;
import org.codehaus.xfire.transport.TransportManager;

public class TestServiceClient {

    private static XFireProxyFactory proxyFactory = new XFireProxyFactory();
    private HashMap endpoints = new HashMap();
    private Service service0;

    public TestServiceClient() {
        create0();
        Endpoint TestServicePortTypeLocalEndpointEP = service0 .addEndpoint(new QName("http://webservice.myconnector.com", "TestServicePortTypeLocalEndpoint"), new QName("http://webservice.myconnector.com", "TestServicePortTypeLocalBinding"), "xfire.local://TestService");
        endpoints.put(new QName("http://webservice.myconnector.com", "TestServicePortTypeLocalEndpoint"), TestServicePortTypeLocalEndpointEP);
        Endpoint TestServiceHttpPortEP = service0 .addEndpoint(new QName("http://webservice.myconnector.com", "TestServiceHttpPort"), new QName("http://webservice.myconnector.com", "TestServiceHttpBinding"), "http://localhost:8080/myconnector/services/TestService");
        endpoints.put(new QName("http://webservice.myconnector.com", "TestServiceHttpPort"), TestServiceHttpPortEP);
    }

    public Object getEndpoint(Endpoint endpoint) {
        try {
            return proxyFactory.create((endpoint).getBinding(), (endpoint).getUrl());
        } catch (MalformedURLException e) {
            throw new XFireRuntimeException("Invalid URL", e);
        }
    }

    public Object getEndpoint(QName name) {
        Endpoint endpoint = ((Endpoint) endpoints.get((name)));
        if ((endpoint) == null) {
            throw new IllegalStateException("No such endpoint!");
        }
        return getEndpoint((endpoint));
    }

    public Collection getEndpoints() {
        return endpoints.values();
    }

    private void create0() {
        TransportManager tm = (org.codehaus.xfire.XFireFactory.newInstance().getXFire().getTransportManager());
        HashMap props = new HashMap();
        props.put("annotations.allow.interface", "true");
        props.put("objectServiceFactory.style", "wrapped");
        AnnotationServiceFactory asf = new AnnotationServiceFactory(new Jsr181WebAnnotations(), tm, new AegisBindingProvider(new JaxbTypeRegistry()));
        asf.setBindingCreationEnabled(true);
        service0 = asf.create((com.myconnector.client.proxy.test.TestServicePortType.class), props);
        {
            AbstractSoapBinding soapBinding = asf.createSoap11Binding(service0, new QName("http://webservice.myconnector.com", "TestServiceHttpBinding"), "http://schemas.xmlsoap.org/soap/http");
        }
        {
            AbstractSoapBinding soapBinding = asf.createSoap11Binding(service0, new QName("http://webservice.myconnector.com", "TestServicePortTypeLocalBinding"), "urn:xfire:transport:local");
        }
    }

    public TestServicePortType getTestServicePortTypeLocalEndpoint() {
        return ((TestServicePortType)(this).getEndpoint(new QName("http://webservice.myconnector.com", "TestServicePortTypeLocalEndpoint")));
    }

    public TestServicePortType getTestServicePortTypeLocalEndpoint(String url) {
        TestServicePortType var = getTestServicePortTypeLocalEndpoint();
        org.codehaus.xfire.client.Client.getInstance(var).setUrl(url);
        return var;
    }

    public TestServicePortType getTestServiceHttpPort() {
        return ((TestServicePortType)(this).getEndpoint(new QName("http://webservice.myconnector.com", "TestServiceHttpPort")));
    }

    public TestServicePortType getTestServiceHttpPort(String url) {
        TestServicePortType var = getTestServiceHttpPort();
        org.codehaus.xfire.client.Client.getInstance(var).setUrl(url);
        return var;
    }

}

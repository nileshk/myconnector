/*
 * Created on Aug 16, 2004
 *
 */
package com.myconnector.client.util;

import javax.xml.namespace.QName;
import javax.xml.rpc.Service;
import javax.xml.rpc.encoding.TypeMapping;
import javax.xml.rpc.encoding.TypeMappingRegistry;

import org.apache.axis.encoding.ser.ArrayDeserializer;
import org.apache.axis.encoding.ser.ArrayDeserializerFactory;
import org.apache.axis.encoding.ser.ArraySerializerFactory;
import org.apache.axis.encoding.ser.BeanDeserializerFactory;
import org.apache.axis.encoding.ser.BeanSerializerFactory;
import org.apache.log4j.Logger;

import org.springframework.remoting.jaxrpc.JaxRpcServicePostProcessor;

import com.myconnector.dto.BookmarkDTO;

/**
 * 
 * @author nil
 */
public class BookmarkServicePostProcessor implements JaxRpcServicePostProcessor {

    static Logger logger = Logger.getLogger(BookmarkServicePostProcessor.class);
    
	/**
	 * Default encoding style URI, as suggested by the JAX-RPC javadoc:
	 * "http://schemas.xmlsoap.org/soap/encoding/"
	 * @see javax.xml.rpc.encoding.TypeMappingRegistry#register
	 */
	public static final String DEFAULT_ENCODING_STYLE_URI = "http://schemas.xmlsoap.org/soap/encoding/";

	/**
	 * Default namespace to use for custom XML types.
	 * @see javax.xml.rpc.encoding.TypeMapping#register
	 */
	public static final String DEFAULT_TYPE_NAMESPACE_URI = "http://www.myconnector.com/webservices/";


	private String encodingStyleUri = DEFAULT_ENCODING_STYLE_URI;

	private String typeNamespaceUri = DEFAULT_TYPE_NAMESPACE_URI;


	/**
	 * Set the encoding style URI to use for the type mapping.
	 * @see javax.xml.rpc.encoding.TypeMappingRegistry#register
	 */
	public void setEncodingStyleUri(String encodingStyleUri) {
		this.encodingStyleUri = encodingStyleUri;
	}

	/**
	 * Set the namespace to use for custom XML types.
	 * @see javax.xml.rpc.encoding.TypeMapping#register
	 */
	public void setTypeNamespaceUri(String typeNamespaceUri) {
		this.typeNamespaceUri = typeNamespaceUri;
	}


	public void postProcessJaxRpcService(Service service) {
		TypeMappingRegistry registry = service.getTypeMappingRegistry();
		TypeMapping mapping = registry.createTypeMapping();
        registerBeanMapping(mapping, BookmarkDTO.class, "BookmarkDTO");
        //registerArrayMapping(mapping, BookmarkDTO[].class, "BookmarkDTO");
        logger.debug("registering bean BookmarkDTO");
		//registry.register(this.encodingStyleUri, mapping);
        registry.register("", mapping);
	}

	protected void registerBeanMapping(TypeMapping mapping, Class type, String name) {
		QName xmlType = new QName(this.typeNamespaceUri, name);
		mapping.register(type, xmlType,
		    new BeanSerializerFactory(type, xmlType),
		    new BeanDeserializerFactory(type, xmlType));		
	}
	
	protected void registerArrayMapping(TypeMapping mapping, Class type, String name) {
		QName xmlType = new QName(this.typeNamespaceUri, name);
		mapping.register(type, xmlType, new ArraySerializerFactory(), new ArrayDeserializerFactory());	    
	}
}
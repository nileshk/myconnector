/**
 * Dictionary.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC3 Feb 28, 2005 (10:15:14 EST) WSDL2Java emitter.
 */

package com.myconnector.client.dictionary.proxy;

public class Dictionary  implements java.io.Serializable {
    private java.lang.String def;
    private java.lang.String word;

    public Dictionary() {
    }

    public Dictionary(
           java.lang.String def,
           java.lang.String word) {
           this.def = def;
           this.word = word;
    }


    /**
     * Gets the def value for this Dictionary.
     * 
     * @return def
     */
    public java.lang.String getDef() {
        return def;
    }


    /**
     * Sets the def value for this Dictionary.
     * 
     * @param def
     */
    public void setDef(java.lang.String def) {
        this.def = def;
    }


    /**
     * Gets the word value for this Dictionary.
     * 
     * @return word
     */
    public java.lang.String getWord() {
        return word;
    }


    /**
     * Sets the word value for this Dictionary.
     * 
     * @param word
     */
    public void setWord(java.lang.String word) {
        this.word = word;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Dictionary)) return false;
        Dictionary other = (Dictionary) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.def==null && other.getDef()==null) || 
             (this.def!=null &&
              this.def.equals(other.getDef()))) &&
            ((this.word==null && other.getWord()==null) || 
             (this.word!=null &&
              this.word.equals(other.getWord())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getDef() != null) {
            _hashCode += getDef().hashCode();
        }
        if (getWord() != null) {
            _hashCode += getWord().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Dictionary.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.myconnector.com/webservices/", "Dictionary"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("def");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.myconnector.com/webservices/", "def"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("word");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.myconnector.com/webservices/", "word"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}

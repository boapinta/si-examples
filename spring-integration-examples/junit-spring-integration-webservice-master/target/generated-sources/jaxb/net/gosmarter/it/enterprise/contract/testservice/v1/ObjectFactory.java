//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.02.22 at 07:51:32 PM CET 
//


package net.gosmarter.it.enterprise.contract.testservice.v1;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import net.gosmarter.it.enterprise.data.v1.TestServiceRequestType;
import net.gosmarter.it.enterprise.data.v1.TestServiceResponseType;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the net.gosmarter.it.enterprise.contract.testservice.v1 package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _TestServiceRequest_QNAME = new QName("http://goSmarter.net/it/enterprise/contract/TestService/v1", "TestServiceRequest");
    private final static QName _TestServiceResponse_QNAME = new QName("http://goSmarter.net/it/enterprise/contract/TestService/v1", "TestServiceResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: net.gosmarter.it.enterprise.contract.testservice.v1
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TestServiceRequestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://goSmarter.net/it/enterprise/contract/TestService/v1", name = "TestServiceRequest")
    public JAXBElement<TestServiceRequestType> createTestServiceRequest(TestServiceRequestType value) {
        return new JAXBElement<TestServiceRequestType>(_TestServiceRequest_QNAME, TestServiceRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TestServiceResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://goSmarter.net/it/enterprise/contract/TestService/v1", name = "TestServiceResponse")
    public JAXBElement<TestServiceResponseType> createTestServiceResponse(TestServiceResponseType value) {
        return new JAXBElement<TestServiceResponseType>(_TestServiceResponse_QNAME, TestServiceResponseType.class, null, value);
    }

}

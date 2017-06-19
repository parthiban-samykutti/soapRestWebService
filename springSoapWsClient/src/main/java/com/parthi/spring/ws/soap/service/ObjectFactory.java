
package com.parthi.spring.ws.soap.service;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.parthi.spring.ws.soap.service package. 
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


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.parthi.spring.ws.soap.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AccountDetailResponse }
     * 
     */
    public AccountDetailResponse createAccountDetailResponse() {
        return new AccountDetailResponse();
    }

    /**
     * Create an instance of {@link AccountDetail }
     * 
     */
    public AccountDetail createAccountDetail() {
        return new AccountDetail();
    }

    /**
     * Create an instance of {@link AccountDetailRequest }
     * 
     */
    public AccountDetailRequest createAccountDetailRequest() {
        return new AccountDetailRequest();
    }

    /**
     * Create an instance of {@link DetailResponse }
     * 
     */
    public DetailResponse createDetailResponse() {
        return new DetailResponse();
    }

    /**
     * Create an instance of {@link DetailRequest }
     * 
     */
    public DetailRequest createDetailRequest() {
        return new DetailRequest();
    }

}

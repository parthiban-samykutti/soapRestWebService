
package com.parthi.spring.ws.soap.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b14002
 * Generated source version: 2.2
 * 
 */
@WebService(name = "AccountService", targetNamespace = "http://service.soap.ws.spring.parthi.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface AccountService {


    /**
     * 
     * @param accountName
     * @return
     *     returns com.parthi.spring.ws.soap.service.AccountHolderResponse
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getDetail", targetNamespace = "http://service.soap.ws.spring.parthi.com/", className = "com.parthi.spring.ws.soap.service.GetDetail")
    @ResponseWrapper(localName = "getDetailResponse", targetNamespace = "http://service.soap.ws.spring.parthi.com/", className = "com.parthi.spring.ws.soap.service.GetDetailResponse")
    @Action(input = "http://service.soap.ws.spring.parthi.com/AccountService/getDetailRequest", output = "http://service.soap.ws.spring.parthi.com/AccountService/getDetailResponse")
    public AccountHolderResponse getDetail(
        @WebParam(name = "accountName", targetNamespace = "")
        String accountName);

    /**
     * 
     * @param accountHolderRequest
     * @return
     *     returns com.parthi.spring.ws.soap.service.AccountHolderResponse
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getAccountDetails", targetNamespace = "http://service.soap.ws.spring.parthi.com/", className = "com.parthi.spring.ws.soap.service.GetAccountDetails")
    @ResponseWrapper(localName = "getAccountDetailsResponse", targetNamespace = "http://service.soap.ws.spring.parthi.com/", className = "com.parthi.spring.ws.soap.service.GetAccountDetailsResponse")
    @Action(input = "http://service.soap.ws.spring.parthi.com/AccountService/getAccountDetailsRequest", output = "http://service.soap.ws.spring.parthi.com/AccountService/getAccountDetailsResponse")
    public AccountHolderResponse getAccountDetails(
        @WebParam(name = "accountHolderRequest", targetNamespace = "http://service.soap.ws.spring.parthi.com/")
        AccountHolderRequest accountHolderRequest);

}

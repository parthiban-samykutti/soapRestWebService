
package com.parthi.spring.ws.soap.service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


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

    private final static QName _GetDetailResponse_QNAME = new QName("http://service.soap.ws.spring.parthi.com/", "getDetailResponse");
    private final static QName _Account_QNAME = new QName("http://service.soap.ws.spring.parthi.com/", "account");
    private final static QName _AccountHolderResponse_QNAME = new QName("http://service.soap.ws.spring.parthi.com/", "accountHolderResponse");
    private final static QName _GetAccountDetails_QNAME = new QName("http://service.soap.ws.spring.parthi.com/", "getAccountDetails");
    private final static QName _GetDetail_QNAME = new QName("http://service.soap.ws.spring.parthi.com/", "getDetail");
    private final static QName _GetAccountDetailsResponse_QNAME = new QName("http://service.soap.ws.spring.parthi.com/", "getAccountDetailsResponse");
    private final static QName _AccountHolderRequest_QNAME = new QName("http://service.soap.ws.spring.parthi.com/", "accountHolderRequest");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.parthi.spring.ws.soap.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetAccountDetails }
     * 
     */
    public GetAccountDetails createGetAccountDetails() {
        return new GetAccountDetails();
    }

    /**
     * Create an instance of {@link AccountHolderResponse }
     * 
     */
    public AccountHolderResponse createAccountHolderResponse() {
        return new AccountHolderResponse();
    }

    /**
     * Create an instance of {@link AccountHolderRequest }
     * 
     */
    public AccountHolderRequest createAccountHolderRequest() {
        return new AccountHolderRequest();
    }

    /**
     * Create an instance of {@link GetAccountDetailsResponse }
     * 
     */
    public GetAccountDetailsResponse createGetAccountDetailsResponse() {
        return new GetAccountDetailsResponse();
    }

    /**
     * Create an instance of {@link GetDetail }
     * 
     */
    public GetDetail createGetDetail() {
        return new GetDetail();
    }

    /**
     * Create an instance of {@link GetDetailResponse }
     * 
     */
    public GetDetailResponse createGetDetailResponse() {
        return new GetDetailResponse();
    }

    /**
     * Create an instance of {@link Account }
     * 
     */
    public Account createAccount() {
        return new Account();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDetailResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.soap.ws.spring.parthi.com/", name = "getDetailResponse")
    public JAXBElement<GetDetailResponse> createGetDetailResponse(GetDetailResponse value) {
        return new JAXBElement<GetDetailResponse>(_GetDetailResponse_QNAME, GetDetailResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Account }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.soap.ws.spring.parthi.com/", name = "account")
    public JAXBElement<Account> createAccount(Account value) {
        return new JAXBElement<Account>(_Account_QNAME, Account.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AccountHolderResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.soap.ws.spring.parthi.com/", name = "accountHolderResponse")
    public JAXBElement<AccountHolderResponse> createAccountHolderResponse(AccountHolderResponse value) {
        return new JAXBElement<AccountHolderResponse>(_AccountHolderResponse_QNAME, AccountHolderResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAccountDetails }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.soap.ws.spring.parthi.com/", name = "getAccountDetails")
    public JAXBElement<GetAccountDetails> createGetAccountDetails(GetAccountDetails value) {
        return new JAXBElement<GetAccountDetails>(_GetAccountDetails_QNAME, GetAccountDetails.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDetail }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.soap.ws.spring.parthi.com/", name = "getDetail")
    public JAXBElement<GetDetail> createGetDetail(GetDetail value) {
        return new JAXBElement<GetDetail>(_GetDetail_QNAME, GetDetail.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAccountDetailsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.soap.ws.spring.parthi.com/", name = "getAccountDetailsResponse")
    public JAXBElement<GetAccountDetailsResponse> createGetAccountDetailsResponse(GetAccountDetailsResponse value) {
        return new JAXBElement<GetAccountDetailsResponse>(_GetAccountDetailsResponse_QNAME, GetAccountDetailsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AccountHolderRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.soap.ws.spring.parthi.com/", name = "accountHolderRequest")
    public JAXBElement<AccountHolderRequest> createAccountHolderRequest(AccountHolderRequest value) {
        return new JAXBElement<AccountHolderRequest>(_AccountHolderRequest_QNAME, AccountHolderRequest.class, null, value);
    }

}

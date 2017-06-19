
package com.parthi.spring.ws.soap.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getAccountDetails complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getAccountDetails">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accountHolderRequest" type="{http://service.soap.ws.spring.parthi.com/}accountHolderRequest" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getAccountDetails", propOrder = {
    "accountHolderRequest"
})
public class GetAccountDetails {

    @XmlElement(namespace = "")
    protected AccountHolderRequest accountHolderRequest;

    /**
     * Gets the value of the accountHolderRequest property.
     * 
     * @return
     *     possible object is
     *     {@link AccountHolderRequest }
     *     
     */
    public AccountHolderRequest getAccountHolderRequest() {
        return accountHolderRequest;
    }

    /**
     * Sets the value of the accountHolderRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link AccountHolderRequest }
     *     
     */
    public void setAccountHolderRequest(AccountHolderRequest value) {
        this.accountHolderRequest = value;
    }

}

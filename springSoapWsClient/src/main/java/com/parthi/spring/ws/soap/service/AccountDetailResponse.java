
package com.parthi.spring.ws.soap.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accountDetail" type="{http://service.soap.ws.spring.parthi.com/}accountDetail" minOccurs="0" form="qualified"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "accountDetail"
})
@XmlRootElement(name = "accountDetailResponse")
public class AccountDetailResponse {

    protected AccountDetail accountDetail;

    /**
     * Gets the value of the accountDetail property.
     * 
     * @return
     *     possible object is
     *     {@link AccountDetail }
     *     
     */
    public AccountDetail getAccountDetail() {
        return accountDetail;
    }

    /**
     * Sets the value of the accountDetail property.
     * 
     * @param value
     *     allowed object is
     *     {@link AccountDetail }
     *     
     */
    public void setAccountDetail(AccountDetail value) {
        this.accountDetail = value;
    }

}

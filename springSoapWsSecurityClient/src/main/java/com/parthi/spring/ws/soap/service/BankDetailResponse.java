
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
 *         &lt;element name="bankDetail" type="{http://service.soap.ws.spring.parthi.com/}bankDetail" minOccurs="0" form="qualified"/>
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
    "bankDetail"
})
@XmlRootElement(name = "bankDetailResponse")
public class BankDetailResponse {

    protected BankDetail bankDetail;

    /**
     * Gets the value of the bankDetail property.
     * 
     * @return
     *     possible object is
     *     {@link BankDetail }
     *     
     */
    public BankDetail getBankDetail() {
        return bankDetail;
    }

    /**
     * Sets the value of the bankDetail property.
     * 
     * @param value
     *     allowed object is
     *     {@link BankDetail }
     *     
     */
    public void setBankDetail(BankDetail value) {
        this.bankDetail = value;
    }

}

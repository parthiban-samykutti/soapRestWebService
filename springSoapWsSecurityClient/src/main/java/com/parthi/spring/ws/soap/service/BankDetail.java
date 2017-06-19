
package com.parthi.spring.ws.soap.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for bankDetail complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="bankDetail">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="bankName" type="{http://www.w3.org/2001/XMLSchema}string" form="qualified"/>
 *         &lt;element name="rountingNumber" type="{http://www.w3.org/2001/XMLSchema}string" form="qualified"/>
 *         &lt;element name="cityName" type="{http://www.w3.org/2001/XMLSchema}string" form="qualified"/>
 *         &lt;element name="branchName" type="{http://www.w3.org/2001/XMLSchema}string" form="qualified"/>
 *         &lt;element name="zipCode" type="{http://www.w3.org/2001/XMLSchema}long" form="qualified"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "bankDetail", propOrder = {
    "bankName",
    "rountingNumber",
    "cityName",
    "branchName",
    "zipCode"
})
public class BankDetail {

    @XmlElement(required = true)
    protected String bankName;
    @XmlElement(required = true)
    protected String rountingNumber;
    @XmlElement(required = true)
    protected String cityName;
    @XmlElement(required = true)
    protected String branchName;
    protected long zipCode;

    /**
     * Gets the value of the bankName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBankName() {
        return bankName;
    }

    /**
     * Sets the value of the bankName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBankName(String value) {
        this.bankName = value;
    }

    /**
     * Gets the value of the rountingNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRountingNumber() {
        return rountingNumber;
    }

    /**
     * Sets the value of the rountingNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRountingNumber(String value) {
        this.rountingNumber = value;
    }

    /**
     * Gets the value of the cityName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCityName() {
        return cityName;
    }

    /**
     * Sets the value of the cityName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCityName(String value) {
        this.cityName = value;
    }

    /**
     * Gets the value of the branchName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBranchName() {
        return branchName;
    }

    /**
     * Sets the value of the branchName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBranchName(String value) {
        this.branchName = value;
    }

    /**
     * Gets the value of the zipCode property.
     * 
     */
    public long getZipCode() {
        return zipCode;
    }

    /**
     * Sets the value of the zipCode property.
     * 
     */
    public void setZipCode(long value) {
        this.zipCode = value;
    }

}

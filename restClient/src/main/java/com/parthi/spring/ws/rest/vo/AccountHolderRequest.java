package com.parthi.spring.ws.rest.vo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
/**
 * Account detail Request object.
 * 
 * @author  [Parthiban Samykutti]
 * @since 31/Aug/2016
 */
@XmlRootElement(name="accountHolderRequest", namespace="http://service.soap.ws.spring.parthi.com/")
public class AccountHolderRequest implements Serializable{
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 2797979046857229664L;
	private String accountName;

	public String getAccountName() {
		return accountName;
	}

	@XmlElement(name="accountName", namespace="http://service.soap.ws.spring.parthi.com/")
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}	
}

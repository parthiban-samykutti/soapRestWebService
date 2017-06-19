package com.parthi.spring.ws.soap.vo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * POJO class which holds the Account Number.
 * 
 * @author  [Parthiban Samykutti]
 * @since 31/Aug/2016
 */
@XmlRootElement(name="account", namespace="http://service.soap.ws.spring.parthi.com/")
public class Account implements Serializable {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 8478596117522592291L;
	@XmlElement(name="accountNumber", namespace="http://service.soap.ws.spring.parthi.com/")
	private long accountNumber;
	public Account(){};
	public Account(final long accountNumber){
		this.accountNumber = accountNumber;
	}
	public long getAccountNumber() {
		return accountNumber;
	}
	@Override
	public String toString(){
		final StringBuilder builder = new StringBuilder();
		builder.append("Account=[");
		builder.append("accountNumber: ");
		builder.append(accountNumber);
		builder.append("]");
		return builder.toString();
	}
}

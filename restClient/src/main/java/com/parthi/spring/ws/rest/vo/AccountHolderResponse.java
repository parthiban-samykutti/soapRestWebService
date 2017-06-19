package com.parthi.spring.ws.rest.vo;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
/**
 * POJO class which holds the details of Account holder.
 * 
 * @author  [Parthiban Samykutti]
 * @since 31/Aug/2016
 */
@XmlRootElement(name="accountHolderResponse", namespace="http://service.soap.ws.spring.parthi.com/")
public class AccountHolderResponse implements Serializable{
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -8074253934227500104L;
	/**
	 * Account holder name
	 */	
	private String name;
	/**
	 * List of accounts hold by the account holder.
	 */	
	private List<Account> accounNumbers;
	
	public String getName() {
		return name;
	}
	@XmlElement(name="accountName", namespace="http://service.soap.ws.spring.parthi.com/")
	public void setName(final String name) {
		this.name = name;
	}
	public List<Account> getAccounNumbers() {
		return accounNumbers;
	}
	@XmlElement(name="accounNumbers", namespace="http://service.soap.ws.spring.parthi.com/")
	public void setAccounNumbers(final List<Account> accounNumbers) {
		this.accounNumbers = accounNumbers;
	}
	@Override
	public String toString(){
		final StringBuilder builder = new StringBuilder();
		builder.append("AccountHolder=[");
		builder.append("name: ");
		builder.append(name);
		builder.append("accounNumbers: ");
		builder.append(accounNumbers);
		builder.append("]");
		return builder.toString();
	}
}

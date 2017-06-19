package com.parthi.ws.rest.vo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="Account")
public class Account {
	private String name;
	private int number;
	private String type;
	public String getName() {
		return name;
	}
	@XmlElement
	public void setName(String name) {
		this.name = name;
	}
	public int getNumber() {
		return number;
	}
	@XmlElement
	public void setNumber(int number) {
		this.number = number;
	}
	public String getType() {
		return type;
	}
	@XmlElement
	public void setType(String type) {
		this.type = type;
	}
	
}

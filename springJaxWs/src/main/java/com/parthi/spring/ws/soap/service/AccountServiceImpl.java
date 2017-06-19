package com.parthi.spring.ws.soap.service;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.apache.log4j.Logger;

import com.parthi.spring.ws.soap.vo.Account;
import com.parthi.spring.ws.soap.vo.AccountHolderRequest;
import com.parthi.spring.ws.soap.vo.AccountHolderResponse;
/**
 * SOAP service class to serve the account detail requests.
 * 
 * @author ps242[Parthiban Samykutti]
 * @since 31/Aug/2016
 */
@WebService(serviceName="AccountService", name="AccountService", targetNamespace="http://service.soap.ws.spring.parthi.com/")
public class AccountServiceImpl implements AccountService{
	private static final Logger LOG = Logger.getLogger(AccountServiceImpl.class);
	public AccountServiceImpl(){
		System.setProperty("com.sun.xml.internal.ws.transport.http.HttpAdapter.dump", "true");
		System.setProperty("com.sun.xml.ws.transport.http.HttpAdapter.dump", "true");
	}
	/*
	 * (non-Javadoc)
	 * @see com.parthi.spring.ws.soap.service.AccountService#getAccountDetails(com.parthi.spring.ws.soap.vo.AccountHolderRequest)
	 */
	@WebMethod
	public AccountHolderResponse getAccountDetails(@WebParam(partName="accountHolderRequest", name="accountHolderRequest") final AccountHolderRequest accountHolderRequest) {
		LOG.debug("Service Request came from the accountHolder: "+accountHolderRequest);
		final AccountHolderResponse accountHolderOutput = new AccountHolderResponse();
		final List<Account> accounNumbers = new ArrayList<Account>();
		accounNumbers.add(new Account(1321234));
		accounNumbers.add(new Account(4565676));
		accounNumbers.add(new Account(7867887));
		accounNumbers.add(new Account(4534567));
		accountHolderOutput.setAccounNumbers(accounNumbers);
		if(accountHolderRequest != null)
			accountHolderOutput.setName(accountHolderRequest.getAccountName());		
		return accountHolderOutput;
	}
	/*
	 * (non-Javadoc)
	 * @see com.parthi.spring.ws.soap.service.AccountService#getDetail(java.lang.String)
	 */
	@WebMethod
	public AccountHolderResponse getDetail(
			@WebParam(partName = "accountName", name="accountName") String accountName) {
		LOG.debug("Service Request came from the accountHolder: "+accountName);
		final AccountHolderResponse accountHolderOutput = new AccountHolderResponse();
		final List<Account> accounNumbers = new ArrayList<Account>();
		accounNumbers.add(new Account(1321234));
		accounNumbers.add(new Account(4565676));
		accounNumbers.add(new Account(7867887));
		accounNumbers.add(new Account(4534567));
		accountHolderOutput.setAccounNumbers(accounNumbers);
		accountHolderOutput.setName(accountName);
		return accountHolderOutput;
	}
}
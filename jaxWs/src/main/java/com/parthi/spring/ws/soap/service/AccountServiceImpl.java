package com.parthi.spring.ws.soap.service;

import java.util.ArrayList;
import java.util.List;

import javax.jws.HandlerChain;
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
 * @author [Parthiban Samykutti]
 * @since 31/Aug/2016
 */
@WebService(serviceName="AccountService", name="AccountService", targetNamespace="http://service.soap.ws.spring.parthi.com/")
@HandlerChain(file="handlers.xml")
public class AccountServiceImpl implements AccountService{
	private static final Logger LOG = Logger.getLogger(AccountServiceImpl.class);
	/*
	 * (non-Javadoc)
	 * @see com.parthi.spring.ws.soap.service.AccountService#getAccountDetails(com.parthi.spring.ws.soap.vo.AccountHolderRequest)
	 */
	@WebMethod
	public AccountHolderResponse getAccountDetails(@WebParam(partName="accountHolderRequest", name="accountHolderRequest") final AccountHolderRequest accountHolderRequest) {
		LOG.debug("Service Request came from the accountHolder: "+accountHolderRequest);
		System.setProperty("com.sun.xml.ws.transport.http.HttpAdapter.dump", "true");
		final AccountHolderResponse accountHolderOutput = new AccountHolderResponse();
		final List<Account> accounNumbers = new ArrayList<Account>();
		accounNumbers.add(new Account(1321234));
		accounNumbers.add(new Account(4565676));
		accounNumbers.add(new Account(7867887));
		accounNumbers.add(new Account(4534567));
		accountHolderOutput.setAccounNumbers(accounNumbers);
		accountHolderOutput.setName(accountHolderRequest.getAccountName());
		return accountHolderOutput;
	}
	/*
	 * (non-Javadoc)
	 * @see com.parthi.spring.ws.soap.service.AccountService#getAccountDetails(java.lang.String)
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
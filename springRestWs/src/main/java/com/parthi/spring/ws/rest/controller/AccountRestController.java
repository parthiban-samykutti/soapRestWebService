package com.parthi.spring.ws.rest.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.parthi.spring.ws.soap.service.AccountHolderRequest;
import com.parthi.spring.ws.soap.service.AccountHolderResponse;
import com.parthi.spring.ws.soap.service.AccountService;

/**
 * REST service controller to serve the account details for the incoming
 * requests.
 * 
 * @author [Parthiban Samykutti]
 * @since 31/Aug/2016
 */
@RequestMapping("/account/restController")
@RestController
public class AccountRestController {
	private static final Logger LOG = Logger.getLogger(AccountRestController.class);
	@Autowired
	private AccountService accountWebService;
	public AccountRestController() {
		System.setProperty("com.sun.xml.ws.transport.http.client.HttpTransportPipe.dump", "true");
	}
	/**
	 * Fetch the account details of the account holder name passed.
	 * 
	 * @param accountHolderInput
	 * @return accountHolderOutput
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/getAccountDetail", consumes = { MediaType.TEXT_XML_VALUE,MediaType.APPLICATION_XML_VALUE })
	public AccountHolderResponse getAccountDetail(
			@RequestBody final AccountHolderRequest accountHolderInput) {
		LOG.debug("Account details Request came to AccountController.getAccountDetail.....");
		LOG.debug("accountHolderInput: " + accountHolderInput);		
		final AccountHolderResponse accountHolderOutput = accountWebService.getAccountDetails(accountHolderInput);
		return accountHolderOutput;
	}
	/**
	 * Fetch the account details of the account holder name passed.
	 * 
	 * @param accountHolderInput
	 * @return accountHolderOutput
	 */
	@RequestMapping("/getAccountDetails")
	public AccountHolderResponse getAccountDetails(
			@RequestParam(value="name") final String accountHolderName) {
		LOG.debug("Account details Request came to AccountController.getAccountDetails.....");
		LOG.debug("accountHolderName: " + accountHolderName);
		final AccountHolderRequest accountHolderInput = new AccountHolderRequest();
		accountHolderInput.setAccountName(accountHolderName);
		final AccountHolderResponse accountHolderOutput = accountWebService.getAccountDetails(accountHolderInput);
		return accountHolderOutput;
	}
	/**
	 * Fetch the account details of the account holder name passed.
	 * 
	 * @param accountHolderInput
	 * @return accountHolderOutput
	 */
	@RequestMapping(method = RequestMethod.POST, value ="/getAccountDetails")
	public AccountHolderResponse fetchAccountDetails(
			@RequestBody final AccountHolderRequest accountHolderInput) {
		LOG.debug("Account details Request came to AccountController.fetchAccountDetails.....");
		LOG.debug("accountHolderName: " + accountHolderInput);
		final AccountHolderResponse accountHolderOutput = accountWebService.getAccountDetails(accountHolderInput);
		return accountHolderOutput;
	}
	/**
	 * Fetch the account details of the account holder name passed.
	 * 
	 * @param accountHolderInput
	 * @return accountHolderOutput
	 */
	@RequestMapping("/showDetails")
	public AccountHolderResponse dispalyRequestDetails(
			@RequestParam(value="name") final String accountHolderName) {
		LOG.debug("Account details Request came to AccountController.dispalyRequestDetails.....");
		LOG.debug("accountHolderName: " + accountHolderName);
		final AccountHolderResponse accountHolderOutput = (AccountHolderResponse) accountWebService.getDetail(accountHolderName);
		LOG.debug("accountHolderOutput: " + accountHolderOutput);
		return accountHolderOutput;
	}
}
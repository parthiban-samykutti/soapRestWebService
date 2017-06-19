package com.parthi.spring.ws.rest.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
@RequestMapping("account")
@Controller
public class AccountController {
	private static final Logger LOG = Logger.getLogger(AccountController.class);
	@Autowired
	private AccountService accountWebService;
	public AccountController(){
		System.setProperty("com.sun.xml.ws.transport.http.client.HttpTransportPipe.dump", "true");
	}
	/**
	 * Fetch the account details of the account holder name passed.
	 * 
	 * @param accountHolderInput
	 * @return accountHolderOutput
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/getAccountDetail", consumes = { MediaType.TEXT_XML_VALUE,MediaType.APPLICATION_XML_VALUE })
	public @ResponseBody AccountHolderResponse getAccountDetail(
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
	public @ResponseBody AccountHolderResponse getAccountDetails(
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
	@RequestMapping("/showDetails")
	public @ResponseBody AccountHolderResponse displayAccountDetails(
			@RequestParam(value="name") final String accountHolderName) {
		LOG.debug("Account details Request came to AccountController.displayAccountDetails.....");
		LOG.debug("accountHolderName: " + accountHolderName);
		final AccountHolderResponse accountHolderOutput = (AccountHolderResponse) accountWebService.getDetail(accountHolderName);
		return accountHolderOutput;
	}
}
package com.parthi.spring.ws.soap.client.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parthi.spring.ws.soap.service.AccountHolderRequest;
import com.parthi.spring.ws.soap.service.AccountHolderResponse;
import com.parthi.spring.ws.soap.service.AccountService;
/**
 * Consumer to access the account service published on the server.
 * 
 * @author parthiban samykutti
 * @since 01/Oct/2016
 *
 */
@Service
public class AccountServiceClient {
	@Autowired
	private AccountService accountService;
	/**
	 * Get the account details of the given request.
	 * 
	 * @param accountHolderRequest
	 * @return AccountHolderResponse
	 */
	public AccountHolderResponse getAccountDetails(final AccountHolderRequest accountHolderRequest){
		return accountService.getAccountDetails(accountHolderRequest);
	}
	/**
	 * Get the account details of given account name.
	 * 
	 * @param accountName
	 * @return AccountHolderResponse
	 */
	public AccountHolderResponse getDetails(final String accountName){
		return accountService.getDetail(accountName);
	}
	public void setAccountService(final AccountService accountService) {
		this.accountService = accountService;
	}
	
}

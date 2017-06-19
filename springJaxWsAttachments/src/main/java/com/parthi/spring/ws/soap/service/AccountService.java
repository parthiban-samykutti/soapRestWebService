package com.parthi.spring.ws.soap.service;

import com.parthi.spring.ws.soap.vo.AccountHolderRequest;
import com.parthi.spring.ws.soap.vo.AccountHolderResponse;
/**
 * Interface for Account service detail.
 * 
 * @author ps242[Parthiban Samykutti]
 * @since 31/Aug/2016
 */
public interface AccountService {
	/**
	 * Fetch the account detail for the given account name.
	 * 
	 * @param accountHolderRequest
	 * @return AccountHolderResponse
	 */
	public AccountHolderResponse getAccountDetails(final AccountHolderRequest accountHolderRequest);
	/**
	 * Fetch the account detail for the given account name.
	 * 
	 * @param accountName
	 * @return AccountHolderResponse
	 */
	public AccountHolderResponse getDetail(final String accountName);
}

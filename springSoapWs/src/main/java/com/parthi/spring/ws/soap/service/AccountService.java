package com.parthi.spring.ws.soap.service;

import com.parthi.spring.ws.soap.vo.AccountDetailRequest;
import com.parthi.spring.ws.soap.vo.AccountDetailResponse;
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
	 * @param accountDetailRequest
	 * @return AccountDetailResponse
	 */
	public AccountDetailResponse getAccountDetails(final AccountDetailRequest accountDetailRequest);
	/**
	 * Fetch the account detail for the given account name.
	 * 
	 * @param accountName
	 * @return AccountDetailResponse
	 */
	public AccountDetailResponse getDetail(final String accountName);
}

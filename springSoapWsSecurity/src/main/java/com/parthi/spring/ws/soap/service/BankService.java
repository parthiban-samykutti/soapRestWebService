package com.parthi.spring.ws.soap.service;

import com.parthi.spring.ws.soap.vo.BankBranchDetailsRequest;
import com.parthi.spring.ws.soap.vo.BankBranchDetailsResponse;
import com.parthi.spring.ws.soap.vo.BankDetailRequest;
import com.parthi.spring.ws.soap.vo.BankDetailResponse;
/**
 * Webservice interface to fetch the bank detail.
 *  
 * @author Parthiban Samykutti
 * @since 14/Oct/2016
 *
 */
public interface BankService {
	/**
	 * Get the bank detail of the given request (Routing Number).
	 * 
	 * @param bankDetailRequest
	 * @return BankDetailResponse
	 */
	public BankDetailResponse getBankDetail(final BankDetailRequest bankDetailRequest);
	/**
	 * Get the Bank branch details of the given request (bankName, CityName).
	 * 
	 * @param bankBranchDetailsRequest
	 * @return BankBranchDetailsResponse
	 */
	public BankBranchDetailsResponse getBankDetail(final BankBranchDetailsRequest bankBranchDetailsRequest);
}

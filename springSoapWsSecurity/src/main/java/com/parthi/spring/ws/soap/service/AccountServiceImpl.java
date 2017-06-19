package com.parthi.spring.ws.soap.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.parthi.spring.ws.soap.vo.AccountDetail;
import com.parthi.spring.ws.soap.vo.AccountDetailRequest;
import com.parthi.spring.ws.soap.vo.AccountDetailResponse;
import com.parthi.spring.ws.soap.vo.DetailRequest;
import com.parthi.spring.ws.soap.vo.DetailResponse;
/**
 * SOAP service class to serve the account detail requests.
 * 
 * @author ps242[Parthiban Samykutti]
 * @since 31/Aug/2016
 */
@Endpoint(value="accountService")
public class AccountServiceImpl implements AccountService{
	private static final Logger LOG = Logger.getLogger(AccountServiceImpl.class);
	public AccountServiceImpl(){
		LOG.trace("creating instance for AccountServiceImpl.....");
	}
	/*
	 * (non-Javadoc)
	 * @see com.parthi.spring.ws.soap.service.AccountService#getAccountDetails(com.parthi.spring.ws.soap.vo.AccountDetailRequest)
	 */
	@PayloadRoot(localPart="accountDetailRequest", namespace="http://service.soap.ws.spring.parthi.com/")
	public @ResponsePayload AccountDetailResponse getAccountDetails(@RequestPayload final AccountDetailRequest accountDetailRequest) {
		LOG.debug("Service Request came from the accountHolder: "+accountDetailRequest);
		final AccountDetailResponse response = new AccountDetailResponse();
		AccountDetail accountDetail = new AccountDetail();
		final List<Long> accounNumbers = new ArrayList<Long>();
		accounNumbers.add(1321234L);
		accounNumbers.add(4565676L);
		accounNumbers.add(1323423L);
		accounNumbers.add(1334567L);
		accountDetail.getAccountNumbers().addAll(accounNumbers);
		if(accountDetailRequest != null)
			accountDetail.setAccountName(accountDetailRequest.getAccountName());	
		response.setAccountDetail(accountDetail);
		return response;
	}
	/*
	 * (non-Javadoc)
	 * @see com.parthi.spring.ws.soap.service.AccountService#getDetail(com.parthi.spring.ws.soap.vo.DetailRequest)
	 */
	@PayloadRoot(localPart="detailRequest", namespace="http://service.soap.ws.spring.parthi.com/")
	public @ResponsePayload DetailResponse getDetail(
			@RequestPayload final DetailRequest request) {
		LOG.debug("Service Request came from the accountHolder: "+request);
		final DetailResponse response = new DetailResponse();		
		AccountDetail accountDetail = new AccountDetail();
		final List<Long> accounNumbers = new ArrayList<Long>();
		accounNumbers.add(4565676L);
		accounNumbers.add(1323423L);
		accounNumbers.add(1334567L);
		accountDetail.getAccountNumbers().addAll(accounNumbers);
		if(request != null)
			accountDetail.setAccountName(request.getAccountName());
		response.setAccountDetail(accountDetail);	
		return response;
	}
}
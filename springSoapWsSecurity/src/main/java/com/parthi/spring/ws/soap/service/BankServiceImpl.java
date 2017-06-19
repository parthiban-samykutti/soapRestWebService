package com.parthi.spring.ws.soap.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.parthi.spring.ws.soap.vo.BankBranchDetailsRequest;
import com.parthi.spring.ws.soap.vo.BankBranchDetailsResponse;
import com.parthi.spring.ws.soap.vo.BankDetail;
import com.parthi.spring.ws.soap.vo.BankDetailRequest;
import com.parthi.spring.ws.soap.vo.BankDetailResponse;
/**
 * Webservice to serve the bank detail & branch detail requests.
 * 
 * @author Parthiban Samykutti
 * @since 14/Oct/2016
 *
 */
@Endpoint(value="bankService")
public class BankServiceImpl implements BankService {
	private static final Logger LOG = Logger.getLogger(BankServiceImpl.class);
	/*
	 * (non-Javadoc)
	 * @see com.parthi.spring.ws.soap.service.BankService#getBankDetail(com.parthi.spring.ws.soap.vo.BankDetailRequest)
	 */
	@PayloadRoot(localPart="bankDetailRequest", namespace="http://service.soap.ws.spring.parthi.com/")
	public @ResponsePayload BankDetailResponse getBankDetail(final @RequestPayload BankDetailRequest bankDetailRequest) {
		LOG.trace("Invokes BankServiceImpl.getBankDetail(bankDetailRequest).....");
		LOG.debug("bankDetailRequest.getRoutingNumber: "+bankDetailRequest.getRoutingNumber());
		final BankDetailResponse response = new BankDetailResponse();
		final BankDetail bankDetail = new BankDetail();
		if(bankDetailRequest != null){
			bankDetail.setBankName("HDFC");
			bankDetail.setBranchName("Medavakkam");
			bankDetail.setCityName("Chennai");
			bankDetail.setRountingNumber(bankDetailRequest.getRoutingNumber());
			bankDetail.setZipCode(600100);
		}
		response.setBankDetail(bankDetail);
		return response;
	}
	/*
	 * (non-Javadoc)
	 * @see com.parthi.spring.ws.soap.service.BankService#getBankDetail(com.parthi.spring.ws.soap.vo.BankBranchDetailsRequest)
	 */
	@PayloadRoot(localPart="bankBranchDetailsRequest", namespace="http://service.soap.ws.spring.parthi.com/")
	public @ResponsePayload BankBranchDetailsResponse getBankDetail(final @RequestPayload BankBranchDetailsRequest bankBranchDetailsRequest) {
		LOG.trace("Invokes BankServiceImpl.getBankDetail(bankBranchDetailsRequest).....");
		LOG.debug("bankBranchDetailsRequest.getBankName: "+bankBranchDetailsRequest.getBankName());
		LOG.debug("bankBranchDetailsRequest.getCityName: "+bankBranchDetailsRequest.getCityName());
		final List<BankDetail> bankDetails = new ArrayList<BankDetail>();
		BankDetail bankDetail = new BankDetail();
		bankDetail.setBankName(bankBranchDetailsRequest.getBankName());
		bankDetail.setBranchName("Medavakkam");
		bankDetail.setCityName(bankBranchDetailsRequest.getCityName());
		bankDetail.setRountingNumber("1209823");
		bankDetail.setZipCode(600100);
		bankDetails.add(bankDetail);
		bankDetail = new BankDetail();
		bankDetail.setBankName(bankBranchDetailsRequest.getBankName());
		bankDetail.setBranchName("Madipakkam");
		bankDetail.setCityName(bankBranchDetailsRequest.getCityName());
		bankDetail.setRountingNumber("1209423");
		bankDetail.setZipCode(600096);
		bankDetails.add(bankDetail);
		bankDetail = new BankDetail();
		bankDetail.setBankName(bankBranchDetailsRequest.getBankName());
		bankDetail.setBranchName("Selaiyur");
		bankDetail.setCityName(bankBranchDetailsRequest.getCityName());
		bankDetail.setRountingNumber("1209824");
		bankDetail.setZipCode(600098);
		bankDetails.add(bankDetail);
		final BankBranchDetailsResponse response = new BankBranchDetailsResponse();
		response.getBankBranchDetails().addAll(bankDetails);
		return response;
	}

}

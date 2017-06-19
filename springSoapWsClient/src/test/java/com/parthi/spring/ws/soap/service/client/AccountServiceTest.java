package com.parthi.spring.ws.soap.service.client;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ws.client.core.WebServiceTemplate;

import com.parthi.spring.ws.soap.service.AccountDetailRequest;
import com.parthi.spring.ws.soap.service.AccountDetailResponse;
import com.parthi.spring.ws.soap.service.DetailRequest;
import com.parthi.spring.ws.soap.service.DetailResponse;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:soapClient.xml"})
public class AccountServiceTest {
	private static final Logger LOG = Logger.getLogger(AccountServiceTest.class);
	@Autowired
	private WebServiceTemplate accountWsTemplate;
	
	@Test
	public void getAccountDetails(){
		LOG.trace("AccountServiceTest.getAccountDetails....");
		final AccountDetailRequest request = new AccountDetailRequest();
		request.setAccountName("parthibanSamykutti");
		//SoapActionCallback callback = new SoapActionCallback("accountDetail");
		AccountDetailResponse accountDetailResponse = (AccountDetailResponse) accountWsTemplate.marshalSendAndReceive(request);
		LOG.trace("AccountDetailResponse: "+accountDetailResponse);
	}
	@Test
	public void getDetails(){
		LOG.trace("AccountServiceTest.getDetails....");
		final DetailRequest request = new DetailRequest();
		request.setAccountName("Kanishkha Parthiban");
		//SoapActionCallback callback = new SoapActionCallback("accountDetail");
		DetailResponse detailResponse = (DetailResponse) accountWsTemplate.marshalSendAndReceive(request);
		LOG.trace("detailResponse: "+detailResponse);
	}
}

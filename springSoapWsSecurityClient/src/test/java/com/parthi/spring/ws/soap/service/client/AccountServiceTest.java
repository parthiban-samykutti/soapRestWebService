package com.parthi.spring.ws.soap.service.client;

import org.apache.log4j.Logger;
import org.junit.Assert;
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
import com.parthi.spring.ws.soap.service.interceptor.XwssMessageSigner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:soapClient.xml"})
public class AccountServiceTest {
	private static final Logger LOG = Logger.getLogger(AccountServiceTest.class);
	@Autowired
	private WebServiceTemplate accountWsTemplate;
	@Autowired
	private XwssMessageSigner xwssMessageSigner;
	@Test
	public void getAccountDetails(){
		LOG.trace("AccountServiceTest.getAccountDetails....");
		final AccountDetailRequest request = new AccountDetailRequest();
		request.setAccountName("parthibanSamykutti");
		AccountDetailResponse accountDetailResponse = (AccountDetailResponse) accountWsTemplate.marshalSendAndReceive(request);
		LOG.trace("AccountDetailResponse: "+accountDetailResponse);
	}
	/**
	 * Test the webservice method by passing the secured/signed SOAP request.
	 */
	@Test
	public void getDetails(){
		LOG.trace("AccountServiceTest.getDetails....");
		final DetailRequest request = new DetailRequest();
		request.setAccountName("Kanishkha Parthiban");
		DetailResponse detailResponse = (DetailResponse) accountWsTemplate.marshalSendAndReceive(request, xwssMessageSigner.getCallback());
		LOG.trace("detailResponse: "+detailResponse);
		Assert.assertNotNull(detailResponse);
		Assert.assertEquals(request.getAccountName(), detailResponse.getAccountDetail().getAccountName());
	}
}

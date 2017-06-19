package com.parthi.spring.ws.soap.service.client;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ws.client.core.WebServiceTemplate;

import com.parthi.spring.ws.soap.service.BankDetailRequest;
import com.parthi.spring.ws.soap.service.BankDetailResponse;
import com.parthi.spring.ws.soap.service.interceptor.XwssUnamePwdAttacher;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:soapClient.xml"})
public class BankServiceTest {
	private static final Logger LOG = Logger.getLogger(BankServiceTest.class);
	@Autowired
	private WebServiceTemplate bankWsTemplate;
	@Autowired
	private XwssUnamePwdAttacher xwssUnamePwdAttacher;
	
	/**
	 * Test the webservice method by passing the userName/password along with SOAP request.
	 */
	@Test
	public void getBankDetail(){
		LOG.trace("BankServiceTest.getBankDetail....");
		final BankDetailRequest request = new BankDetailRequest();
		request.setRoutingNumber("1234567");
		BankDetailResponse detailResponse = (BankDetailResponse) bankWsTemplate.marshalSendAndReceive(request, xwssUnamePwdAttacher.getCallback());
		LOG.trace("getBankDetail.detailResponse: "+detailResponse);
		Assert.assertNotNull(detailResponse);
		Assert.assertEquals(request.getRoutingNumber(), detailResponse.getBankDetail().getRountingNumber());
	}
}

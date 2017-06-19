package com.parthi.spring.ws.soap.client.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.parthi.spring.ws.soap.service.AccountHolderRequest;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:jaxwsSpringContext.xml")
public class AccountServiceClientTest {
	@Autowired
	AccountServiceClient accountServiceClient = null;
	
	@Test
	public void testGetAccountDetails(){
		AccountHolderRequest accountHolderRequest = new AccountHolderRequest();
		accountHolderRequest.setAccountName("ParthibanSamykutti");
		accountServiceClient.getAccountDetails(accountHolderRequest);
	}
	
	@Test
	public void testGetDetails(){
		accountServiceClient.getDetails("parthi");
	}
}

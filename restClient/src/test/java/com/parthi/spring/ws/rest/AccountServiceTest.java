package com.parthi.spring.ws.rest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.apache.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestClientException;

import com.parthi.spring.ws.rest.AccountService;
import com.parthi.spring.ws.rest.vo.AccountHolderResponse;
/**
 * This class has the Junit test cases for methods in <AcconutService>.
 * 
 * @author [Parthiban Samykutti]
 * @since 31/Aug/2016
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:restAccountContext.xml")
public class AccountServiceTest {
	private static final Logger LOG = Logger.getLogger(AccountServiceTest.class);
	@Autowired
	AccountService accountService;
	
	@Test
	public void testGetAccountDetailByPost(){
		AccountHolderResponse accountHolder = null;
		try{
			accountHolder = accountService.getAccountDetailByPost("s Parthiban");
			assertNotNull(accountHolder);
			assertEquals(accountHolder.getName(), "s Parthiban");
		}catch(final RestClientException clientException){
			LOG.error(clientException);
			clientException.printStackTrace();
			fail("testGetAccountDetailByPost is failed");
		}
	}
	@Ignore
	@Test
	public void testGetAccountDetailsByGetRest(){
		AccountHolderResponse accountHolder = null;
		try{
			accountHolder = accountService.getAccountDetailByGetRest("Parthiban s");
			assertNotNull(accountHolder);
			assertEquals(accountHolder.getName(), "Parthiban s");
		}catch(final RestClientException clientException){
			LOG.error(clientException);
			clientException.printStackTrace();
			fail("testGetAccountDetailsByGetRest is failed");
		}		
	}
	@Ignore
	@Test
	public void testGetAccountDetailsByGet(){
		AccountHolderResponse accountHolder = null;
		try{
			accountHolder = accountService.getAccountDetailsByGet("Parthiban samykutti");
			assertNotNull(accountHolder);
			assertEquals(accountHolder.getName(), "Parthiban samykutti");
		}catch(final RestClientException clientException){
			LOG.error(clientException);
			clientException.printStackTrace();
			fail("testGetAccountDetailsByGet is failed");
		}		
	}
	
	@Test
	public void testGetAccountDetailsByPostRest(){
		AccountHolderResponse accountHolder = null;
		try{
			accountHolder = accountService.getAccountDetailsByPostRest("Parthiban samykutti - 0");
			assertNotNull(accountHolder);
			assertEquals(accountHolder.getName(), "Parthiban samykutti - 0");
		}catch(final RestClientException clientException){
			LOG.error(clientException);
			clientException.printStackTrace();
			fail("testGetAccountDetailsByPostRest is failed");
		}		
	}
	@Ignore
	@Test
	public void testShowDetailsByGet(){
		AccountHolderResponse accountHolder = null;
		try{
			accountHolder = accountService.showDetailsByGet("Parthiban samykutti - 1");
			assertNotNull(accountHolder);
			assertEquals(accountHolder.getName(), "Parthiban samykutti - 1");
		}catch(final RestClientException clientException){
			LOG.error(clientException);
			clientException.printStackTrace();
			fail("testShowDetailsByGet is failed");
		}		
	}
	@Ignore
	@Test
	public void testShowDetailsByGetRest(){
		AccountHolderResponse accountHolder = null;
		try{
			accountHolder = accountService.showDetailsByGetRest("Parthiban samykutti - 2");
			assertNotNull(accountHolder);
			assertEquals(accountHolder.getName(), "Parthiban samykutti - 2");
		}catch(final RestClientException clientException){
			LOG.error(clientException);
			clientException.printStackTrace();
			fail("testShowDetailsByGetRest is failed");
		}		
	}
}

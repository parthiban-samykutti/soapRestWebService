package com.parthi.spring.ws.rest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.parthi.spring.ws.rest.vo.AccountHolderRequest;
import com.parthi.spring.ws.rest.vo.AccountHolderResponse;
/**
 * This class fetch the account details of the account holder from a REST service.
 * 
 * @author  [Parthiban Samykutti]
 * @since 31/Aug/2016
 */
public class AccountService {
	private static final Logger LOG = Logger.getLogger(AccountService.class);
	@Autowired
	private RestTemplate restTemplate;
	private String getAccountDetailPostUrl;
	private String getAccountDetailsGetUrl;
	private String showDetailsGetUrl;
	private String getAccountDetailGetRestUrl;
	private String getAccountDetailsGetRestUrl;
	private String getAccountDetailsPostRestUrl;
	private String showDetailsGetRestUrl;
	
	/**
	 * Retrieves the account details of the account holder through a post method of a @RESTController.
	 * 
	 * @param name
	 * @return AccountHolderResponse
	 */
	public AccountHolderResponse getAccountDetailsByPostRest(final String name) throws RestClientException{
		LOG.debug("getAccountDetailsPostRest-getAccountDetails of: "+name);
		final AccountHolderRequest accountHolder = new AccountHolderRequest();
		accountHolder.setAccountName(name);
		restTemplate.getMessageConverters().add(new Jaxb2RootElementHttpMessageConverter());
		return restTemplate.postForObject(getAccountDetailsPostRestUrl, accountHolder, AccountHolderResponse.class);
	}
	/**
	 * Retrieves the account details of the account holder through a post method of a @Controller.
	 * 
	 * @param name
	 * @return AccountHolderResponse
	 */
	public AccountHolderResponse getAccountDetailByPost(final String name) throws RestClientException{
		LOG.debug("getAccountDetailPost - getAccountDetails of: "+name);
		final AccountHolderRequest accountHolder = new AccountHolderRequest();
		accountHolder.setAccountName(name);
		restTemplate.getMessageConverters().add(new Jaxb2RootElementHttpMessageConverter());
		return restTemplate.postForObject(getAccountDetailPostUrl, accountHolder, AccountHolderResponse.class);
	}
	/**
	 * Retrieves the account details of the account holder through a Get method of @Controller
	 * 
	 * @param name
	 * @return AccountHolderResponse
	 */
	public AccountHolderResponse getAccountDetailsByGet(final String name) throws RestClientException{
		LOG.debug("getAccountDetailsGet - getAccountDetails of: "+name);
		restTemplate.getMessageConverters().add(new Jaxb2RootElementHttpMessageConverter());
		return restTemplate.getForObject(getAccountDetailsGetUrl, AccountHolderResponse.class, name);
	}
	/**
	 * Retrieves the account details of the account holder through a Get method of @Controller.
	 * 
	 * @param name
	 * @return AccountHolderResponse
	 */
	public AccountHolderResponse showDetailsByGet(final String name) throws RestClientException{
		LOG.debug("showDetailsGetUrl - getAccountDetails of: "+name);
		restTemplate.getMessageConverters().add(new Jaxb2RootElementHttpMessageConverter());
		return restTemplate.getForObject(showDetailsGetUrl, AccountHolderResponse.class, name);
	}
	/**
	 * Retrieves the account details of the account holder through a Get method of @RestController.
	 * 
	 * @param name
	 * @return AccountHolderResponse
	 */
	public AccountHolderResponse getAccountDetailByGetRest(final String name) throws RestClientException{
		LOG.debug("getAccountDetailGetRest - getAccountDetails of: "+name);
		restTemplate.getMessageConverters().add(new Jaxb2RootElementHttpMessageConverter());
		return restTemplate.getForObject(getAccountDetailGetRestUrl, AccountHolderResponse.class, name);
	}
	/**
	 * Retrieves the account details of the account holder through a Get method of @RestController.
	 * 
	 * @param name
	 * @return AccountHolderResponse
	 */
	public AccountHolderResponse getAccountDetailsByGetRest(final String name) throws RestClientException{
		LOG.debug("getAccountDetailsGetRest - getAccountDetails of: "+name);
		restTemplate.getMessageConverters().add(new Jaxb2RootElementHttpMessageConverter());
		return restTemplate.getForObject(getAccountDetailsGetRestUrl, AccountHolderResponse.class, name);
	}
	/**
	 * Retrieves the account details of the account holder through a Get method of @RestController.
	 * 
	 * @param name
	 * @return AccountHolderResponse
	 */
	public AccountHolderResponse showDetailsByGetRest(final String name) throws RestClientException{
		LOG.debug("showDetailsGetRest - getAccountDetails of: "+name);
		return restTemplate.getForObject(showDetailsGetRestUrl, AccountHolderResponse.class, name);
	}
	
	public void setGetAccountDetailPostUrl(final String getAccountDetailPostUrl) {
		this.getAccountDetailPostUrl = getAccountDetailPostUrl;
	}
	public void setGetAccountDetailsGetUrl(final String getAccountDetailsGetUrl) {
		this.getAccountDetailsGetUrl = getAccountDetailsGetUrl;
	}
	public void setShowDetailsGetUrl(final String showDetailsGetUrl) {
		this.showDetailsGetUrl = showDetailsGetUrl;
	}
	public void setGetAccountDetailGetRestUrl(final String getAccountDetailGetRestUrl) {
		this.getAccountDetailGetRestUrl = getAccountDetailGetRestUrl;
	}
	public void setGetAccountDetailsGetRestUrl(final String getAccountDetailsGetRestUrl) {
		this.getAccountDetailsGetRestUrl = getAccountDetailsGetRestUrl;
	}
	public void setGetAccountDetailsPostRestUrl(final String getAccountDetailsPostRestUrl) {
		this.getAccountDetailsPostRestUrl = getAccountDetailsPostRestUrl;
	}
	public void setShowDetailsGetRestUrl(final String showDetailsGetRestUrl) {
		this.showDetailsGetRestUrl = showDetailsGetRestUrl;
	}	
}
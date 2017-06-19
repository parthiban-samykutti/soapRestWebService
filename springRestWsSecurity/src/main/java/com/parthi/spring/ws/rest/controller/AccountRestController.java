package com.parthi.spring.ws.rest.controller;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST service controller to serve the account details for the incoming
 * requests.
 * 
 * @author [Parthiban Samykutti]
 * @since 31/Aug/2016
 */
@RequestMapping("/account/restController")
@RestController
public class AccountRestController {
	private static final Logger LOG = Logger.getLogger(AccountRestController.class);
	/**
	 * Fetch the account details of the account holder name passed.
	 * 
	 * @param accountName
	 * @return accountHolderOutput
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/getAccountDetail",produces={MediaType.APPLICATION_JSON_VALUE})
	public Object getAccountDetail(
			final @RequestParam(value="accountName")String accountName) {
		LOG.debug("Account details Request came to AccountRestController.getAccountDetail....."+accountName);
		final JSONObject jsonObject = new JSONObject();
		jsonObject.append("accountName", accountName);
		return jsonObject;
	}
	/**
	 * Fetch the account details of the account holder name passed.
	 * 
	 * @param accountName
	 * @return accountHolderOutput
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/getAccount")
	public  Object getAccount(
			final @RequestParam(value="accountName") String accountName) {
		LOG.debug("Account details Request came to AccountRestController.getAccount....."+accountName);
		final JSONObject jsonObject = new JSONObject();
		jsonObject.append("accountName", accountName);
		return jsonObject;
	}
	/**
	 * Fetch the account details of the account holder name passed.
	 * 
	 * @param accountName
	 * @return accountHolderOutput
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/get")
	public String get(
			final @RequestParam(value="accountName") String accountName) {
		LOG.debug("Account details Request came to AccountRestController.get....."+accountName);
		return accountName;
	}
	/**
	 * Fetch the account details of the account holder name passed.
	 * 
	 * @param accountName
	 * @return accountHolderOutput
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/getName")
	public String getName() {
		LOG.debug("Account details Request came to AccountRestController.getName.....");
		return "name";
	}
}
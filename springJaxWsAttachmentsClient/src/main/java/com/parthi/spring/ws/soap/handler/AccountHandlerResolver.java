package com.parthi.spring.ws.soap.handler;

import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.HandlerResolver;
import javax.xml.ws.handler.PortInfo;

import org.apache.log4j.Logger;
/**
 * Handler resolver to attach the SOAP handlers with SOAP service implementation.
 * 
 * @author Parthiban Samykutti
 * @since 30/Sep/2016
 *
 */
public class AccountHandlerResolver implements HandlerResolver{
	/*
	 * (non-Javadoc)
	 * @see javax.xml.ws.handler.HandlerResolver#getHandlerChain(javax.xml.ws.handler.PortInfo)
	 */
	@SuppressWarnings("rawtypes")
	public List<Handler> getHandlerChain(final PortInfo portInfo) {
		LOG.trace("Invoked AccountHandlerResolver.getHandlerChain.....");
		final AccountMessageHandler accountMessageHandler = new AccountMessageHandler();
		final List<Handler> handlerList = new ArrayList<Handler>();
		handlerList.add(accountMessageHandler);
		return handlerList;
	}	
	private static final Logger LOG = Logger.getLogger(AccountHandlerResolver.class);
}

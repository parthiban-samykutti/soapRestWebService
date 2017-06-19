package com.parthi.spring.ws.soap.interceptor;

import org.apache.log4j.Logger;
/**
 * Subclass to <code>SoapEnvelopeLoggingInterceptor<code> which logs the request and response SOAP messages.
 * 
 * @author Parthiban SAmykutti
 * @since 12/Oct/2016
 */
public class SoapEnvelopeLoggingInterceptor
		extends org.springframework.ws.soap.server.endpoint.interceptor.SoapEnvelopeLoggingInterceptor {
	private static final Logger LOG = Logger.getLogger(SoapEnvelopeLoggingInterceptor.class);
	/*
	 * (non-Javadoc)
	 * @see org.springframework.ws.server.endpoint.AbstractLoggingInterceptor#logMessage(java.lang.String)
	 */
	@Override
	public void logMessage(String message) {
		LOG.trace(message);
	}
	/*
	 * (non-Javadoc)
	 * @see org.springframework.ws.server.endpoint.AbstractLoggingInterceptor#isLogEnabled()
	 */
	@Override
	public boolean isLogEnabled() {
		return true;
	}
}

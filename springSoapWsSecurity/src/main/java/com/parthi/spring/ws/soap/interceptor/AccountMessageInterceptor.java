package com.parthi.spring.ws.soap.interceptor;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import org.apache.log4j.Logger;
import org.springframework.ws.context.MessageContext;
import org.springframework.ws.soap.SoapHeaderElement;
import org.springframework.ws.soap.server.SoapEndpointInterceptor;

/**
 * Intercepts the incoming and outgoing SOAP messages.
 * 
 * @author Parthiban Samykutti
 * @since 06/Oct/2016
 *
 */
public class AccountMessageInterceptor implements SoapEndpointInterceptor {
	private static final Logger LOG = Logger.getLogger(AccountMessageInterceptor.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.ws.server.EndpointInterceptor#handleRequest(org.
	 * springframework.ws.context.MessageContext, java.lang.Object)
	 */
	public boolean handleRequest(final MessageContext messageContext, final Object endpoint) throws Exception {
		LOG.trace("AccountMessageInterceptor.handleRequest.....");
		final File file = new File("..\\logs\\springSoapWs-request.xml");
		if (!file.exists()) {
			file.createNewFile();
		}
		final OutputStream outputStream = new FileOutputStream(file);
		messageContext.getRequest().writeTo(outputStream);
		LOG.trace("AccountMessageInterceptor.getPayloadSource: " + messageContext.getRequest().getPayloadSource());
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.ws.server.EndpointInterceptor#handleResponse(org.
	 * springframework.ws.context.MessageContext, java.lang.Object)
	 */
	public boolean handleResponse(MessageContext messageContext, Object endpoint) throws Exception {
		LOG.trace("AccountMessageInterceptor.handleResponse.....");
		final File file = new File("..\\logs\\springSoapWs-response.xml");
		if (!file.exists()) {
			file.createNewFile();
		}
		final OutputStream outputStream = new FileOutputStream(file);
		messageContext.getResponse().writeTo(outputStream);
		LOG.trace("AccountMessageInterceptor.getPayloadResult: " + messageContext.getRequest().getPayloadResult());
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.ws.server.EndpointInterceptor#handleFault(org.
	 * springframework.ws.context.MessageContext, java.lang.Object)
	 */
	public boolean handleFault(MessageContext messageContext, Object endpoint) throws Exception {
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.ws.server.EndpointInterceptor#afterCompletion(org.
	 * springframework.ws.context.MessageContext, java.lang.Object,
	 * java.lang.Exception)
	 */
	public void afterCompletion(MessageContext messageContext, Object endpoint, Exception ex) throws Exception {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.ws.soap.server.SoapEndpointInterceptor#understands(
	 * org.springframework.ws.soap.SoapHeaderElement)
	 */
	public boolean understands(SoapHeaderElement header) {
		return true;
	}

}

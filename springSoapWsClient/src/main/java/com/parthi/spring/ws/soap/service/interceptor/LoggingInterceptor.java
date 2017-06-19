package com.parthi.spring.ws.soap.service.interceptor;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.soap.SOAPMessageContext;

import org.apache.log4j.Logger;
import org.springframework.ws.client.WebServiceClientException;
import org.springframework.ws.client.support.interceptor.ClientInterceptor;
import org.springframework.ws.context.MessageContext;
/**
 * Intercepts the SOAP request & REsponse from SOAP Client.
 * 
 * @author Parthiban SAmykutti
 * @since 06/Oct/2016
 */
public class LoggingInterceptor implements ClientInterceptor {
	private static final Logger LOG = Logger.getLogger(LoggingInterceptor.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.ws.client.support.interceptor.ClientInterceptor#
	 * handleRequest(org.springframework.ws.context.MessageContext)
	 */
	public boolean handleRequest(MessageContext messageContext) throws WebServiceClientException {
		LOG.trace("LoggingInterceptor.handleRequest.....");
		final File file = new File("target\\logs\\springSoapWsClient-request.xml");
		if (!file.exists()) {
			try {
				file.createNewFile();
				final OutputStream outputStream = new FileOutputStream(file);
				messageContext.getRequest().writeTo(outputStream);
				LOG.trace("LoggingInterceptor.getPayloadSource: " + messageContext.getRequest().getPayloadSource());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.ws.client.support.interceptor.ClientInterceptor#
	 * handleResponse(org.springframework.ws.context.MessageContext)
	 */
	public boolean handleResponse(MessageContext messageContext) throws WebServiceClientException {
		LOG.trace("LoggingInterceptor.handleResponse.....");
		final File file = new File("target\\logs\\springSoapWs-response.xml");
		if (!file.exists()) {
			try {
				file.createNewFile();
				final OutputStream outputStream = new FileOutputStream(file);
				messageContext.getResponse().writeTo(outputStream);
				LOG.trace("LoggingInterceptor.getPayloadResult: " + messageContext.getRequest().getPayloadResult());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.ws.client.support.interceptor.ClientInterceptor#
	 * handleFault(org.springframework.ws.context.MessageContext)
	 */
	public boolean handleFault(MessageContext messageContext) throws WebServiceClientException {
		if(messageContext instanceof SOAPMessageContext){
			SOAPMessageContext context = (SOAPMessageContext) messageContext;
			SOAPMessage message = context.getMessage();
			try {
				SOAPBody soapBody = message.getSOAPBody();
				if(soapBody.hasFault()){
					LOG.error("There was an SOAPFault encountered."+soapBody.getFault());
				}
			} catch (SOAPException e) {
				e.printStackTrace();
			}
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.ws.client.support.interceptor.ClientInterceptor#
	 * afterCompletion(org.springframework.ws.context.MessageContext,
	 * java.lang.Exception)
	 */
	public void afterCompletion(MessageContext messageContext, Exception ex) throws WebServiceClientException {
		
	}

}

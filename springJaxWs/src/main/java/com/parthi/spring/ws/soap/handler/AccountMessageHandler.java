package com.parthi.spring.ws.soap.handler;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

import org.apache.log4j.Logger;
/**
 * Handler to intercept the SOAP request and response messages.
 * 
 * @author Parthiban SAmykutti
 * @since 27/Sep/2016
 */
public class AccountMessageHandler implements SOAPHandler<SOAPMessageContext> {
	private static final Logger LOG = Logger
			.getLogger(AccountMessageHandler.class);
	/*
	 * (non-Javadoc)
	 * @see javax.xml.ws.handler.Handler#close(javax.xml.ws.handler.MessageContext)
	 */
	public void close(final MessageContext msgCtx) {

	}
	/*
	 * (non-Javadoc)
	 * @see javax.xml.ws.handler.Handler#handleFault(javax.xml.ws.handler.MessageContext)
	 */
	public boolean handleFault(final SOAPMessageContext soapMsgCtx) {
		return false;
	}
	/*
	 * (non-Javadoc)
	 * @see javax.xml.ws.handler.Handler#handleMessage(javax.xml.ws.handler.MessageContext)
	 */
	public boolean handleMessage(final SOAPMessageContext soapMsgCtx) {
		LOG.trace("Invokes handleMessage.");
		boolean isResponse = (Boolean) soapMsgCtx
				.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
		LOG.trace("is Outbound message: " + isResponse);
		final SOAPMessage soapMessage = soapMsgCtx.getMessage();
		File outputFile = null;
		if (isResponse) {
			outputFile = new File("..\\logs\\getAccountDetails-springJaxws-soapResponse.xml");
		} else {
			outputFile = new File("..\\logs\\getAccountDetails-springJaxws-soapRequest.xml");
		}
		OutputStream outputStream = null;
		try {
			if (!outputFile.exists()) {
				outputFile.createNewFile();
			}			
			outputStream = new FileOutputStream(outputFile);
			soapMessage.writeTo(outputStream);
		} catch (final IOException e) {
			LOG.error("IOException in handleMessage while writing the soap request/response to file: "+e.fillInStackTrace());
		} catch (final SOAPException e) {
			LOG.error("SOAPException in handleMessage while writing the soap request/response to file: "+e.fillInStackTrace());
		}
		return true;
	}
	/*
	 * (non-Javadoc)
	 * @see javax.xml.ws.handler.soap.SOAPHandler#getHeaders()
	 */
	public Set<QName> getHeaders() {
		return null;
	}
}

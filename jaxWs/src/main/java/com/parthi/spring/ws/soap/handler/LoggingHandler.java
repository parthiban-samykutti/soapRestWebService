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
 * Intercepts the service request messages to print the SOAP request.
 * 
 * @author parthiban Samykutti
 * @since 31/Aug/2016
 *
 */
public class LoggingHandler implements SOAPHandler<SOAPMessageContext>{
	private static final Logger LOG = Logger.getLogger(LoggingHandler.class);
	/*
	 * (non-Javadoc)
	 * @see javax.xml.ws.handler.Handler#close(javax.xml.ws.handler.MessageContext)
	 */
	public void close(final MessageContext context) {
		
	}
	/*
	 * (non-Javadoc)
	 * @see javax.xml.ws.handler.Handler#handleFault(javax.xml.ws.handler.MessageContext)
	 */
	public boolean handleFault(final SOAPMessageContext messageContext) {
		
		return true;
	}
	/*
	 * (non-Javadoc)
	 * @see javax.xml.ws.handler.Handler#handleMessage(javax.xml.ws.handler.MessageContext)
	 */
	public boolean handleMessage(final SOAPMessageContext messageContext) {
		final SOAPMessage soapMessage = messageContext.getMessage();
		LOG.debug("handleMessage to write SOAP message to output stream. ");
		if(soapMessage != null){
			try {
				boolean isResponse = (Boolean)messageContext.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
				LOG.debug("isResponse: "+isResponse);
				OutputStream outputStream = null;
				File file = null;
				if(isResponse){
					file = new File("..\\logs\\getAccountDetails-soapResponse.xml");
					if(!file.exists()){
						file.createNewFile();
					}
					outputStream = new FileOutputStream(file);
				}else{
					file = new File("..\\logs\\getAccountDetails-soapRequest.xml");
					if(!file.exists()){
						file.createNewFile();
					}
					outputStream = new FileOutputStream(file);
				}
				soapMessage.writeTo(outputStream);
				soapMessage.writeTo(System.out);
				outputStream.close();
			} catch (SOAPException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
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

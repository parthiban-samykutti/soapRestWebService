package com.parthi.spring.ws.soap.handler;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.Set;

import javax.activation.DataHandler;
import javax.xml.namespace.QName;
import javax.xml.soap.AttachmentPart;
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
		boolean isRequest = (Boolean) soapMsgCtx
				.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
		LOG.trace("is Outbound message: " + isRequest);
		final SOAPMessage soapMessage = soapMsgCtx.getMessage();
		
		File outputFile = null;
		if (isRequest) {
			outputFile = new File("target\\logs\\request.xml");
		} else {
			outputFile = new File("target\\logs\\response.xml");
			downloadAttachments(soapMessage);	
		}
		OutputStream outputStream = null;
		if (!outputFile.exists()) {
			try {
				outputFile.createNewFile();
			} catch (IOException e) {
				LOG.error("IOException in handleMessage while writing the soap request/response to file: "+e.fillInStackTrace());
			}
		}
		try {
			outputStream = new FileOutputStream(outputFile);
			soapMessage.writeTo(outputStream);
			soapMessage.saveChanges();
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
	/**
	 * Downloads the attachments from the response SOAP.
	 * 
	 * @param soapMessage
	 */
	@SuppressWarnings("unchecked")
	private void downloadAttachments(final SOAPMessage soapMessage){
		final Iterator<AttachmentPart> attachmentParts = soapMessage.getAttachments();
		AttachmentPart attachmentPart = null;
		DataHandler dataHandler = null;
		OutputStream outputStream = null;
		InputStream inputStream = null;
		String attachmentFileName = null;
		while(attachmentParts.hasNext()){
			attachmentPart = attachmentParts.next();
			if(attachmentPart != null){
				try {
					dataHandler = attachmentPart.getDataHandler();
					LOG.trace("contentId: "+attachmentPart.getContentId());
					if(dataHandler != null){
						LOG.trace("dataHandler.getName(): "+dataHandler.getName());
						LOG.trace("dataHandler.getContentType(): "+dataHandler.getContentType());
						inputStream = dataHandler.getInputStream();
						if (inputStream != null) {
							attachmentFileName = "target\\logs\\" + attachmentPart.getContentId().replace(">", "").replace("<", "");
							outputStream = new FileOutputStream(new File(attachmentFileName));
							byte[] bytes = new byte[1024];
							while ((inputStream.read(bytes)) >= 0) {
								outputStream.write(bytes);
							}
							outputStream.close();
						}
						LOG.trace(attachmentFileName+" has been downloaded.");
					}
				} catch (SOAPException e) {
					LOG.error("SOAPException: "+e.fillInStackTrace());
					e.printStackTrace();
				} catch (IOException e) {
					LOG.error("IOException: "+e.fillInStackTrace());
					e.printStackTrace();
				}finally{
					try {
						if(inputStream != null){
							inputStream.close();
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}	
	}
}
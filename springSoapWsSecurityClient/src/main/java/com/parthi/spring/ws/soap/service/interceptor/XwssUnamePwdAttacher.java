package com.parthi.spring.ws.soap.service.interceptor;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.soap.SOAPMessage;

import org.apache.log4j.Logger;
import org.springframework.core.io.Resource;
import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.client.core.WebServiceMessageCallback;
import org.springframework.ws.soap.saaj.SaajSoapMessage;
import org.springframework.ws.soap.security.xwss.callback.SimplePasswordValidationCallbackHandler;

import com.sun.xml.wss.ProcessingContext;
import com.sun.xml.wss.XWSSProcessor;
import com.sun.xml.wss.XWSSProcessorFactory;

public class XwssUnamePwdAttacher {

	private static final Logger LOG = Logger.getLogger(XwssUnamePwdAttacher.class);
	private final XWSSProcessor processor;
	/**
	 * XwssMessageSigner's constructor to load the policyFile and SimplePasswordValidationCallbackHandler.
	 * 
	 * @param policyFile
	 * @param callbackHandler
	 * @throws Exception
	 */
	public XwssUnamePwdAttacher(final Resource policyFile, final SimplePasswordValidationCallbackHandler callbackHandler)
			throws Exception {

		final InputStream policyInputStream = policyFile.getInputStream();
		final XWSSProcessorFactory factory = XWSSProcessorFactory.newInstance();
		processor = factory.createProcessorForSecurityConfiguration(policyInputStream, callbackHandler);
		policyInputStream.close();
	}
	/**
	 * Creates WebServiceMessageCallback object to build the securedSOAP message.
	 * 
	 * @return WebServiceMessageCallback
	 */
	public WebServiceMessageCallback getCallback() {
		LOG.trace("Invokes XwssUnamePwdAttacher.getCallback.....");
		return new WebServiceMessageCallback() {
			public void doWithMessage(final WebServiceMessage message) throws IOException {

				final SaajSoapMessage origSaajMessage = (SaajSoapMessage) message;
				final SOAPMessage origSoapMessage = origSaajMessage.getSaajMessage();
				final ProcessingContext context = new ProcessingContext();

				try {
					context.setSOAPMessage(origSoapMessage);
					final SOAPMessage securedSoapMessage = processor.secureOutboundMessage(context);
					origSaajMessage.setSaajMessage(securedSoapMessage);
				} catch (final Exception exc) {
					LOG.error("Exception in getCallback.WebServiceMessageCallback.doWithMessage"+exc.fillInStackTrace());
					exc.printStackTrace();
					throw new IOException(exc.getMessage());
				}
			}
		};
	}

}

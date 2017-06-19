package com.parthi.spring.ws.soap.service.interceptor;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.soap.SOAPMessage;

import org.apache.log4j.Logger;
import org.springframework.core.io.Resource;
import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.client.core.WebServiceMessageCallback;
import org.springframework.ws.soap.saaj.SaajSoapMessage;
import org.springframework.ws.soap.security.xwss.callback.KeyStoreCallbackHandler;

import com.sun.xml.wss.ProcessingContext;
import com.sun.xml.wss.XWSSProcessor;
import com.sun.xml.wss.XWSSProcessorFactory;
/**
 * Digitally sign the SOAP request message.
 * 
 * @author Parthiban Samykutti
 * @since 13/Oct/2016
 */
public class XwssMessageSigner {
	private static final Logger LOG = Logger.getLogger(XwssMessageSigner.class);
	private final XWSSProcessor processor;
	/**
	 * XwssMessageSigner's constructor to load the policyFile and keyStore Handler.
	 * 
	 * @param policyFile
	 * @param keystoreHandler
	 * @throws Exception
	 */
	public XwssMessageSigner(final Resource policyFile, final KeyStoreCallbackHandler keystoreHandler)
			throws Exception {

		final InputStream policyInputStream = policyFile.getInputStream();
		final XWSSProcessorFactory factory = XWSSProcessorFactory.newInstance();
		processor = factory.createProcessorForSecurityConfiguration(policyInputStream, keystoreHandler);
		policyInputStream.close();
	}
	/**
	 * Creates WebServiceMessageCallback object to build the secured/signed SOAP message.
	 * 
	 * @return WebServiceMessageCallback
	 */
	public WebServiceMessageCallback getCallback() {
		LOG.trace("Invokes XwssMessageSigner.getCallback.....");
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
package com.parthi.spring.ws.soap.handler;

import java.net.URL;

import javax.activation.DataHandler;

import org.apache.log4j.Logger;
/**
 * DataHandler to attach the file to the Soap Message.
 * 
 * @author Parthiban Samykutti
 * @since 29/Sep/2016
 *
 */
public class AttachmentDataHandler extends DataHandler{
	/**
	 * Loads AttachmentDataHandler with content and its mime type.
	 * 
	 * @param obj
	 * @param mimeType
	 */
	public AttachmentDataHandler(final Object obj, final String mimeType) {
		super(obj, mimeType);
		LOG.trace("AttachmentDataHandler creates with mimeType "+mimeType);
	}
	public AttachmentDataHandler(final URL url) {
		super(url);
		LOG.trace("AttachmentDataHandler creates with URL "+url);
	}

	private static final Logger LOG = Logger
			.getLogger(AttachmentDataHandler.class);
}

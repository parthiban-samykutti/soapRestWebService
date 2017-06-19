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
	private String name;
	/**
	 * Loads AttachmentDataHandler with content and its mime type.
	 * 
	 * @param obj
	 * @param mimeType
	 */
	public AttachmentDataHandler(final Object obj, final String mimeType, final String name) {
		super(obj, mimeType);
		this.name = name;
		LOG.trace("AttachmentDataHandler creates with mimeType "+mimeType);
	}
	public AttachmentDataHandler(final URL url, final String name) {
		super(url);
		this.name = name;
		LOG.trace("AttachmentDataHandler creates with URL "+url);
	}
	/*
	 * (non-Javadoc)
	 * @see javax.activation.DataHandler#getName()
	 */
	public String getName(){
		return name;
	}
	private static final Logger LOG = Logger
			.getLogger(AttachmentDataHandler.class);
}

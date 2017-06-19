package com.parthi.spring.ws.rest.auth;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;

/**
 * This filter performs authentication, in order to populate subject info
 * for authorization decisions.
 * 
 * @author Parthiban Samykutti
 * @since 25/Feb/2017
 *
 */
public class PreAuthFilter extends AbstractPreAuthenticatedProcessingFilter {
	private static final Logger LOG = Logger.getLogger(PreAuthFilter.class);
	/*
	 * (non-Javadoc)
	 * @see org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter#getPreAuthenticatedCredentials(javax.servlet.http.HttpServletRequest)
	 */
	@Override
	protected Map<String, String> getPreAuthenticatedCredentials(final HttpServletRequest request) {
		return getUserId(request);
	}
	/*
	 * (non-Javadoc)
	 * @see org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter#getPreAuthenticatedPrincipal(javax.servlet.http.HttpServletRequest)
	 */
	@Override
	protected String getPreAuthenticatedPrincipal(final HttpServletRequest request) {
		return request.getHeader("userName");
	}
	/**
	 * Extracts the credential from the request object.
	 * @param request
	 * @return credentialMap - Map<String, String>
	 */
	private Map<String, String> getUserId(final HttpServletRequest request) {
		final String userName = request.getHeader("userName");
		final String password = request.getHeader("password");
		LOG.debug("PreAuthFilter.userName: "+userName);
		final Map<String, String> credentials = new HashMap<String, String>();
		credentials.put("password", password);
		credentials.put("userName", userName);
		return credentials;
	}
}

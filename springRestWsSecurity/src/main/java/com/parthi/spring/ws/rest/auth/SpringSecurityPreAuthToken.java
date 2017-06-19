package com.parthi.spring.ws.rest.auth;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;

/**
 * An authentication token which is authenticated by default.
 * 
 * @author 
 *
 */
public class SpringSecurityPreAuthToken extends PreAuthenticatedAuthenticationToken {

	/**
	 * NTPreAuthToken serialVersionUID
	 */
	private static final long serialVersionUID = 6599846949198747537L;

	/**
	 * This constructor will create an object for use in an authentication request,
	 * wherein isAuthenticated() will return false by default.
	 * @param aPrincipal
	 * @param aCredentials
	 */
	public SpringSecurityPreAuthToken(Object aPrincipal, Object aCredentials) {
		super(aPrincipal, aCredentials);
	}

	/**
	 * Creates an authentication token, which is marked as authenticated
	 * 
	 * @param aPrincipal
	 * @param aCredentials
	 * @param anAuthorities
	 */
	public SpringSecurityPreAuthToken(Object aPrincipal, Object aCredentials,
			Collection<? extends GrantedAuthority> anAuthorities) {
		super(aPrincipal, aCredentials, anAuthorities);
	}


}

package com.parthi.spring.ws.rest.auth;

import org.apache.log4j.Logger;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;

/**
 * This class retrieves user details from the UserDetailsService, 
 * based on the user info from the NTPreAuthFilter.
 * 
 * @author Parthiban Samykutti
 * @since 25/Feb/2017
 *
 */
public class SpringSecurityAuthenticationProvider implements AuthenticationProvider{
	private static final Logger LOG = Logger.getLogger(SpringSecurityAuthenticationProvider.class);
	
	private UserDetailsService userDetailsService;

	public void setUserDetailsService(final UserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}
	/*
	 * (non-Javadoc)
	 * @see org.springframework.security.authentication.AuthenticationProvider#authenticate(org.springframework.security.core.Authentication)
	 */
	public Authentication authenticate(final Authentication authentication)
			throws AuthenticationException {
		LOG.debug("Authenticating: "+authentication.getName());
		
		final UserDetails user = userDetailsService.loadUserByUsername(authentication.getName());
		//TODO: write logic to authenticate the credential. 
		final PreAuthenticatedAuthenticationToken result = 
			new SpringSecurityPreAuthToken(user, authentication.getCredentials(), user.getAuthorities());
		LOG.debug("SpringSecurityAuthenticationProvider.PreAuthenticatedAuthenticationToken: "+result);
		return result;
	}
	/*
	 * (non-Javadoc)
	 * @see org.springframework.security.authentication.AuthenticationProvider#supports(java.lang.Class)
	 */
	public boolean supports(final Class<?> authentication) {
		return PreAuthenticatedAuthenticationToken.class.isAssignableFrom(authentication);
	}

}

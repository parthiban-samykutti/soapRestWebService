package com.parthi.spring.ws.rest.auth;

import org.apache.log4j.Logger;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Loads data for the pre-authenticated user.
 * 
 * @author Parthiban Samykutti
 * @since 25/Feb/2017
 *
 */
public class SpringSecurityUserDetailsService implements UserDetailsService {
	private static final Logger LOG = Logger.getLogger(PreAuthFilter.class);
	/*
	 * (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
	 */
	public UserDetails loadUserByUsername(final String userName)
			throws UsernameNotFoundException {
		LOG.debug("Loading user by username: "+userName);
		return new SpringSecurityUserDetails(userName);
	}

}

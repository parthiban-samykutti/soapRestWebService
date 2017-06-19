package com.parthi.spring.ws.rest.auth;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Implementation of the Spring Security UserDetails interface.
 * 
 * @see org.springframework.security.core.userdetails.UserDetails
 * @author Parthiban Samykutti
 * @since 25/Feb/2017
 *
 */
public class SpringSecurityUserDetails implements UserDetails {

	/**
	 * NTUserDetails serialVersionUID
	 */
	private static final long serialVersionUID = 3266504880772380090L;
	private String userName;
	private String password;

	public SpringSecurityUserDetails(String userName) {
		this.userName = userName;
	}

	/**
	 * GrantedAuthority should not be used. Providing granted authorities to
	 * Spring Security breaks the model of having the PDP perform policy
	 * evaluations.
	 */

	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new GrantedAuthority() {

			private static final long serialVersionUID = -4720055840635813340L;

			@Override
			public String getAuthority() {
				return "AUTH_USER";
			}

		});
		return authorities;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.security.core.userdetails.UserDetails#getPassword()
	 */
	public String getPassword() {
		return password;
	}
	/*
	 * (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetails#getUsername()
	 */
	public String getUsername() {
		return userName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.core.userdetails.UserDetails#
	 * isAccountNonExpired()
	 */
	public boolean isAccountNonExpired() {
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.core.userdetails.UserDetails#
	 * isAccountNonLocked()
	 */
	public boolean isAccountNonLocked() {
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.core.userdetails.UserDetails#
	 * isCredentialsNonExpired()
	 */
	public boolean isCredentialsNonExpired() {
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.security.core.userdetails.UserDetails#isEnabled()
	 */
	public boolean isEnabled() {
		return true;
	}

}

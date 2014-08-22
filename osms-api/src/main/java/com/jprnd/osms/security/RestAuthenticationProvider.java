package com.jprnd.osms.security;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.authentication.dao.SaltSource;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.Assert;

public class RestAuthenticationProvider extends
		AbstractUserDetailsAuthenticationProvider implements
		AuthenticationProvider {

	private PasswordEncoder passwordEncoder;
	private SaltSource saltSource;
	private UserDetailsService userDetailsService;
	private boolean includeDetailsObject;

	public RestAuthenticationProvider() {
		//this.passwordEncoder = new BCryptPasswordEncoder();

		this.includeDetailsObject = true;
	}

	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails,
			UsernamePasswordAuthenticationToken authentication)
			throws AuthenticationException {
		Object salt = null;
		System.out.println("additionalAuthenticationChecks");
		if (this.saltSource != null) {
			salt = this.saltSource.getSalt(userDetails);
		}

		if (authentication.getCredentials() == null) {
			this.logger.debug("Authentication failed: no credentials provided");

			throw new BadCredentialsException(this.messages.getMessage(
					"AbstractUserDetailsAuthenticationProvider.badCredentials",
					"Bad credentials"));
		}

		String presentedPassword = authentication.getCredentials().toString();

		if (!(this.passwordEncoder.matches(userDetails.getPassword(),
				presentedPassword))) {
			this.logger
					.debug("Authentication failed: password does not match stored value");

			throw new BadCredentialsException(this.messages.getMessage(
					"AbstractUserDetailsAuthenticationProvider.badCredentials",
					"Bad credentials"));
		}
	}

	@Override
	protected void doAfterPropertiesSet() throws Exception {
		Assert.notNull(this.userDetailsService,
				"A UserDetailsService must be set");
	}

	@Override
	protected final UserDetails retrieveUser(String username,
			UsernamePasswordAuthenticationToken authentication)
			throws AuthenticationException {
		System.out.println("retrieveUser");
		UserDetails loadedUser;
		try {
			loadedUser = getUserDetailsService().loadUserByUsername(username);
		} catch (UsernameNotFoundException repositoryProblem) {
			throw new AuthenticationServiceException(
					repositoryProblem.getMessage(), repositoryProblem);
		}

		if (loadedUser == null) {
			throw new AuthenticationServiceException(
					"UserDetailsService returned null, which is an interface contract violation");
		}

		return loadedUser;
	}

	public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}

	protected PasswordEncoder getPasswordEncoder() {
		return this.passwordEncoder;
	}

	public void setSaltSource(SaltSource saltSource) {
		this.saltSource = saltSource;
	}

	protected SaltSource getSaltSource() {
		return this.saltSource;
	}

	public void setUserDetailsService(UserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}

	protected UserDetailsService getUserDetailsService() {
		return this.userDetailsService;
	}

	protected boolean isIncludeDetailsObject() {
		return this.includeDetailsObject;
	}

}

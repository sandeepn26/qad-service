package com.qad.auth.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.qad.delegate.IAuthDelegate;
import com.qad.delegate.IUserDelegate;
import com.qad.model.PrincipalUser;

@Component
@WebFilter(description = "authFilter", urlPatterns = { "/users" }, asyncSupported = true)
public class AuthFilter extends OncePerRequestFilter {

	private static final Logger LOGGER = LogManager.getLogger(AuthFilter.class);

	@Autowired
	IAuthDelegate authDelegate;

	@Autowired
	private IUserDelegate userDelegate;

	protected static final String BEARER = "Bearer ";
	protected static final String AUTH_HEADER = "Authorization";

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {
		final String requestTokenHeader = request.getHeader(AUTH_HEADER);
		LOGGER.info("Checking token");
		if (requestTokenHeader != null) {
			String token = StringUtils.substringAfter(requestTokenHeader, BEARER);
			authDelegate.getUsernameFromToken(token).ifPresent(u -> {
				LOGGER.info("Auth Filter !!!!!!!!!!!!!!!! {} {}", token, u);
				PrincipalUser principal = userDelegate.getPrincipalForToken(u, token);
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
						principal, null, principal.getAuthorities());
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			});
		}

		chain.doFilter(request, response);
	}

}

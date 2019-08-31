package com.qad.auth.intercepters;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.qad.auth.config.AuthUtils;
import com.qad.delegate.IAuthDelegate;
import com.qad.delegate.IUserDelegate;
import com.qad.model.PrincipalUser;

@Service
public class AuthIntercepter extends HandlerInterceptorAdapter {

	private static final Logger LOGGER = LogManager.getLogger(AuthIntercepter.class);

	@Autowired
	IAuthDelegate authDelegate;

	@Autowired
	private IUserDelegate userDelegate;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		LOGGER.info("Checking auth for {}", request.getRequestURL().toString());

		String token = AuthUtils.getRequestAuthToken(request);

		if (StringUtils.isBlank(token)) {
			AuthUtils.handleUnauthorized(response);
			return false;
		}

		Optional<String> usernameOpt = authDelegate.getUsernameFromToken(token);
		if (usernameOpt.isPresent()) {
			PrincipalUser principal = userDelegate.getPrincipalForToken(usernameOpt.get(), token);

			if (principal != null) {
				return true;
			}
		}

		AuthUtils.handleUnauthorized(response);
		return false;
	}

}

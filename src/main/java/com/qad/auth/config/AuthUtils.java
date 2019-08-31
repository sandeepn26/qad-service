package com.qad.auth.config;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qad.model.PrincipalUser;
import com.qad.model.QADResponse;

public class AuthUtils {

	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

	protected static final String BEARER = "Bearer ";
	protected static final String AUTH_HEADER = "Authorization";

	public static Long getCurrentUserId() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication.getPrincipal() == null)
			return -1L;

		PrincipalUser principalUser = (PrincipalUser) authentication.getPrincipal();
		return principalUser.getUserId();
	}

	public static String getString(Object o) {
		try {
			return OBJECT_MAPPER.writeValueAsString(o);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

	public static void handleUnauthorized(HttpServletResponse response) throws IOException {
		response.setStatus(HttpStatus.UNAUTHORIZED.value());
		response.setContentType(MediaType.APPLICATION_JSON_VALUE);
		response.getOutputStream().print(getString(QADResponse.UNAUTHORIZED));
	}

	public static String getRequestAuthToken(HttpServletRequest request) {
		String token = null;
		final String requestTokenHeader = request.getHeader(AUTH_HEADER);
		if (requestTokenHeader != null) {
			token = StringUtils.substringAfter(requestTokenHeader, BEARER);
		}

		return token;
	}

}

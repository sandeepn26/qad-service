package com.globallink.ctm.rest;

import java.io.IOException;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResponseErrorHandler;

import com.globallink.ctm.errorhandlers.CTMError;
import com.globallink.ctm.errorhandlers.CTMErrorBuilder;
import com.globallink.ctm.errorhandlers.CTMException;

@Service
@ComponentScan("com.globallink")
public class CLSReponseErrorHandler implements ResponseErrorHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(CLSReponseErrorHandler.class);

	@Override
	public boolean hasError(ClientHttpResponse httpResponse) throws IOException {

		return (httpResponse.getStatusCode().series() == HttpStatus.Series.CLIENT_ERROR
				|| httpResponse.getStatusCode().series() == HttpStatus.Series.SERVER_ERROR);
	}

	@Override
	public void handleError(ClientHttpResponse httpResponse) throws IOException {
		LOGGER.warn("Failing health due to CLS response error");
		CTMErrorBuilder builder = new CTMErrorBuilder().withErrorCode("CLS_REPONSE_ERROR")
				.withErrorDetails(httpResponse.getStatusText())
				.withCtmStatusCode(Optional.of(CTMError.CLS_REPONSE_ERROR))
				.withHttpStatusCode(Optional.of(httpResponse.getStatusCode().toString()));

		throw new CTMException(builder.build());
	}

}
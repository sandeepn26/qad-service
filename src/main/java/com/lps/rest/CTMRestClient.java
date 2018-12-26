package com.lps.rest;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.lps.errorhandlers.CTMException;
import com.lps.model.Client;
import com.lps.model.Clients;
import com.lps.model.Snapshots;
import com.lps.model.Token;
import com.lps.model.trade.Trades;

@Component
@Scope("singleton")
@ComponentScan("com.lps")
public class CTMRestClient {

	private static final Logger LOGGER = LoggerFactory.getLogger(CTMRestClient.class);

	private static final String BEARER = "Bearer %s";

	private static final String AUTHORIZATION = "authorization";

	@Autowired
	private CTMConfiguration ctmConfiguration;

	private final RestTemplate restTemplate;

	private String tokenUrl;

	private String allClientsUrl;

	private String clientUrl;

	private String snapshotUrl;

	private String allTradesUrl;

	private final HttpHeaders tokenHeaders;

	public CTMRestClient() {
		restTemplate = new RestTemplate();
		tokenHeaders = new HttpHeaders();
		tokenHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		tokenHeaders.setCacheControl("no-cache");
	}

	public Token getToken() throws CTMException {
		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(ctmConfiguration.getCtmCredentials(),
				tokenHeaders);
		Token token = this.restTemplate.postForEntity(tokenUrl.toString(), request, Token.class).getBody();
		return token;
	}

	private HttpEntity<String> getRequestEntity() {
		Token token = getToken();

		HttpHeaders authHeaders = new HttpHeaders();
		authHeaders.setCacheControl("no-cache");

		if (token.getAccessToken() != null) {
			String bearerToken = String.format(BEARER, token.getAccessToken());
			authHeaders.add(AUTHORIZATION, bearerToken);
			LOGGER.info("Bearer token updated");
		}

		HttpEntity<String> request = new HttpEntity<>(authHeaders);
		return request;
	}

	public Clients getAllClients() {
		LOGGER.info("Requesting get Clients");
		ResponseEntity<Clients> response = restTemplate.exchange(this.allClientsUrl, HttpMethod.GET, getRequestEntity(),
				Clients.class);
		return response.getBody();
	}

	public Client getClient(String clientId) {
		LOGGER.info("Requesting get Client for id {}", clientId);
		ResponseEntity<Client> response = restTemplate.exchange(String.format(this.clientUrl, clientId), HttpMethod.GET,
				getRequestEntity(), Client.class);
		return response.getBody();
	}

	public Trades getAllTrades(Map<String, String> parameters) {
		LOGGER.info("Requesting get All trades with {}", parameters.values());
		ResponseEntity<Trades> response = restTemplate.exchange(getUrlWithParams(this.allTradesUrl, parameters),
				HttpMethod.GET, getRequestEntity(), Trades.class);
		return response.getBody();
	}

	public Snapshots getSnapshot(Map<String, String> parameters) {
		LOGGER.info("Requesting trade snapshots with parameters {}", parameters.values());
		ResponseEntity<Snapshots> response = restTemplate.exchange(this.snapshotUrl, HttpMethod.GET, getRequestEntity(),
				Snapshots.class);
		return response.getBody();
	}

	@PostConstruct
	public void initRestClient() {
		LOGGER.info("Initializing urls in the rest client");
		this.tokenUrl = ctmConfiguration.getTokenUrl();
		this.allClientsUrl = ctmConfiguration.getAllClientsUrl();
		this.clientUrl = ctmConfiguration.getClientUrl();
		this.snapshotUrl = ctmConfiguration.getSnapshotUrl();
		this.allTradesUrl = ctmConfiguration.getAllTradesUrl();
		restTemplate.setRequestFactory(
				getClientHttpRequestFactory(ctmConfiguration.getSsProxyHost(), ctmConfiguration.getSsProxyPort()));
		restTemplate.setErrorHandler(new CLSReponseErrorHandler());
	}

	private static String getUrlWithParams(String url, Map<String, String> parameters) {
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url);
		parameters.forEach((k, v) -> builder.queryParam(k, v));

		return builder.toUriString();
	}

	private static ClientHttpRequestFactory getClientHttpRequestFactory(String host, int port) {
		SimpleClientHttpRequestFactory clientHttpRequestFactory = new SimpleClientHttpRequestFactory();
		Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(host, port));
		clientHttpRequestFactory.setProxy(proxy);
		clientHttpRequestFactory.setConnectTimeout(5000);

		return clientHttpRequestFactory;
	}
}

package com.lps.rest;

import java.net.MalformedURLException;
import java.net.URL;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@Configuration
@EnableConfigurationProperties
public class CTMConfiguration {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CTMConfiguration.class);
	
	@Value( "${spring.profiles.active}" )
	private String environment;
	
	@Value( "${ctm.base.url}" )
	private String baseUrl;
	
	@Value( "${ctm.token.endpoint}" )
	private String tokenEndPoint;
	
	@Value( "${ctm.allclients.endpoint}" )
	private String allClientsEndPoint;
	
	@Value( "${ctm.alltrades.endpoint}" )
	private String allTradesEndPoint;
	
	@Value( "${ctm.client.endpoint}" )
	private String clientEndPoint;
	
	@Value( "${ctm.snapshot.endpoint}" )
	private String snapshotEndPoint;
	
	@Value( "${ctm.username}" )
	private String apiUsername;
	
	@Value( "${ctm.password}" )
	private String apiPassword;
	
	@Value( "${ss.proxy.host}" )
	private String ssProxyHost;
	
	@Value( "${ss.proxy.port}" )
	private int ssProxyPort;
	
	private String tokenUrl;
	
	private String allClientsUrl;
	
	private String clientUrl;
	
	private String snapshotUrl;
	
	private String allTradesUrl;
	
	private MultiValueMap<String, String> ctmCredentials;
	
	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	public String getBaseUrl() {
		return baseUrl;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	public String getTokenEndPoint() {
		return tokenEndPoint;
	}

	public void setTokenEndPoint(String tokenEndPoint) {
		this.tokenEndPoint = tokenEndPoint;
	}

	public String getAllClientsEndPoint() {
		return allClientsEndPoint;
	}

	public void setAllClientsEndPoint(String allClientsEndPoint) {
		this.allClientsEndPoint = allClientsEndPoint;
	}

	public String getAllTradesEndPoint() {
		return allTradesEndPoint;
	}

	public void setAllTradesEndPoint(String allTradesEndPoint) {
		this.allTradesEndPoint = allTradesEndPoint;
	}

	public String getClientEndPoint() {
		return clientEndPoint;
	}

	public void setClientEndPoint(String clientEndPoint) {
		this.clientEndPoint = clientEndPoint;
	}

	public String getSnapshotEndPoint() {
		return snapshotEndPoint;
	}

	public void setSnapshotEndPoint(String snapshotEndPoint) {
		this.snapshotEndPoint = snapshotEndPoint;
	}
	
	public String getTokenUrl() {
		return this.tokenUrl;
	}

	public String getAllClientsUrl() {
		return this.allClientsUrl;
	}

	public String getClientUrl() {
		return this.clientUrl;
	}

	public String getSnapshotUrl() {
		return this.snapshotUrl;
	}

	public String getAllTradesUrl() {
		return allTradesUrl;
	}

	public String getApiUsername() {
		return apiUsername;
	}

	public void setApiUsername(String apiUsername) {
		this.apiUsername = apiUsername;
	}

	public String getApiPassword() {
		return apiPassword;
	}

	public void setApiPassword(String apiPassword) {
		this.apiPassword = apiPassword;
	}
	
	public MultiValueMap<String, String> getCtmCredentials() {
		return this.ctmCredentials;
	}

	public String getSsProxyHost() {
		return ssProxyHost;
	}

	public void setSsProxyHost(String ssProxyHost) {
		this.ssProxyHost = ssProxyHost;
	}

	public int getSsProxyPort() {
		return ssProxyPort;
	}

	public void setSsProxyPort(int ssProxyPort) {
		this.ssProxyPort = ssProxyPort;
	}

	@PostConstruct
	public void initializeAllurls() throws MalformedURLException {
		LOGGER.info("Initializing configuration");
		
		URL baseUrl = new URL(getBaseUrl());
		LOGGER.info(String.format("Base URL %s", this.baseUrl));
		
		this.tokenUrl = new URL(baseUrl, getTokenEndPoint()).toString();
		LOGGER.info(String.format("Get Token URL %s", this.tokenUrl));
		
		this.allClientsUrl = new URL(baseUrl, getAllClientsEndPoint()).toString();
		LOGGER.info(String.format("Get All Clients URL %s", this.allClientsUrl));
		
		this.clientUrl = new URL(baseUrl, getClientEndPoint()).toString();
		LOGGER.info(String.format("Get Client URL %s", this.clientUrl));
		
		this.allTradesUrl = new URL(baseUrl, getAllTradesEndPoint()).toString();
		LOGGER.info(String.format("Get All Trades URL %s", this.allTradesUrl));
		
		this.snapshotUrl = new URL(baseUrl, getSnapshotEndPoint()).toString();
		LOGGER.info(String.format("Get Snapshot URL %s", this.snapshotUrl));
		
		ctmCredentials = new LinkedMultiValueMap<>();
		ctmCredentials.add("username", getApiUsername());
		
		// TODO: This password has to be extracted from a secure store
		ctmCredentials.add("password", getApiPassword());
	}

}

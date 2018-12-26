package com.lps.model;

import java.util.List;

public class Clients extends CLSResponse {
	
	private List<Client> clients;

	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

}

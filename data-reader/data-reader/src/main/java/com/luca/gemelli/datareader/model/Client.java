package com.luca.gemelli.datareader.model;

public class Client {

	private String clientId;

	private String cnpj;

	private String clientName;

	private String area;

	public static synchronized Client create() {
		return new Client();
	}

	public Client withClientId(final String clientId) {
		this.clientId = clientId;
		return this;
	}

	public Client withCnpj(final String cnpj) {
		this.cnpj = cnpj;
		return this;
	}

	public Client withClientName(final String clientName) {
		this.clientName = clientName;
		return this;
	}

	public Client withArea(final String area) {
		this.area = area;
		return this;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

}

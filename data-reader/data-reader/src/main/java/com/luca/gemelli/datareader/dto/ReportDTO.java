package com.luca.gemelli.datareader.dto;

import java.util.List;

public class ReportDTO {

	private List<String> idSale;

	private int client;

	private int seller;

	private List<String> worstSeller;

	public static synchronized ReportDTO create() {
		return new ReportDTO();
	}

	public ReportDTO withId(final List<String> idSale) {
		this.idSale = idSale;
		return this;
	}

	public ReportDTO withClient(final int client) {
		this.client = client;
		return this;
	}

	public ReportDTO withSeller(final int seller) {
		this.seller = seller;
		return this;
	}

	public ReportDTO withWorstSeller(final List<String> worstSeller) {
		this.worstSeller = worstSeller;
		return this;
	}

	public List<String> getIdSale() {
		return idSale;
	}

	public void setIdSale(List<String> idSale) {
		this.idSale = idSale;
	}

	public int getClient() {
		return client;
	}

	public void setClient(int client) {
		this.client = client;
	}

	public int getSeller() {
		return seller;
	}

	public void setSeller(int seller) {
		this.seller = seller;
	}

	public List<String> getWorstSeller() {
		return worstSeller;
	}

	public void setWorstSeller(List<String> worstSeller) {
		this.worstSeller = worstSeller;
	}
}

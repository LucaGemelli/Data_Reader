package com.luca.gemelli.datareader.model;

public class Seller {

	private String sellerId;

	private String cpf;

	private String sellerName;

	private Double salary;

	public static synchronized Seller create() {
		return new Seller();
	}

	public Seller withSellerId(final String sellerId) {
		this.sellerId = sellerId;
		return this;
	}

	public Seller withCpf(final String cpf) {
		this.cpf = cpf;
		return this;
	}

	public Seller withSellerName(final String sellerName) {
		this.sellerName = sellerName;
		return this;
	}

	public Seller withSalary(final Double salary) {
		this.salary = salary;
		return this;
	}

	public String getSellerId() {
		return sellerId;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

}

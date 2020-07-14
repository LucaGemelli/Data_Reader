package com.luca.gemelli.datareader.model;

import lombok.Data;

@Data
public class Customer {

    private String cnpj;

    private String name;

    private String businessArea;

    public static synchronized Customer create() {
        return new Customer();
	}

	public Customer withCnpj(final String cnpj) {
        this.cnpj = cnpj;
        return this;
	}

	public Customer withName(final String name) {
        this.name = name;
        return this;
	}

	public Customer withBusinessArea(final String businessArea) {
        this.businessArea = businessArea;
        return this;
	}
}

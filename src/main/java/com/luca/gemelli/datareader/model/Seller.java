package com.luca.gemelli.datareader.model;

import lombok.Data;

@Data
public class Seller {

    private String cpf;

    private String name;

    private double salary;

    private double sales;

    public void addSale(double sale) {
        this.sales += sale;
    }

    public static synchronized Seller create() {
        return new Seller();
	}

    public Seller withCpf(final String cpf) {
        this.cpf = cpf;
        return this;
    }

    public Seller withName(final String name) {
        this.name = name;
        return this;
	}

    public Seller withSalary(final double salary) {
        this.salary = salary;
        return this;
	}

    public Seller withSales(final double sales) {
        this.sales = sales;
        return this;
	}
}

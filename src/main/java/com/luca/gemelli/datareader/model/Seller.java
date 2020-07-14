package com.luca.gemelli.datareader.model;

import lombok.Data;

@Data
public class Seller {

    private String cpf;

    private String name;

    private double salary;

    private double sales;

    public void addSale(double sale) {
        sales += sale;
    }

}

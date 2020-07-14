package com.luca.gemelli.datareader.model;

import java.util.List;

import lombok.Data;

@Data
public class Sale {

    private int id;

    private Salesman salesman;

    private List<Item> items;

    public double getTotal() {
        return items.stream().mapToDouble(item -> item.getPrice() * item.getQuantity()).sum();
    }

}

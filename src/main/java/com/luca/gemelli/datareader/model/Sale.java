package com.luca.gemelli.datareader.model;

import java.util.List;

import lombok.Data;

@Data
public class Sale {

    private int id;

    private Seller seller;

    private List<Item> items;

    public double getTotal() {
        return items.stream().mapToDouble(item -> item.getPrice() * item.getQuantity()).sum();
    }

    public static synchronized Sale create() {
        return new Sale();
	}

    public Sale withId(final int id) {
        this.id = id;
        return this;
    }

    public Sale withSeller(final Seller seller) {
        this.seller = seller;
        return this;
	}

    public Sale withItems(final List<Item> items) {
        this.items = items;
        return this;
	}
}

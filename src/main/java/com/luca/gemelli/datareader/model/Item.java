package com.luca.gemelli.datareader.model;

import lombok.Data;

@Data
public class Item {

    private int id;

    private int quantity;

    private double price;

    public static synchronized Item create() {
        return new Item();
	}

	public Item withId(final int id) {
        this.id = id;
        return this;
	}

	public Item withQuantity(final int quantity) {
        this.quantity = quantity;
        return this;
	}

	public Item withPrice(final double price) {
        this.price = price;
        return this;
	}
}

package com.luca.gemelli.datareader.model;

public class Item {

	private String id;

	private float quantity;

	private float price;

	public static synchronized Item create() {
		return new Item();
	}

	public Item withId(final String id) {
		this.id = id;
		return this;
	}

	public Item withQuantity(final float quantity) {
		this.quantity = quantity;
		return this;
	}

	public Item withPrice(final float price) {
		this.price = price;
		return this;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public float getQuantity() {
		return quantity;
	}

	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

}

package com.luca.gemelli.datareader.model;

import java.util.List;

import com.luca.gemelli.datareader.service.SalesService;

public class Sales {

	private String saleId;

	private List<Item> items;

	private String sellerName;

	public static synchronized Sales create() {
		return new Sales();
	}

	public Sales withSaleId(final String saleId) {
		this.saleId = saleId;
		return this;
	}

	public Sales withItems(final String insertItems) {
		this.items = new SalesService().setItems(insertItems);
		return this;
	}

	public Sales withSellerName(final String sellerName) {
		this.sellerName = sellerName;
		return this;
	}

	public String getSaleId() {
		return saleId;
	}

	public void setSaleId(String saleId) {
		this.saleId = saleId;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(String insertItems) {
		this.items = new SalesService().setItems(insertItems);
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}
}


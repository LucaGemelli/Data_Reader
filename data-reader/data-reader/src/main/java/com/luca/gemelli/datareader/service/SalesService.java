package com.luca.gemelli.datareader.service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.luca.gemelli.datareader.model.Item;

public class SalesService {

	private final static String regex = "(\\w{1,9}-\\d{1,9}-\\d{1,9}[.]{0,1}\\d{0,4})";

	public List<Item> setItems(final String insertItems) {
		final Matcher matcher = Pattern.compile("[\\[]".concat(regex)
													   .concat("[,]")
													   .concat(regex)
													   .concat("[,]")
													   .concat(regex)
													   .concat("[\\]]"))
									   .matcher(insertItems);
		matcher.find();

		List<Item> items = new ArrayList<>();

		for (int idx = 1; idx <= matcher.groupCount(); idx++) {

			final String[] item = matcher.group(idx).split("-");
			final Item insert = new Item();
			insert.setId(item[0]);
			insert.setQuantity(Float.parseFloat(item[1]));
			insert.setPrice(Float.parseFloat(item[2]));

			items.add(insert);
		}

		return items;
	}
}

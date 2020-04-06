package com.luca.gemelli.datareader;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.luca.gemelli.datareader.model.Item;
import com.luca.gemelli.datareader.model.Sales;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DataReaderTeste {

	@Test
	public void populating() {
		List<Item> items = new ArrayList<>();

		Sales sale = new Sales();
		sale.setItems("[1-12-100,2-32-2.50,3-40-3.10]");

		Item item001 = new Item();
		item001.setId("1");
		item001.setQuantity(Float.parseFloat("12"));
		item001.setPrice(Float.parseFloat("100"));
		items.add(item001);

		Assert.assertEquals(sale.getItems().get(0).getId(), items.get(0).getId());
		Assert.assertEquals(Float.compare(sale.getItems().get(0).getPrice(), items.get(0).getPrice()), 0);
		Assert.assertEquals(Float.compare(sale.getItems().get(0).getQuantity(), items.get(0).getQuantity()), 0);

		Item item002 = new Item();
		item002.setId("2");
		item002.setQuantity(Float.parseFloat("32"));
		item002.setPrice(Float.parseFloat("2.50"));
		items.add(item002);

		Assert.assertEquals(sale.getItems().get(1).getId(), items.get(1).getId());
		Assert.assertEquals(Float.compare(sale.getItems().get(1).getPrice(), items.get(1).getPrice()), 0);
		Assert.assertEquals(Float.compare(sale.getItems().get(1).getQuantity(), items.get(1).getQuantity()), 0);

		Item item003 = new Item();
		item003.setId("3");
		item003.setQuantity(Float.parseFloat("40"));
		item003.setPrice(Float.parseFloat("3.10"));
		items.add(item003);

		Assert.assertEquals(sale.getItems().get(2).getId(), items.get(2).getId());
		Assert.assertEquals(Float.compare(sale.getItems().get(2).getPrice(), items.get(2).getPrice()), 0);
		Assert.assertEquals(Float.compare(sale.getItems().get(2).getQuantity(), items.get(2).getQuantity()), 0);
	}
}

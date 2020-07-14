package com.luca.gemelli.datareader.layout;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.luca.gemelli.datareader.model.Item;
import com.luca.gemelli.datareader.model.Sale;
import com.luca.gemelli.datareader.model.Salesman;

public class SaleLayout extends AbstractLayout<Sale> {

    public static final String LAYOUT_CODE = "003";

    public static final int FIELD_CODE = 0;
    public static final int FIELD_SALE_ID = 1;
    public static final int FIELD_ITEMS = 2;
    public static final int FIELD_SALESMAN_NAME = 3;

    public static final int FIELD_ITEM_ID = 0;
    public static final int FIELD_ITEM_QUANTITY = 1;
    public static final int FIELD_ITEM_PRICE = 2;

    private Map<String, Salesman> salesmanMap;

    public void setSalesmanMap(Map<String, Salesman> salesmanMap) {
        this.salesmanMap = salesmanMap;
    }

    @Override
    public Sale read(String line) {
        String[] fields = line.split(FIELD_DELIMITER);

        Salesman salesman = salesmanMap.get(fields[FIELD_SALESMAN_NAME]);

        String rawItems = fields[FIELD_ITEMS].substring(1, fields[FIELD_ITEMS].length() - 1);

        List<Item> items = Arrays.asList(rawItems.split(","))
            .stream()
            .map(rawItem -> {
                String[] itemData = rawItem.split("-");

                Item item = new Item();
                item.setId(Integer.parseInt(itemData[FIELD_ITEM_ID]));
                item.setQuantity(Integer.parseInt(itemData[FIELD_ITEM_QUANTITY]));
                item.setPrice(Double.parseDouble(itemData[FIELD_ITEM_PRICE]));
                return item;
            })
            .collect(Collectors.toList());

        Sale sale = new Sale();
        sale.setId(Integer.parseInt(fields[FIELD_SALE_ID]));
        sale.setItems(items);
        sale.setSalesman(salesman);

        return sale;
    }

}

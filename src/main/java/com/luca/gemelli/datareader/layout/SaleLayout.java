package com.luca.gemelli.datareader.layout;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.luca.gemelli.datareader.model.Item;
import com.luca.gemelli.datareader.model.Sale;
import com.luca.gemelli.datareader.model.Seller;

public class SaleLayout extends AbstractLayout<Sale> {

    public static final String LAYOUT_CODE = "003";

    public static final int CODE_SALE_ID = 1;
    public static final int CODE_ITEMS = 2;
    public static final int CODE_SELLER_NAME = 3;

    public static final int CODE_ITEM_ID = 0;
    public static final int CODE_ITEM_QUANTITY = 1;
    public static final int CODE_ITEM_PRICE = 2;

    private Map<String, Seller> sellerMap;

    public void setSellerMap(Map<String, Seller> sellerMap) {
        this.sellerMap = sellerMap;
    }

    @Override
    public Sale read(String line) {
        final String[] fields = line.split(SEPARATOR);

        final Seller seller = sellerMap.get(fields[CODE_SELLER_NAME]);

        final String rawItems = fields[CODE_ITEMS].substring(1, fields[CODE_ITEMS].length() - 1);

        List<Item> items = Arrays.asList(rawItems.split(","))
            .stream()
            .map(rawItem -> {
                String[] itemData = rawItem.split("-");

                Item item = new Item();
                item.setId(Integer.parseInt(itemData[CODE_ITEM_ID]));
                item.setQuantity(Integer.parseInt(itemData[CODE_ITEM_QUANTITY]));
                item.setPrice(Double.parseDouble(itemData[CODE_ITEM_PRICE]));
                return item;
            })
            .collect(Collectors.toList());

        final Sale sale = new Sale();
        sale.setId(Integer.parseInt(fields[CODE_SALE_ID]));
        sale.setItems(items);
        sale.setSeller(seller);

        return sale;
    }

}

package com.luca.gemelli.datareader.layout;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.luca.gemelli.datareader.model.Sale;
import com.luca.gemelli.datareader.model.Seller;


public class SaleLayoutTest {

    @Mock
    private Map<String, Seller> sellerMap;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSale() {
        SaleLayout layout = new SaleLayout();
        layout.setSellerMap(sellerMap);

        Seller salesman = new Seller();
        salesman.setName("Diego");
        Mockito.when(sellerMap.get("Diego")).thenReturn(salesman);

        Sale sale = layout.read("003ç10ç[1-10-100,2-30-2.50,3-40-3.10]çDiego");
        assertEquals(10, sale.getId());
        assertEquals("Diego", sale.getSeller().getName());
    }
}

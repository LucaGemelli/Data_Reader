package com.luca.gemelli.datareader.layout;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.luca.gemelli.datareader.model.Seller;

public class SellerLayoutTest {

    @Test
    public void testSalesman() {
        SellerLayout layout = new SellerLayout();
        Seller seller = layout.read("001ç3245678865434çRenatoç40000.99");

        assertEquals("3245678865434", seller.getCpf());
        assertEquals("Renato", seller.getName());
        assertEquals(40000.99, seller.getSalary(), 0.001);
    }

}

package com.luca.gemelli.datareader.layout;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.luca.gemelli.datareader.model.Customer;

public class CustomerLayoutTest {

    @Test
    public void testCustomer() {
        CustomerLayout layout = new CustomerLayout();
        Customer customer = layout.read("002ç2345675434544345çJose da SilvaçRural");

        assertEquals("2345675434544345", customer.getCnpj());
        assertEquals("Jose da Silva", customer.getName());
        assertEquals("Rural", customer.getBusinessArea());
    }
}

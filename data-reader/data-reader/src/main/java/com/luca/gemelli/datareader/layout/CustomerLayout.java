package com.luca.gemelli.datareader.layout;

import com.luca.gemelli.datareader.model.Customer;

public class CustomerLayout extends AbstractLayout<Customer> {

    public static final String LAYOUT_CODE = "002";

    public static final int FIELD_CODE = 0;
    public static final int FIELD_CNPJ = 1;
    public static final int FIELD_NAME = 2;
    public static final int FIELD_BUSINESS_AREA = 3;

    @Override
    public Customer read(final String line) {
        String[] fields = line.split(FIELD_DELIMITER);
        Customer customer = new Customer();
        customer.setCnpj(fields[FIELD_CNPJ]);
        customer.setName(fields[FIELD_NAME]);
        customer.setBusinessArea(fields[FIELD_BUSINESS_AREA]);

        return customer;
    }

}

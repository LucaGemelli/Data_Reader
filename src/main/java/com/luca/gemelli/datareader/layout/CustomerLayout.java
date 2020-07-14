package com.luca.gemelli.datareader.layout;

import com.luca.gemelli.datareader.model.Customer;

public class CustomerLayout extends AbstractLayout<Customer> {

    public static final String LAYOUT_CODE = "002";

    public static final int FIELD_CNPJ = 1;
    public static final int FIELD_NAME = 2;
    public static final int FIELD_BUSINESS_AREA = 3;

    @Override
    public Customer read(final String line) {
        final String[] fields = line.split(SEPARATOR);
        return Customer.create()
                       .withCnpj(fields[FIELD_CNPJ])
                       .withName(fields[FIELD_NAME])
                       .withBusinessArea(fields[FIELD_BUSINESS_AREA]);
    }

}

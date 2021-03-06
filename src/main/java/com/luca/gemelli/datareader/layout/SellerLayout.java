package com.luca.gemelli.datareader.layout;

import com.luca.gemelli.datareader.model.Seller;

public class SellerLayout extends AbstractLayout<Seller> {

    public static final String LAYOUT_CODE = "001";

    public static final int CODE_CPF = 1;
    public static final int CODE_NAME = 2;
    public static final int CODE_SALARY = 3;

    @Override
    public Seller read(final String line) {
        final String[] fields = line.split(SEPARATOR);
        return Seller.create()
                     .withCpf(fields[CODE_CPF])
                     .withName(fields[CODE_NAME])
                     .withSalary(Double.parseDouble(fields[CODE_SALARY]));
    }

}

package com.luca.gemelli.datareader.layout;

import com.luca.gemelli.datareader.model.Salesman;

public class SalesmanLayout extends AbstractLayout<Salesman> {

    public static final String LAYOUT_CODE = "001";

    public static final int FIELD_CODE = 0;
    public static final int FIELD_CPF = 1;
    public static final int FIELD_NAME = 2;
    public static final int FIELD_SALARY = 3;

    @Override
    public Salesman read(String line) {
        Salesman salesman = new Salesman();
        String[] fields = line.split(FIELD_DELIMITER);
        salesman.setCpf(fields[FIELD_CPF]);
        salesman.setName(fields[FIELD_NAME]);
        salesman.setSalary(Double.parseDouble(fields[FIELD_SALARY]));

        return salesman;
    }

}

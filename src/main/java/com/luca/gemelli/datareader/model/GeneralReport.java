package com.luca.gemelli.datareader.model;

import lombok.Data;

@Data
public class GeneralReport {

    private Salesman worstSalesman;

    private Sale mostExpensiveSale;

    @Override
    public String toString() {
        String report = "ID of the most expensive sale: " + mostExpensiveSale.getId() + "\n" + "Worst salesman ever: "
                + worstSalesman.getName() + "\n\n";

        return report;
    }

}

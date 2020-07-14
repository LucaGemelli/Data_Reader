package com.luca.gemelli.datareader.model;

import lombok.Data;

@Data
public class General {

    private Seller worstSalesman;

    private Sale mostExpensiveSale;

    @Override
    public String toString() {
      return new StringBuilder().append("ID of the most expensive sale: ")
                                .append(mostExpensiveSale.getId())
                                .append("\n" )
                                .append("Worst salesman ever: ")
                                .append(worstSalesman.getName())
                                .append("\n\n")
                                .toString();
    }

}

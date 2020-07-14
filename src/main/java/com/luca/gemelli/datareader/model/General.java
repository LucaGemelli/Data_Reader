package com.luca.gemelli.datareader.model;

import lombok.Data;

@Data
public class General {

    private Seller worstSeller;

    private Sale mostExpensiveSale;

    @Override
    public String toString() {
      return new StringBuilder().append("ID of the most expensive sale: ")
                                .append(mostExpensiveSale.getId())
                                .append("\n" )
                                .append("Worst salesman ever: ")
                                .append(worstSeller.getName())
                                .append("\n\n")
                                .toString();
    }

    public static synchronized General create() {
        return new General();
	}

	public General withWorstSeller(final Seller worstSeller) {
        this.worstSeller = worstSeller;
        return this;
	}

	public General withMostExpensiveSale(final Sale mostExpensiveSale) {
        this.mostExpensiveSale = mostExpensiveSale;
        return this;
	}

}

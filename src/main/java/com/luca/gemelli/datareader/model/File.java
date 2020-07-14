package com.luca.gemelli.datareader.model;

import lombok.Data;

@Data
public class File {

    private String file;

    private int amountClients;

    private int amountSeller;

    public void incrementAmountClients() {
        amountClients++;
    }

    public void incrementAmountSeller() {
        amountSeller++;
    }

    @Override
    public String toString() {
    return new StringBuilder().append("File: ")
                              .append(file)
                              .append("\n")
                              .append("Amount of clients in the input file: ")
                              .append(amountClients)
                              .append("\n")
                              .append("Amount of salesman in the input file: ")
                              .append(amountSeller)
                              .append("\n\n")
                              .toString();
    }

}

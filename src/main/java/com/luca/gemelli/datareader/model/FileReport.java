package com.luca.gemelli.datareader.model;

import lombok.Data;

@Data
public class FileReport {

    private String file;

    private int amountClients;

    private int amountSalesman;

    public void incrementAmountClients() {
        amountClients++;
    }

    public void incrementAmountSalesman() {
        amountSalesman++;
    }

    @Override
    public String toString() {
        String report = "File: " + file + "\n" + "Amount of clients in the input file: " + amountClients + "\n"
                + "Amount of salesman in the input file: " + amountSalesman + "\n\n";

        return report;
    }

}

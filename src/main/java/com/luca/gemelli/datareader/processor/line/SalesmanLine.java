package com.luca.gemelli.datareader.processor.line;

import java.util.Map;

import com.luca.gemelli.datareader.layout.SalesmanLayout;
import com.luca.gemelli.datareader.model.FileReport;
import com.luca.gemelli.datareader.model.Salesman;

public class SalesmanLine implements Line {

    SalesmanLayout salesmanLayout;
    Map<String, Salesman> salesmanMap;
    FileReport fileReport;

    public SalesmanLine(SalesmanLayout salesmanLayout, Map<String, Salesman> salesmanMap, FileReport fileReport) {
        this.salesmanLayout = salesmanLayout;
        this.salesmanMap = salesmanMap;
        this.fileReport = fileReport;
    }

    public void process(String line) {
        Salesman salesman = salesmanLayout.read(line);
        if (!salesmanMap.containsKey(salesman.getName())) {
            salesmanMap.put(salesman.getName(), salesman);
        }
        fileReport.incrementAmountSalesman();
    }

}

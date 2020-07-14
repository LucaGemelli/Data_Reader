package com.luca.gemelli.datareader.processor;

import java.util.Map;

import com.luca.gemelli.datareader.layout.CustomerLayout;
import com.luca.gemelli.datareader.layout.SaleLayout;
import com.luca.gemelli.datareader.layout.SalesmanLayout;
import com.luca.gemelli.datareader.model.Customer;
import com.luca.gemelli.datareader.model.FileReport;
import com.luca.gemelli.datareader.model.GeneralReport;
import com.luca.gemelli.datareader.model.Sale;
import com.luca.gemelli.datareader.model.Salesman;
import com.luca.gemelli.datareader.processor.line.CustomerLine;
import com.luca.gemelli.datareader.processor.line.Line;
import com.luca.gemelli.datareader.processor.line.SaleLine;
import com.luca.gemelli.datareader.processor.line.SalesmanLine;

public class LineProcessor {

    private SalesmanLayout salesmanLayout;
    private CustomerLayout customerLayout;
    private SaleLayout saleLayout;

    private Map<Integer, Sale> saleMap;
    private Map<String, Customer> customerMap;
    private Map<String, Salesman> salesmanMap;
    private GeneralReport generalReport;
    private FileReport fileReport;

    private static final int LAYOUT_CODE_POSITION_START = 0;
    private static final int LAYOUT_CODE_POSITION_END = 3;

    public LineProcessor(SalesmanLayout salesmanLayout, CustomerLayout customerLayout, SaleLayout saleLayout,
            Map<String, Salesman> salesmanMap, Map<String, Customer> customerMap, Map<Integer, Sale> saleMap,
            GeneralReport generalReport, FileReport fileReport) {
        this.salesmanLayout = salesmanLayout;
        this.customerLayout = customerLayout;
        this.saleLayout = saleLayout;
        this.salesmanMap = salesmanMap;
        this.customerMap = customerMap;
        this.saleMap = saleMap;
        this.generalReport = generalReport;
        this.fileReport = fileReport;
    }

    public void process(String line) throws Exception {
        Line lineImplementation = null;
        switch (line.substring(LAYOUT_CODE_POSITION_START, LAYOUT_CODE_POSITION_END)) {

        case SalesmanLayout.LAYOUT_CODE:
            lineImplementation = new SalesmanLine(salesmanLayout, salesmanMap, fileReport);
            break;

        case CustomerLayout.LAYOUT_CODE:
            lineImplementation = new CustomerLine(customerLayout, customerMap, fileReport);
            break;

        case SaleLayout.LAYOUT_CODE:
            lineImplementation = new SaleLine(saleLayout, saleMap, generalReport);
            break;

        default:
            throw new Exception("Linha inválida.");
        }
        lineImplementation.process(line);
    }
}

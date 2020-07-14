package com.luca.gemelli.datareader.processor.line;

import java.util.Map;

import com.luca.gemelli.datareader.layout.SaleLayout;
import com.luca.gemelli.datareader.model.GeneralReport;
import com.luca.gemelli.datareader.model.Sale;
import com.luca.gemelli.datareader.model.Salesman;

public class SaleLine implements Line {

    private SaleLayout saleLayout;
    private Map<Integer, Sale> saleMap;
    private GeneralReport generalReport;

    public SaleLine(SaleLayout saleLayout, Map<Integer, Sale> saleMap, GeneralReport generalReport) {
        this.saleLayout = saleLayout;
        this.saleMap = saleMap;
        this.generalReport = generalReport;
    }

    public void process(String line) {
        Sale sale = saleLayout.read(line);
        if (generalReport.getMostExpensiveSale() == null) {
            generalReport.setMostExpensiveSale(sale);
        }
        if (sale.getTotal() > generalReport.getMostExpensiveSale().getTotal()) {
            generalReport.setMostExpensiveSale(sale);
        }
        Salesman saleSalesman = sale.getSalesman();
        saleSalesman.addSale(sale.getTotal());
        saleMap.put(sale.getId(), sale);
    }

}

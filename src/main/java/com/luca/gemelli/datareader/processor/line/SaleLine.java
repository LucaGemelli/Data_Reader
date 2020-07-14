package com.luca.gemelli.datareader.processor.line;

import java.util.Map;

import com.luca.gemelli.datareader.layout.SaleLayout;
import com.luca.gemelli.datareader.model.General;
import com.luca.gemelli.datareader.model.Sale;
import com.luca.gemelli.datareader.model.Seller;

public class SaleLine implements Line {

    private SaleLayout layout;
    private Map<Integer, Sale> saleMap;
    private General generalReport;

    public SaleLine(final SaleLayout layout,
                    final Map<Integer, Sale> saleMap,
                    final General generalReport) {
        this.layout = layout;
        this.saleMap = saleMap;
        this.generalReport = generalReport;
    }

    public void process(final String line) {
        final Sale sale = layout.read(line);
        if (generalReport.getMostExpensiveSale() == null) {
            generalReport.setMostExpensiveSale(sale);
        }
        if (sale.getTotal() > generalReport.getMostExpensiveSale().getTotal()) {
            generalReport.setMostExpensiveSale(sale);
        }
        final Seller saleSeller = sale.getSeller();
        saleSeller.addSale(sale.getTotal());
        saleMap.put(sale.getId(), sale);
    }

}

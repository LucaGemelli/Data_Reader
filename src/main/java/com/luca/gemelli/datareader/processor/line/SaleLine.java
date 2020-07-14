package com.luca.gemelli.datareader.processor.line;

import java.util.Map;

import com.luca.gemelli.datareader.layout.SaleLayout;
import com.luca.gemelli.datareader.model.General;
import com.luca.gemelli.datareader.model.Sale;
import com.luca.gemelli.datareader.model.Seller;

public class SaleLine implements Line {

    private SaleLayout layout;
    private Map<Integer, Sale> saleMap;
    private General general;

    public SaleLine(final SaleLayout layout,
                    final Map<Integer, Sale> saleMap,
                    final General generalReport) {
        this.layout = layout;
        this.saleMap = saleMap;
        this.general = generalReport;
    }

    public void process(final String line) {
        final Sale sale = layout.read(line);
        if (general.getMostExpensiveSale() == null) {
            general.setMostExpensiveSale(sale);
        }
        if (sale.getTotal() > general.getMostExpensiveSale().getTotal()) {
            general.setMostExpensiveSale(sale);
        }
        final Seller saleSeller = sale.getSeller();
        saleSeller.addSale(sale.getTotal());
        saleMap.put(sale.getId(), sale);
    }

}

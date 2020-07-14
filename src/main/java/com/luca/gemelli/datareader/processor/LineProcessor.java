package com.luca.gemelli.datareader.processor;

import java.util.Map;

import com.luca.gemelli.datareader.layout.CustomerLayout;
import com.luca.gemelli.datareader.layout.SaleLayout;
import com.luca.gemelli.datareader.layout.SellerLayout;
import com.luca.gemelli.datareader.model.Customer;
import com.luca.gemelli.datareader.model.File;
import com.luca.gemelli.datareader.model.General;
import com.luca.gemelli.datareader.model.Sale;
import com.luca.gemelli.datareader.model.Seller;
import com.luca.gemelli.datareader.processor.line.CustomerLine;
import com.luca.gemelli.datareader.processor.line.Line;
import com.luca.gemelli.datareader.processor.line.SaleLine;
import com.luca.gemelli.datareader.processor.line.SellerLine;

public class LineProcessor {

    private static final int LAYOUT_CODE_POSITION_START = 0;
    private static final int LAYOUT_CODE_POSITION_END = 3;

	private SellerLayout sellerLayout;
    private CustomerLayout customerLayout;
    private SaleLayout saleLayout;

    private Map<Integer, Sale> saleMap;
    private Map<String, Customer> customerMap;
    private Map<String, Seller> sellerMap;
    private General generalReport;
    private File file;

    public LineProcessor(final SellerLayout sellerLayout,
                         final CustomerLayout customerLayout,
                         final SaleLayout saleLayout,
                         final Map<String, Seller> salesmanMap,
                         final Map<String, Customer> customerMap,
                         final Map<Integer, Sale> saleMap,
                         final General generalReport,
                         final File file) {
        this.sellerLayout = sellerLayout;
        this.customerLayout = customerLayout;
        this.saleLayout = saleLayout;
        this.sellerMap = salesmanMap;
        this.customerMap = customerMap;
        this.saleMap = saleMap;
        this.generalReport = generalReport;
        this.file = file;
    }

    public void process(final String line) throws Exception {
        Line lineImplementation = null;
        switch (line.substring(LAYOUT_CODE_POSITION_START, LAYOUT_CODE_POSITION_END)) {

        case SellerLayout.LAYOUT_CODE:
            lineImplementation = new SellerLine(sellerLayout, sellerMap, file);
            break;

        case CustomerLayout.LAYOUT_CODE:
            lineImplementation = new CustomerLine(customerLayout, customerMap, file);
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

package com.luca.gemelli.datareader.processor;

import java.util.Map;
import java.util.stream.Stream;

import com.luca.gemelli.datareader.layout.CustomerLayout;
import com.luca.gemelli.datareader.layout.SaleLayout;
import com.luca.gemelli.datareader.layout.SellerLayout;
import com.luca.gemelli.datareader.model.Customer;
import com.luca.gemelli.datareader.model.File;
import com.luca.gemelli.datareader.model.General;
import com.luca.gemelli.datareader.model.Sale;
import com.luca.gemelli.datareader.model.Seller;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FileProcessor {

    private SellerLayout salesmanLayout;
    private CustomerLayout customerLayout;
    private SaleLayout saleLayout;

    private Map<Integer, Sale> saleMap;
    private Map<String, Customer> customerMap;
    private Map<String, Seller> salesmanMap;
    private General generalReport;

    public FileProcessor(final SellerLayout sellerLayout,
                         final CustomerLayout customerLayout,
                         final SaleLayout saleLayout,
                         final Map<String, Seller> sellerMap,
                         final Map<String, Customer> customerMap,
                         final Map<Integer, Sale> saleMap,
                         final General generalReport) {
        this.salesmanLayout = sellerLayout;
        this.customerLayout = customerLayout;
        this.saleLayout = saleLayout;
        this.salesmanMap = sellerMap;
        this.customerMap = customerMap;
        this.saleMap = saleMap;
        this.generalReport = generalReport;
    }

    public File process(final Stream<String> lines) {
        final File fileReport = new File();
        final LineProcessor lineProcessor = new LineProcessor(salesmanLayout,
                                                              customerLayout,
                                                              saleLayout,
                                                              salesmanMap,
                                                              customerMap,
                                                              saleMap,
                                                              generalReport,
                                                              fileReport);

        lines.forEach(line -> {
            try {
               lineProcessor.process(line);
            } catch (Exception e) {
              log.info("Erro ao processar linha - " + e.getMessage());
            }
        });

        return fileReport;
    }

}

package com.luca.gemelli.datareader.processor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.luca.gemelli.datareader.layout.CustomerLayout;
import com.luca.gemelli.datareader.layout.SaleLayout;
import com.luca.gemelli.datareader.layout.SellerLayout;
import com.luca.gemelli.datareader.model.Customer;
import com.luca.gemelli.datareader.model.File;
import com.luca.gemelli.datareader.model.General;
import com.luca.gemelli.datareader.model.Sale;
import com.luca.gemelli.datareader.model.Seller;
import com.luca.gemelli.datareader.service.FileService;

public class DirectoryProcessor {

    private General general;

    private List<File> files;

    private FileService fileService;

    public DirectoryProcessor(final General general,
                              final List<File> filesReports) {
        this.fileService = new FileService();
        this.general = general;
        this.files = filesReports;
    }

    public void process() throws IOException {
        final Map<String, Seller> sellerMap = new HashMap<>();
        final Map<String, Customer> customerMap = new HashMap<>();
        final Map<Integer, Sale> saleMap = new HashMap<>();

        final SellerLayout sellerLayout = new SellerLayout();
        final CustomerLayout customerLayout = new CustomerLayout();
        final SaleLayout saleLayout = new SaleLayout();
        saleLayout.setSellerMap(sellerMap);

        final FileProcessor processor = new FileProcessor(sellerLayout,
                                                          customerLayout,
                                                          saleLayout,
                                                          sellerMap,
                                                          customerMap,
                                                          saleMap,
                                                          general
        );

        String caminho = this.fileService.getPathIn();
        Files.list(Paths.get(caminho))
                        .filter(p -> p.toString().endsWith(FileService.ENDFILE))
                        .forEach(p -> {
            try {
                File report = processor.process(Files.lines(p));
                report.setFile(p.toString());
                files.add(report);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        if (sellerMap.size() > 0) {
            general.setWorstSeller(sellerMap.values()
                                       .stream()
                                       .min(Comparator.comparingDouble(Seller::getSales))
                                       .get());
        }

    }

}

package com.luca.gemelli.datareader.processor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import com.luca.gemelli.datareader.layout.CustomerLayout;
import com.luca.gemelli.datareader.layout.SaleLayout;
import com.luca.gemelli.datareader.layout.SalesmanLayout;
import com.luca.gemelli.datareader.model.Customer;
import com.luca.gemelli.datareader.model.FileReport;
import com.luca.gemelli.datareader.model.GeneralReport;
import com.luca.gemelli.datareader.model.Sale;
import com.luca.gemelli.datareader.model.Salesman;

public class DirectoryProcessor {

    private GeneralReport generalReport;

    private List<FileReport> filesReports;

    private String inputPath;

    public DirectoryProcessor(String inputPath, GeneralReport generalReport, List<FileReport> filesReports) {
        this.inputPath = inputPath;
        this.generalReport = generalReport;
        this.filesReports = filesReports;
    }

    public void process() throws IOException {
        Map<String, Salesman> salesmanMap = new HashMap<>();
        Map<String, Customer> customerMap = new HashMap<>();
        Map<Integer, Sale> saleMap = new HashMap<>();

        SalesmanLayout salesmanLayout = new SalesmanLayout();
        CustomerLayout customerLayout = new CustomerLayout();
        SaleLayout saleLayout = new SaleLayout();
        saleLayout.setSalesmanMap(salesmanMap);

        FileProcessor processor = new FileProcessor(
            salesmanLayout,
            customerLayout,
            saleLayout,
            salesmanMap,
            customerMap,
            saleMap,
            generalReport
        );

        Files.list(Paths.get(inputPath)).filter(p -> p.toString().endsWith(".dat")).forEach(p -> {
            try {
                Stream<String> lines = Files.lines(p);
                FileReport report = processor.process(lines);
                report.setFile(p.toString());
                filesReports.add(report);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        if (salesmanMap.size() > 0) {
            Salesman worstSalesman = salesmanMap.values()
                    .stream()
                    .min(Comparator.comparingDouble(Salesman::getSales))
                    .get();
            generalReport.setWorstSalesman(worstSalesman);
        }

    }

}

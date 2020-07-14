package com.luca.gemelli.datareader.processor.line;

import java.util.Map;

import com.luca.gemelli.datareader.layout.CustomerLayout;
import com.luca.gemelli.datareader.model.Customer;
import com.luca.gemelli.datareader.model.FileReport;

public class CustomerLine implements Line {

    private CustomerLayout customerLayout;
    private Map<String, Customer> customerMap;
    private FileReport fileReport;

    public CustomerLine(CustomerLayout customerLayout, Map<String, Customer> customerMap, FileReport fileReport) {
        this.customerLayout = customerLayout;
        this.customerMap = customerMap;
        this.fileReport = fileReport;
    }

    public void process(String line) {
        Customer customer = customerLayout.read(line);
        if (!customerMap.containsKey(customer.getName())) {
            customerMap.put(customer.getName(), customer);
        }

        fileReport.incrementAmountClients();
    }
}

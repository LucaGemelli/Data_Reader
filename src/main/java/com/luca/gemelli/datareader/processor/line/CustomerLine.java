package com.luca.gemelli.datareader.processor.line;

import java.util.Map;

import com.luca.gemelli.datareader.layout.CustomerLayout;
import com.luca.gemelli.datareader.model.Customer;
import com.luca.gemelli.datareader.model.File;

public class CustomerLine implements Line {

    private CustomerLayout layout;
    private Map<String, Customer> customerMap;
    private File file;

    public CustomerLine(final CustomerLayout layout,
                        final Map<String, Customer> customerMap,
                        final File file) {
        this.layout = layout;
        this.customerMap = customerMap;
        this.file = file;
    }

    public void process(final String line) {
        final Customer customer = layout.read(line);
        if (!customerMap.containsKey(customer.getName())) {
            customerMap.put(customer.getName(), customer);
        }

        file.incrementAmountClients();
    }
}

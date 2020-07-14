package com.luca.gemelli.datareader.processor.line;

import java.util.Map;

import com.luca.gemelli.datareader.layout.SellerLayout;
import com.luca.gemelli.datareader.model.File;
import com.luca.gemelli.datareader.model.Seller;

public class SellerLine implements Line {

    private SellerLayout sellerLayout;
    private Map<String, Seller> sellerMap;
    private File file;

    public SellerLine(final SellerLayout sellerLayout,
                      final Map<String, Seller> sellerMap,
                      final File file) {
        this.sellerLayout = sellerLayout;
        this.sellerMap = sellerMap;
        this.file = file;
    }

    public void process(final String line) {
        final Seller seller = sellerLayout.read(line);
        if (!sellerMap.containsKey(seller.getName())) {
            sellerMap.put(seller.getName(), seller);
        }
        file.incrementAmountSeller();
    }

}

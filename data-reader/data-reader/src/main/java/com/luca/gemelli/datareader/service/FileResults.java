package com.luca.gemelli.datareader.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

import com.luca.gemelli.datareader.dto.ReportDTO;
import com.luca.gemelli.datareader.model.Client;
import com.luca.gemelli.datareader.model.Sales;
import com.luca.gemelli.datareader.model.Seller;

public class FileResults {

	public ReportDTO resultWriter(final List<Seller> sellers, 
								  final List<Client> clients,
								  final List<Sales> sales) {
		final ReportDTO report = ReportDTO.create() 
										  .withSeller(sellers.size())
										  .withClient(clients.size());
		this.worstSellerHighestSeller(sales, report);

		return report;
	}

	private void worstSellerHighestSeller(final List<Sales> sales, 
										  final ReportDTO report) {
		Map<String, Float> idsSales = new HashMap<>();
		AtomicReference<Float> total = new AtomicReference<>((float) 0);

		for (Sales sale : sales) {
			total.set((float) 0);
			sale.getItems()
					  .forEach(item -> total.updateAndGet(v -> (float) (v + item.getPrice())));
			idsSales
					.put(sale.getSaleId() + ", " + sale.getSellerName(), total.get());
		}

		List<String> worst = new ArrayList<>();
		List<String> best = new ArrayList<>();
		Float saleWorsest = Float.MAX_VALUE;
		Float saleHighest = Float.MIN_VALUE;

		for (Map.Entry<String, Float> entry : idsSales.entrySet()) {
			if (entry.getValue() <= saleWorsest) {
				if (!entry.getValue().equals(saleWorsest)) {
					worst.clear();
				}
				worst.add(entry.getKey());
				saleWorsest = entry.getValue();
			}

			if (entry.getValue() >= saleHighest) {
				if (!entry.getValue().equals(saleHighest)) {
					best.clear();
				}
				best.add(entry.getKey());
				saleHighest = entry.getValue();
			}
		}

		report.setIdSale(best);
		report.setWorstSeller(worst);
	}
}

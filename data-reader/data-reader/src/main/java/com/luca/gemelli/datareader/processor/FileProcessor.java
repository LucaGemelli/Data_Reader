package com.luca.gemelli.datareader.processor;

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

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FileProcessor {

	private SalesmanLayout salesmanLayout;
	private CustomerLayout customerLayout;
	private SaleLayout saleLayout;

	private Map<Integer, Sale> saleMap;
	private Map<String, Customer> customerMap;
	private Map<String, Salesman> salesmanMap;
	private GeneralReport generalReport;

	public FileProcessor(
			SalesmanLayout salesmanLayout,
			CustomerLayout customerLayout,
			SaleLayout saleLayout,
			Map<String, Salesman> salesmanMap,
			Map<String, Customer> customerMap,
			Map<Integer, Sale> saleMap,
			GeneralReport generalReport
		) {
		this.salesmanLayout = salesmanLayout;
		this.customerLayout = customerLayout;
		this.saleLayout = saleLayout;
		this.salesmanMap = salesmanMap;
		this.customerMap = customerMap;
		this.saleMap = saleMap;
		this.generalReport = generalReport;
	}

	public FileReport process(Stream<String> lines) {
		FileReport fileReport = new FileReport();
		LineProcessor lineProcessor = new LineProcessor(
			salesmanLayout,
			customerLayout,
			saleLayout,
			salesmanMap,
			customerMap,
			saleMap,
			generalReport,
			fileReport
		);
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

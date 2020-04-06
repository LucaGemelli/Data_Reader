package com.luca.gemelli.datareader.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.luca.gemelli.datareader.dto.ReportDTO;
import com.luca.gemelli.datareader.factory.FactoryObject;
import com.luca.gemelli.datareader.model.Client;
import com.luca.gemelli.datareader.model.Sales;
import com.luca.gemelli.datareader.model.Seller;

public class FileReading {

	public void fileReading(final File file) throws Exception {

		final BufferedReader bufferedReader =
								new BufferedReader(new FileReader(file));

		String line = bufferedReader.readLine();

		List<Seller> sellers = new ArrayList<>();
		List<Client> clients = new ArrayList<>();
		List<Sales> sales = new ArrayList<>();

		while (Objects.nonNull(line)) {

			final Object obj = FactoryObject.factoryObject(line);

			if (obj instanceof Seller) {
				sellers.add((Seller) obj);

			} else if (obj instanceof Client) {
				clients.add((Client) obj);

			} else if (obj instanceof Sales) {
				sales.add((Sales) obj);
			}

			line = bufferedReader.readLine();
		}

		try {
			ReportDTO result = (new FileResults().resultWriter(sellers, clients, sales));

			new WriteReport().writerReport(result);
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}

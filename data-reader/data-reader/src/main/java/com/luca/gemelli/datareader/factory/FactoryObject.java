package com.luca.gemelli.datareader.factory;

import com.luca.gemelli.datareader.model.Client;
import com.luca.gemelli.datareader.model.Sales;
import com.luca.gemelli.datareader.model.Seller;

public class FactoryObject {

	public static Object factoryObject(final String line) throws Exception {
		try {
			final String[] split = line.split("ç");

			if(!split[0].isEmpty()){
				switch (split[0]) {
					case("001"):
						return Seller.create()
									 .withCpf(split[1])
									 .withSellerName(split[2])
									 .withSalary(Double.parseDouble(split[3]));

					case("002"):
						return Client.create()
									 .withCnpj(split[1])
									 .withClientName(split[2])
									 .withArea(split[3]);

					case("003"):
						return Sales.create()
									.withSaleId(split[1])
									.withItems(split[2])
									.withSellerName(split[3]);
				}

			} else {
				throw new Exception("Error: Id inválido");
			}

		} catch (Exception e) {
			throw new Exception("Error: " + e.getMessage());
		}

		throw new Exception("Erro Inesperado");
	}
}

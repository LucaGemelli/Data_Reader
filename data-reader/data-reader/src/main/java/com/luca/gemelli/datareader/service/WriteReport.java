package com.luca.gemelli.datareader.service;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import com.luca.gemelli.datareader.dto.ReportDTO;

public class WriteReport {

	private final static String NEWLINE = System.getProperty("line.separator");

	public void writerReport(final ReportDTO reportDto) throws IOException {
		final FileWriter arq = new FileWriter(new FileService()
													.getPathOutWithNameFile());
		final PrintWriter saveArq = new PrintWriter(arq);
		saveArq.print(this.buildContentFile(reportDto));
		arq.close();
		System.out.println("Successfully processed");
	}

	private String buildContentFile(final ReportDTO reportDto) {
		return new StringBuilder().append("---------------------REPORT--------------------")
								  .append(NEWLINE)
								  .append(" Clients:")
								  .append(reportDto.getClient())
								  .append(NEWLINE)
								  .append(" Sellers:")
								  .append(reportDto.getSeller())
								  .append(NEWLINE)
								  .append(" Most expensive sale id:")
								  .append(reportDto.getIdSale())
								  .append(NEWLINE)
								  .append(" Worst salesman id:")
								  .append(reportDto.getWorstSeller())
								  .append(NEWLINE)
								  .append("-----------------------------------------------")
								  .toString();
	}
}

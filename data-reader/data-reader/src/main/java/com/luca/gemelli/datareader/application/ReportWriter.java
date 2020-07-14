package com.luca.gemelli.datareader.application;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.List;

import com.luca.gemelli.datareader.model.FileReport;
import com.luca.gemelli.datareader.model.GeneralReport;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ReportWriter {

    private String outputPath;

    private GeneralReport generalReport;

    private List<FileReport> filesReports;

    public ReportWriter(String outputPath, GeneralReport generalReport, List<FileReport> filesReports) {
        this.outputPath = outputPath;
        this.generalReport = generalReport;
        this.filesReports = filesReports;
    }

    public void write() throws IOException {
        String filename = outputPath + "/" + "report-" + Instant.now().getEpochSecond() + ".done.dat";
        String fullReport = generalReport.toString();
        for (FileReport fileReport : filesReports) {
            fullReport += fileReport.toString();
        }
        Files.write(Paths.get(filename), fullReport.getBytes());
        log.info("Relatório gerado com sucesso no caminho: " + filename + "\n");
    }

}

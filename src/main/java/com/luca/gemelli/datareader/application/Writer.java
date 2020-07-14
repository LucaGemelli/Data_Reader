package com.luca.gemelli.datareader.application;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.List;

import com.luca.gemelli.datareader.model.File;
import com.luca.gemelli.datareader.model.General;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Writer {

    private String outputPath;

    private General general;

    private List<File> files;

    public Writer(final String outputPath,
                  final General generalReport,
                  final List<File> files) {
        this.outputPath = outputPath;
        this.general = generalReport;
        this.files = files;
    }

    public void write() throws IOException {
        final String filename = new StringBuilder().append(outputPath)
                                                   .append("/")
                                                   .append("report-")
                                                   .append(Instant.now().getEpochSecond())
                                                   .append(".done.dat")
                                                   .toString();
        String fullReport = general.toString();
        for (File fileReport : files) {
            fullReport += fileReport.toString();
        }

        Files.write(Paths.get(filename),
                    fullReport.getBytes());
        log.info("Relatório gerado com sucesso no caminho: " + filename + "\n");
    }

}

package com.luca.gemelli.datareader.application;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.luca.gemelli.datareader.model.File;
import com.luca.gemelli.datareader.model.General;
import com.luca.gemelli.datareader.service.FileService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Writer {

    private General general;

    private List<File> files;

    private FileService fileService;

    public Writer(final General generalReport,
                  final List<File> files) {
        this.fileService = new FileService();
        this.general = generalReport;
        this.files = files;
    }

    public void write() throws IOException {
        final String filename = this.fileService.getPathOutWithNameFile();
        String fullReport = general.toString();
        for (File fileReport : files) {
            fullReport += fileReport.toString();
        }

        Files.write(Paths.get(filename),
                    fullReport.getBytes());
        log.info("Relatório gerado com sucesso no caminho: " + filename + "\n");
    }

}

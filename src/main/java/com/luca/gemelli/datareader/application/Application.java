package com.luca.gemelli.datareader.application;

import java.util.ArrayList;
import java.util.List;

import com.luca.gemelli.datareader.model.File;
import com.luca.gemelli.datareader.model.General;
import com.luca.gemelli.datareader.processor.DirectoryProcessor;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Application {

    private String inputPath;

    private String outputPath;

    public Application(final String in,
                       final String out) {
        this.inputPath = in;
        this.outputPath = out;
    }

    public void run() throws Exception {
        final List<File> filesReports = new ArrayList<>();
        final General general = new General();

        log.info("Processando arquivos...\n");
        new DirectoryProcessor(inputPath, general, filesReports).process();;

        log.info("Arquivos processados.\n");

        if (filesReports.size() > 0 && general != null) {
            new Writer(outputPath, general, filesReports).write();
        } else {
            log.info("Não há dados para gerar o relatório.");
        }
    }

}

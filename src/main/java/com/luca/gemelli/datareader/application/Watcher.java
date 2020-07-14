package com.luca.gemelli.datareader.application;

import java.nio.file.FileSystems;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Watcher {

    private static final String MESSAGE = "Aguardando novos arquivos para reprocessar...\n";
    private Application application;

    private String inputPath;

    public Watcher(Application application, String in) {
        this.application = application;
        this.inputPath = in;
    }

    public void watch() throws Exception {
        final WatchService watchService = FileSystems.getDefault().newWatchService();
        Paths.get(inputPath)
             .register(watchService, StandardWatchEventKinds.ENTRY_CREATE);
        WatchKey key;
        log.info(MESSAGE);

        while ((key = watchService.take()) != null) {
            key.pollEvents();
            application.run();
            key.reset();
            log.info(MESSAGE);
        }
    }

}

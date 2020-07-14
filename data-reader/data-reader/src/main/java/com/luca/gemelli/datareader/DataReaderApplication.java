package com.luca.gemelli.datareader;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.luca.gemelli.datareader.application.Application;
import com.luca.gemelli.datareader.application.Watcher;

@SpringBootApplication
public class DataReaderApplication implements CommandLineRunner {

    private String inputPath;

    private String outputPath;

    public static void main(String[] args) {
        SpringApplication.run(DataReaderApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Application application = new Application(inputPath, outputPath);
        application.run();

        Watcher watcher = new Watcher(application, inputPath);
        watcher.watch();
    }
}

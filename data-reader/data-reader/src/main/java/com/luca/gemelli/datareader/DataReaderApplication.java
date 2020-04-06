package com.luca.gemelli.datareader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;

import com.luca.gemelli.datareader.service.FolderWatcher;

@SpringBootApplication
public class DataReaderApplication implements ApplicationListener<ApplicationReadyEvent> {

	public static void main(String[] args) {
		SpringApplication.run(DataReaderApplication.class, args);
	}

	@Override
	public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
		try {
			 new FolderWatcher();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

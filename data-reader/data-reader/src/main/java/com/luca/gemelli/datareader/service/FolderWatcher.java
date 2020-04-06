package com.luca.gemelli.datareader.service;

import static java.nio.file.StandardWatchEventKinds.OVERFLOW;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

public class FolderWatcher {

	private String path;

	private FileService fileService;

	public FolderWatcher() throws IOException {
		this.fileService = new FileService();
		this.path = this.fileService.getPathIn();
		this.init(fileService.getFilesIn());
		this.startWacther();
	}

	private void init(final File[] files) {
		for(int i = 0; i < files.length; i++) {
			try {
				new FileReading().fileReading(files[0]);
				files[0].delete();
			} catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
			}
		}
	}

	private void startWacther() throws IOException {
		final Path dir = Paths.get(path);

		final WatchService watcher = dir.getFileSystem()
										.newWatchService();
		dir.register(watcher, StandardWatchEventKinds.ENTRY_CREATE);

		for (;;) {
			try {
				final WatchKey key;
				try {
					key = watcher.take();
				} catch (InterruptedException e) {
					return;
				}

				for (WatchEvent<?> event : key.pollEvents()) {
					final WatchEvent.Kind<?> kind = event.kind();
					if (kind == OVERFLOW) {
						continue;
					}

					if (event.kind() == StandardWatchEventKinds.ENTRY_CREATE) {
						new FileReading()
								.fileReading(new File(this.path.concat(event.context().toString())));
					}
				}

				if (!key.reset()) {
					break;
				}
			} catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
			}
		}
	}
}

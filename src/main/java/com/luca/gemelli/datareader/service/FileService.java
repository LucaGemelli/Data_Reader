package com.luca.gemelli.datareader.service;

import java.io.File;

public class FileService {

	public final static String ENDFILE = ".dat";

	private final static String IN = "\\data\\in\\";

	private final static String OUT = "\\data\\out\\";

	private final static String NAMEFILEOUT = "REPORT_";

	private final static String HOMEPATH = "HOMEPATH";

	private static Integer SEQUENCE = 0;

	public String getPathIn() {
		final String in = this.getPath().concat(IN);
		this.checkAndCreateDir(in);
		return in;
	}

	public String getPathOut() {
		final String out = this.getPath().concat(OUT);
		this.checkAndCreateDir(out);
		return out;
	}

	public String getPathOutWithNameFile() {
		return this.getPathOut().concat(NAMEFILEOUT)
								.concat(this.getNext().toString())
								.concat(ENDFILE);
	}

	private String getPath() {
		return System.getenv(HOMEPATH);
	}

	private void checkAndCreateDir(final String dir) {
		final File diretorio = new File(dir);
		if (!diretorio.exists()) { 
			diretorio.mkdirs();
		}
	}

	private Integer getNext() {
		return SEQUENCE = SEQUENCE + 1;
	}
}
package com.luca.gemelli.datareader.layout;

public abstract class AbstractLayout<T> {

    public static final String LAYOUT_CODE = null;

    public static final int CODE = 0;

    protected static final String SEPARATOR = "ç";

    public abstract T read(String line);

}

package com.neto.desafio.shared;

import java.nio.file.FileSystems;

public class Constant {

    private Constant() {

    }

    public static final String HOME = System.getProperty("user.home");
    public static final String SEPARADOR = FileSystems.getDefault().getSeparator();

    public static final String PATH = new StringBuilder(HOME)
            .append(SEPARADOR)
            .append("data")
            .append(SEPARADOR)
            .toString();

    public static final String PATH_IN = new StringBuilder(PATH).append("in")
            .append(SEPARADOR).toString();

    public static final String PATH_OUT = new StringBuilder(PATH).append("out")
            .append(SEPARADOR).toString();

    public static final String PATH_PROCESSED = new StringBuilder(PATH).append("processed")
            .append(SEPARADOR).toString();

    public static final String OUT_FILE_EXTENSION = ".done.dat";
}

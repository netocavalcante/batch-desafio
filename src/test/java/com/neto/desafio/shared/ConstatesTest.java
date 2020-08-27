package com.neto.desafio.shared;

import java.nio.file.FileSystem;
import java.nio.file.FileSystems;

public class ConstatesTest {
    public static String HOME = System.getProperty("user.home");
    public static String SEPARADOR = FileSystems.getDefault().getSeparator();

    public static String PATH = new StringBuffer(HOME)
            .append(SEPARADOR)
            .append("data")
            .append(SEPARADOR)
            .toString();

    public static String PATH_IN = new StringBuilder(PATH).append("in")
            .append(SEPARADOR).toString();

    public static String PATH_OUT = new StringBuilder(PATH).append("out")
            .append(SEPARADOR).toString();
}

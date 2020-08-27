package com.neto.desafio.batch;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static com.neto.desafio.shared.Constant.PATH_IN;

public class FilteItemReader implements org.springframework.batch.item.ItemReader<List<String>> {

    public static Path PATH_OF_CURRENT_FILE = null;

    @Override
    public List<String> read() throws Exception {

        Path path = Paths.get(PATH_IN);

        return Files.walk(path)
                .filter(this::validate)
                .map(this::obterDados)
                .findAny()
                .orElse(null);
    }

    public List<String> obterDados(Path path) {
        List<String> lines = null;
        try {
            PATH_OF_CURRENT_FILE = path;
            lines = Files.readAllLines(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    public boolean validate(Path path) {
        return path.getFileName().toString().endsWith("dat");
    }
}

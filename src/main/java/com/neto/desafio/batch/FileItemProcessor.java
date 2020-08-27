package com.neto.desafio.batch;

import com.neto.desafio.domain.report.Report;
import com.neto.desafio.parse.Parser;
import com.neto.desafio.parse.ParserFactory;

import java.util.Arrays;
import java.util.List;


public class FileItemProcessor implements org.springframework.batch.item.ItemProcessor<List<String>, Report> {
    private Report report;

    @Override
    public Report process(List<String> lines) throws Exception {
        report = new Report();

        lines.forEach(this::parseToEntity);

        return report;

    }

    private void parseToEntity(String line) {
        String identification = Arrays.stream(line.split("ç"))
                .findFirst()
                .orElse(null);

        Parser parser = new ParserFactory().getParser(identification);

        report.save(parser.parse(line));
    }
}


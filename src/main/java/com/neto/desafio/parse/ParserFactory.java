package com.neto.desafio.parse;

import java.util.HashMap;
import java.util.Map;

public class ParserFactory {

    private Map<String, Parser> parsers;

    public ParserFactory() {
        parsers = new HashMap<>();
        parsers.put("001", new SalesManParser());
        parsers.put("002", new CustomerParser());
        parsers.put("003", new SalesParser());
    }

    public Parser getParser(String identification) {
        return parsers.get(identification);
    }
}

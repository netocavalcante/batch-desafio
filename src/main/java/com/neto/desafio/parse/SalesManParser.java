package com.neto.desafio.parse;


import com.neto.desafio.domain.salesman.SalesMan;

import java.math.BigDecimal;

public class SalesManParser extends Parser<SalesMan> {

    @Override
    public SalesMan parse(String linha) {

        String[] elements = linha.split("ç");

        return new SalesMan(elements[1], elements[2], new BigDecimal(elements[3]));
    }
}

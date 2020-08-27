package com.neto.desafio.domain.salesman;

import java.math.BigDecimal;
import java.math.BigInteger;

public class SalesMan {

    private String cpf;
    private String name;
    private BigDecimal salary;

    public SalesMan(String cpf, String name, BigDecimal salary) {
        this.cpf = cpf;
        this.name = name;
        this.salary = salary;
    }

}

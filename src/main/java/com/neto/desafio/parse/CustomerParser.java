package com.neto.desafio.parse;

import com.neto.desafio.domain.customer.Customer;

public class CustomerParser extends Parser<Customer>{

    @Override
    public Customer parse(String linha) {
        String[] elements = linha.split("ç");

        if (elements.length < 4){
            throw new RuntimeException("Maluco");
        }

        return new Customer(elements[1],elements[2],elements[3]);
    }
}

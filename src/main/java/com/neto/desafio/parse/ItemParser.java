package com.neto.desafio.parse;


import com.neto.desafio.domain.sale.Item;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ItemParser extends Parser<List<Item>>{
    @Override
    public List<Item> parse(String linha) {
       linha = linha.replace("[","").replace("]","");

        return Arrays.stream(linha.split(","))
                .map(this::parseItem)
                .collect(Collectors.toList());
    }

    public Item parseItem(String element) {

        String[] content = element.split("-");

        return new Item(Long.valueOf(content[0]),Integer.valueOf(content[1]), new BigDecimal(content[2]));
    }
}

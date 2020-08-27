package com.neto.desafio.parse;


import com.neto.desafio.domain.sale.Item;
import com.neto.desafio.domain.sale.Sale;

import java.util.List;

import static com.neto.desafio.parse.SalesParser.SaleComponents.*;

public class SalesParser extends Parser<Sale> {

    public enum SaleComponents {
        SALES_ID(1),
        SALESMAN_NAME(3),
        ITEMS(2);

        int position;

        SaleComponents(int position) {
            this.position = position;
        }

        public int getPosition() {
            return position;
        }
    }

    @Override
    public Sale parse(String linha) {
        String[] elements = linha.split("ç");

        Long saleId = Long.valueOf(elements[SALES_ID.getPosition()]);
        String salesManName = elements[SALESMAN_NAME.getPosition()];
        List<Item> items = new ItemParser().parse(elements[ITEMS.getPosition()]);

        return new Sale(saleId, items, salesManName);
    }


}

package com.neto.desafio.domain.sale;

import java.math.BigDecimal;
import java.util.List;

public class Sale {

    private Long salesId;
    private List<Item> items;
    private String salesName;

    public Sale(Long salesId, List<Item> items, String salesName) {
        this.salesId = salesId;
        this.items = items;
        this.salesName = salesName;
    }

    public List<Item> getItems() {
        return items;
    }

    public Long getSalesId() {
        return salesId;
    }

    public BigDecimal getTotoalSale() {
        return this.items.stream().map(Item::totalPrice).reduce(BigDecimal.ZERO,BigDecimal::add);
    }

    public String getSalesName() {
        return this.salesName;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "salesId=" + salesId +
                ", items=" + items +
                ", salesName='" + salesName + '\'' +
                ", totalSale = " + this.getTotoalSale() + '\'' +
                '}';
    }
}

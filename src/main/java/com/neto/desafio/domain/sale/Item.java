package com.neto.desafio.domain.sale;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Item {
    private Long id;
    private Integer quantity;
    private BigDecimal price;

    public Item(Long id, Integer quantity, BigDecimal price) {
        this.id = id;
        this.quantity = quantity;
        this.price = price;
    }

    public BigDecimal totalPrice(){
        return price.multiply(new BigDecimal(quantity));
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}

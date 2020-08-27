package com.neto.desafio.domain.report;

import com.neto.desafio.domain.customer.Customer;
import com.neto.desafio.domain.sale.Sale;
import com.neto.desafio.domain.salesman.SalesMan;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class Report {

    Set<SalesMan> salesMans;
    Set<Customer> customers;
    Set<Sale> sales;

    public Report() {
        sales = new HashSet<>();
        customers = new HashSet<>();
        salesMans = new HashSet<>();
    }

    public <T> void save(T element) {
        if (element instanceof Customer) {
            this.customers.add((Customer) element);
            return;
        }

        if (element instanceof SalesMan) {
            this.salesMans.add((SalesMan) element);
            return;
        }

        this.sales.add((Sale) element);
    }

    private String getNameOfWorstSalesMan() {
        Sale sale = this.sales.stream().min(Comparator.comparing(Sale::getTotoalSale)).orElseGet(null);
        return sale.getSalesName();
    }

    private Long getIdOfMoreExpensiveSale() {
        Sale sale = this.sales.stream().max(Comparator.comparing(Sale::getTotoalSale)).orElseGet(null);
        return sale.getSalesId();
    }

    private int getCountOfSalesMan() {
        return salesMans.size();
    }

    private int getCountCustomers() {
        return customers.size();
    }

    @Override
    public String toString() {
        return "\n Quantidade de clientes = " + getCountCustomers() +
                "\n Quantidade de vendedor = " + getCountOfSalesMan() +
                "\n ID da venda mais cara = " + getIdOfMoreExpensiveSale() +
                "\n O pior vendedor = " + getNameOfWorstSalesMan();
    }

}

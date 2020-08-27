package com.neto.desafio.parse;

public abstract class Parser<T> {

    public abstract T parse(String linha);
}

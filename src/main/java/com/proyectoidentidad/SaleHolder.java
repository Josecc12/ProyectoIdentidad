package com.proyectoidentidad;

public class SaleHolder {

    private SaleHistory sale;
    private final static SaleHolder INSTANCE = new SaleHolder();

    private SaleHolder() {}

    public static SaleHolder getInstance() {
        return INSTANCE;
    }

    public void setSale(SaleHistory u) {
        this.sale = u;
    }

    public SaleHistory getSale() {
        return this.sale;
    }

}

package com.proyectoidentidad;

public class ProductHolder {

    private Product product;
    private final static ProductHolder INSTANCE = new ProductHolder();

    private ProductHolder() {}

    public static ProductHolder getInstance() {
        return INSTANCE;
    }

    public void setProduct(Product u) {
        this.product = u;
    }

    public Product getProduct() {
        return this.product;
    }

}

package com.proyectoidentidad;

public class BuyHolder {
    private Buy buy;
    private final static BuyHolder INSTANCE = new BuyHolder();

    private BuyHolder() {}

    public static BuyHolder getInstance() {
        return INSTANCE;
    }

    public void setBuy(Buy u) {
        this.buy = u;
    }

    public Buy getBuy() {
        return this.buy;
    }
}

package com.proyectoidentidad;

public class ProviderHolder {

    private Provider provider;
    private final static ProviderHolder INSTANCE = new ProviderHolder();

    private ProviderHolder () {}

    public static ProviderHolder getInstance() {
        return INSTANCE;
    }

    public void setProvider(Provider u) {
        this.provider = u;
    }

    public Provider getProvider() {
        return this.provider;
    }
}

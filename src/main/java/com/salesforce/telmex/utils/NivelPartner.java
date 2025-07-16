package com.salesforce.telmex.utils;

public enum NivelPartner {
    Platino("Platino"),
    Oro("Oro"),
    Plata("Plata");

    private final String nivelPartner;

    NivelPartner(String nivelPartner) {
        this.nivelPartner = nivelPartner;
    }

    public String getNivelPartner() {
        return nivelPartner;
    }

    @Override
    public String toString() {
        return nivelPartner;
    }
}

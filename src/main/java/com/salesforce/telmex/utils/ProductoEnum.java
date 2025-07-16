package com.salesforce.telmex.utils;

public enum ProductoEnum {
    MONITOREO_INFINITUM("Monitoreo Infinitum"),
    RESPALDO_INFORMACION("Respaldo de Información");

    private final String producto;

    ProductoEnum(String producto) {
        this.producto = producto;
    }

    public String getProducto() {
        return producto;
    }

    @Override
    public String toString() {
        return producto;
    }
}

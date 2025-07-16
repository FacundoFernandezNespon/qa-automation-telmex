package com.salesforce.tesa.utils;

public enum TipoUser {
    PAM("PAM"),
    Partner("Partner");

    private final String nombreTipoUser;

    TipoUser(String nombreTipoUser) {
        this.nombreTipoUser = nombreTipoUser;
    }

    public String getNombreTipoUser() {
        return nombreTipoUser;
    }

    @Override
    public String toString() {
        return nombreTipoUser;
    }
}

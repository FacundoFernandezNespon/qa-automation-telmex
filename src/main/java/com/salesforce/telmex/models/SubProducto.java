package com.salesforce.telmex.models;

public class SubProducto {
    private String nombre;
    private String precio_platino;
    private String precio_oro;
    private String precio_plata;

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrecio_platino() {
        return precio_platino;
    }

    public void setPrecio_platino(String precio_platino) {
        this.precio_platino = precio_platino;
    }

    public String getPrecio_oro() {
        return precio_oro;
    }

    public void setPrecio_oro(String precio_oro) {
        this.precio_oro = precio_oro;
    }

    public String getPrecio_plata() {
        return precio_plata;
    }

    public void setPrecio_plata(String precio_plata) {
        this.precio_plata = precio_plata;
    }
}

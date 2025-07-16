package com.salesforce.telmex.utils;

import com.salesforce.telmex.models.Producto;
import com.salesforce.telmex.models.SubProducto;
import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class Contexto {

    private TipoUser tipoUser;
    private NivelPartner nivelPartner;
    private ProductoEnum producto;
    private Producto productoInfo;
    private SubProducto subproductoSeleccionado;

    public TipoUser getTipoUser() {
        return tipoUser;
    }

    public void setTipoUser(TipoUser tipoUser) {
        this.tipoUser = tipoUser;
    }

    public NivelPartner getNivelPartner() {
        return nivelPartner;
    }

    public void setNivelPartner(NivelPartner nivelPartner) {
        this.nivelPartner = nivelPartner;
    }

    public ProductoEnum getProducto() {
        return producto;
    }

    public void setProducto(ProductoEnum producto) {
        this.producto = producto;
    }

    public Producto getProductoInfo() {
        return productoInfo;
    }

    public void setProductoInfo(Producto productoInfo) {
        this.productoInfo = productoInfo;
    }

    public SubProducto getSubproductoSeleccionado() {
        return subproductoSeleccionado;
    }

    public void setSubproductoSeleccionado(SubProducto subproductoSeleccionado) {
        this.subproductoSeleccionado = subproductoSeleccionado;
    }
}


package com.salesforce.telmex.tasks;

import com.salesforce.telmex.interactions.EsperarInteraction;
import com.salesforce.telmex.interactions.HacerClickInteraction;
import com.salesforce.telmex.interactions.InsertarInteraction;
import com.salesforce.telmex.models.Producto;
import com.salesforce.telmex.models.SubProducto;
import com.salesforce.telmex.utils.Contexto;
import com.salesforce.telmex.utils.FechaUtil;
import com.salesforce.telmex.utils.JsonDataReader;
import com.salesforce.telmex.utils.ProductoEnum;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.time.Duration;

import static com.salesforce.telmex.userinterfaces.comunidad.AlertasPage.ALERTA_SUCCESS;
import static com.salesforce.telmex.userinterfaces.comunidad.CotizacionPage.*;
import static com.salesforce.telmex.userinterfaces.comunidad.ElementosComunesPage.BTN_CONTINUAR;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class CrearCotizacionTask implements Task {

    private final ProductoEnum productoEnum;
    private final Producto producto;
    private final Contexto contexto;

    public CrearCotizacionTask(Contexto contexto, ProductoEnum productoEnum, Producto producto) {
        this.productoEnum = productoEnum;
        this.producto = producto;
        this.contexto = contexto;
    }

    @Override
    @Step("{0} Se crea la cotizacion")
    public <T extends Actor> void performAs(T actor) {
        String nombreCotizacion = "Cotizacion Automatizada - " + producto.getNombre() + " " + FechaUtil.obtenerFechaActual();
        SubProducto sub = contexto.getSubproductoSeleccionado();

        actor.attemptsTo(
                InsertarInteraction.theValue(nombreCotizacion).into(INPUT_NOMBRE_COTIZACION).withOptions(60),
                HacerClickInteraction.on(BTN_CONTINUAR),
                EsperarInteraction.por(10000),
                InsertarInteraction.theValue(producto.getNombre()).into(BUSCAR_INPUT),
                WaitUntil.the(opcionBusquedaProducto(producto.getNombre()), isClickable()).forNoMoreThan(Duration.ofSeconds(60)),
                HacerClickInteraction.on(opcionBusquedaProducto(producto.getNombre())).withOptions(true),
                WaitUntil.the(botonAgregarProducto(producto.getNombre()), isVisible()).forNoMoreThan(Duration.ofSeconds(60)),
                HacerClickInteraction.on(botonAgregarProducto(producto.getNombre())),
                HacerClickInteraction.on(BTN_CONTINUAR),
                HacerClickInteraction.on(BTN_TRES_PUNTOS).withOptions(5000, true),
                HacerClickInteraction.on(BTN_CONFIGURAR),
                HacerClickInteraction.on(botonAgregarSubProducto(sub.getNombre())),
                WaitUntil.the(ALERTA_SUCCESS, isVisible()).forNoMoreThan(Duration.ofSeconds(60)),
                EsperarInteraction.por(10000),
                HacerClickInteraction.on(BTN_CLOSE_MODAL),
                HacerClickInteraction.on(BTN_CONTINUAR),
                EsperarInteraction.por(5000)
        );
    }


    public static CrearCotizacionTask crearCotizacionTask(Contexto contexto, String productoStr) throws Exception {
        ProductoEnum productoEnum = ProductoEnum.valueOf(productoStr);
        Producto producto = JsonDataReader.getProductoByNombre(productoEnum.toString());
        return new CrearCotizacionTask(contexto, productoEnum, producto);
    }
}


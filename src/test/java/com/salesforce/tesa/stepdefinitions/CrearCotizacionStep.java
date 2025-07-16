package com.salesforce.tesa.stepdefinitions;

import com.google.inject.Inject;
import com.salesforce.tesa.models.Producto;
import com.salesforce.tesa.models.SubProducto;
import com.salesforce.tesa.tasks.CrearCotizacionTask;
import com.salesforce.tesa.tasks.SeleccionarOportunidadTask;
import com.salesforce.tesa.tasks.SeleccionarCuentaTask;
import com.salesforce.tesa.tasks.VerificarPreciosTask;
import com.salesforce.tesa.utils.Contexto;
import com.salesforce.tesa.utils.JsonDataReader;
import com.salesforce.tesa.utils.NivelPartner;
import com.salesforce.tesa.utils.ProductoEnum;
import io.cucumber.java.es.*;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.time.Duration;

import static com.salesforce.tesa.userinterfaces.comunidad.CotizacionPage.BTN_DESCARGAR_PDF;
import static com.salesforce.tesa.userinterfaces.comunidad.CotizacionPage.FILE_PDF;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class CrearCotizacionStep {

    private final Contexto contexto;

    @Inject
    public CrearCotizacionStep(Contexto contexto) { this.contexto = contexto; }

    @Y("el usuario ingresa a la comunidad con Cuenta de nivel {string}")
    public void accedeALaComiunidadDesdeContacto(String nivel) {
        NivelPartner nivelPartner = NivelPartner.valueOf(nivel);
        contexto.setNivelPartner(nivelPartner);

        OnStage.theActorInTheSpotlight().attemptsTo(SeleccionarCuentaTask.seleccionarCuentaTask(nivel));
    }

    @Y("el usuario selecciona una oportunidad")
    public void seleccionaOportunidad() {
        OnStage.theActorInTheSpotlight().attemptsTo(SeleccionarOportunidadTask.seleccionarOportunidadTask());
    }

    @Y("el usuario crea una nueva cotizacion con producto {string} y subproducto {string}")
    public void creaNuevaCotizacion(String producto, String subProducto) throws Exception {
        ProductoEnum productoEnum = ProductoEnum.valueOf(producto);
        contexto.setProducto(productoEnum);

        // Obtenemos la info de los subproductos
        SubProducto subProductoInfo = JsonDataReader.getSubProductoByNombre(productoEnum.toString(), subProducto);

        // Guardamos la info de los subproductos en el contexto
        contexto.setSubproductoSeleccionado(subProductoInfo);

        OnStage.theActorInTheSpotlight().attemptsTo(CrearCotizacionTask.crearCotizacionTask(contexto, producto));
    }

    @Y("el usuario verifica precios en la pantalla de resumen")
    public void verificarPrecios() {
        OnStage.theActorInTheSpotlight().attemptsTo(VerificarPreciosTask.verificarPreciosTask(contexto, contexto.getNivelPartner()));
    }

    @Y("el usuario verifica que se ha creado el PDF")
    public void verificarResumen() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(BTN_DESCARGAR_PDF, isVisible()).forNoMoreThan(Duration.ofSeconds(60)),
                Ensure.that(BTN_DESCARGAR_PDF).isDisplayed(),
                Ensure.that(FILE_PDF).isDisplayed()
        );
    }
}

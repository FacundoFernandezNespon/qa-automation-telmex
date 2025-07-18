package com.salesforce.telmex.tasks;

import com.salesforce.telmex.interactions.HacerClickInteraction;
import com.salesforce.telmex.models.SubProducto;
import com.salesforce.telmex.questions.ObtenerTextoJs;
import com.salesforce.telmex.utils.Contexto;
import com.salesforce.telmex.utils.NivelPartner;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.ensure.Ensure;

import static com.salesforce.telmex.userinterfaces.comunidad.CotizacionPage.BTN_GENERAR_PDF;
import static com.salesforce.telmex.userinterfaces.comunidad.CotizacionPage.PRECIO_MENSUAL;
import static com.salesforce.telmex.userinterfaces.comunidad.ElementosComunesPage.BTN_CONTINUAR;

public class VerificarPreciosTask implements Task {

    private final Contexto contexto;
    private final NivelPartner nivelPartner;

    public VerificarPreciosTask(Contexto contexto, NivelPartner nivelPartner) {
        this.contexto = contexto;
        this.nivelPartner = nivelPartner;
    }

    @Override
    @Step("{0} Se verifican los precios segun el nivel del partner")
    public <T extends Actor> void performAs(T actor) {
        SubProducto sub = contexto.getSubproductoSeleccionado();

        switch (nivelPartner) {
            case Platino:
                actor.attemptsTo(Ensure.that(ObtenerTextoJs.obtenerTexto(PRECIO_MENSUAL)).isEqualTo("$ " + sub.getPrecio_platino()));
                break;
            case Oro:
                actor.attemptsTo(Ensure.that(ObtenerTextoJs.obtenerTexto(PRECIO_MENSUAL)).isEqualTo("$ " + sub.getPrecio_oro()));
                break;
            case Plata:
                actor.attemptsTo(Ensure.that(ObtenerTextoJs.obtenerTexto(PRECIO_MENSUAL)).isEqualTo("$ " + sub.getPrecio_plata()));
        }

        actor.attemptsTo(
                HacerClickInteraction.on(BTN_CONTINUAR),
                HacerClickInteraction.on(BTN_GENERAR_PDF)
        );
    }

    public static VerificarPreciosTask verificarPreciosTask(Contexto contexto, NivelPartner nivelPartner) {
        return Tasks.instrumented(VerificarPreciosTask.class, contexto, nivelPartner);
    }
}

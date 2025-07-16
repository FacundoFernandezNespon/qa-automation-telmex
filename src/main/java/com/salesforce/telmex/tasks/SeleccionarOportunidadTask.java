package com.salesforce.telmex.tasks;

import com.salesforce.telmex.interactions.HacerClickInteraction;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import static com.salesforce.telmex.userinterfaces.comunidad.HeaderPage.HEADER_OPORTUNIDADES;
import static com.salesforce.telmex.userinterfaces.comunidad.OportunidadPage.BUTTON_INICIAR_COTIZACION;
import static com.salesforce.telmex.userinterfaces.comunidad.OportunidadPage.OPORTUNIDAD_TABLA;

public class SeleccionarOportunidadTask implements Task {

    @Override
    @Step("{0} Se selecciona la Oportunidad en la Comunidad")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                HacerClickInteraction.on(HEADER_OPORTUNIDADES),
                HacerClickInteraction.on(OPORTUNIDAD_TABLA),
                HacerClickInteraction.on(BUTTON_INICIAR_COTIZACION)
        );
    }

    public static SeleccionarOportunidadTask seleccionarOportunidadTask() {
        return Tasks.instrumented(SeleccionarOportunidadTask.class);
    }
}

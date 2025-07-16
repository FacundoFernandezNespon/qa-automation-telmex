package com.salesforce.telmex.tasks;

import com.salesforce.telmex.interactions.HacerClickInteraction;
import com.salesforce.telmex.models.Cuenta;
import com.salesforce.telmex.utils.JsonDataReader;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import static com.salesforce.telmex.userinterfaces.crm.CuentaPage.*;

public class SeleccionarCuentaTask implements Task {

    private final String nivel;

    public SeleccionarCuentaTask(String nivel) {
        this.nivel = nivel;
    }

    @Override
    @Step("{0} Se selecciona la cuenta en CRM")
    public <T extends Actor> void performAs(T actor) {

        try {
            // Obtiene la cuenta con el nivel que enviamos
            Cuenta cuenta = JsonDataReader.getCuentaByNivel(nivel);

            actor.attemptsTo(
                    HacerClickInteraction.on(cuentaNombre(cuenta.getNombre())),
                    HacerClickInteraction.on(cuentaContacto(cuenta.getContacto())),
                    HacerClickInteraction.on(BUTTON_INICIAR_SESION_COMUNIDAD)
            );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static SeleccionarCuentaTask seleccionarCuentaTask(String cuenta) {
        return Tasks.instrumented(SeleccionarCuentaTask.class, cuenta);
    }
}

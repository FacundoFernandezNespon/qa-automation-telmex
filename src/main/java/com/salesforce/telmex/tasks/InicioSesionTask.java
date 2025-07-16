package com.salesforce.telmex.tasks;

import com.salesforce.telmex.interactions.HacerClickInteraction;
import com.salesforce.telmex.interactions.InsertarInteraction;
import com.salesforce.telmex.models.User;
import com.salesforce.telmex.utils.JsonDataReader;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import static com.salesforce.telmex.userinterfaces.InicioSesionPage.*;

public class InicioSesionTask implements Task {

    private final String rol;

    public InicioSesionTask(String rol) {
        this.rol = rol;
    }

    public static InicioSesionTask inicioSesionConRol(String rol) {
        return new InicioSesionTask(rol);
    }

    @Override
    @Step("{0} Login con credenciales validas")

    public <T extends Actor> void performAs(T actor) {

        try {
            // Obtiene el usuario con el rol que enviamos
            User user = JsonDataReader.getUserByRole(rol);

            // Hace el login
            actor.attemptsTo(
                    InsertarInteraction.theValue(user.getUsername()).into(INPUT_USER),
                    InsertarInteraction.theValue(user.getPassword()).into(INPUT_PSS),
                    HacerClickInteraction.on(BTN_INGRESO)
            );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static InicioSesionTask inicioSesion() {
        return Tasks.instrumented(InicioSesionTask.class);
    }
}

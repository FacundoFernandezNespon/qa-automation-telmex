package com.salesforce.tesa.stepdefinitions;

import com.google.inject.Inject;
import com.salesforce.telmex.tasks.InicioSesionTask;
import com.salesforce.telmex.utils.Constantes;
import com.salesforce.telmex.utils.Contexto;
import com.salesforce.telmex.utils.TipoUser;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.ensure.Ensure;

import static com.salesforce.telmex.userinterfaces.crm.ElementosComunesPage.BARRA_CERRAR_SESION;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class InicioSesionStep {

    private final Contexto contexto;

    @Inject
    public InicioSesionStep(Contexto contexto) {
        this.contexto = contexto;
    }

    @Cuando("el usuario inicia sesión como {string} en CRM")
    public void elUsuarioIniciaSesionEnCRMComo(String rol) {
        TipoUser user = TipoUser.valueOf(rol);
        contexto.setTipoUser(user);

        theActorInTheSpotlight().wasAbleTo(Open.url(Constantes.URL_DEMO));

        OnStage.theActorInTheSpotlight().attemptsTo(InicioSesionTask.inicioSesionConRol(rol));
    }

    @Cuando("el usuario inicia sesión como {string} en Comunidad")
    public void elUsuarioIniciaSesionEnComunidadComo(String rol) {
        TipoUser user = TipoUser.valueOf(rol);
        contexto.setTipoUser(user);

        theActorInTheSpotlight().wasAbleTo(Open.url(Constantes.URL_COMUNIDAD));

        OnStage.theActorInTheSpotlight().attemptsTo(InicioSesionTask.inicioSesionConRol(rol));
    }

    @Entonces("el usuario accede a CRM")
    public void accedeALaPaginaPrincipalDeCRM() {
        Ensure.that(BARRA_CERRAR_SESION).isDisplayed();
    }

    @Entonces("el usuario accede a Comunidad")
    public void accedeALaPaginaPrincipalDeLaComunidad() {
        Ensure.that(BARRA_CERRAR_SESION).isDisplayed();
    }

    @Dado("que el usuario {string} ha iniciado sesión")
    public void elUsuarioIniciaSesion(String rol) {
        elUsuarioIniciaSesionEnCRMComo(rol);
        accedeALaPaginaPrincipalDeCRM();
    }
}

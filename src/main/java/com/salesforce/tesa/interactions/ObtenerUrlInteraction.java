package com.salesforce.tesa.interactions;

import net.serenitybdd.markers.CanBeSilent;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;

public class ObtenerUrlInteraction implements Interaction, CanBeSilent {

    private final String key;

    public ObtenerUrlInteraction(String key) {
        this.key = key;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        WebDriver driver = BrowseTheWeb.as(actor).getDriver();

        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);
        actor.remember(key, currentUrl);

    }

    public static ObtenerUrlInteraction obtenerUrl(String key) {
        return Tasks.instrumented(ObtenerUrlInteraction.class, key);
    }

    @Override
    public boolean isSilent() {
        return true;
    }
}

package com.salesforce.tesa.interactions;

import net.serenitybdd.markers.IsHidden;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;

public class NavegarUrlInteraction implements Interaction, IsHidden {

    private final String url;

    public NavegarUrlInteraction(String url) {
        this.url = url;
    }

    @Override

    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.url(url)
        );
    }

    public static NavegarUrlInteraction navegarUrl(String url) {
        return Tasks.instrumented(NavegarUrlInteraction.class, url);
    }
}

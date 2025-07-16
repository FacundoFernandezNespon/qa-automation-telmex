package com.salesforce.telmex.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;

public class EsperarInteraction implements Interaction {

    private final int milliseconds;

    public EsperarInteraction(int milliseconds) {
        this.milliseconds = milliseconds;
    }

    public static EsperarInteraction por(int milliseconds) {
        return Tasks.instrumented(EsperarInteraction.class, milliseconds);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

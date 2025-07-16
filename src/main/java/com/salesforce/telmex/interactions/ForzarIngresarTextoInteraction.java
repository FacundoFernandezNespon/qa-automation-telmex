package com.salesforce.telmex.interactions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ForzarIngresarTextoInteraction implements Interaction {
    private final Target target;
    private final String texto;

    public ForzarIngresarTextoInteraction(Target target, String texto) {
        this.target = target;
        this.texto = texto;
    }

    public static Performable into(Target target, String texto) {
        return instrumented(ForzarIngresarTextoInteraction.class, target, texto);
    }

    @Override
    @Step("{0} enters #texto into #target")
    public <T extends Actor> void performAs(T actor) {
        Enter.theValue(texto).into(target.resolveFor(actor));
    }
}

package com.salesforce.telmex.interactions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.time.Duration;
import java.util.List;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class IngresarTextoElementosEncontradosInteraction implements Interaction {

    private final Target targetButton;
    private final Target targetInput;

    public IngresarTextoElementosEncontradosInteraction(Target targetButton, Target targetInput) {
        this.targetButton = targetButton;
        this.targetInput = targetInput;

    }

    public static IngresarTextoElementosEncontradosInteraction on(Target targetButton, Target targetInput) {
        return new IngresarTextoElementosEncontradosInteraction(targetButton, targetInput);
    }

    @Override
    @Step("{0} selects product and enters quantity in corresponding input fields")
    public <T extends Actor> void performAs(T actor) {
        List<WebElementFacade> elements = targetButton.resolveAllFor(actor);

        for (WebElementFacade element : elements) {
            actor.attemptsTo(
                    WaitUntil.the(targetButton, isClickable()).forNoMoreThan(Duration.ofSeconds(60)),
                    JavaScriptClick.on(element)
            );
            WebElementFacade inputElement = targetInput.resolveFor(actor);
            actor.attemptsTo(
                    WaitUntil.the(targetInput, isVisible()).forNoMoreThan(Duration.ofSeconds(60)),
                    Enter.theValue("1").into(inputElement)
            );
        }
    }
}

package com.salesforce.telmex.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.time.Duration;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;

public class InsertarInteraction implements Interaction {

    private final String value;
    private Target targetElement;
    private int waitSeconds;
    private boolean useSendKeys;

    public InsertarInteraction(String value) {
        this(value, null, 30, false);
    }

    public InsertarInteraction(String value, Target targetElement, int waitSeconds, boolean useSendKeys) {
        this.value = value;
        this.targetElement = targetElement;
        this.waitSeconds = waitSeconds;
        this.useSendKeys = useSendKeys;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            actor.attemptsTo(
                    Check.whether(targetElement.resolveFor(actor).isCurrentlyEnabled())
                            .otherwise(WaitUntil.the(targetElement, isEnabled()).forNoMoreThan(Duration.ofSeconds(waitSeconds))),

                    Check.whether(targetElement.resolveFor(actor).getValue().isEmpty())
                            .otherwise(Clear.field(targetElement)),

                    Check.whether(useSendKeys)
                            .andIfSo(SendKeys.of(value).into(targetElement))
                            .otherwise(Enter.theValue(value).into(targetElement))
            );
        } catch (Exception e) {
            throw new RuntimeException("Unexpected error during the value insertion in the element: " + targetElement, e);
        }
    }

    public static InsertarInteraction theValue(String value) {
        return new InsertarInteraction(value);
    }

    public InsertarInteraction into(Target targetElement) {
        this.targetElement = targetElement;
        return this;
    }

    public InsertarInteraction withOptions(int waitSeconds) {
        this.waitSeconds = waitSeconds;
        return this;
    }

    public InsertarInteraction withOptions(boolean useSendKeys) {
        this.useSendKeys = useSendKeys;
        return this;
    }

    public InsertarInteraction withOptions(int waitSeconds, boolean useSendKeys) {
        this.waitSeconds = waitSeconds;
        this.useSendKeys = useSendKeys;
        return this;
    }
}

package com.salesforce.tesa.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.targets.Target;

public class HacerScrollInteraction implements Interaction {

    private final Target targetElement;

    public HacerScrollInteraction(Target target) {
        this.targetElement = target;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            actor.attemptsTo(Scroll.to(targetElement));
        } catch (Exception e) {
            throw new RuntimeException("An unexpected error occurred while scrolling to the element: " + targetElement, e);
        }
    }

    public static HacerScrollInteraction to(Target target) {
        return new HacerScrollInteraction(target);
    }
}


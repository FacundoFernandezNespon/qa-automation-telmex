package com.salesforce.telmex.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.targets.Target;

import java.time.Duration;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class HacerClickInteraction implements Interaction {

    private final Target targetElement;
    private int waitSeconds;
    private boolean useJavaScriptClick;

    public HacerClickInteraction(Target targetElement, int waitSeconds, boolean useJavaScriptClick) {
        this.targetElement = targetElement;
        this.waitSeconds = waitSeconds;
        this.useJavaScriptClick = useJavaScriptClick;
    }

    public HacerClickInteraction(Target targetElement) {
        this(targetElement, 30, false);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            actor.attemptsTo(
                    Check.whether(targetElement.resolveFor(actor).isClickable())
                            .otherwise(WaitUntil.the(targetElement, isClickable()).forNoMoreThan(Duration.ofSeconds(waitSeconds))),

                    Check.whether(useJavaScriptClick)
                            .andIfSo(JavaScriptClick.on(targetElement))
                            .otherwise(Click.on(targetElement))
            );
        } catch (Exception e) {
            throw new RuntimeException("An unexpected error occurred while clicking the element: " + targetElement, e);
        }
    }

    public static HacerClickInteraction on(Target targetElement) {
        return new HacerClickInteraction(targetElement);
    }

    public HacerClickInteraction withOptions(int waitSeconds) {
        this.waitSeconds = waitSeconds;
        return this;
    }

    public HacerClickInteraction withOptions(boolean useJavaScriptClick) {
        this.useJavaScriptClick = useJavaScriptClick;
        return this;
    }

    public HacerClickInteraction withOptions(int waitSeconds, boolean useJavaScriptClick) {
        this.waitSeconds = waitSeconds;
        this.useJavaScriptClick = useJavaScriptClick;
        return this;
    }
}

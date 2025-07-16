package com.salesforce.telmex.interactions;

import net.serenitybdd.markers.CanBeSilent;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class NuevaPestanaInteraction implements Interaction, CanBeSilent {

    private String url;

    public NuevaPestanaInteraction(String url) {
        this.url = url;
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open('" + url + "', '_blank');");
    }

    public static NuevaPestanaInteraction nuevaPestana(String url) {
        return Tasks.instrumented(NuevaPestanaInteraction.class, url);
    }

    @Override
    public boolean isSilent() {
        return true;
    }
}

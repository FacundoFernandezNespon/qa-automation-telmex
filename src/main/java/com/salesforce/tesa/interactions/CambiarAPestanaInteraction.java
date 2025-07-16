package com.salesforce.tesa.interactions;

import net.serenitybdd.markers.CanBeSilent;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class CambiarAPestanaInteraction implements Interaction, CanBeSilent {

    private final int tabIndex;

    public CambiarAPestanaInteraction(int tabIndex) {
        this.tabIndex = tabIndex;
    }

    public static CambiarAPestanaInteraction withIndex(int tabIndex) {
        return Tasks.instrumented(CambiarAPestanaInteraction.class, tabIndex);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabIndex));
    }

    @Override
    public boolean isSilent() {
        return true;
    }
}
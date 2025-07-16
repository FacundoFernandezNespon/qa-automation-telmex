package com.salesforce.tesa.interactions;

import net.serenitybdd.markers.CanBeSilent;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class CerrarPestanaInteraction implements Interaction, CanBeSilent {

    private final int index;

    public CerrarPestanaInteraction(int index) {
        this.index = index;
    }

    public static CerrarPestanaInteraction enIndice(int index) {
        return Tasks.instrumented(CerrarPestanaInteraction.class, index);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        List<String> windows = new ArrayList<>(driver.getWindowHandles());

        if (index >= 0 && index < windows.size()) {
            driver.switchTo().window(windows.get(index));
            driver.close();
            if (windows.size() > 1) {
                int newIndex = (index == 0) ? 1 : 0;
                driver.switchTo().window(windows.get(newIndex));
            }
        } else {
            throw new IndexOutOfBoundsException("Índice de pestaña inválido: " + index);
        }
    }

    @Override
    public boolean isSilent() {
        return true;
    }

}

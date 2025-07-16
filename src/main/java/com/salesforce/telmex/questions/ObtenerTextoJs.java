package com.salesforce.telmex.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class ObtenerTextoJs implements Question<String> {

    private final Target target;

    public ObtenerTextoJs(Target target) {
        this.target = target;
    }

    @Override
    public String answeredBy(Actor actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        String texto = (String) jsExecutor.executeScript("return arguments[0].innerText;", target.resolveFor(actor));
        return texto.trim();
    }

    public static Question<String> obtenerTexto(Target target) {
        return new ObtenerTextoJs(target);
    }
}

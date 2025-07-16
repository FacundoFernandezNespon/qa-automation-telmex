package com.salesforce.telmex.userinterfaces.comunidad;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ElementosComunesPage {

    public static final Target BTN_CONTINUAR = Target.the("Boton Continuar")
            .located(By.xpath("(//span[@class='btnLabel' and normalize-space()='Continuar'])[1]"));
}

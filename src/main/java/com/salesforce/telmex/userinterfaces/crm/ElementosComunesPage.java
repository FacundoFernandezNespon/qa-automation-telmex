package com.salesforce.telmex.userinterfaces.crm;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ElementosComunesPage {
    public static final Target BARRA_CERRAR_SESION = Target.the("Barra superior para cerrar sesion")
            .located(By.xpath("//*[@id=\"oneHeader\"]/div[1]/div"));
}

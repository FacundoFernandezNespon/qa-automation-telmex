package com.salesforce.telmex.userinterfaces.comunidad;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HeaderPage {
    public static final Target HEADER_OPORTUNIDADES = Target.the("Pestaña Oportunidades")
            .located(By.xpath("//a[text()='Oportunidades']"));
}

package com.salesforce.tesa.userinterfaces.comunidad;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class AlertasPage {
    public static final Target ALERTA_SUCCESS = Target.the("Alerta Success")
            .located(By.xpath("//div[@class='slds-theme--success slds-notify--toast slds-notify slds-notify--toast forceToastMessage']"));
}
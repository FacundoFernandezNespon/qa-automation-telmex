package com.salesforce.tesa.userinterfaces.comunidad;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class OportunidadPage {
    public static final Target OPORTUNIDAD_TABLA = Target.the("Oportunidade Opcion")
            .located(By.xpath("(//th[@class='slds-cell-edit cellContainer'])[1]//a"));

    public static final Target BUTTON_INICIAR_COTIZACION = Target.the("Boton Iniciar Cotizacion")
            .located(By.xpath("(//vlocity_cmt-flex-card-state[@data-recordid='REC0'])[2]//span[contains(text(), 'Iniciar')]"));
}

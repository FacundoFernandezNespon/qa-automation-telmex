package com.salesforce.telmex.userinterfaces.crm;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CuentaPage {
    public static Target cuentaNombre(String cuenta) {
        return Target.the("Cuenta: " + cuenta)
                .located(By.xpath("//span[text()='"+ cuenta +"']"));
    }

    public static final Target CUENTA_CONTACTO = Target.the("Sección de aprobaciones")
            .located(By.xpath("//span[text()='Fernando Andrés Castillo Jiménez']"));

    public static Target cuentaContacto(String contacto) {
        return Target.the("Contacto: " + contacto)
                .located(By.xpath("//span[text()='" + contacto + "']"));
    }

    public static final Target BUTTON_INICIAR_SESION_COMUNIDAD = Target.the("Sección de aprobaciones")
            .located(By.xpath("//button[text()='Iniciar sesión en Experiencia como usuario']"));
}

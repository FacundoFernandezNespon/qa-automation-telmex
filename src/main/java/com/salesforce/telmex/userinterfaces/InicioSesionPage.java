package com.salesforce.telmex.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class InicioSesionPage {
    public static final Target INPUT_USER = Target.the("Campo de entrada de nombre de usuario")
            .located(By.id("username"));

    public static final Target INPUT_PSS = Target.the("Campo de entrada de contraseña")
            .located(By.id("password"));

    public static final Target BTN_INGRESO = Target.the("Botón de inicio de sesión")
            .located(By.id("Login"));
}
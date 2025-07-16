package com.salesforce.telmex.userinterfaces.comunidad;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CotizacionPage {
    public static final Target INPUT_NOMBRE_COTIZACION = Target.the("Campo Nombre de la cotizacion")
            .located(By.xpath("//vlocity_cmt-omniscript-text[@data-omni-key='CotizacionNombre']//input[contains(@class, 'vlocity-input slds-input')]"));

    public static final Target BUSCAR_INPUT = Target.the("Input Buscar")
            .located(By.xpath("//input[@placeholder='Buscar']"));

    public static Target opcionBusquedaProducto(String producto) {
        return Target.the("Resultado Busqueda de producto: " + producto)
                .located(By.xpath("//span[@title='En Productos - " + producto + "']"));
    }

    public static Target botonAgregarProducto(String producto) {
        return Target.the("Producto: " + producto)
                .located(By.xpath("//div[.//h3[normalize-space()='" + producto + "']]/following-sibling::div//span[text()='Agregar']"));
    }

    public static Target botonAgregarSubProducto(String subproducto) {
        return Target.the("Producto Hijo: " + subproducto)
                .located(By.xpath("//span[normalize-space()='" + subproducto + "']/ancestor::div[contains(@class, 'slds-grid slds-wrap slds-card slds-p-around_xx-small slds-m-right_small')]//button[.//span[normalize-space()='Agregar']]"));
    }

    public static final Target BTN_TRES_PUNTOS = Target.the("Boton 3 Puntos")
            .located(By.xpath("(//*[starts-with(@id, 'menubutton-id-')]/button/c-icon/span)[3]"));

    public static final Target BTN_CONFIGURAR = Target.the("Boton Configurar")
            .located(By.xpath("//a[@aria-label='Configurar']"));

    public static final Target BTN_CLOSE_MODAL = Target.the("Boton Cerrar Modal")
            .located(By.xpath("//div[@aria-label='Action']//button[@title='Close']"));

    public static final Target BTN_GENERAR_PDF = Target.the("Boton Generar PDF")
            .located(By.xpath("(//span[@aria-label='Generar PDF'])[1]"));

    public static final Target BTN_DESCARGAR_PDF = Target.the("Boton Descargar PDF")
            .located(By.xpath("//button[text()='DescargarPDF']"));

    public static final Target FILE_PDF = Target.the("Archivo PDF")
            .located(By.xpath("//iframe[@class='pdf_viewer']"));

    public static final Target PRECIO_MENSUAL = Target.the("Precio Mensual")
            .located(By.xpath("(//div[normalize-space(text())='Total Cargos Recurrentes Mensuales:']/ancestor::vlocity_cmt-block[1]//span[contains(@class, 'field-value')])[3]"));


}

package com.salesforce.tesa.interactions;

import net.serenitybdd.markers.IsHidden;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Upload;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.nio.file.Paths;
import java.time.Duration;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SubirArchivoInteraction implements Interaction, IsHidden {

    private final String filePath;
    private final Target fileInputTarget;

    public SubirArchivoInteraction(String filePath, Target fileInputTarget) {
        this.filePath = filePath;
        this.fileInputTarget = fileInputTarget;
    }

    public static SubirArchivoInteraction from(String filePath, Target fileInputTarget) {
        return Tasks.instrumented(SubirArchivoInteraction.class, filePath, fileInputTarget);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String fileNameWithExtension = Paths.get(filePath).getFileName().toString();

        String fileNameWithoutExtension = fileNameWithExtension.contains(".")
                ? fileNameWithExtension.substring(0, fileNameWithExtension.lastIndexOf('.'))
                : fileNameWithExtension;

        System.out.println("Nombre del archivo sin extensión: " + fileNameWithoutExtension);

        actor.attemptsTo(
                EsperarInteraction.por(3000),
                WaitUntil.the(fileInputTarget, isVisible()).forNoMoreThan(Duration.ofSeconds(60)),
                Upload.theFile(Paths.get(filePath)).to(fileInputTarget)
        );

        actor.remember("nombreArchivo", fileNameWithoutExtension);
    }
}


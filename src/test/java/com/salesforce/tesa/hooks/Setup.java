package com.salesforce.tesa.hooks;

import com.salesforce.tesa.utils.Contexto;
import io.cucumber.java.Before;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

public class Setup {
    private Contexto contexto;

    @Before
    public void setUp() {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActor("user");
        contexto = new Contexto();
    }

    public Contexto getContexto() {
        return contexto;
    }
}

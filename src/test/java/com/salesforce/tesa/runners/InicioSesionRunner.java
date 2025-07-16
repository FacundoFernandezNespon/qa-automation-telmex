package com.salesforce.tesa.runners;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.core.options.Constants.*;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("/features/authentication/inicio_sesion.feature")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "com.salesforce.tesa.stepdefinitions,com.salesforce.tesa.hooks")
@ConfigurationParameter(key = OBJECT_FACTORY_PROPERTY_NAME, value = "io.cucumber.guice.GuiceFactory")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "io.cucumber.core.plugin.SerenityReporterParallel,pretty,timeline:build/test-results/timeline")

public class InicioSesionRunner {
}

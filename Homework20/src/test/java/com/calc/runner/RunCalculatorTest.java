package com.calc.runner;

import io.cucumber.junit.platform.engine.Constants;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
//@ConfigurationParameter(key = Constants.FILTER_TAGS_PROPERTY_NAME, value = "@smoke")
@ConfigurationParameter(key = Constants.GLUE_PROPERTY_NAME, value = "com/calc/steps")
@ConfigurationParameter(key = Constants.PLUGIN_PROPERTY_NAME,
        value = "pretty,io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm,html:build/cucumber-report/report.html")
public class RunCalculatorTest {
}

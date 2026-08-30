package com.lesson.homework.runner;

import io.cucumber.junit.platform.engine.Constants;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
//@ConfigurationParameter(key = Constants.FILTER_TAGS_PROPERTY_NAME, value = "@smoke")
@ConfigurationParameter(key = Constants.GLUE_PROPERTY_NAME, value = "com.lesson.homework.steps")
@ConfigurationParameter(key = Constants.PLUGIN_PROPERTY_NAME,
        value = "pretty, html:build/cucumber-report/report.html")
public class RunHerokuappTest {
}

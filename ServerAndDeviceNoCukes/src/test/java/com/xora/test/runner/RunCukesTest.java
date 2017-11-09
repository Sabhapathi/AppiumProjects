package com.xora.test.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        features = "src\\test\\resources\\features",
        glue={"com.xora.test.stepDefinition"},
        dryRun = false
	,plugin = {"html:output"}
)

public class RunCukesTest extends AbstractTestNGCucumberTests {


}

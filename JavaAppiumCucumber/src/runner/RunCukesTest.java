package runner;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

@RunWith(Cucumber.class)
@CucumberOptions(
	features = "classpath:feature",
	//glue={"stepDefinition","utils"},
	dryRun = true
//	,plugin = {"html:output"}
	)

public class RunCukesTest {
	


}

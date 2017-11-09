package step_definitions;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources",plugin= {"pretty", "html:target/cucumber-html-reports", "json:target/cucumber-report.json"})
public class RunCukesTest {
}

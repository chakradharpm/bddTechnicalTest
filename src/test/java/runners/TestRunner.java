package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources",
        glue={"stepDefinitions"},
        plugin = {
        "pretty",
        "html:target/cucumber-components-html-report",
        "json:target/cucumber-components-report.json"
},
        strict = true
)
public class TestRunner {
}

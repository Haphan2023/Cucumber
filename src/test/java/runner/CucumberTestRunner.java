package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepDefination", "hooks"},
        monochrome = true,  //display step format in console
        plugin = {"pretty", "html:target/site/cucumber-report-default.html", "json:target/site/cucumber.json"},
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        tags = "@Form"
)

public class CucumberTestRunner extends AbstractTestNGCucumberTests {

}

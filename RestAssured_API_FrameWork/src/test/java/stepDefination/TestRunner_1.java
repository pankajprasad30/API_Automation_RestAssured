package stepDefination;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions
(
		features="src/test/java/resources/",
		glue = {"stepDefinition"},
//		tags="@Smoke",
		dryRun=false,
		monochrome=true,
		plugin= {"pretty","html:target/htmlReport/index.html", "json:target/cucumber.json"}
		
		
		
)

public class TestRunner_1 {

}

package cucumberEx;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
	@CucumberOptions
	(
			features="src\\test\\java\\cucumberEx\\",
			tags= "@Smoke",
			dryRun=false,
			monochrome=false,
			plugin= {"pretty","html:target/htmlReport/index.html"}
			
    )
	public class TestRunner 
	{

}

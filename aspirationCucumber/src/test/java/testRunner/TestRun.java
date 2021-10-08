package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features="src/test/resources/features/homePage.feature",
		glue="stepDefinitions"
		
		
		
		)
public class TestRun extends AbstractTestNGCucumberTests{

}

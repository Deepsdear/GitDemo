package cucmber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/cucumber", glue = "rahulshettyacademy.stepDefinitions", monochrome = true, plugin = {
		"html:target/cucumber.html" }) // give path of cucumber in features, monochrome= this will f=give result in
										// readable format, generate the report of html plugin
public class TestNGTestRunner extends AbstractTestNGCucumberTests {// AbstractTestNGCucumberTests= this is a parent
																	// class, it will provide all the capabilities what
																	// this parent class provide
	
	
	

}

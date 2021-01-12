package runner;

import org.junit.runner.RunWith;
import org.testng.annotations.AfterClass;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions(features = "E:\\SE Project\\Project\\Cucumber\\src\\main\\java\\features\\LogIn.feature" 
	, glue = {"stepDefinations"}
	, dryRun= false
	, monochrome = true
	, format= {"pretty", "html:Reports/HTML_Report", "junit:Reports/Junit_Report" }
	, strict = true
	, tags = {"@Test"}
			
		
		)

public class TestRunner {

	@AfterClass
	public static void writeExtentReport() {
		// Reporter.loadXMLConfig(new File("config/report.xml"));

	}

}

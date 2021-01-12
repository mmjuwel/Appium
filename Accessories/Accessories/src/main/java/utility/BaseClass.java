package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Configuration.Configure_Browser;
import Configuration.ERP_LogIn;

public class BaseClass {

	public static WebDriverWait wait;
	public static WebDriver driver;
	public ExtentReports report;
	public ExtentTest logger;

	public String projectPath = System.getProperty("user.dir");

	private Properties prop;
	private FileInputStream input;

	private String browser;
	private String environment;
	private String baseUrl;
	private String lg_userName;
	private String lg_passwprd;

	public BaseClass() {
		if(driver==null) {
		prop = new Properties();
		try {
			input = new FileInputStream(projectPath + "/Configurations/Configration.properties");
			prop.load(input);
		} catch (Exception e) {
			System.out.println("Unable to find Property File" + e.getMessage());
		}

		this.browser = prop.getProperty("browser");
		this.environment = prop.getProperty("environment");
		this.baseUrl = prop.getProperty("baseUrl");
		lg_userName = prop.getProperty("userName");
		lg_passwprd = prop.getProperty("passwprd");

		Configure_Browser Conf_browser = new Configure_Browser();
		this.driver = Conf_browser.config(browser);

		// Extent Report
		ExtentHtmlReporter extent = new ExtentHtmlReporter(
				projectPath + "\\Reports\\ExtentReport(" + Helper.GetCurrentTime() + ").html");
		extent.loadXMLConfig(projectPath + "/Configurations/extentReportConfiguration.xml");

		report = new ExtentReports();
		report.attachReporter(extent);
		 //Passing Environment information
		report.setSystemInfo("URL: ", baseUrl);
		report.setSystemInfo("Environment: ", environment);
		report.setSystemInfo("Login User: ", lg_userName);
		}
		
		
	}

	@BeforeTest()
	public void LogIn() throws Exception {
		ERP_LogIn login = new ERP_LogIn();

		if (environment.equals("testing")) {

			try {
				login.LogIn_Test_Env(driver, baseUrl, lg_userName, lg_passwprd);
			} catch (Exception e) {
				System.out.println("Unable to Log In into System" + e.getMessage());
			}
		}

		else if (environment.equals("development")) {
			String projectName = prop.getProperty("ProjectName");

			String OM = prop.getProperty("OM");
			String PM = prop.getProperty("PM");
			String PD = prop.getProperty("PD");
			String COM = prop.getProperty("COM");
			String INV = prop.getProperty("INV");

			if (projectName.equals("OM")) {
				login.LogIn_Local_Env(driver, OM);
			}
			if (projectName.equals("PM")) {
				login.LogIn_Local_Env(driver, PM);
			}
			if (projectName.equals("PD")) {
				login.LogIn_Local_Env(driver, PD);
			}
			if (projectName.equals("COM")) {
				login.LogIn_Local_Env(driver, COM);
			}
			if (projectName.equals("INV")) {
				login.LogIn_Local_Env(driver, INV);
			} else {
				System.out.println("Local Invironment Url Not Found");
			}
		}
	}

	/*@AfterMethod
	public void TearDown(ITestResult result) throws IOException {
	}

		if (ITestResult.FAILURE == result.getStatus()) {

			String screenshotPath = Helper.CaptureScreenshot(driver, result.getName()); // Capture Screenshot
			logger.log(Status.FAIL, "FAILED TEST CASE IS " + result.getName()); // to add name in extent report
			logger.log(Status.FAIL, "ERROR  LOG:  " + result.getThrowable()); // to add error/exception in extent
			logger.addScreenCaptureFromPath(screenshotPath); // adding screen shot
		} else if (ITestResult.SKIP == result.getStatus()) {
			logger.log(Status.SKIP, "SKIPPED TEST CASE IS: " + result.getName()); // to add name in extent report
		} else if (ITestResult.SUCCESS == result.getStatus()) {
			logger.log(Status.PASS, "PASSED TEST CASE IS: " + result.getName()); // to add name in extent report
		}
		report.flush();
	}*/

	
	@AfterTest
	public void CloseBrowser() {
		//driver.close();
		System.out.println("Test Completed");
	}

}

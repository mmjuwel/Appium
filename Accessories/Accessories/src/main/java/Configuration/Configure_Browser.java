package Configuration;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Configure_Browser {

	public String browser;

	String projectPath = System.getProperty("user.dir");
	public String driverPath = projectPath + "//Drivers//";

	public WebDriver config(String browser) {
		WebDriver driver = null;

		if (browser.contains("chrome")) {
			System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");
			driver = new ChromeDriver();
		}

		else if (browser.contains("headless")) {
			System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");
			ChromeOptions ChOption = new ChromeOptions();
			ChOption.addArguments("--headless", "--disable-gpu", "--disable-notifications", "--disable-infobars",
					"--window-size=1920,1080");
			ChOption.setPageLoadStrategy(PageLoadStrategy.NONE);
			driver = new ChromeDriver(ChOption);
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
		}

		else if (browser.contains("firefox")) {
			System.setProperty("webdriver.gecko.driver", driverPath + "geckodriver.exe");
			driver = new FirefoxDriver();
		}

		else if (browser.contains("ie")) {
			System.setProperty("webdriver.ie.driver", driverPath + "IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}

		return driver;
	}

}

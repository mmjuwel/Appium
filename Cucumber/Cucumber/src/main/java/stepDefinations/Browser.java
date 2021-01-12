package stepDefinations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Browser {
	
	public WebDriver driver;
	public WebDriverWait wait;
	
	String projectPath = System.getProperty("user.dir");
	public String driverPath = projectPath + "//Drivers//";
	
	Browser(){
		System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");
		this.driver = new ChromeDriver();
		
	}
}

package Master_Setup;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CareInfo {

	
	public String baseUrl;
	public String browser;
	public String driverPath;
	public WebDriver driver;
	

	@BeforeSuite
	// get data from Property file
	public void Configuration() throws IOException {
		Properties prop = new Properties();
		FileInputStream input = new FileInputStream("E:/SE Project/Acc_Erp_MasterSetup/src/Master_Setup/Configration.properties");
		prop.load(input);
		browser = prop.getProperty("browser");
		baseUrl = prop.getProperty("baseUrl");
		driverPath = prop.getProperty("driverPath");
	}

	@BeforeTest
	// select Browser from property file
	public void config() {

		if (browser.contains("chrome")) {
			System.setProperty("webdriver.chrome.driver", driverPath + "//chromedriver.exe");
			driver = new ChromeDriver();
		}

		else if (browser.contains("firefox")) {
			System.setProperty("webdriver.gecko.driver", driverPath + "//geckodriver.exe");
			driver = new FirefoxDriver();
		}

		else if (browser.contains("ie")) {
			System.setProperty("webdriver.internetexplorer.driver", driverPath + "//IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
	}
	
	
	@BeforeMethod
	public void LogIn() throws InterruptedException{
		driver.get(baseUrl);
		Thread.sleep(2000);

		WebElement userid = driver.findElement(By.id("userName"));
		userid.clear();
		userid.sendKeys("rotary");
		Thread.sleep(1000);
		
		WebElement password = driver.findElement(By.id("password"));
		password.clear();
		password.sendKeys("1234");
		Thread.sleep(1000);
		
		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement  button = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnLogIn")));
		button.click();
		driver.manage().window().maximize();
		
		
		//Navigate to care info 
		driver.findElement(By.cssSelector("#niMenu li:nth-child(1)  > a")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("100000843")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("100000404")).click();
		Thread.sleep(1000);
	}
	
	
	@Test(priority=0, dataProvider="getdata")
	// Test Care Instruction
	public void AddCareInfo(String inst, String srtname) throws InterruptedException{
		
		driver.findElement(By.cssSelector("#dropdown-menu100000404 > li:nth-child(1)")).click();
		Thread.sleep(1000);	
		
		WebElement ExtracareInstruction= driver.findElement(By.cssSelector("#Textarea1"));
		ExtracareInstruction.clear();
		ExtracareInstruction.sendKeys(inst);
		WebElement shortName= driver.findElement(By.cssSelector("#shortName > input"));
		shortName.clear();
		shortName.sendKeys(srtname);
		driver.findElement(By.cssSelector(" div.fl-row-box.p-r-5> form > div > div > button.btn.btn-success")).click();	
		
	}
	
	
	@Test(priority=1, dataProvider="getdata")
	// Test Extra Care Instruction
	public void AddExtraCareInfo(String inst, String srtname) throws InterruptedException{
		
		driver.findElement(By.cssSelector("#dropdown-menu100000404 > li:nth-child(2)")).click();
		Thread.sleep(1000);	
		
		WebElement ExtracareInstruction= driver.findElement(By.cssSelector("#Textarea1"));
		ExtracareInstruction.clear();
		ExtracareInstruction.sendKeys(inst);
		WebElement shortName= driver.findElement(By.cssSelector("#shortName > input"));
		shortName.clear();
		shortName.sendKeys(srtname);
		driver.findElement(By.cssSelector(" div.fl-row-box.p-r-5> form > div > div > button.btn.btn-success")).click();	
		
	}
	
	
	@Test(priority=2, dataProvider="getdata")
	// Additional Information
	public void AddAdditionalInfo(String inst, String srtname) throws InterruptedException{
		
		driver.findElement(By.cssSelector("#dropdown-menu100000404 > li:nth-child(3)")).click();
		Thread.sleep(1000);
		
		WebElement ExtracareInstruction= driver.findElement(By.cssSelector("#Textarea1"));
		ExtracareInstruction.clear();
		ExtracareInstruction.sendKeys(inst);
		WebElement shortName= driver.findElement(By.cssSelector("#shortName > input"));
		shortName.clear();
		shortName.sendKeys(srtname);
		driver.findElement(By.cssSelector(" div.fl-row-box.p-r-5> form > div > div > button.btn.btn-success")).click();	
		
	}
	
	/*    //used to execute test from a method for 3 pages
	@AfterMethod(dataProvider="getdata")
	public void AddItem(String inst, String srtname) throws InterruptedException{

		WebElement ExtracareInstruction= driver.findElement(By.cssSelector("#Textarea1"));
		ExtracareInstruction.clear();
		ExtracareInstruction.sendKeys(inst);
		WebElement shortName= driver.findElement(By.cssSelector("#shortName > input"));
		shortName.clear();
		shortName.sendKeys(srtname);
		driver.findElement(By.cssSelector(" div.fl-row-box.p-r-5> form > div > div > button.btn.btn-success")).click();	
		
	}   */
	
	
	@AfterTest
	// close Browser
	public void CloseBrowser(){
		driver.quit();
	}
	
	@DataProvider 
	//send data 
	public Object[][] getdata(){
		int i=3; // How may time test case will be run
		int j=2; // how many data will be provided
		Object [][] data = new Object[i][j];
		data[0][0]="Case instruction ABC4";
		data[0][1]="CABC4";
		data[1][0]="Case instruction ABC5";
		data[1][1]="CABC5";
		data[2][0]="Case instruction ABC6";
		data[2][1]="CABC6";
		
		return data;
		
	}
	
	// delete Item
	/*
	 @Test (priority=0)
	public void deleteCareInfo(){
		driver.findElement(By.cssSelector("tbody > tr:nth-child(1) > td.p-none > ul > li:nth-child(2) > a > i")).click();
		Thread.sleep(1000);	
		driver.findElement(By.id("btnOk")).click();
		
	}   */
	
	

}





























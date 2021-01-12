package Order_Managenent;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Configuration.Configure_Browser;
import Configuration.ERP_LogIn;
import utility.ExcelDataProvider;

public class OrderSourcingPlan {

	
	
	String projectPath = System.getProperty("user.dir");
	String excelPath =projectPath+"\\Excel_Data\\CreateOrder.xlsx";                 
	String sheetName = "SourcingOrder";

	public WebDriverWait wait;
	public WebDriver driver;	
	public String baseUrl;
	public String browser;
	public String lg_userName;
	public String lg_passwprd;


	OrderSourcingPlan() throws  Exception{
		
		Properties prop = new Properties();
		FileInputStream input = new FileInputStream(projectPath+"/src/Master_Setup/Configration.properties");
		prop.load(input);
		browser= prop.getProperty("browser");
		baseUrl = prop.getProperty("baseUrl");
		lg_userName = prop.getProperty("userName");
		lg_passwprd = prop.getProperty("passwprd");

		Configure_Browser Conf_browser= new Configure_Browser();
		driver = Conf_browser.config(browser);
	}
	
	
	@BeforeTest ()
	public void NavigateToOrderSourcing() throws InterruptedException{
		wait = new WebDriverWait(driver, 10);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		
		ERP_LogIn login = new ERP_LogIn();
		login.LogIn_Test_Env(driver, baseUrl, lg_userName, lg_passwprd);
		
		//nevigate to OIrder Sourcing
		WebElement accessoris = driver.findElement(By.cssSelector("#niMenu li:nth-child(1)  > a"));
		accessoris.click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		WebElement  ProdManag = driver.findElement(By.id("100000353"));
		ProdManag.click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		WebElement OrderSourcing =driver.findElement(By.id("100002086"));
		OrderSourcing.click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		WebElement OrderSourcingPlan =driver.findElement(By.cssSelector("#dropdown-menu100002086 > li:nth-child(1) > a"));
		OrderSourcingPlan.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));

	}
	
	
	@Test(dataProvider="OrderSourcing")
	public void OrderSourcing(String Orderno, String plan) throws InterruptedException{
		wait = new WebDriverWait(driver, 10);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		
		/*
		WebElement SearchCust= driver.findElement(By.cssSelector("div.panel-body > div > div:nth-child(1) > div:nth-child(1) > div > div > button"));
		SearchCust.click();
		driver.findElement(By.cssSelector("div.panel-body > div > div:nth-child(1) > div:nth-child(1) > div > div > div > ul > li> input")).sendKeys(cust);
		driver.findElement(By.cssSelector(" div:nth-child(1) >div:nth-child(1) > div > div > div > ul > li> div > label > input")).click();
		driver.findElement(By.cssSelector("div > div:nth-child(1) > div.form-group.m-b-none > label")).click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		
		WebElement Searchbuyer= driver.findElement(By.cssSelector("div.panel-body > div > div:nth-child(1) > div:nth-child(2) > div > div > button "));
		Searchbuyer.click();
		driver.findElement(By.cssSelector("div.panel-body > div > div:nth-child(1) > div:nth-child(2) > div > div > div > ul > li> input")).sendKeys(buyer);
		driver.findElement(By.cssSelector(" div:nth-child(1) > div.m-b-none > div > div > div > ul > li > div > label > input")).click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		*/
		
		WebElement SearchOrderNo= driver.findElement(By.cssSelector("div.panel-body > div > div:nth-child(2) > div:nth-child(1) > div > div > button "));
		SearchOrderNo.click();
		WebElement enterOrderNo= driver.findElement(By.cssSelector("div.panel-body > div > div:nth-child(2) > div:nth-child(1) > div > div > div > ul > li> input"));
		enterOrderNo.clear();
		enterOrderNo.sendKeys(Orderno);
		
		driver.findElement(By.cssSelector("div:nth-child(2) >div:nth-child(1) > div > div > div > ul > li> div > label > input")).click();
		driver.findElement(By.cssSelector("div > div:nth-child(1) > div.form-group.m-b-none > label")).click();
		driver.findElement(By.cssSelector("button.btn-primary")).click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));

		WebElement selectOrder= driver.findElement(By.cssSelector("tbody > tr > td.p-none > ul > li > a"));
		selectOrder.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		if (plan.equals("Booking")) {
			driver.findElement(By.cssSelector("div > div > div> div > div:nth-child(1) > label > span")).click();
		}
		if (plan.equals("Full Production")) {
			driver.findElement(By.cssSelector("div > div.row.ng-scope > div > div > div.row > div > div:nth-child(2) > label > span")).click();
		}
		if (plan.equals("Purchase")) {
			driver.findElement(By.cssSelector("div > div > div> div > div:nth-child(3) > label > span")).click();
		}
		WebElement save= driver.findElement(By.cssSelector("div > div > div > div > div > button.btn.btn-success"));
		save.click();
		Thread.sleep(1000);

		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		WebElement closepage= driver.findElement(By.cssSelector("#orderDistriState_ResolvedPage > div > div > ul >li:nth-child(1) > i"));
		closepage.click();
		WebElement resetSearch= driver.findElement(By.cssSelector("div > div > div > div > div > button.btn.btn-danger"));
		resetSearch.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
	}
	
	@AfterTest
	public void CloseBrowser(){
		driver.quit();
	}
	
	
	@DataProvider(name="OrderSourcing")
	public Object[][] getData() throws Exception{
		Object data[][]= ExcelDataProvider.getDataFromExcel(excelPath, sheetName);
		return data;
	}
}

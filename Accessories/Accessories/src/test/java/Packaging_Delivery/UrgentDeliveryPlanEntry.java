package Packaging_Delivery;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Configuration.Configure_Browser;
import Configuration.ERP_LogIn;
import utility.ExcelDataProvider;

public class UrgentDeliveryPlanEntry {
	
		String projectPath = System.getProperty("user.dir");
		String excelPath =projectPath+"\\Excel_Data\\CreateOrder.xlsx";                 
		String sheetName = "UrgentPlan";

		public WebDriverWait wait;
		public WebDriver driver;	
		public String baseUrl;
		public String browser;
		public String lg_userName;
		public String lg_passwprd;


		UrgentDeliveryPlanEntry() throws  Exception{
			
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
		
		
		@BeforeTest
		public void NavigateToPackagingEntry() throws InterruptedException{
			wait = new WebDriverWait(driver, 10);
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
			
			ERP_LogIn login = new ERP_LogIn();
			login.LogIn_Test_Env(driver, baseUrl, lg_userName, lg_passwprd);
			wait = new WebDriverWait(driver, 10);
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS) ;
	        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
	    	WebElement accessoris = driver.findElement(By.cssSelector("#niMenu li:nth-child(1)  > a"));
			accessoris.click();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
			WebElement  LogisticManagement = driver.findElement(By.id("100000355"));
			LogisticManagement.click();
		
			
		}
		
		

		 @Test(dataProvider="UrgentPlan")
		 public void PackingEntry( String Priority) throws Exception{
				wait = new WebDriverWait(driver, 20);
				driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS) ;
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
				WebElement UrgentDeliveryPlan= driver.findElement(By.id("1000001143"));
				UrgentDeliveryPlan.click();
				Thread.sleep(4000);
				WebElement  OrderListButton = driver.findElement(By.cssSelector("div.col-md-12 > button"));
				OrderListButton.click();
				Thread.sleep(2000);
				WebElement  SelectOrderNo = driver.findElement(By.cssSelector(" tr:nth-child(1) > td.text-center.p-none > label > input"));
				SelectOrderNo.click();
				Thread.sleep(2000);
				WebElement  ClickOkButton = driver.findElement(By.cssSelector("div:nth-child(2) > div > div > div.panel-body > div > div > div.btn-group.pull-right > button"));
				ClickOkButton.click();
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
				driver.findElement(By.cssSelector("div:nth-child(15) > div > select")).sendKeys(Priority);
				WebElement ClickSaveButton = driver.findElement(By.cssSelector("div.col-md-9 > div > button.btn.btn-success"));
				ClickSaveButton.click();
				Thread.sleep(3000);
				WebElement  CloseWindow = driver.findElement(By.cssSelector("div.wi-header-actions > ul > li:nth-child(1) > i"));
				CloseWindow.click();
				Thread.sleep(3000);
				
				
				
		

			}
		
			
			
			@AfterTest
			public void CloseBrowser(){
				driver.quit();
			}
		
			
			@DataProvider(name="UrgentPlan")
			public Object[][] getData() throws Exception{
				Object data[][]= ExcelDataProvider.getDataFromExcel(excelPath, sheetName);
				return data;
				
			}

		 }



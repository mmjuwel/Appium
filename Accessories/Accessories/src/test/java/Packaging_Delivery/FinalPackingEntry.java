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

public class FinalPackingEntry {
	
		String projectPath = System.getProperty("user.dir");
		String excelPath =projectPath+"\\Excel_Data\\CreateOrder.xlsx";                 
		String sheetName = "FPackEntry";

		public WebDriverWait wait;
		public WebDriver driver;	
		public String baseUrl;
		public String browser;
		public String lg_userName;
		public String lg_passwprd;


		FinalPackingEntry() throws  Exception{
			
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
		
		
		@Test
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
		
		
		
		 @Test(dataProvider="FPackEntry")
		 public void PackingEntry( String OrderNo) throws Exception{
				wait = new WebDriverWait(driver, 20);
				driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS) ;
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
				WebElement  FinalPackingMenu = driver.findElement(By.id("1000001124"));
				FinalPackingMenu.click();
				Thread.sleep(2000);
				WebElement FinalPackEntry = driver.findElement(By.cssSelector("#dropdown-menu1000001124 > li:nth-child(2) > a"));
				FinalPackEntry.click();
				Thread.sleep(2000);
				WebElement ReadyForPackingList = driver.findElement(By.cssSelector("div:nth-child(4) > div:nth-child(2) > div > button"));
				ReadyForPackingList.click();
				Thread.sleep(2000);
				
				WebElement ClickOnOrderNo = driver.findElement(By.cssSelector("div:nth-child(4) > div.form-group > div > div > button"));
				ClickOnOrderNo.click();
				Thread.sleep(1000);
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
				driver.findElement(By.cssSelector("div:nth-child(4) > div.form-group > div > div > div > ul > li.list-group-item.p-none > input")).sendKeys(OrderNo);
				driver.findElement(By.cssSelector("div:nth-child(4) > div.form-group > div > div > div > ul > li.list-group-item.mddl.ng-scope > div > label > input")).click();
				
				WebElement ClickOnCustomer = driver.findElement(By.cssSelector("div:nth-child(2) > div > div:nth-child(2) > div > div > div > button"));
				ClickOnCustomer.click();
				WebElement ClickOnSearch = driver.findElement(By.cssSelector("div:nth-child(4) > div.btn-group.pull-right > button.btn.btn-primary"));
				ClickOnSearch.click();
				Thread.sleep(2000);
				WebElement SelectOrderNo = driver.findElement(By.cssSelector("tbody > tr > td.p-none.text-center > div > label > input"));
				SelectOrderNo.click();
				Thread.sleep(1000);
				WebElement ClickOnOkButton = driver.findElement(By.cssSelector("div:nth-child(2) > div.btn-group.pull-right > button"));
				ClickOnOkButton.click();
				Thread.sleep(2000);
				WebElement ClickOnAction = driver.findElement(By.cssSelector("div:nth-child(29) > ul > li:nth-child(1) > div > label > input"));
				ClickOnAction.click();
				Thread.sleep(1000);
				WebElement CloseWindow = driver.findElement(By.cssSelector("div.wi-header-actions > ul > li:nth-child(1) > i"));
				CloseWindow.click();
				Thread.sleep(2000);
				WebElement ClosePopUp = driver.findElement(By.id("btnOk"));
				ClosePopUp.click();
				Thread.sleep(1000);
				//WebElement ClickSaveButton = driver.findElement(By.cssSelector("div.col-md-6 > div > button.btn.btn-success"));
				//ClickSaveButton.click();
				
				
				
				
		

			}
		
			
			
			@AfterTest
			public void CloseBrowser(){
				driver.quit();
			}
		
			
			@DataProvider(name="FPackEntry")
			public Object[][] getData() throws Exception{
				Object data[][]= ExcelDataProvider.getDataFromExcel(excelPath, sheetName);
				return data;
				
			}

		 }










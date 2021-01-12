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

public class LabEntry {
	
		String projectPath = System.getProperty("user.dir");
		String excelPath =projectPath+"\\Excel_Data\\CreateOrder.xlsx";                 
		String sheetName = "LabEntry";

		public WebDriverWait wait;
		public WebDriver driver;	
		public String baseUrl;
		public String browser;
		public String lg_userName;
		public String lg_passwprd;


		LabEntry() throws  Exception{
			
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
		
		
		@BeforeTest()
		public void NavigateToLabEntry() throws InterruptedException{
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
		 
		 @Test(dataProvider="LabEntry")
		 public void PackingEntry( String IssueNo, String LabStatus) throws Exception{
				wait = new WebDriverWait(driver, 20);
				driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS) ;
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
				WebElement  ManageInspection= driver.findElement(By.id("100000960"));
				ManageInspection.click();
				Thread.sleep(2000);
				
				WebElement OrderWiseLabEntry= driver.findElement(By.cssSelector("#dropdown-menu100000960 > li:nth-child(1) > a"));
				OrderWiseLabEntry.click();
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
				Thread.sleep(4000);
				
				WebElement ClickonIssueNo= driver.findElement(By.cssSelector("div:nth-child(1) > div > div > div > div > div:nth-child(3) > div > div > div > button"));
				ClickonIssueNo.click();
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
				
				//WebElement SearchIssueNo= driver.findElement(By.cssSelector("div:nth-child(3) > div > div > div > div > ul > li.list-group-item.p-none > input"));
				//SearchIssueNo.sendKeys(IssueNo);
				Thread.sleep(2000);
				driver.findElement(By.cssSelector("div:nth-child(3) > div > div > div > div > ul > li.list-group-item.p-none > input")).sendKeys(IssueNo);
				
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
				
				WebElement SelectCheckbox= driver.findElement(By.cssSelector("div:nth-child(3) > div > div > div > div > ul > li.list-group-item.mddl.ng-scope > div > label > input"));
				SelectCheckbox.click();
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
				
				WebElement ClickonBuyer= driver.findElement(By.cssSelector("div:nth-child(1) > div:nth-child(2) > div > div > button"));
				ClickonBuyer.click();
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
				
				WebElement ClickonSearchButton= driver.findElement(By.cssSelector("div:nth-child(4) > div.btn-group.pull-right > button.btn.btn-primary"));
				ClickonSearchButton.click();
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
				Thread.sleep(4000);
				Select Status= new Select(driver.findElement(By.cssSelector("div:nth-child(1) > div:nth-child(16) > div > select")));
				Status.selectByVisibleText(LabStatus);
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
				
				Thread.sleep(2000);
				WebElement Savebutton= driver.findElement(By.cssSelector("div:nth-child(2) > div > div > div > div.btn-group.pull-right > button.btn.btn-success"));
				Savebutton.click();
				
				Thread.sleep(2000);
				WebElement CloseWindow= driver.findElement(By.cssSelector("div.wi-header-actions > ul > li:nth-child(1)"));
				CloseWindow.click();
				
				
		

			}
		
			
			
			//@AfterTest
			//public void CloseBrowser(){
				//driver.quit();
			//}
		
			
			@DataProvider(name="LabEntry")
			public Object[][] getData() throws Exception{
				Object data[][]= ExcelDataProvider.getDataFromExcel(excelPath, sheetName);
				return data;
				
			}

		 }






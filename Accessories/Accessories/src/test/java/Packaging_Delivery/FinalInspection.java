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
public class FinalInspection {

	
	String projectPath = System.getProperty("user.dir");
	String excelPath =projectPath+"\\Excel_Data\\CreateOrder.xlsx";                 
	String sheetName = "FI";

	public WebDriverWait wait;
	public WebDriver driver;	
	public String baseUrl;
	public String browser;
	public String lg_userName;
	public String lg_passwprd;
	
	FinalInspection() throws Exception {

		Properties prop = new Properties();
		FileInputStream input = new FileInputStream(projectPath + "/src/Master_Setup/Configration.properties");
		prop.load(input);
		browser = prop.getProperty("browser");
		baseUrl = prop.getProperty("baseUrl");
		lg_userName = prop.getProperty("userName");
		lg_passwprd = prop.getProperty("passwprd");

		Configure_Browser Conf_browser = new Configure_Browser();
		driver = Conf_browser.config(browser);
	}

	
	
	@BeforeTest ()
	public void NavigateToFinalInspection() throws InterruptedException{
		wait = new WebDriverWait(driver, 10);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		
		ERP_LogIn login = new ERP_LogIn();
		login.LogIn_Test_Env(driver, baseUrl, lg_userName, lg_passwprd);
		
		//nevigate to Final Inspection
		WebElement accessoris = driver.findElement(By.id("100000197"));
		accessoris.click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		
		WebElement  QualityControl = driver.findElement(By.id("100000993"));
		QualityControl.click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		
		WebElement  FinalInspection = driver.findElement(By.id("100000975"));
		FinalInspection.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));

	}
	
	@Test(dataProvider="fi")
	public void EnterFinalInspection(String orderNo, String status) throws InterruptedException{
		wait = new WebDriverWait(driver, 10);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));

		
		WebElement SearchOrderNo= driver.findElement(By.cssSelector("div > div:nth-child(3) > div > div > div > button"));
		SearchOrderNo.click();
		WebElement InsertOrderNo= driver.findElement(By.cssSelector("div > div:nth-child(3) > div > div > div > div > ul > li > input"));
		InsertOrderNo.clear();
		InsertOrderNo.sendKeys(orderNo);
		Thread.sleep(1000);
		WebElement SearchItem= driver.findElement(By.cssSelector("div > div:nth-child(3) > div > div > div > div > ul > li > div > label > input"));
		SearchItem.click();
		WebElement SearchButton= driver.findElement(By.cssSelector("div > div:nth-child(4) > div > button.btn-primary"));
		SearchButton.click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		
		WebElement SelectOrder =driver.findElement(By.cssSelector("tbody > tr > td > div > label > input"));
		SelectOrder.click();
		
		WebElement OkButton= driver.findElement(By.cssSelector("form > div:nth-child(2) > div > div > div > div > button.btn-primary"));
		OkButton.click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		
		Select fiStatus= new Select(driver.findElement(By.cssSelector("div.ng-form-finalInspectionForm0 > div:nth-child(29) > div > select")));
		fiStatus.selectByVisibleText(status);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		
		WebElement saveButton=driver.findElement(By.cssSelector("form > div:nth-child(2) > div > div > div > div > button.btn-success"));
		saveButton.click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		
		WebElement ClosePage= driver.findElement(By.cssSelector("#FinalInspectionEntry_ResolvedPage > div > div > ul > li:nth-child(1) > i"));
		ClosePage.click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		Thread.sleep(1000);
		
		WebElement ResetSearchButton= driver.findElement(By.cssSelector("div > div:nth-child(4) > div > button.btn-danger"));
		ResetSearchButton.click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));

	}
	
	
	@AfterTest
	public void CloseBrowser(){
		//driver.quit();
	}
	
	
	@DataProvider(name="fi")
	public Object[][] getData() throws Exception{
		Object data[][]= ExcelDataProvider.getDataFromExcel(excelPath, sheetName);
		return data;
	}

}

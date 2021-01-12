package Master_Setup;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Configuration.Configure_Browser;
import Configuration.ERP_LogIn;
import utility.ExcelDataProvider;



public class VariableHeadEntry {

	String projectPath = System.getProperty("user.dir");
	String excelPath =projectPath+"\\Excel_Data\\variableHeadList.xlsx";                
	String sheetName = "variableHead";

	public WebDriverWait wait;
	public WebDriver driver;	
	public String baseUrl;
	public String browser;
	public String lg_userName;
	public String lg_passwprd;


	VariableHeadEntry() throws  Exception{
		
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
	
	

	@BeforeMethod
	public void NavigateToVariableHead() throws InterruptedException{
		wait = new WebDriverWait(driver, 10);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS) ;
		ERP_LogIn login = new ERP_LogIn();
		login.LogIn_Test_Env(driver, baseUrl, lg_userName, lg_passwprd);

	}



	@Test(dataProvider="variableHead")
	public void AddVariableHead(String buyer, String brand,String bic, String variableHead) throws InterruptedException, Exception{

		//Navigate to  BIC
		WebElement accessoris = driver.findElement(By.cssSelector("#niMenu li:nth-child(1)  > a"));
		accessoris.click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		WebElement  ipd = driver.findElement(By.id("100000843"));
		ipd.click();
		WebElement generalSettings =driver.findElement(By.id("100000867"));
		generalSettings.click();
		WebElement variableHeadEntry =driver.findElement(By.id("1000001054"));
		variableHeadEntry.click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));


		//insert data in Variable Header page 
		wait = new WebDriverWait(driver, 10);
		driver.findElement(By.cssSelector("form > div> div > div > div:nth-child(1) > div > a")).click();
		WebElement buyerName= driver.findElement(By.cssSelector("form > div> div > div > div:nth-child(1) > div > div > div.select2-search > input"));
		buyerName.sendKeys(buyer);
		driver.findElement(By.cssSelector(".ui-select-choices-row-inner > div:nth-child(1)")).click();

		driver.findElement(By.cssSelector("form > div> div > div > div:nth-child(2) > div > a")).click();
		WebElement brandName= driver.findElement(By.cssSelector("form > div> div > div > div:nth-child(2) > div > div > div.select2-search > input"));
		brandName.sendKeys(brand);
		driver.findElement(By.cssSelector(".ui-select-choices-row-inner > div:nth-child(1)")).click();

		driver.findElement(By.cssSelector("form > div> div > div > div:nth-child(3) > div > a")).click();
		WebElement bicName= driver.findElement(By.cssSelector("form > div> div > div > div:nth-child(3) > div > div > div.select2-search > input"));
		bicName.sendKeys(bic);
		driver.findElement(By.cssSelector(".ui-select-choices-row-inner > div:nth-child(1)")).click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));

		WebElement variableHeadName= driver.findElement(By.cssSelector("form > div > div > div > div:nth-child(6) > input"));
		variableHeadName.clear();
		variableHeadName.sendKeys(variableHead);
		driver.findElement(By.cssSelector("form > div:nth-child(1) > div > div >div:nth-child(7) >button.btn.btn-success")).click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		Thread.sleep(2);

		Assert.assertTrue(driver.getPageSource().contains(bic));

	}

	


	@DataProvider(name="variableHead")
	public Object[][] getData() throws Exception{


		//dataFromExcel exdata= new dataFromExcel();
		Object data[][]= ExcelDataProvider.getDataFromExcel(excelPath, sheetName);

		return data;

	}
	
	
	@AfterTest
	public void closeBrowser(){
		driver.quit();
	}




}

package Master_Setup;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Configuration.Configure_Browser;
import Configuration.ERP_LogIn;
import utility.ExcelDataProvider;

public class AddBICProcess {

	String projectPath = System.getProperty("user.dir");
	String excelPath =projectPath+"\\Excel_Data\\CreateBIC.xlsx";                 
	String sheetName = "BicProcess";

	public WebDriverWait wait;
	public WebDriver driver;	
	public String baseUrl;
	public String browser;
	public String lg_userName;
	public String lg_passwprd;


	AddBICProcess() throws  Exception{
		
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
	public void NavigateToBuyerItemCode() throws InterruptedException{
		wait = new WebDriverWait(driver, 10);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		
		ERP_LogIn login = new ERP_LogIn();
		login.LogIn_Test_Env(driver, baseUrl, lg_userName, lg_passwprd);
		

		WebElement accessoris = driver.findElement(By.cssSelector("#niMenu li:nth-child(1)  > a"));
		accessoris.click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		WebElement  ipd = driver.findElement(By.id("100000843"));
		ipd.click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		WebElement itemProcess =driver.findElement(By.id("100000803"));
		itemProcess.click();
		WebElement itemProcessEntry= driver.findElement(By.cssSelector("#dropdown-menu100000803 > li:nth-child(1) > a"));
		itemProcessEntry.click();
		Thread.sleep(1000);
	    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));

	}
	
	
	@Test(dataProvider="bicdetails")
   	public void BICProcessEntry(String buyer, String brand,String bic, String numPro, String proc1, String proc2, String proc3, String proc4) throws InterruptedException{
    	wait = new WebDriverWait(driver, 10);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS) ;

       wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
       
      WebElement SelectBuyer=  driver.findElement(By.cssSelector(" div.panel-body > div:nth-child(1) > div:nth-child(1) > div > div > div > select"));
      SelectBuyer.sendKeys(buyer);
       driver.findElement(By.cssSelector(" div.panel-body > div:nth-child(1) > div:nth-child(1) > div > div > div > select")).sendKeys(Keys.TAB);
       wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
       
       
      WebElement selectBrand=  driver.findElement(By.cssSelector(" form > div:nth-child(1) > div > div > div> div:nth-child(1) > div:nth-child(2) > div > div > div > select"));
      selectBrand.click();
      wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
      driver.findElement(By.cssSelector(" div > div:nth-child(1) > div:nth-child(2) > div > div > div > select")).sendKeys(brand);
       driver.findElement(By.cssSelector("div > div:nth-child(1) > div:nth-child(2) > div > div > div > select")).sendKeys(Keys.ENTER);
       wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
       

       //Select BIC
       driver.findElement(By.cssSelector(" div.panel-body > div:nth-child(2) > div > div > div > div > button:nth-child(1)")).click();
       Thread.sleep(1000);
       wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
       
       driver.findElement(By.xpath("//div[3]/div[2]/div/div[2]/div/div[2]/form/div[1]/div/div/div/div/div[2]/div[1]/div/div/select")).sendKeys(bic);
       driver.findElement(By.xpath("//div[3]/div[2]/div/div[2]/div/div[2]/form/div[1]/div/div/div/div/div[2]/div[1]/div/div/select")).sendKeys(Keys.ENTER);
       driver.findElement(By.cssSelector("div > div:nth-child(2) > div > button.btn.btn-primary")).click();
       wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
       
       WebElement selectBic= driver.findElement(By.cssSelector("tbody > tr > td> div > label > input"));
       selectBic.click();
       driver.findElement(By.cssSelector("div.fl-box> div > div > div > div > button.btn.btn-success")).click();
       wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
       
       
       //add Process
       int procnum= Integer.parseInt(numPro);
       String[] processArr = new String[4];
       
       
       processArr[0] = proc1;
       processArr[1] = proc2;
       processArr[2] = proc3;
       processArr[3] = proc4;
       
       
       
		int i;
		for (i = 0; i < procnum; i++) {
			WebElement SearchProcess = driver.findElement(
					By.cssSelector(" div:nth-child(2) > div > div > div> div > div > div > div> div > div > input"));
			SearchProcess.clear();
			SearchProcess.sendKeys(processArr[i]);
			WebElement addProcess = driver.findElement(By.cssSelector("table > tbody > tr:nth-child(1) > td.p-none > ul > li > a > i"));
			addProcess.click();

		}
       
       //need to click on save button
       driver.findElement(By.cssSelector("div > div > div > div > button.btn.btn-success")).click();
       wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
       WebElement AddNew= driver.findElement(By.cssSelector(" div > div > div > div > button.btn.btn-primary"));
       AddNew.click();
       wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));

       
       
       }
       
       
       
  
	@AfterMethod
	public void afterMethod() {

		//driver.quit();

	}
	
	
	@DataProvider(name="bicdetails")
	public Object[][] getData() throws Exception{
		Object data[][]= ExcelDataProvider.getDataFromExcel(excelPath, sheetName);
		return data;
	}
	
	
	
}

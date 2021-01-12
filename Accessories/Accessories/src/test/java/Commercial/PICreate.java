package Commercial;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

import java.awt.RenderingHints.Key;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.ClickAction;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Configuration.Configure_Browser;
import Configuration.ERP_LogIn;

public class PICreate {

	String projectPath = System.getProperty("user.dir");
	String excelPath =projectPath+"\\Excel_Data\\CreateBIC.xlsx";                 
	String sheetName = "BicProcess";

	public WebDriverWait wait;
	public WebDriver driver;	
	public String baseUrl;
	public String browser;
	public String lg_userName;
	public String lg_passwprd;


	PICreate() throws  Exception{
		
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
		
		wait = new WebDriverWait(driver, 10);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS) ;
       wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
       
    	WebElement accessoris = driver.findElement(By.cssSelector("#niMenu li:nth-child(1)  > a"));
		accessoris.click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		WebElement  finance = driver.findElement(By.id("100000862"));
		finance.click();
       wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		WebElement  CreditClt = driver.findElement(By.id("100000863"));
		CreditClt.click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
	}
	@BeforeMethod
	public void navigation (){
	
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		WebElement  managePI = driver.findElement(By.id("100000824"));
		managePI.click();
	}
	
    @Test(priority = 0, enabled=false)
    //@Test
    public void CreateProformaInvoice() throws InterruptedException{
    	
    	wait = new WebDriverWait(driver, 10);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS) ;
       wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
    
		WebElement  createPi = driver.findElement(By.cssSelector("#dropdown-menu100000824 > li:nth-child(1) > a"));
		createPi.click();
		Thread.sleep(1000);
	     wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));

    	
    	// Select Customer
    	driver.findElement(By.cssSelector("div:nth-child(1) > div > div > div > a ")).click();
    	driver.findElement(By.cssSelector("div:nth-child(1) > div > div> div > div > div.search-container.select2-search > input")).sendKeys("Ad");
    	driver.findElement(By.cssSelector(".ui-select-choices-row-inner > div:nth-child(1)")).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));

        //Select Buyer
        driver.findElement(By.cssSelector("div:nth-child(1) > div.col-md-6 > div > a")).click();
    	driver.findElement(By.cssSelector("div:nth-child(2) > div > div> div > div > div.search-container.select2-search > input")).sendKeys("Ad");
    	driver.findElement(By.cssSelector(".ui-select-choices-row-inner > div:nth-child(1)")).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));

        
        
    	//Select Beneficiary's Bank
        driver.findElement(By.cssSelector("div:nth-child(3) > div:nth-child(2) > div.col-md-6 > div > select")).sendKeys("Next IT Bank Limited");
        driver.findElement(By.cssSelector("div:nth-child(3) > div:nth-child(2) > div.col-md-6 > div > select")).sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));

        
        
        //Select Order
        driver.findElement(By.cssSelector("div > div:nth-child(4) > div:nth-child(1) > div > button")).click();
        Thread.sleep(1000);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
        WebElement modal = driver.findElement(By.cssSelector("div > div.modal-body >form"));                                                    
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
    	WebElement pick=modal.findElement(By.cssSelector("tbody > tr:nth-child(1) > td:nth-child(3) > div > label > input"));
    	pick.click();
    	driver.findElement(By.cssSelector("div > div.modal-body > form > div > div.btn-group.pull-right > button.btn.btn-primary")).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));

    	
    	
    	//PI Currency
//    	driver.findElement(By.cssSelector("div.wi-body.ng-scope > form > div:nth-child(3) > div > div > div > div > div > div > div.panel-body.accordion-margin.p-none > div:nth-child(1) > div.col-md-9.p-r-5 > div > div > div > div > div:nth-child(2) > div > div > div > div:nth-child(2) > div:nth-child(1) > div > div > div > select")).click();
//    	driver.findElement(By.cssSelector("div.wi-body.ng-scope > form > div:nth-child(3) > div > div > div > div > div > div > div.panel-body.accordion-margin.p-none > div:nth-child(1) > div.col-md-9.p-r-5 > div > div > div > div > div:nth-child(2) > div > div > div > div:nth-child(2) > div:nth-child(1) > div > div > div > select")).sendKeys("Aus");
//    	driver.findElement(By.cssSelector("div.wi-body.ng-scope > form > div:nth-child(3) > div > div > div > div > div > div > div.panel-body.accordion-margin.p-none > div:nth-child(1) > div.col-md-9.p-r-5 > div > div > div > div > div:nth-child(2) > div > div > div > div:nth-child(2) > div:nth-child(1) > div > div > div > select")).sendKeys(Keys.DOWN);
//    	driver.findElement(By.cssSelector("div.wi-body.ng-scope > form > div:nth-child(3) > div > div > div > div > div > div > div.panel-body.accordion-margin.p-none > div:nth-child(1) > div.col-md-9.p-r-5 > div > div > div > div > div:nth-child(2) > div > div > div > div:nth-child(2) > div:nth-child(1) > div > div > div > select")).sendKeys(Keys.TAB);
//    	Thread.sleep(1000);
//    	driver.findElement(By.cssSelector("div.wi-body.ng-scope > form > div:nth-child(3) > div > div > div > div > div > div > div.panel-body.accordion-margin.p-none > div:nth-child(1) > div.col-md-9.p-r-5 > div > div > div > div > div:nth-child(2) > div > div > div > div:nth-child(1) > div:nth-child(2) > div > div > input")).sendKeys("64");
//    	driver.findElement(By.cssSelector("div.wi-body.ng-scope > form > div:nth-child(3) > div > div > div > div > div > div > div.panel-body.accordion-margin.p-none > div:nth-child(1) > div.col-md-3.fl-row-box > div > div.panel-body > div:nth-child(5) > div > input")).click();
//    	
    	// Save the PI
    	
    	driver.findElement(By.cssSelector(" div > div > div > div > div.col-md-6 > div > button:nth-child(2)")).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
        WebElement AddNew=  driver.findElement(By.cssSelector("div > div > div > div > div.col-md-6 > div > button:nth-child(1)"));
        AddNew.click();
       
       WebElement closepage=driver.findElement(By.cssSelector(" div.wi-header-actions > ul > li:nth-child(1) > i"));
       closepage.click();
       
    	
    }

    
    //@Test
    @Test(priority = 1)
    public void PISubmission() throws InterruptedException{
		wait = new WebDriverWait(driver, 10);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));

		WebElement createPi = driver.findElement(By.cssSelector("#dropdown-menu100000824 > li:nth-child(3) > a"));
		createPi.click();
		Thread.sleep(1000);
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		//search PI by Order
		WebElement firndOrder = driver.findElement(By.cssSelector(" form> div > div > div > div > div:nth-child(1) > div:nth-child(2) > div > div > div > button"));
		firndOrder.click();
		WebElement orderNo= driver.findElement(By.cssSelector("form > div > div > div > div > div:nth-child(1) > div:nth-child(2) > div > div > div > div > ul > li> input"));
		orderNo.clear();
		orderNo.sendKeys("AD");
		driver.findElement(By.cssSelector(" div:nth-child(2) > div > div > div > div > ul > li > div > label > input")).click();
		driver.findElement(By.cssSelector("div:nth-child(2) > div:nth-child(3) > div > button.btn.btn-primary")).click();
		
		
		driver.findElement(By.cssSelector("tbody > tr > td.p-none > div > label > input")).click();
		driver.findElement(By.cssSelector("div.row.m-t > div > div > button.btn.btn-success")).click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));

		
    	// Enter the value of field
		WebElement modOfSub= driver.findElement(By.cssSelector("form > div:nth-child(3) > div > div > div > div > div:nth-child(1) > div:nth-child(1) > div > div > button"));
		modOfSub.click();
		WebElement entermode= driver.findElement(By.cssSelector("form > div:nth-child(3) > div > div > div > div > div:nth-child(1) > div:nth-child(1) > div > div > div > ul > li > input"));
		entermode.clear();
		entermode.sendKeys("EMail");
		driver.findElement(By.cssSelector("form > div:nth-child(3) > div > div > div > div > div:nth-child(1) > div:nth-child(1) > div > div > div > ul > li > div > label > input")).click();
		
		WebElement ReceivedBy= driver.findElement(By.cssSelector("form > div:nth-child(3) > div > div > div > div > div:nth-child(2) > div:nth-child(1) > div > div > select"));
		ReceivedBy.click();
		ReceivedBy.sendKeys("Abdur Rouf");
		ReceivedBy.sendKeys(Keys.ENTER);
		
		WebElement Acknowledge = driver.findElement(By.cssSelector("form > div:nth-child(3) > div > div > div > div > div:nth-child(3) > div:nth-child(1) > div > div > select"));
		Acknowledge .sendKeys("Abdur Rouf");
		Acknowledge .sendKeys(Keys.ENTER);
		WebElement ModeOFAcknowledge = driver.findElement(By.cssSelector("form > div:nth-child(3) > div > div > div > div > div:nth-child(3) > div:nth-child(2) > div > div > select"));
		ModeOFAcknowledge .sendKeys("EMail");
		ModeOFAcknowledge .sendKeys(Keys.ENTER);
		
		WebElement SubmittedBy = driver.findElement(By.cssSelector("form > div:nth-child(3) > div > div > div > div > div:nth-child(1) > div:nth-child(2) > div > div > select"));
		SubmittedBy .sendKeys("Masud");
		SubmittedBy .sendKeys(Keys.ENTER);
		
		WebElement Submittedto = driver.findElement(By.cssSelector("form > div:nth-child(3) > div > div > div > div > div:nth-child(1) > div:nth-child(3) > div > div > select"));
		Submittedto .sendKeys("Abdur Rouf");
		Submittedto .sendKeys(Keys.ENTER);
		
		WebElement RcvTime = (driver.findElement(By.cssSelector("div:nth-child(2) > div:nth-child(2) > div:nth-child(3) > div > div > button > span")));
		RcvTime.click();
		driver.findElement(By.cssSelector("#a_2")).click();

		WebElement AcwTime = (driver.findElement(By.cssSelector("div:nth-child(2) > div:nth-child(3) > div:nth-child(3) > div > div > input:nth-child(1)")));
		AcwTime.sendKeys("3");
		// driver.findElement(By.cssSelector("#a_4")).click();
		

  
    	//Click on save button
    	driver.findElement(By.cssSelector("div > div.col-md-6 > div > button.btn.btn-success")).click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));

		 WebElement closepage=driver.findElement(By.cssSelector(" #piSubmitState > div.wi-header.ui-draggable-handle > div.wi-header-actions > ul > li:nth-child(1) > i"));
	       closepage.click();
	       Thread.sleep(1000);
	       closepage.click();
    	
	}
      
    
	@AfterTest
	public void afterMethod(){
		
	//driver.quit();
    	
    
    }
}

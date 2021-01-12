
package Master_Setup;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class ItemDescription {
	
	public String baseUrl;
	public String browser;
	public String driverPath;
	public WebDriver driver;
	

	@BeforeSuite
	// get data from Property file
	public void Configuration() throws IOException {
		Properties prop = new Properties();
		FileInputStream input = new FileInputStream("E://SE Project//Acc_Erp_MasterSetup//src//Master_Setup//Configration.properties");
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
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement  button = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnLogIn")));
		button.click();
		driver.manage().window().maximize();
		Thread.sleep(3000);

		
		//Navigate to Item Description 
		WebElement masterSettings= driver.findElement(By.id("100000198"));
		masterSettings.click();
		Thread.sleep(1000);
		WebElement item = driver.findElement(By.id("100000525"));
		item.click();
		Thread.sleep(1000);
	
	}
	
	
	//Add Item General Description 
	@Test(priority=0, dataProvider="getdata", enabled = false)
	public void AddGeneralDescription(String item, String desc) throws InterruptedException{
		Actions action = new Actions(driver);
		WebElement ItemStructure = driver.findElement(By.cssSelector("#dropdown-menu100000525 > li:nth-child(1) > a"));
		action.moveToElement(ItemStructure).build().perform();
		Thread.sleep(1000);
		WebElement genDis = driver.findElement(By.cssSelector("#dropdown-menu100000671 > li:nth-child(6) > a"));
		genDis.click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("form > div:nth-child(2) > div > div > span > button")).click();
		
		//search in modal 
		WebElement modal= driver.findElement(By.cssSelector(" div > div.modal-body >div.form-horizontal"));
		Select searchPeramtr= new Select(modal.findElement(By.cssSelector("div > div:nth-child(2) > div > select")));
		Thread.sleep(1000);
		searchPeramtr.selectByVisibleText("Item");
		modal.findElement(By.cssSelector("div > div:nth-child(3) > input")).sendKeys(item);
		Thread.sleep(1000);
		
		//select Item
		WebElement pick = driver.findElement(By.cssSelector(" div.modal-body > div.row.fl-box.fl-content-box"));
		if (driver.getPageSource().contains("tbody > tr > td.p-none > ul > li > a > i")) {
			pick.findElement(By.cssSelector("tbody > tr > td.p-none > ul > li > a > i")).click();
		} else {
			pick.findElement(By.cssSelector("tbody > tr:nth-child(1) > td.p-none > ul > li > a > i")).click();
		}
		
		WebElement description= driver.findElement(By.cssSelector("#Textarea1"));
		description.sendKeys(desc);
		driver.findElement(By.cssSelector(" form > div:nth-child(4) > div > div > button.btn.btn-success")).click();;
		
		//view all Item by Pagination
		Select page = new Select(driver.findElement(By.cssSelector(" div > select")));
		int allPage= page.getOptions().size();
		page.selectByIndex(allPage-1);

		//check weather is created data exist in the grid
		Assert.assertTrue(driver.getPageSource().contains(item));
		
		
	}
	
	
	//Add Item Custom Description 
		@Test(priority=1, dataProvider="getdata", enabled = false)
		public void AddCustomDescription(String item, String desc) throws InterruptedException{
			Actions action = new Actions(driver);
			WebElement ItemStructure = driver.findElement(By.cssSelector("#dropdown-menu100000525 > li:nth-child(1) > a"));
			action.moveToElement(ItemStructure).build().perform();
			Thread.sleep(1000);
			WebElement custDis = driver.findElement(By.cssSelector("#dropdown-menu100000671 > li:nth-child(7) > a"));
			custDis.click();
			Thread.sleep(1000);
			//driver.findElement(By.cssSelector("form > div:nth-child(2) > div > div > span > button")).click();
			
			Select selectitem= new Select(driver.findElement(By.cssSelector("form > div:nth-child(1) > div > div > select")));
			Thread.sleep(1000);
			selectitem.selectByVisibleText(item);
			Thread.sleep(1000);
			WebElement description= driver.findElement(By.cssSelector("#Textarea1"));
			description.sendKeys(desc);
			driver.findElement(By.cssSelector("form > div:nth-child(3) > div > div > button.btn.btn-success")).click();;

			//view all Item by Pagination
			Select page = new Select(driver.findElement(By.cssSelector(" div > ul > li:nth-child(2) > div > select")));
			int allPage= page.getOptions().size();
			page.selectByIndex(allPage-1);

			//check weather is created data exist in the grid
			driver.getPageSource().contains(item);
		}
	
		
		
		//delete Description
		@Test(priority=2, dataProvider="getdata", enabled = true)
		public void DeleteDescription(String item, String desc) throws InterruptedException{
			Actions action = new Actions(driver);
			WebElement ItemStructure = driver.findElement(By.cssSelector("#dropdown-menu100000525 > li:nth-child(1) > a"));
			action.moveToElement(ItemStructure).build().perform();
			WebElement custDis = driver.findElement(By.cssSelector("#dropdown-menu100000671 > li:nth-child(7) > a"));
			custDis.click();
			Thread.sleep(1000);
			
			//select row and Click on Delete Button 
			WebElement row=driver.findElement(By.xpath(".//td[text()[contains(.,"+item+")]]"));
			row.click();
			driver.findElement(By.cssSelector("tbody > tr.ng-scope.selected-row > td.p-none > ul > li:nth-child(2) > a > i")).click();
			Thread.sleep(1000);
			driver.findElement(By.cssSelector(" div.modal-content > div:nth-child(3) >div > button.btn-primary")).click();
			Thread.sleep(2000);

		}
		
	@DataProvider 
	//send data 
	public Object[][] getdata(){
		int i=3; // How may time test case will be run or How many Item's description will be added
		int j=2; // how many data will be provided
		Object [][] data = new Object[i][j];
		data[0][0]="Bow";
		data[0][1]="Description of Bow";
		data[1][0]="Tag";
		data[1][1]="Description of Tag";
		data[2][0]="Box";
		data[2][1]="Description of Box";
		
		return data;
		
	}
	
	
	
	@AfterTest
	public void CloseBrowser(){
		driver.quit();
	}
	
	
	
	
	
	

}

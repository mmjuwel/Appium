package stepDefinations;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class LogIn_StepsDef extends Browser{
	

	
	
	


	@Given("^User is in Landing page of ERP$")
	public void user_is_in_Landing_page_of_ERP() throws InterruptedException {

		
		driver.get("http://192.168.11.6:2001/");
		
			Thread.sleep(1000);
			wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));

		
	}

	@Then("^Insert Username (.*)$")
	public void insert_User_Name(String user)  {
	  WebElement username=  driver.findElement(By.id("userName"));
	  username.clear();
	  username.sendKeys(user);
	}

	@Then("^Insert Password (.*)$")
	public void insert_Password(String pass) {
	WebElement Pass= driver.findElement(By.id("password"));
	Pass.clear();
	Pass.sendKeys(pass);
	}

	@Then("^Click on Login Button$")
	public void click_on_Login_Button() throws InterruptedException  {
		Thread.sleep(2000);
		driver.findElement(By.id("btnLogIn")).click();
		
	
			Thread.sleep(1000);
			wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));

		
	}

	@Then("^Successfully Login and Get Home Page of ERP$")
	public void successfully_Login_and_Get_Home_Page_of_ERP()  {
		System.out.println("Welcome, You have successfully loggedin");
	  
	}
	

	
	
	
	
	
	
	@Given("^User is in Dashboard Page$")
	public void user_is_in_Dashboard_Page() throws Throwable {

		System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");
		this.driver = new ChromeDriver();
		System.out.println("Start Bank Regression Test");
	   
	}

	@Then("^Nevigate to Bank Entry Page$")
	public void nevigate_to_Bank_Entry_Page() throws Throwable {
		
		driver.findElement(By.cssSelector("#\\31 00000198 > a > span")).click();
		driver.findElement(By.id("100000784")).click();
		driver.findElement(By.cssSelector("#dropdown-menu100000784 > li:nth-child(1) > a")).click();
	    
		Thread.sleep(1000);
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));

	}

	@Then("^Insert Bank Name(.*)$")
	public void insert_Bank_Name(String BankName) throws Throwable {
	   driver.findElement(By.cssSelector("form > div > div:nth-child(1) > div > input")).sendKeys(BankName);
	}

	@Then("^Insert Bank Short Name(.*)$")
	public void insert_Bank_Short_Name(String BankShortName) throws Throwable {
	   driver.findElement(By.cssSelector(".ng-scope > form > div > div:nth-child(2) > div > input")).sendKeys(BankShortName);
	}

	@Then("^Click on Save Button$")
	public void click_on_Save_Button() throws Throwable {
		driver.findElement(By.cssSelector("button.btn.btn-save")).click();
		Thread.sleep(2000);
	   
	}

	

	
	@Then("^Close The browser$")
	public void close_The_browser() {
		
	    System.out.println("Hello world ");
	   driver.quit();
	}
	
	
	
	
	@Given("^two numberes (\\d+) and (\\d+)$")
	public void two_numberes_a_and_b(int a, int b) throws Throwable {
	    System.out.println(a);
	    System.out.println(a);
	    int  x=a+b;
		System.out.println("Sum="+x);
	}

	



	
	

}

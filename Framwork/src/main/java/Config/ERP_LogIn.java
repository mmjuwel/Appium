package Config;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ERP_LogIn {

	public WebDriverWait wait;

	public void LogIn_Test_Env(WebDriver driver, String baseUrl, String userName, String passwprd) throws InterruptedException {
		wait = new WebDriverWait(driver, 10);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		LogInPage loginPage = PageFactory.initElements(driver, LogInPage.class);
		
		driver.get(baseUrl);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		loginPage.InserUserName(userName);
		loginPage.InserPassword(passwprd);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		loginPage.PressLoginButton();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));

		driver.manage().window().maximize();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
	}

	public void LogIn_Local_Env(WebDriver driver, String baseUrl) throws Exception {
	
		driver.get(baseUrl);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		driver.manage().window().maximize();
	}

}

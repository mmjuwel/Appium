package Order_Managenent;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.Menu;
import pages.OM_OrderVerification;
import utility.BaseClass;
import utility.ExcelDataProvider;

@Listeners(utility.Listener.class)
public class StockOrderVarification extends BaseClass {
	
	Menu menu= PageFactory.initElements(driver,Menu.class );
	OM_OrderVerification OrderVerify = PageFactory.initElements(driver, OM_OrderVerification.class);
	// Used Same Page Factory Of Order Verification
	
	@BeforeTest
	public void NavigateToVerifyStockOrder() throws InterruptedException{
		wait = new WebDriverWait(driver, 10);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		menu.Accessory();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		menu.SupplyChainManagement();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		menu.StockOrder();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		menu.verifyStockOrder();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		Thread.sleep(1000);
	}
	
	
	
	@Test(enabled = true, dataProvider = "StockOrderVerify", groups = { "smoke", "regression" })
	public void VerifyOrder(String customer, String orderNo) throws Throwable {
		logger = report.createTest("Stock Order Verification");

		try {
			if (customer != "") {
				OrderVerify.SearchByCustomer(customer);
			}

			OrderVerify.SearchByOrderNo(orderNo);
			OrderVerify.ClickOnSearchbutton();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
			OrderVerify.SeleclectOrderForVerify();
			Thread.sleep(1000);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));

			OrderVerify.ClickOnVerifyButton();
			Thread.sleep(1000);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
			Thread.sleep(1000);
			Assert.assertTrue(OrderVerify.ConfirmVerification());

		} catch (InterruptedException e) {
			throw new AssertionError(" Stock Order could not be Verified. " + e);
		}
	}

	
	
	@DataProvider(name="StockOrderVerify")
	public Object[][] getData() throws Exception{
		String excelPath =projectPath+"\\Excel_Data\\StockOrderVerify.xlsx";                 
		String sheetName = "Verify";
		Object data[][]= ExcelDataProvider.getDataFromExcel(excelPath, sheetName);
		return data;
	}
	
	
	
}

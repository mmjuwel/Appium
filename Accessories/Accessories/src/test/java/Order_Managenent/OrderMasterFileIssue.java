package Order_Managenent;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestNGMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.Menu;
import pages.OM_OrderMasterFileIssue;
import utility.BaseClass;
import utility.ExcelDataProvider;

public class OrderMasterFileIssue extends BaseClass {

	Menu menu = PageFactory.initElements(driver, Menu.class);
	OM_OrderMasterFileIssue masterFile = PageFactory.initElements(driver, OM_OrderMasterFileIssue.class);

	@BeforeTest
	public void navigateToCreateOrder() throws InterruptedException {
		wait = new WebDriverWait(driver, 30);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		menu.Accessory();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		menu.ProductionManagement();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		menu.OrderMasterFileIssue();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
	}

	
	//Test Case 1
	@Test(enabled = false, dataProvider = "masterfileIssue", groups = { "regression" })
	public void PMReceiveFromCS(String customer, String orderNo, String bic) throws Throwable {
		//logger = report.createTest("Master File Receive by Production from CS");

		try {
			if (customer != "") {
				masterFile.SearchByCustomer(customer);
			}
			masterFile.SearchByOrderNo(orderNo);

			if (bic != "") {
				masterFile.SearchByBIC(bic);
			}

			masterFile.ClickOnSearchbutton();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
			Thread.sleep(1000);

			int we = masterFile.getTotalItem();
			for (int i = 0; i < we; i++) {
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
				masterFile.ProductionReceiveFromCS(i);
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
				Thread.sleep(100);
			}

			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
			Assert.assertTrue(masterFile.Confirm_ProductionReceiveFromCS(), " PM could rev from CS ");
			Thread.sleep(1000);

		} catch (InterruptedException e) {
			throw new AssertionError(" Production Receive From CS Test Case Faield. " + e);
		}
	}

	
	//Test Case 2
	@Test(enabled = true, dataProvider = "masterfileIssue", groups = { "regression" })
	public void DesignReceiveFromCS(String customer, String orderNo, String bic) throws Throwable {
		//logger = report.createTest("Master File Receive By Design");

		try {
			if (customer != "") {
				masterFile.SearchByCustomer(customer);
			}
			masterFile.SearchByOrderNo(orderNo);

			if (bic != "") {
				masterFile.SearchByBIC(bic);
			}

			masterFile.ClickOnSearchbutton();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
			Thread.sleep(1000);

			int we = masterFile.getTotalItem();
			for (int i = 0; i < we; i++) {
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
				masterFile.DesignReceiveFromCS(i);
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
				Thread.sleep(100);
			}

			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
			Assert.assertTrue(masterFile.Confirm_DesignReceiveFromCS(), "Design could rev from CS ");
			Thread.sleep(1000);
			
		} catch (InterruptedException e) {
			throw new AssertionError(" Design Receive From CS Test Case Faield", e);
		}
	}

	
	//Test Case 3
	@Test(enabled = false, dataProvider = "masterfileIssue", groups = { "regression" })
	public void PMReceiveFromDesign(String customer, String orderNo, String bic) throws Throwable {
		//logger = report.createTest("Master File Receive By Production from Design");

		try {
			if (customer != "") {
				masterFile.SearchByCustomer(customer);
			}
			masterFile.SearchByOrderNo(orderNo);

			if (bic != "") {
				masterFile.SearchByBIC(bic);
			}

			masterFile.ClickOnSearchbutton();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
			Thread.sleep(1000);

			int we = masterFile.getTotalItem();
			for (int i = 0; i < we; i++) {
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
				masterFile.ProductionReceiveFromDesign(i);
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
				Thread.sleep(100);
			}

			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
			Assert.assertTrue(masterFile.Confirm_ProductionReceiveFromDesign(), "PM could rev from Design ");
			Thread.sleep(1000);

		} catch (InterruptedException e) {
			throw new AssertionError(" Production Receive From Design Test Case Faield", e);
		}
	}

	@DataProvider(name = "masterfileIssue")
	public Object[][] getData(ITestNGMethod testCase) throws Exception {
		Object data[][] = null;
		String excelPath = projectPath + "/Excel_Data/OrdermasterFileIssue.xlsx";
		String sheetName = "MasterFileReceive";
		data = ExcelDataProvider.getDataFromExcel(excelPath, sheetName);
		return data;
	}

}

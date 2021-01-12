package Order_Managenent;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.Menu;
import pages.OM_OrderSourcing;
import utility.BaseClass;
import utility.ExcelDataProvider;

public class OrderSourcing extends BaseClass {

	Menu menu = PageFactory.initElements(driver, Menu.class);
	OM_OrderSourcing Sourcing = PageFactory.initElements(driver, OM_OrderSourcing.class);

	@BeforeTest
	public void navigateToCreateOrder() throws InterruptedException {
		wait = new WebDriverWait(driver, 30);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		menu.Accessory();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		menu.ProductionManagement();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		menu.OrderSourcing();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		menu.OrderSourcingPlan();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
	}

	

		// Test Case 1: 
		@Test(enabled = true, dataProvider = "OrderSourcing")
		public void OrderSourcingPlan (String OrderNo, String Plan) throws Exception {
			// logger = report.createTest("Create plan");
		
				wait = new WebDriverWait(driver, 20);
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
				Thread.sleep(1000);
				Sourcing.SelectOrderNo(OrderNo);
				Thread.sleep(1000);
				Sourcing.ClickSearchbutton();
				Thread.sleep(1000);
				Sourcing.SelectOrderItem();
				Sourcing.SelectSourcingType(Plan);
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
				Sourcing.ClickSavebutton();
				Thread.sleep(1000);
				Sourcing.ClickCloseWindow();
				Thread.sleep(2000);
				Sourcing.ClickReset();
			
			
		}

		@DataProvider(name = "OrderSourcing")
		public Object[][] getData() throws Exception {

			String excelPath = projectPath + "\\Excel_Data\\OrderSourcing.xlsx";
			String sheetName = "Sourcing";
			Object data[][] = ExcelDataProvider.getDataFromExcel(excelPath, sheetName);
			return data;

		}

	}

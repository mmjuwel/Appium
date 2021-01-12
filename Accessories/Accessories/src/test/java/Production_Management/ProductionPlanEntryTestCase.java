package Production_Management;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pages.Menu;
import pages.OM_ProductionPlanEntry;
import utility.BaseClass;
import utility.ExcelDataProvider;

@Listeners(utility.Listener.class)
public class ProductionPlanEntryTestCase extends BaseClass {
	Menu menu = PageFactory.initElements(driver, Menu.class);
	OM_ProductionPlanEntry plan = PageFactory.initElements(driver, OM_ProductionPlanEntry.class);

	@BeforeTest
	public void navigateToProductionPlanEntry() throws InterruptedException {
		System.out.println("Print Plan");
		wait = new WebDriverWait(driver, 10);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));

		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		Thread.sleep(5000);
		// Navigate to Production Entry
		menu.Accessory();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		menu.ProductionManagement();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		menu.ManageProductionPlan();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		menu.ProductionPlanentry();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
	}

	// Test Case 1: Production Plan With Collapse Entry
	@Test(enabled = true, dataProvider = "PPlanEntry")
	public void productionPlanWithCollapse(String MachineNo, String TargetQty, String OrderNo) throws Exception {
		// logger = report.createTest("Create plan");
		try {
			wait = new WebDriverWait(driver, 20);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
			Thread.sleep(1000);
			plan.SelectOrderNo(OrderNo);
			plan.ClickSearch();
			Thread.sleep(1000);
			plan.SelectOrderItemForPlan();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
			plan.ClickOkButton();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
			plan.OpenSlidingScreen();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
			Thread.sleep(2000);
			plan.InsertPlanQty1();
			Thread.sleep(2000);
			plan.ClickOkButtonToSelectOrdDtl();
			plan.SelectMachineNo(MachineNo);
			plan.InsertTargetQty(TargetQty);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
			plan.AddToJobOrder();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
			Thread.sleep(2000);
			plan.SavePlan();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
			plan.AddNewPlan();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));

		} catch (InterruptedException e) {
			throw new AssertionError(" Design Receive From CS Test Case Faield", e);
		}
	}

	// Test Case 2: Production Plan Expand Entry With Size
	@Test(enabled = false, dataProvider = "PPlanEntry")
	public void productionPlanWithExpand(String MachineNo, String TargetQty, String OrderNo) throws Exception {
		// logger = report.createTest("Create plan");
		try {
			wait = new WebDriverWait(driver, 20);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
			Thread.sleep(1000);
			plan.SelectOrderNo(OrderNo);
			plan.ClickSearch();
			Thread.sleep(1000);
			plan.SelectOrderItemForPlan();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
			plan.ClickOkButton();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
			plan.OpenSlidingScreen();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
			Thread.sleep(2000);
			plan.ExpandButton();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
			Thread.sleep(2000);
			plan.InsertPlanQtyWithExpand();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
			Thread.sleep(2000);
			plan.SelectCheckBoxActionButton();
			plan.ClickOkButtonToSelectOrdDtl();
			plan.SelectMachineNo(MachineNo);
			plan.InsertTargetQty(TargetQty);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
			plan.AddToJobOrder();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
//		plan.SavePlan();
//		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
//		plan.AddNewPlan();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));

		} catch (InterruptedException e) {
			throw new AssertionError(" Design Receive From CS Test Case Faield", e);
		}
	}

	@DataProvider(name = "PPlanEntry")
	public Object[][] getData() throws Exception {

		String excelPath = projectPath + "\\Excel_Data\\Plan.xlsx";
		String sheetName = "PlanEntry";
		Object data[][] = ExcelDataProvider.getDataFromExcel(excelPath, sheetName);
		return data;

	}

}

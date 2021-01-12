package Production_Management;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestNGMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.Menu;
import pages.PM_CreatePacking;
import utility.BaseClass;
import utility.ExcelDataProvider;

public class CreatePackingTestCase extends BaseClass {
	// Create Packing Test Case - By Mizan
	Menu menu = PageFactory.initElements(driver, Menu.class);
	PM_CreatePacking packing = PageFactory.initElements(driver, PM_CreatePacking.class);
	SoftAssert softAssert = new SoftAssert();
	

	@BeforeTest
	public void NavigateToCreatePackingMenu() throws InterruptedException {
		wait = new WebDriverWait(driver, 10);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		menu.Accessory();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		menu.ProductionManagement();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		menu.ManagePackaging();
		menu.CreatePacking();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));

	}

	@Test(priority = 0, dataProvider = "packing", enabled = true)
	public void TC_CreatePacking(String Buyer, String Customer, String PONo, String OrderNo, String OrderType,
			String BIC, String Item, String JobOrderNo, String P_UOM1) throws Exception {
		//logger = report.createTest("TC_Create Packing");

		// Buyer dropdown [Parameter: Buyer, div number]
		if (!Buyer.isEmpty()) {
			boolean Isselected = packing.SelectDropdown(Buyer, 1);

			softAssert.assertTrue(Isselected, "Dropdown value not selected");
		}

		// Customer dropdown [Parameter: Customer, div number]
		if (!Customer.isEmpty()) {
			boolean Isselected = packing.SelectDropdown(Customer, 2);

			softAssert.assertTrue(Isselected, "Dropdown value not selected");
		}

		// PONo dropdown [Parameter: Customer, div number]
		if (!PONo.isEmpty()) {
			boolean Isselected = packing.SelectDropdown(PONo, 3);

			softAssert.assertTrue(Isselected, "Dropdown value not selected");
		}

		// OrderNo dropdown [Parameter: Customer, div number]
		if (!OrderNo.isEmpty()) {
			boolean Isselected = packing.SelectDropdown(OrderNo, 4);

			softAssert.assertTrue(Isselected, "Dropdown value not selected");
		}

		// OrderType dropdown [Parameter: Customer, div number]
		if (!OrderType.isEmpty()) {
			boolean Isselected = packing.SelectDropdown(OrderType, 5);

			softAssert.assertTrue(Isselected, "Dropdown value not selected");
		}
		// BIC dropdown [Parameter: Customer, div number]
		if (!BIC.isEmpty()) {
			boolean Isselected = packing.SelectDropdown(BIC, 6);

			softAssert.assertTrue(Isselected, "Dropdown value not selected");
		} // Item dropdown [Parameter: Customer, div number]
		if (!Item.isEmpty()) {
			boolean Isselected = packing.SelectDropdown(Item, 7);

			softAssert.assertTrue(Isselected, "Dropdown value not selected");
		}
		// JobOrderNo dropdown [Parameter: Customer, div number]
		if (!JobOrderNo.isEmpty()) {
			boolean Isselected = packing.SelectDropdown(JobOrderNo, 8);

			softAssert.assertTrue(Isselected, "Dropdown value not selected");
		}

		// Click Search Button
		packing.SearchButton();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));

		// Reset Search Parameter [parameter 0 to rest search parameter and Parameter 1 to reset packinfo grid]
		
		// packing.Reset(0);

		// Item List for Click Action Button
		packing.ItemList(JobOrderNo);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));

		// Packing Information grid Entry

		packing.PackingInfoGridEntry(P_UOM1);

		// Save Packing Info
		/*boolean PackingSaved = packing.Save();
		softAssert.assertTrue(PackingSaved, "Packing doesn not save");
		*/
		
		
		// Reset packing Inof [parameter 0 to rest search parameter and Parameter 1 to reset packinfo grid]
		//packing.Reset(1);
		packing.Save();
		

		softAssert.assertAll();

	}

	@Test(priority = 1, enabled = false)
	public void TC_SavePackingInfo() throws Exception {

		// Save Packing Info
		boolean PackingSaved = packing.Save();
		softAssert.assertTrue(PackingSaved, "Packing doesn not save");

	}

	@Test(priority = 2, enabled = false)
	public void TC_ResetPackingInfo() throws Exception {
		// Reset packing Inof [parameter 0 to rest search parameter and Parameter 1 to
		// reset packinfo grid]
		packing.Reset(1);

	}

	@DataProvider(name = "packing")
	public Object[][] getData(ITestNGMethod testCase) throws Exception {
		Object data[][] = null;
		String excelPath = projectPath + "\\Excel_Data\\Packing.xlsx";
		String sheetName = "CreatePacking";
		// data = ExcelDataProvider.getDataFromExcel(excelPath, sheetName);

		if (testCase.getMethodName().equals("TC_CreatePacking")) {
			data = ExcelDataProvider.getDataFromExcel(excelPath, sheetName);
		}

		return data;

	}

}

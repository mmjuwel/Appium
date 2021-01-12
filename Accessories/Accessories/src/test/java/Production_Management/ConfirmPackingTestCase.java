package Production_Management;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestNGMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;

import pages.Menu;
import pages.PM_ConfirmPacking;
import utility.BaseClass;
import utility.ExcelDataProvider;
import utility.ExcelDataWriter;

public class ConfirmPackingTestCase extends BaseClass {

	// Create Packing Test Case - By Mizan
	Menu menu = PageFactory.initElements(driver, Menu.class);
	PM_ConfirmPacking ConPacking = PageFactory.initElements(driver, PM_ConfirmPacking.class);
	SoftAssert softAssert = new SoftAssert();
	ExcelDataWriter reader = new ExcelDataWriter(System.getProperty("user.dir") + "\\Excel_Data\\OrderIssue.xlsx");
	String sheet = "Issue";
	int statingRow = 2;

	@BeforeTest
	public void NavigateToCreatePackingMenu() throws InterruptedException {
		wait = new WebDriverWait(driver, 10);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		menu.Accessory();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		menu.ProductionManagement();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		menu.ManagePackaging();
		menu.ConfirmPacking();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));

	}

	@Test(priority = 0, dataProvider = "Confirmpacking", enabled = false)
	public void TC_ConfirmPackingOneByOne(String Buyer, String Customer, String PONo, String OrderNo, String OrderType,
			String BIC, String Item, String JobOrderNo) throws Exception {

		try {
			logger = report.createTest("Confirm Packing One by One");
			// Search Parameter
			ConfirmPackSearchParameter(Buyer, Customer, PONo, OrderNo, OrderType, BIC, Item, JobOrderNo);

			// Click Search Button
			ConPacking.SearchButton();
			Thread.sleep(1000);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));

			// Item List for Click Action Button
			ConPacking.ItemList(OrderNo);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));

			// Confirm Packing one by one
			ConPacking.ConfirmPack();

			// Save Confirm packing
			ConPacking.Save();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));

			String toastMessage = ConPacking.TostMessage();
			//String ordNo = ConPacking.getConfirmedNo();

			if (toastMessage.contains("Data saved successfully.")) {
				System.out.println(OrderNo + " | " + toastMessage);

				reader.setCellData(sheet, "OrderNo", statingRow, OrderNo);

				logger.log(Status.INFO, OrderNo + "| Test Success | " + getClass());

			}

			// Thread.sleep(1000);
			// Reset Confirm packing [parameter 0 to rest search parameter and Parameter 1
			// to reset Confirm packing grid]
			ConPacking.Reset(1);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));

		}

		catch (InterruptedException e) {
			throw new AssertionError(" Unable to Confirm Pack. " + e);
		}

	}

	@Test(priority = 1, dataProvider = "Confirmpacking", enabled = true)
	public void TC_ConfirmPackingAll(String Buyer, String Customer, String PONo, String OrderNo, String OrderType,
			String BIC, String Item, String JobOrderNo) throws Exception {

		logger = report.createTest("Confirm Packing One by One");

		try {
			// Search Parameter
			ConfirmPackSearchParameter(Buyer, Customer, PONo, OrderNo, OrderType, BIC, Item, JobOrderNo);

			// Click Search Button
			ConPacking.SearchButton();
			Thread.sleep(1000);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));

			// Item List for Click Action Button
			ConPacking.ItemList(OrderNo);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));

			// Confirm Packing All
			ConPacking.ConfirmAll();

			// Save Confirm packing
			ConPacking.Save();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));

			String toastMessage = ConPacking.TostMessage();
			//String ordNo = ConPacking.getConfirmedNo();

			if (toastMessage.contains("Data saved successfully.")) {
				System.out.println(OrderNo + " | " + toastMessage);

				reader.setCellData(sheet, "OrderNo", statingRow, OrderNo);
				logger.log(Status.INFO, OrderNo + "| Test Success | " + getClass());
			}

			// Reset Confirm packing [parameter 0 to rest search parameter and Parameter 1
			// to reset Confirm packing grid]
			// ConPacking.Reset(1);
		}

		catch (InterruptedException e) {
			throw new AssertionError(" Unable to Confirm Pack. " + e);
		}

	}

	public void ConfirmPackSearchParameter(String Buyer, String Customer, String PONo, String OrderNo, String OrderType,
			String BIC, String Item, String JobOrderNo) {
		// Buyer dropdown [Parameter: Buyer, div number]
		if (!Buyer.isEmpty()) {
			boolean Isselected = ConPacking.SelectDropdown(Buyer, 1);

			softAssert.assertTrue(Isselected, "Dropdown value not selected");
		}

		// Customer dropdown [Parameter: Customer, div number]
		if (!Customer.isEmpty()) {
			boolean Isselected = ConPacking.SelectDropdown(Customer, 2);

			softAssert.assertTrue(Isselected, "Dropdown value not selected");
		}

		// PONo dropdown [Parameter: Customer, div number]
		if (!PONo.isEmpty()) {
			boolean Isselected = ConPacking.SelectDropdown(PONo, 3);

			softAssert.assertTrue(Isselected, "Dropdown value not selected");
		}

		// OrderNo dropdown [Parameter: Customer, div number]
		if (!OrderNo.isEmpty()) {
			boolean Isselected = ConPacking.SelectDropdown(OrderNo, 4);

			softAssert.assertTrue(Isselected, "Dropdown value not selected");
		}

		// OrderType dropdown [Parameter: Customer, div number]
		if (!OrderType.isEmpty()) {
			boolean Isselected = ConPacking.SelectDropdown(OrderType, 5);

			softAssert.assertTrue(Isselected, "Dropdown value not selected");
		}
		// BIC dropdown [Parameter: Customer, div number]
		if (!BIC.isEmpty()) {
			boolean Isselected = ConPacking.SelectDropdown(BIC, 6);

			softAssert.assertTrue(Isselected, "Dropdown value not selected");
		} // Item dropdown [Parameter: Customer, div number]
		if (!Item.isEmpty()) {
			boolean Isselected = ConPacking.SelectDropdown(Item, 7);

			softAssert.assertTrue(Isselected, "Dropdown value not selected");
		}
		// JobOrderNo dropdown [Parameter: Customer, div number]
		if (!JobOrderNo.isEmpty()) {
			boolean Isselected = ConPacking.SelectDropdown(JobOrderNo, 8);

			softAssert.assertTrue(Isselected, "Dropdown value not selected");
		}
	}

	@DataProvider(name = "Confirmpacking")
	public Object[][] getData(ITestNGMethod testCase) throws Exception {
		Object data[][] = null;
		String excelPath = projectPath + "\\Excel_Data\\Packing.xlsx";
		String sheetName = "ConfirmPacking";

		data = ExcelDataProvider.getDataFromExcel(excelPath, sheetName);

		/*
		 * if (testCase.getMethodName().equals("TC_ConfirmPacking")) { data =
		 * ExcelDataProvider.getDataFromExcel(excelPath, sheetName); }else if
		 * (testCase.getMethodName().equals("TC_ConfirmPackingAll")) { data =
		 * ExcelDataProvider.getDataFromExcel(excelPath, sheetName); }
		 */

		return data;

	}

}

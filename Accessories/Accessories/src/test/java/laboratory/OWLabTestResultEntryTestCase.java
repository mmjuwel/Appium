package laboratory;

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

import pages.LAB_OWLabTestResultEntry;
import pages.Menu;
import utility.BaseClass;
import utility.ExcelDataProvider;

public class OWLabTestResultEntryTestCase extends BaseClass {

	// Order Wise Lab TestResult Entry Test Case - By Mizan
	Menu menu = PageFactory.initElements(driver, Menu.class);
	LAB_OWLabTestResultEntry LabTestResult = PageFactory.initElements(driver, LAB_OWLabTestResultEntry.class);
	SoftAssert softAssert = new SoftAssert();

	@BeforeTest
	public void NavigateToLabTestResultEntryMenu() throws InterruptedException {
		wait = new WebDriverWait(driver, 10);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		menu.Accessory();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		menu.Laboratory();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		menu.LabTestResultEntry();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));

	}

	@Test(priority = 0, dataProvider = "LabTestResultEntry")
	public void TC_LabTestResultEntry(String Customer, String Buyer, String CustomerPO, String OrderNo, String Plant,
			String JobOrderNo, String LabStatus) throws Exception {

		//logger = report.createTest("Lab Test Result Entry");
		
		// Search Parameter
		LabTestResultSearchParameter(Customer, Buyer, CustomerPO, OrderNo, Plant);

		// Click Search Button
		LabTestResult.SearchButton();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		
		// Update Lab Status		
		LabTestResult.UpdateLabStatus( JobOrderNo, OrderNo, LabStatus);
		
		// Save Lab Test Result
		LabTestResult.Save();
		
		// Reset Grid changes [parameter 0 to rest search parameter and Parameter 1 to reset  grid changes]
		// LabTestResult.Reset(1);
		 
		 wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		
	}

	public void LabTestResultSearchParameter(String Customer, String Buyer, String CustomerPO, String OrderNo,
			String Plant) throws Exception {
		// Customer dropdown [Parameter: Customer, div number]
		if (!Customer.isEmpty()) {
			boolean Isselected = LabTestResult.SelectDropdown(Customer, 1);

			softAssert.assertTrue(Isselected, "Dropdown value not selected");
		}

		// Buyer dropdown [Parameter: Buyer, div number]
		if (!Buyer.isEmpty()) {
			boolean Isselected = LabTestResult.SelectDropdown(Buyer, 2);

			softAssert.assertTrue(Isselected, "Dropdown value not selected");
		}

		// CustomerPO dropdown [Parameter: CustomerPO, div number]
		if (!CustomerPO.isEmpty()) {
			boolean Isselected = LabTestResult.SelectDropdown(CustomerPO, 3);

			softAssert.assertTrue(Isselected, "Dropdown value not selected");
		}

		// OrderNo dropdown [Parameter: OrderNo, div number]
		if (!OrderNo.isEmpty()) {
			boolean Isselected = LabTestResult.SelectDropdown(OrderNo, 4);

			softAssert.assertTrue(Isselected, "Dropdown value not selected");
		}

		// Plant dropdown [Parameter: Plant, div number]
		if (!Plant.isEmpty()) {
			boolean Isselected = LabTestResult.SelectDropdown(Plant, 5);

			softAssert.assertTrue(Isselected, "Dropdown value not selected");
		}
	}

	@DataProvider(name = "LabTestResultEntry")
	public Object[][] getData(ITestNGMethod testCase) throws Exception {
		Object data[][] = null;
		String excelPath = projectPath + "\\Excel_Data\\Lab1.xlsx";
		String sheetName = "LabTestResult";
		data = ExcelDataProvider.getDataFromExcel(excelPath, sheetName);
		return data;

	}

}

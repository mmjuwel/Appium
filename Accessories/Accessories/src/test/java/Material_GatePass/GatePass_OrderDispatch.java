package Material_GatePass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestNGMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.MGP_GatePassOrderDispatch;
import pages.Menu;
import utility.BaseClass;
import utility.ExcelDataProvider;
import utility.ExcelDataWriter;

public class GatePass_OrderDispatch extends BaseClass {

	Menu menu = PageFactory.initElements(driver, Menu.class);
	MGP_GatePassOrderDispatch gatePass = PageFactory.initElements(driver, MGP_GatePassOrderDispatch.class);

	
	ExcelDataWriter reader = new ExcelDataWriter(System.getProperty("user.dir")+"\\Excel_Data\\Delivery.xlsx");
	String sheet = "DeliveryInfo";
	int statingRow=2;
	
	
	@BeforeTest
	public void navigateToCreateOrder() throws InterruptedException {
		wait = new WebDriverWait(driver, 10);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		menu.Accessory();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		// Thread.sleep(1000);
		menu.GatePassManagement();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		menu.GatePass_N_OrderDispatch();
		// Thread.sleep(2000);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
	}

	@Test(enabled = false, priority = 1, dataProvider = "gatePass", groups = { "smoke", "regression" })
	public void TC_AcknowledgeGPDNOWise(String Customer, String DeliveryPlanNo, String ChallanNo)
			throws InterruptedException {
		logger = report.createTest("TC_Acknowledge GPDNo Wise All Challan");

		try {
			search(Customer, DeliveryPlanNo, ChallanNo);
			Thread.sleep(1000);
			gatePass.clickOnGridDeliveryPlanNoCheckbox();
			boolean rst = gatePass.Confirm_GPDNO();
			Assert.assertTrue(rst, "GDP no not Checked");
			Thread.sleep(1000);
			
			gatePass.Acknowledge();
			reader.setCellData(sheet,"Delivery Plan*",statingRow,DeliveryPlanNo);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
			
		} catch (Exception e) {
			throw new AssertionError(" Order is not dispatched. " + e);
		}
	}

	@Test(enabled = true, priority = 2, dataProvider = "gatePass", groups = { "smoke", "regression" })
	public void TC_AcknowledgeAllChallanOneByOne(String Customer, String DeliveryPlanNo, String ChallanNo)
			throws InterruptedException {
		logger = report.createTest("TC_Acknowledge All Challan One By One");

		try {
			search(Customer, DeliveryPlanNo, ChallanNo);
			int total = gatePass.getTotalActionNo();
			// System.out.println(total);
			for (int index = 0; index < total; index++) {
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
				gatePass.ClickOnChallan(index);
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
				Thread.sleep(1000);
				gatePass.Acknowledge();
				reader.setCellData(sheet,"Plan no*",statingRow,DeliveryPlanNo);
				System.out.println("Plan no: "+DeliveryPlanNo);
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
			}
			Thread.sleep(1000);
		} catch (Exception e) {
			throw new AssertionError(" Order is not dispatched. " + e);
		}
	}

	@Test(enabled = false, priority = 3, dataProvider = "gatePass", groups = { "smoke", "regression" })
	public void TC_RejectChallanOneByOne(String Customer, String DeliveryPlanNo, String ChallanNo)
			throws InterruptedException {
		logger = report.createTest("TC_Reject All Challan One by One");

		try {
			search(Customer, DeliveryPlanNo, ChallanNo);
			int total = gatePass.getTotalActionNo();
			// System.out.println(total);
			for (int index = 0; index < total; index++) {
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
				Thread.sleep(1000);
				gatePass.ClickOnChallan(index);
				Thread.sleep(2000);
				gatePass.Reject("Yes");
			}
		} catch (Exception e) {
			throw new AssertionError(" Order is not dispatched. " + e);
		}
	}

	public void search(String Customer, String DeliveryPlanNo, String ChallanNo) {

		logger = report.createTest("TC_GatePass Search Parametter");
		if (Customer != "") {
			gatePass.SelectCustomer(Customer);
		}

		if (DeliveryPlanNo != "") {
			gatePass.SelectDeliveryPlanNo(DeliveryPlanNo);
		}
		if (ChallanNo != "") {
			gatePass.SelectChallanNo(ChallanNo);
		}
		gatePass.SearchButton();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
	}

	@DataProvider(name = "gatePass")
	public Object[][] getData(ITestNGMethod testCase) throws Exception {
		Object data[][] = null;
		String excelPath = projectPath + "\\Excel_Data\\GatePassAndOrderDispatch.xlsx";
		String sheetName = "GatePass";
		data = ExcelDataProvider.getDataFromExcel(excelPath, sheetName);
		return data;
	}
//test
}

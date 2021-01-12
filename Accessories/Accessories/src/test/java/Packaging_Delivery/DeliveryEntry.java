package Packaging_Delivery;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestNGMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pages.Menu;
import pages.PD_DeliveryEntry;
import utility.BaseClass;
import utility.ExcelDataProvider;
import utility.ExcelDataWriter;

@Listeners(utility.Listener.class)
public class DeliveryEntry extends BaseClass {
	Menu menu = PageFactory.initElements(driver, Menu.class);
	PD_DeliveryEntry Delivery = PageFactory.initElements(driver, PD_DeliveryEntry.class);

	@BeforeTest
	public void navigateToDeliveryEntry() throws InterruptedException {
		wait = new WebDriverWait(driver, 30);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		menu.Accessory();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		menu.LogisticManagement();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		menu.DeliveryConfirm();
		menu.DeliveryEntry();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
	}

	@Test(enabled = true, dataProvider = "delConf", groups = { "smoke", "regression" })
	public void CreateDeliveryEntry(String planNo, String customerName, String Delstatus, String ReceiveBy,
			String ChallanStatus) throws Throwable {

		logger = report.createTest("Delivery Confirmation Entry");

		try {
			Delivery.OpenDeliveryPlanPopup();
			Thread.sleep(1000);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));

			Delivery.SearchByPlanNo(planNo);
			Delivery.SearchByPlanNo("GDP-1782");
			
			if (!customerName.equals("")) {
				Delivery.SearchByCustomer(customerName);
			} 
			Delivery.ClickOnSearchbutton();
			Thread.sleep(1000);
			Delivery.SelectPlanItem();
			Delivery.SelectDeliveryStatus(Delstatus);
			Delivery.SelectReceiveBy(ReceiveBy);
			
			ChallanStatus="Pending";
			
			if (ChallanStatus.equals("Received")) {
				Delivery.SelectChallanAckStatus(ChallanStatus);
			}
			else if (ChallanStatus.equals("") || ChallanStatus.contains("Pending")) {
				ExcelDataWriter reader = new ExcelDataWriter(System.getProperty("user.dir")+"\\Excel_Data\\ChallanAck.xlsx");
				String sheet = "ChallanInfo";
				int statingRow=2;
				String clNo= Delivery.getChallanNumbers();
				reader.setCellData(sheet,"Challan NO*",statingRow,clNo);
				System.out.println(clNo);
			}
			
			//Delivery.ClickOnSaveButton();
//			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
//			Assert.assertTrue(Delivery.ConfirmSave());
//			Delivery.ClickOnNewplanButton();
//			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
//			Thread.sleep(1000);
//			Delivery.AcceptConfirmation();
//			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));


		} catch (Exception e) {
			throw new AssertionError(" Delivery is not entered." + e);
		}
	}

	@DataProvider(name = "delConf")
	public Object[][] getData(ITestNGMethod testCase) throws Exception {
		Object data[][] = null;
		String excelPath = projectPath + "/Excel_Data/Delivery.xlsx";
		String sheetName = "DeliveryInfo";
		data = ExcelDataProvider.getDataFromExcel(excelPath, sheetName);
		return data;
	}

}

package Packaging_Delivery;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestNGMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pages.Menu;
import pages.PD_GeneralDeliveryPlanEntry;
import utility.BaseClass;
import utility.ExcelDataProvider;
import utility.ExcelDataWriter;

@Listeners(utility.Listener.class)
public class GeneralDeliveryPlanEntry extends BaseClass {

	Menu menu = PageFactory.initElements(driver, Menu.class);
	PD_GeneralDeliveryPlanEntry generalDeliveryPlan = PageFactory.initElements(driver,
			PD_GeneralDeliveryPlanEntry.class);
	ExcelDataWriter reader = new ExcelDataWriter(System.getProperty("user.dir")+"\\Excel_Data\\GatePassAndOrderDispatch.xlsx");
	String sheet = "GatePass";
	int statingRow=2;

	@BeforeTest
	public void navigateToGeneralDeliveryPlan() throws InterruptedException {
		wait = new WebDriverWait(driver, 30);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		menu.Accessory();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		menu.LogisticManagement();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		menu.GeneralDeliveryPlan();
		menu.GeneralDeliveryPlanEntry();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
	}

	@Test(enabled = true, dataProvider = "gdp", groups = { "smoke", "regression" })
	public void CreaetGeneralDeliveryPlan(String cln1, String cln2, String cln3, String date, String drivername,
			String deliveryMan) throws Throwable {

		logger = report.createTest("Creaet General Delivery Plan.");

		try {
			
			String[] challan = { cln1, cln2, cln3 };
			for (int i = 0; i < challan.length; i++) {
				if (challan[i].equals("")) {
					break;
				}
				generalDeliveryPlan.openSelectChallanPopup();
				Thread.sleep(1000);
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
				Thread.sleep(1000);
				generalDeliveryPlan.searchByChallanNo(challan[i]);
				generalDeliveryPlan.clickOnSearchButton();
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
				Thread.sleep(1000);
				
				
				
				generalDeliveryPlan.clickOnExpandChallanItem();
				
				
				generalDeliveryPlan.selectChallamItem();
				generalDeliveryPlan.clickOnOKbutton();
				Thread.sleep(1000);
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
			}
			generalDeliveryPlan.selectDate(date);
			generalDeliveryPlan.selectDriver(drivername);
			generalDeliveryPlan.selectDeliveryman(deliveryMan);
			generalDeliveryPlan.insertRemarks("test Remarks");
			generalDeliveryPlan.clickOnSavebutton();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
			Thread.sleep(1000);
			String toastMessage=generalDeliveryPlan.TostMessage();
			String gdpNo=generalDeliveryPlan.getGenarelDeliverryPlanNo();
			
			
			if(toastMessage.contains("Data saved successfully.")) {
				System.out.println(gdpNo+" | "+toastMessage);
				
				reader.setCellData(sheet,"Delivery Plan*",statingRow,gdpNo);
							
				if (generalDeliveryPlan.confiramSave()) {
					logger.log(Status.INFO, gdpNo+"| Test Success | "+ getClass());
				}
			}
			
			
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
			Assert.assertTrue(generalDeliveryPlan.confiramSave());
			generalDeliveryPlan.clickOnAddNewbutton();

		} catch (Exception e) {
			throw new AssertionError(" GDP not Created." + e);
		}
	}

	@DataProvider(name = "gdp")
	public Object[][] getData(ITestNGMethod testCase) throws Exception {
		Object data[][] = null;
		String excelPath = projectPath + "/Excel_Data/GeneralDeliveryPlan.xlsx";
		String sheetName = "ChallanNo";
		data = ExcelDataProvider.getDataFromExcel(excelPath, sheetName);
		return data;
	}

}

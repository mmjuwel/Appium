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
import pages.PD_ChallanAcknoldgement;
import utility.BaseClass;
import utility.ExcelDataProvider;

@Listeners(utility.Listener.class)
public class ChallahAcknowldgement extends BaseClass {

	Menu menu = PageFactory.initElements(driver, Menu.class);
	PD_ChallanAcknoldgement ChallanAck = PageFactory.initElements(driver, PD_ChallanAcknoldgement.class);

	@BeforeTest
	public void navigateToChallanAcknoldgement() throws InterruptedException {
		wait = new WebDriverWait(driver, 30);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		menu.Accessory();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		menu.LogisticManagement();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		menu.ChallanAcknoldgement();
		menu.ChallanAcknoldgementEntry();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
	}

	@Test(enabled = true, dataProvider = "challanAck", groups = { "smoke", "regression" })
	public void InsertChallaAcknoldgement(String customerName, String clnNo, String AckStatus, String date,
			String AckBy, String filePath) throws Throwable {

		logger = report.createTest("Insert Challan Acknoldgement");

		try {
			ChallanAck.SearchByCustomer(customerName);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
			ChallanAck.SelectCustomer();
			Thread.sleep(1000);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
			ChallanAck.SearchByChallanNo(clnNo);
			ChallanAck.ClickOnSearchButton();
			Thread.sleep(1000);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));

			ChallanAck.SelectAckStatus(AckStatus);
			ChallanAck.SelectAckDate(date);
			ChallanAck.SelectAckBy(AckBy);

			ChallanAck.AttachOrderSheet(filePath);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
			ChallanAck.UploadSheet();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
			ChallanAck.CloseSheetpopup();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
			ChallanAck.ClickOnSaveButton();
			Thread.sleep(1000);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
			Assert.assertTrue(ChallanAck.confiramSave());
			ChallanAck.ClickOnAckAnotherButton();

		} catch (Exception e) {
			throw new AssertionError(" Challan is not Acknoldgement. " + e);
		}
	}

	@DataProvider(name = "challanAck")
	public Object[][] getData(ITestNGMethod testCase) throws Exception {
		Object data[][] = null;
		String excelPath = projectPath + "/Excel_Data/\\ChallanAck.xlsx";
		String sheetName = "ChallanInfo";
		data = ExcelDataProvider.getDataFromExcel(excelPath, sheetName);
		return data;
	}

}

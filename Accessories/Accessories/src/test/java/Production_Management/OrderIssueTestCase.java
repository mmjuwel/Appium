package Production_Management;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pages.Menu;
import pages.OM_OrderIssue;
import pages.OM_OrderSourcing;
import utility.BaseClass;
import utility.ExcelDataProvider;
import utility.ExcelDataWriter;

public class OrderIssueTestCase extends BaseClass {

	Menu menu = PageFactory.initElements(driver, Menu.class);
	OM_OrderIssue Issue = PageFactory.initElements(driver, OM_OrderIssue.class);
	ExcelDataWriter reader = new ExcelDataWriter(System.getProperty("user.dir") + "\\Excel_Data\\IssueReceive.xlsx");
	String sheet = "Issue";
	int statingRow = 2;

	@BeforeTest
	public void navigateToCreateOrder() throws InterruptedException {
		wait = new WebDriverWait(driver, 30);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		menu.Accessory();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		menu.ProductionManagement();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		menu.Issue();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		menu.OrderIssue();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		Thread.sleep(1000);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
	}

	// Test Case 1:
	@Test(enabled = true, dataProvider = "OrderIssue")
	public void OrderIssuePlan(String OrderNo) throws Exception {
		logger = report.createTest("Create plan");

		wait = new WebDriverWait(driver, 20);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		Thread.sleep(1000);
		Issue.SelectOrderNo(OrderNo);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		Issue.ClickSearchbutton();
		Thread.sleep(1000);
		Issue.SelectItemToIssue();
		Issue.ClickOkButton();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		Thread.sleep(1000);
		Issue.SelectActionButton();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		Issue.ClickIssueButton();
		Thread.sleep(1000);
		Issue.ClickPopUpButton();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));

		String toastMessage = Issue.TostMessage();
		if (toastMessage.contains("Data saved successfully.")) {
			System.out.println(OrderNo + " | " + toastMessage);

			reader.setCellData(sheet, "OrderNo*", statingRow, OrderNo);

			logger.log(Status.INFO, OrderNo + "| Test Success | " + getClass());

		}

		
		
		Issue.ClickPopUpButton();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		Issue.ClickCloseWindow();
		Issue.ResetButton();

	}

	@DataProvider(name = "OrderIssue")
	public Object[][] getData() throws Exception {

		String excelPath = projectPath + "\\Excel_Data\\OrderIssue.xlsx";
		String sheetName = "Issue";
		Object data[][] = ExcelDataProvider.getDataFromExcel(excelPath, sheetName);
		return data;

	}

}

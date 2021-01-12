package Production_Management;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.Menu;
import pages.OM_ReceiveIssue;
import utility.BaseClass;
import utility.ExcelDataProvider;

public class IssueReceiveTestCase extends BaseClass {
Menu menu = PageFactory.initElements(driver, Menu.class);
OM_ReceiveIssue Receiveissue = PageFactory.initElements(driver, OM_ReceiveIssue.class);


	@BeforeTest
	public void NavigateToIssueOrderItem() throws InterruptedException {
		wait = new WebDriverWait(driver, 10);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		menu.Accessory();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		menu.LogisticManagement();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		menu.IssueReceive();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		menu.ReceiveConfirmIssue();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		Thread.sleep(1000);

	}

		// Test Case 1: 
		@Test(enabled = true, dataProvider = "IssueReceive")
		public void IssueReceiveConfirmation (String OrderNo, String IssueNo) throws Exception {
		
		Receiveissue.SelectOrderNo(OrderNo);
		Thread.sleep(1000);
		Receiveissue.SelectIssueNo(IssueNo);
		Thread.sleep(1000);
		Receiveissue.ClickSearchbutton();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));		Thread.sleep(1000);
		Receiveissue.SelectIssueCheckBox();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		Receiveissue.ClickReceiveConfirm();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		Thread.sleep(1000);	
		Receiveissue.ClickResetbutton();
		Thread.sleep(1000);	
		Receiveissue.ClickPopUp();
		}

			
		
		@DataProvider(name = "IssueReceive")
		public Object[][] getData() throws Exception {

		String excelPath = projectPath + "\\Excel_Data\\IssueReceive.xlsx";
		String sheetName = "Issue";
		Object data[][] = ExcelDataProvider.getDataFromExcel(excelPath, sheetName);
		return data;
	}


}

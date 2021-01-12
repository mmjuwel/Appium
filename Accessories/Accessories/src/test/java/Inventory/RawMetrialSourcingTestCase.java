package Inventory;

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
import pages.INV_RawMaterialSourcing;
import utility.BaseClass;
import utility.ExcelDataProvider;

@Listeners(utility.Listener.class)
public class RawMetrialSourcingTestCase extends BaseClass {
	Menu menu = PageFactory.initElements(driver, Menu.class);
	INV_RawMaterialSourcing RMSourcing = PageFactory.initElements(driver, INV_RawMaterialSourcing.class);
	int flag=0;

	@BeforeTest
	public void RMTestCase() throws InterruptedException {
		System.out.println("Print Plan");
		wait = new WebDriverWait(driver, 10);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));

		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		Thread.sleep(1000);
		// Navigate to Raw Material Sourcing
		menu.Accessory();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		menu.SupplyChainManagement();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		menu.RMSourcingPlan();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		Thread.sleep(2000);
		
	}
		
		
	
	// Test Case 1: Production Plan With Collapse Entry
	@Test(enabled = true, dataProvider = "RMSourcing")
	public void RMSourcingNIC(String CustomerName, String OrderNo, String Sourcingtype) throws Exception {
		 //logger = report.createTest("Create plan");
		 System.out.println("Customer Name: " + CustomerName + ", Order No: " + OrderNo);

		wait = new WebDriverWait(driver, 20);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		
		
		Thread.sleep(1000);
		if(flag==0){
			RMSourcing.RMSourcingNIC();
			flag=1;
		}
		Thread.sleep(3000);
		RMSourcing.SelectCustomer(CustomerName);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		RMSourcing.SelectOrderNo(OrderNo);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		RMSourcing.Search();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		Thread.sleep(3000);
		RMSourcing.SelectOrderItemNIC();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		Thread.sleep(5000);
		RMSourcing.InsertSourcingQty(Sourcingtype);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		Thread.sleep(1000);
		RMSourcing.Save();
		Thread.sleep(1000);
		RMSourcing.CloseWindow();
		RMSourcing.Reset();
	
		
	}
	
	
	
	
	// Test Case 1: Production Plan With Collapse Entry
		@Test(enabled = false, dataProvider = "RMSourcing")
		public void RMSourcingBIC(String CustomerName, String OrderNo, String Sourcingtype) throws Exception {
		
			 System.out.println("Customer Name: " + CustomerName + ", Order No: " + OrderNo);

			wait = new WebDriverWait(driver, 20);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
			Thread.sleep(1000);
			Thread.sleep(1000);
			if(flag==0){
			RMSourcing.RMSourcingBIC();
			flag=1;
			}
			Thread.sleep(30000);
			RMSourcing.SelectCustomer(CustomerName);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
			RMSourcing.SelectOrderNo(OrderNo);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
			RMSourcing.Search();
			Thread.sleep(30000);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
			RMSourcing.SelectOrderItemNIC();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
			Thread.sleep(5000);
			RMSourcing.InsertSourcingQty(Sourcingtype);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
			RMSourcing.Save();
			Thread.sleep(1000);
			RMSourcing.CloseWindow();
			RMSourcing.Reset();
			
		
			
		}
	
	
	
	

	@DataProvider(name = "RMSourcing")
	public Object[][] getData() throws Exception {

		String excelPath = projectPath + "\\Excel_Data\\RawMaterial.xlsx";
		String sheetName = "RMSourcingBIC";
		Object data[][] = ExcelDataProvider.getDataFromExcel(excelPath, sheetName);
		return data;
		
		
	}
}



package Inventory;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestNGMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pages.Menu;
import pages.INV_PurchaseRequisition;
import utility.BaseClass;
import utility.ExcelDataProvider;

@Listeners(utility.Listener.class)
public class PurchaseRequisitionTestCase extends BaseClass {
	Menu menu = PageFactory.initElements(driver, Menu.class);
	INV_PurchaseRequisition PurchaseReq = PageFactory.initElements(driver, INV_PurchaseRequisition.class);


	@BeforeTest
	public void PurchaseReq() throws InterruptedException {
		System.out.println("Print Plan");
		wait = new WebDriverWait(driver, 10);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));

		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		Thread.sleep(5000);
		// Navigate to PurchaseRequisition
		menu.Accessory();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		menu.SupplyChainManagement();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		menu.PurchaseRequisition();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		menu.PurchaseRequisitionStock();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		
	}
		
		
	
	// Test Case 1: PurchaseRequisition With BIC
	@Test(enabled = false, dataProvider = "PurchaseReq")
	public void PurchaseRequisitionBIC(String BuyerName, String BICName, String RequiredQty, String PurchaseAmt, String Date) throws Exception {
		 System.out.println("Customer Name: " + BuyerName + ", Order No: " + BICName);

		wait = new WebDriverWait(driver, 20);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		PurchaseReq.SelectItemStock();
		Thread.sleep(1000);
		PurchaseReq.SelectBuyer(BuyerName);
		PurchaseReq.SelectBIC(BICName);
		PurchaseReq.Search();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		PurchaseReq.SelectBICItemCheckbox();
		PurchaseReq.SelectOKButton();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		PurchaseReq.InsertReqQty(RequiredQty);
		PurchaseReq.InsertPurchaseAmount(PurchaseAmt);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		PurchaseReq.selectDate(Date);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		//PurchaseReq.SaveReq();
		Thread.sleep(1000);
		PurchaseReq.AddNewRequisition();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		PurchaseReq.SelectRequsitionPopUp();
		
	}
		
	
	
	// Test Case 1: PurchaseRequisition With NIC
		@Test(enabled = true, dataProvider = "PurchaseReq")
		public void PurchaseRequisitionNIC(String Item, String ItemType, String NIC, String RequiredQty, String PurchaseAmt, String Date) throws Exception {
			 System.out.println("Customer Name: " + Item + ", Order No: " + ItemType);

			wait = new WebDriverWait(driver, 20);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
			PurchaseReq.SelectItemStock();
			Thread.sleep(1000);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
			PurchaseReq.SelectNICRadioButton();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
			PurchaseReq.SelectItem(Item);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
			PurchaseReq.SelectNICItemType(ItemType);
			PurchaseReq.SelectNIC(NIC);
			PurchaseReq.Search();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
			//PurchaseReq.SelectCheckBoxActionButton();
			PurchaseReq.SelectNICItem();
			PurchaseReq.SelectNICOKButton();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
			PurchaseReq.InsertReqQty(RequiredQty);
			PurchaseReq.InsertPurchaseAmount(PurchaseAmt);
			Thread.sleep(1000);
			PurchaseReq.selectDate(Date);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
			//PurchaseReq.SaveReq();
			Thread.sleep(1000);
			PurchaseReq.AddNewRequisition();
			Thread.sleep(1000);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
			PurchaseReq.SelectRequsitionPopUp();
			
		
		
			
		}
	
	
		@DataProvider(name = "PurchaseReq")
		public Object[][] getData(ITestNGMethod testCase) throws Exception {
			Object data[][] = null;
			String excelPath = projectPath + "\\Excel_Data\\PurchaseRequisition.xlsx";

			if (testCase.getMethodName().contains("PurchaseRequisitionBIC")) {
				String sheetName = "BIC";
				data = ExcelDataProvider.getDataFromExcel(excelPath, sheetName);
			
			} else if (testCase.getMethodName().contains("PurchaseRequisitionNIC")) {
				String sheetName = "NIC";
				data = ExcelDataProvider.getDataFromExcel(excelPath, sheetName);
			} else {
				System.out.println("No Sheet assigned for " + testCase.getMethodName() + " Method");
			}

			return data;
		}
	}
	

	



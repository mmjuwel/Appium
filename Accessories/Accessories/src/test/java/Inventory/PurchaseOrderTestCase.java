package Inventory;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestNGMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pages.INV_PurchaseOrder;
import pages.Menu;
import utility.BaseClass;
import utility.ExcelDataProvider;

@Listeners(utility.Listener.class)
public class PurchaseOrderTestCase extends BaseClass {
	Menu menu = PageFactory.initElements(driver, Menu.class);
	INV_PurchaseOrder PurchaseOrder = PageFactory.initElements(driver, INV_PurchaseOrder.class);


	@BeforeTest
	public void PurchaseORD() throws InterruptedException {
		System.out.println("Print Plan");
		wait = new WebDriverWait(driver, 10);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));

		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		Thread.sleep(1000);
		// Navigate to PurchaseOrder
		menu.Accessory();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		menu.SupplyChainManagement();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		menu.PurchaseOrder();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		menu.CreatePurchaseOrder();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		Thread.sleep(2000);
	}
		
		
	
	// Test Case 1: PurchaseOrder
	@Test(enabled = true, dataProvider = "PurchaseOrder")
	public void PurchaseOrderForRequsition(String RequsitionNo, String Date, String Time) throws Exception {
		 System.out.println("Customer Name: " + RequsitionNo);

		wait = new WebDriverWait(driver, 20);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		Thread.sleep(1000);
		PurchaseOrder.Supplier();
		Thread.sleep(2000);
		PurchaseOrder.SelectSupplierActionButton();
		Thread.sleep(1000);
		PurchaseOrder.SelectRequisitionForStock();
		Thread.sleep(1000);
		PurchaseOrder.SelectRequisitionNo(RequsitionNo);
		PurchaseOrder.SelectSearch();
		Thread.sleep(1000);
		//PurchaseOrder.SelectItem();
		PurchaseOrder.SelectCheckBoxActionButton();
		PurchaseOrder.SelectOKButton();
		Thread.sleep(1000);
		PurchaseOrder.selectDate(Date);
		Thread.sleep(1000);
		PurchaseOrder.SelectTime(Time);
		PurchaseOrder.OpenDeliveryPopUp(); //-----------
		Thread.sleep(1000);
		PurchaseOrder.SelectDeliveryAddress();  //-----------
		PurchaseOrder.InsertPurchaseQty();  
		PurchaseOrder.SaveButtonForReq();
		Thread.sleep(2000);
		PurchaseOrder.SelectAddNewButton();
		Thread.sleep(3000);
		
		
		
	}
		
	
	//TestCase2 PurchaseOrderForOrderRM
	@Test(enabled = false, dataProvider = "PurchaseOrder")
	public void PurchaseOrderForOrderRM(String CustomerName, String OrderNo, String Date, String Time) throws Exception {
		 //System.out.println("Customer Name: " + CustomerName);

		wait = new WebDriverWait(driver, 20);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		Thread.sleep(1000);
		PurchaseOrder.Supplier();
		Thread.sleep(2000);
		PurchaseOrder.SelectSupplierActionButton();
		Thread.sleep(1000);
		PurchaseOrder.SelectOrderRM();
		Thread.sleep(1000);
		PurchaseOrder.SelectCustomer(CustomerName);
		Thread.sleep(1000);
		PurchaseOrder.SelectOrderNo(OrderNo);
		Thread.sleep(1000);
		PurchaseOrder.SelectSearch();
		Thread.sleep(1000);
		PurchaseOrder.SelectItemCheckBoxForOrderRM();
		PurchaseOrder.SelectOKButton();
		Thread.sleep(1000);
		PurchaseOrder.selectDate(Date);
		Thread.sleep(1000);
		PurchaseOrder.SelectTime(Time);
		PurchaseOrder.OpenDeliveryPopUp();
		Thread.sleep(2000);
		PurchaseOrder.SelectDeliveryAddress();
		PurchaseOrder.InsertPurchaseQty();
		PurchaseOrder.SaveButtonForReq();
		Thread.sleep(2000);
		PurchaseOrder.SelectAddNewButton();
		Thread.sleep(3000);
		
		
		
	}
	
	// TestCase3 PurchaseOrderForStockBIC
	@Test(enabled = false, dataProvider = "PurchaseOrder")
	public void PurchaseOrderForStockBIC(String BuyerName, String BICName, String RequiredQty, String PurchaseAmt, String Date, String Time) throws Exception {
		 //System.out.println("Customer Name: " + CustomerName);

		wait = new WebDriverWait(driver, 20);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		Thread.sleep(1000);
		PurchaseOrder.Supplier();
		Thread.sleep(2000);
		PurchaseOrder.SelectSupplierActionButton();
		Thread.sleep(1000);
		PurchaseOrder.SelectForStock();
		Thread.sleep(1000);
		PurchaseOrder.SelectBuyer(BuyerName);
		Thread.sleep(1000);
		PurchaseOrder.SelectBIC(BICName);
		Thread.sleep(1000);
		PurchaseOrder.SelectSearch();
		Thread.sleep(1000);
		//PurchaseOrder.SelectItemCheckBoxForStockBICItem();
		PurchaseOrder.SelectItem3();
		Thread.sleep(2000);
		PurchaseOrder.SelectOKButton();
		Thread.sleep(1000);
		PurchaseOrder.selectDate(Date);
		Thread.sleep(1000);
		PurchaseOrder.SelectTime(Time);
		Thread.sleep(1000);
		PurchaseOrder.OpenDeliveryPopUp();
		Thread.sleep(1000);
		PurchaseOrder.SelectDeliveryAddress();
		PurchaseOrder.InsertReqQty(RequiredQty);
		PurchaseOrder.SaveButtonForReq();
		Thread.sleep(2000);
		PurchaseOrder.SelectAddNewButton();
		Thread.sleep(3000);
		
		
		
	}
	
	
	// TestCase4 PurchaseOrderForStockNIC
		@Test(enabled = false, dataProvider = "PurchaseOrder")
		public void PurchaseOrderForStockNIC(String Item, String ItemType, String NIC, String RequiredQty, String PurchaseAmt, String Date, String Time) throws Exception {
			 //System.out.println("Customer Name: " + CustomerName);

			wait = new WebDriverWait(driver, 20);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
			Thread.sleep(1000);
			PurchaseOrder.Supplier();
			Thread.sleep(2000);
			PurchaseOrder.SelectSupplierActionButton();
			Thread.sleep(1000);
			PurchaseOrder.SelectForStock();
			Thread.sleep(1000);
			PurchaseOrder.SelectNICRadioButton();
			Thread.sleep(1000);
			PurchaseOrder.SelectItem(Item);
			Thread.sleep(1000);
			PurchaseOrder.SelectNICItemType(ItemType);
			Thread.sleep(1000);
			PurchaseOrder.SelectNIC(NIC);
			Thread.sleep(1000);
			PurchaseOrder.SelectSearch();
			Thread.sleep(1000);
			//PurchaseOrder.SelectItemCheckBoxForStockBICItem();
			PurchaseOrder.SelectNICItem();
			Thread.sleep(2000);
			PurchaseOrder.SelectNICOKButton();
			Thread.sleep(1000);
			PurchaseOrder.selectDate(Date);
			Thread.sleep(1000);
			PurchaseOrder.SelectTime(Time);
			Thread.sleep(1000);
			PurchaseOrder.OpenDeliveryPopUp();
			Thread.sleep(1000);
			PurchaseOrder.SelectDeliveryAddress();
			PurchaseOrder.InsertReqQty(RequiredQty);
			PurchaseOrder.SaveButtonForReq();
			Thread.sleep(2000);
			PurchaseOrder.SelectAddNewButton();
			Thread.sleep(3000);
			
			
			
		}
		
		
		
	
	
	

	@DataProvider(name = "PurchaseOrder")
	public Object[][] getData(ITestNGMethod testCase) throws Exception {
		Object data[][] = null;
		String excelPath = projectPath + "\\Excel_Data\\PurchaseOrder.xlsx";

		if (testCase.getMethodName().contains("PurchaseOrderForRequsition")) {
			String sheetName = "Requsition";
			data = ExcelDataProvider.getDataFromExcel(excelPath, sheetName);
		
		} else if (testCase.getMethodName().contains("PurchaseOrderForOrderRM")) {
			String sheetName = "OrderRM";
			data = ExcelDataProvider.getDataFromExcel(excelPath, sheetName);
			
		} else if (testCase.getMethodName().contains("PurchaseOrderForStockBIC")) {
			String sheetName = "BIC";
			data = ExcelDataProvider.getDataFromExcel(excelPath, sheetName);
			
		} else if (testCase.getMethodName().contains("PurchaseOrderForStockNIC")) {
			String sheetName = "NIC";
			data = ExcelDataProvider.getDataFromExcel(excelPath, sheetName);
		} else {
			System.out.println("No Sheet assigned for " + testCase.getMethodName() + " Method");
		}

		return data;
	}
}



package Production_Management;
import java.util.concurrent.TimeUnit;

import javax.swing.Spring;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pages.Menu;
import pages.OM_ProductionEntry;
import utility.BaseClass;
import utility.ExcelDataProvider;

@Listeners(utility.Listener.class)
public class ProductionEntryTestCase extends BaseClass{

	Menu menu= PageFactory.initElements(driver,Menu.class );
	OM_ProductionEntry productionEntry= PageFactory.initElements(driver,OM_ProductionEntry.class );

	@BeforeTest
	public void NavigateToProductionEntry() throws InterruptedException{
		wait = new WebDriverWait(driver, 10);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		
		//Navigate to Production ENtry 
		menu.Accessory();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		menu.ProductionManagement();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		Thread.sleep(2000);
		menu.ProductionEntry();
		Thread.sleep(1000);
		//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));

	}
	
	//ProductionEntry With Collapse Expand
	@Test(enabled = true, dataProvider = "ProductionData")
	public void ProductionEntry( String processName, String machineNo, String orderNo, String jobOrderNo, String prodtype, String operatorName) throws InterruptedException{
		
		try {
		wait = new WebDriverWait(driver, 20);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		
		productionEntry.SelectProcess(processName);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		productionEntry.SelectMachine(machineNo);
		Thread.sleep(1000);
		productionEntry.Search();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		Thread.sleep(3000);
		
		
		
		if (!orderNo.equals("")) {
			productionEntry.SelectOrderNo(orderNo);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
			Thread.sleep(1000);
		}
		
		productionEntry.SelectJobOrder(jobOrderNo);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		Thread.sleep(1000);

		productionEntry.SearchJobOrder();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		Thread.sleep(1000);
		
		
		
		
		
		productionEntry.SelectJobOrder();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		Thread.sleep(1000);
		
		productionEntry.SelectOperator(operatorName);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		Thread.sleep(1000);
		
		productionEntry.StartProcess();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		Thread.sleep(1000);
		
		productionEntry.SelectProductionType(prodtype);
		productionEntry.InsertProductionQty();
		Thread.sleep(1000);
		productionEntry.SaveProduction();
	
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		Thread.sleep(1000);
		//productionEntry.FinishProcess();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		productionEntry.CloseProcess();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		Thread.sleep(3000);
		
		} catch (InterruptedException e) {
			throw new AssertionError(" Design Receive From CS Test Case Faield", e);
		}
	}
	
	
	
	

	@DataProvider(name="ProductionData")
	public Object[][] getData() throws Exception{
		String excelPath =projectPath+"\\Excel_Data\\Production.xlsx";                 
		String sheetName = "ProductionEntry";
		Object data[][]= ExcelDataProvider.getDataFromExcel(excelPath, sheetName);
		return data;
	}
	

	

	
}

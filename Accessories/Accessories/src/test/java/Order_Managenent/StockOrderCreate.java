package Order_Managenent;

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

import com.aventstack.extentreports.Status;

import pages.Menu;
import pages.OM_OrderCreate;
import pages.OM_StockOrderCreate;
import utility.BaseClass;
import utility.ExcelDataProvider;

@Listeners(utility.Listener.class)
public class StockOrderCreate extends BaseClass {
	Menu menu = PageFactory.initElements(driver, Menu.class);
	OM_OrderCreate OrderCreate = PageFactory.initElements(driver, OM_OrderCreate.class);
	OM_StockOrderCreate stkOrder = PageFactory.initElements(driver, OM_StockOrderCreate.class);

	@BeforeTest
	public void navigateToCreate_StockOrder() throws InterruptedException {
		wait = new WebDriverWait(driver, 10);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		menu.Accessory();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		// Thread.sleep(1000);
		menu.SupplyChainManagement();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		menu.StockOrder();
		menu.CreaetStockOrder();
		// Thread.sleep(2000);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
	}

	// Test Case 1: Finished Main Label
	@Test(enabled = false, dataProvider = "CreateStockOrder", groups = { "smoke", "regression" })
	public void CareateStockOrder_ForFinishedMainLabel(String CustomerName, String BuyerName, String OrderNo,
			String bic, String OrderQty, String delvDate, String refOrdNo) throws Exception {

		logger = report.createTest("Careate Stock Order With Finish MAIN Label");

		try {
			InsertBasicInfo(CustomerName, BuyerName, OrderNo, delvDate, refOrdNo);
			InsertOrderItem(bic, OrderQty);
			SaveOrder();
		} catch (InterruptedException e) {
			throw new AssertionError(" Order could not be Created. " + e);
		}
	}

	// Test Case 2: Semi-Finished Main Label
	@Test(enabled = false, dataProvider = "CreateStockOrder", groups = { "smoke", "regression" })
	public void CareateStockOrder_ForSemiFinishedMainLabel(String CustomerName, String BuyerName, String OrderNo,
			String bic, String OrderQty, String delvDate, String refOrdNo, String process) throws Exception {

		logger = report.createTest("Careate Stock Order With Finish MAIN Label");

		try {
			InsertBasicInfo(CustomerName, BuyerName, OrderNo, delvDate, refOrdNo);
			InsertOrderItem(bic, OrderQty);
			stkOrder.clickOnSemiFinish();
			stkOrder.openProcessListPopup();
			Thread.sleep(1000);
			stkOrder.selectProcess(process);
			stkOrder.clickOnOkButton();
			SaveOrder();
		} catch (InterruptedException e) {
			throw new AssertionError(" Order could not be Created. " + e);
		}
	}

	// Test Case 3: Finished Care Label
	@Test(enabled = false, dataProvider = "CreateStockOrder", groups = { "regression" })
	public void CareateStockOrder_CareLabel(String CustomerName, String BuyerName, String OrderNo, String bic,
			String OrderQty, String delvDate, String refOrdNo, String nop, String comp, String addiComp)
			throws Exception {

		logger = report.createTest("Careate Stock Order With Finish CARE Label");
		try {

			InsertBasicInfo(CustomerName, BuyerName, OrderNo, delvDate, refOrdNo);
			InsertOrderItem(bic, OrderQty);

			OrderCreate.SelectComposition(comp);
			OrderCreate.SelectAdditionalComposition(addiComp);
			OrderCreate.SelectCareInstructions();
			OrderCreate.SelectAdditionalInfos();
			OrderCreate.InsertNOP(nop);

			SaveOrder();

		} catch (InterruptedException e) {
			throw new AssertionError(" Order could not be Created. " + e);
		}
	}

	// Test Case 4: Semi Finish Care Label
	@Test(enabled = true, dataProvider = "CreateStockOrder", groups = { "regression" })
	public void CareateStockOrder_SemiFinishCareLabel(String CustomerName, String BuyerName, String OrderNo, String bic,
			String OrderQty, String delvDate, String refOrdNo, String nop, String comp, String addiComp, String process)
			throws Exception {

		logger = report.createTest("Careate Stock Order With Semi-Finish CARE Label");
		try {

			InsertBasicInfo(CustomerName, BuyerName, OrderNo, delvDate, refOrdNo);
			InsertOrderItem(bic, OrderQty);

			OrderCreate.SelectComposition(comp);
			OrderCreate.SelectAdditionalComposition(addiComp);
			OrderCreate.SelectCareInstructions();
			OrderCreate.SelectAdditionalInfos();
			OrderCreate.InsertNOP(nop);

			stkOrder.clickOnSemiFinish();
			stkOrder.openProcessListPopup();
			Thread.sleep(1000);
			stkOrder.selectProcess(process);
			stkOrder.clickOnOkButton();
			SaveOrder();

		} catch (InterruptedException e) {
			throw new AssertionError(" Order could not be Creaetd. " + e);
		}
	}

	// Test Case 5: Multiple Part of Care And Size
	@Test(enabled = false, dataProvider = "CreateStockOrder", groups = { "regression" })
	public void CareateStockOrder_CareandSizeWiseMultiParts(String CustomerName, String BuyerName, String OrderNo,
			String bic, String OrderQty, String delvDate, String refOrdNo, String nop, String comp, String addiComp,
			String secNop, String secComp, String secAdComp) throws Exception {

		logger = report.createTest("Careate Stock Order With Finish Multiple PARTS Care & SIZE");
		try {

			InsertBasicInfo(CustomerName, BuyerName, OrderNo, delvDate, refOrdNo);
			InsertOrderItem(bic, OrderQty);

			int QTY = Integer.parseInt(OrderQty);
			int qtyPerPart = QTY / 2; // used 2 care inst wise part
			int qtyPerSize = qtyPerPart / 3; // used 3 size for each part

			// First Par's Info
			OrderCreate.InsertNOP(nop);
			OrderCreate.SelectComposition(comp);
			OrderCreate.SelectAdditionalComposition(addiComp);
			OrderCreate.SelectCareInstructions();
			OrderCreate.SelectExtraCareInst();
			OrderCreate.SelectAdditionalInfos();
			// OrderCreate.InsertItemOptionqty(qtyPerPart);

			OrderCreate.OpenSizePopup();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
			Thread.sleep(1000);
			OrderCreate.SelectSizes();
			OrderCreate.ClickOkButtonInSizePopup();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
			Thread.sleep(1000);
			OrderCreate.InsertSizeWiseOrderQty(qtyPerSize);

			OrderCreate.ClickOnAddAnotherCareInfo();

			// Second Part's info
			OrderCreate.InsertNOP(secNop);
			OrderCreate.SelectComposition(secComp);
			OrderCreate.SelectAdditionalComposition(secAdComp);
			// OrderCreate.InsertItemOptionqty(qtyPerPart);

			OrderCreate.OpenSizePopup();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
			Thread.sleep(1000);
			OrderCreate.SelectSizes();
			OrderCreate.ClickOkButtonInSizePopup();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
			Thread.sleep(1000);
			OrderCreate.InsertSizeWiseOrderQty(qtyPerSize);

			SaveOrder();
		} catch (InterruptedException e) {
			throw new AssertionError(" Order could not be Created. " + e);
		}
	}

	// Test Case 6: Multiple Part of Care And Size For Semi Finish
	@Test(enabled = false, dataProvider = "CreateStockOrder", groups = { "regression" })
	public void CareateStockOrder_SemiFinishCareandSizeWiseMultiParts(String CustomerName, String BuyerName,
			String OrderNo, String bic, String OrderQty, String delvDate, String refOrdNo, String nop, String comp,
			String addiComp, String secNop, String secComp, String secAdComp, String process) throws Exception {

		logger = report.createTest("Careate Stock Order With Semi-Finish Multiple PARTS Care & SIZE");
		try {

			InsertBasicInfo(CustomerName, BuyerName, OrderNo, delvDate, refOrdNo);
			InsertOrderItem(bic, OrderQty);

			int QTY = Integer.parseInt(OrderQty);
			int qtyPerPart = QTY / 2; // used 2 care inst wise part
			int qtyPerSize = qtyPerPart / 3; // used 3 size for each part

			// First Par's Info
			OrderCreate.InsertNOP(nop);
			OrderCreate.SelectComposition(comp);
			OrderCreate.SelectAdditionalComposition(addiComp);
			OrderCreate.SelectCareInstructions();
			OrderCreate.SelectExtraCareInst();
			OrderCreate.SelectAdditionalInfos();
			// OrderCreate.InsertItemOptionqty(qtyPerPart);
			OrderCreate.OpenSizePopup();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
			Thread.sleep(1000);
			OrderCreate.SelectSizes();
			OrderCreate.ClickOkButtonInSizePopup();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
			Thread.sleep(1000);
			OrderCreate.InsertSizeWiseOrderQty(qtyPerSize);
			OrderCreate.ClickOnAddAnotherCareInfo();

			// Second Part's info
			OrderCreate.InsertNOP(secNop);
			OrderCreate.SelectComposition(secComp);
			OrderCreate.SelectAdditionalComposition(secAdComp);
			// OrderCreate.InsertItemOptionqty(qtyPerPart);

			OrderCreate.OpenSizePopup();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
			Thread.sleep(1000);
			OrderCreate.SelectSizes();
			OrderCreate.ClickOkButtonInSizePopup();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
			Thread.sleep(1000);
			OrderCreate.InsertSizeWiseOrderQty(qtyPerSize);
			stkOrder.clickOnSemiFinish();
			stkOrder.openProcessListPopup();
			Thread.sleep(1000);
			stkOrder.selectProcess(process);
			stkOrder.clickOnOkButton();
			SaveOrder();
		} catch (InterruptedException e) {
			throw new AssertionError(" Order could not be Created. " + e);
		}
	}

	private void InsertBasicInfo(String CustomerName, String BuyerName, String OrderNo, String dlvdt, String refOrdNo)
			throws Exception {
		wait = new WebDriverWait(driver, 20);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		stkOrder.SelectCustomer(CustomerName);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		stkOrder.SelectBuyer(BuyerName);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		stkOrder.InserOrderNo(OrderNo);
		stkOrder.selectDeliveryDate(dlvdt);
		stkOrder.insertRefOrdNo(refOrdNo);
	}

	private void InsertOrderItem(String bic, String OrderQty) throws Exception {
		stkOrder.OpenBicPopup();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		Thread.sleep(1000);
		stkOrder.SearchByBIC(bic);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		Thread.sleep(1000);
		stkOrder.SeleclectBICForOrder();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		Thread.sleep(1000);
		OrderCreate.InsertOrderQrt(OrderQty);
	}

	private void SaveOrder() throws Exception {

		OrderCreate.SaveOrder();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		if (OrderCreate.VerifySaveOfOrder()) {
			logger.log(Status.INFO, "Test Success | " + getClass());
		}
		OrderCreate.AddNewOrder();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		Thread.sleep(1000);
	}

	@DataProvider(name = "CreateStockOrder")
	public Object[][] getData(ITestNGMethod testCase) throws Exception {
		Object data[][] = null;
		String excelPath = projectPath + "\\Excel_Data\\StockOrder.xlsx";

		if (testCase.getMethodName().contains("CareateStockOrder_MainLabel")) {
			String sheetName = "Main";
			data = ExcelDataProvider.getDataFromExcel(excelPath, sheetName);
		} else if (testCase.getMethodName().contains("CareateStockOrder_ForSemiFinishedMainLabel")) {
			String sheetName = "SemiFinishMain";
			data = ExcelDataProvider.getDataFromExcel(excelPath, sheetName);
		} else if (testCase.getMethodName().contains("CareateStockOrder_CareLabel")) {
			String sheetName = "Care";
			data = ExcelDataProvider.getDataFromExcel(excelPath, sheetName);
		} else if (testCase.getMethodName().contains("CareateStockOrder_SemiFinishCareLabel")) {
			String sheetName = "SemiFinishCare";
			data = ExcelDataProvider.getDataFromExcel(excelPath, sheetName);
		} else if (testCase.getMethodName().contains("CareateStockOrder_CareandSizeWiseMultiParts")) {
			String sheetName = "MultiPartCare&Size";
			data = ExcelDataProvider.getDataFromExcel(excelPath, sheetName);
		} else if (testCase.getMethodName().contains("CareateStockOrder_SemiFinishCareandSizeWiseMultiParts")) {
			String sheetName = "SemifinishMultiPartCare&Size";
			data = ExcelDataProvider.getDataFromExcel(excelPath, sheetName);
		} else {
			System.out.println("No Sheet assigned for " + testCase.getMethodName() + " Method");
		}

		return data;
	}

}

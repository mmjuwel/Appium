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

import net.bytebuddy.implementation.ExceptionMethod;
import pages.Menu;
import pages.OM_OrderCreate;
import utility.BaseClass;
import utility.ExcelDataWriter;
import utility.ExcelDataProvider;

@Listeners(utility.Listener.class)
public class OrderCreate extends BaseClass {

	Menu menu = PageFactory.initElements(driver, Menu.class);
	OM_OrderCreate OrderCreate = PageFactory.initElements(driver, OM_OrderCreate.class);
	ExcelDataWriter reader = new ExcelDataWriter(System.getProperty("user.dir")+"\\Excel_Data\\OrderVerification.xlsx");
	String sheetName = "OrderVerify";
	int rowFlag=2;

	@BeforeTest
	public void navigateToCreateOrder() throws InterruptedException {
		wait = new WebDriverWait(driver, 10);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		menu.Accessory();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		// Thread.sleep(1000);
		menu.CustomerSupport();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		menu.Order();
		menu.CreaetOrder();
		// Thread.sleep(2000);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
	}

	// Test Case 1: Main Label
	@Test(enabled = true, priority = 1, dataProvider = "CreateBaseOrder", groups = { "regression" })
	public void CareateOrder_MainLabel(String CustomerName, String po, String BuyerName, String brand, String OrdType,
			String OrderNo, String Deparment, String season, String StyleNo, String StyleName, String prodNo,
			String prodname, String gmtwash, String custCont, String bic, String itemprodNo, String OrderQty,
			String AppStatus, String ordSheet) throws Exception {

		logger = report.createTest("Careate Order with MAIN Label");

		try {
			InsertBasicInfo(CustomerName, po, BuyerName, OrdType, OrderNo, Deparment, season, StyleNo, StyleName,
					prodNo, prodname, gmtwash, custCont);
			InsertOrderItem(bic, itemprodNo, OrderQty);
			SaveOrder(AppStatus, ordSheet,OrderNo);
		} catch (InterruptedException e) {
			throw new AssertionError(" Order could not be Creaetd. " + e);
		}
		
		
	}

	// Test Case 2: Care Label
	@Test(enabled = false, priority = 2, dataProvider = "CreateBaseOrder", groups = { "regression" })
	public void CareateOrder_CareLabel(String CustomerName, String po, String BuyerName, String brand, String OrdType,
			String OrderNo, String Deparment, String season, String StyleNo, String StyleName, String prodNo,
			String prodname, String gmtwash, String custCont, String bic, String itemprodNo, String OrderQty,
			String nop, String comp, String addiComp, String AppStatus, String ordSheet) throws Exception {

		logger = report.createTest("Careate Order with CARE Label");
		try {
			InsertBasicInfo(CustomerName, po, BuyerName, OrdType, OrderNo, Deparment, season, StyleNo, StyleName,
					prodNo, prodname, gmtwash, custCont);
			InsertOrderItem(bic, itemprodNo, OrderQty);
			OrderCreate.SelectComposition(comp);
			OrderCreate.SelectAdditionalComposition(addiComp);
			OrderCreate.SelectCareInstructions();
			OrderCreate.SelectAdditionalInfos();
			OrderCreate.InsertNOP(nop);

			SaveOrder(AppStatus, ordSheet,OrderNo);

		} catch (InterruptedException e) {
			throw new AssertionError(" Order could not be Verified. " + e);
		}
	}

	// Test Case 3: Size Label
	@Test(enabled = false, priority = 3, dataProvider = "CreateBaseOrder", groups = { "regression" })
	public void CareateOrder_SizeLabel(String CustomerName, String po, String BuyerName, String brand, String OrdType,
			String OrderNo, String Deparment, String season, String StyleNo, String StyleName, String prodNo,
			String prodname, String gmtwash, String custCont, String bic, String itemprodNo, String OrderQty,
			String AppStatus, String ordSheet) throws Exception {

		logger = report.createTest("Careate Order with SIZE Label");
		try {
			InsertBasicInfo(CustomerName, po, BuyerName, OrdType, OrderNo, Deparment, season, StyleNo, StyleName,
					prodNo, prodname, gmtwash, custCont);
			InsertOrderItem(bic, itemprodNo, OrderQty);

			int QTY = Integer.parseInt(OrderQty);
			int qtyPerSize = QTY / 3; // Used 3 sized in POM

			OrderCreate.OpenSizePopup();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
			Thread.sleep(1000);
			OrderCreate.SelectSizes();
			OrderCreate.ClickOkButtonInSizePopup();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
			Thread.sleep(1000);
			OrderCreate.InsertSizeWiseOrderQty(qtyPerSize);

			SaveOrder(AppStatus, ordSheet,OrderNo);

		} catch (InterruptedException e) {
			throw new AssertionError(" Order could not be Verified. " + e);
		}
	}

	// Test Case 4: Care and Size Label
	@Test(enabled = false,priority = 4, dataProvider = "CreateBaseOrder", groups = { "regression" })
	public void CareateOrder_CareAndSizeLabel(String CustomerName, String po, String BuyerName, String brand,
			String OrdType, String OrderNo, String Deparment, String season, String StyleNo, String StyleName,
			String prodNo, String prodname, String gmtwash, String custCont, String bic, String itemprodNo,
			String OrderQty, String nop, String comp, String addiComp, String AppStatus, String ordSheet)
			throws Exception {
		logger = report.createTest("Careate Order with CARE & SIZE Label");
		try {
			int QTY = Integer.parseInt(OrderQty);
			int qtyPerSize = QTY / 3; // Used 3 sized in POM

			InsertBasicInfo(CustomerName, po, BuyerName, OrdType, OrderNo, Deparment, season, StyleNo, StyleName,
					prodNo, prodname, gmtwash, custCont);
			InsertOrderItem(bic, itemprodNo, OrderQty);

			OrderCreate.SelectComposition(comp);
			OrderCreate.SelectAdditionalComposition(addiComp);
			OrderCreate.SelectCareInstructions();
			OrderCreate.SelectAdditionalInfos();
			OrderCreate.InsertNOP(nop);

			OrderCreate.OpenSizePopup();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
			Thread.sleep(1000);
			OrderCreate.SelectSizes();
			OrderCreate.ClickOkButtonInSizePopup();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
			Thread.sleep(1000);
			OrderCreate.InsertSizeWiseOrderQty(qtyPerSize);

			SaveOrder(AppStatus, ordSheet,OrderNo);

		} catch (InterruptedException e) {
			throw new AssertionError(" Order could not be Verified. " + e);
		}
	}

	// Test Case 5: Taag With Variable
	@Test(enabled = false, priority = 5, dataProvider = "CreateBaseOrder", groups = { "regression" })
	public void CareateOrder_TagWithVariable(String CustomerName, String po, String BuyerName, String brand,
			String OrdType, String OrderNo, String Deparment, String season, String StyleNo, String StyleName,
			String prodNo, String prodname, String gmtwash, String custCont, String bic, String itemprodNo,
			String OrderQty, String numOfVari, String AppStatus, String ordSheet, String xlFilePath) throws Exception {

		logger = report.createTest("Careate Order with TAG & VARIABLE");

		try {
			int QTY = Integer.parseInt(OrderQty);
			InsertBasicInfo(CustomerName, po, BuyerName, OrdType, OrderNo, Deparment, season, StyleNo, StyleName,
					prodNo, prodname, gmtwash, custCont);
			InsertOrderItem(bic, itemprodNo, OrderQty);

			OrderCreate.SelectVariableData();

			if (numOfVari == "") {
				OrderCreate.ImportVariable(xlFilePath);
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
				Thread.sleep(1000);
			} else {
				int variable = Integer.parseInt(numOfVari);
				int qtyPerSize = QTY / variable;

				for (int i = 1; i <= variable; i++) {
					OrderCreate.InsertVariableInfo(i, "95.0(" + i + ")", qtyPerSize);
				}
			}
			SaveOrder(AppStatus, ordSheet,OrderNo);

		} catch (InterruptedException e) {
			throw new AssertionError(" Order could not be Verified. " + e);
		}
	}

	// Test Case 6: Composite
	@Test(enabled = false, priority = 6,dataProvider = "CreateBaseOrder", groups = { "regression" })
	public void CareateOrder_Composite(String CustomerName, String po, String BuyerName, String brand, String OrdType,
			String OrderNo, String Deparment, String season, String StyleNo, String StyleName, String prodNo,
			String prodname, String gmtwash, String custCont, String bic, String itemprodNo, String OrderQty,
			String AppStatus, String ordSheet) throws Exception {

		logger = report.createTest("Careate Order with COMPOSITE Item");
		try {
			InsertBasicInfo(CustomerName, po, BuyerName, OrdType, OrderNo, Deparment, season, StyleNo, StyleName,
					prodNo, prodname, gmtwash, custCont);
			InsertOrderItem(bic, itemprodNo, OrderQty);
			SaveOrder(AppStatus, ordSheet,OrderNo);

		} catch (InterruptedException e) {
			throw new AssertionError(" Order could not be Verified. " + e);
		}
	}

	// Test Case 7: Multiple Part of Care
	@Test(enabled = false, priority = 7,dataProvider = "CreateBaseOrder", groups = { "regression" })
	public void CareateOrder_CareWiseMultiParts(String CustomerName, String po, String BuyerName, String brand,
			String OrdType, String OrderNo, String Deparment, String season, String StyleNo, String StyleName,
			String prodNo, String prodname, String gmtwash, String custCont, String bic, String itemprodNo,
			String OrderQty, String nop, String comp, String addiComp, String secNop, String secComp, String secAdComp,
			String AppStatus, String ordSheet) throws Exception {

		logger = report.createTest("Create Order with CARE wise PARTS");
		try {
			InsertBasicInfo(CustomerName, po, BuyerName, OrdType, OrderNo, Deparment, season, StyleNo, StyleName,
					prodNo, prodname, gmtwash, custCont);
			InsertOrderItem(bic, itemprodNo, OrderQty);

			int QTY = Integer.parseInt(OrderQty);
			int qtyPerPart = QTY / 2; // used 2 care inst wise part

			OrderCreate.InsertNOP(nop);
			OrderCreate.SelectComposition(comp);
			OrderCreate.SelectAdditionalComposition(addiComp);
			OrderCreate.SelectCareInstructions();
			OrderCreate.SelectExtraCareInst();
			OrderCreate.SelectAdditionalInfos();
			OrderCreate.InsertItemOptionqty(qtyPerPart);

			OrderCreate.ClickOnAddAnotherCareInfo();

			OrderCreate.InsertNOP(secNop);
			OrderCreate.SelectComposition(secComp);
			OrderCreate.SelectAdditionalComposition(secAdComp);
			OrderCreate.InsertItemOptionqty(qtyPerPart);

			SaveOrder(AppStatus, ordSheet,OrderNo);
		} catch (InterruptedException e) {
			throw new AssertionError(" Order could not be Verified. " + e);
		}

	}

	// Test Case 8: Multiple Part of Care And Size
	@Test(enabled = false, priority = 8, dataProvider = "CreateBaseOrder", groups = { "regression" })
	public void CareateOrder_CareandSizeWiseMultiParts(String CustomerName, String po, String BuyerName, String brand,
			String OrdType, String OrderNo, String Deparment, String season, String StyleNo, String StyleName,
			String prodNo, String prodname, String gmtwash, String custCont, String bic, String itemprodNo,
			String OrderQty, String nop, String comp, String addiComp, String secNop, String secComp, String secAdComp,
			String AppStatus, String ordSheet) throws Exception {

		logger = report.createTest("Create Order with CARE wise Multiple PARTS & SIZE");
		try {
			InsertBasicInfo(CustomerName, po, BuyerName, OrdType, OrderNo, Deparment, season, StyleNo, StyleName,
					prodNo, prodname, gmtwash, custCont);
			InsertOrderItem(bic, itemprodNo, OrderQty);

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

			SaveOrder(AppStatus, ordSheet,OrderNo);
		} catch (InterruptedException e) {
			throw new AssertionError(" Order could not be Verified. " + e);
		}

	}

	// Test Case 9: Care Label Ignore Size
	@Test(enabled = false, priority = 9,dataProvider = "CreateBaseOrder", groups = { "regression" })
	public void CareateOrder_CareIgnoreSize(String CustomerName, String po, String BuyerName, String brand,
			String OrdType, String OrderNo, String Deparment, String season, String StyleNo, String StyleName,
			String prodNo, String prodname, String gmtwash, String custCont, String bic, String itemprodNo,
			String OrderQty, String comp, String addiComp, String AppStatus, String ordSheet) throws Exception {

		logger = report.createTest("Create Order with CARE Label ignoring Size ");
		try {
			InsertBasicInfo(CustomerName, po, BuyerName, OrdType, OrderNo, Deparment, season, StyleNo, StyleName,
					prodNo, prodname, gmtwash, custCont);
			InsertOrderItem(bic, itemprodNo, OrderQty);

			OrderCreate.UncheckIgnoreSize();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
			Thread.sleep(1000);
			OrderCreate.AcceptConfirmationModal();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));

			OrderCreate.SelectComposition(comp);
			OrderCreate.SelectAdditionalComposition(addiComp);
			OrderCreate.SelectCareInstructions();
			OrderCreate.SelectAdditionalInfos();

			SaveOrder(AppStatus, ordSheet,OrderNo);
		} catch (InterruptedException e) {
			throw new AssertionError(" Order could not be Verified. " + e);
		}
	}

	// Test Case 10: Multiple Item (3 item -> main, care, care and Size
	@Test(enabled = false, priority = 10,dataProvider = "CreateBaseOrder", groups = { "regression" })
	public void CareateOrder_MultipleItem(String CustomerName, String po, String BuyerName, String brand,
			String OrdType, String OrderNo, String Deparment, String season, String StyleNo, String StyleName,
			String prodNo, String prodname, String gmtwash, String custCont, String itemprodNo, String fstBic,
			String fstOrderQty, String secBic, String secOrdQty, String nop, String seccomp, String thBic,
			String thOrderQty, String thaddiComp, String AppStatus, String ordSheet) throws Exception {

		logger = report.createTest("Careate Order with Multiple Item");

		try {
			int QTY = Integer.parseInt(thOrderQty);
			int qtyPerSize = QTY / 3; // Used 3 sized in POM

			InsertBasicInfo(CustomerName, po, BuyerName, OrdType, OrderNo, Deparment, season, StyleNo, StyleName,
					prodNo, prodname, gmtwash, custCont);

			// Item 1 Main
			InsertOrderItem(fstBic, itemprodNo, fstOrderQty);

			// Item 2 Care
			InsertOrderItem(secBic, itemprodNo, secOrdQty);
			OrderCreate.SelectComposition(seccomp);
			OrderCreate.SelectCareInstructions();
			OrderCreate.InsertNOP(nop);

			// item 3 care and Size
			InsertOrderItem(thBic, itemprodNo, thOrderQty);
			OrderCreate.SelectAdditionalComposition(thaddiComp);
			OrderCreate.OpenSizePopup();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
			Thread.sleep(1000);
			OrderCreate.SelectSizes();
			OrderCreate.ClickOkButtonInSizePopup();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
			Thread.sleep(1000);
			OrderCreate.InsertSizeWiseOrderQty(qtyPerSize);

			SaveOrder(AppStatus, ordSheet,OrderNo);

		} catch (InterruptedException e) {
			throw new AssertionError(" Order could not be Verified. " + e);
		}
	}

	private void InsertBasicInfo(String CustomerName, String po, String BuyerName, String OrderType, String OrderNo,
			String Deparment, String season, String StyleNo, String StyleName, String prodNo, String prodname,
			String gmtwash, String custCont) throws Exception {
		wait = new WebDriverWait(driver, 20);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		OrderCreate.SelectCustomer(CustomerName);
		Thread.sleep(500);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		OrderCreate.InserCustomerPO(po);
		OrderCreate.SelectBuyer(BuyerName);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		OrderCreate.SelectOrderType(OrderType);
		OrderCreate.InserOrderNo(OrderNo+" A");
		OrderCreate.SelectDepartment(Deparment);
		OrderCreate.SelectSeason(season);
		OrderCreate.InsertStyleNo(StyleNo);
		OrderCreate.InsertStyleName(StyleName);
		OrderCreate.InsertProductNo(prodNo);
		OrderCreate.InsertProductName(prodname);
		OrderCreate.InsertReferanceNo("Ref123");
		OrderCreate.SelectGMTWashtype(gmtwash);
		OrderCreate.SelectCustomerContact(custCont);

	}

	private void InsertOrderItem(String bic, String itemprodNo, String OrderQty) throws Exception {
		OrderCreate.OpenBicPopup();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		Thread.sleep(1000);
		OrderCreate.SearchByBIC(bic);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		Thread.sleep(1000);
		OrderCreate.SeleclectBICForOrder();
		OrderCreate.ClickOkButtonInBICPopup();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		Thread.sleep(1000);
		OrderCreate.InsertItemProdNo(itemprodNo);
		OrderCreate.InsertOrderQrt(OrderQty);
	}

	private void SaveOrder(String AppStatus, String ordSheet, String OrderNo) throws Exception {
		OrderCreate.SelectApprovalStatus(AppStatus);
		OrderCreate.SelectDeliveryAddress();
		OrderCreate.SelectDeliveryDate();
		Thread.sleep(1000);
		// OrderCreate.AttachOrderSheet(projectPath + "/Excel_Data/ordersheet.pdf");
		OrderCreate.AttachOrderSheet(ordSheet);
		Thread.sleep(1000);
		OrderCreate.UploadSheet();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		Thread.sleep(3000);
		OrderCreate.CloseSheetpopup();
		OrderCreate.SaveOrder();
		Thread.sleep(300);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		String toastMessage=OrderCreate.TostMessage();
		
		
		if(toastMessage.contains("Data saved successfully.")) {
			System.out.println(toastMessage);
			
			reader.setCellData(sheetName,"OrderNo*",rowFlag,OrderNo);
						
			if (OrderCreate.VerifySaveOfOrder()) {
				logger.log(Status.INFO, "Test Success | " + getClass());
			}

			OrderCreate.AddNewOrder();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
			Thread.sleep(1000);
			rowFlag++;
		
		
		}
		
	}

	@DataProvider(name = "CreateBaseOrder")
	public Object[][] getData(ITestNGMethod testCase) throws Exception {
		Object data[][] = null;
		String excelPath = projectPath + "\\Excel_Data\\Order.xlsx";

		if (testCase.getMethodName().contains("CareateOrder_MainLabel")) {
			String sheetName = "Main";
			data = ExcelDataProvider.getDataFromExcel(excelPath, sheetName);
		} else if (testCase.getMethodName().contains("CareateOrder_CareLabel")) {
			String sheetName = "Care";
			data = ExcelDataProvider.getDataFromExcel(excelPath, sheetName);
		} else if (testCase.getMethodName().contains("CareateOrder_SizeLabel")) {
			String sheetName = "Size";
			data = ExcelDataProvider.getDataFromExcel(excelPath, sheetName);
		} else if (testCase.getMethodName().contains("CareateOrder_CareAndSizeLabel")) {
			String sheetName = "Care&Size";
			data = ExcelDataProvider.getDataFromExcel(excelPath, sheetName);
		} else if (testCase.getMethodName().contains("CareateOrder_TagWithVariable")) {
			String sheetName = "Tag";
			data = ExcelDataProvider.getDataFromExcel(excelPath, sheetName);
		} else if (testCase.getMethodName().contains("CareateOrder_Composite")) {
			String sheetName = "Composite";
			data = ExcelDataProvider.getDataFromExcel(excelPath, sheetName);
		} else if (testCase.getMethodName().contains("CareateOrder_CareWiseMultiParts")) {
			String sheetName = "CareWiseMultiParts";
			data = ExcelDataProvider.getDataFromExcel(excelPath, sheetName);
		} else if (testCase.getMethodName().contains("CareateOrder_CareandSizeWiseMultiParts")) {
			String sheetName = "CareandSizeWiseMultiParts";
			data = ExcelDataProvider.getDataFromExcel(excelPath, sheetName);
		} else if (testCase.getMethodName().contains("CareateOrder_CareIgnoreSize")) {
			String sheetName = "CareIgnoreSize";
			data = ExcelDataProvider.getDataFromExcel(excelPath, sheetName);
		} else if (testCase.getMethodName().contains("CareateOrder_MultipleItem")) {
			String sheetName = "MultipleOrderItem";
			data = ExcelDataProvider.getDataFromExcel(excelPath, sheetName);
		} else {
			System.out.println("No Sheet assigned for " + testCase.getMethodName() + " Method");
		}

		return data;
	}
}

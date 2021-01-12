package Order_Managenent;

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
import pages.OM_OrderCreate;
import pages.OM_OrderVerification;
import utility.BaseClass;
import utility.ExcelDataProvider;

@Listeners(utility.Listener.class)
public class OrderVarification extends BaseClass {

	Menu menu = PageFactory.initElements(driver, Menu.class);
	OM_OrderVerification OrderVerify = PageFactory.initElements(driver, OM_OrderVerification.class);
	OM_OrderCreate OrderCreate = PageFactory.initElements(driver, OM_OrderCreate.class);

	@BeforeTest
	public void navigateToOrderVerification() throws InterruptedException {
		wait = new WebDriverWait(driver, 30);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		menu.Accessory();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		// Thread.sleep(1000);
		menu.CustomerSupport();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		menu.OrderVerification();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
	}

	@Test(enabled = true, dataProvider = "varifyOder", groups = { "smoke", "regression" })
	public void VerifyOrder(String customer, String orderNo) throws Throwable {
		logger = report.createTest("Order Verification");

		try {
			if (customer != "") {
				OrderVerify.SearchByCustomer(customer);
			}

			OrderVerify.SearchByOrderNo(orderNo);
			OrderVerify.ClickOnSearchbutton();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
			OrderVerify.SeleclectOrderForVerify();
			Thread.sleep(1000);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));

			OrderVerify.ClickOnVerifyButton();
			Thread.sleep(1000);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
			Thread.sleep(1000);
			Assert.assertTrue(OrderVerify.ConfirmVerification());

		} catch (InterruptedException e) {
			throw new AssertionError(" Order could not be Verified. " + e);
		}
	}

	@Test(enabled = false, dataProvider = "varifyOder", groups = { "regression" })
	public void Varification_DeleteOrderItem(String buyer, String customer, String orderNo, String bic)
			throws Throwable {
		logger = report.createTest("Delete Orfer Item From Verification");

		try {
			if (buyer != "") {
				OrderVerify.SearchByBuyer(buyer);
			}

			if (customer != "") {
				OrderVerify.SearchByCustomer(customer);
			}

			OrderVerify.SearchByOrderNo(orderNo);
			OrderVerify.ClickOnSearchbutton();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
			OrderVerify.SeleclectOrderForVerify();
			Thread.sleep(1000);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));

			OrderVerify.SelectOrderItemForDelete(bic);
			Thread.sleep(1000);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
			OrderVerify.AcceptConfirmationModal();
			Thread.sleep(1000);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
			OrderVerify.ClickOnVerifyButton();
			Thread.sleep(1000);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
			Thread.sleep(1000);
			Assert.assertTrue((OrderVerify.ConfirmVerification()));
			
		} catch (InterruptedException e) {
			throw new AssertionError(" Item could not be Deleted. " + e);
		}
	}

	
	@Test(enabled = false, dataProvider = "varifyOder", groups = { "regression" })
	public void Varification_AddOrderItem(String buyer, String customer, String orderNo, String bic, String itemprodNo,
			String itemType, String ordQty, String nop, String comp, String AppStatus) throws Throwable {
		logger = report.createTest("Add Orfer Item From Verification");

		try {
			if (buyer != "") {
				OrderVerify.SearchByBuyer(buyer);
			}

			if (customer != "") {
				OrderVerify.SearchByCustomer(customer);
			}

			OrderVerify.SearchByOrderNo(orderNo);
			OrderVerify.ClickOnSearchbutton();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
			OrderVerify.SeleclectOrderForVerify();
			Thread.sleep(1000);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));

			InsertOrderItem(bic, itemprodNo, ordQty, AppStatus);

			if (itemType.equals("Care")) {

				OrderCreate.SelectComposition(comp);
				// OrderCreate.SelectCareInstructions();
				OrderCreate.InsertNOP(nop);
			}

			else if (itemType.equals("Size") || itemType.contains("Main & Size")) {

				int QTY = Integer.parseInt(ordQty);
				int qtyPerSize = QTY / 3; // Used 3 sized in POM

				OrderCreate.OpenSizePopup();
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
				Thread.sleep(1000);
				OrderCreate.SelectSizes();
				OrderCreate.ClickOkButtonInSizePopup();
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
				Thread.sleep(1000);
				OrderCreate.InsertSizeWiseOrderQty(qtyPerSize);
			}

			else if (itemType.equals("Care and Size") || itemType.contains("Care & Size")) {

				int QTY = Integer.parseInt(ordQty);
				int qtyPerSize = QTY / 3; // Used 3 sized in POM

				OrderCreate.SelectComposition(comp);
				OrderCreate.InsertNOP(nop);

				OrderCreate.OpenSizePopup();
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
				Thread.sleep(1000);
				OrderCreate.SelectSizes();
				OrderCreate.ClickOkButtonInSizePopup();
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
				Thread.sleep(1000);
				OrderCreate.InsertSizeWiseOrderQty(qtyPerSize);
			}

			else if (itemType.equals("Tag")) {

				OrderCreate.SelectVariableData();

				int variable = Integer.parseInt(nop);
				int qtyPerSize = Integer.parseInt(ordQty) / variable;

				for (int i = 1; i <= variable; i++) {
					OrderCreate.InsertVariableInfo(i, "95.0(" + i + ")", qtyPerSize);
				}
			}

			OrderVerify.ClickOnVerifyButton();
			Thread.sleep(1000);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
			Thread.sleep(1000);
			Assert.assertTrue((OrderVerify.ConfirmVerification()));

		} catch (InterruptedException e) {
			throw new AssertionError(" Item could not be Added. " + e);
		}
	}

	private void InsertOrderItem(String bic, String itemprodNo, String OrderQty, String AppStatus) throws Exception {
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
		OrderCreate.SelectApprovalStatusForItem(AppStatus);
	}

	@DataProvider(name = "varifyOder")
	public Object[][] getData(ITestNGMethod testCase) throws Exception {
		Object data[][] = null;
		String excelPath = projectPath + "/Excel_Data/OrderVerification1.xlsx";
		if (testCase.getMethodName().contains("VerifyOrder")) {
			String sheetName = "OrderVerify";
			data = ExcelDataProvider.getDataFromExcel(excelPath, sheetName);
		} else if (testCase.getMethodName().contains("Varification_DeleteOrderItem")) {
			String sheetName = "DeleteBICFromVarification";
			data = ExcelDataProvider.getDataFromExcel(excelPath, sheetName);
		} else if (testCase.getMethodName().contains("Varification_AddOrderItem")) {
			String sheetName = "AddBICFromVarification";
			data = ExcelDataProvider.getDataFromExcel(excelPath, sheetName);
		}
		return data;
	}

}

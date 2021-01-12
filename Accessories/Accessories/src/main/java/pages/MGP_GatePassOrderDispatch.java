package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import net.bytebuddy.implementation.bytecode.ByteCodeAppender.Size;

public class MGP_GatePassOrderDispatch {

	// Customer dropdown
	@FindBy(how = How.XPATH, using = "//div[@data-ng-model='searchModel.customerID']//a//b")
	private WebElement customer;

	@FindBy(how = How.XPATH, using = "//div[@class='ui-select-dropdown select2-drop select2-with-searchbox select2-drop-active']//input")
	private WebElement insertCustomer;
	@FindBy(how = How.XPATH, using = "//div[@class='ui-select-dropdown select2-drop select2-with-searchbox select2-drop-active']//ul//li//ul//li")
	private WebElement selectCustomer;

	// Delivery Plan dropdwon

	@FindBy(how = How.XPATH, using = "//div[@data-ng-model='searchModel.planID']//a")
	private WebElement deliveryPlanNo;

	@FindBy(how = How.XPATH, using = "//div[@class='ui-select-dropdown select2-drop select2-with-searchbox select2-drop-active']//input")
	private WebElement insertDeliveryPlanNo;

	@FindBy(how = How.XPATH, using = "//div[@class='ui-select-dropdown select2-drop select2-with-searchbox select2-drop-active']//ul//li//ul//li")
	private WebElement selectDeliveryPlanNo;

	// Challan No dropdown
	@FindBy(how = How.XPATH, using = "//div[@data-ng-model='searchModel.challanID']//a")
	private WebElement challanNo;

	@FindBy(how = How.XPATH, using = "//div[@class='ui-select-dropdown select2-drop select2-with-searchbox select2-drop-active']//input")
	private WebElement insertChallanNo;

	@FindBy(how = How.XPATH, using = "//div[@class='ui-select-dropdown select2-drop select2-with-searchbox select2-drop-active']//ul//li//ul//li")
	private WebElement selectChallanNo;

	// Search Button

	@FindBy(how = How.XPATH, using = "//button[@class='btn btn-search btn-primary']")
	private WebElement searchButton;

	// Grid

	@FindBy(how = How.XPATH, using = "//table[starts-with(@id,'_gridID')]//tbody/tr[1]//td[1]//label//input")
	private WebElement gdDeliveryPlanNo;

	// Acknowledge button

	@FindAll(@FindBy(how = How.XPATH, using = "//span[.='Acknowledge']"))
	private List<WebElement> acknowledgeButton;

	// All action list
	@FindAll(@FindBy(how = How.XPATH, using = "//a[@data-ng-click='onSelectChallanGatePass(deliveryPlan)']"))
	private List<WebElement> challanAction;

	@FindBy(how = How.XPATH, using = "//button[@class='btn btn-reject btn-danger']")
	private WebElement reject;

	@FindBy(how = How.ID, using = "btnOk")
	private WebElement rejectYes;

	@FindBy(how = How.ID, using = "btnClose")
	private WebElement rejectNo;

	public void SelectCustomer(String CustomerName) {
		customer.click();
		insertCustomer.clear();
		insertCustomer.sendKeys(CustomerName);
		selectCustomer.click();
	}

	public void SelectChallanNo(String ChallanNo) {
		challanNo.click();
		insertChallanNo.clear();
		insertChallanNo.sendKeys(ChallanNo);
		selectChallanNo.click();

	}

	public void SelectDeliveryPlanNo(String DeliveryPlanNo) {
		deliveryPlanNo.click();
		insertDeliveryPlanNo.clear();
		insertDeliveryPlanNo.sendKeys(DeliveryPlanNo);
		selectDeliveryPlanNo.click();
	}

	public void SearchButton() {
		searchButton.click();
	}

	public void clickOnGridDeliveryPlanNoCheckbox() {
		gdDeliveryPlanNo.click();
	}

	public boolean Confirm_GPDNO() {
		return gdDeliveryPlanNo.isSelected();
	}

	public int getTotalActionNo() {
		return challanAction.size();
	}

	public void ClickOnChallan(int index) {
		challanAction.get(index).click();
	}

	public void Acknowledge() {
		acknowledgeButton.get(acknowledgeButton.size() - 1).click();
	}

	public void Reject(String status) {

		reject.click();

		if (status.equalsIgnoreCase("Yes")) {
			rejectYes.click();
		} else {
			rejectNo.click();
		}
	}
}

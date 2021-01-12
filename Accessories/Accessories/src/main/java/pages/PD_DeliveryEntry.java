package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class PD_DeliveryEntry {

	@FindBy(how = How.CSS, using = "[data-ng-click='showDeliveryPlanList()']")
	private WebElement selectPlan;

	// search
	@FindBy(how = How.CSS, using = "[data-ng-model='planSearchObj.planID']")
	private WebElement searchByPlanNo;
	@FindBy(how = How.CSS, using = "[data-ng-model='planSearchObj.customerID']")
	private WebElement searchByCustomer;
	@FindBy(how = How.CSS, using = "[data-ng-bind-html='customer.customerName | highlight: $select.search']")
	private WebElement selectCustForSearch;

	@FindBy(how = How.CSS, using = "div[class='ui-select-dropdown select2-drop select2-with-searchbox select2-drop-active']>div>input[ng-model='$select.search']")
	private WebElement insertitemForSearch;
	@FindAll(@FindBy(how = How.CSS, using = ".ui-select-highlight"))
	private List<WebElement> selectHighlightedItemForSearch;

	@FindBy(how = How.CSS, using = "button.btn-search > span")
	private WebElement searchButton;

	@FindBy(how = How.CSS, using = "[data-ni-click='selectEntity(entity)']")
	private WebElement selectPlanItem;

	@FindBy(how = How.CSS, using = "[data-ng-model='entity.deliStatusCd']")
	private WebElement deliveryStatus;

	@FindBy(how = How.CSS, using = "[data-ng-click='toggleSelect($event)']")
	private WebElement receiveBy;
	@FindAll(@FindBy(how = How.CSS, using = "[ng-click='handleClick($event,i)']"))
	private List<WebElement> receiveByOptions;
	@FindBy(how = How.CSS, using = "[ng-click='handleClick($event,i)']>textarea")
	private WebElement rcvrNameInput;
	
	@FindBy(how = How.CSS, using = "[ng-click='addNewItem()']")
	private WebElement okButtonOfRcvItm;
	@FindBy(how = How.CSS, using = "div.disabled")
	private WebElement challanNumbers;
	
	public String getChallanNumbers() {
		
		return challanNumbers.getText();
	}
	
	
	
	
	@FindBy(how = How.CSS, using = "[data-ng-model='entity.chlnAckStatusCd']")
	private WebElement ChallanAckStatus;

	@FindBy(how = How.CSS, using = "[data-ni-click='save($formValidation)']")
	private WebElement saveButton;
	@FindBy(how = How.CSS, using = ".btn-primary")
	private WebElement newDeliveryEntry;
	@FindBy(how = How.ID, using = "btnOk")
	private WebElement acceptConfirmation;

	public void OpenDeliveryPlanPopup() {
		selectPlan.click();
	}
	
	public void SearchByPlanNo(String planNo) {
		searchByPlanNo.click();
		insertitemForSearch.clear();
		insertitemForSearch.sendKeys(planNo);
		WebElement hilightedItem = selectHighlightedItemForSearch.get(0);
		hilightedItem.click();
	}

	public void SearchByCustomer(String customerName) {
		searchByCustomer.click();
		insertitemForSearch.clear();
		insertitemForSearch.sendKeys(customerName);
		selectCustForSearch.click();
	}

	public void ClickOnSearchbutton() {
		searchButton.click();
	}

	public void SelectPlanItem() {
		selectPlanItem.click();
	}

	public void SelectDeliveryStatus(String status) {
		Select delistatus = new Select(deliveryStatus);
		delistatus.selectByVisibleText(status);
	}

	public void SelectReceiveBy(String ReceiveBy) {
		receiveBy.click();
		boolean status = false;
		for (WebElement rcvItem : receiveByOptions) {
			if (rcvItem.getText().contains(ReceiveBy)) {
				rcvItem.click();
				status = true;
				break;
			}
		}

		if (status == false) {
			rcvrNameInput.clear();
			rcvrNameInput.sendKeys(ReceiveBy);
			okButtonOfRcvItm.click();
		}
	}

	public void SelectChallanAckStatus(String ChallanStatus) {
		Select clnSt = new Select(ChallanAckStatus);
		clnSt.selectByVisibleText(ChallanStatus);
	}

	public void ClickOnSaveButton() {
		saveButton.click();
	}

	public boolean ConfirmSave() {
		boolean status=false;
		if(!newDeliveryEntry.isEnabled())
		{
			status=true;
		}
		return status;
	}

	public void ClickOnNewplanButton() {
		newDeliveryEntry.click();
	}
	public void AcceptConfirmation() {
		acceptConfirmation.click();
	}

}

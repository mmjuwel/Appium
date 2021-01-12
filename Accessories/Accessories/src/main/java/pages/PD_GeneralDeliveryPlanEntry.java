package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class PD_GeneralDeliveryPlanEntry {

	@FindBy(how = How.CSS, using = "[data-ng-click='showChallanModal()']")
	WebElement selectChallanpopup;

	@FindBy(how = How.CSS, using = "[data-ng-model='searchEntity.customerID']")
	WebElement searchByCustomer;
	@FindBy(how = How.CSS, using = "div[data-ng-model='searchEntity.customerID'] [name='searchText']")
	WebElement insertCustomerToSearch;

	@FindBy(how = How.CSS, using = "[data-ng-model='searchEntity.challanNo']")
	WebElement searchByChallanNo;
	@FindBy(how = How.CSS, using = "div[data-ng-model='searchEntity.challanNo'] [name='searchText']")
	WebElement insertChalalnNoToSearch;
	@FindBy(how = How.CSS, using = "div[data-ng-model='searchEntity.challanNo'] .checkbox")
	WebElement selectChallanToSearch;

	@FindBy(how = How.CSS, using = "[data-ni-click='search()']")
	WebElement searchButton;

//Datepicker
	@FindBy(how = How.CSS, using = "[data-ng-model='model.shipPlan.dispatchDateTime']")
	WebElement datePicker;
	@FindAll(@FindBy(how = How.CSS, using = ".ui-state-default"))
	List<WebElement> date;
	
	
	@FindBy(how = How.CSS, using = "[data-ni-click='expandChallanClick(entity,$event)']")
	WebElement itemExpand;
	@FindBy(how = How.CSS, using = "[data-ng-model='entity.isSelected']")
	WebElement selectChallan;

	@FindBy(how = How.CSS, using = "[data-ng-click='ok()']")
	WebElement OKButton;

	@FindBy(how = How.CSS, using = "[data-ng-model='model.shipPlan.dispatchDateTime']")
	WebElement deliveryDate;
	@FindBy(how = How.CSS, using = "[data-ng-model='model.shipPlan.vehicleID']")
	WebElement vehicle;
	@FindBy(how = How.CSS, using = "[data-ng-model='model.shipPlan.driverID']")
	WebElement driverman;
	@FindBy(how = How.CSS, using = "[data-ng-model='model.shipPlan.deliManID']")
	WebElement deliveryMan;

	@FindBy(how = How.CSS, using = "[data-ng-click='toggleSelect()']")
	WebElement remarks;
	@FindBy(how = How.CSS, using = "[data-ng-model='textOption.otherText']")
	List<WebElement> insertRemarks;

	@FindBy(how = How.CSS, using = ".btn-save")
	WebElement saveButton;
	
	@FindBy(how = How.XPATH, using = "//div[@class='toast-message']")
	private WebElement getToastMessage;
	@FindBy(how = How.CSS, using = "[data-ng-model='model.shipPlan.planNo']")
	private WebElement gdpNo;
	@FindBy(how = How.CSS, using = "[data-ng-click='addNew()']")
	WebElement addNewButton;

	// Search
	public void openSelectChallanPopup() {
		selectChallanpopup.click();
	}

	public void searchByChallanNo(String challanNo) {
		searchByChallanNo.click();
		insertChalalnNoToSearch.sendKeys(challanNo);
		selectChallanToSearch.click();
	}

	public void searchByCustomer(String customer) {
		searchByCustomer.click();
		insertCustomerToSearch.sendKeys(customer);

	}

	public void clickOnSearchButton() {
		searchButton.click();
	}

	public void clickOnExpandChallanItem() {
		if (itemExpand.isDisplayed()) {
		itemExpand.click();
		}
	}

	public void selectChallamItem() {
		selectChallan.click();
	}

	public void clickOnOKbutton() {
		OKButton.click();
	}


	public void selectDate(String Date) {
		datePicker.click();
		for (WebElement we : date)

		{
			if (we.getText().equals(Date)) {
				we.click();
				break;
			}
		}
	}

	public void selectVehicle(String vehicleNo) {
		Select vh = new Select(vehicle);
		vh.selectByVisibleText(vehicleNo);

	}

	public void selectDriver(String DriverName) {
		Select drv = new Select(driverman);
		drv.selectByVisibleText(DriverName);
		// drv.selectByIndex(1);
	}

	public void selectDeliveryman(String DeliveryMan) {
		Select delman = new Select(deliveryMan);
		delman.selectByVisibleText(DeliveryMan);
		// delman.selectByIndex(1);
	}

	public void insertRemarks(String remark) {
		remarks.click();
		insertRemarks.get(0).clear();
		insertRemarks.get(0).sendKeys(remark);
	}

	public void clickOnSavebutton() {
		saveButton.click();
	}
	
	
	
	public String TostMessage() {
		return getToastMessage.getText();
	}
	public String getGenarelDeliverryPlanNo() {
		return gdpNo.getAttribute("value");
	}
	
	

	public boolean confiramSave() {
		boolean status = false;
		if (addNewButton.isEnabled()) {
			status = true;
		}
		return status;
	}

	public void clickOnAddNewbutton() {
		addNewButton.click();
	}

}

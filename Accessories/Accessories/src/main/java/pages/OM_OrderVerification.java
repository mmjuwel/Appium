package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class OM_OrderVerification {

	// Search Fields
	@FindBy(how = How.CSS, using = "[data-ng-model='searchParams.buyer']")
	WebElement searchByBuyer;
	@FindBy(how = How.CSS, using = "[data-ng-model='searchParams.customer']")
	WebElement searchByCustomer;
	@FindBy(how = How.CSS, using = "[data-ng-model='searchParams.orderNo']")
	WebElement searchByOrder;

	@FindBy(how = How.CSS, using = "div[class='ui-select-dropdown select2-drop select2-with-searchbox select2-drop-active']>div>input[ng-model='$select.search']")
	WebElement insertitemForSearch;

	@FindAll(@FindBy(how = How.CSS, using = ".ui-select-highlight"))
	List<WebElement> selectHighlightedItemForSearch;

	@FindBy(how = How.CSS, using = "button.btn-search > span")
	WebElement searchButton;

	@FindBy(how = How.CSS, using = "[data-ng-click='selectOrder(data)']")
	List<WebElement> selectOrder;

	@FindAll(@FindBy(how = How.CSS, using = "[data-ng-repeat='orderItem in ordItemList']"))
	List<WebElement> orderItemRow;
	@FindAll(@FindBy(how = How.CSS, using = "[data-ni-click='deleteOrderItem(orderItem,$formValidation)']"))
	List<WebElement> itemDeletebtn;

	@FindBy(how = How.ID, using = "btnOk")
	WebElement AcceptConfiramtionModal;
	
	@FindBy(how = How.CSS, using = "[data-ni-click='save($formValidation)']")
	WebElement verifyButton;

	public void SearchByBuyer(String customerName) {
		searchByBuyer.click();
		insertitemForSearch.clear();
		insertitemForSearch.sendKeys(customerName);

		WebElement hilightedItem = selectHighlightedItemForSearch.get(0);
		hilightedItem.click();
	}

	public void SearchByCustomer(String customerName) {
		searchByCustomer.click();
		insertitemForSearch.clear();
		insertitemForSearch.sendKeys(customerName);

		WebElement hilightedItem = selectHighlightedItemForSearch.get(0);
		hilightedItem.click();
	}

	public void SearchByOrderNo(String orderNo) {
		searchByOrder.click();
		insertitemForSearch.clear();
		insertitemForSearch.sendKeys(orderNo);

		WebElement hilightedItem = selectHighlightedItemForSearch.get(0);
		hilightedItem.click();
	}

	public void ClickOnSearchbutton() {
		searchButton.click();
	}

	public void SeleclectOrderForVerify() {
		WebElement Order = selectOrder.get(0); // always select first one after search
		Order.click();
	}

	public void SelectOrderItemForDelete(String bic) {

		int i = 0;
		for (WebElement itemList : orderItemRow) {
			if (itemList.getText().contains(bic)) {

				WebElement delete = itemDeletebtn.get(i);
				delete.click();
			}
			i++;
		}
	}

	public void AcceptConfirmationModal() {
		AcceptConfiramtionModal.click();
	}

	public void ClickOnVerifyButton() {
		verifyButton.click();
	}

	public boolean ConfirmVerification() {

		boolean status = false;
		if (searchButton.isDisplayed()) {
			status = true;
		}
		return status;
	}

}

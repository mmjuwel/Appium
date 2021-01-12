package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class OM_StockOrderCreate {

	// Select Customer
	@FindBy(how = How.CSS, using = "[data-ng-model='vmv.order.customerID']")
	private WebElement customer;

	// Global Path
	@FindBy(how = How.CSS, using = "div[class='ui-select-dropdown select2-drop select2-with-searchbox select2-drop-active']>div>input[ng-model='$select.search']")
	private WebElement insertForSearch;
	@FindBy(how = How.CSS, using = "div.ui-select-dropdown>ul>li>ul>li>div>div.ng-binding")
	private WebElement selecHltitem;

	// Select Buyer
	@FindBy(how = How.CSS, using = "[data-ng-model='vmv.order.buyerID']")
	private WebElement buyer;

	// Basic info
	@FindBy(how = How.CSS, using = "[data-ng-model='vmv.order.orderNO']")
	private WebElement orderNo;

	@FindBy(how = How.CSS, using = "[data-ng-model='vmv.order.deliveryDate']")
	private WebElement openDeliveryDatePopup;
	@FindAll(@FindBy(how = How.CSS, using = ".ui-state-default"))
	List<WebElement> date;

	@FindBy(how = How.CSS, using = "[data-ng-model='vmv.order.refOrderNo']")
	private WebElement refOrdNo;

	// select_BIC_start
	@FindBy(how = How.CSS, using = "button.btn-selectItem")
	private WebElement bicPopupButton;
	@FindBy(how = How.CSS, using = "[data-ng-model='searchParams.buyerItemCode']")
	private WebElement bicBySearch;

	@FindBy(how = How.CSS, using = "[data-ni-click='search()']")
	private WebElement searchButton;
	@FindAll(@FindBy(how = How.CSS, using = "[ng-click='selectItem(itemCode)']"))
	private List<WebElement> selectBICForOrder;
	// End Select BIC

	// Semi-Finished
	@FindBy(how = How.CSS, using = "[data-ng-model='vmv.order.isSemifinished']")
	private List <WebElement> semiFinished;

	@FindBy(how = How.CSS, using = "[ng-click='showProcess(orderItem)']")
	private WebElement processListPopup;
	@FindAll(@FindBy(how = How.CSS, using = "[ng-repeat='process in grp.processList']"))
	private List<WebElement> processes;
	@FindAll(@FindBy(how = How.CSS, using = "[data-ng-model='process.isSelected']"))
	private List<WebElement> selectProcess;
	@FindBy(how = How.CSS, using = "[data-ng-click='ok()']")
	private WebElement okbutton;

	public void SelectCustomer(String CustomerName) {
		customer.click();
		insertForSearch.clear();
		insertForSearch.sendKeys(CustomerName);
		selecHltitem.click();
	}

	public void SelectBuyer(String BuyerName) throws Exception {
		buyer.click();
		insertForSearch.clear();
		insertForSearch.sendKeys(BuyerName);
		//Thread.sleep(1000);
		selecHltitem.click();
	}

	public void InserOrderNo(String OrderNo) {
		orderNo.clear();
		orderNo.sendKeys(OrderNo);
	}

	public void selectDeliveryDate(String Date) {
		openDeliveryDatePopup.click();
		for (WebElement we : date)

		{
			if (we.getText().equals(Date)) {
				we.click();
				break;
			}
		}
	}

	public void insertRefOrdNo(String refNo) {
		refOrdNo.clear();
		refOrdNo.sendKeys(refNo);
	}

	// Select BIC
	public void OpenBicPopup() {
		bicPopupButton.click();
	}

	public void SearchByBIC(String bic) {
		bicBySearch.click();
		insertForSearch.clear();
		insertForSearch.sendKeys(bic);
		selecHltitem.click();
		searchButton.click();
	}

	public void SeleclectBICForOrder() {
		WebElement BICitem = selectBICForOrder.get(0);
		BICitem.click();
	}

	// Semi-Finished
	public void clickOnSemiFinish() {
		semiFinished.get(1).click();
	}

	public void openProcessListPopup() {
		processListPopup.click();
	}

	public void selectProcess(String process) {
		int i = 0;
		for (WebElement we : processes) {
			if (we.getText().contains(process)) {
				selectProcess.get(i).click();
				break;
			}
			i++;
		}
	}
	
	public void clickOnOkButton() {
		okbutton.click();
	}

}

package pages;

import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.BaseClass;

public class OM_OrderMasterFileIssue {

	// Search Fields
	@FindBy(how = How.CSS, using = "[data-ng-model='searchEntity.buyerID']")
	WebElement searchByBuyer;
	@FindBy(how = How.CSS, using = "[data-ng-model='searchEntity.customerID']")
	WebElement searchByCustomer;
	@FindBy(how = How.CSS, using = "[data-ng-model='searchEntity.orderNo']")
	WebElement searchByOrder;
	@FindBy(how = How.CSS, using = "[data-ng-model='searchEntity.buyerItemCode']")
	WebElement searchByBIC;

	@FindBy(how = How.CSS, using = "div[class='ui-select-dropdown select2-drop select2-with-searchbox select2-drop-active']>div>input[ng-model='$select.search']")
	WebElement insertitemForSearch;

	@FindAll(@FindBy(how = How.CSS, using = ".ui-select-highlight"))
	List<WebElement> selectHighlightedItemForSearch;

	@FindBy(how = How.CSS, using = "[data-ng-click='search()']")
	WebElement searchButton;
	@FindBy(how = How.CSS, using = "[data-ng-click='reset()']")
	WebElement resetButton;

	@FindAll(@FindBy(how = How.CSS, using = "[data-ng-model='data.isCSToProdRcvd ']"))
	List<WebElement> ProdReceiveFromCS;

	@FindAll(@FindBy(how = How.CSS, using = "[data-ng-model='data.isCSToDsgnRcvd']"))
	List<WebElement> DesignReceiveFromCS;

	@FindAll(@FindBy(how = How.CSS, using = "[data-ng-model='data.isDsgnToProdRcvd']"))
	List<WebElement> ProdReceiveFromDesign;

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

	public void SearchByBIC(String bic) {
		searchByBIC.click();
		insertitemForSearch.clear();
		insertitemForSearch.sendKeys(bic);

		WebElement hilightedItem = selectHighlightedItemForSearch.get(0);
		hilightedItem.click();
	}

	public void ClickOnSearchbutton() {
		searchButton.click();
	}
	public void ResetSearh() {
		resetButton.click();
	}
	
	

	public int getTotalItem() {
		int sz=0;
		 sz=ProdReceiveFromCS.size();
		return sz;
	}
	
	
	
	public void ProductionReceiveFromCS(int i) {
		ProdReceiveFromCS.get(i).click();
	}
	
	public boolean Confirm_ProductionReceiveFromCS() {
		boolean status = true;
		for (WebElement we : ProdReceiveFromCS) {
			status = true;
			if (we.isEnabled()) {
				status = false;
				break;
			}
		}
		return status;
	}
	
	
	
	public void DesignReceiveFromCS(int i) {
		 DesignReceiveFromCS.get(i).click();
	}

	public boolean Confirm_DesignReceiveFromCS() {
		boolean status = true;
		for (WebElement we : DesignReceiveFromCS) {
			status = true;
			if (we.isEnabled()) {
				status = false;
				break;
			}
		}
		return status;
	}

	
	
	public void ProductionReceiveFromDesign(int i) {
		 ProdReceiveFromDesign.get(i).click();
	}

	public boolean Confirm_ProductionReceiveFromDesign() {
		boolean status = true;
		for (WebElement we : ProdReceiveFromDesign) {
			status = true;
			if (we.isEnabled()) {
				status = false;
				break;
			}
		}
		return status;
	}
}

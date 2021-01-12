package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class OM_ReceiveIssue {

	@FindBy(how = How.CSS, using = "[data-ng-model='searchEntity.orderID']")
	private WebElement ClickOrderNo;     
	
	@FindBy(how = How.CSS, using = "div.col-md-10 > div:nth-child(2) > div:nth-child(1) > div > div > div > ul > li.list-group-item.p-none > input")
	private WebElement InsertOrderNo;
	
	@FindBy(how = How.CSS, using = "div:nth-child(2) > div:nth-child(1) > div > div > div > ul > li.list-group-item.mddl.ng-scope > div > label > input")
	private WebElement ClickInsertOrderNo;
	
	@FindBy(how = How.CSS, using = "[data-ng-model='searchEntity.issueID']")
	private WebElement ClickIssueNo;
	
	@FindBy(how = How.CSS, using = "div:nth-child(1) > div:nth-child(4) > div > div > div > ul > li.list-group-item.p-none > input")
	private WebElement InsertIssueNo;  
	
	@FindBy(how = How.CSS, using = "div:nth-child(1) > div:nth-child(4) > div > div > div > ul > li:nth-child(2) > div > label > input")
	private WebElement ClickInsertIssueNo;  
	
	
	//[data-ng-model='searchEntity.issueID']
	// div:nth-child(1) > div:nth-child(4) > div > div > div > ul > li.list-group-item.p-none > input
	
	// div:nth-child(1) > div:nth-child(4) > div > div > div > ul > li:nth-child(2) > div > label > input
	
	
	@FindBy(how = How.CSS, using = "button.btn-search")
	private WebElement Search; 
	
	
	@FindBy(how = How.CSS, using = "tbody > tr:nth-child(1) > td > ul > li > input")
	private WebElement issueItem;

	@FindBy(how = How.CSS, using = "div > button.btn.btn-confirm.btn-success > span")
	private WebElement receiveConfirmButton;
	
	@FindBy(how = How.CSS, using = "button.btn-reset")
	private WebElement Reset; 
	
	@FindBy(how = How.CSS, using = "[data-ng-model='checkAall']")
	private WebElement IssueCheckBox; 
	
	@FindBy(how = How.CSS, using = "button.btn-confirm")
	private WebElement ReceiveConfirm; 
	
	@FindBy(how = How.CSS, using = "#btnOk")
	private WebElement PopUp; 
	
	public void SelectIssueToReceive() {
		issueItem.click();
	}
	
	public void ReceiveConfirm() {
		receiveConfirmButton.click();
	}
	
	
	public void SelectOrderNo(String OrderNo) {
		ClickOrderNo.click();
		InsertOrderNo.clear();
		InsertOrderNo.sendKeys(OrderNo);
		ClickInsertOrderNo.click();
		}
	
	
	public void SelectIssueNo(String IssueNo) {
		ClickIssueNo.click();
		InsertIssueNo.clear();
		InsertIssueNo.sendKeys(IssueNo);
		ClickInsertIssueNo.click();
		}
	
	
	
	public void ClickSearchbutton() {
		Search.click();
	}
	
	public void SelectIssueCheckBox() {
		IssueCheckBox.click();
	}
	
	public void ClickReceiveConfirm() {
		ReceiveConfirm.click();
	}
	
	public void ClickResetbutton() {
		Reset.click();
	}
	
	public void ClickPopUp() {
		PopUp.click();
	}

}

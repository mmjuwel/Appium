package pages;


import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class OM_OrderIssue {

	WebDriver driver;

	@FindBy(how = How.CSS, using = "[data-ng-model='searchEntity.orderID']")
	private WebElement ClickOrderNo;     
	
	@FindBy(how = How.CSS, using = "div.col-md-10 > div:nth-child(2) > div:nth-child(1) > div > div > div > ul > li.list-group-item.p-none > input")
	private WebElement InsertOrderNo;
	
	@FindBy(how = How.CSS, using = "div:nth-child(2) > div:nth-child(1) > div > div > div > ul > li.list-group-item.mddl.ng-scope > div > label > input")
	private WebElement ClickInsertOrderNo;
	
	@FindBy(how = How.CSS, using = "button.btn-search")
	private WebElement Search; 
	
	@FindAll(@FindBy(how = How.CSS, using = "[blank-grid='issueGridOpt'] [type='checkbox']"))
	private List <WebElement> IssueAll;
	
	@FindBy(how = How.CSS, using = ".btn-addorder")
	private WebElement OkButton; 
	
	@FindBy(how = How.CSS, using = "[ng-model='isCheckStatus.value']")
	private WebElement ActionButton; 
	
	@FindBy(how = How.CSS, using = "[data-ng-click='saveIssue()']")
	private WebElement Issue; 
	
	@FindBy(how = How.CSS, using = "#btnClose")
	private WebElement PopUp; 
	
	@FindBy(how = How.CSS, using = "#issueProdState_ResolvedPage [data-ng-click='closeWindow()'] > .ni")
	private WebElement CloseWindow; 
	
	
	@FindBy(how = How.CSS, using = "[data-ng-click='reset()']")
	private WebElement Reset; 
	
	
	

	
	public void SelectOrderNo(String OrderNo) {
		ClickOrderNo.click();
		InsertOrderNo.clear();
		InsertOrderNo.sendKeys(OrderNo);
		ClickInsertOrderNo.click();
		}
	
	public void ClickSearchbutton() {
		Search.click();
	}

	public void SelectItemToIssue() {
		int i=0;
		for(WebElement button:IssueAll){
		WebElement Select = IssueAll.get(i);
		button.click();
		i++;
		}
	}
	
	
	public void ClickOkButton() {
		OkButton.click();
	}
	

	public void SelectActionButton() {
		ActionButton.click();
	}
	
	public void ClickIssueButton() {
		Issue.click();
	}
	
	public void ClickPopUpButton() {
		PopUp.click();
	}
	
	@FindBy(how = How.XPATH, using = "//div[@class='toast-message']")
	private WebElement getToastMessage;
	public String TostMessage() {
		return getToastMessage.getText();
	}
	
	public void ClickCloseWindow() {
		CloseWindow.click();
	}
	
	public void ResetButton() {
		Reset.click();
	}

}

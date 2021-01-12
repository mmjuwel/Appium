package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;


public class INV_RawMaterialSourcing {

	
	@FindBy (how=How.LINK_TEXT,using="Create RM Sourcing Plan for BIC")
	private WebElement RMSourcingBIC;
	
	@FindBy (how=How.LINK_TEXT,using="Create RM Sourcing Plan for NIC")
	private WebElement RMSourcingNIC;

	@FindBy(how = How.CSS, using = "[data-ng-model='searchParams.customerID']")
	private WebElement Customer;
	
	@FindBy(how = How.CSS, using = "div:nth-child(1) > div > div > div.col-md-9.p-1-right-none > div > div > div.search-container.select2-search > input")
	private WebElement InsertCustomerName;
	
	@FindBy(how = How.CSS, using = "[data-ng-bind-html='cust.customerName| highlight: $select.search']")
	private WebElement ClickCustomerName;
	
	@FindBy(how = How.CSS, using = "[data-ng-model='searchParams.orderID']")
	private WebElement Order;
	
	@FindBy(how = How.CSS, using = "div:nth-child(1) > div:nth-child(3) > div > div > div > div.search-container.select2-search > input")
	private WebElement InsertOrderNo;
	
	@FindBy(how = How.CSS, using = "[data-ng-bind-html='order.orderNo| highlight: $select.search']")
	private WebElement ClickOrderNo;

	@FindBy(how = How.CSS, using = "button.btn-search")
	private WebElement ClickSearch;
	
	@FindAll(@FindBy(how = How.CSS, using = "[ni-group='gridOptions'] .fa"))
	private List <WebElement> SelectOrderItem;
	
	@FindAll(@FindBy(how = How.XPATH, using = "//div[starts-with(@id,'_DivGridID')]//div[2]//div[11]//input"))
	private List <WebElement> PurchaseQty;
	
	@FindAll(@FindBy(how = How.XPATH, using = "//div[starts-with(@id,'_DivGridID')]//div[2]//div[12]//input"))
	private List <WebElement> ProductionQty;
	
	@FindAll(@FindBy(how = How.CSS, using = "#_DivGridID1592473503817 > .ng-valid.ng-form-piItemDtlForm div:nth-child(10)"))
	private List <WebElement> BookQty;
	
	@FindAll(@FindBy(how = How.XPATH, using = "//div[starts-with(@id,'_DivGridID')]//div[2]//div[7]"))
	private List <WebElement> balance;
	
	@FindBy(how = How.CSS, using = "button.btn-save")
	private WebElement Save;
	
	@FindBy(how = How.CSS, using = "div#ficRMSrcPlnState_ResolvedPage [data-ng-click='closeWindow()'] > .ni")
	private WebElement Close;
	
	@FindBy(how = How.CSS, using = "button.btn-reset")
	private WebElement Reset;

	
	public void RMSourcingBIC() {
		RMSourcingBIC.click();
	}
	
	
	public void RMSourcingNIC() {
		RMSourcingNIC.click();
	}
	

	public void SelectCustomer(String CustomerName) {
		Customer.click();
		InsertCustomerName.sendKeys(CustomerName);
		ClickCustomerName.click();
		}
	
	
	public void SelectOrderNo(String OrderNo) {
		Order.click();
		InsertOrderNo.sendKeys(OrderNo);
		ClickOrderNo.click();
		}
	
	
	public void Search() {
		ClickSearch.click();
	}
	
	
	public void SelectOrderItemNIC() {
		WebElement orditem = SelectOrderItem.get(SelectOrderItem.size() -2); //always select last item of first page
		orditem.click();
	
		}


	public void InsertSourcingQty(String Sourcingtype ) {
	 
		int i =0;
	if (Sourcingtype.equals("Purchase"))
		
	for(WebElement SizePurQty:PurchaseQty){
		WebElement bal= balance.get(i);
		String SizeBal= bal.getText();
		SizePurQty.clear();
		SizePurQty.sendKeys(SizeBal);
		i++;
				} 
	
	if (Sourcingtype.equals("Production"))
		
		for(WebElement SizePrdQty:ProductionQty){
			WebElement bal= balance.get(i);
			String SizeBal= bal.getText();
			SizePrdQty.clear();
			SizePrdQty.sendKeys(SizeBal);
			i++;
				}
	
	
	if (Sourcingtype.equals("Book"))
		
		for(WebElement SizeBookQty:BookQty){
			WebElement bal= balance.get(i);
			String SizeBal= bal.getText();
			SizeBookQty.clear();
			SizeBookQty.sendKeys(SizeBal);
			i++;
				}
		
		
		}


	public void Save() {
		Save.click();
	}
	
	
	public void CloseWindow() {
		Close.click();
	}
	
	public void Reset() {
		Reset.click();
	}
	
	
}

		




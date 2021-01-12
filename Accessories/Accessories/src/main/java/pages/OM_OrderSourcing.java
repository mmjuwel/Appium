package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class OM_OrderSourcing {

	

	@FindBy(how = How.CSS, using = "[data-ng-model='searchEntity.orderID']")
	private WebElement ClickOrderNo;     
	
	@FindBy(how = How.CSS, using = "div.col-md-10 > div:nth-child(2) > div:nth-child(1) > div > div > div > ul > li.list-group-item.p-none > input")
	private WebElement InsertOrderNo;
	
	@FindBy(how = How.CSS, using = "div:nth-child(2) > div:nth-child(1) > div > div > div > ul > li.list-group-item.mddl.ng-scope > div > label > input")
	private WebElement ClickInsertOrderNo;
	
	@FindBy(how = How.CSS, using = "button.btn-search")
	private WebElement Search; 
	
	@FindBy(how = How.CSS, using = "[ni-group='gridOptions'] tr:nth-of-type(1) .fa")
	private WebElement OrderItem; 
	
	@FindAll(@FindBy(how = How.CSS, using = "div.row.ng-scope > div > div > div.row > div > div:nth-child(1) > label > input"))
	private List <WebElement> FullBooking;
	
	@FindAll(@FindBy(how = How.CSS, using = "div.row.ng-scope > div > div > div.row > div > div:nth-child(2) > label > input"))
	private List <WebElement> FullProduction;
	
	@FindAll(@FindBy(how = How.CSS, using = "div.row.ng-scope > div > div > div.row > div > div:nth-child(3) > label > input"))
	private List <WebElement> FullPurcahse;
	
	@FindBy(how = How.CSS, using = "button.btn-save")
	private WebElement Save; 
	
	@FindBy(how = How.CSS, using = "div#orderDistriState_ResolvedPage [data-ng-click='closeWindow()']")
	private WebElement CloseWindow; 
	
	@FindBy(how = How.CSS, using = "button.btn-reset")
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
	
	public void SelectOrderItem() {
		OrderItem.click();
	}

	
	public void SelectSourcingType(String Plan) {
		int i=0;
		if(Plan.equals("Production"))	
		for(WebElement button:FullProduction){
		WebElement Select = FullProduction.get(i);
		button.click();
		i++;
		}
	
		if(Plan.equals("Purchase"))
		for(WebElement button:FullPurcahse){
		WebElement Select = FullPurcahse.get(i);
		button.click();
		i++;	
		}
		
	if(Plan.equals("Booking"))
		for(WebElement button:FullBooking){
		WebElement Select = FullBooking.get(i);
		button.click();
		i++;
		}
	}
	
	
	public void ClickSavebutton() {
		Save.click();
	 }
	
	
	public void ClickCloseWindow() {
		CloseWindow.click();
	 }
	
	public void ClickReset() {
		Reset.click();
	 }
			
		
	}
	
	
	



	

	
	

	
	



package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class INV_PurchaseRequisition {

	// Purchase Requisition With BIC
	
	@FindAll(@FindBy(how = How.CSS, using = "[data-ng-click='selectRow(entity)']"))
	private List <WebElement> SelectOrderItem;
	
	@FindBy(how = How.CSS, using = ".btn-common")
	private WebElement SelectItemForStock;
	
	@FindBy(how = How.CSS, using = "div[data-ng-model='ficSearchParams.buyerID'] > .select2-choice")
	private WebElement Buyer;
	
	@FindBy(how = How.CSS, using = " div.row.ng-scope > div > div > div > div > div.col-md-10 > div:nth-child(2) > div:nth-child(1) > div > div > div.col-md-9.p-1-right-none > div > div > div.search-container.select2-search > input")
	private WebElement InsertBuyerName;
	
	@FindBy(how = How.CSS, using = "[data-ng-bind-html='objFicBuyer.buyerName | highlight: $select.search']")
	private WebElement BuyerClick;
	
	@FindBy(how = How.CSS, using = "div[data-ng-model='ficSearchParams.bicID'] > .select2-choice")
	private WebElement BIC;
	
	@FindBy(how = How.CSS, using = "div.row.ng-scope > div > div > div > div > div.col-md-10 > div:nth-child(2) > div.form-group.m-b-none > div > div > div > div.search-container.select2-search > input")
	private WebElement InsertBICName;
	
	@FindBy(how = How.CSS, using = "li.select2-highlighted [data-ng-bind-html='objFicBic.buyerItemCode | highlight: $select.search']")
	private WebElement BICClick;
	
	@FindBy(how = How.CSS, using = "button.btn-search")
	private WebElement Search;
	
	//@FindAll(@FindBy(how = How.CSS, using = "[blank-grid='ficGridOptions'] [type='checkbox']"))
	//private List <WebElement> selectSizes;
	
	@FindAll(@FindBy(how = How.CSS, using = "[blank-grid='ficGridOptions'] [type='checkbox']"))
	private List <WebElement> BICItemCheckbox;
		
	@FindAll(@FindBy(how = How.CSS, using = "[data-ng-model='nicItemMaterial.isSelected']"))
	private List <WebElement> selectSizesForNIC;
	
	@FindBy(how = How.CSS, using = "[data-ni-click='selectFicItemMaterial()']")
	private WebElement OKbutton;
	
	@FindBy(how = How.CSS, using = "button[data-ni-click='selectNicItemMaterial($event)']")
	private WebElement NICOKbutton;
	
	
	@FindAll(@FindBy(how = How.CSS, using = "div.ni-table-row-group [maxlength='15']"))
	private List <WebElement> ReqiredQty;
	
	@FindAll(@FindBy(how = How.CSS, using = "div.ni-table-row-group [maxlength='13']"))
	private List <WebElement> PurchaseAmount;
	
	@FindAll(@FindBy(how = How.CSS, using = "div.ni-table-row-group .ni-datepicker > .form-control"))
	private List <WebElement> DatePicker;
	
	@FindBy(how = How.CSS, using = "div.ui-datepicker-group-first tr:nth-of-type(5) > td:nth-of-type(4) > .ui-state-default")
	private WebElement ClickCalander;
	
	@FindBy(how = How.CSS, using = "button.btn-save")
	private WebElement Save;
	
	@FindBy(how = How.CSS, using = "button.btn-addorder")
	private WebElement NewRequsition;
	
	@FindBy(how = How.CSS, using = "#btnOk")
	private WebElement RequsitionPopUp;
	
	
	
	// Purchase Requisition With NIC
	
	@FindBy(how = How.CSS, using = "div:nth-child(1) > div > div > div > div > div.search-container.select2-search > input")
	private WebElement InsertItemName;
	
	@FindBy(how = How.CSS, using = "[data-ng-bind-html='objNicItem.name | highlight: $select.search']")
	private WebElement ItemClick;
	
	
	@FindBy(how = How.CSS, using = "[data-ng-disabled='gridData.selectedBicOrNicType === bicOrNic.bIC']")
	private WebElement SelectNIC;
	
	@FindBy(how = How.CSS, using = "[data-ng-model='nicSearchParams.itemID'] > .select2-choice")
	private WebElement NIC;
	
	@FindBy(how = How.CSS, using = "div.row.ng-scope > div > div > div > div > div.col-md-10 > div:nth-child(2) > div > div > div > a")
	private WebElement ItemType1;
	
	@FindBy(how = How.CSS, using = "div.row.ng-scope > div > div > div > div > div.col-md-10 > div:nth-child(2) > div > div > div > div > div.search-container.select2-search > input")
	private WebElement InsertItemType;
	
	@FindBy(how = How.CSS, using = "[data-ng-bind-html='objNicItemType.name | highlight: $select.search']")
	private WebElement ItemTypeClick;
	
	@FindBy(how = How.CSS, using = "div[data-ng-model='nicSearchParams.nicID'] > .select2-choice")
	private WebElement SelectNIC1;
	
	@FindBy(how = How.CSS, using = "div.row.ng-scope > div > div > div > div > div.col-md-10 > div:nth-child(3) > div > div > div > div > div.search-container.select2-search > input")
	private WebElement InsertNIC;
	
	@FindBy(how = How.CSS, using = "[data-ng-bind-html='objNic.nICNo | highlight: $select.search']")
	private WebElement ClickInsertNIC;
	
	
	
	
	

	public void SelectItemStock(){
		SelectItemForStock.click();
		
	}
	
	
	public void SelectNICRadioButton(){
		SelectNIC.click();
		
	}
	
	public void SelectBuyer(String BuyerName) {
		Buyer.click();
		InsertBuyerName.clear();
		InsertBuyerName.sendKeys(BuyerName);
		BuyerClick.click();
		}
	
	
	public void SelectBIC(String BICName) {
		BIC.click();
		InsertBICName.clear();
		InsertBICName.sendKeys(BICName);
		BICClick.click();
		}
	
	public void SelectItem(String Item) {
		NIC.click();
		InsertItemName.clear();
		InsertItemName.sendKeys(Item);
		ItemClick.click();
		}
	
	public void SelectNICItemType(String ItemType) {
		ItemType1.click();
		InsertItemType.sendKeys(ItemType);
		ItemTypeClick.click();
		}
	
	public void SelectNIC(String NIC) {
		SelectNIC1.click();
		InsertNIC.sendKeys(NIC);
		ClickInsertNIC.click();
		}
	
	
	public void Search(){
		Search.click();
		
	}
	
	
	public void SelectBICItemCheckbox(){
		int i=0;
		for(WebElement button:BICItemCheckbox){
		WebElement Select = BICItemCheckbox.get(i);
		button.click();
		i++;
		
		
		}
	}
	
	
	public void SelectNICItem() {
		WebElement Select = selectSizesForNIC.get(selectSizesForNIC.size() - 1);
		Select.click();
	}

	public void SelectOKButton(){
		OKbutton.click();
		
	}
	
	
	public void SelectNICOKButton(){
		NICOKbutton.click();
		
	}


	
	public void InsertReqQty(String RequiredQty) {
		
			for(WebElement SizeReqQty:ReqiredQty){
				SizeReqQty.clear();
				SizeReqQty.sendKeys(RequiredQty);
		
		}

		
	}
	
	public void InsertPurchaseAmount(String PurchaseAmt) {
		
		for(WebElement SizePurchaseAmt:PurchaseAmount){
			SizePurchaseAmt.clear();
			SizePurchaseAmt.sendKeys(PurchaseAmt);
		
		}
	}
	
	
	public void selectDate(String Date) throws InterruptedException {
		
		for(WebElement DatePick:DatePicker){
		DatePick.click();
		ClickCalander.click();
		Thread.sleep(1000);
		}
	}
		
	
	
	public void SaveReq() {
		Save.click();
	}
		
	public void AddNewRequisition() {
		NewRequsition.click();
		
		}
	
	public void SelectRequsitionPopUp() {
		RequsitionPopUp.click();


		}
	}

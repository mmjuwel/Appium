package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class INV_PurchaseOrder {


	// Purchase Order With Requisition
	
	@FindBy(how = How.CSS, using = "[ng-click='openSupplierModal()']")
	private WebElement Supplier;
	
	@FindBy(how = How.CSS, using = ".ui-draggable.modal-dialog tr:nth-of-type(1) i:nth-of-type(1)")
	private WebElement SupplerActionButton;
	
	@FindBy(how = How.CSS, using = "[data-ng-disabled='!po.supplierID || (po.supplierID && po.pOSrcCd && po.pOSrcCd !== poSourceCd.fromRequisition) ']")
	private WebElement RequisitionForStock;
	
	@FindBy(how = How.CSS, using = "div.row > div.col-md-9 > div:nth-child(1) > div > div > div > a")
	private WebElement RequisitionNo;
	
	@FindBy(how = How.CSS, using = "[ng-model='$select.search']")
	private WebElement InsertRequisitionNo;
	
	@FindBy(how = How.CSS, using = "[data-ng-bind-html='obj.requisitionNo | highlight: $select.search']")
	private WebElement ClickReqNo;
	
	@FindBy(how = How.CSS, using = "button.btn-search")
	private WebElement Search;
	
	@FindAll(@FindBy(how = How.CSS, using = "[data-ng-model='item.isSelected']"))
	private List <WebElement> SelectItem;
	
	@FindAll(@FindBy(how = How.CSS, using = "div.medium-page [type='checkbox']"))
	private List <WebElement> ActionCheckBoxForRequisition;
	
	@FindBy(how = How.CSS, using = "button.btn-okay")
	private WebElement ClickOKButton;
	
	@FindBy(how = How.CSS, using = "[data-ng-model='po.deliveryDtTm']")
	WebElement datePicker;

	@FindAll(@FindBy(how = How.CSS, using = ".ui-state-default"))
	List<WebElement> date;
	
	@FindBy(how = How.CSS, using = "[data-ng-model='po.deliveryTime'] [placeholder='hh']")
	WebElement Timehr;
	
	@FindBy(how = How.CSS, using = "a[ni-dbclick-prevent]")
	WebElement ClickDeliveryAdd;
	
	@FindBy(how = How.CSS, using = "[blank-grid='goAddresses1'] tr:nth-of-type(1) .fa")
	WebElement ClickDeliveryPopUpAction;
	
	@FindAll(@FindBy(how = How.CSS, using = "div[blank-div-grid-new='gridOptions'] .ni-table-cell > .form-control"))
	private List <WebElement> PurchaeQty;
	
	@FindAll(@FindBy(how = How.CSS, using = "div[blank-div-grid-new='gridOptions'] div:nth-of-type(11)"))
	private List <WebElement> balance;
	
	@FindBy(how = How.CSS, using = "button.btn-save")
	private WebElement ReqisitionSaveButton;
	
	@FindBy(how = How.CSS, using = "button.btn-addorder")
	WebElement AddNewButton;
	
	
	// Purchase Order With OrderRM
	
	
	@FindBy(how = How.CSS, using = "[data-ng-disabled='!po.supplierID || (po.supplierID && po.pOSrcCd && po.pOSrcCd !== poSourceCd.fromRawMaterials)']")
	private WebElement OrderRM;
	
	@FindBy(how = How.CSS, using = "[data-ng-model='nicSearchParams.customerID']")
	private WebElement Customer;
	
	@FindBy(how = How.CSS, using = "div:nth-child(1) > div:nth-child(1) > div > div > div.col-md-9.p-1-right-none > div > div > div.search-container.select2-search > input")
	private WebElement InsertCustomerName;
	
	@FindBy(how = How.CSS, using = "[data-ng-bind-html='objCustomer.customerName | highlight: $select.search']")
	private WebElement ClickCustomerName;
	
	@FindBy(how = How.CSS, using = "[data-ng-model='nicSearchParams.orderID']")
	private WebElement Order;
	
	@FindBy(how = How.CSS, using = "div:nth-child(2) > div > div > div > div.search-container.select2-search > input")
	private WebElement InsertOrderNo;
	
	@FindBy(how = How.CSS, using = "[data-ng-bind-html='objOrder.orderNo | highlight: $select.search']")
	private WebElement ClickOrderNo;
	
	@FindAll(@FindBy(how = How.CSS, using = "[blank-grid='ordersRMGridOptions'] [type='checkbox']"))
	private List <WebElement> ActionCheckBoxForOrderRM;
	
	
	// Purchase Order With BIC For Stock
	
	@FindBy(how = How.CSS, using = "[data-ng-disabled='!po.supplierID || (po.supplierID && po.pOSrcCd && (po.pOSrcCd !== poSourceCd.fromBICItems && po.pOSrcCd !== poSourceCd.fromNICItems))']")
	private WebElement ItemForStock;
	
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
	
	@FindAll(@FindBy(how = How.CSS, using = "[blank-grid='ficGridOptions'] [type='checkbox']"))
	private List <WebElement> ActionCheckBoxForStockBICItem;
	
	@FindBy(how = How.CSS, using = "[maxlength='8']")
	private WebElement ReqQty;
	
	
	// Purchase Order With NIC For Stock
	
	@FindBy(how = How.CSS, using = "[data-ng-disabled='gridData.selectedBicOrNicType === bicOrNic.bIC']")
	private WebElement SelectNICRadioButton;
	
	@FindBy(how = How.CSS, using = "div:nth-child(1) > div > div > div > div > div.search-container.select2-search > input")
	private WebElement InsertItemName;
	
	@FindBy(how = How.CSS, using = "[data-ng-bind-html='objNicItem.name | highlight: $select.search']")
	private WebElement ItemClick;
	
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
	
	@FindAll(@FindBy(how = How.CSS, using = "[data-ng-model='nicItemMaterial.isSelected']"))
	private List <WebElement> selectSizesForNIC;
	
	@FindBy(how = How.CSS, using = "button[data-ni-click='selectNicItemMaterial($event)']")
	private WebElement NICOKbutton;
	
	
	
	
	
	
	// Purchase Order With Requisition

	public void Supplier(){
		Supplier.click();
		
	}
	
	
	public void SelectSupplierActionButton(){
		SupplerActionButton.click();
		
	}
	
	
	public void SelectRequisitionForStock(){
		RequisitionForStock.click();
		
	}
	
	public void SelectRequisitionNo(String RequsitionNo) {
		RequisitionNo.click();
		InsertRequisitionNo.clear();
		InsertRequisitionNo.sendKeys(RequsitionNo);
		ClickReqNo.click();
		}
	
	
	public void SelectSearch(){
		Search.click();
		
	}
	
	
	public void SelectItem() {
		WebElement Select = SelectItem.get(SelectItem.size() - 9);
		Select.click();
	}
	
	
	public void SelectOKButton(){
		ClickOKButton.click();
		
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
	
	public void SelectTime(String Time) {
		Timehr.click();
		Timehr.clear();
		Timehr.sendKeys(Time);
		
		}
	
	
	
	public void OpenDeliveryPopUp(){
		ClickDeliveryAdd.click();
		
	}
	
	public void SelectDeliveryAddress(){
		ClickDeliveryPopUpAction.click();
		
	}
	
		
	public void InsertPurchaseQty() {
		 int i =1;
		for(WebElement SizePurchaseQty:PurchaeQty){
			WebElement bal= balance.get(i);
			
			String SizeBal= bal.getText();
			SizePurchaseQty.clear();
			SizePurchaseQty.sendKeys(SizeBal);
			i++;
		
		}
		
	}
	
	
	public void SelectCheckBoxActionButton(){
		int i=0;
		for(WebElement button:ActionCheckBoxForRequisition){
		WebElement Select = ActionCheckBoxForRequisition.get(i);
		button.click();
		i++;
		
		
		}
	}
		
		
		public void SaveButtonForReq(){
			ReqisitionSaveButton.click();
			
		}
		
		
		public void SelectAddNewButton(){
			AddNewButton.click();
		}
		
		
	// Purchase Order With OrderRM
		
		
	public void SelectOrderRM(){
			OrderRM.click();
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
	
	
	public void SelectItemCheckBoxForOrderRM(){
		int i=0;
		for(WebElement button:ActionCheckBoxForOrderRM){
		WebElement Select = ActionCheckBoxForOrderRM.get(i);
		button.click();
		i++;
		
		
		}
	}
	// Purchase Order With BIC For Stock
	
	public void SelectForStock(){
			ItemForStock.click();
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
		
	
	public void SelectItemCheckBoxForStockBICItem(){
		int i=0;
		for(WebElement button:ActionCheckBoxForStockBICItem){
		WebElement Select = ActionCheckBoxForStockBICItem.get(i);
		button.click();
		i++;
		
		}
	}
		
	
	public void SelectItem3() {
		WebElement Select = ActionCheckBoxForStockBICItem.get(ActionCheckBoxForStockBICItem.size() - 3);
		Select.click();
	}
		
		public void InsertReqQty(String RequiredQty) {
			ReqQty.clear();
			ReqQty.sendKeys(RequiredQty);
			
			}	
		
		
	// Purchase Order With NIC For Stock
		

		
		public void SelectNICRadioButton(){
			SelectNICRadioButton.click();
			
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
		
		
		public void SelectNICItem() {
			WebElement Select = selectSizesForNIC.get(selectSizesForNIC.size() - 1);
			Select.click();
		}
		
		public void SelectNICOKButton(){
			NICOKbutton.click();
			
		}
		
		
		
		}
	
	
	
	
	
	
	
	
	

	
	


		
		
		
		





		




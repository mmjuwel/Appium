package pages;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;


public class OM_OrderCreate {

	// Select Customer
	@FindBy(how = How.CSS, using = "div[data-ng-model='vmv.order.customerID'] > .select2-choice")
	private WebElement customer;
	@FindBy(how = How.CSS, using = "div:nth-child(1) > div > div > div > div.select2-search > input")
	private WebElement inserCustomerName;
	@FindBy(how = How.CSS, using = "div>div.ui-select-dropdown>ul>li>ul>li>div>div.ng-binding")
	private WebElement selectCustomer;

	@FindBy(how = How.CSS, using = "input[data-ng-change='changePONo()']")
	private WebElement customerPo;

	// Select Buyer
	@FindBy(how = How.CSS, using = "div[data-ng-model='vmv.order.buyerID'] > .select2-choice")
	private WebElement buyer;
	@FindBy(how = How.CSS, using = "div:nth-child(4) > div > div > div > div > div > div.search-container.select2-search > input")
	private WebElement insertBuyerName;
	@FindBy(how = How.CSS, using = "li.select2-highlighted [data-ng-bind-html='buyer.buyerName | highlight: $select.search']")
	private WebElement seelctBuyer;

	@FindBy(how = How.CSS, using = "div.panel-body > div > div:nth-child(1) > div:nth-child(5) > div > div > select")
	private WebElement brand;

	// Basic Info
	@FindBy(how = How.CSS, using = "select[data-ng-model='vmv.order.orderTypeID']")
	private WebElement orderType;

	@FindBy(how = How.CSS, using = "input[ni-pattern-restrict][maxlength='30']")
	private WebElement orderNo;

	@FindBy(how = How.CSS, using = "div.panel-body > div > div:nth-child(2) > div:nth-child(1) > div > div > input")
	private WebElement trackingNo;

	@FindBy(how = How.CSS, using = "select[data-ng-model='vmv.order.buyerDeptID']")
	private WebElement deparment;

	@FindBy(how = How.CSS, using = "[data-ng-model='vmv.order.seasonID']")
	private WebElement season;

	@FindBy(how = How.CSS, using = "[data-ng-model='vmv.order.productNo']")
	private WebElement styleNo;

	@FindBy(how = How.CSS, using = "[data-ng-model='vmv.order.productName']")
	private WebElement styleName;

	@FindBy(how = How.CSS, using = "[data-ng-model='vmv.order.orderProductNo']")
	private WebElement productNo;

	@FindBy(how = How.CSS, using = "[data-ng-model='vmv.order.orderProductName']")
	private WebElement productName;

	@FindBy(how = How.CSS, using = "[data-ng-model='vmv.order.refOrderNo']")
	private WebElement refNo;

	@FindBy(how = How.CSS, using = "[data-ng-model='vmv.order.gmtWashTypeID']")
	private WebElement gmtWashType;

	@FindBy(how = How.CSS, using = "[data-ng-model='vmv.order.fabricID']")
	private WebElement fabric;

	@FindBy(how = How.CSS, using = "[data-ng-model='vmv.order.fabricComposition']")
	private WebElement farbicComp;

	@FindBy(how = How.CSS, using = "[data-ng-model='vmv.order.customerContID']")
	private WebElement customerContact;

	@FindBy(how = How.CSS, using = "[data-ng-model='vmv.order.deliveryDate']")
	private WebElement openDeliveryDatePopup;
	@FindBy(how = How.XPATH, using = "//div[@class='ui-datepicker-group ui-datepicker-group-last']//a[.='9']")
	private WebElement selectDeliveryDate;

	@FindBy(how = How.CSS, using = "[data-ng-model='vmv.order.targetDate']")
	private WebElement openTargetDatePopup;
	@FindBy(how = How.CSS, using = "div.ui-datepicker-group.ui-datepicker-group-last > table > tbody > tr:nth-child(5) > td:nth-child(6) > a")
	private WebElement selectTargetDate;

	@FindBy(how = How.CSS, using = "[data-ng-click='showShipingAddressForMaster()']")
	private WebElement openDeliveryAddress;
	@FindBy(how = How.CSS, using = "div > div.modal-body > form")
	private WebElement deliveryAddressPopup;
	@FindBy(how = How.CSS, using = "[data-ng-click='selectionAddress(address)']")
	private WebElement delAdd;

	@FindBy(how = How.CSS, using = "[data-ng-model='orderAppStatus']")
	private WebElement approvalStatus;

	// Attach order sheet start
	@FindBy(how = How.CSS, using = "[ng-click='uploadArtWorksEvent()']")
	private WebElement attachOrderSheetBtn;
	@FindBy(how = How.CSS, using = " div > div.modal-header.ui-draggable-handle")
	private WebElement orderSheetPopup;
	@FindBy(how = How.CSS, using = "[accept]")
	private WebElement fromComputer;
	@FindBy(how = How.CSS, using = "[data-ng-click='uploadImage()']")
	private WebElement uploadSheetButton;
	@FindBy(how = How.CSS, using = "[data-ng-click='close()']")
	private WebElement closeSheetpopup;
	// End File upload

	// select_BIC_start
	@FindBy(how = How.CSS, using = "button[data-ng-click='showBuyerItemCode(vmv.order.buyerID, $event)']")
	private WebElement bicPopupButton;
	@FindBy(how = How.CSS, using = "div > div.modal-body > form")
	private WebElement bicPopup;
	@FindBy(how = How.CSS, using = "[data-ng-model='searchParams.buyerItemCode']")
	private WebElement bicBySearch;
	@FindBy(how = How.CSS, using = "div[class='ui-select-dropdown select2-drop select2-with-searchbox select2-drop-active']>div>input[ng-model='$select.search']")
	private WebElement insertBIC;
	@FindBy(how = How.CSS, using = ".ui-select-highlight")
	private WebElement selectBICForSearch;
	@FindBy(how = How.CSS, using = "button[data-ni-click='search()'] > span")
	private WebElement searchButton;
	@FindBy(how = How.CSS, using = "tbody > tr:nth-child(1) > td.p-none > div > label > input")
	private WebElement selectBICForOrder;
	@FindAll(@FindBy(how = How.CSS, using = "[data-ni-click='okItemSelection($event)']"))
	private List <WebElement> okButton;
	// End Select BIC

	//Item Info
	@FindAll(@FindBy(how = How.CSS, using = "[data-ng-model='orderItem.productNo']"))
	private List <WebElement> itemProdNo;

	
	@FindAll(@FindBy(how = How.CSS, using = "[data-ng-model='orderItem.orderQty']"))
	private List <WebElement>  ordQty;

	@FindBy(how = How.CSS, using = "div:nth-child(16) > div > span > button")
	private WebElement gridDeliAddBtn;

	@FindBy(how = How.CSS, using = "tbody > tr > td.p-none > ul > li")
	private WebElement selectAddInGrid;

	@FindAll(@FindBy(how = How.CSS, using = "[data-ng-model='orderItem.approvalStatus']"))
	private List <WebElement> approvalStatusForItem;

	@FindBy(how = How.CSS, using = "button.btn.btn-save.btn-success")
	private WebElement saveButton;
	@FindBy(how = How.XPATH, using = "//div[@class='toast-message']")
	private WebElement getToastMessage;

	@FindBy(how = How.CSS, using = "[data-ni-click='addNew($formValidation)']")
	private WebElement addNewOrderButton;

	// Select Size

	@FindAll(@FindBy(how = How.CSS, using = "[data-ng-click='showBuyerSize(itemOption)']"))
	private List<WebElement> selectSizes;

	@FindBy(how = How.XPATH, using = "//div[1]/div/div/div[4]/div[2]/div/label/input")
	private WebElement size_S;
	@FindBy(how = How.XPATH, using = "//div[1]/div/div/div[5]/div[2]/div/label/input")
	private WebElement size_M;
	@FindBy(how = How.XPATH, using = "//div[1]/div/div/div[6]/div[2]/div/label/input")
	private WebElement size_L;

	@FindBy(how = How.CSS, using = "[data-ni-click='ok($event)']")
	private WebElement okBtnToTakeSize;

	@FindAll(@FindBy(how = How.CSS, using = "[data-ng-model='itemDetail.qty']"))
	private List<WebElement> qtyperSz;

	// ````````````End Size Label`````````````````

	// ````````````Variable Data``````````````````
	@FindAll(@FindBy(how = How.CSS, using = "[data-ng-click='toggleVariableData()']"))
	private List<WebElement> variableDataEntry;
	
	@FindBy(how= How.CSS, using= "div> div:nth-child(1) >[data-ng-model='attvalList.attributeValue']")
	private WebElement variableNo;
	@FindBy(how = How.CSS, using = "div> div:nth-child(2) >[data-ng-model='attvalList.attributeValue']")
	private WebElement variableInfo;
	@FindBy(how = How.CSS, using = "[data-ng-model='itemOption.itemDetail.qty']")
	private WebElement variableWiseQty;
	@FindBy(how = How.CSS, using = ".fa-plus")
	private WebElement addVariableQty;
	
	@FindBy(how=How.ID, using="fileInput")
	private WebElement importVariableXl; 
	
	// ````````End Variable Data````````````

	// Care label
	@FindAll(@FindBy(how = How.CSS, using = "[ng-model='linkItemObj.isSizeRequired']"))
	private List<WebElement> ignoresz;
	
	@FindAll(@FindBy(how = How.CSS, using = "[data-ng-model='itemOption.itemCareInfo.nOP']"))
	private List<WebElement> numberOfPart;

	@FindAll(@FindBy(how = How.CSS, using = "[data-ng-model='itemOption.itemCareInfo.compositionID']"))
	private List<WebElement> composition;
	@FindAll(@FindBy(how = How.CSS, using = "[data-ng-model='itemOption.itemCareInfo.compositionID'] >div >div>input"))
	private List<WebElement> searchComp;
	@FindBy(how = How.CSS, using = "li.select2-highlighted [data-ng-bind-html='com.value | highlight: $select.search']")
	private WebElement SelectComposition;

	@FindAll(@FindBy(how = How.CSS, using = "[data-ng-model='itemOption.itemCareInfo.addiCompoID']"))
	private List<WebElement> AddiComposition;
	@FindAll(@FindBy(how = How.CSS, using = "[data-ng-model='itemOption.itemCareInfo.addiCompoID']>div >div>input"))
	private List<WebElement> searchAddComp;
	@FindBy(how = How.CSS, using = "li.select2-highlighted [data-ng-bind-html='com.value | highlight: $select.search']")
	private WebElement selectAddiComposition;

	@FindAll(@FindBy(how = How.CSS, using = "[item-source='vmv.informationList']"))
	private List<WebElement> careInstruction;
	@FindBy(how = How.CSS, using = "[item-source='vmv.informationList'] li:nth-of-type(2)")
	private WebElement careInst1;
	@FindBy(how = How.CSS, using = "[item-source='vmv.informationList'] li:nth-of-type(3)")
	private WebElement careInst2;

	@FindAll(@FindBy(how = How.CSS, using = "div[item-source='vmv.extraCareInsList']"))
	private List<WebElement> ExtracareInstruction;
	@FindBy(how = How.CSS, using = "div[item-source='vmv.extraCareInsList'] li:nth-of-type(2)")
	private WebElement ExtracareInst1;

	@FindAll(@FindBy(how = How.CSS, using = "div[item-source='vmv.addiInformationList']"))
	private List<WebElement> AdditionalInfo;
	@FindBy(how = How.CSS, using = "div[item-source='vmv.addiInformationList'] li:nth-of-type(3)")
	private WebElement AdditionalInfo1;

	@FindAll(@FindBy(how = How.CSS, using = "[data-ng-model='itemOption.qty']"))
	private List<WebElement> itemOptionqty;

	// ````````````````````End Care``````````````````

	@FindBy(how = How.CSS, using = "[data-ni-click='addAnotherCareInfo($formValidation,itemOption,linkItemObj)']")
	WebElement AddAnotherCareInfo;

	public void SelectCustomer(String CustomerName) {
		customer.click();
		inserCustomerName.clear();
		inserCustomerName.sendKeys(CustomerName);
		selectCustomer.click();
		
		
		
	}

	public void InserCustomerPO(String po) {
		customerPo.clear();
		customerPo.sendKeys(po);
	}

	public void SelectBuyer(String BuyerName) throws Exception {
		buyer.click();
		insertBuyerName.clear();
		insertBuyerName.sendKeys(BuyerName);
		Thread.sleep(1000);
		seelctBuyer.click();
	}

	public void SelectBrand(String BrandName) {
		Select brandName = new Select(brand);
		brandName.selectByVisibleText(BrandName);
	}

	public void SelectOrderType(String OrderType) {
		Select typ = new Select(orderType);
		typ.selectByVisibleText(OrderType);
	}

	public void InserOrderNo(String OrderNo) {
		orderNo.clear();
		orderNo.sendKeys(OrderNo);
	}

	public void InsertTrackingNO(String TrackingNO) {
		trackingNo.sendKeys(TrackingNO);
	}

	public void SelectDepartment(String Deparment_Name) {
		if (Deparment_Name != null) {
			Select Department = new Select(deparment);
			Department.selectByVisibleText(Deparment_Name);
		}
	}

	public void SelectDepartment(int dropdown_index) { // overloaded
		Select Department = new Select(deparment);
		Department.selectByIndex(dropdown_index);
	}

	public void SelectSeason(String Season_name) {
		if (Season_name != null) {
		Select Buyer_Season = new Select(season);
		Buyer_Season.selectByVisibleText(Season_name);
		}
	}

	public void SelectSeason(int dropdown_index) { // over load
		Select Buyer_Season = new Select(season);
		Buyer_Season.selectByIndex(dropdown_index);
	}

	public void InsertStyleNo(String StyleNo) {
		styleNo.sendKeys(StyleNo);
	}

	public void InsertStyleName(String StyleName) {
		styleName.sendKeys(StyleName);
	}

	public void InsertProductNo(String ProductNo) {
		productNo.sendKeys(ProductNo);
	}

	public void InsertProductName(String ProductName) {
		productName.sendKeys(ProductName);
	}
	public void InsertReferanceNo(String refNumber) {
		refNo.sendKeys(refNumber);
	}

	public void SelectGMTWashtype(String WashType) {
		Select washType = new Select(gmtWashType);
		washType.selectByVisibleText(WashType);
	}

	public void SelectGMTWashtype(int WashType_index) {
		Select washType = new Select(gmtWashType);
		washType.selectByIndex(WashType_index);
	}

	public void SelectCustomerContact(String CustomerContact_Name) {

		Select CusCont = new Select(customerContact);
		if(CusCont.getFirstSelectedOption() == null) {
			CusCont.selectByVisibleText(CustomerContact_Name);
		}
	}

	public void SelectCustomerContact(int dropdown_index) { // overloaded
		Select CusCont = new Select(customerContact);
		CusCont.selectByIndex(dropdown_index);
	}

	public void SelectDeliveryDate() {
		openDeliveryDatePopup.click();
		selectDeliveryDate.click();
	}

	public void SelectTargetDate() {
		openTargetDatePopup.click();
		selectTargetDate.click();
	}

	public void SelectDeliveryAddress() throws Exception {
		openDeliveryAddress.click();
		Thread.sleep(2000);
		delAdd.click();
	}

	public void OpenBicPopup() {
		bicPopupButton.click();
	}

	public void SearchByBIC(String bic) {
		bicBySearch.click();
		insertBIC.clear();
		insertBIC.sendKeys(bic);
		selectBICForSearch.click();
		searchButton.click();
	}

	public void SeleclectBICForOrder() {
		selectBICForOrder.click();
	}

	public void ClickOkButtonInBICPopup() {
		WebElement OKbtn= okButton.get(1);
		OKbtn.click();
	}

	//Item info 
	public void InsertItemProdNo(String prodNo) {
		WebElement insertProdNo = itemProdNo.get(itemProdNo.size()-1);
		insertProdNo.clear();
		insertProdNo.sendKeys(prodNo);
	}
	
	public void InsertOrderQrt(String OrderQty) {
		WebElement insertQty = ordQty.get(ordQty.size()-1);
		insertQty.clear();
		insertQty.sendKeys(OrderQty);
	}
	
	public void SelectApprovalStatusForItem(String AppStatus) {
		WebElement itemApprovalStatus = approvalStatusForItem.get(approvalStatusForItem.size()-1);
		Select AprStatus = new Select(itemApprovalStatus);
		AprStatus.selectByVisibleText(AppStatus);
	}

	public void SelectAddressDromGrid() throws InterruptedException {
		gridDeliAddBtn.click();
		Thread.sleep(1000);
		selectAddInGrid.click();
	}

	public void SelectApprovalStatus(String AppStatus) {
		Select AprStatus = new Select(approvalStatus);
		AprStatus.selectByVisibleText(AppStatus);
	}

	public void SelectApprovalStatus(int Dropdown_index) {
		Select AprStatus = new Select(approvalStatus);
		AprStatus.selectByIndex(Dropdown_index);
	}

	// Item Detail Info ```````````````````````````````````````````````````
	public void OpenSizePopup() {
		WebElement lastselectSizes = selectSizes.get(selectSizes.size() - 1);
		lastselectSizes.click();
	}

	public void SelectSizes() {
		size_S.click();
		size_M.click();
		size_L.click();
	}

	public void ClickOkButtonInSizePopup() {
		okBtnToTakeSize.click();
	}

	public void InsertSizeWiseOrderQty(int qtyPerSize) throws Exception {

		for (WebElement insertSzqty : qtyperSz) {
			insertSzqty.clear();
			insertSzqty.sendKeys(String.valueOf(qtyPerSize));
		}
	}

	//Variable 
	public void SelectVariableData() {
		WebElement lastvariableDataEntry = variableDataEntry.get(variableDataEntry.size() - 1);
		lastvariableDataEntry.click();
	}

	public void InsertVariableInfo(int variNo, String variableinfo, int qty) {
		
		variableNo.clear();
		variableNo.sendKeys(String.valueOf(variNo));
		variableInfo.clear();
		variableInfo.sendKeys(variableinfo);
		variableWiseQty.clear();
		variableWiseQty.sendKeys(String.valueOf(qty));
		addVariableQty.click();
	}

	public void ImportVariable(String xlFilePath) {
		//importVariableXl.click();
		importVariableXl.sendKeys(xlFilePath);
	}
	
	public void UncheckIgnoreSize() {
		WebElement CheckBox = ignoresz.get(ignoresz.size()-1);
		if (CheckBox.isSelected()){
			CheckBox.click();
		}
	}
	
	@FindBy(how=How.ID, using="btnOk")		
	WebElement AcceptConfiramtionModal;
	
	public void AcceptConfirmationModal() {
		AcceptConfiramtionModal.click();
	}
	
	public void InsertNOP(String NumberOfPart) {
		WebElement lastNOP = numberOfPart.get(numberOfPart.size() - 1);
		lastNOP.clear();
		lastNOP.sendKeys(NumberOfPart);
	}

	public void SelectComposition(String Composition) {
		WebElement lastComposition = composition.get(composition.size() - 1);
		WebElement lastsearchComp = searchComp.get(searchComp.size() - 1);
		lastComposition.click();
		lastsearchComp.clear();
		lastsearchComp.sendKeys(Composition);
		SelectComposition.click();
	}

	public void SelectAdditionalComposition(String additionalComposition) {
		WebElement lastAddiComposition = AddiComposition.get(AddiComposition.size() - 1);
		WebElement lastsearchAddComp = searchAddComp.get(searchAddComp.size() - 1);
		lastAddiComposition.click();
		lastsearchAddComp.clear();
		lastsearchAddComp.sendKeys(additionalComposition);
		selectAddiComposition.click();
	}

	public void SelectCareInstructions() {
		WebElement lastAddiCare = careInstruction.get(careInstruction.size() - 1);
		lastAddiCare.click();
		careInst1.click();

	}

	public void SelectExtraCareInst() {
		WebElement lastExtracareInstruction = ExtracareInstruction.get(ExtracareInstruction.size() - 1);
		lastExtracareInstruction.click();
		ExtracareInst1.click();

	}

	public void SelectAdditionalInfos() throws InterruptedException {
		WebElement lastAdditionalInfo = AdditionalInfo.get(AdditionalInfo.size() - 1);
		lastAdditionalInfo.click();
		AdditionalInfo1.click();
	}

	public void InsertItemOptionqty(int ItemOption_Qty) {
		WebElement lastitemOptionqty = itemOptionqty.get(itemOptionqty.size() - 1);
		lastitemOptionqty.clear();
		lastitemOptionqty.sendKeys(String.valueOf(ItemOption_Qty));
	}

	public void ClickOnAddAnotherCareInfo() {
		AddAnotherCareInfo.click();

	}

	public void AttachOrderSheet(String filePath) {
		attachOrderSheetBtn.click();
		fromComputer.sendKeys(filePath);
	}

	public void UploadSheet() {
		uploadSheetButton.click();
	}

	public void CloseSheetpopup() {
		closeSheetpopup.click();
	}

	public void SaveOrder() {
		saveButton.click();
	}

	public String TostMessage() {
		return getToastMessage.getText();
	}
	public Boolean VerifySaveOfOrder() {
		Boolean status = addNewOrderButton.isEnabled();
		return status;
	}

	public void AddNewOrder() {
		addNewOrderButton.click();
	}

}

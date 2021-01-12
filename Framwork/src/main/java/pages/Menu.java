package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import utility.BaseClass;

public class Menu {

	// Section
	@FindBy(how = How.LINK_TEXT, using = "ACCESSORY")
	private WebElement accessory;
	@FindBy(how = How.LINK_TEXT, using = "Marketing & Sales")
	private WebElement marketingnSales;
	@FindBy(how = How.LINK_TEXT, using = "Customer Support")
	private WebElement customerSupport;

	// order
	@FindBy(how = How.LINK_TEXT, using = "Order")
	private WebElement order;
	@FindBy(how = How.LINK_TEXT, using = "Order Entry")
	private WebElement createOrder;
	@FindBy(how = How.LINK_TEXT, using = "Edit Order")
	private WebElement editeOrder;
	@FindBy(how = How.LINK_TEXT, using = "Order Verification")
	private WebElement orderVerification;
	
	// Order Sourcing
	
	

	// Production
	@FindBy(how = How.LINK_TEXT, using = "Production Management")
	private WebElement productionManagement;

	@FindBy(how = How.LINK_TEXT, using = "Order Sourcing")
	private WebElement orderSourcing;
	
	@FindBy(how = How.LINK_TEXT, using = "Order Sourcing Plan")
	private WebElement orderSourcingPlan;

	@FindBy(how = How.LINK_TEXT, using = "Manage Production Plan")
	private WebElement manageProductionPlan;
	@FindBy(how = How.LINK_TEXT, using = "Production Plan Entry")
	private WebElement productionPlanentry;

	@FindBy(how = How.LINK_TEXT, using = "Order Master File Issue")
	private WebElement orderMasterFileIssue;

	@FindBy(how = How.LINK_TEXT, using = "Manage Packaging")
	private WebElement managePackaging;

	@FindBy(how = How.LINK_TEXT, using = "New Create Packing")
	private WebElement createPacking;

	@FindBy(how = How.LINK_TEXT, using = "New Confirm Packing")
	private WebElement confirmPacking;

	@FindBy(how = How.ID, using = "100000856")
	private WebElement productionEntry;
	
	@FindBy(how = How.LINK_TEXT, using = "Order Issue")
	private WebElement Issue;
	
	@FindBy(how = How.LINK_TEXT, using = "Order Issue To Dispatch")
	private WebElement OrderIssue;

	

	// supplychain
	@FindBy(how = How.LINK_TEXT, using = "Supply Chain Management")
	private WebElement supplyChainManagement;

	@FindBy(how = How.LINK_TEXT, using = "Stock Order")
	private WebElement stockOrder;

	@FindBy(how = How.LINK_TEXT, using = "Create Stock Order")
	private WebElement CreateStockOrder;
	@FindBy(how = How.LINK_TEXT, using = "Verify Stock Order")
	private WebElement VrtifyStockOrder;

	// Supply Chain Mng2

	// supplychain

	@FindBy(how = How.LINK_TEXT, using = "Raw Material Sourcing Plan")
	private WebElement RMSourcing;

	// @FindBy (how=How.CSS,using="#\31 000001236")
	// private WebElement RMSourcingBIC;

	@FindBy(how = How.LINK_TEXT, using = "Create RM Sourcing Plan for BIC")
	private WebElement RMSourcingBIC;

	@FindBy(how = How.LINK_TEXT, using = "Create RM Sourcing Plan for NIC")
	private WebElement RMSourcingNIC;

	@FindBy(how = How.LINK_TEXT, using = "Purchase Requisition")
	private WebElement PurchaseReq;

	@FindBy(how = How.LINK_TEXT, using = "Purchase Requisition for Stock")
	private WebElement PurchaseReqStock;

	@FindBy(how = How.LINK_TEXT, using = "Purchase Order")
	private WebElement PurchaseOrder;

	@FindBy(how = How.LINK_TEXT, using = "Create Purchase Order")
	private WebElement CreatePurchaseOrder;

	// Finance
	@FindBy(how = How.ID, using = "100000862")
	private WebElement Finance;

	// Commercial
	@FindBy(how = How.ID, using = "100000203")
	private WebElement Commercial;

	// Logistics
	@FindBy(how = How.LINK_TEXT, using = "Logistic Management")
	private WebElement logisticManagement;

	@FindBy(how = How.LINK_TEXT, using = "Issue Receive")
	private WebElement IssueReceive;
	
	@FindBy(how = How.LINK_TEXT, using = "Issue Receive Confirmation")
	private WebElement IssueReceiveConfirm;

	@FindBy(how = How.LINK_TEXT, using = "General Delivery Plan")
	private WebElement generalDeliveryPlan;
	@FindBy(how = How.CSS, using = "[ng-click='menuItemClick(1000001128)']")
	private WebElement generalDeliveryPlanEntry;
	@FindBy(how = How.LINK_TEXT, using = "General Delivery Plan Edit")
	private WebElement generalDeliveryPlanEdit;

	@FindBy(how = How.LINK_TEXT, using = "Delivery Confirm Entry")
	private WebElement deliveryConfirmEntry;
	@FindBy(how = How.LINK_TEXT, using = "Delivery Entry")
	private WebElement deliveryEntry;
	@FindBy(how = How.LINK_TEXT, using = "Delivery Edit")
	private WebElement deliveryEdit;
	@FindBy(how = How.LINK_TEXT, using = "Challan Acknowledgement")
	private WebElement challanAcknowledgement;
	@FindBy(how = How.LINK_TEXT, using = "Challan Acknowledgement Entry")
	private WebElement challanAcknowledgementEntry;

	// Gate Pass & Order Dispatch
	@FindBy(how = How.LINK_TEXT, using = "Gate Pass Management")
	private WebElement getPassManagement;

	@FindBy(how = How.LINK_TEXT, using = "Gate Pass & Order Dispatch")
	private WebElement getPass_orderDispatch;

	
	
	//Laboratory 
	@FindBy(how = How.LINK_TEXT, using = "Laboratory")
	private WebElement laboratory;
	
	//Order Wise Lab Test Result (Lab Report) 
	@FindBy(how = How.LINK_TEXT, using = "Order Wise Lab Test Result Entry")
	private WebElement labTestResult;
	
	 
	//Product Development [PD]
	@FindBy(how = How.LINK_TEXT, using = "PD")
	private WebElement pd;
	
	//Buyer Item Code 
	@FindBy(how = How.LINK_TEXT, using = "Buyer Item Code")
	private WebElement bic;
	
	//Buyer Item Code 
	@FindBy(how = How.LINK_TEXT, using = "Create Buyer Item Code")
	private WebElement createBIC;
	
	
	public void Accessory() {
		accessory.click();
	}

	public void MarketingAndSales() {
		marketingnSales.click();
	}

	// Customer Support
	public void CustomerSupport() {
		customerSupport.click();
	}

	public void Order() {
		order.click();
	}

	public void CreaetOrder() {
		createOrder.click();
	}

	public void EditOrder() {
		editeOrder.click();
	}

	public void OrderVerification() {
		orderVerification.click();
	}

	// Production management
	public void ProductionManagement() {
		productionManagement.click();
	}

	
	public void OrderSourcing() {
		orderSourcing.click();
		
	}
	
	public void OrderSourcingPlan() {
		orderSourcingPlan.click();
	}

	public void ManageProductionPlan() {
		manageProductionPlan.click();
	}

	public void ProductionPlanentry() {
		productionPlanentry.click();
	}

	public void OrderMasterFileIssue() {
		orderMasterFileIssue.click();
	}

	public void ProductionEntry() {
		productionEntry.click();
	}

	public void Issue() {
		Issue.click();
	}

	public void OrderIssue() {
		OrderIssue.click();
	}

	public void ManagePackaging() {
		managePackaging.click();
	}

	public void CreatePacking() {

		createPacking.click();
	}

	public void ConfirmPacking() {

		confirmPacking.click();
	}

	// SupplyChain
	public void SupplyChainManagement() {
		supplyChainManagement.click();
	}

	public void StockOrder() {
		stockOrder.click();
	}

	public void CreaetStockOrder() {
		CreateStockOrder.click();
	}

	public void verifyStockOrder() {
		VrtifyStockOrder.click();
	}

	// New

	public void RMSourcingPlan() {
		RMSourcing.click();

	}

	public void RMSourcingPlanBIC() {
		RMSourcingBIC.click();

	}

	public void PurchaseRequisition() {
		PurchaseReq.click();

	}

	public void PurchaseRequisitionStock() {
		PurchaseReqStock.click();

	}

	public void PurchaseOrder() {
		PurchaseOrder.click();

	}

	public void CreatePurchaseOrder() {
		CreatePurchaseOrder.click();

	}

	// Logistics Management
	public void LogisticManagement() {
		logisticManagement.click();
	}

	public void IssueReceive() {
		IssueReceive.click();
	}
	
	public void ReceiveConfirmIssue() {
		IssueReceiveConfirm.click();
	}

	public void GeneralDeliveryPlan() {
		generalDeliveryPlan.click();
	}

	public void GeneralDeliveryPlanEntry() {
		generalDeliveryPlanEntry.click();
	}

	public void GeneralDeliveryPlanEdit() {
		generalDeliveryPlanEdit.click();
	}

	public void DeliveryConfirm() {
		deliveryConfirmEntry.click();
	}

	public void DeliveryEntry() {
		deliveryEntry.click();
	}

	public void DeliveryEdit() {
		deliveryEdit.click();
	}

	public void ChallanAcknoldgement() {
		challanAcknowledgement.click();
	}

	public void ChallanAcknoldgementEntry() {
		challanAcknowledgementEntry.click();
	}

	// Gate Pass & Order Dispatch
	public void GatePassManagement() {
		getPassManagement.click();
	}

	public void GatePass_N_OrderDispatch() {
		getPass_orderDispatch.click();
	}
	
	
	//Laboratory
	public void Laboratory() {
		laboratory.click();
	}
	
	public void LabTestResultEntry() {
		labTestResult.click();
	}
	
	
	//PD
	
	public void PD() {
		pd.click();
	}
	
	public void BIC() {
		bic.click();
	}
	public void CreateBIC() {
		createBIC.click();
	}

}

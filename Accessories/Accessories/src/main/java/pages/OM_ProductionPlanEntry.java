package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class OM_ProductionPlanEntry {


	@FindBy(how = How.CSS, using = "[data-ng-model='searchEntity.ordID']")
	private WebElement OrderNo2;
	
	@FindBy(how = How.CSS, using = "[data-ng-model='searchEntity.ordID'] [name='searchText']")
	private WebElement InsertOrderNo;
	
	@FindBy(how = How.CSS, using = "div:nth-child(2) > div:nth-child(1) > div > div > div > ul > li.list-group-item.mddl.ng-scope > div > label > input")
	private WebElement ClickInsertOrderNo;
	
	@FindBy(how = How.CSS, using = "button.btn-search")
	private WebElement Search;
	
	@FindAll(@FindBy(how = How.CSS, using = "[data-ng-click='selectRow(entity)']"))
	private List <WebElement> SelectOrderItem;
	
	@FindBy(how = How.CSS, using = ".fa-check-circle-o")
	private WebElement okButton;
	
	@FindBy(how = How.CSS, using = ".fa-arrow-circle-down")
	private WebElement SlidingScreenBtn;

	@FindAll(@FindBy(how = How.CSS, using = "div.ni-table-row.ng-scope > div:nth-child(16)"))
	private List <WebElement> balance;
	
	@FindBy(how = How.CSS, using = "div.ni-table-row.ng-scope > div:nth-child(16)")
	private WebElement BalanceP1;
	
	@FindBy(how = How.CSS, using = "[data-ng-model='entity.planQty']")
	private WebElement PlanP1;
	
	@FindBy(how = How.CSS, using = "[data-ng-show='vmv.isExpand === false']")
	private WebElement ExpandButtonClick;

	@FindBy(how = How.CSS, using = "div[data-ng-form='planItemDtlForm']")
	private WebElement ExpandBalance;
	
	@FindAll(@FindBy(how = How.CSS, using = "[data-ng-model='entity.planQty']"))
	private List <WebElement> ExpandPlanQty;
	
	@FindBy(how = How.CSS, using = "private WebElement checkItem;// [data-ng-disabled='entity.isCombined || vmv.entryMode === operationMode.update']")
	private WebElement CollaupsedActioncheckbox;
	
	@FindAll(@FindBy(how = How.CSS, using = "div:nth-child(19) > ul > li > div > label > input"))
	private List <WebElement> ExpandActionCheckBox;
	
	@FindBy(how = How.CSS, using = "[data-ng-disabled='entity.isCombined || vmv.entryMode === operationMode.update']")
	private WebElement checkItemwithsize;

	@FindAll(@FindBy(how = How.CSS, using = "div.ni-table-row.ng-scope > div.ni-table-cell.p-none.cell-dropdown-visible > input"))
	private List <WebElement> Planqty;

	@FindBy(how = How.CSS, using = "div:nth-child(19) > ul > li > div > label > input")
	private WebElement checkItem;

	@FindBy(how = How.CSS, using = "button.btn-okay")
	private WebElement OkBtn;
	
	@FindBy(how = How.CSS, using = "[data-ng-model='vmv.planItem.machineID']")
	private WebElement machineno;
	
	@FindBy(how = How.CSS, using = "[ni-control-focus='focusTargetQty']")
	private WebElement TargetQty;
	
	@FindBy(how = How.CSS, using = "button.btn-addorder")
	private WebElement addToJobOrder;

	@FindBy(how = How.CSS, using = "button.btn-save")
	private WebElement SaveBtn;

	@FindBy(how = How.CSS, using = "button.btn-selectItem")
	private WebElement AddNewPlan;

	
	
	public void SelectOrderNo(String OrderNo) {
		OrderNo2.click();
		InsertOrderNo.sendKeys(OrderNo);
		ClickInsertOrderNo.click();
		}
	
	public void ClickSearch() {
		Search.click();
	}
	
	
	public void SelectOrderItemForPlan() {
		WebElement orditem = SelectOrderItem.get(SelectOrderItem.size()-1); //always select last item of first page
		
		orditem.click();
	}

	public void ClickOkButton() {
		okButton.click();
	}

	public void OpenSlidingScreen() {
		SlidingScreenBtn.click();
	}
	
	
	public void ExpandButton() {
		ExpandButtonClick.click();
	}
	

	public void InsertPlanQtyWithExpand() {
		 int i =0;
		for(WebElement SizePlanQty:Planqty){
			WebElement bal= balance.get(i);
			
			String SizeBal= bal.getText();
			SizePlanQty.clear();
			SizePlanQty.sendKeys(SizeBal);
			i++;
		
		}

		
	}
	
	public void SelectCheckBoxActionButton(){
		int i=0;
		for(WebElement button:ExpandActionCheckBox){
		WebElement Select = ExpandActionCheckBox.get(i);
		button.click();
		i++;
		
		
		}
		
	}
	
	
	public void InsertPlanQty1() {

		if (PlanP1.isEnabled() == true) {

			String bal = BalanceP1.getText();
			PlanP1.clear();
			PlanP1.sendKeys(bal);
			checkItemwithsize.click();
			
		} 
		else{
			
			checkItemwithsize.click();
			
			}
		}
	
	
	
	
	public void CheckOrderItemDetailWithSize() {
		checkItemwithsize.click();
	}
	

	public void CheckOrderItemDetail() {
		checkItem.click();
	}

	public void ClickOkButtonToSelectOrdDtl() {
		OkBtn.click();
	}

	public void SelectMachineNo(String MachineNo) {
		Select SelectMachine = new Select(machineno);
		SelectMachine.selectByVisibleText(MachineNo);
	}

	public void InsertTargetQty(String Targetqty) {
		TargetQty.clear();
		TargetQty.sendKeys(Targetqty);
	}

	public void AddToJobOrder() {
		addToJobOrder.click();
	}

	public void SavePlan() {
		SaveBtn.click();
	}

	public void AddNewPlan() {
		AddNewPlan.click();
	}
	
	

}

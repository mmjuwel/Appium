package pages;

import java.util.List;

import javax.swing.Spring;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class OM_ProductionEntry {

	@FindBy(how = How.CSS, using = "[data-ng-model='modelObject.selectedProcessID']")
	WebElement process;

	@FindBy(how = How.CSS, using = "[data-ng-model='modelObject.selectedMachineID']")
	WebElement machine;
	
	@FindBy(how = How.CSS, using = "div:nth-child(1) > div > div.col-md-2 > div > div > button")
	WebElement ClickonSearch;

	@FindBy(how = How.CSS, using = "tr:nth-child(1) > td.p-none > ul > li > a > i")
	WebElement selectJobOrder;

	@FindBy(how = How.CSS, using = "[data-ng-disabled='model.jobOrder.joblevel == fixedIDs.jobLevelCD.WJL']")
	WebElement operator;

	@FindBy(how = How.CSS, using = "button.btn-start")
	WebElement startButton;

	@FindBy(how = How.CSS, using = "button.btn-finished")
	WebElement finishButton;

	@FindBy(how = How.CSS, using = "button.btn-stop")
	WebElement stopButton;

	@FindBy(how = How.CSS, using = "form>div>div:nth-child(5)>div>div>div>div>div:nth-child(1)>button")
	WebElement outOFOrderButton;

	@FindBy(how = How.CSS, using = "[data-ng-click='onClickHourlyProduction(pItem)']")
	WebElement hourlyButton_expand;

	@FindBy(how = How.CSS, using = "[data-ng-click='onClickHourlyProductionCollapsed()']")
	WebElement hourlyButton_colapse;

	@FindBy(how = How.CSS, using = "[data-ng-click='onClickShiftWiseProduction(pItem)']")
	WebElement shiftButton_expand;

	@FindBy(how = How.CSS, using = "[data-ng-click='onClickShiftWiseProductionCollapsed()']")
	WebElement ShiftButton_colapse;

	@FindBy(how = How.CSS, using = "div:nth-child(2)>div:nth-child(1)>table:nth-child(1)>tbody:nth-child(2)>tr:nth-child(1)>td:nth-child(14)")
	WebElement planQty_expand;

	@FindBy(how = How.CSS, using = "div:nth-child(2)>div:nth-child(2)>table:nth-child(1)>tbody:nth-child(2)>tr:nth-child(1)>td:nth-child(14)")
	WebElement planQty_collapse;

	@FindBy(how = How.CSS, using = "div:nth-child(2)>div:nth-child(1)>table:nth-child(1)>tbody:nth-child(2)>tr:nth-child(1)>td:nth-child(16)")
	WebElement totalProductionQty_expand;

	@FindBy(how = How.CSS, using = "div:nth-child(2)>div:nth-child(2)>table:nth-child(1)>tbody:nth-child(2)>tr:nth-child(1)>td:nth-child(16)")
	WebElement totalProductionQty_collapse;

	@FindBy(how = How.CSS, using = "div:nth-child(2)>div:nth-child(1)>table:nth-child(1)>tbody:nth-child(2)>tr:nth-child(1)>td:nth-child(17)")
	WebElement balanceqty_expand;
	
	@FindBy(how = How.CSS, using = "div:nth-child(2)>div:nth-child(2)>table:nth-child(1)>tbody:nth-child(2)>tr:nth-child(1)>td:nth-child(17)")
	WebElement balanceqty_collapse;
	
	@FindBy(how = How.CSS, using = "tbody > tr:nth-child(1) > td.p-none > input")
	WebElement productionQtyEntry;

	@FindBy(how = How.CSS, using = "button.btn-save")
	WebElement saveButton;

	@FindBy(how = How.CSS, using = "button[data-ng-click='cancel()']")
	WebElement closeButton;
	
	@FindBy(how = How.CSS, using = "[data-ng-disabled='isProdFinished || model.isEnabledStarting']")
	WebElement Collapsebutton;
	
	//Special Case
	@FindAll(@FindBy(how = How.CSS, using = "form[name='productionForm'] [data-ng-hide='model.production.isCollapsed'] > [blank-grid='planItemDetailGridOption'] td:nth-of-type(17)"))
	private List <WebElement> SizeWiseExpandBalance;
	
	@FindAll(@FindBy(how = How.CSS, using = "form[name='productionForm'] [data-ng-hide='model.production.isCollapsed'] > [blank-grid='planItemDetailGridOption'] td:nth-of-type(18)"))
	private List <WebElement> SizeWiseExpandShift;
	
	
	@FindAll(@FindBy(how = How.CSS, using = "[data-ng-model='hours.hourlyProdQty']"))
	private List <WebElement> SizeWiseProdQty;
	
	
	@FindAll(@FindBy(how = How.CSS, using = "form[name='productionForm'] [data-ng-hide='model.production.isCollapsed'] > [blank-grid='planItemDetailGridOption'] td:nth-of-type(17)"))
	List <WebElement> ExpandBalanceSize;
	
	
	@FindAll(@FindBy(how = How.CSS, using = "tbody > tr > td.p-none > input"))
	List <WebElement> ExpandProductionQty;
	
	
	@FindAll(@FindBy(how = How.CSS, using = "form[name='productionForm'] div:nth-of-type(2) > div:nth-of-type(2) tr:nth-of-type(2) button:nth-of-type(2)"))
	List <WebElement> ExpandShift;
	
	

	public void SelectProcess(String processName) {
		Select PlantProcess = new Select(process);
		PlantProcess.selectByVisibleText(processName);
	}

	public void SelectMachine(String machineNo) {
		Select processMachine = new Select(machine);
		processMachine.selectByVisibleText(machineNo);
	}
	
	public void Search() {
		ClickonSearch.click();
	}

	
	
	@FindBy(how = How.CSS, using = "[data-ng-model='searchParams.orderID']")
	WebElement orderNumber;
	
	@FindBy(how = How.CSS, using = "[data-ng-model='searchParams.jobOrderID']")
	WebElement joborderNumber;
	
	@FindBy(how = How.CSS, using = "button[data-ng-disabled='!(searchParams.jobOrderID || searchParams.orderID)']")
	WebElement searcForOrder_joborder;
	
	public void SelectOrderNo(String orderNo) {
		Select ordernumberselect = new Select(orderNumber);
		ordernumberselect.selectByVisibleText(orderNo);
	}
	
	public void SelectJobOrder(String jobOrderNo) {
		Select jobOrderSelect = new Select(joborderNumber);
		jobOrderSelect.selectByVisibleText(jobOrderNo);
	}
	
	public void SearchJobOrder() {
		searcForOrder_joborder.click();
	}
	
	
	
	
	
	
	public void SelectJobOrder() {
		selectJobOrder.click();
	}

	public void SelectOperator(String operatorName) {
		Select operatorList = new Select(operator);
		operatorList.selectByVisibleText(operatorName);
	}

	public void StartProcess() {
		startButton.click();
	}

	public void StopProcess() {
		stopButton.click();
	}
	

	
	public void CollapsebuttonClick() {
		Collapsebutton.click();
	}
	
	

	public void SelectProductionType(String prodtype) {
		if (prodtype.equals("Hourly")) {
			if (hourlyButton_colapse.isDisplayed())
				hourlyButton_colapse.click();
			else {
				hourlyButton_expand.click();
			}
		}
		if (prodtype.equals("Shift")) {
			if (ShiftButton_colapse.isDisplayed()) {
				ShiftButton_colapse.click();
			} else {
				shiftButton_expand.click();
			}
		}
	}

	public void InsertProductionQty() {
		productionQtyEntry.clear();

		if (balanceqty_expand.isDisplayed()) {

			productionQtyEntry.sendKeys(balanceqty_expand.getText());
		} else {
			productionQtyEntry.sendKeys(balanceqty_collapse.getText());
		}
	}
	
	
	
	
	
	public void InsertPlanQtyWithExpand() {
		 int size =0;
		for(WebElement SizeProdQty:ExpandProductionQty){
			WebElement bal= ExpandBalanceSize.get(size);
			
			String SizeBal= bal.getText();
			//size++;
			// shit
			//ExpandShift.
			
			int i=0;
			for(WebElement Shift:ExpandShift){
				WebElement Click= ExpandShift.get(i);{
					Shift.click();	
					//i++;
				}
			
			SizeProdQty.clear();
			SizeProdQty.sendKeys(SizeBal);
			saveButton.click();
			//save
			
			System.out.println();
		}
		
		
	}
	}
	
	
	

	public void SaveProduction() {
		saveButton.click();
	}

	public void StopProduction() {
		stopButton.click();
	}
	
	// No need this for Present Busness
	public void FinishProcess() {
		if (planQty_collapse.isDisplayed() && totalProductionQty_collapse.isDisplayed()) {
			if (planQty_collapse.getText().equals(totalProductionQty_collapse.getText())) {
				finishButton.click();
			}
		} else {
			if (planQty_collapse.getText().equals(totalProductionQty_collapse.getText())) {
				finishButton.click();
			}
		}
	}

	public void CloseProcess() {
		closeButton.click();
	}

}

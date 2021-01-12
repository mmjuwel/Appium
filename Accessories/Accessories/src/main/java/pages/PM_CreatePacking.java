package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;


public class PM_CreatePacking {

	// Clink on Dropdwon
	@FindAll(@FindBy(how = How.XPATH, using = "//button[@class='btn btn-multiselect ng-binding']"))
	private List<WebElement> ClickDropdown;

	// Insert dropdwon Search value
	@FindAll(@FindBy(how = How.XPATH, using = "//input[@placeholder='<Search>']"))
	private List<WebElement> InsertSearchValue;

	// Find Selected text
	@FindAll(@FindBy(how = How.XPATH, using = "//div[@class='form-control dropdown multi-select p-none ng-isolate-scope ng-valid open']//div"))
	private List<WebElement> FindText;

	// Select Search Value
	@FindAll(@FindBy(how = How.XPATH, using = "//div[@class='form-control dropdown multi-select p-none ng-isolate-scope ng-valid open']//div//input"))
	private List<WebElement> SelectSearchValue;

	// Customer Label
	@FindBy(how = How.XPATH, using = "//label[@title='Customer']")
	private WebElement Label;

	// Select Button
	@FindBy(how = How.XPATH, using = "//button[@class='btn btn-search btn-primary']")
	private WebElement searchButton;

	// Job Order No Column
	@FindAll(@FindBy(how = How.XPATH, using = "//div[@class='table-responsive ']//table[1]//tbody//tr//td[10]"))
	private List<WebElement> jobNo;

	// Packed Quantity Column
	@FindAll(@FindBy(how = How.XPATH, using = "//div[@class='table-responsive ']//table[1]//tbody//tr//td[14]"))
	private List<WebElement> packedQuantity;

	// Action button Column
	@FindAll(@FindBy(how = How.XPATH, using = "//div[@class='table-responsive ']//table[1]//tbody//tr//td[16]"))
	private List<WebElement> actionbutton;

	// P/UOM1
	@FindBy(how = How.XPATH, using = "//select[@data-ng-model='model.pack.pUOMID']")
	private WebElement selectPUOM1;

	// P/UOM1
	@FindBy(how = How.XPATH, using = "//select[@data-ng-model='model.pack.pUOMID']")
	private WebElement packPlanNo;

	// Total grid size
	@FindAll(@FindBy(how = How.XPATH, using = "//div[@data-ng-repeat='entity in model.pack.packageItemList']"))
	private List<WebElement> gridSize;
	
		// Pack Balance
	@FindAll(@FindBy(how = How.XPATH, using = "//div[@data-ng-repeat='entity in model.pack.packageItemList']//div[10]"))
	private List<WebElement> packBal;
	
	// Pack Quantity Amount (PackQty)
	@FindAll(@FindBy(how = How.XPATH, using = "//div[@data-ng-repeat='entity in model.pack.packageItemList']//div[11]//input"))
	private List<WebElement> packQty;
	
	// Quantity of unit of Measurement(Qty_PUOM)
	@FindAll(@FindBy(how = How.XPATH, using = "//div[@data-ng-repeat='entity in model.pack.packageItemList']//div[12]//input"))
	private List<WebElement> qtyPUOM;
	
	// Pack Weight (Wt_Kg)
	@FindAll(@FindBy(how = How.XPATH, using = "//div[@data-ng-repeat='entity in model.pack.packageItemList']//div[13]//input"))
	private List<WebElement> wtKg;
	
	// Save 
	@FindBy(how = How.XPATH, using = "//button[@class='btn btn-save btn-success']")
	private WebElement save;
	
	
	// Reset 
	@FindAll(@FindBy(how = How.XPATH, using = "//button[@class='btn btn-reset btn-danger']"))
	private List<WebElement> reset;
	
	// Confirm reset OK
	@FindBy(how = How.ID, using = "btnOk")
	private WebElement okReset;
	
	// Close window
	@FindAll(@FindBy(how = How.XPATH, using = "//li[@data-ng-click='closeWindow()']"))
	private List<WebElement> closeWindow;
	
		
		
	public boolean SelectDropdown(String SearchVal, int divIndex) {
		divIndex -= 1;
		ClickDropdown.get(divIndex).click();
		InsertSearchValue.get(divIndex).clear();
		InsertSearchValue.get(divIndex).sendKeys(SearchVal);

		for (int i = 0; i < SelectSearchValue.size(); i++) {

			if (FindText.get(i).getText().equalsIgnoreCase(SearchVal)) {
				SelectSearchValue.get(i).click();

			}
		}
		Label.click();
		String selectedValue = ClickDropdown.get(divIndex).getText();
		if (!selectedValue.isEmpty()) {
			return true;
		} else {
			return false;
		}

	}

	public void SearchButton() {
		searchButton.click();
	}

	public void ItemList(String JobOrderNo) throws Exception {

		int totalRow = jobNo.size();

		for (int i = 0; i < jobNo.size(); i++) {

			if (!JobOrderNo.isEmpty()) {

				if (jobNo.get(i).getText().equalsIgnoreCase(JobOrderNo)) {
					actionbutton.get(i).click();
					Thread.sleep(3000);
				}

			} else {
				if (Integer.parseInt(packedQuantity.get(i).getText()) > 0) {
					actionbutton.get(i).click();
					Thread.sleep(3000);
				}

			}

		}

	}

	public void PackingInfoGridEntry(String P_UOM1) {

		// Enter Packing Information
		if (!P_UOM1.isEmpty()) {

			// Select "P/UOM1" from dropdown
			Select Select_PUOM1 = new Select(selectPUOM1);
			Select_PUOM1.selectByVisibleText(P_UOM1);

		}
		
		int TotalGridSize = gridSize.size();
		
		
		
		for (int rowIndex=0; rowIndex < gridSize.size();rowIndex++) {			
			// Get  Pack Balance 
		String PackBlance=	packBal.get(rowIndex).getText();
			
			
			// Enter Pack Quantity Amount (PackQty)
			packQty.get(rowIndex).clear();
			packQty.get(rowIndex).sendKeys(PackBlance);

			double devidat = Integer.parseInt(PackBlance) / 5;
			
			if(devidat<1) {
				devidat=1;
			}
			int Qty_PUOM =(int)Math.round(devidat);
			
			// Enter Quantity of unit of Measurement(Qty_PUOM)
			qtyPUOM.get(rowIndex).clear();
			qtyPUOM.get(rowIndex).sendKeys(String.valueOf(Qty_PUOM));

			// Enter Weight (Wt_Kg)
			//wtKg.get(rowIndex).clear();
			//wtKg.get(rowIndex).sendKeys("10");
			
		} 

	}

	public boolean Save() throws Exception {
		
		save.click();
			// Gate "Pack Plan No"
		Thread.sleep(1000);
		if(!packPlanNo.getText().isEmpty()) {
			//Close Pack Entry window
			closeWindow.get(1).click();
			return true;
			
		}else {		
			return false;
		}
		
		
		
	}
	
	
	
	public void Reset(int x) throws Exception {
		if(x==0) {
			//  Reset Search Parametere
			reset.get(0).click();
		}else {
			// Confirm Reset Packing grid 
			reset.get(1).click();
			Thread.sleep(500);
			okReset.click();
			//Close Pack Entry window
			closeWindow.get(1).click();
			
			
		}
	}
	
}

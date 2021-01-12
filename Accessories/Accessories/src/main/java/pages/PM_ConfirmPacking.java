package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;


public class PM_ConfirmPacking {

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

	// Packing list by Order No
	@FindAll(@FindBy(how = How.XPATH, using = "//div[@class='table-responsive ']//table[1]//tbody//tr//td[3]"))
	private List<WebElement> orderNo;

	// Ready for Packing
	@FindAll(@FindBy(how = How.XPATH, using = "//div[@class='table-responsive ']//table[1]//tbody//tr//td[15]"))
	private List<WebElement> rfp;

	// Confirm Balance Quantity
	@FindAll(@FindBy(how = How.XPATH, using = "//div[@class='table-responsive ']//table[1]//tbody//tr//td[18]"))
	private List<WebElement> cBalQty;
	// Action button Column
	@FindAll(@FindBy(how = How.XPATH, using = "//div[@class='table-responsive ']//table[1]//tbody//tr//td[22]"))
	private List<WebElement> actionbutton;

	// Totla row of grid
	@FindAll(@FindBy(how = How.XPATH, using = "//div[@data-ng-repeat='packItm in model.pack.packageItemList']"))
	private List<WebElement> gridSize;

	// Get balance Quantity
	@FindAll(@FindBy(how = How.XPATH, using = "//div[@data-ng-repeat='packItm in model.pack.packageItemList']//div[20]"))
	private List<WebElement> getBalQty;

	// Check confirm pack
	@FindAll(@FindBy(how = How.XPATH, using = "//div[@data-ng-repeat='packItm in model.pack.packageItemList']//div[21]//div//div[1]//div[4]//input"))
	private List<WebElement> checkedConform;

	// Get Confirm Pack Quantity
	@FindAll(@FindBy(how = How.XPATH, using = "//div[@data-ng-repeat='packItm in model.pack.packageItemList']//div[19]"))
	private List<WebElement> getCQty;

	// Checked All
	@FindBy(how = How.XPATH, using = "(//div[@class='ni-table-header-group'])[2]//div//div//input")
	private WebElement checkAll;

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
	
	
	// Dropdown Selection
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
	
	// Click search button
	public void SearchButton() {
		searchButton.click();
	}
	// Select item from list
	public void ItemList(String OrderNo) throws Exception {

		int totalRow = orderNo.size();

		for (int i = 0; i < orderNo.size(); i++) {
			int RFP = Integer.parseInt(rfp.get(i).getText());
			int CBalQty = Integer.parseInt(cBalQty.get(i).getText());

			if (!OrderNo.isEmpty() && RFP > 0 && CBalQty > 0) {

				if (orderNo.get(i).getText().equalsIgnoreCase(OrderNo)) {
					actionbutton.get(i).click();
					Thread.sleep(1000);
				}

			} else {
				Assert.fail("Invali Order No  or RFP value or cBalQty ");

			}
		}
	}

	//Confirm pack one by one
	public void ConfirmPack() throws Exception {

		int TotalGridSize = gridSize.size();

		for (int rowIndex = 0; rowIndex < gridSize.size(); rowIndex++) {
			// Get Pack Balance
			int BalanceQty = Integer.parseInt(getBalQty.get(rowIndex).getText());

			// Checked Confirm check box
			checkedConform.get(rowIndex).click();
			Thread.sleep(500);
			int ConfirmPackQty = Integer.parseInt(getCQty.get(rowIndex).getText());
			if (BalanceQty > 0 && ConfirmPackQty > 0) {

			} else {
				Assert.fail("Fail!!.. Balance Quantity or Conform Pack Quantity is 0");
			}

		}

	}
	// Confirm All Pack
	public void ConfirmAll() throws Exception {
		checkAll.click();
		Thread.sleep(1000);
		for (int rowIndex = 0; rowIndex < gridSize.size(); rowIndex++) {

			// Checked Confirm check box
			boolean Checked = checkedConform.get(rowIndex).isSelected();
			
			int ConfirmPackQty = Integer.parseInt(getCQty.get(rowIndex).getText());
			if (Checked) {

			} else {
				Assert.fail("Fail!!.. All Check box not selected");
			}
		}

	}

	// Save and close window
	public void Save() throws Exception {

		save.click();
		Thread.sleep(3000);
		// Close Pack Entry window
		closeWindow.get(1).click();

	}
	
	// Reset 
	public void Reset(int x) throws Exception {
		if (x == 0) {
			// Reset Search Parametere
			reset.get(0).click();
		} else {
			// Confirm Reset Packing grid
			reset.get(1).click();
			Thread.sleep(500);
			okReset.click();
			// Close Pack Entry window
			closeWindow.get(1).click();

		}
	}
	
	
	
	@FindBy(how = How.XPATH, using = "//div[@class='toast-message']")
	private WebElement getToastMessage;
	@FindBy(how = How.CSS, using = "[data-ng-model='model.pack.orderNo']")
	private WebElement confirmOrderNo;
	
	public String TostMessage() {
		return getToastMessage.getText();
	}
	public String getConfirmedNo() {
		return confirmOrderNo.getAttribute("value");
	}
	

}

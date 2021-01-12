package pages;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class LAB_OWLabTestResultEntry {
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

	// Grid Size
	@FindAll(@FindBy(how = How.XPATH, using = "(//table[starts-with(@id,'_gridID')])[4]//tbody//tr[@class='ng-scope']"))
	private List<WebElement> gridSize;
	// Order No
	@FindAll(@FindBy(how = How.XPATH, using = "(//table[starts-with(@id,'_gridID')])[4]//tbody//tr[@class='ng-scope']//td[3]"))
	private List<WebElement> getOrderNo;

	// Job Order No
	@FindAll(@FindBy(how = How.XPATH, using = "(//table[starts-with(@id,'_gridID')])[4]//tbody//tr[@class='ng-scope']//td[6]"))
	private List<WebElement> getJobOrderNo;

	// Job OrderNo Expand button
	@FindAll(@FindBy(how = How.XPATH, using = "(//table[starts-with(@id,'_gridID')])[4]//tbody//tr[@class='ng-scope']//td[6]//a"))
	private List<WebElement> jobNoExpandButton;

	// Prodution Status
	@FindAll(@FindBy(how = How.XPATH, using = "(//table[starts-with(@id,'_gridID')])[4]//tbody//tr[@class='ng-scope']//td[17]"))
	private List<WebElement> getProSts;

	// Sample Revice Check box
	@FindAll(@FindBy(how = How.XPATH, using = "(//table[starts-with(@id,'_gridID')])[4]//tbody//tr[@class='ng-scope']//td[18]//input"))
	private List<WebElement> samRcvCheck;

	// Lab Status
	@FindAll(@FindBy(how = How.XPATH, using = "(//table[starts-with(@id,'_gridID')])[4]//tbody//tr[@class='ng-scope']//td[20]//select"))
	private List<WebElement> labSts;

	// Save
	@FindBy(how = How.XPATH, using = "//button[@class='btn btn-save btn-success']")
	private WebElement save;

	// Reset
	@FindAll(@FindBy(how = How.XPATH, using = "//button[@class='btn btn-reset btn-danger']"))
	private List<WebElement> reset;

	// Confirm reset OK
	@FindBy(how = How.ID, using = "btnOk")
	private WebElement okReset;

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

	// Update Lab Test Result

	public void UpdateLabStatus(String jobOrderNo, String OrderNo, String LabStatus) {
		int TotlaGridSize = gridSize.size();

		for (int i = 0; i < TotlaGridSize; i++) {
			String GetOrderNO = getOrderNo.get(i).getText();
			if (GetOrderNO.contains(OrderNo)) {
				String JobOrderNos = getJobOrderNo.get(i).getText();

				List<String> list = Arrays.asList(JobOrderNos.split(","));

				if (list.size() > 1) {
					jobNoExpandButton.get(i).click();
					TotlaGridSize = gridSize.size();
				}

				String ProStatus = getProSts.get(i).getText();

				if (ProStatus.equalsIgnoreCase("Done") || ProStatus.equalsIgnoreCase("Running")) {

					boolean Checked = samRcvCheck.get(i).isSelected();

					if (!Checked) {
						samRcvCheck.get(i).click();
					}

					Select LabSts = new Select(labSts.get(i));
					LabSts.selectByVisibleText(LabStatus);

				}
			}
		}

	}

	// Save
	public void Save() throws Exception {

		save.click();
		Thread.sleep(1000);
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

		}
	}

}

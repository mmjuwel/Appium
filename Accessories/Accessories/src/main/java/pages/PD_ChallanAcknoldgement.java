package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class PD_ChallanAcknoldgement {

	@FindBy(how = How.CSS, using = "[data-ng-model='value']")
	private WebElement searchByCustomer;
	@FindBy(how = How.CSS, using = ".ni-select-record")
	private WebElement selectCustomer;

	@FindBy(how = How.CSS, using = "[data-ng-model='searchEntity.dispatchID']")
	private WebElement searchByChallanNo;

	@FindBy(how = How.CSS, using = "[ng-model='$select.search']")
	private WebElement insertitemForSearch;
	@FindBy(how = How.CSS, using = ".ui-select-highlight")
	private WebElement selectHighlightedItemForSearch;

	@FindBy(how = How.CSS, using = "[data-ng-click='search()']")
	private WebElement searchButton;

	@FindBy(how = How.CSS, using = "select[data-ng-model='entity.chlnAckStatusCd']")
	//@FindBy(how = How.CSS, using = "#_gridID1589948001796 > tbody > tr > td:nth-child(4) > div > select")
	private WebElement ackStatus;
	@FindBy(how = How.CSS, using = "[data-ng-model='entity.acknowledgeDt']")
	private WebElement ackDate;
	@FindAll(@FindBy(how = How.CSS, using = ".ui-state-default"))
	List<WebElement> date;

	@FindBy(how = How.CSS, using = "[data-ng-model='entity.acknowledgeBy']")
	private WebElement ackBy;

	// Attach order sheet start
	@FindBy(how = How.CSS, using = "button.btn-upload > span")
	WebElement uploadChallanCopy;
//		@FindBy(how = How.CSS, using = " div > div.modal-header.ui-draggable-handle")
//		WebElement orderSheetPopup;
	@FindBy(how = How.CSS, using = "[accept]")
	WebElement fromComputer;
	@FindBy(how = How.CSS, using = "[data-ng-click='uploadImage()']")
	WebElement uploadSheetButton;
	@FindBy(how = How.CSS, using = ".btn[data-ng-click='close()'] > span")
	WebElement closeSheetpopup;
	// End File upload

	@FindBy(how = How.CSS, using = "button.btn-save > span")
	WebElement saveButton;
	@FindBy(how = How.CSS, using = "[data-ni-click='ackAnother()']")
	WebElement ackAnother;

	public void SearchByCustomer(String customerName) {
		searchByCustomer.sendKeys(customerName);
	}

	public void SelectCustomer() {
		selectCustomer.click();
	}

	public void SearchByChallanNo(String ChalNo) {
		searchByChallanNo.click();
		insertitemForSearch.clear();
		insertitemForSearch.sendKeys(ChalNo);
		selectHighlightedItemForSearch.click();
	}

	public void ClickOnSearchButton() {
		searchButton.click();
	}

	public void SelectAckStatus(String AckStatus) {
		Select ackst = new Select(ackStatus);
		//ackst.selectByVisibleText(AckStatus);
		ackst.selectByValue(AckStatus);
	}

	public void SelectAckDate(String Date) {
		ackDate.click();
		for (WebElement we : date)

		{
			if (we.getText().equals(Date)) {
				we.click();
				break;
			}
		}
	}

	public void SelectAckBy(String AckBy) {
		Select acBy = new Select(ackBy);
		acBy.selectByVisibleText(AckBy);
	}

	public void AttachOrderSheet(String filePath) {
		uploadChallanCopy.click();
		fromComputer.sendKeys(filePath);
	}

	public void UploadSheet() {
		uploadSheetButton.click();
	}

	public void CloseSheetpopup() {
		closeSheetpopup.click();
	}

	public void ClickOnSaveButton() {
		saveButton.click();
	}

	public boolean confiramSave() {
		boolean status = false;
		if (ackAnother.isEnabled()) {
			status = true;
		}
		return status;
	}

	public void ClickOnAckAnotherButton() {
		ackAnother.click();
	}

}

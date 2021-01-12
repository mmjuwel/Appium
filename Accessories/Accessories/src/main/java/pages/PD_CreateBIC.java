package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import utility.BaseClass;

public class PD_CreateBIC extends BaseClass {

	// Dropdown Selection ------
	public boolean SelectDropdown(String SearchVal, int divIndex) {

		// Clink on Dropdwon
		List<WebElement> ClickDropdown = driver.findElements(By.xpath("//div[@class='col-md-9 p-1-right-none']//div//a"));

		divIndex -= 1;
		ClickDropdown.get(divIndex).click();
		// Insert dropdwon Search value
		WebElement InsertSearchValue = driver.findElement(By.xpath("//div[@class='ui-select-dropdown select2-drop select2-with-searchbox select2-drop-active']//div//input"));

		InsertSearchValue.clear();
		InsertSearchValue.sendKeys(SearchVal);
		// Find Selected text
		List<WebElement> FindText = driver.findElements(By.xpath("//div[@class='ui-select-dropdown select2-drop select2-with-searchbox select2-drop-active']//ul//li//ul//li"));

		for (int i = 0; i < FindText.size(); i++) {

			if (FindText.get(i).getText().equalsIgnoreCase(SearchVal)) {
				FindText.get(i).click();

			}
		}

		String selectedValue = ClickDropdown.get(divIndex).getText();
		if (!selectedValue.isEmpty()) {
			return true;
		} else {
			return false;
		}

	}

	// -------Enter Buyer Item Code
	public void BuyerItemCode(String BIC) {

		driver.findElement(By.xpath("//input[@data-ng-model='model.itemCode.buyerItemCode']")).sendKeys(BIC);
	}

	// -------Check Generated Code
	public void Generatedcode(String Gcode) {
		if (Gcode.equals("Yes")) {
			driver.findElement(By.xpath("//input[@data-ng-model='model.itemCode.isAutoGenBIC']")).click();
		}
	}

	// Assert BIC Enter and Generate Code
	public boolean AssertBIC_GenCode() {
		WebElement bicEnter = driver.findElement(By.xpath("//input[@data-ng-model='model.itemCode.buyerItemCode']"));
		WebElement gCodeCheck = driver.findElement(By.xpath("//input[@data-ng-model='model.itemCode.isAutoGenBIC']"));
		String BIC = bicEnter.getText();
		boolean GenCode = gCodeCheck.isSelected();

		if (!BIC.isEmpty() || GenCode) {
			return true;
		} else {
			return false;
		}

	}

	// Check Is Product No Mandatory
	public boolean IsProductNoMandatory(String isPNM) throws Exception {
		WebElement proNoMandatory = driver.findElement(By.xpath("//input[@data-ng-model='model.itemCode.isProductNoMandatory']"));

		proNoMandatory.click();

		Thread.sleep(500);
		boolean IsProNoMand = proNoMandatory.isSelected();
		if (IsProNoMand) {
			return true;
		} else {
			return false;
		}
	}

	// Check Nominated
	public boolean Nominated(String Nomi) throws Exception {

		WebElement nomi = driver.findElement(By.xpath("//label[contains(@title,'Nominated')]//input[contains(@value,'1')]"));

		boolean DesableStatus = nomi.isDisplayed();
		if (DesableStatus) {
			nomi.click();
			Thread.sleep(00);
			boolean nomiStatus = nomi.isSelected();
			if (nomiStatus) {
				return true;
			} else {
				return false;
			}
		}
		return true;
	}

	// Check Non Nominated
	public boolean NonNominated(String NonNomi) {

		WebElement nonNomi = driver.findElement(By.xpath("//label[contains(@title,'Nominated')]//input[contains(@value,'2')]"));

		boolean DesableStatus = nonNomi.isDisplayed();
		if (DesableStatus) {

			nonNomi.click();
			boolean nonNomiStatus = nonNomi.isSelected();
			if (nonNomiStatus) {
				return true;
			} else {
				return false;
			}
		}
		return true;
	}

	// Enter Description
	public boolean Description(String Description) {
		WebElement descrip = driver.findElement(By.xpath("//textarea[@data-ng-model='model.itemCode.description']"));

		descrip.sendKeys(Description);

		// WebElement getDescrip = driver.findElement(By.xpath(""));
		String DescripStatus = descrip.getText();
		if (!DescripStatus.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	// Enter No Of Color
	public boolean NoOfColor(String ColorNo) {
		WebElement colorNo = driver.findElement(By.xpath("//input[@data-ng-model='model.itemCode.noOfColor']"));

		colorNo.sendKeys(ColorNo);

		String ColorNoStatus = colorNo.getText();
		if (!ColorNoStatus.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	// Upload Image using Attach/View Artwork
	public void AttachViewArtwork(String AttachedFile) throws Exception {
		// Click "Attach/View Artwork" button
		WebElement artWorkBtn = driver.findElement(By.xpath("//button[@class='btn-block btn-browse btn btn-default']"));
		artWorkBtn.click();
		Thread.sleep(1000);
		// Click "From Computer" button
		WebElement comBtn = driver.findElement(By.xpath("//span[@class='btn btn-info btn-file']//input"));
		comBtn.sendKeys(AttachedFile);
		// ---- Click "Upload" button
		Thread.sleep(1000);
		WebElement uploadBtn = driver.findElement(By.xpath("//button[@class='btn btn-upload btn-info']"));
		uploadBtn.click();
		Thread.sleep(2000);
		// ---- Click "Close" button
		WebElement closedBtn = driver
				.findElement(By.xpath("//div[@class='bottom-btn-group']//button[@class='btn btn-close btn-danger']"));
		closedBtn.click();
		Thread.sleep(3000);
	}

	// --- Start ---- Item Detail Entry--------

	// -------Enter itm
	public boolean itm(String itm) throws Exception {

		Select itemID = new Select(driver.findElement(By.xpath("//select[contains(@data-ng-model,'item.itemID')]")));
		itemID.selectByVisibleText(itm);
		Thread.sleep(500);
		itemID.getFirstSelectedOption();
		if (itemID.equals(itm)) {
			return true;
		} else {
			return false;
		}

	}

	// -------Enter typ
	public boolean typ(String typ) throws Exception {

		Select itemTypeID = new Select(
				driver.findElement(By.xpath("//select[contains(@data-ng-model,'item.itemTypeID')]")));
		itemTypeID.selectByVisibleText(typ);
		Thread.sleep(500);
		itemTypeID.getFirstSelectedOption();
		if (itemTypeID.equals(typ)) {
			return true;
		} else {
			return false;
		}

	}

	// -------Enter cat
	public boolean cat(String cat) throws Exception {

		Select catgoryID = new Select(
				driver.findElement(By.xpath("//select[contains(@data-ng-model,'item.catgoryID')]")));
		catgoryID.selectByVisibleText(cat);

		Thread.sleep(500);
		catgoryID.getFirstSelectedOption();
		if (catgoryID.equals(cat)) {
			return true;
		} else {
			return false;
		}

	}

	// -------Enter SubCat
	public boolean SubCat(String SubCat, int PartDivNumber) throws Exception {

		Select subCatID = new Select(
				driver.findElement(By.xpath("//select[contains(@data-ng-model,'item.subCatID')]")));
		subCatID.selectByVisibleText(SubCat);

		Thread.sleep(500);
		subCatID.getFirstSelectedOption();
		if (subCatID.equals(SubCat)) {
			return true;
		} else {
			return false;
		}

	}

	// Enter RNno
	public void RNno(String RNno) {

		driver.findElement(By.xpath("//input[contains(@data-ng-model,'item.rNNo')]")).sendKeys(RNno);

	}

	// Enter Option
	public void Option(String Option) {

		List<WebElement> OptionDiv = driver.findElements(By.xpath("//div[@ng-repeat='optionObj in item.bICOptionList']"));
		OptionDiv.size();
		driver.findElement(By.xpath("(//div[@ng-repeat='optionObj in item.bICOptionList'])[" + OptionDiv.size()
				+ "]//input[@data-ng-model='optionObj.optionCode']")).clear();
		driver.findElement(By.xpath("(//div[@ng-repeat='optionObj in item.bICOptionList'])[" + OptionDiv.size()
				+ "]//input[@data-ng-model='optionObj.optionCode']")).sendKeys(Option);

	}

	// Enter Option Name
	public void Option_Name(String OptionName) {
		List<WebElement> OptionDiv = driver.findElements(By.xpath("//div[@ng-repeat='optionObj in item.bICOptionList']"));
		OptionDiv.size();
		driver.findElement(By.xpath("(//div[@ng-repeat='optionObj in item.bICOptionList'])[" + OptionDiv.size()
				+ "]//input[@data-ng-model='optionObj.optionName']")).clear();
		driver.findElement(By.xpath("(//div[@ng-repeat='optionObj in item.bICOptionList'])[" + OptionDiv.size()
				+ "]//input[@data-ng-model='optionObj.optionName']")).sendKeys(OptionName);

	}

	// Enter Color Option
	public void Color_Option(String ColorOption) {
		List<WebElement> OptionDiv = driver.findElements(By.xpath("//div[@ng-repeat='optionObj in item.bICOptionList']"));
		OptionDiv.size();
		driver.findElement(By.xpath("(//div[@ng-repeat='optionObj in item.bICOptionList'])[" + OptionDiv.size()
				+ "]//input[@data-ng-model='optionObj.colorOption']")).clear();
		driver.findElement(By.xpath("(//div[@ng-repeat='optionObj in item.bICOptionList'])[" + OptionDiv.size()
				+ "]//input[@data-ng-model='optionObj.colorOption']")).sendKeys(ColorOption);

	}

	public void GridEntry(String GroundColor, String GroundColorCode, String TextColor, String TextColorCode,
			String Thickness, String BackingMic, String WarpColor, String Diameter, String GSM, String Design,
			String Folding, String Slit, String Cutting, String PeelType, String EdgeFinish, String Composition,
			String Specialty, String Certification) throws Exception {

		List<WebElement> OptionDiv = driver.findElements(By.xpath("//div[@ng-repeat='optionObj in item.bICOptionList']"));
		OptionDiv.size();

		// --Ground Color
		driver.findElement(By.xpath("((//div[@ng-repeat='optionObj in item.bICOptionList'])[" + OptionDiv.size()
				+ "]//input[@data-ng-model='attrValue.attributeValue'])[1]")).clear();
		driver.findElement(By.xpath("((//div[@ng-repeat='optionObj in item.bICOptionList'])[" + OptionDiv.size()
				+ "]//input[@data-ng-model='attrValue.attributeValue'])[1]")).sendKeys(GroundColor);
		// --Ground Color Code
		driver.findElement(By.xpath("((//div[@ng-repeat='optionObj in item.bICOptionList'])[" + OptionDiv.size()
				+ "]//input[@data-ng-model='attrValue.attributeValue'])[2]")).clear();
		driver.findElement(By.xpath("((//div[@ng-repeat='optionObj in item.bICOptionList'])[" + OptionDiv.size()
				+ "]//input[@data-ng-model='attrValue.attributeValue'])[2]")).sendKeys(GroundColorCode);
		// --Text Color
		driver.findElement(By.xpath("((//div[@ng-repeat='optionObj in item.bICOptionList'])[" + OptionDiv.size()
				+ "]//input[@data-ng-model='attrValue.attributeValue'])[3]")).clear();
		driver.findElement(By.xpath("((//div[@ng-repeat='optionObj in item.bICOptionList'])[" + OptionDiv.size()
				+ "]//input[@data-ng-model='attrValue.attributeValue'])[3]")).sendKeys(TextColor);
		// --Text Color Code
		driver.findElement(By.xpath("((//div[@ng-repeat='optionObj in item.bICOptionList'])[" + OptionDiv.size()
				+ "]//input[@data-ng-model='attrValue.attributeValue'])[4]")).clear();
		driver.findElement(By.xpath("((//div[@ng-repeat='optionObj in item.bICOptionList'])[" + OptionDiv.size()
				+ "]//input[@data-ng-model='attrValue.attributeValue'])[4]")).sendKeys(TextColorCode);
		// --Thickness
		driver.findElement(By.xpath("((//div[@ng-repeat='optionObj in item.bICOptionList'])[" + OptionDiv.size()
				+ "]//input[@data-ng-model='attrValue.attributeValue'])[5]")).clear();
		driver.findElement(By.xpath("((//div[@ng-repeat='optionObj in item.bICOptionList'])[" + OptionDiv.size()
				+ "]//input[@data-ng-model='attrValue.attributeValue'])[5]")).sendKeys(Thickness);
		// --Backing Mic
		driver.findElement(By.xpath("((//div[@ng-repeat='optionObj in item.bICOptionList'])[" + OptionDiv.size()
				+ "]//input[@data-ng-model='attrValue.attributeValue'])[6]")).clear();
		driver.findElement(By.xpath("((//div[@ng-repeat='optionObj in item.bICOptionList'])[" + OptionDiv.size()
				+ "]//input[@data-ng-model='attrValue.attributeValue'])[6]")).sendKeys(BackingMic);
		// --Warp Color
		driver.findElement(By.xpath("((//div[@ng-repeat='optionObj in item.bICOptionList'])[" + OptionDiv.size()
				+ "]//input[@data-ng-model='attrValue.attributeValue'])[7]")).clear();
		driver.findElement(By.xpath("((//div[@ng-repeat='optionObj in item.bICOptionList'])[" + OptionDiv.size()
				+ "]//input[@data-ng-model='attrValue.attributeValue'])[7]")).sendKeys(WarpColor);

		// -- Diameter

		driver.findElement(By.xpath("((//div[@ng-repeat='optionObj in item.bICOptionList'])[" + OptionDiv.size()
				+ "]//select[@data-ng-model='attrValue.attributeValue'])[1]")).sendKeys(Diameter);

		// -- GSM

		driver.findElement(By.xpath("((//div[@ng-repeat='optionObj in item.bICOptionList'])[" + OptionDiv.size()
				+ "]//select[@data-ng-model='attrValue.attributeValue'])[2]")).sendKeys(GSM);
		// -- Design

		driver.findElement(By.xpath("((//div[@ng-repeat='optionObj in item.bICOptionList'])[" + OptionDiv.size()
				+ "]//select[@data-ng-model='attrValue.attributeValue'])[3]")).sendKeys(Design);
		// -- Folding

		driver.findElement(By.xpath("((//div[@ng-repeat='optionObj in item.bICOptionList'])[" + OptionDiv.size()
				+ "]//select[@data-ng-model='attrValue.attributeValue'])[4]")).sendKeys(Folding);
		// -- Slit

		driver.findElement(By.xpath("((//div[@ng-repeat='optionObj in item.bICOptionList'])[" + OptionDiv.size()
				+ "]//select[@data-ng-model='attrValue.attributeValue'])[5]")).sendKeys(Slit);
		// -- Cutting

		driver.findElement(By.xpath("((//div[@ng-repeat='optionObj in item.bICOptionList'])[" + OptionDiv.size()
				+ "]//select[@data-ng-model='attrValue.attributeValue'])[6]")).sendKeys(Cutting);
		// -- Peel type

		driver.findElement(By.xpath("((//div[@ng-repeat='optionObj in item.bICOptionList'])[" + OptionDiv.size()
				+ "]//select[@data-ng-model='attrValue.attributeValue'])[7]")).sendKeys(PeelType);
		// -- Edge Finish

		driver.findElement(By.xpath("((//div[@ng-repeat='optionObj in item.bICOptionList'])[" + OptionDiv.size()
				+ "]//select[@data-ng-model='attrValue.attributeValue'])[8]")).sendKeys(EdgeFinish);
		// -- Composition

		driver.findElement(By.xpath("((//div[@ng-repeat='optionObj in item.bICOptionList'])[" + OptionDiv.size()
				+ "]//select[@data-ng-model='attrValue.attributeValue'])[9]")).sendKeys(Composition);
		// -- Specialty

		driver.findElement(By.xpath("((//div[@ng-repeat='optionObj in item.bICOptionList'])[" + OptionDiv.size()
				+ "]//select[@data-ng-model='attrValue.attributeValue'])[10]")).sendKeys(Specialty);
		// -- Certification

		driver.findElement(By.xpath("((//div[@ng-repeat='optionObj in item.bICOptionList'])[" + OptionDiv.size()
				+ "]//select[@data-ng-model='attrValue.attributeValue'])[11]")).sendKeys(Certification);
	}

	public void partGridList(String D_UOM, String Length, String Width, String LAF, String WAF, String S_UOM,
			String Price, int PartNumber ) {

		boolean IsPriceSlabChecked = driver
				.findElement(By.xpath("//input[contains(@data-ng-model,'model.itemCode.hasSlab')]")).isSelected();
		driver.findElement(By.xpath("//input[@data-ng-model='item.hasMultiPart']")).isSelected();
		boolean iSCompositeItemChecked = driver
				.findElement(By.xpath("//input[@data-ng-model='model.itemCode.isComposite']")).isSelected();

		
		List<WebElement> OptionDiv = driver.findElements(By.xpath("//div[@ng-repeat='optionObj in item.bICOptionList']"));
		OptionDiv.size();
		
		//List <WebElement> PartNumberList=driver.findElements(By.xpath("(//div[@ng-repeat='optionObj in item.bICOptionList'])[" + OptionDiv.size()+ "]//select[@data-ng-model='objPart.dUOMID']"));
		
		//int PartNumber=PartNumberList.size();
				
		//int PartNumber= (PartNumberList.size()/2)+1;

		

		// -- Dimensional Unit Of Measurement (D/UOM)
		
		  Select dUOM= new Select(driver.findElement(By.xpath("((//div[@ng-repeat='optionObj in item.bICOptionList'])[" + OptionDiv.size()+ "]//select[@data-ng-model='objPart.dUOMID'])[" + PartNumber + "]")));
		  dUOM.selectByVisibleText(D_UOM);
		
		//driver.findElement(By.xpath("((//div[@ng-repeat='optionObj in item.bICOptionList'])[" + OptionDiv.size()+ "]//select[@data-ng-model='objPart.dUOMID'])[" + PartNumber + "]")).sendKeys(D_UOM);
		
		
		// -- Length
		driver.findElement(By.xpath("((//div[@ng-repeat='optionObj in item.bICOptionList'])[" + OptionDiv.size()
				+ "]//input[@data-ng-model='objPart.length'])[" + PartNumber + "]")).clear();
		driver.findElement(By.xpath("((//div[@ng-repeat='optionObj in item.bICOptionList'])[" + OptionDiv.size()
				+ "]//input[@data-ng-model='objPart.length'])[" + PartNumber + "]")).sendKeys(Length);
		// -- Width
		driver.findElement(By.xpath("((//div[@ng-repeat='optionObj in item.bICOptionList'])[" + OptionDiv.size()
				+ "]//input[@data-ng-model='objPart.width'])[" + PartNumber + "]")).clear();
		driver.findElement(By.xpath("((//div[@ng-repeat='optionObj in item.bICOptionList'])[" + OptionDiv.size()
				+ "]//input[@data-ng-model='objPart.width'])[" + PartNumber + "]")).sendKeys(Width);
		// -- Length After Folding
		driver.findElement(By.xpath("((//div[@ng-repeat='optionObj in item.bICOptionList'])[" + OptionDiv.size()
				+ "]//input[@data-ng-model='objPart.lengthAfterFolding'])[" + PartNumber + "]")).clear();
		driver.findElement(By.xpath("((//div[@ng-repeat='optionObj in item.bICOptionList'])[" + OptionDiv.size()
				+ "]//input[@data-ng-model='objPart.lengthAfterFolding'])[" + PartNumber + "]")).sendKeys(LAF);
		// -- Width After Folding
		driver.findElement(By.xpath("((//div[@ng-repeat='optionObj in item.bICOptionList'])[" + OptionDiv.size()
				+ "]//input[@data-ng-model='objPart.widthAfterFolding'])[" + PartNumber + "]")).clear();
		driver.findElement(By.xpath("((//div[@ng-repeat='optionObj in item.bICOptionList'])[" + OptionDiv.size()
				+ "]//input[@data-ng-model='objPart.widthAfterFolding'])[" + PartNumber + "]")).sendKeys(WAF);

		// -- Size Unit Of Measurement (S/UOM)
		if (!iSCompositeItemChecked) {
			Select sUOM = new Select(
					driver.findElement(By.xpath("((//div[@ng-repeat='optionObj in item.bICOptionList'])[" + OptionDiv.size()
							+ "]//select[@data-ng-model='objPart.uOMID'])[" + PartNumber + "]")));
			sUOM.selectByVisibleText(S_UOM);
		}

		// -- Price
		if (!(IsPriceSlabChecked || iSCompositeItemChecked)) {
			driver.findElement(By.xpath("((//div[@ng-repeat='optionObj in item.bICOptionList'])[" + OptionDiv.size()
					+ "]//input[@data-ng-model='objPart.price'])[" + PartNumber + "]")).clear();
			driver.findElement(By.xpath("((//div[@ng-repeat='optionObj in item.bICOptionList'])[" + OptionDiv.size()
					+ "]//input[@data-ng-model='objPart.price'])[" + PartNumber + "]")).sendKeys(Price);
		}
		// String D_UOM,String Length,String Width, String LAF,String WAF,String
		// S_UOM,String Price
	}

	// Add Option Button
	public  void Add_OptionButton() throws Exception {
		Thread.sleep(1000);
		boolean iSCompositeItemChecked =driver.findElement(By.xpath("//input[@data-ng-model='model.itemCode.isComposite']")).isSelected();
		String btn;
		if( iSCompositeItemChecked) {			
			List <WebElement> ComOptionNo = driver.findElements(By.xpath("//button[@ng-show='bicUIOptionObj.isAddShow']"));
			ComOptionNo.size();
			driver.findElement(By.xpath("(//button[@ng-show='bicUIOptionObj.isAddShow'])["+ComOptionNo.size()+"]")).click();
			
		}else {
			
			List<WebElement> OptionDiv = driver.findElements(By.xpath("//div[@ng-repeat='optionObj in item.bICOptionList']"));
			OptionDiv.size();
			driver.findElement(By.xpath("(//div[@ng-repeat='optionObj in item.bICOptionList'])[" + OptionDiv.size()+ "]//button[@ng-show='optionObj.isAddShow']")).click();
		}
		
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.id("overlay-content"))));
		
	}


	
	
	//Part Check box  select
	public boolean Part_Checked() throws Exception {

		boolean IsPartChecked=driver.findElement(By.xpath("//input[@data-ng-model='item.hasMultiPart']")).isSelected();
		if(!IsPartChecked) {
		driver.findElement(By.xpath("//input[@data-ng-model='item.hasMultiPart']")).click();
		Thread.sleep(500);
		
		}
		return true;
	}



	public  void Add_PartButton() {
		
		
		boolean iSCompositeItemChecked =driver.findElement(By.xpath("//input[@data-ng-model='model.itemCode.isComposite']")).isSelected();
	
	if( iSCompositeItemChecked) {

		List<WebElement> CompositeAddPartList  =driver.findElements(By.xpath("//div[contains(@data-ng-class,' : !model.itemCode.isComposite')]"));
	
		driver.findElement(By.xpath("(//div[contains(@data-ng-class,' : !model.itemCode.isComposite')])["+CompositeAddPartList.size()+"]//a[@title='Add another part']")).click();
		
	}else {
		List<WebElement> OptionDiv = driver.findElements(By.xpath("//div[@ng-repeat='optionObj in item.bICOptionList']"));
		int OptionDiveSize =OptionDiv.size();
		
		List<WebElement> AddPartList= driver.findElements(By.xpath("(//div[@ng-repeat='optionObj in item.bICOptionList'])[" + OptionDiv.size()+ "]//a[@title='Add another part']"));
		int AddPartSize =AddPartList.size();
		driver.findElement(By.xpath("((//div[@ng-repeat='optionObj in item.bICOptionList'])[" + OptionDiv.size()+ "]//a[@title='Add another part'])["+AddPartList.size()+"]")).click();
		
	}

	
}

	// Save
	public  void SaveButton() {
		driver.findElement(By.xpath("//button[@class='btn btn-save btn-success']")).click();
	}
	//Reset
	public  void ResetButton() {
		driver.findElement(By.xpath("//button[@class='btn btn-reset btn-danger']")).click();
	}
	//Refresh
	public  void RefreshButton() {
		driver.findElement(By.xpath("//button[@class='btn btn-refresh btn-danger ng-scope']")).click();
	}


}

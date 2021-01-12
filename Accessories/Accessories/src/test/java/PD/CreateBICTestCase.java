package PD;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestNGMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.LAB_OWLabTestResultEntry;
import pages.Menu;
import pages.PD_CreateBIC;
import utility.BaseClass;
import utility.ExcelDataProvider;

public class CreateBICTestCase extends BaseClass {

	Menu menu = PageFactory.initElements(driver, Menu.class);
	// PD_CreateBIC createBIC = PageFactory.initElements(driver,
	// PD_CreateBIC.class);
	PD_CreateBIC createBIC = new PD_CreateBIC();

	SoftAssert softAssert = new SoftAssert();

	int addOption = 1;
	int addPart = 1;
	int partNo=1;
	int lastPartNo=1;

	@BeforeTest
	public void NavigateToCreateBICMenu() throws InterruptedException {
		wait = new WebDriverWait(driver, 10);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		menu.Accessory();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		menu.PD();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		menu.BIC();
		menu.CreateBIC();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));

	}

	@Test(priority = 0, dataProvider = "bicEntry", enabled = true)
	public void TC_BIC_BasicInfo(String buyer, String brand, String customer, String bic, String gc, String ipnm,
			String nomi, String non_nomi, String descrip, String hps, String ncolor, String artwork) throws Exception {
		//logger = report.createTest("BIC basic info entry");

		// Buyer dropdown [Parameter: Buyer, div number]
		if (!buyer.isEmpty()) {
			boolean Isselected = createBIC.SelectDropdown(buyer, 1);

			softAssert.assertTrue(Isselected, "Dropdown value not selected");
		}

		// Brand dropdown [Parameter: brand, div number]
		if (!brand.isEmpty()) {
			boolean Isselected = createBIC.SelectDropdown(brand, 2);

			softAssert.assertTrue(Isselected, "Dropdown value not selected");
		}

		// Customer dropdown [Parameter: customer, div number]
		if (!customer.isEmpty()) {
			boolean Isselected = createBIC.SelectDropdown(customer, 3);

			softAssert.assertTrue(Isselected, "Dropdown value not selected");
		}

		// Select BIC ----
		if (!bic.isEmpty()) {
			createBIC.BuyerItemCode(bic);
		}

		// Check Mark "Generated code"
		if (gc.equalsIgnoreCase("Yes")) {
			createBIC.Generatedcode(gc);
		}
		softAssert.assertTrue(createBIC.AssertBIC_GenCode(), " Buyer Item Code and Auto Generate code is empty");

		// Check Is Product No Mandatory
		if (ipnm.equalsIgnoreCase("Yes")) {
			boolean isselected = createBIC.IsProductNoMandatory(ipnm);

			softAssert.assertTrue(isselected, "Is Product No Mandatory not selected");
		}

		// Check Mark "Nominated"
		if (nomi.equalsIgnoreCase("Yes")) {
			boolean isselected = createBIC.Nominated(nomi);
			softAssert.assertTrue(isselected, "Nominated not selected");
		}

		// Check Mark "Non Nominated"
		if (non_nomi.equalsIgnoreCase("Yes")) {
			boolean isselected = createBIC.NonNominated(non_nomi);
			softAssert.assertTrue(isselected, "Non Nominated not selected");
		}

		// Enter Description
		boolean isselected = createBIC.Description(descrip);
		softAssert.assertTrue(isselected, "Description field is empaty");

		// Enter No Of Color
		boolean isselected1 = createBIC.NoOfColor(ncolor);
		softAssert.assertTrue(isselected1, "Description field is empaty");

		// Upload Image using Attach/View Artwork
		if (!artwork.isEmpty()) {
			createBIC.AttachViewArtwork(artwork);
		} else {
			softAssert.fail("ArtWork attach path is empty.");
		}

		// softAssert.assertAll();

	}

	@Test(priority = 1, dataProvider = "bicEntry", enabled = true)
	public void TC_Basic_Item__Selection(String Itm, String Typ, String Cat, String SubCat, String RNNo, String Option,
			String OptionName, String ColorOpton, String GroundColor, String GroundColorCode, String TextColor,
			String TextColorCode, String Thickness, String BackingMic, String WarpColor, String Diameter, String GSM,
			String Design, String Folding, String Slit, String Cutting, String PeelType, String EdgeFinish,
			String Composition, String Specialty, String Certification, String D_UOM, String Length, String Width,
			String LAF, String WAF, String S_UOM, String Price) throws Exception {

		boolean isselected;
		if (Itm != "" && Typ != "") {
			// ------------Start "Item Detail Entry "----------------------
			// ----- Select Itm
			isselected = createBIC.itm(Itm);
			softAssert.assertTrue(isselected, "Item not selected");

			// ----- Select Typ
			isselected = createBIC.typ(Typ);
			softAssert.assertTrue(isselected, "type not selected");
			// ------ Select Cat
			if (!Cat.isEmpty()) {
				isselected = createBIC.cat(Cat);
				softAssert.assertTrue(isselected, "Category not selected");
			}
			// ------- Select SubCat
			/*
			 * if(!SubCat.isEmpty()) { isselected=createBIC.SubCat(SubCat);
			 * softAssert.assertTrue(isselected, "Sub Category not selected"); }
			 */
			// ------RNno
			if (!RNNo.isEmpty()) {
				createBIC.RNno(RNNo);
			}

		}

		if (Option != "" || ColorOpton != "") {

			if (addOption > 1) {

				// Add Option Button
				createBIC.Add_OptionButton();
				
			}

			addOption++;

			// ----- Enter Option

			createBIC.Option(Option);

			// ----- Enter Option Name
			createBIC.Option_Name(OptionName);

			// ----- Enter Color Option
			createBIC.Color_Option(ColorOpton);

			// -----Grid Input(Ground Color to Warp Color)
			createBIC.GridEntry(GroundColor, GroundColorCode, TextColor, TextColorCode, Thickness, BackingMic,
					WarpColor, Diameter, GSM, Design, Folding, Slit, Cutting, PeelType, EdgeFinish, Composition,
					Specialty, Certification);

			// -----Grid Input(D/UOM to Price)
			createBIC.partGridList(D_UOM, Length, Width, LAF, WAF, S_UOM, Price,partNo);

			// ------------End "Item Detail Entry "----------------------
		}
		
	}

	@Test(priority = 2, dataProvider = "bicEntry", enabled = false)
	public void TC_Part_Item__Selection(String Itm, String Typ, String Cat, String SubCat, String RNNo, String Option,
			String OptionName, String ColorOpton, String GroundColor, String GroundColorCode, String TextColor,
			String TextColorCode, String Thickness, String BackingMic, String WarpColor, String Diameter, String GSM,
			String Design, String Folding, String Slit, String Cutting, String PeelType, String EdgeFinish,
			String Composition, String Specialty, String Certification, String D_UOM, String Length, String Width,
			String LAF, String WAF, String S_UOM, String Price) throws Exception {

		// Checked Part
		boolean PartStatus=createBIC.Part_Checked();
		if(PartStatus) {
			if(partNo<=1) {
				partNo++;
				lastPartNo++;
			}
		}

		boolean isselected;
		if (Itm != "" && Typ != "") {

			// ------------Start "Item Detail Entry "----------------------
			// ----- Select Itm
			isselected = createBIC.itm(Itm);
			softAssert.assertTrue(isselected, "Item not selected");

			// ----- Select Typ
			isselected = createBIC.typ(Typ);
			softAssert.assertTrue(isselected, "type not selected");
			// ------ Select Cat
			if (!Cat.isEmpty()) {
				isselected = createBIC.cat(Cat);
				softAssert.assertTrue(isselected, "Category not selected");
			}
			// ------- Select SubCat
			/*
			 * if(!SubCat.isEmpty()) { isselected=createBIC.SubCat(SubCat);
			 * softAssert.assertTrue(isselected, "Sub Category not selected"); }
			 */
			// ------RNno
			if (!RNNo.isEmpty()) {
				createBIC.RNno(RNNo);
			}

		}

		if (Option != "" || ColorOpton != "") {

			if (addOption > 1) {

				// Add Option Button
				createBIC.Add_OptionButton();
				
				partNo=(lastPartNo/2)+1;
			}

			addOption++;

			// Enter Option

			createBIC.Option(Option);

			// Enter Option Name
			createBIC.Option_Name(OptionName);

			// Enter Color Option
			createBIC.Color_Option(ColorOpton);
		}
		if (Itm.equals("") && Typ.equals("") && Option.equals("") && ColorOpton.equals("")) {
			addPart++;
			if (addPart > 1) {
				// Add Part Button
				if(partNo>=lastPartNo) {
				createBIC.Add_PartButton();
				partNo+=2;
				lastPartNo+=2;
				}else {
					partNo+=1;
				}
				
			}

			createBIC.partGridList(D_UOM, Length, Width, LAF, WAF, S_UOM, Price,partNo);

		} else {

			// -----Grid Input(Ground Color to Warp Color)
			createBIC.GridEntry(GroundColor, GroundColorCode, TextColor, TextColorCode, Thickness, BackingMic,
					WarpColor, Diameter, GSM, Design, Folding, Slit, Cutting, PeelType, EdgeFinish, Composition,
					Specialty, Certification);

			// -----Grid Input(D/UOM to Price)
			createBIC.partGridList(D_UOM, Length, Width, LAF, WAF, S_UOM, Price,partNo);

			// ------------End "Item Detail Entry "----------------------
		}

	}

	
	
	
	@Test(priority=3,enabled=true)
	public void TC_Save_Reset() {

		  // Save
		  createBIC.SaveButton(); 
		  //Reset
		  createBIC.ResetButton();
		  //Refresh
		 createBIC.RefreshButton();
		  
		 

	

		
	}
	
	@DataProvider(name = "bicEntry")
	public Object[][] getData(ITestNGMethod testCase) throws Exception {
		Object data[][] = null;
		String excelPath = projectPath + "\\Excel_Data\\BIC_Information.xlsx";

		if (testCase.getMethodName().equals("TC_BIC_BasicInfo")) {
			data = ExcelDataProvider.getDataFromExcel(excelPath, "BICinfo");
		} else if (testCase.getMethodName().equals("TC_Basic_Item__Selection")) {

			data = ExcelDataProvider.getDataFromExcel(excelPath, "BasicItemSelection");
		} else if (testCase.getMethodName().equals("TC_Part_Item__Selection")) {
			data = ExcelDataProvider.getDataFromExcel(excelPath, "PartItemSelection");
		} else if (testCase.getMethodName().equals("TC_5_Composite_Item__Selection")) {
			data = ExcelDataProvider.getDataFromExcel(excelPath, "CompositeItemSelection");
		}
		return data;

	}

}

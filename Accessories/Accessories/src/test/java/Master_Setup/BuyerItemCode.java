package Master_Setup;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Configuration.Configure_Browser;
import Configuration.ERP_LogIn;
import utility.ExcelDataProvider;
//Class is used to Create  Buyer Item Code with parts, Options
public class BuyerItemCode {

	
	String projectPath = System.getProperty("user.dir");
	String excelPath =projectPath+"\\Excel_Data\\CreateBIC.xlsx";                 
	String sheetName = "CreateBIC";

	public WebDriverWait wait;
	public WebDriver driver;	
	public String baseUrl;
	public String browser;
	public String lg_userName;
	public String lg_passwprd;


	BuyerItemCode() throws  Exception{
		
		Properties prop = new Properties();
		FileInputStream input = new FileInputStream(projectPath+"/src/Master_Setup/Configration.properties");
		prop.load(input);
		browser= prop.getProperty("browser");
		baseUrl = prop.getProperty("baseUrl");
		lg_userName = prop.getProperty("userName");
		lg_passwprd = prop.getProperty("passwprd");

		Configure_Browser Conf_browser= new Configure_Browser();
		driver = Conf_browser.config(browser);
	}
	
	
	@BeforeTest ()
	public void NavigateToBuyerItemCode() throws InterruptedException{
		wait = new WebDriverWait(driver, 10);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		
		ERP_LogIn login = new ERP_LogIn();
		login.LogIn_Test_Env(driver, baseUrl, lg_userName, lg_passwprd);
		
		//nevigate to BIC
		WebElement accessoris = driver.findElement(By.cssSelector("#niMenu li:nth-child(1)  > a"));
		accessoris.click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		WebElement  ipd = driver.findElement(By.id("100000843"));
		ipd.click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		WebElement BuyerItemCode =driver.findElement(By.id("100000717"));
		BuyerItemCode.click();
		WebElement CreateBic= driver.findElement(By.cssSelector("#dropdown-menu100000717 > li:nth-child(1) > a"));
		CreateBic.click();
		Thread.sleep(1000);

	}
	
	@Test(dataProvider="bicdetails")
	public void CreateBuyerItemCode( String Buyer,String Brand,String BIC,String Description, String Artwork,String part,String item, String itemtype,String cat, String subcat, String rn, String grndclr, String grndclrcd, String txtclr, String txtclrcd, String thnk, String dia, String gsm, String dsn, String duom, String suom, String prc, String option ) throws InterruptedException{
		wait = new WebDriverWait(driver, 10);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS) ;
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		
		
		driver.findElement(By.cssSelector("div.panel-body > div > div:nth-child(1) > div:nth-child(1) > div > div > a")).click();
		WebElement selectBuyer= driver.findElement(By.cssSelector("div.panel-body > div > div:nth-child(1) > div:nth-child(1) > div > div > div >div> input"));
		selectBuyer.sendKeys(Buyer);
		driver.findElement(By.cssSelector(".ui-select-choices-row-inner >div:nth-child(1)")).click();

		
		driver.findElement(By.cssSelector("div > div.panel-body > div > div:nth-child(2) > div:nth-child(1) > div > div > a")).click();
		WebElement selectBrand= driver.findElement(By.cssSelector("div.panel-body > div > div:nth-child(2) > div:nth-child(1) > div > div > div > div > input"));
		selectBrand.sendKeys(Brand);
		driver.findElement(By.cssSelector(".ui-select-choices-row-inner > div:nth-child(1)")).click();
		
		WebElement bicName= driver.findElement(By.cssSelector(" div:nth-child(2) > div.form-group.m-b-none > div:nth-child(2) > input"));
		bicName.sendKeys(BIC);
		WebElement desc = driver.findElement(By.cssSelector("div:nth-child(3) > div:nth-child(1) > div > textarea"));
		desc.sendKeys(Description);
		
		
		
		//upload image
		driver.findElement(By.cssSelector("div:nth-child(4) > div.form-group.m-b-none > div > button")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("form > div:nth-child(1) > div > span > span >input")).sendKeys(Artwork);
		driver.findElement(By.cssSelector("form > div.btn-group.pull-right > button.btn.btn-info")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("form > div.btn-group.pull-right > button.btn.btn-danger")).click();
		
		
		//Insert Item Details 
		itemDetailsEntry(item,itemtype,cat,subcat,rn,grndclr,grndclrcd,txtclr,txtclrcd,thnk,dia,gsm,dsn);
		
		
		//Add Parts
		if(part.equals("")|| part.equals("0")){
			priceEntry(duom, suom, prc);
		}
		else {
		
			WebElement Part= driver.findElement(By.cssSelector("div > div:nth-child(1) > div:nth-child(1) > label > i.fa.fa-square-o.m-l-none"));
			Part.click();
			Thread.sleep(1000);
			partEntry(part,duom, suom, prc);
		}
		
		//add Option
		if (!option.equals("")&& !option.equals("0")){
			optionEntry(option);
			}
		
		
	    //Save BIC
		WebElement save=driver.findElement(By.cssSelector("button.btn.btn-success.ng-binding"));
		save.click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		Thread.sleep(3000);
		
		WebElement AddNew= driver.findElement(By.cssSelector("form > div:nth-child(4) > div > div > div > div > button:nth-child(1)"));
		AddNew.click();
	}
	
	
	public void itemDetailsEntry(String item,String itemtype,String cat,String subcat,String rn,String grndclr,String grndclrcd,String txtclr,String txtclrcd,String thk,String dia,String gsm,String dsn) throws InterruptedException{
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		
		Select Item= new Select(driver.findElement(By.cssSelector(" div:nth-child(1) > div > div > div.ni-table-row-group > div > div:nth-child(1) > div > select")));
		Item.selectByVisibleText(item);
		Select Itemtyp= new Select(driver.findElement(By.cssSelector(" div:nth-child(1) > div > div > div.ni-table-row-group > div > div:nth-child(2) > div > select")));
		Itemtyp.selectByVisibleText(itemtype);
		
		//optional
		if(cat !=null){
		Select itemCat= new Select(driver.findElement(By.cssSelector(" div:nth-child(1) > div > div > div.ni-table-row-group > div > div:nth-child(3) > div > select")));
		itemCat.selectByVisibleText(cat);
		}
		
		if(subcat !=null){
		Select itemSubCat= new Select(driver.findElement(By.cssSelector(" div:nth-child(1) > div > div > div.ni-table-row-group > div > div:nth-child(4) > div > select")));
		itemSubCat.selectByVisibleText(subcat);
		}
		
		//optional
		if(rn !=null){
		WebElement RNno= driver.findElement(By.cssSelector("div:nth-child(1) > div > div > div.ni-table-row-group > div > div:nth-child(5) > input"));
		RNno.sendKeys(rn);
		}
		
		
		WebElement GrdClr= driver.findElement(By.cssSelector("div:nth-child(2) > div > div > div > div.ni-table-row-group > div > div:nth-child(1) > div > div > div:nth-child(1) > div > input"));
		GrdClr.sendKeys(grndclr);
		
		
		if(grndclrcd !=null){
			WebElement grdclrcode= driver.findElement(By.cssSelector("div:nth-child(2) > div > div > div > div.ni-table-row-group > div > div:nth-child(1) > div > div > div:nth-child(2) > div > input"));
			grdclrcode.sendKeys(grndclrcd);
		}
		
		if(txtclr !=null){
			WebElement textclr= driver.findElement(By.cssSelector("div:nth-child(2) > div > div > div > div.ni-table-row-group > div > div:nth-child(1) > div > div > div:nth-child(3) > div > input"));
			textclr.sendKeys(txtclr);
		}
		
		if(txtclrcd !=null){
			WebElement textclrcd= driver.findElement(By.cssSelector("div:nth-child(2) > div > div > div > div.ni-table-row-group > div > div:nth-child(1) > div > div > div:nth-child(4) > div > input"));
			textclrcd.sendKeys(txtclrcd);
		}
		if(thk !=null){
			WebElement Thk= driver.findElement(By.cssSelector("div:nth-child(2) > div > div > div > div.ni-table-row-group > div > div:nth-child(1) > div > div > div:nth-child(5) > div > input"));
			Thk.sendKeys(thk);
		}
		
		if(dia !=null){
			Select Dia= new Select(driver.findElement(By.cssSelector("div:nth-child(2) > div > div > div > div.ni-table-row-group > div > div:nth-child(1) > div > div > div:nth-child(6) > div >div > select")));
			Dia.selectByVisibleText(dia);
			}
		
		if(gsm !=null){
			Select GSM= new Select(driver.findElement(By.cssSelector(" div:nth-child(2) > div > div > div > div.ni-table-row-group > div > div:nth-child(1) > div > div > div:nth-child(7) > div >div > select")));
			GSM.selectByVisibleText(gsm);
			}
		if(dsn !=null){
			Select DSN= new Select(driver.findElement(By.cssSelector(" div:nth-child(2) > div > div > div > div.ni-table-row-group > div > div:nth-child(1) > div > div > div:nth-child(8) > div >div > select")));
			DSN.selectByVisibleText(dsn);
			}
		

	}
	
	
	//To Insert DUOM,SUOM and Price 
	public void priceEntry(String duom, String suom, String prc){
		Select DUOM= new Select(driver.findElement(By.cssSelector("div:nth-child(2) > div > div > div > div.ni-table-row-group > div > div:nth-child(2) > div > div > div:nth-child(1) > div > select")));
		DUOM.selectByVisibleText(duom);
		Select SUOM= new Select(driver.findElement(By.cssSelector("div:nth-child(2) > div > div > div > div.ni-table-row-group > div > div:nth-child(2) > div > div > div:nth-child(6) > div > select")));
		SUOM.selectByVisibleText(suom);

		if (!prc.equals("")) {
			WebElement Prc = driver.findElement(By.cssSelector("div:nth-child(2) > div > div > div > div.ni-table-row-group > div > div:nth-child(2) > div > div > div:nth-child(7) > input"));
			Prc.clear();
			Prc.sendKeys(prc);
			}
	}
	
	
	
	//To add Parts with BIC
	public void partEntry(String part, String duom, String suom, String prc){
		int Part= Integer.parseInt(part);
		for (int i=1; i<= Part;i++)
			
		{
			Select DUOM= new Select(driver.findElement(By.xpath("//div/div[3]/div[1]/div/div[2]/div/div/div[2]/div["+i+"]/div[2]/div/select")));
			DUOM.selectByVisibleText(duom);
			
			Select SUOM= new Select(driver.findElement(By.xpath("//div/div[3]/div[1]/div/div[2]/div/div/div[2]/div["+i+"]/div[7]/div/select")));
			SUOM.selectByVisibleText(suom);
			
			
			if (!prc.equals("")) {
				WebElement Prc = driver.findElement(By.xpath("//div/div[3]/div[1]/div/div[2]/div/div/div[2]/div["+i+"]/div[8]/input"));
				Prc.clear();
				Prc.sendKeys(prc);
				}
			
			
			if(i<Part){
			WebElement AddPart = driver.findElement(By.xpath("//div/div[3]/div[1]/div/div[2]/div/div/div[2]/div["+i+"]/div[9]//ul/li[2]/a/i"));
			AddPart.click();
				}
		}
	}
	
	
	//To add Option by Option No
	public void optionEntry(String option){
		
		int opt= Integer.parseInt(option);
		for (int i=1; i<= opt;i++){
		WebElement OptNo=driver.findElement(By.xpath("//div[2]/div/div/div/div["+i+"]/div/div[1]/div/div[1]/div[1]/div/div/input"));
		OptNo.sendKeys(String.valueOf(i));
		
		if(i<opt){
		WebElement Addoption = driver.findElement(By.xpath("//div[2]/div/div/div/div["+i+"]/div/div[2]/div/button[1]"));
		Addoption.click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay-background")));
		}
		
		}
		
	}
	
	
	@AfterTest
	public void CloseBrowser(){
		driver.quit();
	}
	
	@DataProvider(name="bicdetails")
	public Object[][] getData() throws Exception{
		Object data[][]= ExcelDataProvider.getDataFromExcel(excelPath, sheetName);
		return data;
	}
	
		
}

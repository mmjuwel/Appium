package roughPack;

import org.testng.annotations.Test;

import utility.ExcelDataWriter;



public class Rough {
  @Test
  public void f() {
	  ExcelDataWriter reader = new ExcelDataWriter(System.getProperty("user.dir")+"\\Excel_Data\\OrderVerification.xlsx");
		String sheetName = "OrderVerify";
		
		//write cell value
		reader.setCellData(sheetName,"OrderNo*",4,"555");
		
		// count total row
		int rowCount = reader.getRowCount(sheetName);
		System.out.println("total rows: " + rowCount);
	  
	  
	  
  }
}

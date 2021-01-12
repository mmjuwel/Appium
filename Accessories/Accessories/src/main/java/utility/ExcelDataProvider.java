package utility;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelDataProvider {

	private  static XSSFWorkbook worjbook;
	private  static XSSFSheet sheet;

	public static void excelUtil(String excelpath, String sheetName) throws Exception {
		worjbook = new XSSFWorkbook(excelpath);
		sheet = worjbook.getSheet(sheetName);
	}

	public static int rowCount() {
		int totalRow;
		totalRow = sheet.getPhysicalNumberOfRows();
		// System.out.println("Total Row="+totalRow);
		return totalRow;
	}

	public static int colCount() {
		int totalCol = sheet.getRow(0).getPhysicalNumberOfCells();
		// System.out.println("Total col="+totalCol);
		return totalCol;

	}

	// Get Both String and Integer to Value of Excel
	public static String getCellValue(int rowNum, int colNum) throws Exception {
		DataFormatter formatter = new DataFormatter();
		String cellValue = formatter.formatCellValue(sheet.getRow(rowNum).getCell(colNum));
		return cellValue;
	}

	// get data cell wise
	public static Object[][] getDataFromExcel(String excelPath, String sheetName) {

		try {
			excelUtil(excelPath, sheetName);
		} catch (Exception e) {
			System.out.println("Unable to load Excel Or Sheet " + e.getMessage());
		}
		int rowCount = rowCount();
		int colCount = colCount();
		Object data[][] = new Object[rowCount - 1][colCount];
		for (int i = 1; i < rowCount; i++) {
			for (int j = 0; j < colCount; j++) {
				String cellValue = null;
				try {
					cellValue = getCellValue(i, j);
				} catch (Exception e) {
					System.out.println("Unable to get Data From Excell Cell " + e.getMessage());
				}
				// System.out.print(cellValue+ " | ");
				data[i - 1][j] = cellValue;
			}
			// System.out.println("//");
		}
		return data;
	}

	

}

import { browser, element, by, ExpectedConditions, protractor} from 'protractor'
import { Alert, WebElement } from 'selenium-webdriver';
import {Workbook, Row, Cell} from 'exceljs';
describe('Protractor Typescript Demo', function() {
	browser.ignoreSynchronization = true; // for non-angular websites
	it('Excel File Operations', function() {
		// set implicit time to 30 seconds
		browser.manage().timeouts().implicitlyWait(30000);
		// create object for workbook
		var wb = new Workbook();
		// read xlsx file type
		wb.xlsx.readFile("D:\Code\Test Automation\Protractor\Protractor_Framwork\excelFiles\bankData.xlsx").then(function(){
			//sheet object
			let sheet = wb.getWorksheet("Sheet1");
			//row objct
			let rowObject = sheet.getRow(3);
			// cell object
			let cellObject = rowObject.getCell(2);
			//print
			console.log(cellObject.value);
			//use the cell value as url for navigation
			browser.get(cellObject.toString())
		});
	});
});
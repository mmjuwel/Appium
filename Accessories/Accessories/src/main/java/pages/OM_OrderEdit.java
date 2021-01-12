package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class OM_OrderEdit extends OM_OrderCreate{

	
	@FindBy(how=How.CSS, using= "li[data-ng-hide='data.isAlreadyVerified'] .fa")
	WebElement editButton;
	
	
	
	//delete order
	@FindBy(how=How.CSS, using= ".fa-trash-o")
	WebElement deleteButton;
	@FindBy(how=How.CSS, using= "#btnOk")
	WebElement acceptDeleteConf;
	@FindBy(how=How.CSS, using= "#btnClose")
	WebElement denyDeleteConf;
	
	public void ClickOnEditButton() {
		editButton.click();
	}
	
	public void DeleteOrder() {
		deleteButton.click();
		acceptDeleteConf.click();
		denyDeleteConf.click();
	}
	
}

package Config;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LogInPage {

	@FindBy(how = How.ID, using = "userName")
	private WebElement userName;
	@FindBy(how = How.ID, using = "password")
	private WebElement password;
	@FindBy(how = How.ID, using = "btnLogIn")
	private WebElement LogInButton;

	public void InserUserName(String username) {
		userName.clear();
		userName.sendKeys(username);
	}

	public void InserPassword(String pass) {
		password.clear();
		password.sendKeys(pass);
	}

	public void PressLoginButton() {
		LogInButton.click();
	}
}

package pageObject.Nopcommerce.Admin;

import org.openqa.selenium.WebDriver;

import common.AbstractPage;
import common.PageManagerObject;
import pageUI.Nopcommerce.Admin.LoginAdminPageUI;

public class LoginPageObjectAdmin extends AbstractPage {
	WebDriver driver;
	public LoginPageObjectAdmin(WebDriver driver) {
		this.driver=driver;
	}
	public void inputToEmail(String email) {
		waitForElementVisible(driver, LoginAdminPageUI.EMAIL_TEXTBOX);
		senkeyToElement(driver, LoginAdminPageUI.EMAIL_TEXTBOX, email);
	}
	public void inputToPassword(String password) {
		waitForElementVisible(driver, LoginAdminPageUI.PASSWORD_TEXTBOX);
		senkeyToElement(driver, LoginAdminPageUI.PASSWORD_TEXTBOX, password);
	}
	public HomeAdminPageObject clickToLoginButton() {
		waitToElementClickable(driver, LoginAdminPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginAdminPageUI.LOGIN_BUTTON);
		return PageManagerObject.getHomeAdminPageObject(driver);
	}
	
}

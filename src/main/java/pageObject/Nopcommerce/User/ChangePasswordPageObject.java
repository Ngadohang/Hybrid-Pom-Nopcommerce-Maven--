package pageObject.Nopcommerce.User;

import org.openqa.selenium.WebDriver;

import common.AbstractPage;
import common.PageManagerObject;
import pageUI.Nopcommerce.User.AbstractPageUser;
import pageUI.Nopcommerce.User.ChangePasswordPageUI;

public class ChangePasswordPageObject extends AbstractPage{
	private WebDriver driver;
	public ChangePasswordPageObject(WebDriver driver) {
		this.driver=driver;
	}
	public void inputToTextBoxPassword(String valueInput, String value) {
		waitForElementVisible(driver, AbstractPageUser.DYNAMIC_TEXTBOX_BY_LABEL, value);
		senkeyToElement(driver, AbstractPageUser.DYNAMIC_TEXTBOX_BY_LABEL, valueInput, value);
	}
	public void clickToChangePasswordButton(String value) {
		waitToElementClickable(driver, AbstractPageUser.DYNAMIC_BUTTON, value);
		clickToElement(driver, AbstractPageUser.DYNAMIC_BUTTON, value);
	}
	public boolean isSuccessMessageDisplay() {
		return isElementDisplay(driver, ChangePasswordPageUI.MESSAGE_CHANGE_PASSWORD_SUCCESS);
	}
	public HomePageObject clickToLogoutLink(String value) {
		waitToElementClickable(driver, AbstractPageUser.DYNAMIC_LINK,value);
		clickToElement(driver, AbstractPageUser.DYNAMIC_LINK, value);
		return PageManagerObject.getHomePageObject(driver);
	}

}

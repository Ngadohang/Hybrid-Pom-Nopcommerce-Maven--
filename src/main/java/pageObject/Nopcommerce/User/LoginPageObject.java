package pageObject.Nopcommerce.User;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;

import common.AbstractPage;
import common.PageManagerObject;
import pageUI.Nopcommerce.User.AbstractPageUser;
import pageUI.Nopcommerce.User.LoginPageUI;

public class LoginPageObject extends AbstractPage {
	private WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToLoginTextBox(String valueInput, String value) {
		waitForElementVisible(driver, AbstractPageUser.DYNAMIC_TEXTBOX, value);
		senkeyToElement(driver, AbstractPageUser.DYNAMIC_TEXTBOX, valueInput, value);
	}
	public void inputToLoginTextBoxByLabel(String valueInput, String value) {
		waitForElementVisible(driver, AbstractPageUser.DYNAMIC_TEXTBOX_BY_LABEL, value);
		senkeyToElement(driver, AbstractPageUser.DYNAMIC_TEXTBOX_BY_LABEL, valueInput, value);
	}

	public void clickToLoginCheckBox(String value) {
		waitToElementClickable(driver, AbstractPageUser.DYNAMIC_TEXTBOX, value);
		clickToElement(driver, AbstractPageUser.DYNAMIC_TEXTBOX, value);
	}

	public void clickToLoginButton(String value) {
		waitToElementClickable(driver, AbstractPageUser.DYNAMIC_BUTTON, value);
		try {
			clickToElement(driver, AbstractPageUser.DYNAMIC_BUTTON, value);
		} catch (UnhandledAlertException f) {
		    try {
		        Alert alert = driver.switchTo().alert();
		        String alertText = alert.getText();
		        System.out.println("Alert data: " + alertText);
		        alert.accept();
		    } catch (NoAlertPresentException e) {
		        e.printStackTrace();
		    }
		}
	}

	public boolean isEmailErrorMessageDisplay(String value) {
		return isElementDisplay(driver, LoginPageUI.EMAIL_ERROR_MESSAGE, value);
	}

	public boolean isErrorMessageDisplay(String value) {
		return isElementDisplay(driver, LoginPageUI.ERROR_MESSAGE, value);
	}

	public boolean isLoginSucessDisplay(String value) {
		return isElementDisplay(driver, AbstractPageUser.DYNAMIC_LINK, value);
	}

	public boolean isLoginTitlePageDisplay() {
		return isElementDisplay(driver, LoginPageUI.LOGIN_PAGE_TITLE);
	}

	public void clickToLoginLink(String value) {
		waitForElementVisible(driver, AbstractPageUser.DYNAMIC_LINK, value);
		clickToElement(driver, AbstractPageUser.DYNAMIC_LINK, value);
	}

}

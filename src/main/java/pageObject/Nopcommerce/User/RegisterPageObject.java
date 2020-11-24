package pageObject.Nopcommerce.User;

import org.openqa.selenium.WebDriver;

import common.AbstractPage;
import common.PageManagerObject;
import pageUI.Nopcommerce.User.RegisterPageUI;

public class RegisterPageObject extends AbstractPage {
	private WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToRegisterButton() {
		scrollToElement(driver, RegisterPageUI.REGISTER_BUTTON);
		waitToElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);

	}

	public boolean isFirstNameTextErrorDisplay() {
		scrollToElement(driver, RegisterPageUI.FIRST_NAME_ERROR);
		waitForElementVisible(driver, RegisterPageUI.FIRST_NAME_ERROR);
		return isElementDisplay(driver, RegisterPageUI.FIRST_NAME_ERROR);
	}

	public boolean isLastNameTextErrorDisplay() {
		waitForElementVisible(driver, RegisterPageUI.LAST_NAME_ERROR);
		return isElementDisplay(driver, RegisterPageUI.LAST_NAME_ERROR);
	}

	public boolean isEmailTextErrorDisplay() {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_ERROR);
		return isElementDisplay(driver, RegisterPageUI.EMAIL_ERROR);
	}

	public boolean isPasswordTextErrorDisplay() {
		scrollToElement(driver, RegisterPageUI.PASS_WORD_ERROR);
		waitForElementVisible(driver, RegisterPageUI.PASS_WORD_ERROR);
		return isElementDisplay(driver, RegisterPageUI.PASS_WORD_ERROR);
	}

	public boolean isConfirmTextErrorDisplay() {
		waitForElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_ERROR);
		return isElementDisplay(driver, RegisterPageUI.CONFIRM_PASSWORD_ERROR);
	}

	public boolean isEmailValidTextDisplay() {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_WRONG);
		return isElementDisplay(driver, RegisterPageUI.EMAIL_WRONG);
	}

	public void isRefreshPage() {
		refreshCurrentPage(driver);
	}

	public void inputToEmailTextBox(String value) {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
		senkeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, value);
	}

	public boolean isEmailExistTextDisplay() {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_EXIST);
		return isElementDisplay(driver, RegisterPageUI.EMAIL_EXIST);
	}

	public boolean isPasswordErrorDisplay() {
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_INVAILD);
		return isElementDisplay(driver, RegisterPageUI.PASSWORD_INVAILD);
	}

	public boolean isPasswordNotMatchDisplay() {
		waitForElementVisible(driver, RegisterPageUI.CONFIRMATION_NOT_MATCH);
		return isElementDisplay(driver, RegisterPageUI.CONFIRMATION_NOT_MATCH);
	}

	public void inputToPasswordTextBox(String value) {
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_TEXTBOX);
		senkeyToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, value);

	}
	public void inputToConfirmationPasswordTextBox(String value) {
		waitForElementVisible(driver, RegisterPageUI.CONFIRMATION_PASSWORD_TEXTBOX);
		senkeyToElement(driver, RegisterPageUI.CONFIRMATION_PASSWORD_TEXTBOX, value);
	}

	public String clickToRadioCheckboxGender(String value) {
		waitToElementClickable(driver, RegisterPageUI.DYNAMIC_GENDER_CHECKBOX,value );
		clickToElement(driver, RegisterPageUI.DYNAMIC_GENDER_CHECKBOX,value);
		return value;
	}

	public String inputToFirstNameTextBox(String value) {
		waitForElementVisible(driver, RegisterPageUI.FIRST_NAME_TEXTBOX);
		senkeyToElement(driver, RegisterPageUI.FIRST_NAME_TEXTBOX, value);
		return value;
	}

	public String inputToLastNameTextBox(String value) {
		waitForElementVisible(driver, RegisterPageUI.LAST_NAME_TEXTBOX);
		senkeyToElement(driver, RegisterPageUI.LAST_NAME_TEXTBOX, value);
		return value;
	}

	public String selectToDayofBirth(String value) {
		waitForElementVisible(driver, RegisterPageUI.DAY_SELECTION);
		selectItemInDropdownDefault(driver, RegisterPageUI.DAY_SELECTION, value);
		return value;
	}

	public String selectToMonthofBirth(String value) {
		waitForElementVisible(driver, RegisterPageUI.MONTH_SELECTION);
		selectItemInDropdownDefault(driver, RegisterPageUI.MONTH_SELECTION, value);
		return value;
	}

	public String selectToYearofBirth(String value) {
		waitForElementVisible(driver, RegisterPageUI.YEAR_SELECTION);
		selectItemInDropdownDefault(driver, RegisterPageUI.YEAR_SELECTION, value);
		return value;
	}

	public String inputToCompanyTextBox(String value) {
		waitForElementVisible(driver, RegisterPageUI.COMPANY_TEXTBOX);
		senkeyToElement(driver, RegisterPageUI.COMPANY_TEXTBOX, value);
		return value;
	}

	public void clickToNewsLetter() {
		waitToElementClickable(driver, RegisterPageUI.NEWSLETTER_CHECKBOX);
		clickToElement(driver,  RegisterPageUI.NEWSLETTER_CHECKBOX);
	}


	public boolean isRegisterSuccessMessage() {
		waitForElementVisible(driver, RegisterPageUI.REGISTER_SUCCESS_MESSAGER);
		return isElementDisplay(driver, RegisterPageUI.REGISTER_SUCCESS_MESSAGER);
	}

	public boolean isMyAccountLinkDisplay() {
		waitForElementVisible(driver, RegisterPageUI.MY_ACCOUNT_LINK);
		return isElementDisplay(driver, RegisterPageUI.MY_ACCOUNT_LINK);
	}

	public boolean isLogoutLinkDisplay() {
		waitForElementVisible(driver, RegisterPageUI.LOG_OUT_LINK);
		return isElementDisplay(driver, RegisterPageUI.LOG_OUT_LINK);
	}

	public HomePageObject clicktoLogoutButton() {
		waitToElementClickable(driver, RegisterPageUI.LOG_OUT_LINK);
		clickToElement(driver, RegisterPageUI.LOG_OUT_LINK);
		return PageManagerObject.getHomePageObject(driver);
		
	}

	public void waitLoadPage() {
		reloadPageByJs();
	}

}

package pageObject.Nopcommerce.Admin;

import org.openqa.selenium.WebDriver;

import common.AbstractPage;
import common.PageManagerObject;
import pageObject.Nopcommerce.User.CustomerAdminPageObject;
import pageUI.Nopcommerce.Admin.EditCustomerAdminPageUI;
import pageUI.Nopcommerce.Admin.NewCustomerAdminPageUI;

public class NewCustomerAdminPageObject extends AbstractPage {
	WebDriver driver;

	public NewCustomerAdminPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String inputToEmailTextBox(String email) {
		waitForElementVisible(driver, NewCustomerAdminPageUI.EMAIL_TEXTBOX);
		senkeyToElement(driver, NewCustomerAdminPageUI.EMAIL_TEXTBOX, email);
		return email;
	}

	public void inputToPasswordTextBox(String password) {
		waitForElementVisible(driver, NewCustomerAdminPageUI.PASSWORD_TEXTBOX);
		senkeyToElement(driver, NewCustomerAdminPageUI.PASSWORD_TEXTBOX, password);
	}

	public String inputToFirstNameTextBox(String firstName) {
		waitForElementVisible(driver, NewCustomerAdminPageUI.FIRST_NAME_TEXTBOX);
		senkeyToElement(driver, NewCustomerAdminPageUI.FIRST_NAME_TEXTBOX, firstName);
		return firstName;
	}

	public String inputToLastNameTextBox(String lastName) {
		waitForElementVisible(driver, NewCustomerAdminPageUI.LAST_NAME_TEXTBOX);
		senkeyToElement(driver, NewCustomerAdminPageUI.LAST_NAME_TEXTBOX, lastName);
		return lastName;
	}

	public void clickToGenderCheckBox(String value) {
		waitToElementClickable(driver, NewCustomerAdminPageUI.DYNAMIC_GENDER_RADIO, value);
		clickToElement(driver, NewCustomerAdminPageUI.DYNAMIC_GENDER_RADIO, value);
	}

	public String inputToDateTimeTextBox(String value) {
		waitForElementVisible(driver, NewCustomerAdminPageUI.DATE_OF_BIRTH);
		senkeyToElement(driver, NewCustomerAdminPageUI.DATE_OF_BIRTH, value);
		return value;
	}

	public String inputToCompanyTextBox(String companyName) {
		waitForElementVisible(driver, NewCustomerAdminPageUI.COMPANY_TEXTBOX);
		senkeyToElement(driver, NewCustomerAdminPageUI.COMPANY_TEXTBOX, companyName);
		return companyName;
	}

	public void clickToIsTaxExemptCheckBox() {
		waitToElementClickable(driver, NewCustomerAdminPageUI.IS_TAX_EXEMPT);
		clickToElement(driver, NewCustomerAdminPageUI.IS_TAX_EXEMPT);

	}

	public String selectToManagerOfVendorDropdown(String valueItem) {
		waitForElementVisible(driver, NewCustomerAdminPageUI.VENDOR_SELECT);
		selectItemInDropdownDefault(driver, NewCustomerAdminPageUI.VENDOR_SELECT, valueItem);
		return valueItem;
	}

	public String inputToCommentTextArea(String value) {
		waitForElementVisible(driver, NewCustomerAdminPageUI.ADMIN_COMMENT_TEXTAREA);
		senkeyToElement(driver, NewCustomerAdminPageUI.ADMIN_COMMENT_TEXTAREA, value);
		return value;
	}

	public void clickToSaveEditButton() {
		waitToElementClickable(driver, NewCustomerAdminPageUI.SAVE_CONTINUE_BUTTON);
		clickToElement(driver, NewCustomerAdminPageUI.SAVE_CONTINUE_BUTTON);
	}

	public boolean isAddNewCustomerSuccess() {
		return isElementDisplay(driver, NewCustomerAdminPageUI.NEW_CUSTOMER_SUCCESS_MESSAGE);
	}

	public CustomerAdminPageObject clickToBackToCustomerList() {
		waitToElementClickable(driver, NewCustomerAdminPageUI.BACK_TO_CUSTOMER);
		clickToElement(driver, NewCustomerAdminPageUI.BACK_TO_CUSTOMER);
		return PageManagerObject.getCustomerAdminPageObject(driver);
	}

	public boolean isTitlePageDispayed() {
		return isElementDisplay(driver, NewCustomerAdminPageUI.ADDRESS_TITLE);
	}

	public void selectToNewsLetterDropdown(String value) {
		waitForElementVisible(driver, NewCustomerAdminPageUI.NEWSLETTER_DROPDOWN_PARENT_XPATH);
		selectMutilItemCustomDropdown(driver, NewCustomerAdminPageUI.NEWSLETTER_DROPDOWN_PARENT_XPATH, NewCustomerAdminPageUI.NEWSLETTER_DROPDOWN_CHILD_XPATH, value);
		
	}

	public void selectToCustomerRoleDropdown(String value) {
		waitForElementVisible(driver, NewCustomerAdminPageUI.CUSTOMER_ROLE_DROPDOWN_PARENT_XPATH);
		selectMutilItemCustomDropdown(driver, NewCustomerAdminPageUI.CUSTOMER_ROLE_DROPDOWN_PARENT_XPATH, NewCustomerAdminPageUI.CUSTOMER_ROLE_DROPDOWN_CHILD_XPATH, value);
	}
	
	public void closeTagCustomerRoleDefaulDropdown() {
		waitToElementClickable(driver, NewCustomerAdminPageUI.CUSTOMER_ROLE_CLOSE, "Registered");
		clickToElement(driver,NewCustomerAdminPageUI.CUSTOMER_ROLE_CLOSE, "Registered");
	}
}

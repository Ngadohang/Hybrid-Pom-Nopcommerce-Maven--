package pageObject.Nopcommerce.Admin;

import org.openqa.selenium.WebDriver;

import common.AbstractPage;
import common.PageManagerObject;
import pageObject.Nopcommerce.User.CustomerAdminPageObject;
import pageUI.Nopcommerce.Admin.EditAdressAdminPageUI;
import pageUI.Nopcommerce.Admin.EditCustomerAdminPageUI;
import pageUI.Nopcommerce.Admin.ProductPageUI;

public class EditCustomerAdminPageObject extends AbstractPage {
	private WebDriver driver;

	public EditCustomerAdminPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isTitlePageDispayed() {
		return isElementDisplay(driver, EditCustomerAdminPageUI.ADDRESS_LAYOUT);
	}

	public String inputToEmailTextBox(String email) {
		waitForElementVisible(driver, EditCustomerAdminPageUI.EMAIL_TEXTBOX);
		senkeyToElement(driver, EditCustomerAdminPageUI.EMAIL_TEXTBOX, email);
		return email;
	}

	public String inputToFirstNameTextBox(String firstName) {
		waitForElementVisible(driver, EditCustomerAdminPageUI.FIRST_NAME_TEXTBOX);
		senkeyToElement(driver, EditCustomerAdminPageUI.FIRST_NAME_TEXTBOX, firstName);
		return firstName;
	}

	public String inputToLastNameTextBox(String lastName) {
		waitForElementVisible(driver, EditCustomerAdminPageUI.LAST_NAME_TEXTBOX);
		senkeyToElement(driver, EditCustomerAdminPageUI.LAST_NAME_TEXTBOX, lastName);
		return lastName;
	}

	public String inputToDateTimeTextBox(String datetime) {
		waitForElementVisible(driver, EditCustomerAdminPageUI.DATE_OF_BIRTH);
		senkeyToElement(driver, EditCustomerAdminPageUI.DATE_OF_BIRTH, datetime);
		return datetime;
	}

	public String inputToCompanyTextBox(String companyName) {
		waitForElementVisible(driver, EditCustomerAdminPageUI.COMPANY_TEXTBOX);
		senkeyToElement(driver, EditCustomerAdminPageUI.COMPANY_TEXTBOX, companyName);
		return companyName;
	}

	public String inputToCommentTextArea(String content) {
		waitForElementVisible(driver, EditCustomerAdminPageUI.ADMIN_COMMENT_TEXTAREA);
		senkeyToElement(driver, EditCustomerAdminPageUI.ADMIN_COMMENT_TEXTAREA, content);
		return content;
	}

	public CustomerAdminPageObject clickToSaveEditButton() {
		waitToElementClickable(driver, EditCustomerAdminPageUI.SAVE_BUTTON);
		clickToElement(driver, EditCustomerAdminPageUI.SAVE_BUTTON);
		return PageManagerObject.getCustomerAdminPageObject(driver);
	}

	public NewAddressAdminPageObject clickToAddAddressButton() {
		waitToElementClickable(driver, EditCustomerAdminPageUI.ADD_NEW_ADDRESS);
		clickToElement(driver, EditCustomerAdminPageUI.ADD_NEW_ADDRESS);
		return PageManagerObject.getNewAddressAdminPageObject(driver);
	}

	public boolean isAddressInfoDisplay(String... value) {
		return isElementDisplay(driver, EditCustomerAdminPageUI.ADDRESS_INFO_ROW, value);
	}

	public EditAddressAdminPageObject clickToEditAddress(String... value) {
		waitToElementClickable(driver, EditCustomerAdminPageUI.EDIT_ADDRESS_BUTTON,value);
		clickToElement(driver, EditCustomerAdminPageUI.EDIT_ADDRESS_BUTTON, value);
		return PageManagerObject.getEditAddressAdminPageObject(driver);
	}

	public void clickToDeleteAddress(String... value) {
		waitToElementClickable(driver, EditCustomerAdminPageUI.DELETE_ADDRESS_BUTTON,value);
		clickToElement(driver, EditCustomerAdminPageUI.DELETE_ADDRESS_BUTTON, value);
	}

	public boolean isNoDataInTabel() {
		return isElementDisplay(driver, EditCustomerAdminPageUI.NO_DATA_ADDRESS);
	}

	public void inputToPasswordTextBox(String password) {
		waitForElementVisible(driver, EditCustomerAdminPageUI.PASSWORD_TEXTBOX);
		senkeyToElement(driver, EditCustomerAdminPageUI.PASSWORD_TEXTBOX, password);
	}

	public boolean isTitleEditCustomerDispay(String... value) {
		return isElementDisplay(driver, EditCustomerAdminPageUI.TITLE_PAGE, value);
	}

	public void clickToAddressLayout() {
		waitToElementClickable(driver, EditCustomerAdminPageUI.ADDRESS_LAYOUT);
		clickToElement(driver, EditCustomerAdminPageUI.ADDRESS_LAYOUT);
	}

	public boolean isInforAddressDisplayed(String[] infoAddress, String... value) {
		boolean status = false;
		String inforAddFull = getTextElement(driver, EditCustomerAdminPageUI.ADDRESS_DATA_CELL, value);
		for (String Info : infoAddress) {
			if (inforAddFull.contains(Info)) {
				status = true;
			} else {
				status = false;
				break;
			}
		}
		return status;
	}

	public void acceptAlertToDeleteItem() {
		acceptAlert(driver);
	}

}

package pageObject.Nopcommerce.User;

import org.openqa.selenium.WebDriver;


import common.AbstractPage;
import common.PageManagerObject;
import pageObject.Nopcommerce.Admin.EditCustomerAdminPageObject;
import pageObject.Nopcommerce.Admin.NewCustomerAdminPageObject;
import pageUI.Nopcommerce.Admin.CustomerAdminPageUI;
import pageUI.Nopcommerce.Admin.NewCustomerAdminPageUI;

public class CustomerAdminPageObject extends AbstractPage {
	WebDriver driver;
	public CustomerAdminPageObject(WebDriver driver) {
		this.driver=driver;
	}

	public NewCustomerAdminPageObject clickToAddNewCustomer() {
		waitToElementClickable(driver,CustomerAdminPageUI.ADD_NEW_CUSTOMER_BUTTON);
		clickToElement(driver, CustomerAdminPageUI.ADD_NEW_CUSTOMER_BUTTON);
		return PageManagerObject.getNewCustomerAdminPageObject(driver);
	}

	public void clickToSearchButton() {
		waitToElementClickable(driver,CustomerAdminPageUI.SEARCH_BUTTON);
		clickToElement(driver, CustomerAdminPageUI.SEARCH_BUTTON);
	}

	public void selectToCustomerRoleDropdown(String value) {
		waitForElementVisible(driver, CustomerAdminPageUI.CUSTOMER_ROLE_DROPDOWN);
		selectMutilItemCustomDropdown(driver,  CustomerAdminPageUI.CUSTOMER_ROLE_DROPDOWN, CustomerAdminPageUI.DYNAMIC_DROPDOWN_CHILD_XPATH, value);
	}

	public void inputToEmailTextBox(String email) {
		waitForElementVisible(driver, CustomerAdminPageUI.EMAIL_TEXTBOX);
		senkeyToElement(driver, CustomerAdminPageUI.EMAIL_TEXTBOX, email);
	}

	public boolean isNewCustomerDisplay(String...value) {
		return isElementDisplay(driver, CustomerAdminPageUI.DATA_CUSTOMER_ROW,value);
	}

	public boolean isNewCustomerUniqueDisplay(String...value) {
		return isElementDisplay(driver, CustomerAdminPageUI.DATA_CUSTOMER_ROW,value);
	}

	public void inputToFistNameTextBox(String firstName) {
		waitForElementVisible(driver, CustomerAdminPageUI.FIRST_NAME_TEXBOX);
		senkeyToElement(driver, CustomerAdminPageUI.FIRST_NAME_TEXBOX, firstName);
	}

	public void inputToLastNameTextBox(String lastName) {
		waitForElementVisible(driver, CustomerAdminPageUI.LAST_NAME_TEXBOX);
		senkeyToElement(driver, CustomerAdminPageUI.LAST_NAME_TEXBOX, lastName);
	}

	public void inputToCompanyTextBox(String company) {
		waitForElementVisible(driver, CustomerAdminPageUI.COMPANY_TEXBOX);
		senkeyToElement(driver, CustomerAdminPageUI.COMPANY_TEXBOX, company);	
	}

	public void selectToMonth(String valueItem) {
		waitForElementVisible(driver, CustomerAdminPageUI.MONTH_SELECT);
		selectItemInDropdownDefault(driver,  CustomerAdminPageUI.MONTH_SELECT, valueItem);
	}

	public void selectToDay(String valueItem) {
		waitForElementVisible(driver, CustomerAdminPageUI.DAY_SELECT);
		selectItemInDropdownDefault(driver,  CustomerAdminPageUI.DAY_SELECT, valueItem);
	}

	
	public boolean isTitleEditCustomerDispay() {
		return isElementDisplay(driver, CustomerAdminPageUI.CUSTOMER_PAGE_TITLE);
	}


	public EditCustomerAdminPageObject clickToEditByName(String...value) {
		waitToElementClickable(driver, CustomerAdminPageUI.EDIT_BUTTON_ON_ROW,value);
		clickToElement(driver, CustomerAdminPageUI.EDIT_BUTTON_ON_ROW,value);
		return PageManagerObject.getEditCustomerAdminPageObject(driver);
	}

	public boolean isUpdateCustomerSuccess() {
		return isElementDisplay(driver, CustomerAdminPageUI.UPDATE_SUCCESS_MESSAGE);
	}

	public void closeTagCustomerRoleDefaulDropdown() {
		waitToElementClickable(driver, NewCustomerAdminPageUI.CUSTOMER_ROLE_CLOSE, "Registered");
		clickToElement(driver,NewCustomerAdminPageUI.CUSTOMER_ROLE_CLOSE, "Registered");
	}


	

}

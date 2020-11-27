package pageObject.Nopcommerce.Admin;

import org.openqa.selenium.WebDriver;

import common.AbstractPage;
import common.PageManagerObject;
import pageUI.Nopcommerce.Admin.NewAddressAdminPageUI;

public class NewAddressAdminPageObject extends AbstractPage {
	private WebDriver driver;
	public NewAddressAdminPageObject(WebDriver driver) {
			this.driver=driver;
	}

	public boolean isTileNewAddressDisplay() {
		return isElementDisplay(driver, NewAddressAdminPageUI.NEW_ADDRESS_TITLE);
	}

	public String inputToFistName(String firstName) {
		waitForElementVisible(driver, NewAddressAdminPageUI.FIRST_NAME_TEXTBOX);
		senkeyToElement(driver, NewAddressAdminPageUI.FIRST_NAME_TEXTBOX, firstName);
		return firstName;
	}

	public String inputToLastName(String lastName) {
		waitForElementVisible(driver, NewAddressAdminPageUI.LAST_NAME_TEXTBOX);
		senkeyToElement(driver,  NewAddressAdminPageUI.LAST_NAME_TEXTBOX, lastName);
		return lastName;
	}

	public String inputToEmail(String email) {
		waitForElementVisible(driver, NewAddressAdminPageUI.EMAIL_TEXTBOX);
		senkeyToElement(driver,  NewAddressAdminPageUI.EMAIL_TEXTBOX, email);
		return email;
	}

	public String inputToCompany(String companyName) {
		waitForElementVisible(driver, NewAddressAdminPageUI.COMPANY_TEXTBOX);
		senkeyToElement(driver,  NewAddressAdminPageUI.COMPANY_TEXTBOX, companyName);
		return companyName;
	}

	public String selectToCountry(String country) {
		waitForElementVisible(driver, NewAddressAdminPageUI.COUNTRY_SELECT);
		selectItemInDropdownDefault(driver, NewAddressAdminPageUI.COUNTRY_SELECT, country);
		return country;
	}

	public String selectToState(String state) {
		waitForElementVisible(driver, NewAddressAdminPageUI.STATE_SELECT);
		selectItemInDropdownDefault(driver, NewAddressAdminPageUI.STATE_SELECT, state);
		return state;
	}

	public String inputToCity(String city) {
		waitForElementVisible(driver, NewAddressAdminPageUI.CITY_TEXTBOX);
		senkeyToElement(driver,  NewAddressAdminPageUI.CITY_TEXTBOX, city);
		return city;
	}

	public String inputToAddress1(String address) {
		waitForElementVisible(driver, NewAddressAdminPageUI.ADDRESS1_TEXTBOX);
		senkeyToElement(driver,  NewAddressAdminPageUI.ADDRESS1_TEXTBOX, address);
		return address;
	}

	public String inputToZipCode(String zinCop) {
		waitForElementVisible(driver, NewAddressAdminPageUI.ZIPCODE_TEXTBOX);
		senkeyToElement(driver,  NewAddressAdminPageUI.ZIPCODE_TEXTBOX, zinCop);
		return zinCop;
	}

	public String inputToPhone(String phone) {
		waitForElementVisible(driver, NewAddressAdminPageUI.PHONE_TEXTBOX);
		senkeyToElement(driver,  NewAddressAdminPageUI.PHONE_TEXTBOX, phone);
		return phone;
	}

	public EditAddressAdminPageObject clickToSaveButton() {
		waitToElementClickable(driver, NewAddressAdminPageUI.SAVE_BUTTON);
		clickToElement(driver, NewAddressAdminPageUI.SAVE_BUTTON);
		return PageManagerObject.getEditAddressAdminPageObject(driver);
	}

	public String inputToAddress2(String address) {
		waitForElementVisible(driver, NewAddressAdminPageUI.ADDRESS2_TEXTBOX);
		senkeyToElement(driver,  NewAddressAdminPageUI.ADDRESS2_TEXTBOX, address);
		return address;
	}

	public String inputToFax(String fax) {
		waitForElementVisible(driver, NewAddressAdminPageUI.FAX_TEXTBOX);
		senkeyToElement(driver,  NewAddressAdminPageUI.FAX_TEXTBOX, fax);
		return fax;
	}

}

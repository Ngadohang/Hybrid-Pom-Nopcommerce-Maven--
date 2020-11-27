package pageObject.Nopcommerce.Admin;

import org.openqa.selenium.WebDriver;

import common.AbstractPage;
import common.PageManagerObject;
import pageUI.Nopcommerce.Admin.EditAdressAdminPageUI;
import pageUI.Nopcommerce.Admin.EditCustomerAdminPageUI;

public class EditAddressAdminPageObject extends AbstractPage {
	private WebDriver driver;

	public EditAddressAdminPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String inputToFistName(String firstName) {
		waitForElementVisible(driver, EditAdressAdminPageUI.FIRST_NAME_TEXTBOX,firstName);
		senkeyToElement(driver, EditAdressAdminPageUI.FIRST_NAME_TEXTBOX, firstName);
		return firstName;
	}

	public String inputToLastName(String lastName) {
		waitForElementVisible(driver, EditAdressAdminPageUI.LAST_NAME_TEXTBOX,lastName);
		senkeyToElement(driver, EditAdressAdminPageUI.LAST_NAME_TEXTBOX, lastName);
		return lastName;
	}

	public String inputToEmail(String email) {
		waitForElementVisible(driver, EditAdressAdminPageUI.EMAIL_TEXTBOX,email);
		senkeyToElement(driver, EditAdressAdminPageUI.EMAIL_TEXTBOX, email);
		return email;
	}

	public String inputToCompany(String companyName) {
		waitForElementVisible(driver, EditAdressAdminPageUI.COMPANY_TEXTBOX,companyName);
		senkeyToElement(driver, EditAdressAdminPageUI.COMPANY_TEXTBOX, companyName);
		return companyName;
	}

	public String selectToCountry(String country) {
		waitForElementVisible(driver, EditAdressAdminPageUI.COUNTRY_SELECT,country);
		selectItemInDropdownDefault(driver, EditAdressAdminPageUI.COUNTRY_SELECT, country);
		return country;
	}

	public String selectToState(String state) {
		waitForElementVisible(driver, EditAdressAdminPageUI.STATE_SELECT,state);
		selectItemInDropdownDefault(driver, EditAdressAdminPageUI.STATE_SELECT, state);
		return state;
	}
	
	public String inputToCity(String city) {
		waitForElementVisible(driver, EditAdressAdminPageUI.CITY_TEXTBOX,city);
		senkeyToElement(driver, EditAdressAdminPageUI.CITY_TEXTBOX, city);
		return city;
	}

	public String inputToAddress1(String address) {
		waitForElementVisible(driver, EditAdressAdminPageUI.ADDRESS1_TEXTBOX,address);
		senkeyToElement(driver, EditAdressAdminPageUI.ADDRESS1_TEXTBOX, address);
		return address;
	}
	public String inputToZipCode(String zinCop) {
		waitForElementVisible(driver, EditAdressAdminPageUI.ZIPCODE_TEXTBOX,zinCop);
		senkeyToElement(driver, EditAdressAdminPageUI.ZIPCODE_TEXTBOX, zinCop);
		return zinCop;
	}
	public String inputToPhone(String phone) {
		waitForElementVisible(driver, EditAdressAdminPageUI.PHONE_TEXTBOX,phone);
		senkeyToElement(driver, EditAdressAdminPageUI.PHONE_TEXTBOX, phone);
		return phone;
	}

	public void clickToSaveButton() {	
		waitToElementClickable(driver, EditAdressAdminPageUI.SAVE_BUTTON);
		clickToElement(driver,  EditAdressAdminPageUI.SAVE_BUTTON);
	}

	public EditCustomerAdminPageObject clickToBackToCustomerButton() {
		waitToElementClickable(driver, EditAdressAdminPageUI.BACK_TO_CUSTOMER);
		clickToElement(driver,  EditAdressAdminPageUI.BACK_TO_CUSTOMER);
		return PageManagerObject.getEditCustomerAdminPageObject(driver);
	}

	public String inputToAddress2(String address) {
		waitForElementVisible(driver, EditAdressAdminPageUI.ADDRESS2_TEXTBOX,address);
		senkeyToElement(driver, EditAdressAdminPageUI.ADDRESS2_TEXTBOX, address);
		return address;
	}

	public String inputToFax(String fax) {
		waitForElementVisible(driver, EditAdressAdminPageUI.FAX_TEXTBOX,fax);
		senkeyToElement(driver, EditAdressAdminPageUI.FAX_TEXTBOX, fax);
		return fax;
	}


}

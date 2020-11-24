package pageObject.Nopcommerce.User;

import org.openqa.selenium.WebDriver;

import common.AbstractPage;
import pageUI.Nopcommerce.User.MyAccountPageUI;

public class MyAccountPageObject extends AbstractPage{
	private WebDriver driver;
	public MyAccountPageObject(WebDriver driver) {
		this.driver=driver;
	}
	public boolean isGenderInfoDisplay(String value) {
		return isElementDisplay(driver, MyAccountPageUI.GENDER_INFO, value);
	}
	public String getFirstNameTextBox() {
		return getElementAttribute(driver, MyAccountPageUI.FIRST_NAME_INFO, "value");
	}
	
	public String getLastNameTextBox() {
		return getElementAttribute(driver, MyAccountPageUI.LAST_NAME_INFO, "value");
	}
	public String getSelectionOfMonth() {
		return getFirstSelectedTextInDropdownDefault(driver, MyAccountPageUI.BIRTH_MONTH_INFO);
	}
	public String getSelectionOfYear() {
		return getFirstSelectedTextInDropdownDefault(driver, MyAccountPageUI.BIRTH_YEAR_INFO);
	}
	public String getEmailTextBox() {
		return getElementAttribute(driver, MyAccountPageUI.EMAIL_INFO, "value");
	}
	public Object getCompanyTextBox() {
		return getElementAttribute(driver, MyAccountPageUI.COMPANY_INFO, "value");
	}
	public String getSelectionOfDay() {
		return getFirstSelectedTextInDropdownDefault(driver, MyAccountPageUI.BIRTH_DAY_INFO);
	}

}

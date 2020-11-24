package pageObject.Nopcommerce.User;

import org.openqa.selenium.WebDriver;

import common.AbstractPage;
import pageUI.Nopcommerce.User.AbstractPageUser;
import pageUI.Nopcommerce.User.AddressPageUI;

public class AddressPageObject extends AbstractPage {
	private WebDriver driver;

	public AddressPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToAddNewButton() {
		waitToElementClickable(driver, AddressPageUI.ADD_NEW_BUTTON);
		clickToElement(driver, AddressPageUI.ADD_NEW_BUTTON);
	}

	public boolean isTilePageDisplay() {
		return isElementDisplay(driver, AddressPageUI.ADD_NEW_ADDRESS_TITLE);
	}

	public String inputTextBoxAddress(String valueInput, String value) {
		waitForElementVisible(driver, AbstractPageUser.DYNAMIC_TEXTBOX_BY_LABEL, value);
		senkeyToElement(driver,AbstractPageUser.DYNAMIC_TEXTBOX_BY_LABEL, valueInput, value);
		return valueInput;
	}

	public String selectTextBoxAddress(String selection, String value) {
		waitForElementVisible(driver, AddressPageUI.DYNAMIC_SELECTION, value);
		selectItemInDropdownDefault(driver, AddressPageUI.DYNAMIC_SELECTION, selection, value);
		return selection;
	}

	public void clickSaveButton() {
		waitForElementVisible(driver, AddressPageUI.SAVE_BUTTON);
		clickToElement(driver, AddressPageUI.SAVE_BUTTON);
	}

	public boolean isInforDisplay(String value1, String value2) {
		return isElementDisplay(driver, AddressPageUI.DYNAMIC_INFO_BY_LABEL, value1, value2);
	}

	public boolean isInforDisplay(String value) {
		return isElementDisplay(driver, AddressPageUI.DYNAMIC_INFO, value);
	}

	public boolean isTitlePageDisplay() {
		return isElementDisplay(driver, AddressPageUI.ADDRESS_TITLE);
	}

	public boolean isAddressCustomerDisplay(String value) {
		return isElementDisplay(driver, AddressPageUI.CUSTOMER_TITLE, value);
	}

}

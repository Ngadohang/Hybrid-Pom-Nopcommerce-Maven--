package pageObject.Nopcommerce.User;

import org.openqa.selenium.WebDriver;

import common.AbstractPage;
import common.PageManagerObject;
import pageUI.Nopcommerce.User.ProductDetailPageUI;
import pageUI.Nopcommerce.User.UpdateCartPageUI;

public class UpdateCartPageObject extends AbstractPage {
	private WebDriver driver;

	public UpdateCartPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String setAttributeTypeSelect(String select, String value) {
		waitForElementVisible(driver, UpdateCartPageUI.PRODUCT_TYPE_SELECT, value);
		selectItemInDropdownDefault(driver, UpdateCartPageUI.PRODUCT_TYPE_SELECT, select, value);
		return getTextFirstSelectedTextInDropdownDefault(driver, ProductDetailPageUI.PRODUCT_TYPE_SELECT, value);
	}

	public String setAttributeTypeRadio(String... value) {
		waitToElementClickable(driver, UpdateCartPageUI.PRODUCT_TYPE_RADIO, value);
		checkToCheckBox(driver, UpdateCartPageUI.PRODUCT_TYPE_RADIO, value);
		return getTextElement(driver, UpdateCartPageUI.VALUE_RADIO, value);
	}

	public Double getPriceProduct() {
		sleepInMilisecond(1000);
		String value= getTextElement(driver, UpdateCartPageUI.PRODUCT_PRICE);
		value=value.replace("$", "");
		value=value.replace(",", "");
		return Double.valueOf(value);
	}

	public void clickToUpdateCartButton() {
		waitToElementClickable(driver, UpdateCartPageUI.UPDATE_CART_BUTTON);
		clickToElement(driver, UpdateCartPageUI.UPDATE_CART_BUTTON);
	}

	public CartPageObject clickToMoveCartPage() {
		waitToElementClickable(driver,UpdateCartPageUI.UPDATE_CART_LINK_SUCCESS_MESSAGE );
		clickToElement(driver, UpdateCartPageUI.UPDATE_CART_LINK_SUCCESS_MESSAGE);
		return PageManagerObject.getCartPageObject(driver);
	}

	public void uncheckAttributeTypeCheckbox(String... value) {
		sleepInMilisecond(000);
		waitForElementVisible(driver, UpdateCartPageUI.PRODUCT_TYPE_CHECKBOX, value);
		uncheckToCheckBox(driver, UpdateCartPageUI.PRODUCT_TYPE_CHECKBOX, value);
	}

}

package pageObject.Nopcommerce.User;

import org.openqa.selenium.WebDriver;

import common.AbstractPage;
import pageUI.Nopcommerce.User.ComparePageUI;

public class ComparePageObject extends AbstractPage {
	private WebDriver driver;
	public ComparePageObject(WebDriver driver) {
		this.driver=driver;
	}
	public boolean isProductDisplayedOnComparelist(String...value) {
		return isElementDisplay(driver, ComparePageUI.PRODUCT_INFO, value);
	}
	public String isImageProductDispayedOnComparelist(String...value) {
		return getElementAttribute(driver, ComparePageUI.IMAGE_PRODUCT, "src", value);
	}
	public void clickClearlistButton() {
		waitToElementClickable(driver, ComparePageUI.CLEAR_LIST_BUTTON);
		clickToElement(driver, ComparePageUI.CLEAR_LIST_BUTTON);
	}
	public boolean isComparelistEmpty() {
		return isElementDisplay(driver, ComparePageUI.COMPARE_LIST_EMPTY);
	}

}

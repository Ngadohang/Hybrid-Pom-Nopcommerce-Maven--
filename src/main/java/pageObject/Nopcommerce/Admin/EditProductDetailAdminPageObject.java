package pageObject.Nopcommerce.Admin;

import org.openqa.selenium.WebDriver;

import common.AbstractPage;
import pageObject.Nopcommerce.User.EditProductDetailAdminPageUI;

public class EditProductDetailAdminPageObject extends AbstractPage {
	WebDriver driver;
	public EditProductDetailAdminPageObject(WebDriver driver) {
		this.driver=driver;
	}
	public boolean isEditProductDetailTitleDisplay(String value) {
		return isElementDisplay(driver, EditProductDetailAdminPageUI.TITLE_PAGE,value);
	}
	public String getProductNameTextBox() {
		return getTextAttribute(driver, EditProductDetailAdminPageUI.PRODUCT_NAME_TEXTBOX, "value");
	}
	public void clickToProductInfoLayout() {
		waitToElementClickable(driver, EditProductDetailAdminPageUI.PRODUCT_INFO_LAYOUT);
		clickToElement(driver, EditProductDetailAdminPageUI.PRODUCT_INFO_LAYOUT);
	}

}

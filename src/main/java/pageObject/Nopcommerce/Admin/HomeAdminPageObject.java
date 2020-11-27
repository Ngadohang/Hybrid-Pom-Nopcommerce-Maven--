package pageObject.Nopcommerce.Admin;

import org.openqa.selenium.WebDriver;

import common.AbstractPage;
import pageUI.Nopcommerce.Admin.HomeAdminPageUI;

public class HomeAdminPageObject extends AbstractPage {
	private WebDriver driver;
	public HomeAdminPageObject(WebDriver driver) {
		this.driver=driver;
	}

	public void clickToSubMenu(String subcategory) {
		waitToElementClickable(driver, HomeAdminPageUI.DYNAMIC_SUBCATEGORY_LINK, subcategory);
		clickToElement(driver, HomeAdminPageUI.DYNAMIC_SUBCATEGORY_LINK, subcategory);
	}

	public void clickToMenu(String category) {
		waitToElementClickable(driver, HomeAdminPageUI.DYNAMIC_CATEGORY_LINK, category);
		clickToElement(driver, HomeAdminPageUI.DYNAMIC_CATEGORY_LINK, category);
		
	}

	public void clickToCustomerCatagory() {
		waitToElementClickable(driver, HomeAdminPageUI.CUSTOMER_CATEGORY_LINK);
		clickToElement(driver, HomeAdminPageUI.CUSTOMER_CATEGORY_LINK);
	}
}

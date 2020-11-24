package pageObject.Nopcommerce.User;

import org.openqa.selenium.WebDriver;

import common.AbstractPage;
import common.PageManagerObject;
import pageUI.Nopcommerce.User.AbstractPageUser;

public class HomePageObject extends AbstractPage {
	private WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public LoginPageObject clickToLoginLink(String value) {
		waitForElementVisible(driver, AbstractPageUser.DYNAMIC_LINK, value);
		clickToElement(driver, AbstractPageUser.DYNAMIC_LINK, value);
		return PageManagerObject.getLoginPageObject(driver);
	}

	public void moveToMenu(String value) {
		waitForElementVisible(driver, AbstractPageUser.DYNAMIC_LINK, value);
		hoverMouseToElement(driver, AbstractPageUser.DYNAMIC_LINK, value);
	}

	public void clickToProductCategory(String value) {
		waitForElementVisible(driver, AbstractPageUser.DYNAMIC_LINK, value);
		clickToElement(driver, AbstractPageUser.DYNAMIC_LINK, value);
	}

	public boolean isCategoryTitleDisplay(String value) {
		return isElementDisplay(driver, AbstractPageUser.DYNAMIC_LINK, value);
	}

	public void clickToProductTile(String value) {
		waitForElementVisible(driver,AbstractPageUser.DYNAMIC_LINK , value);
	}

	public boolean isProductTitleDisplay() {
		// TODO Auto-generated method stub
		return false;
	}

	public void clickToAddYourReview() {
		// TODO Auto-generated method stub
		
	}

	public SearchPageObject clickToSearchLink(String value) {
		waitToElementClickable(driver, AbstractPageUser.DYNAMIC_LINK, value);
		clickToElement(driver, AbstractPageUser.DYNAMIC_LINK, value);
		return PageManagerObject.getSearchPageObject(driver);
	}

	public ProductListPageObject clickToSubMenu(String value) {
		waitToElementClickable(driver, AbstractPageUser.DYNAMIC_LINK, value);
		clickToElement(driver, AbstractPageUser.DYNAMIC_LINK, value);
		return PageManagerObject.getProductListPageObject(driver);
	}

	
}

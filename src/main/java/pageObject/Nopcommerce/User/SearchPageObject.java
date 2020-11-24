package pageObject.Nopcommerce.User;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import common.AbstractPage;
import common.PageManagerObject;
import pageUI.Nopcommerce.User.AbstractPageUser;
import pageUI.Nopcommerce.User.ProductDetailPageUI;
import pageUI.Nopcommerce.User.SearchPageUI;
import pageUI.Nopcommerce.User.UpdateCartPageUI;

public class SearchPageObject extends AbstractPage {
	private WebDriver driver;

	public SearchPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToSearchTextBox(String valueInput, String value) {
		waitForElementVisible(driver, AbstractPageUser.DYNAMIC_TEXTBOX_BY_LABEL, value);
		senkeyToElement(driver, AbstractPageUser.DYNAMIC_TEXTBOX_BY_LABEL, valueInput, value);
	}

	public void clickToSearchButton() {
		waitToElementClickable(driver, SearchPageUI.SEARCH_BUTTON);
		clickToElement(driver, SearchPageUI.SEARCH_BUTTON);
		scrollToElement(driver, SearchPageUI.RESULT_SEARCH);
	}

	public boolean isTitleSearchDisplay(String value) {
		return isElementDisplay(driver, AbstractPageUser.DYNAMIC_TITLE, value);
	}

	public boolean isMessageErrorDisplay(String value) {
		return isElementDisplay(driver, AbstractPageUser.DYNAMIC_ERROR_MESSAGE, value);
	}

	public boolean isProductDisplay(String... value) {
		return isElementDisplay(driver, AbstractPageUser.DYNAMIC_PRODUCT, value);
	}

	public boolean areImageProductsLoaded(String nameProduct) {
		boolean status = false;
		int namSize = nameProduct.length();
		List<WebElement> imageProducts = findElementsByXpath(driver, SearchPageUI.LIST_IMAGE_PRODUCT_SEARCH);
		int imageSize = imageProducts.size();
		int i = 0;
		for (WebElement image : imageProducts) {
			i++;
			if (image != null) {
				if (isImageLoaded(driver, image)) {
					status = true;
				} else {
					status = false;
				}
			} else {
				status = false;
			}
			if (i == imageSize) {
				break;
			}
		}
		return status;
	}

	public boolean isTitleProductsDisplay(String nameProduct) {
		boolean status = false;
		List<WebElement> titleProducts = findElementsByXpath(driver, SearchPageUI.TITLE_PRODUCT);
		int titleSize = titleProducts.size();
		int i = 0;
		for (WebElement title : titleProducts) {
			i++;
			if (title != null) {
				if (title.getText().toLowerCase().contains(nameProduct.toLowerCase())) {
					status = true;
				} else {
					status = false;
				}
				if (i == titleSize) {
					break;
				}
			}
		}
		return status;
	}

	public void clickToAbvancedCheckbox() {
		waitToElementClickable(driver, SearchPageUI.ADVANCED_CHECKBOX);
		if (!isElementSelected(driver, SearchPageUI.ADVANCED_CHECKBOX)) {
			clickToElement(driver, SearchPageUI.ADVANCED_CHECKBOX);
		}
	}

	public void selectToCategory(String value) {
		waitForElementVisible(driver, SearchPageUI.CATEGORIES_SELECT);
		selectItemInDropdownDefault(driver, SearchPageUI.CATEGORIES_SELECT, value);
	}

	public void clickToAutoCheckBox() {
		waitToElementClickable(driver, SearchPageUI.AUTO_CHECKBOX);
		if (!isElementSelected(driver, SearchPageUI.AUTO_CHECKBOX)) {
			clickToElement(driver, SearchPageUI.AUTO_CHECKBOX);
		}
	}

	public void selectToManufacturer(String value) {
		waitForElementVisible(driver, SearchPageUI.MANU_SELECT);
		selectItemInDropdownDefault(driver, SearchPageUI.MANU_SELECT, value);
	}

	public void inputToPriceFromTexBox(String value) {
		waitForElementVisible(driver, SearchPageUI.PRICE_FROM_TEXTBOX);
		senkeyToElement(driver, SearchPageUI.PRICE_FROM_TEXTBOX, value);
	}

	public void inputToPriceToTextBox(String value) {
		waitForElementVisible(driver, SearchPageUI.PRICE_TO_TEXTBOX);
		senkeyToElement(driver, SearchPageUI.PRICE_TO_TEXTBOX, value);
	}

	public CartPageObject clickToShoppingCartLink() {
		waitToElementClickable(driver, SearchPageUI.SHOPPING_CART_LINK_MESSAGE);
		clickToElement(driver, SearchPageUI.SHOPPING_CART_LINK_MESSAGE);
		return PageManagerObject.getCartPageObject(driver);
	}

	public ProductDetailPageObject clickToAddToCartButton(String value) {
		waitToElementClickable(driver, SearchPageUI.ADD_TO_CART_BY_NAME_PRODUCT, value);
		clickToElement(driver, SearchPageUI.ADD_TO_CART_BY_NAME_PRODUCT, value);
		return PageManagerObject.getProductDetailPageObject(driver);
	}

	public Double getPriceProduct(String namePro) {
		String value = getTextElement(driver, SearchPageUI.PRICE_BY_NAME_PRODUCT, namePro);
		value = value.replace("$", "");
		value = value.replace(",", "");
		return Double.valueOf(value);
	}

}

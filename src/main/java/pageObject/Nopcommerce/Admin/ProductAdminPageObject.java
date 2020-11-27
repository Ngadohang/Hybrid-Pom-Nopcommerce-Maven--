package pageObject.Nopcommerce.Admin;

import org.openqa.selenium.WebDriver;

import common.AbstractPage;
import common.PageManagerObject;
import pageUI.Nopcommerce.Admin.ProductPageUI;

public class ProductAdminPageObject extends AbstractPage {
	private WebDriver driver;

	public ProductAdminPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToProductName(String namePro) {
		waitForElementVisible(driver, ProductPageUI.SEARCH_PRODUCT_NAME_TEXTBOX);
		senkeyToElement(driver, ProductPageUI.SEARCH_PRODUCT_NAME_TEXTBOX, namePro);
	}

	public void clickToSearchButton() {
		waitToElementClickable(driver, ProductPageUI.SEARCH_BUTTON);
		clickToElement(driver, ProductPageUI.SEARCH_BUTTON);
	}

	public boolean isProductInfoDislayed(String...values) {
		return isElementDisplay(driver, ProductPageUI.INFO_PRODUCT, values);
	}

	public boolean isUncheckedSearchSubCategory() {
		return isElementSelected(driver, ProductPageUI.SUBCATEGORY_CHECKBOX);
	}

	public boolean isNoDateMessageDisplayed() {
		return isElementDisplay(driver, ProductPageUI.NO_DATA_IN_TABLE_MESSAGE);
	}

	public void selectToCategory(String valueItem) {
		waitForElementVisible(driver, ProductPageUI.CATEGORY_SELECT);
		selectItemInDropdownDefault(driver, ProductPageUI.CATEGORY_SELECT, valueItem);
	}

	public void clickToSearchSubCategoriesCheckbox() {
		waitToElementClickable(driver, ProductPageUI.SUBCATEGORY_CHECKBOX);
		clickToElement(driver, ProductPageUI.SUBCATEGORY_CHECKBOX);
	}

	public void selectToManufacturer(String valueItem) {
		waitForElementVisible(driver, ProductPageUI.MANUFACTURER_SELECT);
		selectItemInDropdownDefault(driver, ProductPageUI.MANUFACTURER_SELECT, valueItem);
	}

	public void inputToProductSku(String value) {
		waitForElementVisible(driver, ProductPageUI.GO_TO_SKU_TEXTBOX);
		senkeyToElement(driver, ProductPageUI.GO_TO_SKU_TEXTBOX, value);
	}

	public EditProductDetailAdminPageObject clickToGoToProductSku() {
		waitToElementClickable(driver, ProductPageUI.GO_TO_SKU_BUTTON);
		clickToElement(driver, ProductPageUI.GO_TO_SKU_BUTTON);
		return PageManagerObject.getEditProductDetailAdminPageObject(driver);
	}

	public void clickToSubCategoriesCheckboxed() {
		waitToElementClickable(driver, ProductPageUI.SUBCATEGORY_CHECKBOX);
		uncheckToCheckBox(driver, ProductPageUI.SUBCATEGORY_CHECKBOX);
	}

}

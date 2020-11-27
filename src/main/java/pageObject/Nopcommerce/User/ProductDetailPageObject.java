package pageObject.Nopcommerce.User;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import common.AbstractPage;
import common.PageManagerObject;
import pageUI.Nopcommerce.User.AbstractPageUser;
import pageUI.Nopcommerce.User.CartPageUI;
import pageUI.Nopcommerce.User.ProductDetailPageUI;
import pageUI.Nopcommerce.User.ProductListPageUI;

public class ProductDetailPageObject extends AbstractPage {
	private WebDriver driver;

	public ProductDetailPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isBreadCrumbDisplay(String... value) {
		return isElementDisplay(driver, AbstractPageUser.DYNAMIC_BREADCRUMB_PRODUCT_DETAIL, value);
	}

	public void clickToWishlistButton() {
		waitToElementClickable(driver, ProductDetailPageUI.ADD_WISH_LIST_BUTTON);
		clickToElement(driver, ProductDetailPageUI.ADD_WISH_LIST_BUTTON);
	}

	public boolean isWishlistSuccessMessageDisplay() {
		return isElementDisplay(driver, ProductDetailPageUI.GO_WISH_LIST_LINK);
	}

	public WishListPageObject clickToWishListLink() {
		waitToElementClickable(driver, ProductDetailPageUI.GO_WISH_LIST_LINK);
		clickToElement(driver, ProductDetailPageUI.GO_WISH_LIST_LINK);
		return PageManagerObject.getWishListPageObject(driver);
	}

	public String getSkuInfo() {
		return getTextElement(driver, ProductDetailPageUI.SKU_INFO);
	}

	public String getProductName() {
		return getTextElement(driver, ProductDetailPageUI.PRODUCT_NAME);
	}

	public String setAttributeTypeSelect(String select, String value) {
		waitForElementVisible(driver, ProductDetailPageUI.PRODUCT_TYPE_SELECT, value);
		selectItemInDropdownDefault(driver, ProductDetailPageUI.PRODUCT_TYPE_SELECT, select, value);
		return getTextFirstSelectedTextInDropdownDefault(driver, ProductDetailPageUI.PRODUCT_TYPE_SELECT, value);
	}

	public String setAttributeTypeRadio(String... value) {
		waitToElementClickable(driver, ProductDetailPageUI.PRODUCT_TYPE_RADIO, value);
		checkToCheckBox(driver, ProductDetailPageUI.PRODUCT_TYPE_RADIO, value);
		return getTextElement(driver, ProductDetailPageUI.VALUE_RADIO, value);
	}

	public String setAttributeTypeCheckbox(String nameAttribute, String valueCheckbox) {
		waitForElementVisible(driver, ProductDetailPageUI.PRODUCT_TYPE_CHECKBOX, nameAttribute, valueCheckbox);
		checkToCheckBox(driver, ProductDetailPageUI.PRODUCT_TYPE_CHECKBOX, nameAttribute, valueCheckbox);
		return valueCheckbox;
	}

	public WishListPageObject clickToWishlistLinkOnMenu() {
		waitToElementClickable(driver, ProductDetailPageUI.WISH_LIST_LINK);
		clickToElement(driver, ProductDetailPageUI.WISH_LIST_LINK);
		return PageManagerObject.getWishListPageObject(driver);
	}

	public String getImageProduct() {
		waitForElementVisible(driver, ProductDetailPageUI.IMAGE_PRODUCT);
		String imageSrc = getElementAttribute(driver, ProductDetailPageUI.IMAGE_PRODUCT, "src");
		String[] listSrc = imageSrc.split("_");
		String imageSrcNew = listSrc[0];
		return imageSrcNew;
	}

//	public String getTextAtrributeCheckBox(String value) {
//		ArrayList<String> valueCheckbox = new ArrayList<String>();
//		List<WebElement> checkboxList = findElementsByXpath(driver, ProductDetailPageUI.INPUT_CHECKBOX, value);
//		int checkboxSize = checkboxList.size();
//		int i = 0;
//		for (WebElement checkbox : checkboxList) {
//			i++;
//			if (isElementSelectedByJs(driver, ProductDetailPageUI.INPUT_CHECKBOX_CSS)) {
//				String valueText = getElementByXpath(driver, ProductDetailPageUI.VALUE_CHECKBOX, value).getText();
//				System.out.println(valueText);
//			}
//			if (i == checkboxSize) {
//				break;
//			}
//
//		}
//		return valueCheckbox.toString();
//	}

	public int isShoppingCartLinkDisplay(int count) {
		if (isElementDisplay(driver, ProductDetailPageUI.SHOPPING_CART_LINK_MESSAGE)) {
			count++;
		}
		return count;
	}

	public CartPageObject clickToShoppingCartLink() {
		waitToElementClickable(driver, ProductDetailPageUI.SHOPPING_CART_LINK_MESSAGE);
		clickToElement(driver, ProductDetailPageUI.SHOPPING_CART_LINK_MESSAGE);
		return PageManagerObject.getCartPageObject(driver);
	}

	public int getNumberProductOnCartLink() {
		String value = getTextElement(driver, ProductDetailPageUI.SHOP_CART_SIZE_TEXT_ON_MENU);
		value = value.replace("(", "").replace(")", "").trim();
		return (int) Float.parseFloat(value);
	}

	public void moveToCartLink() {
		scrollToElement(driver, ProductDetailPageUI.SHOP_CART_LINK);
		waitForElementVisible(driver, ProductDetailPageUI.SHOP_CART_LINK);
		hoverMouseToElement(driver, ProductDetailPageUI.SHOP_CART_LINK);
	}

	public boolean isProductInfoDislayedPopup(String... values) {
		return isElementDisplay(driver, ProductDetailPageUI.PRODUCT_INFO_POPUP, values);
	}

	public int getNumberProductOnWishlist() {
		String value = getTextElement(driver, ProductDetailPageUI.WISH_LIST_SIZE_TEXT_ON_MENU);
		value = value.replace("(", "").replace(")", "").trim();
		return (int) Float.parseFloat(value);
	}

	public void clickToCloseButton() {
		waitToElementClickable(driver, ProductDetailPageUI.CLOSE_BUTTON);
		clickToElement(driver, ProductDetailPageUI.CLOSE_BUTTON);
	}

	public boolean isNoteItemSizeDisplay(String value) {
		return isElementDisplay(driver, ProductDetailPageUI.PRODUCT_SIZE_NOTE, value);
	}

	public String getPriceProduct() {
		return getTextElement(driver, ProductDetailPageUI.PRODUCT_PRICE);
	}

	public Double getFloatPriceProduct() {
		sleepInMilisecond(2000);
		String value= getTextElement(driver, ProductDetailPageUI.PRODUCT_PRICE);
		value=value.replace("$", "");
		value=value.replace(",", "");
		return Double.valueOf(value);
	}

	public String changePriceToPriceNew(Double price, int count) {
		Double value= price*count;
		NumberFormat format = NumberFormat.getCurrencyInstance(Locale.CANADA);
        String currencytotal = format.format(value);
		return currencytotal;
	}

	public CartPageObject clickToGoToCart() {
		waitToElementClickable(driver, ProductDetailPageUI.GO_TO_CART_BUTTON);
		clickToElement(driver,  ProductDetailPageUI.GO_TO_CART_BUTTON);
		return PageManagerObject.getCartPageObject(driver);
	}

	public String changePriceToPriceText(Double price) {
		NumberFormat format = NumberFormat.getCurrencyInstance(Locale.CANADA);
        String priceText = format.format(price);
		return priceText;
	}

	public void clickToAddToCartButton() {
		waitToElementClickable(driver, ProductDetailPageUI.ADD_TO_CART_BUTTON);
		clickToElement(driver,  ProductDetailPageUI.ADD_TO_CART_BUTTON);
	}
	
	



}

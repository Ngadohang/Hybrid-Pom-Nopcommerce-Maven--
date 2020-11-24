package pageObject.Nopcommerce.User;

import java.text.NumberFormat;
import java.util.Locale;

import org.openqa.selenium.WebDriver;

import common.AbstractPage;
import common.PageManagerObject;
import pageUI.Nopcommerce.User.AbstractPageUser;
import pageUI.Nopcommerce.User.CartPageUI;
import pageUI.Nopcommerce.User.WishListPageUI;

public class CartPageObject extends AbstractPage {
	private WebDriver driver;

	public CartPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isTitleCartPageDisplay() {
		return isElementDisplay(driver, CartPageUI.SHOPPING_CART_TITLE);
	}

	public boolean isSkuDisplayedToShoppingCart(String... value) {
		return isElementDisplay(driver, CartPageUI.SKU_OF_PRODUCT, value);
	}

	public boolean isProductInfoDisplay(String processor, String rAM, String hDD, String oS, String software,
			String namePro) {
		boolean status = false;
		String productInfo = getTextElement(driver, CartPageUI.PRODUCT_INFO, namePro).toLowerCase();
		if (productInfo.contains(processor.toLowerCase()) && productInfo.contains(hDD.toLowerCase())
				&& productInfo.contains(oS.toLowerCase()) && productInfo.contains(software.toLowerCase())) {
			status = true;
		}
		return status;
	}

	public String getImageToShopCart(String value) {
		return getElementAttribute(driver, CartPageUI.IMAGE_OF_PRODUCT, "src", value);
	}

	public String getPriceToShopCart(String namePro) {
		return getTextElement(driver, CartPageUI.PRICE_OF_PRODUCT, namePro);
	}

	public void moveToMenu(String value) {
		waitToElementClickable(driver, AbstractPageUser.DYNAMIC_LINK, value);
		hoverMouseToElement(driver, AbstractPageUser.DYNAMIC_LINK, value);
	}

	public int getNumberProductOnWishlist() {
		String value = getTextElement(driver, CartPageUI.WISH_LIST_LINK_ON_MENU);
		value = value.replace("(", "").replace(")", "").trim();
		return (int) Float.parseFloat(value);
	}

	public int getNumberProductOnCart() {
		String value = getTextElement(driver, CartPageUI.SHOPPING_CART_LINK);
		value = value.replace("(", "").replace(")", "").trim();
		return (int) Float.parseFloat(value);
	}

	public ProductListPageObject clickToSubMenu(String value) {
		waitToElementClickable(driver, AbstractPageUser.DYNAMIC_LINK, value);
		clickToElement(driver, AbstractPageUser.DYNAMIC_LINK, value);
		return PageManagerObject.getProductListPageObject(driver);
	}

	public UpdateCartPageObject clickToEditLink() {
		waitToElementClickable(driver, CartPageUI.EDIT_BUTTON);
		clickToElement(driver, CartPageUI.EDIT_BUTTON);
		return PageManagerObject.getUpdateCartPageObject(driver);
	}

	public String getValueQuantityProInCart(String namePro) {
		return getElementAttribute(driver, CartPageUI.QUANTITY_PRO_TEXTBOX, "value", namePro);
	}

	public int inputToQuantityProInCart(String quantityPro, String namePro) {
		waitForElementVisible(driver, CartPageUI.QUANTITY_PRO_TEXTBOX, namePro);
		senkeyToElement(driver, CartPageUI.QUANTITY_PRO_TEXTBOX, quantityPro, namePro);
		return (int) Float.parseFloat(quantityPro);
	}

	public void clickToUpdateCartButton() {
		waitToElementClickable(driver, CartPageUI.UPDATE_CART_BUTTON);
		clickToElement(driver, CartPageUI.UPDATE_CART_BUTTON);
	}

	public String getTotalProduct(String namePro) {
		return getTextElement(driver, CartPageUI.TOTAL_PRO, namePro);
	}

	public String calculateTotal(Double price, int quantity) {
		Double value = price * quantity;
		NumberFormat format = NumberFormat.getCurrencyInstance(Locale.CANADA);
		String total = format.format(value);
		return total;
	}

	public String changePriceToPriceText(Double price) {
		NumberFormat format = NumberFormat.getCurrencyInstance(Locale.CANADA);
		String priceText = format.format(price);
		return priceText;
	}

	public boolean isCartEmptyMessageDispay() {
		return isElementDisplay(driver, CartPageUI.CART_EMPTY_MESSAGE);
	}

	public boolean isProUnDisplayInCart() {
		return isElementUnDisplayExistDom(driver, CartPageUI.FORMAT_PRO);
	}

	public void inputToSearchTextBox(String value) {
		waitForElementVisible(driver, AbstractPageUser.SEARCH_TEXTBOX);
		senkeyToElement(driver, AbstractPageUser.SEARCH_TEXTBOX, value);
	}

	public SearchPageObject clickToSearchButton() {
		waitToElementClickable(driver, AbstractPageUser.SEARCH_BUTTON);
		clickToElement(driver, AbstractPageUser.SEARCH_BUTTON);
		return PageManagerObject.getSearchPageObject(driver);
	}

	public void clickToRemoveCheckbox(String namePro) {
		waitToElementClickable(driver, CartPageUI.REMOVE_CHECKBOX, namePro);
		clickToElement(driver, CartPageUI.REMOVE_CHECKBOX, namePro);
	}

	public boolean isProSizeInShopCartPopup(int numb) {
		return isElementDisplay(driver, CartPageUI.QUANTITY_PRO_IN_SHOPPING_CART_LINK, String.valueOf(numb));
	}

	public void moveToShopCartLinkInMenu(int numb) {
		waitForElementVisible(driver, CartPageUI.SHOPPING_CART_LINK, String.valueOf(numb));
		hoverMouseToElement(driver, CartPageUI.SHOPPING_CART_LINK, String.valueOf(numb));
	}

	public boolean isNoItemsInCartMessageDisplay() {
		return isElementDisplay(driver, CartPageUI.CART_EMPTY_MESSAGE);
	}

	public String setGiftWrapping(String select) {
		waitForElementVisible(driver, CartPageUI.GIFT_WRAPPING);
		selectItemInDropdownDefault(driver, CartPageUI.GIFT_WRAPPING, select);
		return getTextFirstSelectedTextInDropdownDefault(driver, CartPageUI.GIFT_WRAPPING, select);
	}

	public void clickToEstimateShipping() {
		waitToElementClickable(driver, CartPageUI.ESTIMATE_BUTTON);
		clickToElement(driver, CartPageUI.ESTIMATE_BUTTON);
	}

	public String setCountryToShipping(String country) {
		waitForElementVisible(driver, CartPageUI.COUNTRY_SELECTION);
		selectItemInDropdownDefault(driver, CartPageUI.COUNTRY_SELECTION, country);
		return getTextFirstSelectedTextInDropdownDefault(driver, CartPageUI.COUNTRY_SELECTION, country);
	}

	public String setStateToShipping(String state) {
		waitForElementVisible(driver, CartPageUI.STATE_PROVINCE_SELECTION);
		selectItemInDropdownDefault(driver, CartPageUI.STATE_PROVINCE_SELECTION, state);
		return getTextFirstSelectedTextInDropdownDefault(driver, CartPageUI.STATE_PROVINCE_SELECTION, state);
	}

	public String inputToZipCodeToShipping(String zinCop) {
		waitForElementVisible(driver, CartPageUI.ZIP_CODE_TEXTBOX);
		senkeyToElement(driver, CartPageUI.ZIP_CODE_TEXTBOX, zinCop);
		return zinCop;
	}

	public String clickToShippingMethod(String nameMe) {
		waitToElementClickable(driver, CartPageUI.METHOD_SHIPPING_RADIO, nameMe);
		clickToElement(driver, CartPageUI.METHOD_SHIPPING_RADIO, nameMe);
		return nameMe;
	}

	public void clickToAppyButton() {
		waitToElementClickable(driver, CartPageUI.APPY_BUTTON);
		clickToElement(driver, CartPageUI.APPY_BUTTON);
	}

	public boolean isInforShipDisplay(String...values) {
		return isElementDisplay(driver, CartPageUI.INFO_SHIPPING_AFTER_CHECKOUT, values);
	}

	public void clickToIagreeCheckBox() {
		waitToElementClickable(driver, CartPageUI.I_AGREE_CHECKBOX);
		clickToElement(driver, CartPageUI.I_AGREE_CHECKBOX);
	}

	public void clickToCheckOutButton() {
		waitToElementClickable(driver, CartPageUI.CHECK_OUT_BUTTON);
		clickToElement(driver, CartPageUI.CHECK_OUT_BUTTON);

	}

	public boolean isYouWillEarnNoteDispay(String value) {
		return isElementDisplay(driver, CartPageUI.YOU_WILL_EARN_NOTE, value);
	}

}

package pageObject.Nopcommerce.User;

import org.openqa.selenium.WebDriver;

import common.AbstractPage;
import common.PageManagerObject;
import pageUI.Nopcommerce.User.AbstractPageUser;
import pageUI.Nopcommerce.User.CartPageUI;
import pageUI.Nopcommerce.User.ProductDetailPageUI;
import pageUI.Nopcommerce.User.WishListPageUI;

public class WishListPageObject extends AbstractPage {
	private WebDriver driver;

	public WishListPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isTitleWishlistDisplay() {
		return isElementDisplay(driver, WishListPageUI.TITLE_WISH_LIST);
	}
	public boolean isSkuDisplayedToWishlist(String... value) {
		return isElementDisplay(driver, WishListPageUI.SKU_OF_PRODUCT, value);
	}

	public boolean isWishlistEmptyDisplay() {
		return isElementDisplay(driver, WishListPageUI.WISH_LIST_EMPTY_MESSAGE);
	}

	public int numberProductInWishlist() {
		return findElementsByXpath(driver, WishListPageUI.ROW_PRODUCT_SIZE).size();
	}

	public boolean isProductInfoDisplay(String processor, String rAM, String hDD, String oS,
			String software, String namePro) {
		boolean status = false;
		String productInfo = getTextElement(driver, WishListPageUI.PRODUCT_INFO, namePro).toLowerCase();
		System.out.println(productInfo);
		if (productInfo.contains(processor.toLowerCase()) && productInfo.contains(hDD.toLowerCase())
				&& productInfo.contains(oS.toLowerCase()) && productInfo.contains(software.toLowerCase())) {
			status = true;
		}
		return status;
	}

	public String getImageOnWishlist(String value) {
		return getElementAttribute(driver, WishListPageUI.IMAGE_OF_PRODUCT, "src", value);
	}

	public String getPriceOnWishlist(String namePro) {
		return getTextElement(driver, WishListPageUI.PRICE_OF_PRODUCT, namePro);
	}

	public void clickToMyWishList() {
		waitToElementClickable(driver, WishListPageUI.MY_WISH_LIST_LINK);
		clickToElement(driver, WishListPageUI.MY_WISH_LIST_LINK);
	}

	public String getTitleMyWishlist() {
		waitForElementVisible(driver, WishListPageUI.TITLE_MY_WISH_LIST);
		return getTextElement(driver, WishListPageUI.TITLE_MY_WISH_LIST);
	}

	public void clickToAddToCartCheckBox(String value) {
		waitToElementClickable(driver, WishListPageUI.ADD_TO_CART_CHECKBOX,value);
		checkToCheckBox(driver, WishListPageUI.ADD_TO_CART_CHECKBOX,value);
	}

	public CartPageObject clickToAddToCartButton() {
		waitToElementClickable(driver, WishListPageUI.ADD_TO_CART_BUTTON);
		clickToElement(driver,  WishListPageUI.ADD_TO_CART_BUTTON);
		return PageManagerObject.getCartPageObject(driver);
	}

	public boolean isIndexProductShowOnWishlist(int totalProduct) {
		return isElementDisplay(driver, ProductDetailPageUI.WISH_LIST_SIZE_TEXT_ON_MENU, String.valueOf(totalProduct));
	}

	public void clickToRemoveProductInWishlist(String value) {
		waitToElementClickable(driver, WishListPageUI.REMOVE_CHECKBOX,value);
		checkToCheckBox(driver, WishListPageUI.REMOVE_CHECKBOX,value);
	}

	public void clickToUpdateWishlistButton() {
		waitToElementClickable(driver, WishListPageUI.UPDATE_WISH_LIST_BUTTON);
		clickToElement(driver,  WishListPageUI.UPDATE_WISH_LIST_BUTTON);
	}

	public void moveToMenu(String value) {
		waitForElementVisible(driver, AbstractPageUser.DYNAMIC_LINK, value);	
		hoverMouseToElement(driver, AbstractPageUser.DYNAMIC_LINK, value);
	}

	public ProductListPageObject clickToSubMenu(String value) {
		waitToElementClickable(driver, AbstractPageUser.DYNAMIC_LINK, value);
		clickToElement(driver, AbstractPageUser.DYNAMIC_LINK, value);
		return PageManagerObject.getProductListPageObject(driver);
	}

	public int getNumberProductOnWishlist() {
		String value = getTextElement(driver, WishListPageUI.WISH_LIST_LINK_ON_MENU);
		value = value.replace("(", "").replace(")", "").trim();
		return (int) Float.parseFloat(value);
	}

	

}

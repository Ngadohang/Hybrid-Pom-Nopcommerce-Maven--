package pageUI.Nopcommerce.User;

public class ProductDetailPageUI {
	public static final String IMAGE_PRODUCT = "//div[@class='picture']/img";
	public static final String IMAGE_THUMBS = "//div[@class='picture-thumbs']//img";
	public static final String ADD_WISH_LIST_BUTTON = "//input[@value='Add to wishlist']";
	public static final String ADD_TO_CART_BUTTON = "//input[@value='Add to cart']";
	public static final String SHOPPING_CART_LINK_MESSAGE = "//p[contains(.,'The product has been added to your')]/a[text()='shopping cart']";
	public static final String CLOSE_BUTTON="//span[@title='Close']";

	public static final String GO_WISH_LIST_LINK = "//p[contains(.,'The product has been added to your')]/a[text()='wishlist']";
	public static final String WISH_LIST_LINK = "//span[text()='Wishlist']";
	public static final String SHOP_CART_LINK = "//span[text()='Shopping cart']";
	
	public static final String PRODUCT_NAME = "//div[@class='product-name']//h1[text()='Build your own computer']";
	public static final String WISH_LIST_SIZE_TEXT_ON_MENU = "//span[text()='Wishlist']/following-sibling::span";
	public static final String SHOP_CART_SIZE_TEXT_ON_MENU = "//span[text()='Shopping cart']/following-sibling::span";
	
	
	public static final String WISH_LIST_URL = "//span[text()='Your wishlist URL for sharing:']/following-sibling::a";
	public static final String PRODUCT_TYPE_RADIO = "//label[contains(.,'%s')]/parent::dt/following-sibling::dd[1]//label[text()='%s']/preceding-sibling::input[@type='radio']";
	public static final String PRODUCT_TYPE_CHECKBOX = "//label[contains(.,'%s')]/parent::dt/following-sibling::dd[1]//label[text()='%s']/preceding-sibling::input[@type='checkbox']";
	public static final String PRODUCT_TYPE_SELECT = "//label[contains(.,'%s')]/parent::dt/following-sibling::dd[1]/select";
	public static final String VALUE_RADIO = "//label[contains(.,'%s')]/parent::dt/following-sibling::dd[1]//label[text()='%s']";

	public static final String VALUE_CHECKBOX = "//label[contains(.,'%s')]/parent::*/following-sibling::dd//li/label";
	public static final String INPUT_CHECKBOX = "//label[contains(.,'%s')]/parent::*/following-sibling::dd//li/input";
	public static final String INPUT_CHECKBOX_CSS = "dd[id^='product_attribute'] input[type='checkbox']";

	public static final String PRODUCT_PRICE = "//span[@id='price-value-1']";
	public static final String SKU_INFO = "//span[text()='SKU:']/following-sibling::span";

	public static final String PRODUCT_SIZE_IN_POPUP_CART_NOTE = "//div[@class='count' and contains(.,'There are') and contains(.,'in your cart') and contains(.,'%s item(s)')]";
	public static final String PRODUCT_SIZE_NOTE = "//div[@class='count' and contains(.,'There are') and contains(.,'in your cart') and contains(.,'%s item(s)') ]";
	public static final String PRODUCT_INFO_POPUP = "//img[contains(@src,'%s')]/ancestor::*/following-sibling::*//a[text()='%s']/parent::*/following-sibling::*[contains(.,'%s') and contains(.,'%s') and contains(.,'%s') and  contains(.,'%s') and contains(.,'%s') and contains(.,'%s') and contains(.,'%s') ]/following-sibling::*/span[text()='%s']/parent::*/following-sibling::*/span[text()='%s']/ancestor::*/following-sibling::*/strong[text()='%s']";
	public static final String GO_TO_CART_BUTTON="//input[@value='Go to cart']";
}

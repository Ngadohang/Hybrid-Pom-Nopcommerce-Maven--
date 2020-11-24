package pageUI.Nopcommerce.User;

public class CartPageUI {
	public static final String QUANTITY_PRO_IN_SHOPPING_CART_LINK="//li[@id='topcartlink']/a/span[text()='Shopping cart']/following-sibling::span";
	public static final String SHOPPING_CART_LINK="//li[@id='topcartlink']/a/span[text()='Shopping cart']";
	public static final String SHOPPING_CART_TITLE="//h1[text()='Shopping cart']";
	public static final String WISH_LIST_LINK_ON_MENU="//span[text()='Wishlist']/following-sibling::span";
	public static final String SKU_OF_PRODUCT="//a[text()='%s']/parent::*/preceding-sibling::*//span[text()='%s']";
	public static final String IMAGE_OF_PRODUCT="//a[text()='%s']/parent::*/preceding-sibling::*//img";
	public static final String PRODUCT_INFO="//a[text()='%s']/parent::*/*[@class='attributes']";
	public static final String PRICE_OF_PRODUCT="//a[text()='%s']/parent::*/following-sibling::*/label[text()='Price:']/following-sibling::span";

	
	public static final String EDIT_BUTTON="//a[text()='Edit']";
	public static final String QUANTITY_PRO_TEXTBOX="//a[text()='%s']/parent::*/following-sibling::*/input";
	public static final String TOTAL_PRO="//a[text()='%s']/ancestor::*/following-sibling::*/label[text()='Total:']/following-sibling::span";
	public static final String UPDATE_CART_BUTTON="//input[@name='updatecart']";
	public static final String CART_EMPTY_MESSAGE="//div[@class='page-body']/div[contains(.,'Your Shopping Cart is empty!')]";
	public static final String FORMAT_PRO="//h1[text()='Shopping cart']/parent::*/following-sibling::*//form";
	public static final String GIFT_WRAPPING="//label[contains(.,'Gift wrapping')]/parent::*/following-sibling::*/select";
	public static final String ESTIMATE_BUTTON="//a[contains(.,'Estimate shipping')]";
	public static final String COUNTRY_SELECTION="//select[@id='CountryId']";
	public static final String STATE_PROVINCE_SELECTION="//select[@id='StateProvinceId']";
	public static final String ZIP_CODE_TEXTBOX="//input[@id='ZipPostalCode']";
	public static final String NAME_METHOD_SHIPPING="//div[text()='%s']";
	public static final String METHOD_SHIPPING_RADIO="//div[text()='%s']/following-sibling::*[2]";
	public static final String APPY_BUTTON="//input[@value='Apply']";
	public static final String I_AGREE_CHECKBOX="//input[@id='termsofservice']";
	public static final String CHECK_OUT_BUTTON="//button[@id='checkout']";
	public static final String INFO_SHIPPING_AFTER_CHECKOUT="//div[contains(.,'Gift wrapping: %s')]/ancestor::*//label[text()='Sub-Total:']/parent::*/following-sibling::*/span[text()='%s']/ancestor::*/following-sibling::*//label[text()='Shipping:']/following-sibling::*[text()='(%s)']/parent::*/following-sibling::*/span[text()='%s']/ancestor::*/following-sibling::*//label[text()='Total:']/parent::*/following-sibling::*//strong[text()='%s']";
	public static final String YOU_WILL_EARN_NOTE="//label[text()='//label[text()='You will earn:']/parent::*/following-sibling::*/span[text()='%s points']";
	public static final String REMOVE_CHECKBOX="//a[text()='%s']/parent::*/preceding-sibling::*/input[@name='removefromcart']";
}

package pageUI.Nopcommerce.User;

public class UpdateCartPageUI {
	public static final String UPDATE_CART_BUTTON="//input[@value='Update']";
	public static final String UPDATE_CART_LINK_SUCCESS_MESSAGE = "//p[contains(.,'The product has been added to your')]/a[text()='shopping cart']";
	public static final String PRODUCT_TYPE_RADIO = "//label[contains(.,'%s')]/parent::dt/following-sibling::dd[1]//label[text()='%s']/preceding-sibling::input[@type='radio']";
	public static final String PRODUCT_TYPE_CHECKBOX = "//label[contains(.,'%s')]/parent::dt/following-sibling::dd[1]//label[text()='%s']/preceding-sibling::input[@type='checkbox']";
	public static final String PRODUCT_TYPE_SELECT = "//label[contains(.,'%s')]/parent::dt/following-sibling::dd[1]/select";
	public static final String VALUE_RADIO = "//label[contains(.,'%s')]/parent::dt/following-sibling::dd[1]//label[text()='%s']";
	public static final String PRODUCT_PRICE = "//span[@id='price-value-1']";	}

package pageUI.Nopcommerce.User;

public class SearchPageUI {
	public static final String LIST_IMAGE_PRODUCT_SEARCH = "//div[@class='picture']//img";
	public static final String TITLE_PRODUCT = "//h2[@class='product-title']/a";
	public static final String ADVANCED_CHECKBOX = "//input[@id='adv']";
	public static final String AUTO_CHECKBOX = "//input[@id='isc']";
	public static final String SEARCH_IN_CHECKBOX = "//input[@id='isc']";
	public static final String CATEGORIES_SELECT = "//select[@id='cid']";
	public static final String MANU_SELECT = "//select[@id='mid']";
	public static final String PRICE_FROM_TEXTBOX = "//input[@id='pf']";
	public static final String PRICE_TO_TEXTBOX = "//input[@id='pt']";
	public static final String RESULT_SEARCH="//div[@class='search-results']";
	public static final String SEARCH_BUTTON="//div[@class='fieldset']//following-sibling::*/input[@value='Search']";
	public static final String ADD_TO_CART_BY_NAME_PRODUCT="//a[text()='%s']/parent::*/following-sibling::*//input[@value='Add to cart']";
	public static final String PRICE_BY_NAME_PRODUCT="//a[text()='%s']/parent::*/following-sibling::*//span[@class='price actual-price']";
	public static final String SHOPPING_CART_LINK_MESSAGE = "//p[contains(.,'The product has been added to your')]/a[text()='shopping cart']";
}

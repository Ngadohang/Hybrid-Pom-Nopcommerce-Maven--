package pageUI.Nopcommerce.User;

public class AbstractPageUser {
	public static final String DYNAMIC_LINK = "//a[contains(.,'%s')]";
	public static final String DYNAMIC_TEXTBOX = "//input[@id='%s']";
	public static final String DYNAMIC_BUTTON = "//input[@value='%s']";
	public static final String DYNAMIC_TEXTBOX_BY_LABEL = "//label[text()='%s']/parent::div/input";
	public static final String DYNAMIC_TITLE = "//h1[text()='%s']";
	public static final String DYNAMIC_LINK_FOOTER = "//div[@class='footer-block customer-service']//a[text()='%s']";
	public static final String DYNAMIC_ERROR_MESSAGE ="//div[text()='%s']";
	public static final String DYNAMIC_PRODUCT = "//img[contains(@title,'%s')]/ancestor::*/following-sibling::*//a[text()='%s']/parent::*/following-sibling::*//div[@style='width:%s']/ancestor::*/following-sibling::*//span[text()='%s']/ancestor::*/following-sibling::*/input[@value='Add to cart']/following-sibling::input[@value='Add to compare list']/following-sibling::input[@value='Add to wishlist']";
	public static final String DYNAMIC_BREADCRUMB_PRODUCT_LIST="//div[@class='breadcrumb']//li/a[text()='Home']/parent::li/following-sibling::li/a[@title='%s']/parent::li/following-sibling::li/strong[text()='%s']";
	public static final String DYNAMIC_BREADCRUMB_PRODUCT_DETAIL="//div[@class='breadcrumb']//li/a[text()='Home']/parent::li/following-sibling::li/a[@title='%s']/parent::li/following-sibling::li/a[@title='%s']/parent::li/following-sibling::li/strong[text()='%s']";
	
	public static final String PRICE_PRODUCT_BY_NAME="//a[text()='%s']/parent::*/following-sibling::*//span[contains(@class,'price')]";
	public static final String IMAGE_PRODUCT_BY_NAME="//a[text()='%s']/ancestor::*/div[@class='picture']//img";
	public static final String SEARCH_TEXTBOX="//input[@id='small-searchterms']";
	public static final String SEARCH_BUTTON="//input[@value='Search']";
	
}

package pageUI.Nopcommerce.User;

public class ProductListPageUI {
	public static final String SORT_SELECT="//select[@id='products-orderby']";
	public static final String PAGING_SELECT="//select[@id='products-pagesize']";
	public static final String NEXT_BUTTON="//a[text()='Next']";
	public static final String PREVIOUS_BUTTON="//a[text()='Previous']";
	public static final String DYNAMIC_PAGING_NUMBER="//a[text()='%s']/parent::li[@class='individual-page']";

	public static final String TITLE_PRODUCT="//h2[@class='product-title']/a";
	public static final String DYNAMIC_TITLE_PRODUCT="//h2[@class='product-title']/a[text()='%s']";
	public static final String PRICE_PRODUCT_LIST="//div[@class='prices']/span";
	
	public static final String COMPARE_LIST_BUTTON="//a[text()='%s']/parent::*/following-sibling::*//input[@value='Add to compare list']";
	public static final String COMPARE_LIST_LINK="//p[contains(.,'The product has been added to your')]/a[text()='product comparison']";
	
	public static final String PRICE_PRODUCT_BY_NAME="//a[text()='%s']/parent::*/following-sibling::*//span[contains(@class,'price')]";
	public static final String IMAGE_PRODUCT_BY_NAME="//a[text()='%s']/ancestor::*/div[@class='picture']//img";
}


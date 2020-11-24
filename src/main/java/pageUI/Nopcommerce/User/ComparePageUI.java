package pageUI.Nopcommerce.User;

public class ComparePageUI {
	public static final String PRODUCT_INFO="//tr[@class='remove-product']//input[@value='Remove']/ancestor::*/following-sibling::*//img[contains(@src,'%s')]/ancestor::*//a[text()='%s']/ancestor::*/following-sibling::tr//td[text()='%s']";
	public static final String IMAGE_PRODUCT="//a[@class='picture']/img[contains(@alt,'%s')]";
	public static final String CLEAR_LIST_BUTTON="//a[text()='Clear list']";
	public static final String COMPARE_LIST_EMPTY="//div[text()='You have no items to compare.']";
}

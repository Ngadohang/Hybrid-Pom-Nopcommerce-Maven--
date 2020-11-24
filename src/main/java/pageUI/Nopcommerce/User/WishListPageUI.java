package pageUI.Nopcommerce.User;

public class WishListPageUI {
	public static final String WISH_LIST_LINK_ON_MENU="//span[text()='Wishlist']/following-sibling::span";
	public static final String TITLE_WISH_LIST="//h1[text()='Wishlist']";
	public static final String WISH_LIST_EMPTY_MESSAGE="//div[text()='The wishlist is empty!']";
	public static final String ROW_PRODUCT_SIZE="//tbody//tr";
	
	public static final String REMOVE_CHECKBOX="//a[text()='%s']/parent::*/preceding-sibling::*/input[@name='removefromcart']";
	public static final String ADD_TO_CART_CHECKBOX="//a[text()='%s']/parent::*/preceding-sibling::*/input[@name='addtocart']";
	public static final String SKU_OF_PRODUCT="//a[text()='%s']/parent::*/preceding-sibling::*//span[text()='%s']";
	public static final String IMAGE_OF_PRODUCT="//a[text()='%s']/parent::*/preceding-sibling::*//img";
	public static final String PRODUCT_INFO="//a[text()='%s']/parent::*/*[@class='attributes']";
	public static final String PRICE_OF_PRODUCT="//a[text()='%s']/parent::*/following-sibling::*/label[text()='Price:']/following-sibling::span";
	
	public static final String MY_WISH_LIST_LINK="//div[@class='share-info']/span[text()='Your wishlist URL for sharing:']/following-sibling::a";
	public static final String TITLE_MY_WISH_LIST="//div[@class='page-title']/h1";
	public static final String ADD_TO_CART_BUTTON="//input[@value='Add to cart']";
	public static final String UPDATE_WISH_LIST_BUTTON="//input[@value='Update wishlist']";
}


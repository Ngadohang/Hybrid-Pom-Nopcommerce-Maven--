package pageUI.Nopcommerce.Admin;

public class ProductPageUI {
		public static final String SEARCH_PRODUCT_NAME_TEXTBOX="//input[@id='SearchProductName']";
		public static final String SEARCH_BUTTON="//button[@id='search-products']";
		public static final String INFO_PRODUCT="//img[@src]/parent::*/following-sibling::*[text()='%s']/following-sibling::*[text()='%s']/following-sibling::*[text()='%s']/following-sibling::*[text()='%s']/following-sibling::*[text()='%s']/following-sibling::*//i[@nop-value]";
		public static final String CATEGORY_SELECT="//select[@id='SearchCategoryId']";
		public static final String SUBCATEGORY_CHECKBOX="//input[@id='SearchIncludeSubCategories']";
		public static final String MANUFACTURER_SELECT="//select[@id='SearchManufacturerId']";
		public static final String GO_TO_SKU_TEXTBOX="//input[@id='GoDirectlyToSku']";
		public static final String GO_TO_SKU_BUTTON="//button[@id='go-to-product-by-sku']";
		public static final String NO_DATA_IN_TABLE_MESSAGE="//td[text()='No data available in table']";
}

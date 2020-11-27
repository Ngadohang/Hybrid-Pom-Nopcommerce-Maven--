package pageUI.Nopcommerce.Admin;

public class CustomerAdminPageUI {
	public static final String CUSTOMER_PAGE_TITLE = "//h1[contains(.,'Customers')]";
	public static final String ADD_NEW_CUSTOMER_BUTTON = "//a[contains(.,'Add new')]";
	public static final String SEARCH_BUTTON = "//button[@id='search-customers']";
	public static final String UPDATE_SUCCESS_MESSAGE="//button[@class='close']/parent::div[contains(.,'The customer has been updated successfully.')]";
	public static final String DATA_CUSTOMER_ROW = "//tr//td[text()='%s %s']/following-sibling::td[text()='%s']/following-sibling::td[text()=\"%s\"]";
	public static final String EDIT_BUTTON_ON_ROW= DATA_CUSTOMER_ROW +"/following-sibling::td[last()]/a";
	public static final String FIRST_NAME_TEXBOX = "//input[@id='SearchFirstName']";
	public static final String EMAIL_TEXTBOX = "//input[@id='SearchEmail']";
	public static final String LAST_NAME_TEXBOX = "//input[@id='SearchLastName']";
	public static final String COMPANY_TEXBOX = "//input[@id='SearchCompany']";
	public static final String MONTH_SELECT = "//select[@id='SearchMonthOfBirth']";
	public static final String DAY_SELECT = "//select[@id='SearchDayOfBirth']";
	public static final String DYNAMIC_COL_ADDRESS_BY_TITLE_TABLE = "//th[text()='%s']/preceding-sibling::*";
	public static final String DYNAMIC_CELL_ADDRESS_BY_NAME_DATA = "//td[text()='%s %s']/following-sibling::*[%s]/a";
	public static final String ADD_NEW_ADDRESS_SUCCESS_MESSAGE = "//button[@class='close']/parent::*[contains(.,'The new address has been added successfully.')]";
	public static final String CUSTOMER_ROLE_DROPDOWN = "//label[text()='Customer roles']/ancestor::*/following-sibling::*/div[contains(@class,'k-multiselect')]";
	public static final String DYNAMIC_DROPDOWN_CHILD_XPATH = "//ul[@id='SelectedCustomerRoleIds_listbox']/li";
	public static final String CUSTOMER_ROLE_CLOSE_BUTTON="//ul[@id='SelectedCustomerRoleIds_taglist']//span[text()='%s']/following-sibling::*";

}

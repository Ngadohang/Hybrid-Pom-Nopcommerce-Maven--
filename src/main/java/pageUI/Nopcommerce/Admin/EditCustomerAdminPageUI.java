package pageUI.Nopcommerce.Admin;

public class EditCustomerAdminPageUI {
	public static final String EMAIL_TEXTBOX = "//input[@id='Email']";
	public static final String PASSWORD_TEXTBOX = "//input[@id='Password']";
	public static final String FIRST_NAME_TEXTBOX = "//input[@id='FirstName']";
	public static final String LAST_NAME_TEXTBOX = "//input[@id='LastName']";
	public static final String COMPANY_TEXTBOX = "//input[@id='Company']";
	public static final String DATE_OF_BIRTH = "//input[@id='DateOfBirth']";
	public static final String EDIT_CUSTOMER_SUCCESS_MESSAGE = "//button[@class='close']/parent::*[contains(.,'The new customer has been added successfully.')]";
	public static final String SAVE_BUTTON = "// button[contains(.,'Save')][1]";
	public static final String ADD_NEW_ADDRESS="// button[contains(.,'Add new address')]";
	public static final String ADDRESS_DATA_CELL="// td[text()='%s']/following-sibling::*[text()='%s']/following-sibling::*[text()='%s']/following-sibling::*[text()='%s']/following-sibling::*[text()='%s']/following-sibling::*/div";
	public static final String ADDRESS_INFO_ROW="// td[text()='%s']/following-sibling::*[text()='%s']/following-sibling::*[text()='%s']/following-sibling::*[text()='%s']/following-sibling::*[text()='%s']";
	public static final String EDIT_ADDRESS_BUTTON="// td[text()='%s']/following-sibling::*[text()='%s']/following-sibling::*[text()='%s']/following-sibling::*[text()='%s']/following-sibling::*[text()='%s']/following-sibling::*//a[contains(.,'Edit')]";
	public static final String DELETE_ADDRESS_BUTTON="// td[text()='%s']/following-sibling::*[text()='%s']/following-sibling::*[text()='%s']/following-sibling::*[text()='%s']/following-sibling::*[text()='%s']/following-sibling::*//a[contains(.,'Delete')]";
	public static final String NO_DATA_ADDRESS="//span[text()='Addresses']/parent::*/following-sibling::*//tbody//td[text()='No data available in table']";
	public static final String TITLE_PAGE="//h1[contains(.,'Edit customer details - %s %s')]";
	public static final String ADMIN_COMMENT_TEXTAREA="//textarea[@id='AdminComment']";
	public static final String ADDRESS_LAYOUT="//div[@id='customer-address']";
}

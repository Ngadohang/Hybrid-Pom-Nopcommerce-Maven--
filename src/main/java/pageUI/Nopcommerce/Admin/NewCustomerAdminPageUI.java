package pageUI.Nopcommerce.Admin;

public class NewCustomerAdminPageUI {
	public static final String EMAIL_TEXTBOX = "//input[@id='Email']";
	public static final String PASSWORD_TEXTBOX = "//input[@id='Password']";
	public static final String FIRST_NAME_TEXTBOX = "//input[@id='FirstName']";
	public static final String LAST_NAME_TEXTBOX = "//input[@id='LastName']";
	public static final String DYNAMIC_GENDER_RADIO = "//label[contains(.,'%s')]/input";
	public static final String DATE_OF_BIRTH = "//input[@id='DateOfBirth']";
	public static final String COMPANY_TEXTBOX = "//input[@id='Company']";
	public static final String IS_TAX_EXEMPT = "//input[@id='IsTaxExempt']";
	public static final String NEWSLETTER_DROPDOWN_PARENT_XPATH= "//label[text()='Newsletter']/ancestor::*/following-sibling::*//div[contains(@class,'k-widget k-multiselect')]";
	public static final String CUSTOMER_ROLE_DROPDOWN_PARENT_XPATH= "//label[text()='Customer roles']/ancestor::*/following-sibling::*//div[contains(@class,'k-widget k-multiselect')]";
	public static final String NEWSLETTER_DROPDOWN_CHILD_XPATH= "//ul[@id='SelectedNewsletterSubscriptionStoreIds_listbox']/li";
	public static final String CUSTOMER_ROLE_DROPDOWN_CHILD_XPATH = "//ul[@id='SelectedCustomerRoleIds_listbox']/li";
	public static final String VENDOR_SELECT = "//select[@id='VendorId']";
	public static final String ADMIN_COMMENT_TEXTAREA="//textarea[@id='AdminComment']";
	public static final String SAVE_CONTINUE_BUTTON="//button[@name='save-continue']";
	public static final String NEW_CUSTOMER_SUCCESS_MESSAGE="//button[@class='close']/parent::*[contains(.,'The new customer has been added successfully.')]";
	public static final String ADDRESS_TITLE="//h1[contains(.,'Add a new customer')]";
	public static final String BACK_TO_CUSTOMER="//a[text()='back to customer list']";
	public static final String CUSTOMER_ROLE_TEXTBOX="//input[@aria-describedby='SelectedCustomerRoleIds_taglist']";
	public static final String CUSTOMER_ROLE_CLOSE="//span[text()='%s']/following-sibling::*";

}

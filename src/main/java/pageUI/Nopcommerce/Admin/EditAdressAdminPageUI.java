package pageUI.Nopcommerce.Admin;

public class EditAdressAdminPageUI {
	public static final String FIRST_NAME_TEXTBOX = "//input[@id='Address_FirstName']";
	public static final String LAST_NAME_TEXTBOX = "//input[@id='Address_LastName']";
	public static final String EMAIL_TEXTBOX = "//input[@id='Address_Email']";
	public static final String COMPANY_TEXTBOX = "//input[@id='Address_Company']";
	public static final String CITY_TEXTBOX = "//input[@id='Address_City']";
	public static final String ADDRESS1_TEXTBOX = "//input[@id='Address_Address1']";
	public static final String ADDRESS2_TEXTBOX = "//input[@id='Address_Address2']";
	public static final String ZIPCODE_TEXTBOX = "//input[@id='Address_ZipPostalCode']";
	public static final String PHONE_TEXTBOX = "//input[@id='Address_PhoneNumber']";
	public static final String FAX_TEXTBOX = "//input[@id='Address_FaxNumber']";
	public static final String COUNTRY_SELECT = "//select[@id='Address_CountryId']";
	public static final String STATE_SELECT = "//select[@id='Address_StateProvinceId']";
	public static final String SAVE_BUTTON = "//button[contains(.,'Save')]";
	public static final String NEW_ADDRESS_TITLE = "//h1[contains(.,'Add a new address')]";
	public static final String NEW_ADDRESS_SUCCESS_MESSAGE="// button[@class='close']/parent::*[contains(.,'The new address has been added successfully.')]";
	public static final String BACK_TO_CUSTOMER="// a[text()='back to customer details']";
}

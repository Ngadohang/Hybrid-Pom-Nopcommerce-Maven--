package pageUI.Nopcommerce.User;

public class LoginPageUI {
	public static final String LOGIN_PAGE_TITLE = "//h1[text()='Welcome, Please Sign In!']";
	public static final String ERROR_MESSAGE = "//strong[text()='Returning Customer']/parent::div/preceding-sibling::*[text()='Login was unsuccessful. Please correct the errors and try again.']/ul/li[text()='%s']";
	public static final String EMAIL_ERROR_MESSAGE="//span[text()='%s']";

}

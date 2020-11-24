package commonTestCase;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.AbstractTest;
import common.PageManagerObject;
import commonData.DataJson;
import pageObject.Nopcommerce.User.HomePageObject;
import pageObject.Nopcommerce.User.RegisterPageObject;

public class Common_TC_02_Register_Success_Case extends AbstractTest {
	WebDriver driver;
	public static String email, password,gender,firsname,lastname,birthday,birthmonth,birthdayear,company;
	@Parameters({"browser", "url","registerData"})
	@BeforeTest
	public void beforeTestCase(String browserName, String url, String registerData) {
		log.info("Open User Page");
		driver= getBrowserDriver(browserName, url);
		data=DataJson.get(registerData);
		email = "ngado" + getEmailRandom() + "@gmail.com";
		password=data.getPassword();
		homePage=PageManagerObject.getHomePageObject(driver);
		log.info("Register Step 01:Click to 'Register'link ");
		registerPage=(RegisterPageObject) homePage.clickToNewPage(driver,"Register");
		log.info("Register Step 02:input to field");
		gender=registerPage.clickToRadioCheckboxGender("Male");
		firsname=registerPage.inputToFirstNameTextBox(data.getFirstName());
		lastname=registerPage.inputToLastNameTextBox(data.getLastName());
		birthday=registerPage.selectToDayofBirth(data.getDateOfBirthDay());
		birthmonth=registerPage.selectToMonthofBirth(data.getDateOfBirthMonth());
		birthdayear=registerPage.selectToYearofBirth(data.getDateOfBirthYear());
		registerPage.inputToEmailTextBox(email);
		company=registerPage.inputToCompanyTextBox(data.getCompany());
		registerPage.clickToNewsLetter();
		registerPage.inputToPasswordTextBox(password);
		registerPage.inputToConfirmationPasswordTextBox(password);
		
		log.info("Register Step 03:Click to 'Register' button");
		registerPage.clickToRegisterButton();	
		
		log.info("Register Step 04: Verify register success");
		verifyTrue(registerPage.isRegisterSuccessMessage());
		verifyTrue(registerPage.isMyAccountLinkDisplay());
		verifyTrue(registerPage.isLogoutLinkDisplay());

		log.info("Register Step 05: Click 'Logout' button");
		registerPage.clicktoLogoutButton();
		
		removeDriver();
	}
	
	public int getEmailRandom() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}
	
	HomePageObject homePage;
	RegisterPageObject registerPage;
	DataJson data;
}

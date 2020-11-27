package com.Nopcommerce.User;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.AbstractTest;
import common.PageManagerObject;
import commonData.DataJson;
import commonTestCase.Common_TC_02_Register_Success_Case;
import pageObject.Nopcommerce.User.HomePageObject;
import pageObject.Nopcommerce.User.RegisterPageObject;

public class User_TC_01_Register_with_Fail_Case extends AbstractTest {
	WebDriver driver;
	String emailInvalid, passwordInvalid, confirmationpassword, password, firstname, lastname,
			confirmationpasswordmatch;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeTestCase(String browserName, String url) {
		log.info("Open User Page");
		driver = getBrowserDriver(browserName, url);
		homePage = PageManagerObject.getHomePageObject(driver);
		registerPage = (RegisterPageObject) homePage.clickToNewPage(driver,"Register");
		emailInvalid = "ngado29@";
		passwordInvalid = "12345";
		password = "123456";
		confirmationpasswordmatch = "123456";
		confirmationpassword = "123457";
		firstname = "nga";
		lastname = "huyen";

	}

	@Test
	public void TC_01_Register_Emty_Data() {
		log.info("Register with EmtyData");
		registerPage.clickToRegisterButton();
		log.info("Verify display success");
		verifyTrue(registerPage.isFirstNameTextErrorDisplay());
		verifyTrue(registerPage.isLastNameTextErrorDisplay());
		verifyTrue(registerPage.isEmailTextErrorDisplay());
		verifyTrue(registerPage.isPasswordTextErrorDisplay());
		verifyTrue(registerPage.isConfirmTextErrorDisplay());

	}

	@Test
	public void TC_02_Register_Invalid_Email() {
		registerPage.openPageUrl(driver,"https://demo.nopcommerce.com/register");
		log.info("Register with Invail Email");
		registerPage.inputToEmailTextBox(emailInvalid);
		registerPage.clickToRegisterButton();
		verifyTrue(registerPage.isEmailValidTextDisplay());
	}

	@Test
	public void TC_03_Register_Exist_Email() {
		registerPage.openPageUrl(driver,"https://demo.nopcommerce.com/register");
		log.info("Register with exist Email");
		registerPage.inputToFirstNameTextBox(firstname);
		registerPage.inputToLastNameTextBox(lastname);
		registerPage.inputToEmailTextBox(Common_TC_02_Register_Success_Case.email);
		registerPage.inputToPasswordTextBox(password);
		registerPage.inputToConfirmationPasswordTextBox(confirmationpasswordmatch);
		registerPage.clickToRegisterButton();
		verifyTrue(registerPage.isEmailExistTextDisplay());

	}

	@Test
	public void TC_04_Register_With_Invail_Password() {
		registerPage.openPageUrl(driver,"https://demo.nopcommerce.com/register");
		log.info("Register with invail password");
		registerPage.inputToPasswordTextBox(passwordInvalid);
		registerPage.clickToRegisterButton();
		verifyTrue(registerPage.isPasswordErrorDisplay());
	}

	@Test
	public void TC_05_Register_With_Password_Not_Match_Confirmation_Password() {
		registerPage.openPageUrl(driver,"https://demo.nopcommerce.com/register");
		log.info("Register with Password is not match confirmation Password");
		registerPage.inputToPasswordTextBox(password);
		registerPage.inputToConfirmationPasswordTextBox(confirmationpassword);
		registerPage.clickToRegisterButton();
		verifyTrue(registerPage.isPasswordNotMatchDisplay());

	}
	

	@AfterClass
	public void afterClass() {
		removeDriver();
	}

	HomePageObject homePage;
	RegisterPageObject registerPage;

}

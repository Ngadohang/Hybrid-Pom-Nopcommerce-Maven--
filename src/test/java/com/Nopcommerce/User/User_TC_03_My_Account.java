package com.Nopcommerce.User;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import common.AbstractTest;
import common.PageManagerObject;
import commonData.DataHelper;
import commonTestCase.Common_TC_02_Register_Success_Case;
import pageObject.Nopcommerce.User.AddressPageObject;
import pageObject.Nopcommerce.User.ChangePasswordPageObject;
import pageObject.Nopcommerce.User.HomePageObject;
import pageObject.Nopcommerce.User.LoginPageObject;
import pageObject.Nopcommerce.User.MyAccountPageObject;

public class User_TC_03_My_Account extends AbstractTest {
	WebDriver driver;
	DataHelper data;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeTestCase(String browserName, String url) {
		log.info("Open User Page");
		driver = getBrowserDriver(browserName, url);
		homePage = PageManagerObject.getHomePageObject(driver);
		loginPage = (LoginPageObject) homePage.clickToNewPage(driver, "Log in");
		loginPage.inputToLoginTextBox(Common_TC_02_Register_Success_Case.email, "Email");
		loginPage.inputToLoginTextBox(Common_TC_02_Register_Success_Case.password, "Password");
		loginPage.clickToLoginButton("Log in");
		data = new DataHelper();

	}

	@Test
	public void TC_01_Update_Info_Customer() {
		log.info("Update Infor Customer");
		homePage=PageManagerObject.getHomePageObject(driver);
		myAccoutPage = (MyAccountPageObject) homePage.clickToNewPage(driver, "My account");
		verifyTrue(myAccoutPage.isGenderInfoDisplay("Male"));
		verifyEquals(myAccoutPage.getFirstNameTextBox(), Common_TC_02_Register_Success_Case.firsname);
		verifyEquals(myAccoutPage.getLastNameTextBox(), Common_TC_02_Register_Success_Case.lastname);
		verifyEquals(myAccoutPage.getSelectionOfDay(), Common_TC_02_Register_Success_Case.birthday);
		verifyEquals(myAccoutPage.getSelectionOfMonth(), Common_TC_02_Register_Success_Case.birthmonth);
		verifyEquals(myAccoutPage.getSelectionOfYear(), Common_TC_02_Register_Success_Case.birthdayear);
		verifyEquals(myAccoutPage.getEmailTextBox(), Common_TC_02_Register_Success_Case.email);
		verifyEquals(myAccoutPage.getCompanyTextBox(), Common_TC_02_Register_Success_Case.company);
	}

	@Test
	public void TC_02_Add_Addresses_Info_Customer() {
		log.info("add new address");
		addressPage = (AddressPageObject) myAccoutPage.clickToNewPage(driver, "Addresses");
		addressPage.clickToAddNewButton();
		verifyTrue(addressPage.isTilePageDisplay());
		String firstname = addressPage.inputTextBoxAddress(data.getFirstName(), "First name:");
		String lastname = addressPage.inputTextBoxAddress(data.getLastName(), "Last name:");
		String email = addressPage.inputTextBoxAddress(data.getEmail(), "Email:");
		String conpany = addressPage.inputTextBoxAddress(data.getCompanyName(), "Company:");
		String country = addressPage.selectTextBoxAddress("Canada", "Country:");
		String state = addressPage.selectTextBoxAddress("Nova Scotia", "State / province:");
		String city = addressPage.inputTextBoxAddress(data.getCity(), "City:");
		String address1 = addressPage.inputTextBoxAddress(data.getAddress(), "Address 1:");
		String address2 = addressPage.inputTextBoxAddress(data.getAddress(), "Address 2:");
		String zipCode = addressPage.inputTextBoxAddress(data.getZinCop(), "Zip / postal code:");
		String phone = addressPage.inputTextBoxAddress(data.getPhone(), "Phone number:");
		System.out.println(phone);
		String fax = addressPage.inputTextBoxAddress(data.getFax(), "Fax number:");
		addressPage.clickSaveButton();

		verifyTrue(addressPage.isTitlePageDisplay());
		verifyTrue(addressPage.isAddressCustomerDisplay(firstname + " " + lastname));
		verifyTrue(addressPage.isInforDisplay("Email:", email));
		verifyTrue(addressPage.isInforDisplay("Phone number:", phone));
		verifyTrue(addressPage.isInforDisplay("Fax number:", fax));
		verifyTrue(addressPage.isInforDisplay(address1));
		verifyTrue(addressPage.isInforDisplay(address2));
		verifyTrue(addressPage.isInforDisplay(city + ", " + state + ", " + zipCode));
		verifyTrue(addressPage.isInforDisplay(country));

	}

	@Test
	public void TC_03_Change_Password() {
		log.info("Change password");
		changePasswordPage = (ChangePasswordPageObject) addressPage.clickToNewPage(driver, "Change password");
		changePasswordPage.inputToTextBoxPassword(Common_TC_02_Register_Success_Case.password, "Old password:");
		String passNew = data.getPassword();
		changePasswordPage.inputToTextBoxPassword(passNew, "New password:");
		changePasswordPage.inputToTextBoxPassword(passNew, "Confirm password:");
		changePasswordPage.clickToChangePasswordButton("Change password");
		log.info("log out");
		verifyTrue(changePasswordPage.isSuccessMessageDisplay());
		homePage = changePasswordPage.clickToLogoutLink("Log out");
		log.info("log in với password cũ");
		loginPage = homePage.clickToLoginLink("Log in");
		loginPage.inputToLoginTextBoxByLabel(Common_TC_02_Register_Success_Case.email, "Email:");
		loginPage.inputToLoginTextBoxByLabel(Common_TC_02_Register_Success_Case.password, "Password:");
		loginPage.clickToLoginButton("Log in");
		verifyTrue(loginPage.isErrorMessageDisplay("The credentials provided are incorrect"));
		log.info("log in với password mới");
		loginPage.clickToLoginLink("Log in");
		loginPage.inputToLoginTextBoxByLabel(Common_TC_02_Register_Success_Case.email, "Email:");
		loginPage.inputToLoginTextBoxByLabel(passNew, "Password:");
		loginPage.clickToLoginButton("Log in");
		verifyTrue(loginPage.isLoginSucessDisplay("My account"));
		verifyTrue(loginPage.isLoginSucessDisplay("Log out"));
	}

	@Test
	public void TC_04_My_Product_Review() {
		loginPage.openPageUrl(driver, "https://demo.nopcommerce.com/");
		homePage=PageManagerObject.getHomePageObject(driver);
		homePage.moveToMenu("Computers");
		homePage.clickToProductCategory("Desktops");
		verifyTrue(homePage.isCategoryTitleDisplay("Desktops"));
		homePage.clickToProductTile("Build your own computer");
		verifyTrue(homePage.isProductTitleDisplay());
		homePage.clickToAddYourReview();
		
	}

	@AfterClass
	public void afterClass() {
		// removeDriver();
	}

	HomePageObject homePage;
	LoginPageObject loginPage;
	MyAccountPageObject myAccoutPage;
	AddressPageObject addressPage;
	ChangePasswordPageObject changePasswordPage;
}

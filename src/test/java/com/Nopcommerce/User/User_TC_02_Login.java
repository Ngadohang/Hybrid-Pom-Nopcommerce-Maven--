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
import commonTestCase.Common_TC_02_Register_Success_Case;
import pageObject.Nopcommerce.User.HomePageObject;
import pageObject.Nopcommerce.User.LoginPageObject;

public class User_TC_02_Login extends AbstractTest  {
	WebDriver driver;
	
	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeTestCase(String browserName, String url) {
		log.info("Open User Page");
		driver = getBrowserDriver(browserName, url);
		homePage = PageManagerObject.getHomePageObject(driver);
		loginPage = (LoginPageObject) homePage.clickToNewPage(driver,"Log in");
		
	}
	
	@Test
	public void TC_01_Login_with_Empty_Data() {
		verifyTrue(loginPage.isLoginTitlePageDisplay());
		log.info("login with empty data");
		loginPage.clickToLoginCheckBox("RememberMe");
		loginPage.clickToLoginButton("Log in");
		verifyTrue(loginPage.isEmailErrorMessageDisplay("Please enter your email"));
	}
	
	@Test
	public void TC_02_Login_with_invalid_Email() {
		log.info("login with email wrong");
		loginPage.openPageUrl(driver, "https://demo.nopcommerce.com/login");
		loginPage.inputToLoginTextBox("ngado","Email");
		loginPage.clickToLoginButton("Log in");
		verifyTrue(loginPage.isEmailErrorMessageDisplay("Wrong email"));
		loginPage.openPageUrl(driver, "https://demo.nopcommerce.com/login");
		loginPage.inputToLoginTextBox("ngado@","Email");
		loginPage.clickToLoginButton("Log in");
		verifyTrue(loginPage.isEmailErrorMessageDisplay("Wrong email"));
		loginPage.openPageUrl(driver, "https://demo.nopcommerce.com/login");
		loginPage.inputToLoginTextBox("ngado@gmail","Email");
		loginPage.clickToLoginButton("Log in");
		verifyTrue(loginPage.isEmailErrorMessageDisplay("Wrong email"));
		loginPage.openPageUrl(driver, "https://demo.nopcommerce.com/login");
		loginPage.inputToLoginTextBox("ngado@.com","Email");
		loginPage.clickToLoginButton("Log in");
		verifyTrue(loginPage.isEmailErrorMessageDisplay("Wrong email"));
		loginPage.openPageUrl(driver, "https://demo.nopcommerce.com/login");
		loginPage.inputToLoginTextBox("nga do@gmail.com","Email");
		loginPage.clickToLoginButton("Log in");
		verifyTrue(loginPage.isEmailErrorMessageDisplay("Wrong email"));
	}
	
	@Test
	public void TC_03_Login_with_Email_Incorrect() {
		log.info("login with email incorrect");
		loginPage.openPageUrl(driver, "https://demo.nopcommerce.com/login");
		loginPage.inputToLoginTextBox("ngado@gmail.com","Email");
		loginPage.inputToLoginTextBox("123456","Password");
		loginPage.clickToLoginCheckBox("RememberMe");
		loginPage.clickToLoginButton("Log in");
		verifyTrue(loginPage.isErrorMessageDisplay("No customer account found"));
	}
	
	@Test
	public void TC_04_Login_with_Email_Correct_and_Password_Empty() {
		log.info("Login with Email correct and password empty");
		loginPage.openPageUrl(driver, "https://demo.nopcommerce.com/login");
		loginPage.inputToLoginTextBox(Common_TC_02_Register_Success_Case.email,"Email");
		loginPage.clickToLoginButton("Log in");
		loginPage.clickToLoginCheckBox("RememberMe");
		verifyTrue(loginPage.isErrorMessageDisplay("The credentials provided are incorrect"));
	}
	@Test
	public void TC_05_Login_with_Email_Correct_and_Password_Incorrect() {
		log.info("Login with email correct and incorrect");
		loginPage.openPageUrl(driver, "https://demo.nopcommerce.com/login");
		loginPage.inputToLoginTextBox(Common_TC_02_Register_Success_Case.email,"Email");
		loginPage.inputToLoginTextBox("123456","Password");
		loginPage.clickToLoginButton("Log in");
		loginPage.clickToLoginCheckBox("RememberMe");
		verifyTrue(loginPage.isErrorMessageDisplay("The credentials provided are incorrect"));
	}
	
	@Test
	public void TC_06_Login_Success_with_Email_Password() {
		log.info("Login success with email password");
		loginPage.openPageUrl(driver, "https://demo.nopcommerce.com/login");
		loginPage.inputToLoginTextBox(Common_TC_02_Register_Success_Case.email,"Email");
		loginPage.inputToLoginTextBox(Common_TC_02_Register_Success_Case.password,"Password");
		loginPage.clickToLoginButton("Log in");
		verifyTrue(loginPage.isLoginSucessDisplay("My account"));
		verifyTrue(loginPage.isLoginSucessDisplay("Log out"));
	}
	
	
	
	@AfterClass
	public void afterClass() {
		removeDriver();
	}
	
	HomePageObject homePage;
	LoginPageObject loginPage;
}

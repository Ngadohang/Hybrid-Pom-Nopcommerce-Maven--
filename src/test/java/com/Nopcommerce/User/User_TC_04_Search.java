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
import pageObject.Nopcommerce.User.SearchPageObject;

public class User_TC_04_Search extends AbstractTest {
	WebDriver driver;
	DataHelper data;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeTestCase(String browserName, String url) {
		log.info("Open User Page");
		driver = getBrowserDriver(browserName, url);
		homePage = PageManagerObject.getHomePageObject(driver);
//		loginPage = (LoginPageObject) homePage.clickToNewPage(driver, "Log in");
//		loginPage.inputToLoginTextBox(Common_TC_02_Register_Success_Case.email, "Email");
//		loginPage.inputToLoginTextBox(Common_TC_02_Register_Success_Case.password, "Password");
//		loginPage.clickToLoginButton("Log in");
//		homePage=PageManagerObject.getHomePageObject(driver);
//		data = new DataHelper();

	}

	@Test
	public void TC_01_Search_With_Data_Emty() {
		log.info("Search with Data emty");
		searchPage=homePage.clickToSearchLink("Search");
		verifyTrue(searchPage.isTitleSearchDisplay("Search"));
		searchPage.inputToSearchTextBox("", "Search keyword:");
		searchPage.clickToSearchButton();
		verifyTrue(searchPage.isMessageErrorDisplay("Search term minimum length is 3 characters"));
	}
	
	@Test
	public void TC_02_Search_With_Data_Not_Exist() {
		searchPage.refreshCurrentPage(driver);
		log.info("Search with data not exist");
		searchPage.inputToSearchTextBox("Macbook Pro 2050", "Search keyword:");
		searchPage.clickToSearchButton();
		verifyTrue(searchPage.isMessageErrorDisplay("No products were found that matched your criteria."));
	}
	
	@Test
	public void TC_03_Search_With_Product_Name_Relative() {
		searchPage.refreshCurrentPage(driver);
		log.info("Search with product name-Relative");
		searchPage.inputToSearchTextBox("Lenovo", "Search keyword:");
		searchPage.clickToSearchButton();
		verifyTrue(searchPage.areImageProductsLoaded("Lenovo"));
		verifyTrue(searchPage.isTitleProductsDisplay("Lenovo"));
		verifyTrue(searchPage.isProductDisplay("Lenovo IdeaCentre 600 All-in-One PC","Lenovo IdeaCentre 600 All-in-One PC","100%","$500.00"));
		verifyTrue(searchPage.isProductDisplay("Lenovo Thinkpad X1 Carbon Laptop","Lenovo Thinkpad X1 Carbon Laptop","80%","$1,360.00"));
		
	}

	@Test
	public void TC_04_Search_With_Product_Name_Absolute() {
		searchPage.refreshCurrentPage(driver);
		log.info("Search with product name-Absolute");
		searchPage.inputToSearchTextBox("ThinkPad X1 Carbon", "Search keyword:");
		searchPage.clickToSearchButton();
		verifyTrue(searchPage.areImageProductsLoaded("Thinkpad X1 Carbon"));
		verifyTrue(searchPage.isTitleProductsDisplay("Thinkpad X1 Carbon"));
		
	}
	
	@Test
	public void TC_05_Advanced_Search_With_Parent_Categories() {
		searchPage.refreshCurrentPage(driver);
		log.info("Search with advanced search with parent categories");
		searchPage.inputToSearchTextBox("Apple MacBook Pro", "Search keyword:");
		searchPage.clickToAbvancedCheckbox();
		searchPage.selectToCategory("Computers");
		searchPage.clickToSearchButton();
		verifyTrue(searchPage.isMessageErrorDisplay("No products were found that matched your criteria."));
	}
	
	@Test
	public void TC_06_Advanced_Search_Sub_Categories() {
		searchPage.refreshCurrentPage(driver);
		log.info("Search with advanced search with sub categories");
		searchPage.inputToSearchTextBox("Apple MacBook Pro", "Search keyword:");
		searchPage.clickToAbvancedCheckbox();
		searchPage.selectToCategory("Computers");
		searchPage.clickToAutoCheckBox();
		searchPage.clickToSearchButton();
		verifyTrue(searchPage.areImageProductsLoaded("Apple MacBook Pro 13-inch"));
		verifyTrue(searchPage.isTitleProductsDisplay("Apple MacBook Pro 13-inch"));
		
	}
	
	@Test
	public void TC_07_Advanced_Search_Incorrect_Manufacturer() {
		searchPage.refreshCurrentPage(driver);
		log.info("Search with advanced search with incorrect manufacturer");
		searchPage.inputToSearchTextBox("Apple MacBook Pro", "Search keyword:");
		searchPage.clickToAbvancedCheckbox();
		searchPage.selectToCategory("Computers");
		searchPage.clickToAutoCheckBox();
		searchPage.selectToManufacturer("HP");
		searchPage.clickToSearchButton();
		verifyTrue(searchPage.isMessageErrorDisplay("No products were found that matched your criteria."));
	}
	
	
	@Test
	public void TC_08_Advanced_Search_Correct_Manufacturer() {
		searchPage.refreshCurrentPage(driver);
		log.info("Search with advanced search with correct manufacturer");
		searchPage.inputToSearchTextBox("Apple MacBook Pro", "Search keyword:");
		searchPage.clickToAbvancedCheckbox();
		searchPage.selectToCategory("Computers");
		searchPage.clickToAutoCheckBox();
		searchPage.selectToManufacturer("Apple");
		searchPage.clickToSearchButton();
		verifyTrue(searchPage.areImageProductsLoaded("Apple MacBook Pro 13-inch"));
		verifyTrue(searchPage.isTitleProductsDisplay("Apple MacBook Pro 13-inch"));
		
	}
	@Test
	public void TC_09_Advanced_Search_In_Price_Range() {
		searchPage.refreshCurrentPage(driver);
		log.info("Search with advanced in price range");
		searchPage.inputToSearchTextBox("Apple MacBook Pro", "Search keyword:");
		searchPage.clickToAbvancedCheckbox();
		searchPage.selectToCategory("Computers");
		searchPage.clickToAutoCheckBox();
		searchPage.selectToManufacturer("Apple");
		searchPage.inputToPriceFromTexBox("1000");
		searchPage.inputToPriceToTextBox("2000");
		searchPage.clickToSearchButton();
		verifyTrue(searchPage.areImageProductsLoaded("Apple MacBook Pro 13-inch"));
		verifyTrue(searchPage.isTitleProductsDisplay("Apple MacBook Pro 13-inch"));
	}
	
	@Test
	public void TC_10_Advanced_Search_Price_Range_Lower_Product_Price() {
		searchPage.refreshCurrentPage(driver);
		log.info("Search with advanced price range lower product price");
		searchPage.inputToSearchTextBox("Apple MacBook Pro", "Search keyword:");
		searchPage.clickToAbvancedCheckbox();
		searchPage.selectToCategory("Computers");
		searchPage.clickToAutoCheckBox();
		searchPage.selectToManufacturer("Apple");
		searchPage.inputToPriceFromTexBox("1000");
		searchPage.inputToPriceToTextBox("1700");
		searchPage.clickToSearchButton();
		verifyTrue(searchPage.isMessageErrorDisplay("No products were found that matched your criteria."));
	}
	@Test
	public void TC_11_Advanced_Search_Price_Range_Higher_Product_Price() {
		searchPage.refreshCurrentPage(driver);
		log.info("Search with advanced price range higher product price");
		searchPage.inputToSearchTextBox("Apple MacBook Pro", "Search keyword:");
		searchPage.clickToAbvancedCheckbox();
		searchPage.selectToCategory("Computers");
		searchPage.clickToAutoCheckBox();
		searchPage.selectToManufacturer("Apple");
		searchPage.inputToPriceFromTexBox("1900");
		searchPage.inputToPriceToTextBox("5000");
		searchPage.clickToSearchButton();
		verifyTrue(searchPage.isMessageErrorDisplay("No products were found that matched your criteria."));
	}

	@AfterClass
	public void afterClass() {
		 removeDriver();
	}

	HomePageObject homePage;
	LoginPageObject loginPage;
	SearchPageObject searchPage;
}

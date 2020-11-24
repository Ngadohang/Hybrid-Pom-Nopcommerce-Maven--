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
import pageObject.Nopcommerce.User.ProductListPageObject;
import pageObject.Nopcommerce.User.SearchPageObject;

public class User_TC_05_Sort_Display_Pading extends AbstractTest {
	WebDriver driver;
	DataHelper data;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeTestCase(String browserName, String url) {
		log.info("Open User Page");
		driver = getBrowserDriver(browserName, url);
		homePage = PageManagerObject.getHomePageObject(driver);
		homePage.moveToMenu("Computers");
		productListPage=homePage.clickToSubMenu("Notebooks");
		
		
	}

	@Test
	public void TC_01_Sort_With_Name_A_Z() {
		log.info("Name is sorted by A-Z");
		
		verifyTrue(productListPage.isBreadCrumbDisplay("Computers","Notebooks"));
		verifyTrue(productListPage.isNoteBookDisplay("Notebooks"));
		productListPage.selectToSortName("Name: A to Z");
		verifyTrue(productListPage.isNameSortedAscending());
	}
	@Test
	public void TC_02_Sort_With_Name_Z_A() {
		log.info("Name is sorted by Z-A");
		productListPage.selectToSortName("Name: Z to A");
		verifyTrue(productListPage.isNameSortedDescending());
	}
	@Test
	public void TC_03_Sort_With_Low_To_High() {
		log.info("Price is sorted by low to high");
		productListPage.selectToSortName("Price: Low to High");
		verifyTrue(productListPage.isPriceSortedLowToHigh());
	}
	@Test
	public void TC_04_Sort_With_High_To_Low() {
		log.info("Price is sorted by high to low");
		productListPage.selectToSortName("Price: High to Low");
		verifyTrue(productListPage.isPriceSortedHighToLow());
	}
	@Test
	public void TC_05_Dispay_3_Product_On_Page() {
		log.info("Display 3 product on page");
		productListPage.openPageUrl(driver, "https://demo.nopcommerce.com/notebooks");
		productListPage.selectToNumberPerPage("3");
		verifyTrue(productListPage.isHowNumberProductOnPage(3));
		verifyTrue(productListPage.isNextButtonDisplay());
		productListPage.clickToCurrentPage("2");
		verifyTrue(productListPage.isPreviousButtonDisplay());
		
	}
	@Test
	public void TC_06_Dispay_6_Product_On_Page() {
		log.info("Display 6 product on page");
		productListPage.selectToNumberPerPage("6");
		verifyTrue(productListPage.isHowNumberProductOnPage(6));
		verifyTrue(productListPage.isNextButtonNoDisplay());
		verifyTrue(productListPage.isPreviousButtonNoDisplay());
		
	}
	@Test
	public void TC_07_Dispay_9_Product_On_Page() {
		log.info("Display 9 product on page");
		productListPage.selectToNumberPerPage("9");
		verifyTrue(productListPage.isHowNumberProductOnPage(9));
		verifyTrue(productListPage.isNextButtonNoDisplay());
		verifyTrue(productListPage.isPreviousButtonNoDisplay());
		
	}

	@AfterClass
	public void afterClass() {
		 removeDriver();
	}

	HomePageObject homePage;
	LoginPageObject loginPage;
	SearchPageObject searchPage;
	ProductListPageObject productListPage;
}

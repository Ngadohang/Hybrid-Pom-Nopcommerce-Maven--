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
import pageObject.Nopcommerce.User.CartPageObject;
import pageObject.Nopcommerce.User.ChangePasswordPageObject;
import pageObject.Nopcommerce.User.ComparePageObject;
import pageObject.Nopcommerce.User.HomePageObject;
import pageObject.Nopcommerce.User.LoginPageObject;
import pageObject.Nopcommerce.User.MyAccountPageObject;
import pageObject.Nopcommerce.User.ProductDetailPageObject;
import pageObject.Nopcommerce.User.ProductListPageObject;
import pageObject.Nopcommerce.User.SearchPageObject;
import pageObject.Nopcommerce.User.WishListPageObject;

public class User_TC_06_Wishlist_Compare_Recent_Review extends AbstractTest {
	WebDriver driver;
	DataHelper data;
	String delivery, SKU, Processor, RAM, HDD, OS, Software, price, title, image;

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
		homePage = PageManagerObject.getHomePageObject(driver);
		homePage.moveToMenu("Computers");
		productListPage = homePage.clickToSubMenu("Desktops");
		productDetailPage = productListPage.clickToProductDetail("Build your own computer");

		title = productDetailPage.getProductName();
		SKU = productDetailPage.getSkuInfo();
		Processor = productDetailPage.setAttributeTypeSelect("2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00]",
				"Processor");
		RAM = productDetailPage.setAttributeTypeSelect("4GB [+$20.00]", "RAM");
		HDD = productDetailPage.setAttributeTypeRadio("HDD", "400 GB [+$100.00]");
		OS = productDetailPage.setAttributeTypeRadio("OS", "Vista Premium [+$60.00]");
		Software=productDetailPage.setAttributeTypeCheckbox("Software", "Acrobat Reader [+$10.00]");
		price = productDetailPage.getPriceProduct();
		image = productDetailPage.getImageProduct();
	}

	@Test
	public void TC_01_Add_To_Wishlist() {
		log.info("Add product to wishlist");
		verifyEquals(productDetailPage.getNumberProductOnWishlist(), 0);
		wishListPage = productDetailPage.clickToWishlistLinkOnMenu();
		verifyTrue(wishListPage.isWishlistEmptyDisplay());
		wishListPage.backToPage(driver);
		HDD = productDetailPage.setAttributeTypeRadio("HDD", "320 GB");
		productDetailPage.setAttributeTypeCheckbox("Software", "Acrobat Reader [+$10.00]");
		Software = productDetailPage.setAttributeTypeCheckbox("Software", "Acrobat Reader [+$10.00]");
		price = productDetailPage.getPriceProduct();
		productDetailPage.clickToWishlistButton();
		verifyTrue(productDetailPage.isWishlistSuccessMessageDisplay());
		wishListPage = productDetailPage.clickToWishListLink();
		verifyTrue(wishListPage.isTitleWishlistDisplay());
		log.info("Check wish list on menu");
		verifyEquals(wishListPage.getNumberProductOnWishlist(), 1);
		log.info("check Sku info on wish list");
		verifyTrue(wishListPage.isSkuDisplayedToWishlist(title, SKU));
		log.info("check image info on wish list");
		verifyTrue(wishListPage.getImageOnWishlist(title).contains(image));
		log.info("check product info on wish list");
		verifyTrue(wishListPage.isProductInfoDisplay(Processor, RAM, HDD, OS, Software, title));
		log.info("check price info on wish list");
		verifyEquals(wishListPage.getPriceOnWishlist(title), price);
		wishListPage.clickToMyWishList();
		verifyTrue(wishListPage.getTitleMyWishlist()
				.contains(Common_TC_02_Register_Success_Case.firsname));
		verifyTrue(wishListPage.getTitleMyWishlist()
				.contains(Common_TC_02_Register_Success_Case.lastname));
	}

	@Test
	public void TC_02_Add_Product_To_Cart_Form_Wish_List() {
		wishListPage.clickToAddToCartCheckBox(title);
		cartPage = wishListPage.clickToAddToCartButton();
		log.info("open cart page success");
		verifyTrue(cartPage.isTitleCartPageDisplay());
		log.info("check add product to shopping cart success");
		verifyEquals(cartPage.getNumberProductOnCart(),1);
		log.info("check product is removed to Wishlist");
		verifyEquals(cartPage.getNumberProductOnWishlist(), 0);
		System.out.println(cartPage.getNumberProductOnWishlist());
		log.info("verify sản phẩm được thêm vào shopping cart");
		log.info("check Sku info on shopping cart");
		verifyTrue(cartPage.isSkuDisplayedToShoppingCart(title, SKU));
		log.info("check image info on wish list");
		verifyTrue(cartPage.getImageToShopCart(title).contains(image));
		log.info("check product info on wish list");
		verifyTrue(cartPage.isProductInfoDisplay(Processor, RAM, HDD, OS, Software, title));
		log.info("check price info on wish list");
		verifyEquals(cartPage.getPriceToShopCart(title), price);

	}

	@Test
	public void TC_03_Remove_Product_In_Wish_List() {
		log.info("Remove product in wishlist");
		cartPage.moveToMenu("Electronics");
		productListPage = cartPage.clickToSubMenu("Cell phones");
		productDetailPage = productListPage.clickToProductDetail("HTC One M8 Android L 5.0 Lollipop");
		productDetailPage.clickToWishlistButton();
		wishListPage = productDetailPage.clickToWishListLink();
		wishListPage.clickToRemoveProductInWishlist("HTC One M8 Android L 5.0 Lollipop");
		wishListPage.clickToUpdateWishlistButton();
		verifyTrue(wishListPage.isWishlistEmptyDisplay());
	}

	@Test
	public void TC_04_Add_Product_To_Compare() {
		log.info("Add product to compare");
		wishListPage.moveToMenu("Computers");
		productListPage = wishListPage.clickToSubMenu("Software");
		String priceSouFor = productListPage.clickToComparelistButton("Sound Forge Pro 11 (recurring)");
		String imageProSouFor = productListPage.getImageProduct("Sound Forge Pro 11 (recurring)");
		String priceWin = productListPage.clickToComparelistButton("Windows 8 Pro");
		String imageWin = productListPage.getImageProduct("Windows 8 Pro");
		comparePage = productListPage.clickToComparelistlink();
		verifyTrue(comparePage.isProductDisplayedOnComparelist("Sound Forge Pro 11 (recurring)",
				"Sound Forge Pro 11 (recurring)", priceSouFor));
		verifyTrue(comparePage.isImageProductDispayedOnComparelist("Sound Forge Pro 11 (recurring)")
				.contains(imageProSouFor));
		verifyTrue(comparePage.isProductDisplayedOnComparelist(imageWin, "Windows 8 Pro", priceWin));
		comparePage.clickClearlistButton();
		verifyTrue(comparePage.isComparelistEmpty());

	}

	@Test
	public void TC_05_Recently_View_Products() {
		
	}

	@AfterClass
	public void afterClass() {
		// removeDriver();
	}

	HomePageObject homePage;
	LoginPageObject loginPage;
	SearchPageObject searchPage;
	ProductListPageObject productListPage;
	ProductDetailPageObject productDetailPage;
	WishListPageObject wishListPage;
	CartPageObject cartPage;
	ComparePageObject comparePage;
}

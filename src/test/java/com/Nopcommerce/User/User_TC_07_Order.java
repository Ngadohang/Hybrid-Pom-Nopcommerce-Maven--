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
import pageObject.Nopcommerce.User.UpdateCartPageObject;
import pageObject.Nopcommerce.User.WishListPageObject;

public class User_TC_07_Order extends AbstractTest {
	WebDriver driver;
	DataHelper data;
	String delivery, SKU, Processor, RAM, HDD, OS, Software1, Software2,title, image,Software0;
	Double price;
	int count=0;
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
	}

	@Test
	public void TC_01_Add_Product_To_Cart() {
		title = productDetailPage.getProductName();
		SKU = productDetailPage.getSkuInfo();
		Processor = productDetailPage.setAttributeTypeSelect("2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00]",
				"Processor");
		RAM = productDetailPage.setAttributeTypeSelect("8GB [+$60.00]", "RAM");
		HDD = productDetailPage.setAttributeTypeRadio("HDD", "400 GB [+$100.00]");
		OS = productDetailPage.setAttributeTypeRadio("OS", "Vista Premium [+$60.00]");
		Software1 = productDetailPage.setAttributeTypeCheckbox("Software", "Acrobat Reader [+$10.00]");
		Software2 = productDetailPage.setAttributeTypeCheckbox("Software", "Total Commander [+$5.00]");
		Software0="Microsoft Office [+$50.00]";
		price = productDetailPage.getFloatPriceProduct();
		String priceText= productDetailPage.changePriceToPriceText(price);
		image = productDetailPage.getImageProduct();
		productDetailPage.clickToAddToCartButton();
		count=productDetailPage.isShoppingCartLinkDisplay(count);
		log.info("quantity product on menu link shop cart");
		verifyEquals(productDetailPage.getNumberProductOnCartLink(), count);		
		String total=productDetailPage.changePriceToPriceNew(price,count);
		productDetailPage.clickToCloseButton();
		productDetailPage.moveToCartLink();
		log.info("quantity product in popup shop cart");
		verifyTrue(productDetailPage.isNoteItemSizeDisplay(String.valueOf(count)));
		log.info("verify product info in ");
		
		verifyTrue(productDetailPage.isProductInfoDislayedPopup(image,title,Processor,RAM,HDD,OS,Software0,Software1,Software2,priceText,String.valueOf(count),total));
	}
	
	@Test
	public void TC_02_Edit_Product_In_Shop_Cart() {
		log.info("Go to cart");
		cartPage=productDetailPage.clickToGoToCart();
		updateCartPage=cartPage.clickToEditLink();
		String editProcessor=updateCartPage.setAttributeTypeSelect("2.2 GHz Intel Pentium Dual-Core E2200",
				"Processor");
		String editRAM=updateCartPage.setAttributeTypeSelect("4GB [+$20.00]", "RAM");
		String edittHDD=updateCartPage.setAttributeTypeRadio("HDD", "320 GB");
		String editOS=updateCartPage.setAttributeTypeRadio("OS", "Vista Home [+$50.00]");
		updateCartPage.uncheckAttributeTypeCheckbox("Software", "Acrobat Reader [+$10.00]");
		updateCartPage.uncheckAttributeTypeCheckbox("Software", "Total Commander [+$5.00]");
		price = updateCartPage.getPriceProduct();
		updateCartPage.clickToUpdateCartButton();
		cartPage=updateCartPage.clickToMoveCartPage();
		log.info("verify Sku pro in shop cart");
		verifyTrue(cartPage.isSkuDisplayedToShoppingCart(title, SKU));
		log.info("verify image pro in shop cart");
		verifyTrue(cartPage.getImageToShopCart(title).contains(image));
		log.info("verify pro info in shop cart");
		verifyTrue(cartPage.isProductInfoDisplay(editProcessor, editRAM, edittHDD, editOS, Software0, title));
		log.info("verify price pro in shop cart");
		String priceText= cartPage.changePriceToPriceText(price);
		verifyEquals(cartPage.getPriceToShopCart(title), priceText);
		log.info("verify quantity defauls pro in shop cart");
		verifyEquals(cartPage.getValueQuantityProInCart(title),"1");
		int quantity=cartPage.inputToQuantityProInCart("2",title);
		cartPage.clickToUpdateCartButton();
		String total=cartPage.calculateTotal(price,quantity);
		verifyEquals(cartPage.getTotalProduct(title), total);
	}
	@Test
	public void TC_03_Remove_From_Cart() {
		log.info("remove pro from cart");
		cartPage.clickToRemoveCheckbox(title);
		cartPage.clickToUpdateCartButton();
		log.info("cart is empty");
		verifyTrue(cartPage.isCartEmptyMessageDispay());
		log.info("pro undisplay in cart");
		verifyTrue(cartPage.isProUnDisplayInCart());
		log.info("popup cart is empty");
		verifyTrue(cartPage.isProSizeInShopCartPopup(0));
		cartPage.moveToShopCartLinkInMenu(0);
		verifyTrue(cartPage.isNoItemsInCartMessageDisplay());
	}
	
	@Test
	public void TC_04_Update_Cart() {
		log.info("update quantity cart");
		cartPage.inputToSearchTextBox("Lenovo IdeaCentre 600 All-in-One PC");
		searchPage=cartPage.clickToSearchButton();
		price=searchPage.getPriceProduct("Lenovo IdeaCentre 600 All-in-One PC");
		searchPage.clickToAddToCartButton("Lenovo IdeaCentre 600 All-in-One PC");
		cartPage=searchPage.clickToShoppingCartLink();
		int quantity=cartPage.inputToQuantityProInCart("6", "Lenovo IdeaCentre 600 All-in-One PC");
		cartPage.clickToUpdateCartButton();
		String total=cartPage.calculateTotal(price,quantity);
		verifyEquals(cartPage.getTotalProduct("Lenovo IdeaCentre 600 All-in-One PC"), total);
	}
	
	@Test
	public void TC_05_Order() {
		cartPage.clickToRemoveCheckbox("Lenovo IdeaCentre 600 All-in-One PC");
		cartPage.clickToUpdateCartButton();
		cartPage.inputToSearchTextBox("Apple MacBook Pro 13-inch");
		searchPage=cartPage.clickToSearchButton();
		productDetailPage=searchPage.clickToAddToCartButton("Apple MacBook Pro 13-inch");
		productDetailPage.clickToAddToCartButton();
		cartPage=productDetailPage.clickToShoppingCartLink();
		String giftWrap=cartPage.setGiftWrapping("Yes [+$10.00]");
		cartPage.clickToEstimateShipping();
		String country= cartPage.setCountryToShipping("Viet Nam");
		String state= cartPage.setStateToShipping("Other");
		String zipcode=cartPage.inputToZipCodeToShipping(data.getZinCop());
		String priceShip=cartPage.clickToShippingMethod("Next Day Air");
		cartPage.clickToAppyButton();
		verifyTrue(cartPage.isInforShipDisplay(giftWrap,"Next Day Air","$3,610.00",priceShip,"$3,610.00"));
		verifyTrue(cartPage.isYouWillEarnNoteDispay("361"));
		cartPage.clickToIagreeCheckBox();
		cartPage.clickToCheckOutButton();
		
	}

	@AfterClass
	public void afterClass() {
		removeDriver();
	}

	HomePageObject homePage;
	LoginPageObject loginPage;
	SearchPageObject searchPage;
	ProductListPageObject productListPage;
	ProductDetailPageObject productDetailPage;
	WishListPageObject wishListPage;
	CartPageObject cartPage;
	ComparePageObject comparePage;
	UpdateCartPageObject updateCartPage;
}

package common;

import org.openqa.selenium.WebDriver;

import pageObject.Nopcommerce.User.AddressPageObject;
import pageObject.Nopcommerce.User.CartPageObject;
import pageObject.Nopcommerce.User.ChangePasswordPageObject;
import pageObject.Nopcommerce.User.ComparePageObject;
import pageObject.Nopcommerce.User.HomePageObject;
import pageObject.Nopcommerce.User.LoginPageObject;
import pageObject.Nopcommerce.User.MyAccountPageObject;
import pageObject.Nopcommerce.User.MyReviewProductPageObject;
import pageObject.Nopcommerce.User.ProductCategoryPageObject;
import pageObject.Nopcommerce.User.ProductDetailPageObject;
import pageObject.Nopcommerce.User.ProductListPageObject;
import pageObject.Nopcommerce.User.RegisterPageObject;
import pageObject.Nopcommerce.User.SearchPageObject;
import pageObject.Nopcommerce.User.UpdateCartPageObject;
import pageObject.Nopcommerce.User.WishListPageObject;

public class PageManagerObject {
	
	public static HomePageObject getHomePageObject(WebDriver driver) {
		return new HomePageObject(driver);
	}
	public static RegisterPageObject getRegisterPageObject(WebDriver driver) {
		return new RegisterPageObject(driver);
	}
	public static LoginPageObject getLoginPageObject(WebDriver driver) {
		return new LoginPageObject(driver);
	}
	public static MyAccountPageObject getMyAccountPageObject(WebDriver driver) {
		return new MyAccountPageObject(driver);
	}
	public static AddressPageObject getAddressPageObject(WebDriver driver) {
		return new AddressPageObject(driver);
	}
	public static MyReviewProductPageObject getMyReviewProductPageObject(WebDriver driver) {
		return new MyReviewProductPageObject(driver);
	}
	public static ChangePasswordPageObject getChangePasswordPageObject(WebDriver driver) {
		return new ChangePasswordPageObject(driver);
	}
	public static ProductCategoryPageObject getProductCategoryPageObject(WebDriver driver) {
		return new ProductCategoryPageObject(driver);
	}
	public static ProductListPageObject getProductListPageObject(WebDriver driver) {
		return new ProductListPageObject(driver);
	}
	public static ProductDetailPageObject getProductDetailPageObject(WebDriver driver) {
		return new ProductDetailPageObject(driver);
	}
	public static SearchPageObject getSearchPageObject(WebDriver driver) {
		return new SearchPageObject(driver);
	}
	public static WishListPageObject getWishListPageObject(WebDriver driver) {
		return new WishListPageObject(driver);
	}
	public static CartPageObject getCartPageObject(WebDriver driver) {
		return new CartPageObject(driver);
	}
	public static ComparePageObject getComparePageObject(WebDriver driver) {
		return new ComparePageObject(driver);
	}
	public static UpdateCartPageObject getUpdateCartPageObject(WebDriver driver) {
		return new UpdateCartPageObject(driver);
	}
	
}

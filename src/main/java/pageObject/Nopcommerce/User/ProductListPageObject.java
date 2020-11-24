package pageObject.Nopcommerce.User;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.google.common.base.FinalizableReferenceQueue;

import common.AbstractPage;
import common.PageManagerObject;
import net.bytebuddy.utility.privilege.GetSystemPropertyAction;
import pageUI.Nopcommerce.User.AbstractPageUser;
import pageUI.Nopcommerce.User.ProductDetailPageUI;
import pageUI.Nopcommerce.User.ProductListPageUI;

public class ProductListPageObject extends AbstractPage {
	private WebDriver driver;
	public ProductListPageObject(WebDriver driver) {
		this.driver=driver;
	}
	public boolean isBreadCrumbDisplay(String...value) {
		return isElementDisplay(driver, AbstractPageUser.DYNAMIC_BREADCRUMB_PRODUCT_LIST,value);
	}
	public boolean isNoteBookDisplay(String value) {
		return isElementDisplay(driver, AbstractPageUser.DYNAMIC_TITLE, value);
	}
	public void selectToSortName(String value) {
		waitForElementVisible(driver, ProductListPageUI.SORT_SELECT);
		selectItemInDropdownDefault(driver, ProductListPageUI.SORT_SELECT, value);
	}
	public boolean isNameSortedAscending() {
		return isDataStringSortedAscending(driver, ProductListPageUI.TITLE_PRODUCT);
	}
	public boolean isNameSortedDescending() {
		return isDataStringSortedDescending(driver,ProductListPageUI.TITLE_PRODUCT);
	}
	public boolean isPriceSortedLowToHigh() {
		return isDataFloatSortedAscending(driver, ProductListPageUI.PRICE_PRODUCT_LIST);
	}
	public void selectToNumberPerPage(String value) {
		waitForElementVisible(driver, ProductListPageUI.PAGING_SELECT);
		selectItemInDropdownDefault(driver, ProductListPageUI.PAGING_SELECT, value);
	}
	public boolean isNextButtonDisplay() {
		return isElementDisplay(driver, ProductListPageUI.NEXT_BUTTON);
	}
	public boolean isPreviousButtonDisplay() {
		return isElementDisplay(driver, ProductListPageUI.PREVIOUS_BUTTON);
	}
	public boolean isNextButtonNoDisplay() {
		return isElementUnDisplayExistDom(driver, ProductListPageUI.NEXT_BUTTON);
	}
	public boolean isPreviousButtonNoDisplay() {
		return isElementUnDisplayExistDom(driver,  ProductListPageUI.NEXT_BUTTON);
	}
	public boolean isPriceSortedHighToLow() {
		return isDataFloatSortedDescending(driver, ProductListPageUI.PRICE_PRODUCT_LIST);
	}
	public boolean isHowNumberProductOnPage(int i) {
		boolean status =false;
		int elementSize=  findElementsByXpath(driver, ProductListPageUI.TITLE_PRODUCT).size();
		if(elementSize<=i) {
			status=true;
		}else {status=false;}
		return status;
	}
	public void clickToCurrentPage(String value) {
		waitToElementClickable(driver, ProductListPageUI.DYNAMIC_PAGING_NUMBER, value);
		clickToElement(driver, ProductListPageUI.DYNAMIC_PAGING_NUMBER, value);
	}
	public ProductDetailPageObject clickToProductDetail(String value) {
		waitToElementClickable(driver, ProductListPageUI.DYNAMIC_TITLE_PRODUCT, value);
		clickToElement(driver, ProductListPageUI.DYNAMIC_TITLE_PRODUCT, value);
		return PageManagerObject.getProductDetailPageObject(driver);
	}
	public String clickToComparelistButton(String...value) {
		waitToElementClickable(driver, ProductListPageUI.COMPARE_LIST_BUTTON, value);
		clickToElement(driver, ProductListPageUI.COMPARE_LIST_BUTTON, value);
		return getTextElement(driver, ProductListPageUI.PRICE_PRODUCT_BY_NAME, value);
	}
	public ComparePageObject clickToComparelistlink() {
		waitToElementClickable(driver, ProductListPageUI.COMPARE_LIST_LINK);
		clickToElement(driver, ProductListPageUI.COMPARE_LIST_LINK);
		return PageManagerObject.getComparePageObject(driver);
	}
	public String getImageProduct(String value) {
		waitForElementVisible(driver, ProductListPageUI.IMAGE_PRODUCT_BY_NAME,value);
		String imageSrc = getElementAttribute(driver, ProductListPageUI.IMAGE_PRODUCT_BY_NAME, "src",value);
		String[] listSrc = imageSrc.split("_");
		String imageSrcNew = listSrc[0];
		return imageSrcNew;
	}
	

}

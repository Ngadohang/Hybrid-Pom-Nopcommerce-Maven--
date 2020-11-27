package com.Nopcommerce.Admin;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.AbstractPage;
import common.AbstractTest;
import common.PageManagerObject;
import commonData.DataHelper;
import commonData.DataJson;
import pageObject.Nopcommerce.Admin.EditAddressAdminPageObject;
import pageObject.Nopcommerce.Admin.EditCustomerAdminPageObject;
import pageObject.Nopcommerce.Admin.EditProductDetailAdminPageObject;
import pageObject.Nopcommerce.Admin.HomeAdminPageObject;
import pageObject.Nopcommerce.Admin.LoginPageObjectAdmin;
import pageObject.Nopcommerce.Admin.NewAddressAdminPageObject;
import pageObject.Nopcommerce.Admin.NewCustomerAdminPageObject;
import pageObject.Nopcommerce.Admin.ProductAdminPageObject;
import pageObject.Nopcommerce.User.CustomerAdminPageObject;

public class Admin extends AbstractTest {
	WebDriver driver;
	DataJson dataJ;
	DataHelper dataF;
	String email, firstName, lastName, company;
	String emailedit, firstNameedit, lastNameedit, companyedit;

	@Parameters({"browser", "url", "loginData"})
	@BeforeClass
	public void beforeTest(String browserName, String url, String dataLogin) {
		driver = getBrowserDriver(browserName, url);
		loginPageAdmin = PageManagerObject.getLoginPageObjectAdmin(driver);
		dataF = DataHelper.getData();
		dataJ= DataJson.get(dataLogin);
		loginPageAdmin.inputToEmail(dataJ.getEmail());
		loginPageAdmin.inputToPassword(dataJ.getPassword());
		homePageAdmin = loginPageAdmin.clickToLoginButton();
	}

	@Test
	public void TC_01_Search_with_Product_Name() {
		log.info("Search with product name");
		homePageAdmin.clickToMenu("Catalog");
		homePageAdmin.clickToSubMenu("Products");
		productPageAdmin = PageManagerObject.getProductAdminPageObject(driver);
		productPageAdmin.inputToProductName("Lenovo IdeaCentre 600 All-in-One PC");
		productPageAdmin.clickToSearchButton();
		log.info("check info product dislay on table");
		verifyTrue(productPageAdmin.isProductInfoDislayed("Lenovo IdeaCentre 600 All-in-One PC", "LE_IC_600", "500",
				"10000", "Simple"));
	}

	@Test
	public void TC_02_Search_With_ProductName_ParentCategory_UncheckedSubCategories() {
		log.info("Search with product name, parent category, unchecked subcategories");
		productPageAdmin.inputToProductName("Lenovo IdeaCentre 600 All-in-One PC");
		productPageAdmin.selectToCategory("Computers");
		productPageAdmin.clickToSearchButton();
		log.info("check no product dislayed");
		verifyTrue(productPageAdmin.isNoDateMessageDisplayed());
	}

	@Test
	public void TC_03_Search_with_ProductName_ParentCategory_CheckedSubCatagories() {
		log.info("Search with product name, parent category, checked subcategories");
		productPageAdmin.inputToProductName("Lenovo IdeaCentre 600 All-in-One PC");
		productPageAdmin.selectToCategory("Computers");
		productPageAdmin.clickToSearchSubCategoriesCheckbox();
		productPageAdmin.clickToSearchButton();
		log.info("check info pro display");
		verifyTrue(productPageAdmin.isProductInfoDislayed("Lenovo IdeaCentre 600 All-in-One PC", "LE_IC_600", "500",
				"10000", "Simple"));
	}

	@Test
	public void TC_04_Search_with_ProductName_ChildCategory_UncheckedSubCategories() {
		log.info("Search with product name, parent category, unchecked subcategories");
		productPageAdmin.inputToProductName("Lenovo IdeaCentre 600 All-in-One PC");
		productPageAdmin.selectToCategory("Computers");
		productPageAdmin.clickToSubCategoriesCheckboxed();
		productPageAdmin.clickToSearchButton();
		log.info("check info pro display");
		verifyTrue(productPageAdmin.isNoDateMessageDisplayed());
	}

	@Test
	public void TC_05_Search_with_ProductName_Manufacturer() {
		log.info("Search with product name, manufacturer");
		productPageAdmin.inputToProductName("Lenovo IdeaCentre 600 All-in-One PC");
		productPageAdmin.selectToManufacturer("Apple");
		productPageAdmin.clickToSearchSubCategoriesCheckbox();
		productPageAdmin.clickToSearchButton();
		log.info("check info pro display");
		verifyTrue(productPageAdmin.isNoDateMessageDisplayed());

	}

	@Test
	public void TC_06_Go_to_directly_To_Product() {
		log.info("Search with product name, manufacturer");
		productPageAdmin.inputToProductSku("LE_IC_600");
		editProductDetailAdminPage=productPageAdmin.clickToGoToProductSku();
		verifyTrue(editProductDetailAdminPage.isEditProductDetailTitleDisplay("Lenovo IdeaCentre 600 All-in-One PC"));
		editProductDetailAdminPage.clickToProductInfoLayout();
		verifyEquals(editProductDetailAdminPage.getProductNameTextBox(),"Lenovo IdeaCentre 600 All-in-One PC");
	}

	@Test
	public void TC_07_Create_New_Customer() {
		log.info("Create New Customer");
		driver.get("https://admin-demo.nopcommerce.com/Admin");
		homePageAdmin=PageManagerObject.getHomeAdminPageObject(driver);
		homePageAdmin.clickToCustomerCatagory();
		homePageAdmin.clickToSubMenu("Customers");
		customerAdminPage=PageManagerObject.getCustomerAdminPageObject(driver);
		newCustomerAdminPage = customerAdminPage.clickToAddNewCustomer();
		log.info("go to add new customer page");
		verifyTrue(newCustomerAdminPage.isTitlePageDispayed());
		email = newCustomerAdminPage.inputToEmailTextBox(dataF.getEmail());
		newCustomerAdminPage.inputToPasswordTextBox(dataF.getPassword());
		firstName = newCustomerAdminPage.inputToFirstNameTextBox(dataF.getFirstName());
		lastName = newCustomerAdminPage.inputToLastNameTextBox(dataF.getLastName());
		newCustomerAdminPage.clickToGenderCheckBox("Male");
		newCustomerAdminPage.inputToDateTimeTextBox("08/20/1995");
		company = newCustomerAdminPage.inputToCompanyTextBox(dataF.getCompanyName());
		newCustomerAdminPage.clickToIsTaxExemptCheckBox();
		newCustomerAdminPage.selectToNewsLetterDropdown("Your store name");
		newCustomerAdminPage.selectToCustomerRoleDropdown("Guests");
		newCustomerAdminPage.closeTagCustomerRoleDefaulDropdown();
		newCustomerAdminPage.selectToManagerOfVendorDropdown("Vendor 1");
		newCustomerAdminPage.inputToCommentTextArea("newcustomer");
		newCustomerAdminPage.clickToSaveEditButton();
		log.info("check create new customer success");
		verifyTrue(newCustomerAdminPage.isAddNewCustomerSuccess());
		customerAdminPage = newCustomerAdminPage.clickToBackToCustomerList();
		customerAdminPage.selectToCustomerRoleDropdown("Guests");
		customerAdminPage.closeTagCustomerRoleDefaulDropdown();
		customerAdminPage.clickToSearchButton();
		log.info("New customer is displayed");
		verifyTrue(customerAdminPage.isNewCustomerDisplay(firstName, lastName,"Guests",company));

	}

	@Test
	public void TC_08_Search_Customer_With_Email() {
		customerAdminPage.refreshCurrentPage(driver);
		customerAdminPage.closeTagCustomerRoleDefaulDropdown();
		customerAdminPage.selectToCustomerRoleDropdown("Guests");
		customerAdminPage.inputToEmailTextBox(email);
		customerAdminPage.clickToSearchButton();
		log.info("New customer is displayed unique");
		verifyTrue(customerAdminPage.isNewCustomerUniqueDisplay(firstName, lastName,"Guests",company));

	}

	@Test
	public void TC_09_Search_Customer_With_Email() {
		customerAdminPage.refreshCurrentPage(driver);
		customerAdminPage.selectToCustomerRoleDropdown("Guests");
		customerAdminPage.closeTagCustomerRoleDefaulDropdown();
		customerAdminPage.inputToFistNameTextBox(firstName);
		customerAdminPage.inputToLastNameTextBox(lastName);
		customerAdminPage.clickToSearchButton();
		log.info("New customer is displayed unique");
		verifyTrue(customerAdminPage.isNewCustomerUniqueDisplay(firstName, lastName,"Guests",company));

	}

	@Test
	public void TC_10_Search_Customer_With_Email() {
		customerAdminPage.refreshCurrentPage(driver);
		customerAdminPage.selectToCustomerRoleDropdown("Guests");
		customerAdminPage.closeTagCustomerRoleDefaulDropdown();
		customerAdminPage.inputToCompanyTextBox(company);
		customerAdminPage.clickToSearchButton();
		log.info("New customer is displayed unique");
		verifyTrue(customerAdminPage.isNewCustomerUniqueDisplay(firstName, lastName,"Guests",company));

	}

	@Test
	public void TC_11_Search_Customer_With_Full_Data() {
		customerAdminPage.refreshCurrentPage(driver);
		customerAdminPage.inputToEmailTextBox(email);
		customerAdminPage.inputToFistNameTextBox(firstName);
		customerAdminPage.inputToLastNameTextBox(lastName);
		customerAdminPage.selectToMonth("8");
		customerAdminPage.selectToDay("20");
		customerAdminPage.selectToCustomerRoleDropdown("Guests");
		customerAdminPage.closeTagCustomerRoleDefaulDropdown();
		customerAdminPage.inputToCompanyTextBox(company);
		customerAdminPage.clickToSearchButton();
		log.info("New customer is displayed unique");
		verifyTrue(customerAdminPage.isNewCustomerUniqueDisplay(firstName, lastName,"Guests",company));

	}

	@Test
	public void TC_12_Edit_Customer() {
		driver.get("https://admin-demo.nopcommerce.com/Admin");
		homePageAdmin = PageManagerObject.getHomeAdminPageObject(driver);
		homePageAdmin.clickToCustomerCatagory();
		homePageAdmin.clickToSubMenu("Customers");
		customerAdminPage = PageManagerObject.getCustomerAdminPageObject(driver);
		customerAdminPage.inputToEmailTextBox(email);
		customerAdminPage.inputToFistNameTextBox(firstName);
		customerAdminPage.inputToLastNameTextBox(lastName);
		customerAdminPage.selectToMonth("8");
		customerAdminPage.selectToDay("20");
		customerAdminPage.inputToCompanyTextBox(company);
		customerAdminPage.selectToCustomerRoleDropdown("Guests");
		customerAdminPage.closeTagCustomerRoleDefaulDropdown();
		customerAdminPage.clickToSearchButton();
		log.info("go to edit customer page");
		editCustomerAdminPage = customerAdminPage.clickToEditByName(firstName, lastName,"Guests",company);
		log.info("Check title edit product page");
		verifyTrue(editCustomerAdminPage.isTitleEditCustomerDispay(lastName,firstName));
		emailedit = editCustomerAdminPage.inputToEmailTextBox(dataF.getEmail());
		firstNameedit = editCustomerAdminPage.inputToFirstNameTextBox(dataF.getFirstName());
		lastNameedit = editCustomerAdminPage.inputToLastNameTextBox(dataF.getLastName());
		editCustomerAdminPage.inputToDateTimeTextBox("09/7/2000");
		companyedit = editCustomerAdminPage.inputToCompanyTextBox(dataF.getCompanyName());
		editCustomerAdminPage.inputToCommentTextArea("editcustomer");
		customerAdminPage = editCustomerAdminPage.clickToSaveEditButton();
		log.info("check create update customer success");
		verifyTrue(customerAdminPage.isUpdateCustomerSuccess());
		customerAdminPage.inputToEmailTextBox(emailedit);
		customerAdminPage.inputToFistNameTextBox(firstNameedit);
		customerAdminPage.inputToLastNameTextBox(lastNameedit);
		customerAdminPage.selectToMonth("9");
		customerAdminPage.selectToDay("7");
		customerAdminPage.selectToCustomerRoleDropdown("Guests");
		customerAdminPage.closeTagCustomerRoleDefaulDropdown();
		customerAdminPage.inputToCompanyTextBox(companyedit);
		customerAdminPage.clickToSearchButton();
		log.info("New customer is displayed unique");
		verifyTrue(customerAdminPage.isNewCustomerUniqueDisplay(firstNameedit, lastNameedit,"Guests",companyedit));
	}

	String firstnameAdd, lastnameAdd, emailAdd, phoneAdd, faxAdd;

	@Test
	public void TC_13_Add_New_Address_In_Customer_Detail() {
		editCustomerAdminPage = customerAdminPage.clickToEditByName(firstNameedit, lastNameedit,"Guests",companyedit);
		log.info("Check dislay layout Add new address");
		editCustomerAdminPage.clickToAddressLayout();
		newAddressAdminPage = editCustomerAdminPage.clickToAddAddressButton();
		log.info("Check title New Address Page");
		newAddressAdminPage.isTileNewAddressDisplay();
		firstnameAdd = newAddressAdminPage.inputToFistName(dataF.getFirstName());
		lastnameAdd = newAddressAdminPage.inputToLastName(dataF.getLastName());
		emailAdd = newAddressAdminPage.inputToEmail(dataF.getEmail());
		String companyAdd = newAddressAdminPage.inputToCompany(dataF.getCompanyName());
		String countryAdd = newAddressAdminPage.selectToCountry("Canada");
		String stateAdd = newAddressAdminPage.selectToState("Saskatchewan");
		String cityAdd = newAddressAdminPage.inputToCity(dataF.getCity());
		String address1Add = newAddressAdminPage.inputToAddress1(dataF.getAddress());
		String address2Add = newAddressAdminPage.inputToAddress2(dataF.getAddress());
		String zipcodeAdd = newAddressAdminPage.inputToZipCode(dataF.getZinCop());
		phoneAdd = newAddressAdminPage.inputToPhone(dataF.getPhone());
		faxAdd = newAddressAdminPage.inputToFax(dataF.getFax());
		String[] infoAddress = { companyAdd, countryAdd, stateAdd, cityAdd, address1Add, address2Add, zipcodeAdd };
		editAddressAdminPage = newAddressAdminPage.clickToSaveButton();
		editCustomerAdminPage = editAddressAdminPage.clickToBackToCustomerButton();
		verifyTrue(editCustomerAdminPage.isAddressInfoDisplay(firstnameAdd, lastnameAdd, emailAdd, phoneAdd, faxAdd));
		verifyTrue(editCustomerAdminPage.isInforAddressDisplayed(infoAddress,firstnameAdd, lastnameAdd, emailAdd, phoneAdd, faxAdd));
	}

	String firstnameAddedit, emailAddedit, phoneAddedit, faxAddedit, lastnameAddedit;

	@Test
	public void TC_14_Edit_Address() {
		driver.get("https://admin-demo.nopcommerce.com/Admin");
		homePageAdmin = PageManagerObject.getHomeAdminPageObject(driver);
		homePageAdmin.clickToCustomerCatagory();
		homePageAdmin.clickToSubMenu("Customers");
		customerAdminPage = PageManagerObject.getCustomerAdminPageObject(driver);
		customerAdminPage.inputToEmailTextBox(emailedit);
		customerAdminPage.inputToFistNameTextBox(firstNameedit);
		customerAdminPage.inputToLastNameTextBox(lastNameedit);
		customerAdminPage.selectToMonth("9");
		customerAdminPage.selectToDay("7");
		customerAdminPage.selectToCustomerRoleDropdown("Guests");
		customerAdminPage.closeTagCustomerRoleDefaulDropdown();
		customerAdminPage.inputToCompanyTextBox(companyedit);
		customerAdminPage.clickToSearchButton();
		editCustomerAdminPage = customerAdminPage.clickToEditByName(firstNameedit, lastNameedit,"Guests",companyedit);
		editAddressAdminPage=editCustomerAdminPage.clickToEditAddress(firstnameAdd, lastnameAdd, emailAdd, phoneAdd, faxAdd);
		firstnameAddedit = editAddressAdminPage.inputToFistName(dataF.getFirstName());
		lastnameAddedit = editAddressAdminPage.inputToLastName(dataF.getLastName());
		emailAddedit = editAddressAdminPage.inputToEmail(dataF.getEmail());
		String companyAddedit = editAddressAdminPage.inputToCompany(dataF.getCompanyName());
		String countryAddedit = editAddressAdminPage.selectToCountry("Canada");
		String stateAddedit = editAddressAdminPage.selectToState("Saskatchewan");
		String cityAddedit = editAddressAdminPage.inputToCity(dataF.getCity());
		String address1Addedit = editAddressAdminPage.inputToAddress1(dataF.getAddress());
		String address2Addedit = editAddressAdminPage.inputToAddress2(dataF.getAddress());
		String zipcodeAddedit = editAddressAdminPage.inputToZipCode(dataF.getZinCop());
		phoneAddedit = editAddressAdminPage.inputToPhone(dataF.getPhone());
		faxAddedit = editAddressAdminPage.inputToFax(dataF.getFax());
		String[] infoAddress = { companyAddedit, countryAddedit, stateAddedit, cityAddedit, address1Addedit, address2Addedit, zipcodeAddedit };
		editAddressAdminPage.clickToSaveButton();
		editCustomerAdminPage = editAddressAdminPage.clickToBackToCustomerButton();
		verifyTrue(editCustomerAdminPage.isAddressInfoDisplay(firstnameAddedit, lastnameAddedit, emailAddedit, phoneAddedit, faxAddedit));
		verifyTrue(editCustomerAdminPage.isInforAddressDisplayed(infoAddress,firstnameAddedit, lastnameAddedit, emailAddedit, phoneAddedit, faxAddedit));

	}

	@Test
	public void TC_15_Delete_Address() {
		driver.get("https://admin-demo.nopcommerce.com/Admin");
		homePageAdmin = PageManagerObject.getHomeAdminPageObject(driver);
		homePageAdmin.clickToCustomerCatagory();
		homePageAdmin.clickToSubMenu("Customers");
		customerAdminPage = PageManagerObject.getCustomerAdminPageObject(driver);
		customerAdminPage.inputToEmailTextBox(emailedit);
		customerAdminPage.inputToFistNameTextBox(firstNameedit);
		customerAdminPage.inputToLastNameTextBox(lastNameedit);
		customerAdminPage.selectToMonth("9");
		customerAdminPage.selectToDay("7");
		customerAdminPage.selectToCustomerRoleDropdown("Guests");
		customerAdminPage.closeTagCustomerRoleDefaulDropdown();
		customerAdminPage.inputToCompanyTextBox(companyedit);
		customerAdminPage.clickToSearchButton();
		editCustomerAdminPage = customerAdminPage.clickToEditByName(firstNameedit, lastNameedit,"Guests",companyedit);
		editCustomerAdminPage.clickToDeleteAddress(firstnameAddedit, lastnameAddedit, emailAddedit, phoneAddedit, faxAddedit);
		editCustomerAdminPage.acceptAlertToDeleteItem();
		verifyTrue(editCustomerAdminPage.isNoDataInTabel());
	}

	@AfterClass
	public void afterClass() {
		//removeDriver();
	}

	HomeAdminPageObject homePageAdmin;
	LoginPageObjectAdmin loginPageAdmin;
	ProductAdminPageObject productPageAdmin;
	EditCustomerAdminPageObject editCustomerAdminPage;
	CustomerAdminPageObject customerAdminPage;
	NewCustomerAdminPageObject newCustomerAdminPage;
	NewAddressAdminPageObject newAddressAdminPage;
	EditAddressAdminPageObject editAddressAdminPage;
	EditProductDetailAdminPageObject editProductDetailAdminPage;
}

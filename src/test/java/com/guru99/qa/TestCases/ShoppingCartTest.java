package com.guru99.qa.TestCases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.guru99.qa.TestBase.TestBase;
import com.guru99.qa.Utils.BrowserAlertHelper;
import com.guru99.qa.Utils.TestUtil;
import com.guru99.qa.WebPages.CustomerLoginPage;
import com.guru99.qa.WebPages.HomePage;
import com.guru99.qa.WebPages.MobilePage;
import com.guru99.qa.WebPages.MyAcctPage;
import com.guru99.qa.WebPages.MyWishlistPage;
import com.guru99.qa.WebPages.ShoppingCartPage;
import com.guru99.qa.WebPages.TvPage;
import com.guru99.qa.WebPages.WishlistSharingPage;

public class ShoppingCartTest extends TestBase {

	// Creating a variable for Pages
	HomePage homePage;
	MobilePage mobilePage;
	TestUtil testUtil;
	CustomerLoginPage customerLoginPage;
	MyAcctPage myAcctPage;
	TvPage tvPage;
	MyWishlistPage myWishlistPage;
	WishlistSharingPage wishlistSharingPage;
	ShoppingCartPage shoppingCartPage;
	BrowserAlertHelper browserAlertHelper;

	// Calling the TestBase Constructor
	public ShoppingCartTest() {
		super();
	}

	// Calling TestBase Functions and Creating Page Objects
	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		homePage = new HomePage();
		mobilePage = new MobilePage();
		customerLoginPage = new CustomerLoginPage();
		myAcctPage = new MyAcctPage();
		tvPage = new TvPage();
		myWishlistPage = new MyWishlistPage();
		wishlistSharingPage = new WishlistSharingPage();
		shoppingCartPage = new ShoppingCartPage();
		browserAlertHelper = new BrowserAlertHelper();
		homePage.ClickOnMyAcctLink();
		customerLoginPage.Login(prop.getProperty("Email"), prop.getProperty("Password"));
		myAcctPage.ClickOnMyWishList();
		myWishlistPage.ClickOnTv();
		tvPage.ClickOnLgAddToWishList();
		myWishlistPage.ClickOnAddToCart();
	}

	// Verifying Page Title
	@Test(priority = 1)
	public void verifyPageTitleTest() {
		extentTest = extentReports.startTest("verifyPageTitleTest");
		Assert.assertEquals(shoppingCartPage.verifyPageTitle(), "Shopping Cart");
	}

	// Clicking on Proceed To Checkout Link
	@Test(priority = 2)
	public void ClickOnProceedToCheckOutTest() {
		extentTest = extentReports.startTest("ClickOnProceedToCheckOutTest");
		shoppingCartPage.ClickOnProceedToCheckOut();
	}

	// Click and Update on QtyField
	@Test(priority = 3)
	public void ClickAndUpdateQtyFieldTest() {
		extentTest = extentReports.startTest("ClickAndUpdateQtyFieldTest");
		shoppingCartPage.ClickAndUpdateQtyField("2");
	}

	// Verifying TotalPrice After Update
	@Test(priority = 4)
	public void verifyTotalPriceTest() {
		extentTest = extentReports.startTest("verifyTotalPriceTest");
		shoppingCartPage.verifyTotalPrice();
	}

}
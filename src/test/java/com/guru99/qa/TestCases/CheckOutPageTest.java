package com.guru99.qa.TestCases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.guru99.qa.TestBase.TestBase;
import com.guru99.qa.Utils.BrowserAlertHelper;
import com.guru99.qa.Utils.TestUtil;
import com.guru99.qa.WebPages.CheckOutPage;
import com.guru99.qa.WebPages.CustomerLoginPage;
import com.guru99.qa.WebPages.HomePage;
import com.guru99.qa.WebPages.MobilePage;
import com.guru99.qa.WebPages.MyAcctPage;
import com.guru99.qa.WebPages.MyWishlistPage;
import com.guru99.qa.WebPages.ShoppingCartPage;
import com.guru99.qa.WebPages.TvPage;
import com.guru99.qa.WebPages.WishlistSharingPage;

public class CheckOutPageTest extends TestBase {

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
	CheckOutPage checkOutPage;
	BrowserAlertHelper browserAlertHelper;

	// Calling the TestBase Constructor
	public CheckOutPageTest() {
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
		checkOutPage = new CheckOutPage();
		browserAlertHelper = new BrowserAlertHelper();
		homePage.ClickOnMyAcctLink();
		customerLoginPage.Login(prop.getProperty("Email"), prop.getProperty("Password"));
		myAcctPage.ClickOnMyWishList();
		myWishlistPage.ClickOnTv();
		tvPage.ClickOnLgAddToWishList();
		myWishlistPage.ClickOnAddToCart();
		shoppingCartPage.ClickOnProceedToCheckOut();
	}

	// Verifying Page Ttile
	@Test(priority = 1, enabled = false)
	public void verifyPageTitleTest() {
		extentTest = extentReports.startTest("verifyPageTitleTest");
		Assert.assertEquals(checkOutPage.verifyPageTitle(), "Checkout");
	}

	// Entering Values in the Required Field
	@Test(priority = 2)
	public void EnterValuesTest() {
		extentTest = extentReports.startTest("EnterValuesTest");
		checkOutPage.EnterValues();

	}

}

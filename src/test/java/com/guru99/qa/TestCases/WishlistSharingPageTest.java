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
import com.guru99.qa.WebPages.TvPage;
import com.guru99.qa.WebPages.WishlistSharingPage;

public class WishlistSharingPageTest extends TestBase {

	// Creating a variable for Pages
	HomePage homePage;
	MobilePage mobilePage;
	TestUtil testUtil;
	CustomerLoginPage customerLoginPage;
	MyAcctPage myAcctPage;
	TvPage tvPage;
	MyWishlistPage myWishlistPage;
	WishlistSharingPage wishlistSharingPage;
	BrowserAlertHelper browserAlertHelper;

	// Calling the TestBase Constructor
	public WishlistSharingPageTest() {
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
		tvPage = new TvPage();
		myWishlistPage = new MyWishlistPage();
		wishlistSharingPage = new WishlistSharingPage();
		browserAlertHelper = new BrowserAlertHelper();
		homePage.ClickOnTvLink();
		tvPage.ClickOnLgAddToWishList();
		customerLoginPage.Login(prop.getProperty("Email"), prop.getProperty("Password"));
		myWishlistPage.ClickOnShareWishList();
	}

	// Verifying WishlistSharingPage Title
	@Test(priority = 1)
	public void verifyPageTitleTest() {
		extentTest = extentReports.startTest("verifyPageTitleTest");
		Assert.assertEquals(wishlistSharingPage.verifyPageTitle(), "Wishlist Sharing");
	}

	// Entering Values and click On ShareWishlistBtn
	@Test(priority = 2)
	public void EnterValuesAndClickTest() {
		extentTest = extentReports.startTest("EnterValuesAndClickTest");
		wishlistSharingPage.EnterValuesAndClick("sudha80@yahoo.com", "Hi Sudha...!!!");

	}

}

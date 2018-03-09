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

public class MyWishlistPageTest extends TestBase {

	// Creating a variable for Pages
	HomePage homePage;
	MobilePage mobilePage;
	TestUtil testUtil;
	CustomerLoginPage customerLoginPage;
	MyAcctPage myAcctPage;
	TvPage tvPage;
	MyWishlistPage myWishlistPage;
	BrowserAlertHelper browserAlertHelper;

	// Calling the TestBase Constructor
	public MyWishlistPageTest() {
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
		browserAlertHelper = new BrowserAlertHelper();
		homePage.ClickOnTvLink();
		tvPage.ClickOnLgAddToWishList();
		customerLoginPage.Login(prop.getProperty("Email"), prop.getProperty("Password"));
	}

	// Verifying SiteTitle
	@Test(priority = 1)
	public void verifyPageTitleTest() {
		extentTest = extentReports.startTest("verifyPageTitleTest");
		Assert.assertEquals(myWishlistPage.verifyPageTitle(), "My Wishlist");
	}

	// Clicking on LgAddToWishList
	@Test(priority = 2)
	public void ClickOnShareWishListTest() {
		extentTest = extentReports.startTest("ClickOnShareWishListTest");
		myWishlistPage.ClickOnShareWishList();
	}

}

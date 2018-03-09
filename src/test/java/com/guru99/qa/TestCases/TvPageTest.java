package com.guru99.qa.TestCases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.guru99.qa.TestBase.TestBase;
import com.guru99.qa.Utils.BrowserAlertHelper;
import com.guru99.qa.Utils.TestUtil;
import com.guru99.qa.WebPages.CreateNewCustomerAcctPage;
import com.guru99.qa.WebPages.CustomerLoginPage;
import com.guru99.qa.WebPages.HomePage;
import com.guru99.qa.WebPages.MobilePage;
import com.guru99.qa.WebPages.MyAcctPage;
import com.guru99.qa.WebPages.TvPage;

public class TvPageTest extends TestBase {

	// Creating a variable for Pages
	HomePage homePage;
	MobilePage mobilePage;
	TestUtil testUtil;
	CustomerLoginPage customerLoginPage;
	CreateNewCustomerAcctPage createNewCustomerAcctPage;
	MyAcctPage myAcctPage;
	TvPage tvPage;
	BrowserAlertHelper browserAlertHelper;

	// Calling the TestBase Constructor
	public TvPageTest() {
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
		createNewCustomerAcctPage = new CreateNewCustomerAcctPage();
		myAcctPage = new MyAcctPage();
		tvPage = new TvPage();
		browserAlertHelper = new BrowserAlertHelper();
		homePage.ClickOnTvLink();
	}

	// Verifying SiteTitle
	@Test(priority = 1)
	public void verifyTvPageTitleTest() {
		extentTest = extentReports.startTest("verifyTvPageTitleTest");
		Assert.assertEquals(tvPage.verifyTvPageTitle(), "TV");
	}

	// Clicking on LgAddToWishList
	@Test(priority = 2)
	public void ClickOnLgAddToWishListTest() {
		extentTest = extentReports.startTest("ClickOnLgAddToWishListTest");
		tvPage.ClickOnLgAddToWishList();
	}
}

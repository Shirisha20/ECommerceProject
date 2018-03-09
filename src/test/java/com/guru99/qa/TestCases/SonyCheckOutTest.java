package com.guru99.qa.TestCases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.guru99.qa.TestBase.TestBase;
import com.guru99.qa.Utils.BrowserAlertHelper;
import com.guru99.qa.Utils.TestUtil;
import com.guru99.qa.WebPages.HomePage;
import com.guru99.qa.WebPages.MobilePage;
import com.guru99.qa.WebPages.SonyCheckOutPage;

public class SonyCheckOutTest extends TestBase {

	// Creating a variable for Pages
	HomePage homePage;
	MobilePage mobilePage;
	SonyCheckOutPage sonyCheckOutPage;
	TestUtil testUtil;
	BrowserAlertHelper browserAlertHelper;

	// Calling the TestBase Constructor
	public SonyCheckOutTest() {
		super();
	}

	// Calling TestBase Functions and Creating Page Objects
	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		homePage = new HomePage();
		mobilePage = new MobilePage();
		sonyCheckOutPage = new SonyCheckOutPage();
		browserAlertHelper = new BrowserAlertHelper();
		homePage.ClickOnMobile();
		mobilePage.ClickOnSonyAddToCartBtn();
	}

	// Verifying SonyCheckOutPage Title
	@Test(priority = 1)
	public void verifySonyCheckOutPageTitleTest() {
		extentTest = extentReports.startTest("verifySonyCheckOutPageTitleTest");
		Assert.assertEquals(sonyCheckOutPage.verifySonyCheckOutPageTitle(), "Shopping Cart");

	}

	// Sending Input to Qty Box And Updating the Quantity
	@Test(priority = 2)
	public void verifyErrorMsgTest() {
		extentTest = extentReports.startTest("verifyErrorMsgTest");
		sonyCheckOutPage.SendAndUpdate("1000");
		Assert.assertEquals(sonyCheckOutPage.verifyErrorMsg(),
		        "Some of the products cannot be ordered in requested quantity.");

	}

	// Verifying Messge after clicking on EmptyCart
	@Test(priority = 3)
	public void verifyEmptyCartMsgTest() {
		extentTest = extentReports.startTest("verifyEmptyCartMsgTest");
		Assert.assertEquals(sonyCheckOutPage.verifyEmptyCartMsg(), "SHOPPING CART IS EMPTY");

	}

}

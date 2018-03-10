package com.guru99.qa.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.guru99.qa.TestBase.TestBase;
import com.guru99.qa.Utils.BrowserAlertHelper;
import com.guru99.qa.Utils.TestUtil;
import com.guru99.qa.WebPages.HomePage;
import com.guru99.qa.WebPages.MobilePage;

public class MobilePageTest extends TestBase {

	// Creating a variable for Pages
	HomePage homePage;
	MobilePage mobilePage;
	TestUtil testUtil;
	BrowserAlertHelper browserAlertHelper;

	// Calling the TestBase Constructor
	public MobilePageTest() {
		super();
	}

	// Calling TestBase Functions and Creating Page Objects
	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		homePage = new HomePage();
		mobilePage = new MobilePage();
		browserAlertHelper = new BrowserAlertHelper();
		homePage.ClickOnMobile();
	}

	// Verifying SiteTitle
	@Test(priority = 1)
	public void verifyMobilePageTitleTest() {
		extentTest = extentReports.startTest("verifyMobilePageTitleTest");
		Assert.assertEquals(mobilePage.verifyMobilePageTitle(), "MOBILE");
		try {
			TestUtil.ScreenCapture();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Selecting An Element from DropDown
	@Test(priority = 2)
	public void DropDowntest() {
		extentTest = extentReports.startTest("DropDowntest");
		mobilePage.DropDown();
		try {
			TestUtil.ScreenCapture();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Verifying Mobile Costs
	@Test(priority = 3)
	public void verifySonyMobileCostTest() {
		extentTest = extentReports.startTest("verifySonyMobileCostTest");
		Assert.assertEquals(mobilePage.verifySonyMobileCost(), "$100.00");
		try {
			TestUtil.ScreenCapture();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Clicking on SonyXPeriaLink
	@Test(priority = 4)
	public void ClickOnSonyTest() {
		extentTest = extentReports.startTest("ClickOnSonyTest");
		mobilePage.ClickOnSony();
	}

	// Clicking on SonyXPeria AddToCart Button
	@Test(priority = 5)
	public void ClickOnSonyAddToCartBtnTest() {
		extentTest = extentReports.startTest("ClickOnSonyAddToCartBtnTest");
		mobilePage.ClickOnSonyAddToCartBtn();
	}

	// Clicking On AddToCompare Link and Compare to Compare Prices for Two Mobiles
	@Test(priority = 6)
	public void ComparePricesTest() {
		extentTest = extentReports.startTest("ComparePricesTest");
		mobilePage.ComparePrices();

	}

	// Clicking on IPhone AddToCart Button
	@Test(priority = 0)
	public void ClickOnIPhoneAddToCartTest() {
		extentTest = extentReports.startTest("ClickOnIPhoneAddToCartTest");
		mobilePage.ClickOnIPhoneAddToCart();
	}

}
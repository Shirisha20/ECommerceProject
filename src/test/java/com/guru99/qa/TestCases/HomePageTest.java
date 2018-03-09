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

public class HomePageTest extends TestBase {

	// Creating a variable for Pages
	HomePage homePage;
	MobilePage mobilePage;
	TestUtil testUtil;
	BrowserAlertHelper browserAlertHelper;

	// Calling the TestBase Constructor
	public HomePageTest() {
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
	}

	// Verifying SiteTitle
	@Test(priority = 1)
	public void verifySiteTitleTest() {
		extentTest = extentReports.startTest("verifySiteTitleTest");
		Assert.assertEquals(homePage.verifySiteTitle(), "THIS IS DEMO SITE FOR   ");
		try {
			TestUtil.ScreenCapture();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Click on MobileLink
	@Test(priority = 2)
	public void ClickOnMobileTest() {
		extentTest = extentReports.startTest("ClickOnMobileTest");
		homePage.ClickOnMobile();
	}

	// Clicking on TvLink
	@Test(priority = 3)
	public void ClickOnTvLinkTest() {
		extentTest = extentReports.startTest("ClickOnTvLinkTest");
		homePage.ClickOnTvLink();
	}

}

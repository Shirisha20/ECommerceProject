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
import com.guru99.qa.WebPages.SonyDetailedPage;

public class SonyDetailedPageTest extends TestBase {

	// Creating a variable for Pages
	HomePage homePage;
	MobilePage mobilePage;
	TestUtil testUtil;
	SonyDetailedPage sonyDetailedPage;
	BrowserAlertHelper browserAlertHelper;

	// Calling the TestBase Constructor
	public SonyDetailedPageTest() {
		super();
	}

	// Calling TestBase Functions and Creating Page Objects
	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		homePage = new HomePage();
		mobilePage = new MobilePage();
		sonyDetailedPage = new SonyDetailedPage();
		browserAlertHelper = new BrowserAlertHelper();
		homePage.ClickOnMobile();
		mobilePage.ClickOnSony();
	}

	// Get Title of the Page
	@Test(priority = 1)
	public void PageTitleTest() {
		extentTest = extentReports.startTest("PageTitleTest");
		sonyDetailedPage.PageTitle();
	}

	// Verifying Sony Cost on SonyDetailedPage
	@Test(priority = 2)
	public void verifySonyCostTest() {
		extentTest = extentReports.startTest("verifySonyCostTest");
		Assert.assertEquals(sonyDetailedPage.verifySonyCost(), "$100.00");
		try {
			TestUtil.ScreenCapture();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Comparing SonyCost on Two Pages
	@Test(priority = 3)
	public void CompareSonyCostTest() {
		extentTest = extentReports.startTest("CompareSonyCostTest");
		Assert.assertEquals(mobilePage.verifySonyMobileCost(), sonyDetailedPage.verifySonyCost());
		try {
			TestUtil.ScreenCapture();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

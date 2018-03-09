package com.guru99.qa.TestCases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.guru99.qa.TestBase.TestBase;
import com.guru99.qa.Utils.BrowserAlertHelper;
import com.guru99.qa.Utils.TestUtil;
import com.guru99.qa.WebPages.CustomerLoginPage;
import com.guru99.qa.WebPages.HomePage;
import com.guru99.qa.WebPages.MyAcctPage;
import com.guru99.qa.WebPages.MyOrdersPage;

public class MyOrderPageTest extends TestBase {

	// Creating a variable for Pages
	HomePage homePage;
	TestUtil testUtil;
	CustomerLoginPage customerLoginPage;
	MyAcctPage myAcctPage;
	MyOrdersPage myOrdersPage;
	BrowserAlertHelper browserAlertHelper;

	// Calling the TestBase Constructor
	public MyOrderPageTest() {
		super();
	}

	// Calling TestBase Functions and Creating Page Objects
	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		homePage = new HomePage();
		customerLoginPage = new CustomerLoginPage();
		myAcctPage = new MyAcctPage();
		myOrdersPage = new MyOrdersPage();
		browserAlertHelper = new BrowserAlertHelper();
		homePage.ClickOnMyAcctLink();
		customerLoginPage.Login(prop.getProperty("Email"), prop.getProperty("Password"));
		myAcctPage.ClickOnMyOrdersLink();
	}

	// Verifying Page Title
	@Test(priority = 1)
	public void verifyPageTitleTest() {
		extentTest = extentReports.startTest("verifyPageTitleTest");
		Assert.assertEquals(myOrdersPage.verifyPageTitle(), "My Orders");
	}

	// Clicking On ViewOrderLink
	@Test(priority = 2)
	public void ClickOnViewOrderLinkTest() {
		extentTest = extentReports.startTest("ClickOnViewOrderLinkTest");
		myOrdersPage.ClickOnViewOrderLink();
	}

}

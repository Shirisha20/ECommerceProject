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
import com.guru99.qa.WebPages.OrderNumberPage;

public class OrderNumberPageTest extends TestBase {

	// Creating a variable for Pages
	HomePage homePage;
	TestUtil testUtil;
	CustomerLoginPage customerLoginPage;
	MyAcctPage myAcctPage;
	MyOrdersPage myOrdersPage;
	OrderNumberPage orderNumberPage;
	BrowserAlertHelper browserAlertHelper;

	// Calling the TestBase Constructor
	public OrderNumberPageTest() {
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
		orderNumberPage = new OrderNumberPage();
		browserAlertHelper = new BrowserAlertHelper();
		homePage.ClickOnMyAcctLink();
		customerLoginPage.Login(prop.getProperty("Email"), prop.getProperty("Password"));
		myAcctPage.ClickOnMyOrdersLink();
		myOrdersPage.ClickOnViewOrderLink();
	}

	// Verifying Page Title
	@Test(priority = 1, enabled = false)
	public void verifyPageTitleTest() {
		extentTest = extentReports.startTest("verifyPageTitleTest");
		Assert.assertEquals(orderNumberPage.verifyPageTitle(), "Order # 100006333");
	}

	// Verifying Page Header
	@Test(priority = 2, enabled = false)
	public void verifyPageHeaderTest() {
		extentTest = extentReports.startTest("verifyPageHeaderTest");
		Assert.assertEquals(orderNumberPage.verifyPageHeader(), "ORDER #100006333 - PENDING");

	}

	// Clicking on PrintOrderLink
	@Test(priority = 3)
	public void ClickOnPrintOrderTest() {
		extentTest = extentReports.startTest("ClickOnPrintOrderTest");
		orderNumberPage.ClickOnPrintOrder();

	}
}
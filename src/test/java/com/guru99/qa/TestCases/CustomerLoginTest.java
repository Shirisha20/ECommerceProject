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

public class CustomerLoginTest extends TestBase {

	// Creating a variable for Pages
	HomePage homePage;
	MobilePage mobilePage;
	TestUtil testUtil;
	CustomerLoginPage customerLoginPage;
	BrowserAlertHelper browserAlertHelper;

	// Calling the TestBase Constructor
	public CustomerLoginTest() {
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
		browserAlertHelper = new BrowserAlertHelper();
		homePage.ClickOnMyAcctLink();
	}

	// Verifying CustomerLogin Header
	@Test(priority = 1)
	public void verifyCustomerLoginHeaderTest() {
		extentTest = extentReports.startTest("verifyCustomerLoginHeaderTest");
		Assert.assertEquals(customerLoginPage.verifyCustomerLoginHeader(), "LOGIN OR CREATE AN ACCOUNT");
	}

	// Click on CreateAcctBtn
	@Test(priority = 2, enabled = false)
	public void ClickOnCreateAcctBtnTest() {
		extentTest = extentReports.startTest("ClickOnCreateAcctBtnTest");
		customerLoginPage.ClickOnCreateAcctBtn();
	}

	// Logging with Existing Acct Values
	@Test(priority = 3)
	public void LoginTest() {
		extentTest = extentReports.startTest("LoginTest");
		customerLoginPage.Login(prop.getProperty("Email"), prop.getProperty("Password"));

	}

}

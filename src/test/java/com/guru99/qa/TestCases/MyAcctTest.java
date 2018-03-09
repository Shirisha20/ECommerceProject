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

public class MyAcctTest extends TestBase {

	// Creating a variable for Pages
	HomePage homePage;
	MobilePage mobilePage;
	TestUtil testUtil;
	CustomerLoginPage customerLoginPage;
	CreateNewCustomerAcctPage createNewCustomerAcctPage;
	MyAcctPage myAcctPage;
	BrowserAlertHelper browserAlertHelper;

	// Calling the TestBase Constructor
	public MyAcctTest() {
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
		browserAlertHelper = new BrowserAlertHelper();
		homePage.ClickOnMyAcctLink();
		customerLoginPage.ClickOnCreateAcctBtn();
		createNewCustomerAcctPage.ValidRegistration("sai", "Ram", "sai3@gmail.com", "test123", "test123");
	}

	// Verifying Page Title
	@Test(priority = 1)
	public void verifyAllTest() {
		extentTest = extentReports.startTest("verifyAllTest");
		Assert.assertEquals(myAcctPage.verifyMyAcctPageTitle(), "My Account");
		myAcctPage.ClickOnMyWishList();
		driver.navigate().back();
		myAcctPage.ClickOnMyOrdersLink();

	}

}

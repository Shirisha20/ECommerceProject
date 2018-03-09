package com.guru99.qa.TestCases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.guru99.qa.TestBase.TestBase;
import com.guru99.qa.Utils.BrowserAlertHelper;
import com.guru99.qa.Utils.TestUtil;
import com.guru99.qa.WebPages.CreateNewCustomerAcctPage;
import com.guru99.qa.WebPages.CustomerLoginPage;
import com.guru99.qa.WebPages.HomePage;
import com.guru99.qa.WebPages.MobilePage;

public class CreateNewCustomerAcctTest extends TestBase {

	// Creating a variable for Pages
	HomePage homePage;
	MobilePage mobilePage;
	TestUtil testUtil;
	CustomerLoginPage customerLoginPage;
	CreateNewCustomerAcctPage createNewCustomerAcctPage;
	BrowserAlertHelper browserAlertHelper;

	// Calling the TestBase Constructor
	public CreateNewCustomerAcctTest() {
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
		browserAlertHelper = new BrowserAlertHelper();
		homePage.ClickOnMyAcctLink();
		customerLoginPage.ClickOnCreateAcctBtn();
	}

	// Verifying Page Title
	@Test(priority = 1)
	public void verifyCreateNewCustomerAcctTitleTest() {
		extentTest = extentReports.startTest("verifyCreateNewCustomerAcctTitleTest");
		Assert.assertEquals(createNewCustomerAcctPage.verifyCreateNewCustomerAcctTitle(),
		        "Create New Customer Account");
	}

	@DataProvider
	public Object[][] GetData() {
		Object data[][] = TestUtil.getTestData("TestData");
		return data;
	}

	// Create Valid Account
	@Test(priority = 2, dataProvider = "GetData", enabled = false)
	public void ValidRegistrationTest(String FName, String LName, String Email, String Pwd, String ConfirmPwd) {
		extentTest = extentReports.startTest("ValidRegistrationTest");
		createNewCustomerAcctPage.ValidRegistration(FName, LName, Email, Pwd, ConfirmPwd);

	}

}

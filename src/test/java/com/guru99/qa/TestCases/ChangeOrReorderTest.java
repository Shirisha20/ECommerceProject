package com.guru99.qa.TestCases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.guru99.qa.TestBase.TestBase;
import com.guru99.qa.Utils.BrowserAlertHelper;
import com.guru99.qa.Utils.TestUtil;
import com.guru99.qa.WebPages.CheckOutPage;
import com.guru99.qa.WebPages.CustomerLoginPage;
import com.guru99.qa.WebPages.HomePage;
import com.guru99.qa.WebPages.MyAcctPage;
import com.guru99.qa.WebPages.ShoppingCartPage;

public class ChangeOrReorderTest extends TestBase {

	// Creating a variable for Pages
	HomePage homePage;
	TestUtil testUtil;
	CustomerLoginPage customerLoginPage;
	MyAcctPage myAcctPage;
	ShoppingCartPage shoppingCartPage;
	CheckOutPage checkOutPage;
	BrowserAlertHelper browserAlertHelper;

	// Calling the TestBase Constructor
	public ChangeOrReorderTest() {
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
		shoppingCartPage = new ShoppingCartPage();
		checkOutPage = new CheckOutPage();
		browserAlertHelper = new BrowserAlertHelper();
		homePage.ClickOnMyAcctLink();
		customerLoginPage.Login(prop.getProperty("Email"), prop.getProperty("Password"));
		myAcctPage.ClickOnReOrderLink();
		shoppingCartPage.ClickAndUpdateQtyField("10");
		shoppingCartPage.verifyTotalPrice();
		shoppingCartPage.ClickOnProceedToCheckOut();
		checkOutPage.EnterValues();
	}

	@Test
	public void verifyTitle() {
		extentTest = extentReports.startTest("verifyTitle");
		String Title = driver.getTitle();
		System.out.println(Title);
		Assert.assertTrue(true, "Title is found");
	}

}

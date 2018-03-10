package com.guru99.qa.TestCases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.guru99.qa.TestBase.TestBase;
import com.guru99.qa.Utils.BrowserAlertHelper;
import com.guru99.qa.Utils.TestUtil;
import com.guru99.qa.WebPages.HomePage;
import com.guru99.qa.WebPages.MobilePage;
import com.guru99.qa.WebPages.ShoppingCartPage;

public class DiscountTest extends TestBase {

	// Creating a variable for Pages
	HomePage homePage;
	MobilePage mobilePage;
	TestUtil testUtil;
	ShoppingCartPage shoppingCartPage;
	BrowserAlertHelper browserAlertHelper;

	// Calling the TestBase Constructor
	public DiscountTest() {
		super();
	}

	// Calling TestBase Functions and Creating Page Objects
	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		homePage = new HomePage();
		mobilePage = new MobilePage();
		shoppingCartPage = new ShoppingCartPage();
		browserAlertHelper = new BrowserAlertHelper();

	}

	@Test
	public void verifyDiscountPrice() {
		extentTest = extentReports.startTest("verifyDiscountPrice");
		homePage.ClickOnMobile();
		mobilePage.ClickOnIPhoneAddToCart();
		shoppingCartPage.EnterDiscountCodeClickApply("GURU50");
		shoppingCartPage.verifyDiscountSuccessMsg();

	}

}

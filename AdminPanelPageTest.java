package com.guru99.qa.TestCases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.guru99.qa.EmailUtil.EmailUtil;
import com.guru99.qa.TestBase.TestBase;
import com.guru99.qa.Utils.BrowserAlertHelper;
import com.guru99.qa.Utils.TestUtil;
import com.guru99.qa.WebPages.AdminPanelPage;
import com.guru99.qa.WebPages.BackendLoginPage;

public class AdminPanelPageTest extends TestBase {

	// Creating a variable for Pages
	BackendLoginPage backendPage;
	AdminPanelPage adminPanelPage;
	EmailUtil emailUtil;
	TestUtil testUtil;
	BrowserAlertHelper browserAlertHelper;

	// Calling the TestBase Constructor
	public AdminPanelPageTest() {
		super();
	}

	// Calling TestBase Functions and Creating Page Objects
	@BeforeMethod
	public void setUp() {
		BackendInitialization();
		backendPage = new BackendLoginPage();
		adminPanelPage = new AdminPanelPage();
		emailUtil = new EmailUtil();
		testUtil = new TestUtil();
		browserAlertHelper = new BrowserAlertHelper();
		backendPage.Login(prop.getProperty("UserName"), prop.getProperty("Pwd"));

	}

	// Verifying Page Ttile
	@Test(priority = 1)
	public void verifyPageTitleTest() {
		extentTest = extentReports.startTest("verifyPageTitleTest");
		adminPanelPage.verifyPageTitle();

	}

	// Clicking Button
	@Test(priority = 2)
	public void ClickOnButtonsTest() {
		extentTest = extentReports.startTest("ClickOnButtonsTest");
		adminPanelPage.ClickOnButtons();

	}
}

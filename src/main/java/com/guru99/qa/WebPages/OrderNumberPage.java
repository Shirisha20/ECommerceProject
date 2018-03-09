package com.guru99.qa.WebPages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.guru99.qa.TestBase.TestBase;
import com.guru99.qa.Utils.BrowserAlertHelper;
import com.guru99.qa.Utils.TestUtil;

public class OrderNumberPage extends TestBase {

	@FindBy(xpath = "//h1[text()='Order #100006333 - Pending']")
	WebElement OrderNumberPageHeader;

	@FindBy(xpath = "//a[text()='Print Order']")
	WebElement PrintOrderLink;

	@FindBy(xpath = "//h1")
	WebElement OrderNumber;

	// Initializing the Page Objects:
	public OrderNumberPage() {
		PageFactory.initElements(driver, this);
	}

	// Verifying Page Title
	public String verifyPageTitle() {
		String PageTitle = driver.getTitle();
		System.out.println(PageTitle);
		return PageTitle;
	}

	// Verifying Page Header
	public String verifyPageHeader() {
		String PageHeader = OrderNumberPageHeader.getText();
		System.out.println(PageHeader);
		return PageHeader;
	}

	// Clicking on PrintOrderLink
	public void ClickOnPrintOrder() {
		PrintOrderLink.click();
		BrowserAlertHelper.SwitchWindow(driver);
		TestUtil.drawBorder(OrderNumber, driver);
		try {
			TestUtil.ScreenCapture();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

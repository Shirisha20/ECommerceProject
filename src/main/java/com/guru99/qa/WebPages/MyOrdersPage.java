package com.guru99.qa.WebPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.guru99.qa.TestBase.TestBase;

public class MyOrdersPage extends TestBase {

	@FindBy(xpath = "//a[text()='View Order']")
	WebElement ViewOrderLink;

	// Initializing the Page Objects:
	public MyOrdersPage() {
		PageFactory.initElements(driver, this);
	}

	// Verifying Page Title
	public String verifyPageTitle() {
		String PageTitle = driver.getTitle();
		System.out.println(PageTitle);
		return PageTitle;
	}

	// Clicking On ViewOrderLink
	public OrderNumberPage ClickOnViewOrderLink() {
		ViewOrderLink.click();
		return new OrderNumberPage();
	}

}

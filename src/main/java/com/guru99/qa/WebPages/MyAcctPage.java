package com.guru99.qa.WebPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.guru99.qa.TestBase.TestBase;

public class MyAcctPage extends TestBase {

	@FindBy(xpath = "/html/body/div/div/div[2]/div/div[2]/div/div[1]/form[1]/div/div/button[1]")
	WebElement ShareWishlistBtn;

	@FindBy(xpath = "/html/body/div/div/div[2]/div/div[1]/div/div[2]/ul/li[8]/a")
	WebElement MyWishListLink;

	@FindBy(xpath = "//a[text()='My Orders']")
	WebElement MyOrdersLink;

	@FindBy(xpath = "//a[text()='Reorder']")
	WebElement ReOrderLink;

	// Initializing the Page Objects:
	public MyAcctPage() {
		PageFactory.initElements(driver, this);
	}

	// Verifying Page Title
	public String verifyMyAcctPageTitle() {
		String PageTitle = driver.getTitle();
		System.out.println(PageTitle);
		return PageTitle;
	}

	// Clicking On MyWishList Link
	public MyWishlistPage ClickOnMyWishList() {
		MyWishListLink.click();
		return new MyWishlistPage();
	}

	// Clicking On MyOrders Link
	public MyOrdersPage ClickOnMyOrdersLink() {
		MyOrdersLink.click();
		return new MyOrdersPage();
	}

	// Clicking On ReOrder Link
	public ShoppingCartPage ClickOnReOrderLink() {
		ReOrderLink.click();
		return new ShoppingCartPage();
	}

}

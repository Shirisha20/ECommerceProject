package com.guru99.qa.WebPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.guru99.qa.TestBase.TestBase;

public class WishlistSharingPage extends TestBase {

	// Page Factory - OR:
	@FindBy(xpath = "//*[@id=\"email_address\"]")
	WebElement EmailAddressField;

	@FindBy(xpath = "//*[@id=\"message\"]")
	WebElement MessegeField;

	@FindBy(xpath = "/html/body/div/div/div[2]/div/div[2]/div/form/div[2]/button")
	WebElement ShareWishListBtn;

	@FindBy(xpath = "/html/body/div/div/div[2]/div/div[2]/div/div[1]/ul/li/ul/li/span")
	WebElement SuccessSharedMsg;

	// Initializing the Page Objects:
	public WishlistSharingPage() {
		PageFactory.initElements(driver, this);
	}

	// Verifying WishlistSharingPage Title
	public String verifyPageTitle() {
		String PageTitle = driver.getTitle();
		System.out.println(PageTitle);
		return PageTitle;
	}

	// Entering Values and click On ShareWishlistBtn
	public void EnterValuesAndClick(String Email, String Msg) {
		EmailAddressField.sendKeys(Email);
		MessegeField.sendKeys(Msg);
		ShareWishListBtn.click();
		String Messege = SuccessSharedMsg.getText();
		System.out.println(Messege);
		Assert.assertEquals(Messege, "Your Wishlist has been shared.");

	}
}

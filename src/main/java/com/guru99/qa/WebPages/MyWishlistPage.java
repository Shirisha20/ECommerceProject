package com.guru99.qa.WebPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.guru99.qa.TestBase.TestBase;

public class MyWishlistPage extends TestBase {

	// Page Factory - OR:
	@FindBy(xpath = "/html/body/div/div/div[2]/div/div[2]/div/div[1]/form[1]/div/div/button[1]")
	WebElement ShareWishList;

	@FindBy(xpath = "//span[text()='Add to Cart']")
	WebElement AddToCart;

	@FindBy(xpath = "//span[contains(text(),'Cart')]")
	WebElement Cart;

	@FindBy(linkText = "Checkout")
	WebElement CheckOut;

	@FindBy(linkText = "TV")
	WebElement TvLink;

	// Initializing the Page Objects:
	public MyWishlistPage() {
		PageFactory.initElements(driver, this);
	}

	// Verifying SiteTitle
	public String verifyPageTitle() {
		String TitleOfThePage = driver.getTitle();
		System.out.println(TitleOfThePage);
		return TitleOfThePage;
	}

	// Clicking on LgAddToWishList
	public WishlistSharingPage ClickOnShareWishList() {
		ShareWishList.click();
		return new WishlistSharingPage();
	}

	// Clicking on AddToCart Link
	public void ClickOnAddToCart() {
		AddToCart.click();

	}

	// Clicking on Cart Button
	public void ClickOnCart() {
		Cart.click();
	}

	// Clicking on CheckOut Button
	public CheckOutPage ClickOnCheckOut() {
		CheckOut.click();
		return new CheckOutPage();
	}

	// Clicking on Tv Link
	public void ClickOnTv() {
		TvLink.click();
	}

}

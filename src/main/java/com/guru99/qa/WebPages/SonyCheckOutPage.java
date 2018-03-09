package com.guru99.qa.WebPages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.guru99.qa.TestBase.TestBase;
import com.guru99.qa.Utils.TestUtil;

public class SonyCheckOutPage extends TestBase {

	// Page Factory - OR:
	@FindBy(xpath = "//input[@class='input-text qty']")
	WebElement QtyInputBox;

	@FindBy(xpath = "//button[@title='Add to Cart']")
	WebElement AddToCart;

	@FindBy(xpath = "//button[@title='Update']")
	WebElement UpdateBtn;

	@FindBy(xpath = "//li[@class='error-msg']")
	WebElement ErrorMsg;

	@FindBy(xpath = "//div[@class='header-minicart']")
	WebElement Cart;

	@FindBy(xpath = "//span[text()='Empty Cart']")
	WebElement EmptyCart;

	@FindBy(xpath = "//h1[text()='Shopping Cart is Empty']")
	WebElement EmptyCartMsg;

	// Initializing the Page Objects:
	public SonyCheckOutPage() {
		PageFactory.initElements(driver, this);
	}

	// Verifying SonyCheckOutPage Title
	public String verifySonyCheckOutPageTitle() {
		String TitleOfThePage = driver.getTitle();
		System.out.println(TitleOfThePage);
		return TitleOfThePage;
	}

	// Sending Input to Qty Box And Updating the Quantity
	public void SendAndUpdate(String Number) {
		QtyInputBox.click();
		QtyInputBox.clear();
		QtyInputBox.sendKeys(Number);
		UpdateBtn.click();
	}

	// Clicking On AddToCart Button
	public void ClickOnAddToCart() {
		AddToCart.click();
	}

	// Verifying Error Messege
	public String verifyErrorMsg() {
		String ErrorMessege = ErrorMsg.getText();
		System.out.println(ErrorMsg);
		TestUtil.drawBorder(ErrorMsg, driver);
		try {
			TestUtil.ScreenCapture();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ErrorMessege;
	}

	// Verifying Messge after clicking on EmptyCart
	public String verifyEmptyCartMsg() {
		EmptyCart.click();
		String EmptyCartMessege = EmptyCartMsg.getText();
		System.out.println(EmptyCartMessege);
		TestUtil.drawBorder(EmptyCartMsg, driver);
		try {
			TestUtil.ScreenCapture();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return EmptyCartMessege;
	}

}

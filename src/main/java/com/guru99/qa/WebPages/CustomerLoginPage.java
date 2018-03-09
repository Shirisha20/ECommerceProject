package com.guru99.qa.WebPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.guru99.qa.TestBase.TestBase;

public class CustomerLoginPage extends TestBase {

	// Page Factory - OR:
	@FindBy(xpath = "//h1[contains(text(),'Login or Create an Account')]")
	WebElement CustomerLoginHeading;

	@FindBy(xpath = "//span[contains(text(),'Create an Account')]")
	WebElement CreateAcctBtn;

	@FindBy(xpath = "//*[@id=\"email\"]")
	WebElement EmailField;

	@FindBy(xpath = "//*[@id=\"pass\"]")
	WebElement PasswordField;

	@FindBy(xpath = "//*[@id=\"send2\"]")
	WebElement LoginBtn;

	// Initializing the Page Objects:
	public CustomerLoginPage() {
		PageFactory.initElements(driver, this);
	}

	// Verifying CustomerLogin Header
	public String verifyCustomerLoginHeader() {
		String HeaderOfThePage = CustomerLoginHeading.getText();
		System.out.println(HeaderOfThePage);
		return HeaderOfThePage;
	}

	// Click on CreateAcctBtn
	public CreateNewCustomerAcctPage ClickOnCreateAcctBtn() {
		CreateAcctBtn.click();
		return new CreateNewCustomerAcctPage();
	}

	// Logging with Existing Acct Values
	public MyWishlistPage Login(String Email, String Password) {
		EmailField.sendKeys(Email);
		PasswordField.sendKeys(Password);
		LoginBtn.click();
		return new MyWishlistPage();
	}
}
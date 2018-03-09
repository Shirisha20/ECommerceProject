package com.guru99.qa.WebPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.guru99.qa.TestBase.TestBase;

public class CreateNewCustomerAcctPage extends TestBase {

	// Page Factory - OR:
	@FindBy(xpath = "//input[@name='firstname']")
	WebElement FirstNameField;

	@FindBy(xpath = "//input[@name='lastname']")
	WebElement LastNameField;

	@FindBy(xpath = "//input[@name='email']")
	WebElement EmailField;

	@FindBy(xpath = "//input[@name='password']")
	WebElement PasswordField;

	@FindBy(xpath = "//input[@name='confirmation']")
	WebElement ConfirmPwdField;

	@FindBy(xpath = "//span[contains(text(), 'Register')]")
	WebElement RegisterBtn;

	@FindBy(xpath = "/html/body/div/div/div[2]/div/div[2]/div/div/ul/li/ul/li/span")
	WebElement RegisterConfirmMsg;

	// Initializing the Page Objects:
	public CreateNewCustomerAcctPage() {
		PageFactory.initElements(driver, this);
	}

	// Verifying Page Title
	public String verifyCreateNewCustomerAcctTitle() {
		String PageTitle = driver.getTitle();
		System.out.println(PageTitle);
		return PageTitle;
	}

	// Create Valid Account
	public void ValidRegistration(String FName, String LName, String Email, String Pwd, String ConfirmPwd) {
		FirstNameField.sendKeys(FName);
		LastNameField.sendKeys(LName);
		EmailField.sendKeys(Email);
		PasswordField.sendKeys(Pwd);
		ConfirmPwdField.sendKeys(ConfirmPwd);
		RegisterBtn.click();
		String PageTitle = RegisterConfirmMsg.getText();
		Assert.assertEquals(PageTitle, "Thank you for registering with Main Website Store.");
	}

}

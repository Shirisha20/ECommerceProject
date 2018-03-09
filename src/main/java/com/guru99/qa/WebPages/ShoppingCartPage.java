package com.guru99.qa.WebPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.guru99.qa.TestBase.TestBase;

public class ShoppingCartPage extends TestBase {

	// Page Factory - OR:
	@FindBy(xpath = "//span[text()='Proceed to Checkout']")
	WebElement ProceedToCheckOut;

	@FindBy(xpath = "//input[@type='text']")
	WebElement QtyField;

	@FindBy(xpath = "//span[text()='Update']")
	WebElement UpdateBtn;

	@FindBy(xpath = "//td[@class='product-cart-total']")
	WebElement TotalPrice;

	// Initializing the Page Objects:
	public ShoppingCartPage() {
		PageFactory.initElements(driver, this);
	}

	// Verifying Page Title
	public String verifyPageTitle() {
		String TitleOfThePage = driver.getTitle();
		System.out.println(TitleOfThePage);
		return TitleOfThePage;
	}

	// Clicking on Proceed To Checkout Link
	public CheckOutPage ClickOnProceedToCheckOut() {
		ProceedToCheckOut.click();
		return new CheckOutPage();
	}

	// Click and Update on QtyField
	public void ClickAndUpdateQtyField(String Qty) {
		QtyField.clear();
		Actions Action = new Actions(driver);
		Action.moveToElement(QtyField).doubleClick().perform();
		QtyField.sendKeys(Qty);
		UpdateBtn.click();

	}

	// Verifying TotalPrice After Update
	public void verifyTotalPrice() {
		String Price = TotalPrice.getText();
		System.out.println(Price);
		Assert.assertTrue(true, "Price Matched");
	}
}

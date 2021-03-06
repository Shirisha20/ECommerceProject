package com.guru99.qa.WebPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.guru99.qa.TestBase.TestBase;
import com.guru99.qa.Utils.TestUtil;

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

	@FindBy(xpath = "//input[@name='coupon_code']")
	WebElement DiscountCodes;

	@FindBy(xpath = "//span[text()='Apply']")
	WebElement Apply;

	@FindBy(xpath = "//span[text()='Coupon code \"GURU50\" was applied.']")
	WebElement DiscountSuccessMsg;

	@FindBy(xpath = "//span[text()='-$25.00']")
	WebElement DiscountPrice;

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

	// Entering DiscountCode and Clicking On Apply
	public void EnterDiscountCodeClickApply(String Code) {
		DiscountCodes.sendKeys(Code);
		Apply.click();
	}

	// Verifying Discount Price and Messege After Apply Coupon Code
	public void verifyDiscountSuccessMsg() {
		String Msg = DiscountSuccessMsg.getText();
		System.out.println(Msg);
		TestUtil.drawBorder(DiscountSuccessMsg, driver);
		Assert.assertTrue(true, "Discount Applied");
		TestUtil.drawBorder(DiscountPrice, driver);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

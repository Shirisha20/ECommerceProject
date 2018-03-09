package com.guru99.qa.WebPages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.guru99.qa.TestBase.TestBase;
import com.guru99.qa.Utils.TestUtil;

public class CheckOutPage extends TestBase {

	// Page Factory - OR:
	@FindBy(id = "billing:street1")
	WebElement AddressField;

	@FindBy(id = "billing:city")
	WebElement CityField;

	@FindBy(id = "billing:region_id")
	WebElement StateField;

	@FindBy(id = "billing:postcode")
	WebElement ZipField;

	@FindBy(id = "billing:country_id")
	WebElement CountryField;

	@FindBy(id = "billing:telephone")
	WebElement TelephoneField;

	@FindBy(xpath = "/html/body/div/div/div[2]/div/div[1]/ol/li[1]/div[2]/form/div/div/button")
	WebElement Continue;

	@FindBy(xpath = "//*[@id=\"billing-buttons-container\"]/button/span/span")
	WebElement ContinueBtn;

	@FindBy(xpath = "//label[text()='Check / Money order ']")
	WebElement CheckMoneyOrder;

	@FindBy(xpath = "/html/body/div/div/div[2]/div/div[1]/ol/li[5]/div[2]/div/div[2]/div/button")
	WebElement PlaceOrder;

	@FindBy(xpath = "//h2[text()='Thank you for your purchase!']")
	WebElement OrderSuccessMsg;

	@FindBy(xpath = "//p[contains(text(), 'Your order # is: ')]")
	WebElement OrderNumber;

	@FindBy(xpath = "//*[@id=\"billing:use_for_shipping_yes\"]")
	WebElement ShipToThisAddress;

	@FindBy(xpath = "//*[@id=\"shipping-method-buttons-container\"]/button/span/span")
	WebElement ShippingMethodContinue;

	@FindBy(xpath = "//*[@id=\"payment-buttons-container\"]/button")
	WebElement PaymentInformationContinue;

	// Initializing the Page Objects:
	public CheckOutPage() {
		PageFactory.initElements(driver, this);
	}

	// Verifying Page Ttile
	public String verifyPageTitle() {
		String TitleOfThePage = driver.getTitle();
		System.out.println(TitleOfThePage);
		return TitleOfThePage;
	}

	// Enter full Values in the Shipping address
	public void ShippingDetails(String Address, String City, String Zip, String PhoneNum) {
		AddressField.clear();
		AddressField.sendKeys(Address);
		CityField.clear();
		CityField.sendKeys(City);
		StateField.click();
		Select selectState = new Select(StateField);
		selectState.selectByIndex(43);
		ZipField.clear();
		ZipField.sendKeys(Zip);
		TelephoneField.clear();
		TelephoneField.sendKeys(PhoneNum);
		ContinueBtn.click();
		ShippingMethodContinue.click();
		CheckMoneyOrder.click();
		PaymentInformationContinue.click();
		PlaceOrder.click();
		String Messege = OrderSuccessMsg.getText();
		System.out.println(Messege);
		Assert.assertEquals(Messege, "THANK YOU FOR YOUR PURCHASE!");
		TestUtil.drawBorder(OrderNumber, driver);
		try {
			TestUtil.ScreenCapture();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Entering Values in the Required Field
	public void EnterValues() {

		ShipToThisAddress.click();
		ContinueBtn.click();
		ShippingMethodContinue.click();
		CheckMoneyOrder.click();
		PaymentInformationContinue.click();
		PlaceOrder.click();
		String Messege = OrderSuccessMsg.getText();
		System.out.println(Messege);
		Assert.assertEquals(Messege, "THANK YOU FOR YOUR PURCHASE!");
		TestUtil.drawBorder(OrderNumber, driver);
		try {
			TestUtil.ScreenCapture();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

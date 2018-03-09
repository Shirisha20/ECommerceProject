package com.guru99.qa.WebPages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.guru99.qa.TestBase.TestBase;
import com.guru99.qa.Utils.BrowserAlertHelper;
import com.guru99.qa.Utils.TestUtil;

public class MobilePage extends TestBase {

	// Page Factory - OR:
	@FindBy(xpath = "//h1[text()= 'Mobile']")
	WebElement MobileTitle;

	@FindBy(xpath = "//select[@title='Sort By']")
	WebElement SortByDropDown;

	@FindBy(xpath = "//span[contains(@id, 'product-price-1')]")
	WebElement SonyXPeriaCost;

	@FindBy(xpath = "//span[contains(@id, 'product-price-3')]")
	WebElement SamsungCost;

	@FindBy(xpath = "//span[contains(@id, 'product-price-2')]")
	WebElement IPhoneCost;

	@FindBy(linkText = "Sony Xperia")
	WebElement SonyXPeriaLink;

	@FindBy(xpath = "//a[@title='Xperia']//following::button[@type='button']")
	WebElement XPeriaAddToCartBtn;

	@FindBy(xpath = "//span[contains(text(), '$500')]//following::a[3]")
	WebElement IPhoneAddToCompare;

	@FindBy(xpath = "//span[contains(text(), '$130')]//following::a[8]")
	WebElement SamsungAddToCompare;

	@FindBy(xpath = "//span[contains(text(), '$100')]//following::a[3]")
	WebElement SonyAddToCompare;

	@FindBy(xpath = "//span[text()='Compare']")
	WebElement Compare;

	@FindBy(xpath = "//span[contains(text(), '$500')]")
	WebElement IPhonePrice;

	@FindBy(xpath = "//span[contains(text(), '$130')]")
	WebElement SamsungPrice;

	@FindBy(xpath = "//span[contains(text(), '$100')]")
	WebElement SonyPrice;

	// Initializing the Page Objects:
	public MobilePage() {
		PageFactory.initElements(driver, this);
	}

	// Verifying Mobile Page Title
	public String verifyMobilePageTitle() {
		String TitleOfTheSite = MobileTitle.getText();
		System.out.println(TitleOfTheSite);
		return TitleOfTheSite;
	}

	// Selecting An Element from DropDown
	public void DropDown() {
		Select DropDown = new Select(SortByDropDown);
		DropDown.selectByIndex(1);
	}

	// Verifying Mobile Costs
	public String verifySonyMobileCost() {
		String MCost = SonyXPeriaCost.getText();
		System.out.println(MCost);
		return MCost;
	}

	// Clicking on SonyXPeriaLink
	public SonyDetailedPage ClickOnSony() {
		SonyXPeriaLink.click();
		return new SonyDetailedPage();
	}

	// Clicking on SonyXPeria AddToCart Button
	public SonyCheckOutPage ClickOnSonyAddToCartBtn() {
		XPeriaAddToCartBtn.click();
		return new SonyCheckOutPage();
	}

	// Clicking On AddToCompare Link and Compare to Compare Prices for Two Mobiles
	public void ComparePrices() {
		IPhoneAddToCompare.click();
		SonyAddToCompare.click();
		Compare.click();
		BrowserAlertHelper.SwitchWindow(driver);
		TestUtil.drawBorder(IPhonePrice, driver);
		TestUtil.drawBorder(SonyPrice, driver);
		try {
			TestUtil.ScreenCapture();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

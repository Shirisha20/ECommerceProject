package com.guru99.qa.WebPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.guru99.qa.TestBase.TestBase;

public class SonyDetailedPage extends TestBase {

	// Page Factory - OR:
	@FindBy(xpath = "//span[contains(@id, 'product-price-1')]")
	WebElement SonyCost;

	// Initializing the Page Objects:
	public SonyDetailedPage() {
		PageFactory.initElements(driver, this);
	}

	// Get Title of the Page
	public void PageTitle() {
		driver.getTitle();
	}

	// Verifying Sony Cost on SonyDetailedPage
	public String verifySonyCost() {
		String Cost = SonyCost.getText();
		System.out.println(Cost);
		return Cost;
	}

}

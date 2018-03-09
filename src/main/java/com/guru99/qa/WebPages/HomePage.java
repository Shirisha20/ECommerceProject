package com.guru99.qa.WebPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.guru99.qa.TestBase.TestBase;

public class HomePage extends TestBase {

	// Page Factory - OR:
	@FindBy(xpath = "//div[@class='page-title']")
	WebElement SiteTitle;

	@FindBy(xpath = "//a[text()='Mobile']")
	WebElement MobileLink;

	@FindBy(xpath = "/html/body/div/div/div[3]/div/div[4]/ul/li[1]/a")
	WebElement MyAccountLink;

	@FindBy(xpath = "/html/body/div/div/header/div/div[3]/nav/ol/li[2]/a")
	WebElement TvLink;

	// Initializing the Page Objects:
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	// Verifying SiteTitle
	public String verifySiteTitle() {
		String TitleOfTheSite = SiteTitle.getText();
		System.out.println(TitleOfTheSite);
		return TitleOfTheSite;
	}

	// Click on MobileLink
	public MobilePage ClickOnMobile() {
		MobileLink.click();
		return new MobilePage();
	}

	// Click on MyAccountLink
	public CustomerLoginPage ClickOnMyAcctLink() {
		MyAccountLink.click();
		return new CustomerLoginPage();
	}

	// Clicking on TvLink
	public TvPage ClickOnTvLink() {
		TvLink.click();
		return new TvPage();
	}

}

package com.guru99.qa.WebPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.guru99.qa.TestBase.TestBase;

public class TvPage extends TestBase {

	// Page Factory - OR:
	@FindBy(xpath = "/html/body/div/div/div[2]/div/div[2]/div[1]/div[2]/ul/li[1]/div/div[3]/ul/li[1]/a")
	WebElement LgAddToWishList;

	// Initializing the Page Objects:
	public TvPage() {
		PageFactory.initElements(driver, this);
	}

	// Verifying SiteTitle
	public String verifyTvPageTitle() {
		String TitleOfThePage = driver.getTitle();
		System.out.println(TitleOfThePage);
		return TitleOfThePage;
	}

	// Clicking on LgAddToWishList
	public CustomerLoginPage ClickOnLgAddToWishList() {
		Actions Action = new Actions(driver);
		Action.moveToElement(LgAddToWishList).doubleClick().perform();
		return new CustomerLoginPage();
	}

}

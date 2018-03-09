package com.guru99.qa.Utils;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * this class for all methods we are used to handle browser alert.
 */
public class BrowserAlertHelper {

	public String parent_window;
	public String popup_window;

	// this is method to check if there any browser alert.
	public static boolean isDialogPresent(WebDriver driver) {
		try {
			driver.getTitle();
			return false;
		} catch (UnhandledAlertException e) {
			// Modal dialog showed
			return true;
		}
	}

	// this is method to accept browser alert.
	public static void acceptBrowserAlert(WebDriver driver) {

		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	// this is method to decline browser alert.
	public static void declineBrowserAlert(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}

	// get alert text
	public String getBrowserAlertText(WebDriver driver) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 2);
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			System.out.println(alertText);
			return alertText;
		} catch (Exception e) {
			System.out.println("no browser alert showing");
		}
		return null;
	}

	// get window Text
	public static void SwitchWindow(WebDriver driver) {
		Set<String> handler = driver.getWindowHandles();
		Iterator<String> it = handler.iterator();
		String parentWindowId = it.next();
		System.out.println("parent window id:" + parentWindowId);
		String childWindowId = it.next();
		System.out.println("Child window id:" + childWindowId);
		driver.switchTo().window(childWindowId);
		System.out.println("child window pop up title" + driver.getTitle());
		driver.close();
		driver.switchTo().window(parentWindowId);
		System.out.println("parent window title" + driver.getTitle());
	}

}

package com.qa.orangehrm.pagelayers;

import org.openqa.selenium.WebDriver;

import com.qa.orangehrm.utilities.BrowserUtility;
import com.qa.orangehrm.utilities.ElementUtilities;

public class BasePage {

	protected WebDriver driver;
	protected BrowserUtility bu;
	protected ElementUtilities eu;
	
	public BasePage (WebDriver driver) {
		this.driver=driver;
		System.out.println("Here driver came super driver and went to respective calling class-> "+this.driver);
		this.bu = new BrowserUtility(driver);
		this.eu = new ElementUtilities(driver);
	}
}

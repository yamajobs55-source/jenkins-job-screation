package com.qa.orangehrm.pagelayers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminPage extends BasePage{
	

private final By adminPageHeader=By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']");
private final By searchUser=By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
private final By searchbtn=By.xpath("//button[@type='submit']");
private final By recordmsg=By.xpath("//span[@class='oxd-text oxd-text--span']");//here they give /[1] in xpath

public AdminPage(WebDriver driver) {
	super(driver);
	// TODO Auto-generated constructor stub
}

public boolean verifyadminPageHeading() {
	return driver.findElement(adminPageHeader).isDisplayed();
}
	public boolean searchforUser(String enteredUserName)
	{
		driver.findElement(searchUser).sendKeys(enteredUserName);
		System.out.println("the entered useranem is :"+enteredUserName);
		driver.findElement(searchbtn).click();;
		try {
			return  driver.findElement(recordmsg).isDisplayed();
			//here this try and catch method not displayed in the output
		}
		catch(Exception e)
		{
			System.out.println("The record is not displayed");
			return false;
		}
		
	}
	
	
	
}

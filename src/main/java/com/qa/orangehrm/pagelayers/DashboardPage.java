package com.qa.orangehrm.pagelayers;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.orangehrm.exception.FrameworkExceptions;

public class DashboardPage extends BasePage{
	//remove this line
//private WebDriver driver;
	
	private final By dashboardPageHeading = By.cssSelector(".oxd-topbar-header-breadcrumb>h6");
	private final By menuList = By.xpath("//*[local-name()='svg']/following-sibling::span");
	private final By profileMenu = By.cssSelector(".oxd-userdropdown-tab");
	private final By logoutOption = By.xpath("//a[.='Logout']");
	
	public DashboardPage(WebDriver driver) {
		super(driver);
	}
	
	public String verifyDashboardPageHeading() {
		String headingText = driver.findElement(dashboardPageHeading).getText();
		System.out.println("The dashboard page header text is :"+headingText);
		return headingText;
	}
	
	public int verifyListCountOfMenuList() {
		List<WebElement> menuListOptions = driver.findElements(menuList);
		int actualMenuListCount = menuListOptions.size();
		return actualMenuListCount;
	}
	
	
	public BasePage selctMenu(String expectedMenu) {
		List<WebElement> listOfMenu = driver.findElements(menuList);
		int totalmenucount = listOfMenu.size();
		System.out.println("Total number of menu list is :"+totalmenucount);
		for(WebElement element:listOfMenu) {
			String actualMenu = element.getText();
			if(actualMenu.equals(expectedMenu)) {
				element.click();
				switch(expectedMenu) {
				case "Admin":
					return new AdminPage(driver);
				case "PIM":
					return new PIMPage(driver);
				case "Leave":
					return new LeavePage(driver);
				case "Recruitment":	
					return new RecruitmentPage(driver);
				case "Time":
					return new TimePage(driver);
					default:
						System.out.println("Inavalid Menu");
						throw new FrameworkExceptions("Invalid Menu list:"+expectedMenu);
				}
			}
		}
		
		throw new FrameworkExceptions("Invalid Menu list:"+expectedMenu);
	}
		
	
	
	public void logoutApplication() {
		driver.findElement(profileMenu).click();
		driver.findElement(logoutOption).click();
	}
}

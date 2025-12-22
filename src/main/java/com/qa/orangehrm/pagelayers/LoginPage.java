package com.qa.orangehrm.pagelayers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.qameta.allure.Step;

public class LoginPage extends BasePage {
	//private WebDriver driver;
	
	
	//Declaration of locators

	private final By loginPageHeading =By.xpath("//h5[text()='Login']");
	private final By username =By.name("username");
	private final By psw =By.name("password");
	private final By loginbtn =By.xpath("//button[@type='submit']");
	private final By forgottenpsw =By.cssSelector(".orangehrm-login-forgot");
	
	//initialization
	
	 
	public LoginPage( WebDriver driver) {
                                         	//this.driver=driver;
            super(driver);  
            System.out.println("Driver is in LoginPage->"+driver);
	}
	//utilization
	@Step("verifyloginpageheadding")
	public boolean verifyloginpageheadding() {
		 
		WebElement header = driver.findElement(loginPageHeading);
		boolean h1 = header.isDisplayed();
		return h1;
		
	}
	
	@Step("verifyloginpageurl")
	public String verifyloginpageurl() {
			String currentUrl = driver.getCurrentUrl();
			System.out.println("the login page url is "+currentUrl);
			return currentUrl;
		
		
	}
	@Step("verfyloginPageTitle")
	public String verfyloginPageTitle() {
		
		String loginpagetitle = driver.getTitle();
		System.out.println("Login page title is :"+loginpagetitle);
		 return loginpagetitle;
	}
	@Step("verifyforgotpswexist")
	public boolean verifyforgotpswexist() {
		return driver.findElement(forgottenpsw).isDisplayed();

	}
	@Step("verifyforgotpswexist")
	public void dologin(String appusn,String apppsw) {
		driver.findElement(username).sendKeys(appusn);
		driver.findElement(psw).sendKeys(apppsw);
		driver.findElement(loginbtn).click();
	}
	@Step("verifyforgotpswexist")
	public void clickforgotpswlink() {
		
		driver.findElement(forgottenpsw).click();
	}
	@Step("doLogin by entering usn:{0} and psw:{1}")
	//here i am applying browser and element utilities
	public DashboardPage ddoLogin(String appUsn,String appPsw) throws Exception  {
		WebElement usnTf = bu.locateElement(username);
		eu.doSendkeys(usnTf, appUsn);
		WebElement pswTf = bu.locateElement(psw);
		eu.doSendkeys(pswTf, appPsw);
		WebElement logiBtn = bu.locateElement(loginbtn);                      //DashboardPage
		eu.doClick(logiBtn);
		 return new DashboardPage(driver);
	} 
	
	
	
	
	
//	public DashboardPage ddoLogin(String appUsn,String appPsw) {
//		driver.findElement(username).sendKeys(appUsn);
//		driver.findElement(psw).sendKeys(appPsw);
//		driver.findElement(loginbtn).click();                       //DashboardPage before applying utilities
//		 return new DashboardPage(driver);
//	} 
	

}

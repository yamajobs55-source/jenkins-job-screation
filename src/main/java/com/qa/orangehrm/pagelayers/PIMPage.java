package com.qa.orangehrm.pagelayers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PIMPage extends BasePage {
	
	
	public PIMPage(WebDriver driver) {
		super(driver);
	}
	
	//pim page
	By addemp=By.xpath("");
	
	
	//add emp page 
	By fnTf=By.xpath("");
	By mnTf=By.xpath("");
	By lnTf=By.xpath("");
	By save=By.xpath("");
	By cancel=By.xpath("");
	
	public void clickOnAddEmp() {
		driver.findElement(addemp).click();
				
	}
	
	public void addEmpDetails(String fn,String mn,String ln) throws InterruptedException {
		driver.findElement(fnTf).sendKeys(fn);;
		driver.findElement(mnTf).sendKeys(mn);;
		driver.findElement(lnTf).sendKeys(ln);;
		driver.findElement(save).click();;
		driver.findElement(cancel).click();;
		Thread.sleep(2000);
		clickOnAddEmp();
	}
	
	
	
	
	
	
	
	
	
	
	
}

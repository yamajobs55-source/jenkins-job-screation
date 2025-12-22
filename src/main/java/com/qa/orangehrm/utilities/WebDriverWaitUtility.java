package com.qa.orangehrm.utilities;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.orangehrm.Validation.ValidationHelper;
import com.qa.orangehrm.exception.ElementExceptions;

public class WebDriverWaitUtility extends BaseUtility {
	 WebDriverWait ww;
  static final int SHORT_WAIT =3;
  static final int MED_WAIT =5;
  static final  int LONG_WAIT =10;
	public WebDriverWaitUtility(WebDriver driver) {
		super(driver);	}
	
	
  public WebDriverWait driverWait() {
	   ww = new WebDriverWait(driver, Duration.ofSeconds(MED_WAIT));
	   return ww;
  }
  
  public WebDriverWait getDriverWait() {
	  return driverWait();
  }
  
  //presence of element->DOM
  public WebElement checkPresenceofElement(By locator) {
	  ValidationHelper.validateLocator(locator, "checkPresenceofElement");
	  try {
		return getDriverWait().until(ExpectedConditions.presenceOfElementLocated(locator));
	} catch (Exception e) {
		
	throw new ElementExceptions("[WebDriverWaitUtility]-presence of element is failed=="+e);
	}
  }
  
  //Visisbility of element-UI
  public WebElement checkVisisbilityofElement(By locator) {
	  ValidationHelper.validateLocator(locator, "checkVisisbilityofElement");
	  try {
		return getDriverWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
	} catch (Exception e) {
		
	throw new ElementExceptions("[WebDriverWaitUtility]-checkVisisbilityofElement is failed=="+e);
	}
  }
  
  //Element clickable
  
  public WebElement checkElementClickable(By locator) {
	  ValidationHelper.validateLocator(locator, "checkElementClickable");
	  try {
		return getDriverWait().until(ExpectedConditions.elementToBeClickable(locator));
	} catch (Exception e) {
		
	throw new ElementExceptions("[WebDriverWaitUtility]-checkElementClickable is failed=="+e);
	}
  }
  
  //url contains
  
  public Boolean checkExpextedUrl(String ExpectedUrl) {
	  ValidationHelper.validateString(ExpectedUrl, "checkExpextedUrl");
	  try {
		return getDriverWait().until(ExpectedConditions.urlContains(ExpectedUrl));
	} catch (Exception e) {
		
	throw new ElementExceptions("[WebDriverWaitUtility]-checkExpextedUrl is failed because it is not matching =="+e);
	}
  }
  
  //Title contains
  
  public Boolean checkExpextedTitle(String ExpectedTitle) {
	  ValidationHelper.validateString(ExpectedTitle, "ExpectedTitle");
	  try {
		return getDriverWait().until(ExpectedConditions.titleContains(ExpectedTitle));
	} catch (Exception e) {
		
	throw new ElementExceptions("[WebDriverWaitUtility]-ExpectedTitle is failed because it is not matching =="+e);
	}
  }
  
  
}

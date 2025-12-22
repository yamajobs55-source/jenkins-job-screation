package com.qa.orangehrm.frameworkObjects;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class UtilityObjects {
	
	public static Actions actionsobject(WebDriver driver) {
		return new Actions(driver);
	}


	public static Select selectobject(WebElement element) {
		return new Select(element);
	}
//	
//	public static Robot robotobject(WebElement element) {
//		return new Robot(element);
//	}
}

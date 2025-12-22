package com.qa.orangehrm.utilities;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.orangehrm.Validation.ValidationHelper;
import com.qa.orangehrm.exception.ElementExceptions;
import com.qa.orangehrm.frameworkObjects.UtilityObjects;

public class DropdownUtility extends BaseUtility {
public DropdownUtility(WebDriver driver) {
		super(driver);
		
	}

	public void selectByValue(WebElement dropdown, String value) throws Exception {
		ValidationHelper.validateElement(dropdown, "selectByValue");
		ValidationHelper.validateString(value, "selectByValue");
		try {
			UtilityObjects.selectobject(dropdown).selectByValue(value);
		}catch(RuntimeException e) {
			throw new ElementExceptions("[DropdownUtility]-selectByValue is failed"+e);
		}
		
	}
	
	
	public void selectByindex(WebElement dropdown, int index) throws Exception {
		ValidationHelper.validateElement(dropdown, "selectByindex");
		if(index<0) {
			throw new ElementExceptions("[DropdownUtility]-index canot be less than 0");
		}
		try {
			UtilityObjects.selectobject(dropdown).selectByIndex(index);
		}catch(RuntimeException e) {
			throw new ElementExceptions("[DropdownUtility]-selectByindex is failed"+e);
		}
		
	}
	
	public void selectByVisibletext(WebElement dropdown, String visibletext) throws Exception {
		ValidationHelper.validateElement(dropdown, "selectByVisibletext");
		ValidationHelper.validateString(visibletext, "selectByVisibletext");
		try {
			UtilityObjects.selectobject(dropdown).selectByVisibleText(visibletext);
		}catch(RuntimeException e) {
			throw new ElementExceptions("[DropdownUtility]-selectByVisibletext is failed"+e);
		}
		
	}
	

	public void selectByContainsVisibletext(WebElement dropdown, String containsvisibletext) throws Exception {
		ValidationHelper.validateElement(dropdown, "selectByContainsVisibletext");
		ValidationHelper.validateString(containsvisibletext, "selectByContainsVisibletext");
		try {
			UtilityObjects.selectobject(dropdown).selectByContainsVisibleText(containsvisibletext);
		}catch(RuntimeException e) {
			throw new ElementExceptions("[DropdownUtility]-selectByContainsVisibletext is failed"+e);
		}
		
	}
	
	public void deselectByValue(WebElement dropdown, String value) throws Exception {
		ValidationHelper.validateElement(dropdown, "deselectByValue");
		ValidationHelper.validateString(value, "deselectByValue");
		try {
			UtilityObjects.selectobject(dropdown).deselectByValue(value);
		}catch(RuntimeException e) {
			throw new ElementExceptions("[DropdownUtility]-deselectByValue is failed"+e);
		}
		
	}
	
	
	public void deselectByindex(WebElement dropdown, int index) throws Exception {
		ValidationHelper.validateElement(dropdown, "deselectByindex");
		if(index<0) {
			throw new ElementExceptions("[DropdownUtility]-index canot be less than 0");
		}
		try {
			UtilityObjects.selectobject(dropdown).deselectByIndex(index);
		}catch(RuntimeException e) {
			throw new ElementExceptions("[DropdownUtility]-selectByindex is failed"+e);
		}
		
	}
	
	public void deselectByVisibletext(WebElement dropdown, String visibletext) throws Exception {
		ValidationHelper.validateElement(dropdown, "deselectByVisibletext");
		ValidationHelper.validateString(visibletext, "deselectByVisibletext");
		try {
			UtilityObjects.selectobject(dropdown).deselectByVisibleText(visibletext);
		}catch(RuntimeException e) {
			throw new ElementExceptions("[DropdownUtility]-deselectByVisibletext is failed"+e);
		}
		
	}
	

	public void deselectByContainsVisibletext(WebElement dropdown, String containsvisibletext) throws Exception {
		ValidationHelper.validateElement(dropdown, "deselectByContainsVisibletext");
		ValidationHelper.validateString(containsvisibletext, "deselectByContainsVisibletext");
		try {
			UtilityObjects.selectobject(dropdown).deSelectByContainsVisibleText(containsvisibletext);
		}catch(RuntimeException e) {
			throw new ElementExceptions("[DropdownUtility]-deselectByContainsVisibletext is failed"+e);
		}
		
	}
	
	public void deselectAll(WebElement dropdown) {
		
	}
	
	
	
	
	
	
	
	public WebElement fetchFirstSelectedOption(WebElement dropdown) throws Exception {
		ValidationHelper.validateElement(dropdown, "fetchFirstSelectedOption");
		try {
			WebElement firstSelectedOption = UtilityObjects.selectobject(dropdown).getFirstSelectedOption();
			System.out.println("The first selected option is:"+firstSelectedOption.getText());
			return firstSelectedOption;
		}catch(RuntimeException e) {
			throw new ElementExceptions("[DropdownUtility]-fetchFirstSelectedOption is failed"+e);
		}
		
	}
	
	public List<WebElement> fetchAllSelectedOption(WebElement dropdown) throws Exception {
		ValidationHelper.validateElement(dropdown, "fetchAllSelectedOption");
		try {
			List<WebElement> Options = UtilityObjects.selectobject(dropdown).getAllSelectedOptions();
			for(WebElement option:Options) {
			
			System.out.println("The first selected option is:"+option.getText());
			}
			return Options;
		}catch(RuntimeException e) {
			throw new ElementExceptions("[DropdownUtility]-fetchAllSelectedOption is failed"+e);
			}
		}
		
		
		
		
		public List<WebElement> getOptions(WebElement dropdown) throws Exception {
			ValidationHelper.validateElement(dropdown, "getOptions");
			try {
				List<WebElement> Options = UtilityObjects.selectobject(dropdown).getOptions();
				for(WebElement option:Options) {
				
				System.out.println("The first selected option is:"+option.getText());
				}
				return Options;
			}catch(RuntimeException e) {
				throw new ElementExceptions("[DropdownUtility]-getOptions is failed"+e);
			}
	}
	
		public boolean checkMultiple(WebElement dropdown) throws Exception {
			ValidationHelper.validateElement(dropdown, "checkMultiple");
			try {
				boolean selected = UtilityObjects.selectobject(dropdown).isMultiple();
				return selected;
			}catch(RuntimeException e) {
				throw new ElementExceptions("[DropdownUtility]-checkMultiple is failed"+e);
			}
	}
	
	
	
	
	
	
	
	
	
	//select options
	//SelectByvalue
	//selectByindex
	//SelectByvisibletext
	//selectBycontainsvisibletext
}

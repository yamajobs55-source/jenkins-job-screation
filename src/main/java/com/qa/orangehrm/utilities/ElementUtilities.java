package com.qa.orangehrm.utilities;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.orangehrm.Validation.ValidationHelper;
import com.qa.orangehrm.exception.ElementExceptions;

public class ElementUtilities extends BaseUtility {
//private WebDriver driver;
public ElementUtilities(WebDriver driver) {
	super(driver);
  }

	public void doClick(WebElement elementName) throws Exception{
		ValidationHelper.validateElement(elementName, "doClick");
		try {
			elementName.click();
		} catch (Exception e) {
			throw new ElementExceptions("=== [ActionsUtilities] -doClick action is not performing on element "+elementName+"===");
		}
		
	}
	public void doClear(WebElement elementName) throws Exception{
		ValidationHelper.validateElement(elementName, "doClear");
		try {
			elementName.clear();
		} catch (Exception e) {
			throw new ElementExceptions("=== [ActionsUtilities] -doClear action is not performing on element "+elementName+"===");
		}
	}
	public void doSendkeys(WebElement elementName,String value) throws Exception{
		ValidationHelper.validateElement(elementName, "doSendKeys");
		ValidationHelper.validateString(value, "doSendkeys");
		try {
			elementName.sendKeys(value);
		} catch (Exception e) {
			throw new ElementExceptions("=== [ActionsUtilities] -doSendkeys action is not performing on element "+elementName+"===");
		}
	}
	public String fetchInnerText(WebElement elementName) throws Exception{
		ValidationHelper.validateElement(elementName, "doClear");
		try {
			return elementName.getText();
		} catch (Exception e) {
			throw new ElementExceptions("=== [ActionsUtilities] -fetchInnerText action is not performing on element "+elementName+"===");
		}
	}
	public Dimension fetchElementSize(WebElement elementName) throws Exception{
		ValidationHelper.validateElement(elementName, "fetchElementSize");
		System.out.println("The ElementSize is "+elementName.getSize());
		try {
			return elementName.getSize();
		} catch (Exception e) {
			throw new ElementExceptions("=== [ActionsUtilities] -fetchElementSize action is not performing on element "+elementName+"===");
		}
	}
	public int fetchElementWidth(WebElement elementName) throws Exception{
		ValidationHelper.validateElement(elementName, "fetchElementWidth");
		System.out.println("The ElementWidth is "+elementName.getSize().getWidth());
		try {
			return elementName.getSize().getWidth();
		} catch (Exception e) {
			throw new ElementExceptions("=== [ActionsUtilities] -fetchElementWidth action is not performing on element "+elementName+"===");
		}
		
	}
	public int fetchElementHeight(WebElement elementName) throws Exception{
		ValidationHelper.validateElement(elementName, "fetchElementHeight");
		System.out.println("The ElementHeight is "+elementName.getSize().getHeight());
		try {
			return elementName.getSize().getHeight();
		} catch (Exception e) {
			throw new ElementExceptions("=== [ActionsUtilities] -fetchElementHeight action is not performing on element "+elementName+"===");
		}
	}
	public Point fetchElementLocation(WebElement elementName) throws Exception{
		ValidationHelper.validateElement(elementName, "fetchElementLocation");
		System.out.println("The ElementLocation is "+elementName.getLocation());
		try {
			return elementName.getLocation();
		} catch (Exception e) {
			throw new ElementExceptions("=== [ActionsUtilities] -fetchElementLocation action is not performing on element "+elementName+"===");
		}
	}
	public int fetchXaxis(WebElement elementName) throws Exception {
		ValidationHelper.validateElement(elementName, "fetchXaxis");
		System.out.println("The ElementXaxis is "+elementName.getLocation().getX());
		try {
			return elementName.getLocation().getX();
		} catch (Exception e) {
			throw new ElementExceptions("=== [ActionsUtilities] -fetchXaxis action is not performing on element "+elementName+"===");
		}
	}
	public int fetchYaxis(WebElement elementName) throws Exception {
		ValidationHelper.validateElement(elementName, "fetchYaxis");
		System.out.println("The ElementYaxis is "+elementName.getLocation().getY());
		try {
			return elementName.getLocation().getY();
		} catch (Exception e) {
			throw new ElementExceptions("=== [ActionsUtilities] -fetchYaxis action is not performing on element "+elementName+"===");
		}
	}
	public boolean checkElementIsDisplyed(WebElement elementName) throws Exception{
		ValidationHelper.validateElement(elementName, "checkElementIsDisplyed");
	   try {
		   return elementName.isDisplayed();
	} catch (Exception e) {
		throw new ElementExceptions("=== [ActionsUtilities] -checkElementIsDisplyed action is not performing on element "+elementName+"===");
	         }
	}
	public boolean checkElementIsSelected(WebElement elementName) throws Exception {
		ValidationHelper.validateElement(elementName, "checkElementIsSelected");
	    try {
	    	return elementName.isSelected();
		} catch (Exception e) {
			throw new ElementExceptions("=== [ActionsUtilities] -checkElementIsSelected action is not performing on element "+elementName+"===");
		}
	}
	public boolean checkElementIsEnabled(WebElement elementName) throws Exception {
		ValidationHelper.validateElement(elementName, "checkElementIsEnabled");
	    try {
	    	return elementName.isEnabled();
		} catch (Exception e) {
			throw new ElementExceptions("=== [ActionsUtilities] -checkElementIsEnabled action is not performing on element "+elementName+"===");
		}
	}
	public String fetchElementTagName(WebElement elementName) throws Exception {
		ValidationHelper.validateElement(elementName, "fetchElementTagName");
		System.out.println("The ElementTagName is "+elementName.getTagName());
		try {
			return elementName.getTagName();
		} catch (Exception e) {
			throw new ElementExceptions("=== [ActionsUtilities] -fetchElementTagName action is not performing on element "+elementName+"===");
		}
	}
	public  String fetchElementAttributeValue(WebElement elementName,String attributeName) throws Exception {
		ValidationHelper.validateElement(elementName, "fetchElementAttributeValue");
		ValidationHelper.validateString(attributeName, "fetchElementAttributeValue");
		try {
			return elementName.getAttribute(attributeName);
		} catch (Exception e) {
			throw new ElementExceptions("=== [ActionsUtilities] -fetchElementAttributeValue action is not performing on element "+elementName+"===");
		}
	}
	public String fetchCssValue(WebElement elementName,String elementKey) throws Exception {
		ValidationHelper.validateElement(elementName, "fetchCssValue");
		ValidationHelper.validateString(elementKey, "fetchCssValue");
		try {
			return elementName.getCssValue(elementKey);
		} catch (Exception e) {
			throw new ElementExceptions("=== [ActionsUtilities] -fetchCssValue action is not performing on element "+elementName+"===");
		}
	}
}
  
//  public void doClick(WebElement elementname) throws Exception {
//	  ValidationHelper.validateElement(elementname, "doClick");
//	  try {
//		  elementname.click();
//	  }catch(Exception e) {
//		  throw new ElementExceptions("===[ElementUtility] - the fetchedElement is not matching on element"+elementname+"===");
//	  }
//	  
//	 
//  }
//  
//  public void doclear(WebElement elementname) throws Exception {
//	  ValidationHelper.validateElement(elementname, "doClear");
//	  elementname.click();
//  }
//  
//  public void doSendKeys(WebElement elementName,String value) throws Exception {
//	  ValidationHelper.validateElement(elementName, "dosendkeys");
//	  ValidationHelper.validateString(value, "doSendKeys");
//	  elementName.sendKeys(value);
//  }
//  public String fetchInnerText(WebElement elementName) throws Exception {
//	  ValidationHelper.validateElement(elementName, "gettext");
//	  System.out.println("The inner text is "+elementName.getText());
//	  return elementName.getText();
//	}
//  public Dimension fetchElementSize(WebElement elementName) throws Exception {
//	  ValidationHelper.validateElement(elementName, "fetchElementSize");
//	  System.out.println("The elementSize is"+elementName.getSize());
//	  return elementName.getSize();
//  }
//  public int fetchElementWidth(WebElement elementName) throws Exception {
//	  ValidationHelper.validateElement(elementName, "fetchElementWidth");
//	  System.out.println("The ElementWidth  is"+elementName.getSize().getWidth());
//	  return elementName.getSize().getWidth();
//  }
//  public int fetchElementHeight(WebElement elementName) throws Exception {
//	  ValidationHelper.validateElement(elementName, "fetchElementSize");
//	  System.out.println("The ElementHeight is"+elementName.getSize().getHeight());
//	  return elementName.getSize().getHeight();
//  }	
//  
//  public Point fetchElementLocation(WebElement elementName) throws Exception {
//	  ValidationHelper.validateElement(elementName, "fetchElementLocation");
//	  System.out.println("The ElementLocation is"+elementName.getLocation());
//	  return elementName.getLocation();
//  }	
//  public int fetchElementXaxis(WebElement elementName) throws Exception {
//	  ValidationHelper.validateElement(elementName, "fetchElementXaxis");
//	  System.out.println("The ElementXaxis is"+elementName.getLocation().getX());
//	  return elementName.getLocation().getX();
//  }	
//  public int fetchElementYaxis(WebElement elementName) throws Exception {
//	  ValidationHelper.validateElement(elementName, "fetchElementYaxis");
//	  System.out.println("The ElementYaxis is"+elementName.getLocation().getY());
//	  return elementName.getLocation().getY();
//  }	
//  public boolean checkElementIsDisplayed(WebElement elementName) throws Exception {
//	  ValidationHelper.validateElement(elementName, "checkElementIsDisplayed");
//	  System.out.println("The ElementIsDisplayed is"+elementName.isDisplayed());
//	  return elementName.isDisplayed();
//  }	
//  public boolean checkElementIsEnable(WebElement elementName) throws Exception {
//	  ValidationHelper.validateElement(elementName, "checkElementIsEnable");
//	  System.out.println("The ElementIsEnable is"+elementName.isEnabled());
//	  return elementName.isEnabled();
//  }	
//  public boolean checkElementIsSelected(WebElement elementName) throws Exception {
//	  ValidationHelper.validateElement(elementName, "checkElementIsSelected");
//	  System.out.println("The ElementIsSelected is"+elementName.isSelected());
//	  return elementName.isSelected();
//  }	
//	public String fetchElementTagName(WebElement elementName) throws Exception {
//		ValidationHelper.validateElement(elementName, "fetchElementTagName");
//		System.out.println("The ElementTagName is "+elementName.getTagName());
//		return elementName.getTagName();
//	}
//	public String fetchElementAttributeValue(WebElement elementName,String attributeName) throws Exception {
//		ValidationHelper.validateElement(elementName, "fetchElementTagName");
//		ValidationHelper.validateString(attributeName, "fetchElementAttributeValue");
//		System.out.println("The ElementAttributeValue is "+elementName.getAttribute(attributeName));
//		return elementName.getAttribute(attributeName);
//	}
//	
//	public String fetchElementCssValue(WebElement elementName,String elementKey) throws Exception {
//		ValidationHelper.validateElement(elementName, "fetchElementCssValue");
//		ValidationHelper.validateString(elementKey, "fetchElementCssValue");
//		System.out.println("The ElementCssValue is "+elementName.getCssValue(elementKey));
//		return elementName.getCssValue(elementKey);
//	}
//  
//	
//	
//	
//	
	
	
//  public int fetchElementTagName(WebElement elementName) throws Exception {
//	  ValidationHelper.validateElement(elementName, "fetchElementTagName");
//	  ValidationHelper.validateString(attributeName, "fetchElementAttributeValue");
//	  System.out.println("The ElementYaxis is"+elementName.getLocation().getY());
//	  return elementName.getLocation().getY();
//  }	
//  
  
  
  
  

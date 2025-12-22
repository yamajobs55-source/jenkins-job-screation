package com.qa.orangehrm.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.orangehrm.Validation.ValidationHelper;
import com.qa.orangehrm.exception.ElementExceptions;

public class JavaScriptUtilities extends BaseUtility
{
	
	private JavascriptExecutor jse;
	 public JavaScriptUtilities(WebDriver driver) {
		 super(driver);
		 jse = (JavascriptExecutor)driver;
	 }
	 
	 //pass input
	 public void enterInputJSE(String input,WebElement element) throws Exception {
		 ValidationHelper.validateElement(element, "enterInputJSE");
		 jse.executeScript("arguments[0].value='"+input+"'",element);
	 }
	 
	 //clearInput
	 public void clearInputJSE(WebElement element) throws Exception {
		 ValidationHelper.validateElement(element, "clearInputJSE");
		 jse.executeScript("arguments[0].clear();",element);
	 }
	 
	 //scroll to element
	 public void scrollToElementJSE(WebElement element) throws Exception{
		 ValidationHelper.validateElement(element, "scrollToElementJSE");
		 jse.executeScript("arguments[0].scrollIntoView();",element);
	 }
	 
	 //scroll Y
	 public void scrollYJSE(int x, int y) {
		 if(x>0 && y<0) {
			 throw new ElementExceptions("===[JavaScriptUtilities] -x is greater than 0 and y is lesser than 0===");
		 }
		 jse.executeScript("window.scrollBy("+x+", "+y+")");
	 }
	 
	 //scroll x
	 public void scrollXJSE(int x, int y) {
		 if(x<0 && y==0) {
			 throw new ElementExceptions("===[JavaScriptUtilities] -x is lesser than 0 and y is greater than 0===");
		 }
		 jse.executeScript("window.scrollBy("+x+", "+y+")");
	 }
	 
	 
	 //scroll to bottom
	 public void scrolltoBottomPageJSE() {
		
		 jse.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	 }
	 
	 //SCROLL TO TOP
	 public void scrolltoTOPPageJSE() {	
		 jse.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
	 }

	 //ZOOM THE PAGE
	 public void zoomPageJSE(int zoomSize) {	
		 jse.executeScript("document.body.style.zoom='"+zoomSize+"'");
	 } 
	 
	 //highlight
	 public void markElementJSE(WebElement element) throws Exception{
		 ValidationHelper.validateElement(element, "markElementJSE");
		 jse.executeScript("arguments[0].style.border='3px solid red'",element);
	 }
}

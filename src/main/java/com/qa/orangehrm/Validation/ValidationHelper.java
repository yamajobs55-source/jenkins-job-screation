package com.qa.orangehrm.Validation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.qa.orangehrm.exception.ElementExceptions;

public class ValidationHelper {

	public static void validateLocator(By locatorName, String methodname) {
		if (locatorName == null) {
		throw new ElementExceptions("==[ValidationHelper]-- locator cannot be null==\n"
		+ "The entered locator name is :" + locatorName);
		}
		if (methodname == null) {
		throw new ElementExceptions("==[ValidationHelper]-- methodName cannot be null==\n"
		+ "The entered locator name is :" + methodname);

		}
		}

		public static void validateElement(WebElement elementname, String methodname) throws Exception {
		if (elementname == null) {
		throw new Exception(
		"==[ValidationHelper]-- element name cannot be null==\n " + "The entered name is :" + elementname);

		}
		if (methodname == null) {
		throw new Exception("==[ValidationHelper]-- methodName cannot be null==\n" + "The entered locator name is :"
		+ methodname);

		}
		}

		public static void validateString(String enteredinput, String methodname) {
		if (enteredinput == null) {
		throw new ElementExceptions("==[ValidationHelper]-- enteredinput cannot be null==\n "
		+ "The entered input is :" + enteredinput);

		}
		if (methodname == null) {
		throw new ElementExceptions("==[ValidationHelper]-- methodName cannot be null==\n"
		+ "The entered locator name is :" + methodname);

		}
		}

		}


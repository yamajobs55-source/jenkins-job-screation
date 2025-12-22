package com.qa.orangehrm.listeners;

import org.testng.ITestListener;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.internal.TestResult;

import com.qa.orangehrm.driverfactory.DriverManager;

import io.qameta.allure.Attachment;

public class AllureListenerUtility implements ITestListener {

	public String getTestMethodName(ITestContext result) {
		return ((TestResult) result).getMethod().getConstructorOrMethod().getName();
	}
	@Attachment(value ="page screenshot",type ="image/png")
	public byte[] getScreenshotBytes(WebDriver driver) {
		TakesScreenshot ts = (TakesScreenshot)driver;
		return ts.getScreenshotAs(OutputType.BYTES);
	}
	@Attachment(value ="{0}",type ="text/plain")
	public String getTextLog(String msg) {
		return msg;
	}
	@Attachment(value ="{0}",type ="text/html")
	public String getHtmlLog(String msg) {
		return msg;
	}
	
	
	
	
	//before each testng.xml suite tag
	public void onStart(ITestContext context) {
		System.out.println("I am here before the suite execution : "+ context.getName());
	}
	//before each testng.xml suite tag
	public void onfinish(ITestContext context) {
		System.out.println("I am here after the suite execution : "+ context.getName());
	}
	//it will execute before the execution of each test method
		public void onTestStart(ITestContext result) {
			System.out.println("I am here after the suite execution : "+ result.getName());
		}
	//it will execute only if the execution of each test method status is pass
 		public void onTestSuccess(ITestContext result) {
		System.out.println("I am here after the suite execution : "+ result.getName());
				}
 	//it will execute only if the execution of each test method status is fail
 	  public void onTestFailure(ITestContext result) {
	  System.out.println("I am here after the suite execution : "+ result.getName());
	  if(DriverManager.getDriver() instanceof WebDriver) {
		  System.out.println("Screenshot captured for failure test method that is :" +getTestMethodName(result));
	  }
	  getTextLog(getTestMethodName(result)+"Failed and screenshot captured");
 	  }
	//it will execute only if the execution of each test method status is skipped
	 public void onTestSkipped(ITestContext result) {
	 System.out.println("I am here after the suite execution : "+ result.getName());
	 }					


}

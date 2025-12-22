package com.qa.orangehrm.driverfactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.qa.orangehrm.apperromgg.ApplicationErrorMsg;
import com.qa.orangehrm.constantvalues.ApplicationConstants;
import com.qa.orangehrm.exception.ElementExceptions;
import com.qa.orangehrm.exception.FrameworkExceptions;

public class DriverManager {
	
	private BrowserOptions bopts;
	private Properties prop;
	
	private static final Logger log=LogManager.getLogger(DriverManager.class);//this class i am absent
  //private WebDriver driver;
	public static ThreadLocal<WebDriver> ltDriver=new ThreadLocal<WebDriver>();

	public WebDriver browserInit(String browserName) 
	{
		log.info("From class [Drivermanager] & method [browserInit] The initialized browser is"+browserName);
		switch(browserName.toLowerCase().trim()){
		case"chrome":
//			driver = new ChromeDriver();
			ltDriver.set(new ChromeDriver(bopts.getChromeOptions()));
		break;
		case"firefox":
//			driver = new FirefoxDriver();
			ltDriver.set(new FirefoxDriver(bopts.getFirefoxOptions()));
		break;
		case"edge":
//			driver = new EdgeDriver();
			ltDriver.set(new EdgeDriver(bopts.getEdgeOptions()));
			
		break;
		case"ie":
	//		driver = new InternetExplorerDriver();
			ltDriver.set(new InternetExplorerDriver(bopts.getIoOptions()));
        break;
		case"safari":
//			driver = new SafariDriver();
 		ltDriver.set(new SafariDriver());

		default:System.out.println(ApplicationErrorMsg.INVALID_BROWSER_MSG);

		throw new FrameworkExceptions("===Invalid Browsername===");
        
		
	}
//		return driver;
		return getDriver();
	}
	public static WebDriver getDriver() {
		return ltDriver.get();
	}
	

public Properties initpropert() throws IOException{
	try {
FileInputStream fis=new FileInputStream(ApplicationConstants.PROPERTYFILE);
prop = new Properties();
prop.load(fis);
bopts = new BrowserOptions(prop);
	}
	catch(Exception e) {
		throw new ElementExceptions("== [DriverManager]== - Property FIle Not found");
		
	}
 return prop;
}

public static File captureScreenshotFile() {
	
	log.info("From class [Drivermanager] & method [captureScreenshotFile] capture the screenshot");
	TakesScreenshot ts=(TakesScreenshot)getDriver();
	return ts.getScreenshotAs(OutputType.FILE);
}

}


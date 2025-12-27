package com.qa.orangehrm.driverfactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
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
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

//import com.qa.orangehrm.appconstants.I_ApplicationConstantValues;
import com.qa.orangehrm.apperromgg.ApplicationErrorMsg;
import com.qa.orangehrm.constantvalues.ApplicationConstants;
//import com.qa.orangehrm.diverfactory.BrowserOptions;
import com.qa.orangehrm.exception.FrameworkExceptions;

public class DriverManager {
	
	private BrowserOptions bopts;
	private Properties prop;
	
	private static final Logger log=LogManager.getLogger(DriverManager.class);//this class i am absent
  //private WebDriver driver;
	public static ThreadLocal<WebDriver> ltDriver=new ThreadLocal<WebDriver>();

	public WebDriver browserInit(String browserName) 
	{
		boolean remoteExecution = Boolean.parseBoolean(prop.getProperty("remote"));
		log.info("From class [Drivermanager] & method [browserInit] The initialized browser is"+browserName);
		switch(browserName.toLowerCase().trim()){
		case"chrome":
		//	driver = new ChromeDriver();
			if(remoteExecution) {
				init_remoteDriver("chrome");
			}else {
				ltDriver.set(new ChromeDriver(bopts.getChromeOptions()));
			}	
		break;
		case"firefox":
//			driver = new FirefoxDriver();
			if(remoteExecution) {
				init_remoteDriver("firefox");
			}else {
			ltDriver.set(new FirefoxDriver(bopts.getFirefoxOptions()));
			}
		break;
		case"edge":
//			driver = new EdgeDriver();
			if(remoteExecution) {
				init_remoteDriver("edge");
			}else {
			ltDriver.set(new EdgeDriver(bopts.getEdgeOptions()));
			}
		break;
		case"ie":
	//		driver = new InternetExplorerDriver();
			if(remoteExecution) {
				init_remoteDriver("ie");
			}else {
			ltDriver.set(new InternetExplorerDriver(bopts.getIoOptions()));
			}
        break;
		case"safari":
//			driver = new SafariDriver();
			if(remoteExecution) {
				init_remoteDriver("safari");
			}else {
 		ltDriver.set(new SafariDriver());
			}

		default:System.out.println(ApplicationErrorMsg.INVALID_BROWSER_MSG);

		throw new FrameworkExceptions("===Invalid Browsername===");
        
		
	}
//		return driver;
		return getDriver();
	}
	public static WebDriver getDriver() {
		return ltDriver.get();
	}

	public Properties initProperty() {
		try {
			FileInputStream fis = new FileInputStream(ApplicationConstants.PROPERTYFILE);
			prop = new Properties();
			prop.load(fis);
			bopts = new BrowserOptions(prop);
			log.info("From class [DriverManager] & method [initProperty] The porperty file  has been initialized with proper location");
			}
		catch (Exception e) {
			log.info("From class [DriverManager] & method [initProperty] The porperty file  is not initialized");
			throw new FrameworkExceptions("===[DriverManager] - Could not initiate the property file / incorrect file path===");
		}
		log.info("From class [DriverManager] & method [initProperty] The porperty file  is initialized and returned");
		return prop;		
	}
	
	
	private void init_remoteDriver(String browsername ) {
		try {
			switch (browsername) {
			case "chrome" :ltDriver.set(new RemoteWebDriver(new URL(prop.getProperty("huburl")),bopts.getChromeOptions()));
			break;
			case "firefox" :ltDriver.set(new RemoteWebDriver(new URL(prop.getProperty("huburl")),bopts.getFirefoxOptions()));
			break;
			case "edge" :ltDriver.set(new RemoteWebDriver(new URL(prop.getProperty("huburl")),bopts.getEdgeOptions()));
			break;
			default:log.error("Please supply the browser name for selenium grid");
			break;
			}
		}
		catch(Exception e) {
			
		}
		
	}
	

//public Properties initpropert() throws IOException{
//	prop = new Properties();
//	FileInputStream fis = null;
//	String envName = System.getProperty("env").trim().toLowerCase();
//    log.info("The envirom=nment name is : " + envName);
//	try {
//		if (envName == null) {
//		log.warn("The envirom=nment name is : " + envName);
//       fis = new FileInputStream("./src/test/resources/ConfigurationData/ConfigData.qa.properties");
//       }
//	else {
//		switch (envName) {
//		 case "qa":fis = new FileInputStream("./src/test/resources/ConfigurtionData/ConfigData.qa.properties");
//				break;
//			case "dev":fis = new FileInputStream("./src/test/resources/ConfigurtionData/ConfigData.Dev.properties");
//				break;
//			case "staging":fis = new FileInputStream("./src/test/resources/ConfigurtionData/ConfigData.staging.properties");
//				break;
//			default:
//                 log.warn("The specified environment name is not valid");
//				throw new FrameworkExceptions("===Invalid environment");
//			}
//		}
//	} catch (Exception e) {
//	   e.getStackTrace();
//}
//
//	try {
//		prop.load(fis);
//		bopts = new BrowserOptions(prop);
//	} catch (IOException e) {
//		e.printStackTrace();
//	}
// return prop;
//}

public static File captureScreenshotFile() {
	
	log.info("From class [Drivermanager] & method [captureScreenshotFile] capture the screenshot");
	TakesScreenshot ts=(TakesScreenshot)getDriver();
	return ts.getScreenshotAs(OutputType.FILE);
}

//public Properties initProperty(){
//
//	prop = new Properties();
//
//	FileInputStream fis = null;
//
//	String envName=System.getProperty("env").trim().toLowerCase();
//
//	log.info("The environment name is:"+envName);
//
//	try {
//
//		if(envName==null) {
//
//			log.warn("the environment name is null :"+envName);
//
//			fis = new FileInputStream("./src/test/resources/ConfigurationData/ConfigData.qa.properties");
//
//		}
//
//		else {
//
//			switch(envName) {
//
//			case "qa":fis =new FileInputStream("./src/test/resources/ConfigurationData/ConfigData.qa.properties");
//
//			break;
//
//			case "dev":fis =new FileInputStream("./src/test/resources/ConfigurationData/ConfigData.dev.properties");
//
//			break;
//
//			case "staging":fis =new FileInputStream("./src/test/resources/ConfigurationData/ConfigData.staging.properties");
//
//			break;
//
//			default:log.warn("The specified environment name is not valid");
//
//					throw new FrameworkExceptions("===Invalid environment");
//
//			}
//
//		}
//
//	}catch(Exception e) {
//
//		e.getStackTrace();
//
//	}
//
//	try {
//
//		prop.load(fis);
//
//		bopts= new BrowserOptions (prop);	
//
//	}catch(IOException e) {
//
//		e.printStackTrace();
//
//	}
//
//	return prop;
//
//}

}


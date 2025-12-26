package com.qa.orangehrm.basetest;

import java.io.IOException;

import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.chaintest.plugins.ChainTestListener;
import com.qa.orangehrm.driverfactory.DriverManager;
import com.qa.orangehrm.pagelayers.AdminPage;
import com.qa.orangehrm.pagelayers.DashboardPage;
import com.qa.orangehrm.pagelayers.LoginPage;
import com.qa.orangehrm.pagelayers.PIMPage;
import com.qa.orangehrm.utilities.BrowserUtility;

public class Basetest {

	private WebDriver driver;
	DriverManager dm;
	protected LoginPage lp;
	protected PIMPage pim;
	protected DashboardPage dbp;
	protected AdminPage ap;
	BrowserUtility bu;
	protected Properties pop;
	
	
	private static final Logger log = LogManager.getLogger(DriverManager.class);
	@Parameters("xmlBrowserName")
	@BeforeTest


	public void launchBrowser(String xmlBrowserName) throws IOException {
	 dm = new DriverManager();
	 pop = dm.initProperty();
	 if(xmlBrowserName!=null) {
	 pop.setProperty("browsername", xmlBrowserName);
  }
	 log.info("The initialzed browser is :" + pop.getProperty("browsername"));
	 driver = dm.browserInit(pop.getProperty("browsername"));
 	 bu = new BrowserUtility(driver);
 	 
	 bu.maximizeBrowser();
//   driver.manage().window().maximize();
	 
	 bu.globalWait(10);
//	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	 
	 bu.EnterUrl(pop.getProperty("testurl"));
//   driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	
	 System.out.println("Driver is in Basetest->"+driver);
	 lp = new LoginPage(driver);
	}
	@AfterMethod
	public void getScreenshotFile(ITestResult result) throws InterruptedException {
		Thread.sleep(500);
	if(!result.isSuccess()) {
		ChainTestListener.embed(DriverManager.captureScreenshotFile(),"image/png");
	}
	}
	
	
	
	
	@AfterTest
	public void terminateBrowser() throws InterruptedException {
	//	driver.quit();
		  if (driver != null) {
			 try { dbp.logoutApplication();
			 }
			 catch(Exception e) {
				 System.out.println("[BaseTest] -Already logged out from application");
			 }
			 
		Thread.sleep(2000);
		driver.quit();
	    }
	}	
}




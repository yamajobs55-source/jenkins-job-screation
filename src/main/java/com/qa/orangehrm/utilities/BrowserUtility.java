package com.qa.orangehrm.utilities;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;

import com.qa.orangehrm.Validation.ValidationHelper;
import com.qa.orangehrm.exception.ElementExceptions;
import com.qa.orangehrm.exception.FrameworkExceptions;

public class BrowserUtility extends BaseUtility {
//private WebDriver driver;

   public BrowserUtility(WebDriver driver) {
	   
	super(driver);
    }

   public void EnterUrl(String testUrl) {
    ValidationHelper.validateString(testUrl, "EnterUrl");
   if(testUrl==null) {
		throw new FrameworkExceptions("===[BrowserUtility] - The testurl cannot be null==");
	}
	if(!testUrl.startsWith("https")|testUrl.indexOf("https")!=0) {
		throw new FrameworkExceptions("===[BrowserUtility]-The TestUrl http/https is missing===");	
	}
	driver.get(testUrl);
   }
   
   public String fetchApplicationTitle() {
	return driver.getTitle();
   }
   
   public String fetchCurrentPageUrl() {
	return driver.getCurrentUrl();
   }
   
   public String fetchPagesource() {
    return driver.getPageSource();
   }
   
   public void closeCurrentTab() {
    driver.close();
   }
   
   public void terminateBrowser() {
    driver.quit();
   }
   
   public void maximizeBrowser() {
    driver.manage().window().maximize();
   }
   
   public void manimizeBrowser() {
    driver.manage().window().minimize();
   }
   
   public void fullScreeen() {
    driver.manage().window().fullscreen();
   }
   
   public void deleteBrowsercookis() {
    driver.manage().deleteAllCookies();
   }
   
   public void globalWait(int sec) {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
   }
 
   public WebElement locateElement(By locator) {
	ValidationHelper.validateLocator(locator, "locateElement");
	try {
	return driver.findElement(locator);
   }catch(NoSuchElementException e) {
		throw new ElementExceptions("===[BrowserUtility] - The specified "+locator+" is not matching with any element in webpage===");
        }
   } 
   
   public List<WebElement> locateElements(By locator) {
	ValidationHelper.validateLocator(locator, "locateElements");
	try {
		return driver.findElements(locator);
		}catch(NoSuchElementException e) {
			throw new ElementExceptions("===[BrowserUtility] - The specified "+locator+" is not matching with any elements in webpage===");
			
		}
   }
   public void navigaToPage(String testUrl) {
	
	if(testUrl==null) {
		throw new FrameworkExceptions("===[BrowserUtility] - The testurl cannot be null==");
   }

   if(!testUrl.startsWith("https")|(testUrl.indexOf("https")!=0)) {
	throw new FrameworkExceptions("===[BrowserUtility] - The testurl protocol http/https is missing==");
   }
	driver.navigate().to(testUrl);
   }
   
   public void navigatePrevoiusPage() {
	driver.navigate().back();
   }
   
   public void navigateForwardPage() {
	driver.navigate().forward();
   }
   
   public void refresThePage() {
	driver.navigate().refresh();
   }
   
   public String fetchparentTabAddress() {
	return driver.getWindowHandle();
   }
   
   public Set<String> fetchAllTabAddress() {
	return driver.getWindowHandles();
   }
   
   public Alert switchToAlert() {
	return driver.switchTo().alert();
   }
   
   public void switchToWindow(String windowAddress) {
	if(windowAddress==null) {
		throw new FrameworkExceptions("===[BrowserUtility] - The windowAddress cannot be null==");
    }
	driver.switchTo().window(windowAddress);
   }

   public Point FethchBrowserPosition()
   {
	return driver.manage().window().getPosition();
   }
   
   public int FethchBrowserXaxis()
   {
	return driver.manage().window().getPosition().getX();
   }
   
   public int FethchBrowserYaxis()
   {
	return driver.manage().window().getPosition().getY();
   }
   
   public Dimension fetchBrowserDiemension() {
	return driver.manage().window().getSize();
   }
   
   public int fetchBrowserWidth() {
	return driver.manage().window().getSize().getWidth();
   }
   
   public int fetchBrowserHeight() {
	return driver.manage().window().getSize().getHeight();
   }
   
   public void changeBrowserPosition(int x,int y) {
	Point p = new Point(x, y);
	driver.manage().window().setPosition(p);
   }
   
   public void changeBrowserDimension(int width,int height) {
	Dimension d = new Dimension(width, height);
	driver.manage().window().setSize(d);
   }
   
   public WebDriver SwitchtoFrame(int index) {
	return driver.switchTo().frame(index);
   }
   
   public WebDriver SwitchtoFrame(String name){
	return driver.switchTo().frame(name);
   }
   
   public WebDriver SwitchtoFrame(WebElement Addressofframe){
	return driver.switchTo().frame(Addressofframe);
   }
   
   public void openNewWindow() {
	   driver.switchTo().newWindow(WindowType.WINDOW);
   }
   
   public void openNewTab() {
	   driver.switchTo().newWindow(WindowType.TAB);
   }
   }













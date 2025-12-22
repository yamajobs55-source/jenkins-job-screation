package com.qa.orangehrm.utilities;


import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.orangehrm.Validation.ValidationHelper;
import com.qa.orangehrm.exception.ElementExceptions;
import com.qa.orangehrm.frameworkObjects.UtilityObjects;

public class Actionutility extends BaseUtility{

	public Actionutility(WebDriver driver) {
		super(driver);
	}
	 
	    public void doRightClick(WebElement element) throws Exception {
	    	ValidationHelper.validateElement(element, "doRightClick");
	    	try {
				UtilityObjects.actionsobject(driver).contextClick(element).perform();
			} catch (RuntimeException e) {
				throw new ElementExceptions("=== [ActionsUtilities] -doRightClick action is not performing on element "+element+"===");
			}
	    }
	    public void doRightClick() {
	    	try {
				UtilityObjects.actionsobject(driver).contextClick().perform();
			} catch (RuntimeException e) {
				throw new ElementExceptions("===ActionsUtilities] -doRightClick action is not performing on mouse location ===");
			}
	    }
	    public void doDoubleClick(WebElement element)  throws Exception{
	    	ValidationHelper.validateElement(element, "doDoubleClick");
	    	try {
			    UtilityObjects.actionsobject(driver).doubleClick(element).perform();
			} catch (RuntimeException e) {
				throw new ElementExceptions("=== [ActionsUtilities] -doDoubleClick action is not performing on element "+element+"===");
			}
	    }
	    public void doDoubleClick() {
	    	try {
			    UtilityObjects.actionsobject(driver).doubleClick().perform();
			} catch (RuntimeException e) {
				throw new ElementExceptions("=== [ActionsUtilities] -doDoubleClick action is not performing on mouse location  ===");
			}
	    }
	    public void doDragAndDrop(WebElement src,WebElement dest)  throws Exception{
	    	ValidationHelper.validateElement(src, "doDragAndDrop");
	    	ValidationHelper.validateElement(dest, "doDragAndDrop");
	    	try {
	    		UtilityObjects.actionsobject(driver).dragAndDrop(src, dest).perform();
			} catch (RuntimeException e) {
				throw new ElementExceptions("=== [ActionsUtilities] -doDragAndDrop action is not performing on element "+src+" "+dest+"===");
			}
	    }
	    public void doDragAndDropByAxis(WebElement element,int x,int y) throws Exception {
	    	ValidationHelper.validateElement(element, "doDragAndDrop");
	    	try {
	    		UtilityObjects.actionsobject(driver).dragAndDropBy(element, x, y).perform();
			} catch (RuntimeException e) {
				throw new ElementExceptions("=== [ActionsUtilities] -doDragAndDropByAxis action is not performing on element "+element+"===");
			}
	    }
	    public void mouseHoverAction(WebElement element) throws Exception {
	    	ValidationHelper.validateElement(element, "mouseHoverAction");
	    	try {
			    UtilityObjects.actionsobject(driver).moveToElement(element).perform();
			} catch (RuntimeException e) {
				throw new ElementExceptions("=== [ActionsUtilities] -mouseHoverAction  is not performing on element "+element+"===");
			}
	    }
	    public void mouseHoverActionOnAxis(WebElement element,int x, int y) throws Exception {
	    	ValidationHelper.validateElement(element, "mouseHoverAction");
	    	try {
			    UtilityObjects.actionsobject(driver).moveToElement(element, x, y).perform();
			} catch (RuntimeException e) {
				throw new ElementExceptions("=== [ActionsUtilities] -mouseHoverAction  is not performing on element "+element+"===");
			}
	    }
	    public void clickHoldRelease(WebElement element,int time) throws Exception {
	    	ValidationHelper.validateElement(element, "clickHoldRelease");
	    	try {
	    		  UtilityObjects.actionsobject(driver).clickAndHold(element).pause(Duration.ofSeconds(time)).release(element).perform();
			} catch (RuntimeException e) {
				throw new ElementExceptions("=== [ActionsUtilities] -clickHoldRelease  is not performing on element "+element+"===");
			}
	    }
	    public void scrollToElement(WebElement element) throws Exception {
	    	ValidationHelper.validateElement(element, "scrollToelement");
	    	try {
	    		UtilityObjects.actionsobject(driver).scrollToElement(element).perform();
			} catch (RuntimeException e) {
				throw new ElementExceptions("===[ActionsUtility] - scrollToElement failed on element " +element+" "+e+ "===");
			}
	    }
	    public void scrollByAmount(int x,int y) {
	    	try {
	    		UtilityObjects.actionsobject(driver).scrollByAmount(x, y).perform();
			} catch (RuntimeException e) {
				throw new ElementExceptions("===[ActionsUtility] - scrollByAmount failed on axis" +x+","+y+" "+e+ "===");
			}
	    }
	    public void sendKeys(WebElement element, String value) throws Exception {
	       ValidationHelper.validateElement(element, "sendKeys");
	       ValidationHelper.validateString(value, "sendKeys");
	    try {
		   UtilityObjects.actionsobject(driver).sendKeys(element, value).perform();
	        } catch (RuntimeException e) {
		          throw new ElementExceptions("=== [ActionsUtilities] - sendKeys action  is not performing on element "+element+"===");
	                              }
	        }
	    public void clickAndHold(WebElement element) throws Exception {
	    	 ValidationHelper.validateElement(element, "clickAndHold");
	    	 try {
	    		   UtilityObjects.actionsobject(driver).clickAndHold(element);
			} catch (RuntimeException e) {
			       throw new ElementExceptions("=== [ActionsUtilities] - clickAndHold action  is not performing on element "+element+"+"+e+"+===");	
			}	 
	    }
	    public void clickAndHold() {
	   	 try {
	   		   UtilityObjects.actionsobject(driver).clickAndHold();
			} catch (RuntimeException e) {
			       throw new ElementExceptions("=== [ActionsUtilities] - clickAndHold action  is not performing on element "+e+"===");	
			}	 
	   }
	    public void click(WebElement element) throws Exception {
	    	ValidationHelper.validateElement(element, "click");
	    	try {
	    		UtilityObjects.actionsobject(driver).click(element).perform();
			} catch (RuntimeException e) {
				  throw new ElementExceptions("=== [ActionsUtilities] - clickAndHold action  is not performing on element "+element+"===");
			}	
	    }
	    public void click() {
	    	try {
	    		UtilityObjects.actionsobject(driver).click().perform();
			} catch (RuntimeException e) {
				throw new ElementExceptions("=== [ActionsUtilities] - click action  is not performing on element"+e+" ===");	
			}	
	    }
	    public void moveToElement(WebElement element) throws Exception {
			ValidationHelper.validateElement(element, "moveToElement");
			try {
				UtilityObjects.actionsobject(driver).moveToElement(element).perform();	
			} catch (RuntimeException e) {
				throw new ElementExceptions("===[ActionsUtility] - moveToElement failed on offSet " +element+" " +e+ "===");
			}
		}
		
		public void moveToElement(WebElement element, int xOffset, int yOffset) throws Exception {
			ValidationHelper.validateElement(element, "moveToElement");
			try {
				UtilityObjects.actionsobject(driver).moveToElement(element,xOffset,yOffset).perform();	
			} catch (RuntimeException e) {
				throw new ElementExceptions("===[ActionsUtility] - moveToElement failed on offSet " +element+" " +e+ "===");
			}
		}
		//KeyBoard Actions
			public void sendKeys(CharSequence keys) {
				ValidationHelper.validateString(keys.toString(), "sendKeys");
				try {
					UtilityObjects.actionsobject(driver).sendKeys(keys).perform();	
				} catch (RuntimeException e) {
					throw new ElementExceptions("===[ActionsUtility] - sendKeys failed" +e+ "===");
				}
			}
			public void sendKeys(WebElement element,CharSequence keys) throws Exception {
				ValidationHelper.validateString(keys.toString(), "sendKeys");
				ValidationHelper.validateElement(element, "sendKeys");
				try {
					UtilityObjects.actionsobject(driver).sendKeys(element,keys).perform();	
				} catch (RuntimeException e) {
					throw new ElementExceptions("===[ActionsUtility] - sendKeys failed on element "+e+ "===");
				}
			}
			public void keyDown(CharSequence key) {
				ValidationHelper.validateString(key.toString(), "keyDown");
				try {
					UtilityObjects.actionsobject(driver).keyDown(key).perform();	
				} catch (RuntimeException e) {
					throw new ElementExceptions("===[ActionsUtility] - keyDown failed for key: "+key+" "+e+ "===");
				}
			}
			public void keyDown(WebElement element,CharSequence key) throws Exception {
				ValidationHelper.validateString(key.toString(), "keyDown");
				ValidationHelper.validateElement(element, "keyDown");
				try {
					UtilityObjects.actionsobject(driver).keyDown(element,key).perform();	
				} catch (RuntimeException e) {
					throw new ElementExceptions("===[ActionsUtility] - keyDown failed for key: "+key+" "+e+ "===");
				}
			}
			public void keyUp(CharSequence key) {
				ValidationHelper.validateString(key.toString(), "keyDown");
				try {
					UtilityObjects.actionsobject(driver).keyUp(key).perform();	
				} catch (RuntimeException e) {
					throw new ElementExceptions("===[ActionsUtility] - keyUp failed for key: "+key+" "+e+ "===");
				}
			}
			public void keyUp(WebElement element,CharSequence key) throws Exception {
				ValidationHelper.validateString(key.toString(), "keyDown");
				ValidationHelper.validateElement(element, "keyDown");
				try {
					UtilityObjects.actionsobject(driver).keyUp(element,key).perform();	
				} catch (RuntimeException e) {
					throw new ElementExceptions("===[ActionsUtility] - keyUp failed for key: "+key+" "+e+ "===");
				}
			}
			
//			Composite actions
			public void hoverAndClick(WebElement hoverElement,WebElement clickElement) throws Exception {
				ValidationHelper.validateElement(hoverElement, "keyDown");
				ValidationHelper.validateElement(clickElement, "keyDown");
				try {
					UtilityObjects.actionsobject(driver).moveToElement(hoverElement).click(clickElement).perform();
				} catch (RuntimeException e) {
					throw new ElementExceptions("===[ActionsUtility] - hoverAndClick failed "+e+"===");
				}
			}
			public void buildAndPerform() {
				try {
					UtilityObjects.actionsobject(driver).build().perform();;
				} catch (RuntimeException e) {
					throw new ElementExceptions("===[ActionsUtility] - buildAndPerform failed "+e+"===");
				}
			}
			public void pause(Duration time) {
				try {
					UtilityObjects.actionsobject(driver).pause(time).perform();;
				} catch (RuntimeException e) {
					throw new ElementExceptions("===[ActionsUtility] - pause failed "+e+"===");
				}
			}
}
	


//rightclick-contextclick(ele)
//doubleclick 
//draganddrop
//mousehover
//click,hold and realese
//scroll to element
//scroll x,y
//dragbyx,y
//movebyoffset






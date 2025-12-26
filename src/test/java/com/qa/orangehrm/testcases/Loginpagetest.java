package com.qa.orangehrm.testcases;



import org.testng.Assert;
import org.testng.Reporter;
//import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.chaintest.plugins.ChainTestListener;
import com.qa.orangehrm.basetest.Basetest;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("CRS=101")
@Feature("SRS-101:LoginFunctionality")
@Story("FS-101:TestofLogin")
//@Listeners(ChainTestListener.class)

public class Loginpagetest extends Basetest {
	@Owner("Test001")
	@Severity(SeverityLevel.MINOR)
	@Description("Verify-checkLoginPageHeading")
	@Test(priority = 1)
	public void checkLoginPageHeading() {
		
		boolean hedding = lp.verifyloginpageheadding();
		Assert.assertTrue(hedding);
	//	Assert.fail();
		Reporter.log("Verified checkLoginPageHeading");//TestNg report
		ChainTestListener.log("Verified checkLoginPageHeading");//chaintest report
	}
	@Owner("Test001")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Verify-checkLoginpageUrl")
    @Test(priority = 2)
	public void checkloginpageurl() {
		String loginPageUrl = lp.verifyloginpageurl();
		boolean res = loginPageUrl.contains("/auth/login");
		Assert.assertTrue(res);
		Reporter.log("checkloginpageurl is success");
	    ChainTestListener.log("checkloginpageurl is success");

	}
	@Owner("Test001")
	@Severity(SeverityLevel.NORMAL)
	@Description("Verify-checkLoginpageUrlTitle")
    @Test(priority = 3)
	public void checkLoginPageTitle() {
		String actualLoginPageTitle = lp.verfyloginPageTitle();
		Assert.assertEquals(actualLoginPageTitle, "OrangeHRM");
		Reporter.log("checkLoginPageTitle is success");
		ChainTestListener.log("checkLoginPageTitle is success");

	}
	@Owner("Test001")
	@Severity(SeverityLevel.NORMAL)
	@Description("Verify-forgpotpassword")  
    @Test(priority = 4)
	public void checkForgotPsw() {
		Assert.assertTrue(lp.verifyforgotpswexist()); 
		Reporter.log("checkForgotPsw is success");
		ChainTestListener.log("checkForgotPsw is success");

	}
	@Owner("Test001")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Verify-doLoginApp")
    @Test(priority = 5)
    public void dologin() throws Exception {
    	
    lp.ddoLogin(pop.getProperty("usn"), pop.getProperty("psw"));
 //   	lp.dologin("Admin", "admin123");
	Reporter.log("dologin is success");
	ChainTestListener.log("dologin is success");

    	
    }
	@Test
	public void checkLoginPageHeading1() {
		
		
		Reporter.log("Verified checkLoginPageHeading and validate");//TestNg report
		ChainTestListener.log("Verified checkLoginPageHeading");//chaintest report
}
}

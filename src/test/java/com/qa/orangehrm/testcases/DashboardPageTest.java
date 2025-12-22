package com.qa.orangehrm.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.chaintest.plugins.ChainTestListener;
import com.qa.orangehrm.basetest.Basetest;
import com.qa.orangehrm.pagelayers.DashboardPage;

@Listeners(ChainTestListener.class)

public class DashboardPageTest extends Basetest{
	DashboardPage dbp;
	
	@BeforeClass
	public void dashboardPageSetUp() throws Exception  {
		
	 dbp = lp.ddoLogin(pop.getProperty("usn"), pop.getProperty("psw"));
		
	}
	

	@Test(priority=1)
	public void verifyDashBoardPage() {
		String actualHeading = dbp.verifyDashboardPageHeading();
		Assert.assertEquals(actualHeading,"Dashboard");
	}
	@Test(priority=2)
	public void getCountOfMenuList() {
		int actualCount = dbp.verifyListCountOfMenuList();
		boolean res = (actualCount==12);
		Assert.assertTrue(res);
	}
	
	@Test(priority=3)
	public void selectMenu() {
		dbp.selctMenu("Admin");
		Assert.fail();
	}
	
	@Test(priority=4)
	public void doLogout() {
		dbp.logoutApplication();
		
	}
	
	
}


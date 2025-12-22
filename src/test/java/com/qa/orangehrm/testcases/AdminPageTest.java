package com.qa.orangehrm.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.chaintest.plugins.ChainTestListener;
import com.qa.orangehrm.basetest.Basetest;
import com.qa.orangehrm.pagelayers.AdminPage;

@Listeners(ChainTestListener.class)
public class AdminPageTest extends Basetest {
	@BeforeClass
	public void AdminPageSetup() throws Exception {
		dbp = lp.ddoLogin(pop.getProperty("usn"), pop.getProperty("psw"));
		//dbp = lp.ddoLogin("Admin", "admin123");
		 ap = (AdminPage) dbp.selctMenu("Admin");
		 
	}
	@Test
public void checkadminpagededding() {
	boolean res = ap.verifyadminPageHeading();
	System.out.println(res);
	}
	
	@Test
	public void checksearchbtn() {
		boolean searchforUser = ap.searchforUser("123");
		System.out.println(searchforUser);
		Assert.fail();
		}
	
}


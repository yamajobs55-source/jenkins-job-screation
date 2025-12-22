package com.qa.orangehrm.testcases;

import org.testng.annotations.BeforeMethod;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.orangehrm.basetest.Basetest;


public class DatadrivenAddEmpTest extends Basetest{
	
	@BeforeMethod
	public void setUp() {
		
	}
	@Test(dataProvider="mulipleUserData")
	public void getAddEmpPage(String fn,String mn,String ln) throws InterruptedException {
	
	}
   @DataProvider(name="mulipleUserData")
	public String[][] mulipleUserData() {
	 String[][] data = new String[3][3];
	 data[0][0]="1FN";
	 data[0][1]="1MN";
	 data[0][2]="1LN";
	 data[1][0]="2FN";
	 data[1][1]="2MN";
	 data[1][2]="2LN";
	 data[2][0]="3FN";
	 data[2][1]="3MN";
	 data[2][2]="3LN";
	 return data;
	}
	
}

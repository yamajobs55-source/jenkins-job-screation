package com.qa.orangehrm.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryLogic implements IRetryAnalyzer {

	private int count=0;
	static private final int maxtry = 3;
	
	public boolean retry(ITestResult result) {
		if(!result.isSuccess()) {
			if(count<maxtry) {
				count++;
				result.setStatus(ITestResult.FAILURE);
			return true;
		}
		else {
			result.setStatus(ITestResult.FAILURE);
		}
		}
		else {
			result.setStatus(ITestResult.SUCCESS);
		}
		return false;
	}

}

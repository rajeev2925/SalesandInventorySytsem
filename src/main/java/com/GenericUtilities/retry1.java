package com.GenericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class retry1 implements IRetryAnalyzer
{
	int count=0;
	int retry_limit=3;
	public boolean retry(ITestResult result) {
		if(count<retry_limit)
		{
		count++;
		return true;
		}
		return false;
	}

}

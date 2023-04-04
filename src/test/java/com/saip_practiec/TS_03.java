package com.saip_practiec;

import org.testng.annotations.Test;

public class TS_03 
{
	@Test(groups = "system")
	public void test_05()
	{
		System.out.println("script 5 system");
	}
	@Test(groups = "smoke")
	public void test_06()
	{
		System.out.println("script 6 smoke");
	}
}

package com.saip_practiec;

import org.testng.annotations.Test;



public class TS_02
{
	@Test(groups = "smoke")
	public void test_03()
	{
		System.out.println("script 3 smoke");
	}
	@Test(groups = "system")
	public void test_04()
	{
		System.out.println("script 4 system");
	}
}

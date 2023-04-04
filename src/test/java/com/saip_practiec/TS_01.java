package com.saip_practiec;

import org.testng.annotations.Test;

import com.GenericUtilities.BaseClass;

public class TS_01 
{
	@Test(groups = "smoke")
	public void test_01()
	{
		System.out.println("script 1 smoke");
	}
	@Test(groups = {"smoke","regresion"})
	public void test_02()
	{
		System.out.println("script 2 smoke and regresion");
	}
}

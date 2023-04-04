package com.saip_practiec;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.GenericUtilities.ExcellUtility;

public class dataprovidedbyexcel
{
	@Test(dataProvider = "data")
	public void read(String a,String b)
	{
		System.out.println(a +" "+b);
	}
	
     @DataProvider
	public Object[][] data() throws Throwable
	{
		ExcellUtility exl = new ExcellUtility();
		Object[][] setofdata = exl.readSetOfData("Sheet3");
		
		return setofdata;
	}
	
}

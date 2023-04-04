package com.saip_practiec;

import org.testng.annotations.Test;

public class read_data_using_dataprovider {
@Test(dataProviderClass = Datapro.class, dataProvider = "data")
public void exc(String a, String b)
{
	System.out.println(a+"  "+b);
}

}

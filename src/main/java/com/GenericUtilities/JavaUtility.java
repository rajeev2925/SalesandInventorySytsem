package com.GenericUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtility 
{

	public int random()
	{
		Random ran = new Random();
		//int randomnum =ran.nextInt(100,999);
		int randomnum=ran.nextInt(999);
		return randomnum;
	}
	public String getSystemDate()
	{
	Date date = new Date();
	String curdate = date.toString();
	return curdate;
	}
	public String formatSystemDateandtime()
	{
		SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
		Date dt = new Date();
		String getDateandTime = df.format(dt);
		getDateandTime.replace(":", "-");
		return getDateandTime;
		
	}
	public String SystemDate()
	{
		SimpleDateFormat df = new SimpleDateFormat("ddMMyyyy");
		Date dt = new Date();
		String getDateandTime = df.format(dt);
		getDateandTime.replace(":", "-");
		return getDateandTime;
		
	}
	public int Simrandom()
	{
		Random ran = new Random();
		int randomnum = ran.nextInt(8);
		return randomnum;
	}
	
}

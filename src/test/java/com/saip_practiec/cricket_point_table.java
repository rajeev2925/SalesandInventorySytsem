package com.saip_practiec;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;

public class cricket_point_table {

	public static void main(String[] args) {
		WebDriver driver = WebDriverManager.chromedriver().create();
		driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/test");
		//List<WebElement> pos = driver.findElements(By.xpath("//tr[@class='table-head']/../..//td[1]"));
		List<WebElement> team = driver.findElements(By.xpath("//tr[@class='table-head']/../..//td[2]"));
		//List<WebElement> matches = driver.findElements(By.xpath("//tr[@class='table-head']/../..//td[3]"));
	//	List<WebElement> points = driver.findElements(By.xpath("//tr[@class='table-head']/../..//td[4]"));
		//List<WebElement> rating = driver.findElements(By.xpath("//tr[@class='table-head']/../..//td[5]"));
		String tname="India";
		boolean flag=false;
		for(WebElement name:team)
		{	
		
			String val = name.getText();
			if(val.equals(tname))
			{
				System.out.println("present");
				flag=true;
			
				
			}
		}
			if(!flag)
			{
				System.out.println("not present");
			}
		}

		

	}



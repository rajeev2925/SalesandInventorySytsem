package com.saip_practiec;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class make_my_trip_02 {

	public static void main(String[] args)
	{
		//notification popup
				ChromeOptions option=new ChromeOptions();
				option.addArguments("--disabled-notifications");
				WebDriverManager.chromiumdriver().setup();
				WebDriver driver=new ChromeDriver(option);
				driver.manage().window().maximize();
				driver.get("https://www.makemytrip.com/");

				driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
				driver.findElement(By.xpath("//li[@data-cy='roundTrip']")).click();
				
				driver.findElement(By.xpath("//span[@class='ic_circularclose_grey']")).click();
				
				driver.findElement(By.xpath("//label[@for='fromCity']")).click();
				
				driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys("bangalore");
				
				driver.findElement(By.xpath("//p[.='Bengaluru, India']")).click();
				
				driver.findElement(By.xpath("//label[@for='toCity']")).click();
				
				driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys("delhi");
				
				driver.findElement(By.xpath("//p[.='New Delhi, India']")).click();
				
				driver.findElement(By.xpath("//div[@aria-label='Tue Mar 14 2023']")).click();
				
				String rday ="Thu";
				String rmonth="Jun";
				String rdate="15";
				String year="2023";
				String rtrdate=rday+" "+rmonth+" "+rdate+" "+year;
				for(;;)
				{
					try {
						driver.findElement(By.xpath("//div[@aria-label='"+rtrdate+"']")).click();
						break;
					}
					catch (Exception e) {
						
							driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
					}
				}
				driver.findElement(By.xpath("//label[@for='travellers']")).click();
				
				driver.findElement(By.xpath("//li[@data-cy='adults-5']")).click();
				
				driver.findElement(By.xpath("//button[.='APPLY']")).click();
				
				driver.findElement(By.xpath("//a[.='Search']")).click();

	}

}

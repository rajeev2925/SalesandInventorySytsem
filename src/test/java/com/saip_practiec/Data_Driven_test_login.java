package com.saip_practiec;

import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Data_Driven_test_login {

	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\datadriven.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet("Sheet1");
		String url = sheet.getRow(0).getCell(0).getStringCellValue();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		String title = "Demo Web Shop";
		int count=sheet.getLastRowNum();
		int count1=0;
		for(int i=1;i<=count;i++)
		{
			driver.findElement(By.xpath("//a[@href='/login']")).click();
				String mail = sheet.getRow(i).getCell(0).getStringCellValue();
				String pass=sheet.getRow(i).getCell(1).getStringCellValue();
				driver.findElement(By.xpath("//input[@name='Email']")).sendKeys(mail);
				driver.findElement(By.xpath("//input[@name='Password']")).sendKeys(pass);
				driver.findElement(By.xpath("//input[@value='Log in']")).click();
				String actual = driver.getTitle();
				if(title.equals(actual))
				{
					count1++;
					driver.findElement(By.xpath("//a[@href='/logout']")).click();
					
				}
			}
			
			System.out.println(count1+" valid test data present"); 
			
			driver.quit();
		}
		

	}



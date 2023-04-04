package com.saip_practiec;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RMGyantraDBcontest {

	public static void main(String[] args) throws Throwable
	{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\rmgyantra.properties");
        Properties pobj1 = new Properties();
         pobj1.load(fis);
         
         String URL = pobj1.getProperty("url");
        String un = pobj1.getProperty("username");
         String psw = pobj1.getProperty("password");
         
         WebDriverManager.chromedriver().create();
         ChromeDriver driver = new ChromeDriver();
         driver.get(URL);
         
	}

}

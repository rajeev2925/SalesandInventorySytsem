package com.saip_practiec;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class readdatafrompropertyfile {

	public static void main(String[] args) throws Throwable  {
	FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Commondata.properties");
        Properties pobj = new Properties();
        pobj.load(fis);
        String URL = pobj.getProperty("url");
        String UN= pobj.getProperty("username");
        String psw=pobj.getProperty("password");
       // System.out.println(URL+" "+UN+" "+psw);
        
        WebDriverManager.chromedriver().setup();
      WebDriver driver = new ChromeDriver();
      driver.manage().window().maximize();
      driver.get(URL);
      driver.findElement(By.name("user")).sendKeys(UN);
      driver.findElement(By.name("password")).sendKeys(psw);
      driver.findElement(By.name("btnlogin")).click();
     Alert wlcmpop = driver.switchTo().alert();
     wlcmpop.accept();
      
	}

}

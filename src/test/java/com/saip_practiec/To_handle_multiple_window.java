package com.saip_practiec;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class To_handle_multiple_window {

	public static void main(String[] args) throws InterruptedException {
	//	WebDriverManager.chromedriver().setup();
	//WebDriver driver=new ChromeDriver();
	//	WebDriver driver=WebDriverManager.firefoxdriver().create();
	//WebDriverManager.firefoxdriver().setup();
		//WebDriver driver=new FirefoxDriver();
		WebDriverManager.edgedriver().setup();
	WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://nxtgenaiacademy.com/multiplewindows/");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.name("123newmessagewindow321")).click();
		driver.findElement(By.name("newbrowserwindow123")).click();
		driver.findElement(By.name("145newbrowsertab234")).click();
		
		
		String expected="NxtGen A.I Academy – Automate Intelligently";
		Set<String> windows = driver.getWindowHandles();
		
		for(String winlist:windows)
		{
			Thread.sleep(2000);
			String curentwintitle = driver.switchTo().window(winlist).getTitle();
			if(curentwintitle.equals(expected))
			{
				driver.manage().window().maximize();
				break;
			}
			
		}
		
	}

}

package com.saip_practiec;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class space_jet_test {

	public static void main(String[] args) throws Throwable
	{
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--disable-notifications");
		WebDriverManager.chromiumdriver().setup();
		WebDriver driver=new ChromeDriver(option);
		driver.manage().window().maximize();
	
	driver.get("https://www.spicejet.com/");
       /* Robot rbt = new Robot();
        rbt.keyPress(KeyEvent.VK_TAB);
        rbt.keyRelease(KeyEvent.VK_TAB);
        rbt.keyPress(KeyEvent.VK_ENTER);
        rbt.keyRelease(KeyEvent.VK_ENTER); */
	
        driver.findElement(By.xpath("//div[.='From' and @dir='auto']")).click();
        driver.findElement(By.xpath("//div[.='From' and @dir='auto']/..//input")).sendKeys("Chen");
        Thread.sleep(1000);
	
        driver.findElement(By.xpath("//div[.='To' and @dir='auto']/..//input")).sendKeys("Bengal");
        
        driver.findElement(By.xpath("//div[@data-testid='undefined-month-March-2023']/..//DIV[.='22']")).click();
        
        driver.findElement(By.xpath("//div[.='1 Adult' and @dir='auto']")).click();
        for(int i=1;i<=3;i++)
        {
        driver.findElement(By.xpath("//div[@data-testid='Adult-testID-plus-one-cta']")).click();
        }
        
       // JavascriptExecutor js=(JavascriptExecutor) driver;
        WebElement done = driver.findElement(By.xpath("//div[@data-testid='home-page-travellers-done-cta']"));
        //js.executeScript("arguments[0].scrollIntoView(true);",done);
        done.click();
        


      driver.findElement(By.xpath("//div[.='Family & Friends' and @style='cursor: pointer;']")).click();
      Thread.sleep(2000);
      driver.findElement(By.xpath("//div[.='Currency']")).click();
      driver.findElement(By.xpath("//div[.='USD']")).click();
         
       Thread.sleep(2000);
      
        driver.findElement(By.xpath("//div[@data-testid='home-page-flight-cta']")).click();
      
	}

}

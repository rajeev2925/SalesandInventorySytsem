package Customer_module;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class create_customer {

	public static void main(String[] args) throws Throwable
	{
		
		
		  WebDriverManager.chromedriver().setup();
		  WebDriver driver=new ChromeDriver();
	      driver.manage().window().maximize();
	     
	      Random rnd = new Random();
			int r = rnd.nextInt(99);
			 
			 FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Commondata.properties");
			Properties pObj = new  Properties();
			pObj.load(fis);
			String URL = pObj.getProperty("url");
			String UN = pObj.getProperty("adminusername");
			String PSW = pObj.getProperty("adminpassword");
			 driver.get(URL);
		      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	      driver.findElement(By.name("user")).sendKeys(UN);
	      driver.findElement(By.name("password")).sendKeys(PSW);
	      driver.findElement(By.name("btnlogin")).click();
	     driver.switchTo().alert().accept();
	     
	     driver.findElement(By.
	    		 xpath("//a[@href='customer.php']")).click();
	     
	     driver.findElement(By.xpath("//a[@href='#' and @type='button']")).click();
	     String actual = null;
	     
	  LinkedHashMap<String, String> map = new  LinkedHashMap<String,String>();
	   FileInputStream fi = new FileInputStream(".\\src\\test\\resources\\simple.xlsx");
	   Workbook book = WorkbookFactory.create(fi);
	     Sheet sh = book.getSheet("Sheet1");
	     for(int i=0;i<=sh.getLastRowNum();i++)
	     {
	    	 String key = sh.getRow(i).getCell(0).getStringCellValue();
	    	 String value = sh.getRow(i).getCell(1).getStringCellValue();
	    	 map.put(key, value);
	    	 
	     }
	     for(Entry<String, String> data:map.entrySet())
	     {
	    	 if(data.getKey().equals("phonenumber"))
	    	 {
	    		 actual = data.getValue()+r;
	     driver.findElement(By.name(data.getKey())).sendKeys(actual);
	     
	    	 	}
	    	 else
	    	 {
	    		 driver.findElement(By.name(data.getKey())).sendKeys(data.getValue());
	    	 }
	     }
	     String  expected=actual+r;
driver.findElement(By.xpath("//form[@action='cust_transac.php?action=add']/button[@type='submit']")).click();
	     

	   driver.findElement(By.xpath("//input[@type='search']")).sendKeys(expected);
	   List<WebElement> elements = driver.findElements(By.xpath("//td[3]"));
 	   int count = elements.size();
 	   if(count>0)
 	   {
	      String ac = driver.findElement(By.xpath("//td[3]")).getText();
	


	      
	  if(expected.equals(ac))
	     {
	    	 System.out.println("customer added succesfully");
	     }
	     else
	     {
	    	 System.out.println("custmer not added");
	     }
 	   }
	     
	     
	     driver.findElement(By.xpath("//a[@id='userDropdown']")).click();
	     
	     driver.findElement(By.xpath("//a[@data-target='#logoutModal']")).click();
	     
	     driver.findElement(By.xpath("(//a[@href='logout.php'])[1]")).click();
	     
	}
	}


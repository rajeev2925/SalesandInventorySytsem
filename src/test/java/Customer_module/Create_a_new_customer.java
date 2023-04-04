package Customer_module;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.GenericUtilities.ExcellUtility;
import com.GenericUtilities.FileUtility;
import com.GenericUtilities.JavaUtility;
import com.GenericUtilities.WebdriverUtilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Create_a_new_customer {

	public static void main(String[] args) throws Throwable
	{
		FileUtility Flib = new FileUtility();
		WebdriverUtilities Wlib = new WebdriverUtilities();
		ExcellUtility Elib = new ExcellUtility();
		JavaUtility Jlib = new JavaUtility();
		String URL = Flib.readDatafronPropertyFile("url");
		String UN = Flib.readDatafronPropertyFile("adminusername");
		String PSW = Flib.readDatafronPropertyFile("adminpassword");
		
			WebDriverManager.chromedriver().setup();
			ChromeDriver driver = new ChromeDriver();
		
			Wlib.maximizewindow(driver);
		
		  driver.get(URL);
		  driver.findElement(By.name("user")).sendKeys(UN);
	      driver.findElement(By.name("password")).sendKeys(PSW);
	      driver.findElement(By.name("btnlogin")).click();
		
		Wlib.acceptalert(driver);
		   driver.findElement(By.
		    		 xpath("//a[@href='customer.php']")).click();
		   driver.findElement(By.xpath("//a[@href='#' and @type='button']")).click();
		   String expected = null;	    
	 LinkedHashMap<String, String> map = Elib.readMultipleData("Sheet1");
	
	for(Entry<String, String> maplist:map.entrySet())
	{
		if(maplist.getKey().equals("phonenumber"))
		{
			expected= maplist.getValue()+Jlib.random();
			driver.findElement(By.name(maplist.getKey())).sendKeys(expected);
			Thread.sleep(2000);
			
		}
		else
		{
			driver.findElement(By.name(maplist.getKey())).sendKeys(maplist.getValue());
		}
	}
	 
     
   
     driver.findElement(By.xpath("//form[@action='cust_transac.php?action=add']/button[@type='submit']")).click();
     	     
     	   driver.findElement(By.xpath("//input[@type='search']")).sendKeys(expected); 
     	   
     	  String actual=null;
     	   List<WebElement> elements = driver.findElements(By.xpath("//td[3]")); 	
		for(WebElement list:elements)
     	     actual=list.getText();      
     		  if(expected.equals(actual))
     		     {
     		    	 System.out.println("customer added succesfully");
     		     }
     		     else
     		     {
     		    	 System.out.println("custmer not added");
     		     }
     	   
     		     driver.findElement(By.xpath("//a[@id='userDropdown']")).click();
     		     
     		     driver.findElement(By.xpath("//a[@data-target='#logoutModal']")).click();
     		     Thread.sleep(2000);
     		     
     		    driver.findElement(By.xpath("(//h5[.='Ready to Leave?'])[1]/../..//a")).click();		    

	}

}
